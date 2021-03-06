/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import chess.core.Board;
import chess.core.Move;
import chess.core.pieces.Piece;
import communication.MoveMessage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author frost
 */
public class GameConnection implements Runnable {

    private Server server;
    private Socket player1;
    private String p1Color;
    private ObjectOutputStream p1Out;
    private ObjectInputStream p1In;
    private Socket player2;
    private String p2Color;
    private ObjectOutputStream p2Out;
    private ObjectInputStream p2In;
    private Board g;
    private Random rand;
    private Socket[] players;

    /**
     * Create a new game thread for two players to play a round of
     * chess.&nbsp;Receive input from players and update the board
     * accordingly.&nbsp;Also update the boards of clients with new moves.
     *
     * @param s1 The socket of the first player
     * @param s2 The socket of the second player
     * @param server The server hosting the game
     */
    public GameConnection(Socket s1, Socket s2, Server server) {

        this.server = server;

        player1 = s1;
        player2 = s2;

        players = new Socket[]{player1, player2};

        try {
            player1.setSoTimeout(0);
            player2.setSoTimeout(0);
        } catch (SocketException ex) {
            Logger.getLogger(GameConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            p1Out = new ObjectOutputStream(player1.getOutputStream());
            p2Out = new ObjectOutputStream(player2.getOutputStream());

            p1Out.reset();
            p1Out.flush();

            p2Out.reset();
            p2Out.flush();
        } catch (IOException ex) {
            Logger.getLogger(GameConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        rand = new Random();
        g = new Board();

        MoveMessage p1M = new MoveMessage("board", null);
        MoveMessage p2M = new MoveMessage("board", null);

        int coinToss = rand.nextInt(2);
        if (coinToss == 1) {
            p1Color = "white";
            p2Color = "black";
        } else {
            p1Color = "black";
            p2Color = "white";
        }

        p1M.setColor(p1Color);
        p1M.isValid();
        p2M.setColor(p2Color);
        p2M.isValid();

        try {
            p1Out.writeUnshared(p1M);
            p1Out.flush();
        } catch (IOException ioe) {
            Logger.getLogger(GameConnection.class.getName()).log(Level.SEVERE, null, ioe);
        }

        try {
            p2Out.writeUnshared(p2M);
            p2Out.flush();
        } catch (IOException ioe) {
            Logger.getLogger(GameConnection.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }

    @Override
    public void run() {

        boolean checkMate = g.isCheckMate();
        boolean draw = g.isMandatoryDraw();
        boolean isOver = checkMate && draw;

        long startTime = System.nanoTime();
        do {

            Object[] moveCommand = null;
            try {
                moveCommand = processMoves();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GameConnection.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (moveCommand != null) {

                boolean isValid = false;
                Socket s = null;
                Integer[] move = null;
                Integer[] target = null;
                String color = null;
                String choice = null;
                Move m = null;

                if (!g.getPromotionInProgress()) {
                    s = (Socket) moveCommand[0];
                    move = (Integer[]) moveCommand[1];
                    m = new Move(move[1], move[0], move[3], move[2]);

                    isValid = g.move(m);
                } else {
                    s = (Socket) moveCommand[0];
                    target = (Integer[]) moveCommand[1];
                    choice = (String) moveCommand[2];
                    Piece p = g.getPiece(target[0], target[1]);

                    g.promotePawn(p, choice);

                    MoveMessage mm = new MoveMessage("board", null);
                    mm.isPromotion();
                    mm.isValid();
                    mm.setTarget(target);
                    mm.setChoice(choice);
                    if (s.equals(player1)) {
                        mm.setColor(p1Color);
                    } else {
                        mm.setColor(p2Color);
                    }
                    mm.setMove(new Integer[]{-1, -1});

                    try {
                        p1Out = new ObjectOutputStream(player1.getOutputStream());
                        p1Out.writeUnshared(mm);
                        p1Out.flush();
                    } catch (IOException ioe) {
                        Logger.getLogger(GameConnection.class.getName()).log(Level.SEVERE, null, ioe);
                    }
                    try {
                        p2Out = new ObjectOutputStream(player2.getOutputStream());
                        p2Out.writeUnshared(mm);
                        p2Out.flush();
                    } catch (IOException ioe) {
                        Logger.getLogger(GameConnection.class.getName()).log(Level.SEVERE, null, ioe);
                    }

                    continue;
                }

                if (!isValid) {
                    int p = findPlayer(s);
                    switch (p) {
                        case 1:
                            try {
                                MoveMessage mm = new MoveMessage("board", null);
                                mm.setMove(move);
                                p1Out = new ObjectOutputStream(player1.getOutputStream());
                                p1Out.writeUnshared(mm);
                                p1Out.flush();
                            } catch (IOException ioe) {
                                Logger.getLogger(GameConnection.class.getName()).log(Level.SEVERE, null, ioe);
                            }
                            break;
                        case 2:
                            try {
                                MoveMessage mm = new MoveMessage("board", null);
                                mm.setMove(move);
                                p2Out = new ObjectOutputStream(player2.getOutputStream());
                                p2Out.writeUnshared(mm);
                                p2Out.flush();
                            } catch (IOException ioe) {
                                Logger.getLogger(GameConnection.class.getName()).log(Level.SEVERE, null, ioe);
                            }
                            break;
                        default:
                            break;
                    }
                } else {
                    //Update players
                    long timeTaken = System.nanoTime() - startTime;
                    try {
                        MoveMessage mm = new MoveMessage("board", null);
                        mm.isValid();
                        if (g.getSuccessfulEnPassant()) {
                            mm.setEnPassant();
                            target = new Integer[]{move[3], move[0]};
                            mm.setTarget(target);
                        }

                        if (p1Color.equals("white") && g.isWhiteTurn()) {
                            if (g.getPromotionInProgress()) {
                                mm.isPromotion();
                            }
                            if (g.isInCheck()) {
                                mm.setInCheck();
                            }
                        } else if (p1Color.equals("black") && !g.isWhiteTurn()) {
                            if (g.getPromotionInProgress()) {
                                mm.isPromotion();
                            }
                            if (g.isInCheck()) {
                                mm.setInCheck();
                            }
                        }

                        mm.setTime(timeTaken);
                        mm.setMove(move);
                        p1Out = new ObjectOutputStream(player1.getOutputStream());
                        p1Out.writeUnshared(mm);
                        p1Out.flush();
                    } catch (IOException ioe) {
                        Logger.getLogger(GameConnection.class.getName()).log(Level.SEVERE, null, ioe);
                    }
                    try {
                        MoveMessage mm = new MoveMessage("board", null);
                        mm.isValid();
                        if (g.getSuccessfulEnPassant()) {
                            mm.setEnPassant();
                            target = new Integer[]{move[3], move[0]};
                            mm.setTarget(target);
                        }
                        if (p2Color.equals("white") && g.isWhiteTurn()) {
                            if (g.getPromotionInProgress()) {
                                mm.isPromotion();
                            }
                            if (g.isInCheck()) {
                                mm.setInCheck();
                            }
                        } else if (p2Color.equals("black") && !g.isWhiteTurn()) {
                            if (g.getPromotionInProgress()) {
                                mm.isPromotion();
                            }
                            if (g.isInCheck()) {
                                mm.setInCheck();
                            }
                        }
                        mm.setTime(timeTaken);
                        mm.setMove(move);
                        p2Out = new ObjectOutputStream(player2.getOutputStream());
                        p2Out.writeUnshared(mm);
                        p2Out.flush();
                    } catch (IOException ioe) {
                        Logger.getLogger(GameConnection.class.getName()).log(Level.SEVERE, null, ioe);
                    }
                    startTime = System.nanoTime();
                }
            }
            checkMate = g.isCheckMate();
            draw = g.isMandatoryDraw();
            isOver = checkMate || draw;
        } while (!isOver);

        MoveMessage end = new MoveMessage("end", null);

        if (g.isCheckMate()) {
            end.setColor(g.checkmatedKing());
            end.setReason("checkmate");
        } else if (g.isMandatoryDraw()) {
            end.setReason("draw");
        }

        try {
            p1Out = new ObjectOutputStream(player1.getOutputStream());
            p1Out.writeUnshared(end);
            p1Out.flush();
        } catch (IOException ioe) {
            Logger.getLogger(GameConnection.class.getName()).log(Level.SEVERE, null, ioe);
        }

        try {
            p2Out = new ObjectOutputStream(player2.getOutputStream());
            p2Out.writeUnshared(end);
            p2Out.flush();
        } catch (IOException ioe) {
            Logger.getLogger(GameConnection.class.getName()).log(Level.SEVERE, null, ioe);
        }

        returnSockets();
    }

    private void returnSockets() {
        server.returnSocket(player1);
        server.returnSocket(player2);
    }

    private Object[] processMoves() throws ClassNotFoundException {
        for (Socket s : players) {
            ObjectInputStream in = null;
            MoveMessage m = null;
            try {
                s.setSoTimeout(500);
            } catch (SocketException se) {
                System.err.println("Could not set timeout");
            }
            try {
                in = new ObjectInputStream(s.getInputStream());
                Object o = in.readObject();
                m = (MoveMessage) o;
            } catch (SocketTimeoutException ste) {
                //Socket read times out
            } catch (IOException ioe) {
                //Did not read an object
            }
            if (m != null) {
                if (!m.getPromotion()) {
                    return new Object[]{s, m.getMove()};
                } else {
                    return new Object[]{s, m.getTarget(), m.getChoice()};
                }
            }
        }
        return null;
    }

    private int findPlayer(Socket s) {
        for (int i = 0; i < players.length; i++) {
            if (s.equals(players[i])) {
                return i + 1;
            }
        }
        return -1;
    }
}
