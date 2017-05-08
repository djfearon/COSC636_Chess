/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui;

import chess.core.Board;
import chess.core.pieces.Piece;
import client.Client;
import communication.MoveMessage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 *
 * @author djfearon0
 */
public class GameGUI extends javax.swing.JFrame {

    private boolean myTurn = false;
    private boolean firstTurn = true;
    private int[] moveFrom;
    private int[] moveTo;
    private int timesClicked;
    private long myTime;
    private long opponentTime;

    private ActionListener buttons;
    private static Client client;
    private final Color darkCell = new Color(74, 165, 74);
    private final Color lightCell = new Color(212, 212, 198);
    private JButton[][] cells;
    private static String color;
    private Piece[][] pieces;
    private Board game;

    /**
     * Creates new form GameGUI
     *
     * @param c
     */
    public GameGUI(Client c) {
        initComponents();
        client = c;
        game = new Board();
        pieces = game.getBoard();
        color = null;
        timesClicked = 0;
        myTime = 0;
        opponentTime = 0;
        moveFrom = null;
        moveTo = null;
        cells = new JButton[8][8];
        jPanel1.setLayout(new GridLayout(8, 8));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        makeButtons();
        drawPieces();

        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(440, 440));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton1.setText("Submit Move");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel Move");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton3.setText("Need Help?");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Your Move Time:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("00:00:00");

        jLabel4.setText("Opponent's Move Time:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("00:00:00");
        jLabel5.setMaximumSize(new java.awt.Dimension(58, 17));
        jLabel5.setMinimumSize(new java.awt.Dimension(58, 17));
        jLabel5.setPreferredSize(new java.awt.Dimension(58, 17));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(4, 4, 4)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (moveFrom != null && moveTo != null) {
            Integer[] move = {moveFrom[0], moveFrom[1], moveTo[0], moveTo[1]};
            MoveMessage m = new MoveMessage("move", null);
            m.setMove(move);

            try {
                ObjectOutputStream output = new ObjectOutputStream(client.socket.getOutputStream());
                output.writeObject(m);
                output.flush();
            } catch (IOException ex) {
                Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            unHighlight();
            moveFrom = null;
            moveTo = null;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        moveFrom = null;
        moveTo = null;
        unHighlight();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        HelpGUI hg = new HelpGUI();
        hg.setVisible(true);
        hg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameGUI(client).setVisible(true);
            }
        });
    }

    private void drawPieces() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton b = cells[i][j];
                if (pieces[j][i] != null) {
                    b.setText(getPieceCode(pieces[j][i]));
                    if (pieces[j][i].getColor().equals("black")) {
                        b.setForeground(Color.BLACK);
                    } else {
                        b.setForeground(Color.WHITE);
                    }
                } else {
                    b.setText("");
                }
            }
        }
    }

    private void makeButtons() {
        int c = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton b = new JButton();
                if (c == 0) {
                    b.setBackground(lightCell);
                } else {
                    b.setBackground(darkCell);
                }
                jPanel1.add(b);
                b.setMargin(new Insets(0, 0, 0, 0));
                b.setFont(new Font("Dialog", Font.PLAIN, 40));
                b.addActionListener((ActionEvent ae) -> {
                    if (myTurn) {
                        if (timesClicked < 2) {
                            int[] click = getButton((JButton) ae.getSource());
                            if (moveFrom == null) {
                                moveFrom = click;
                                timesClicked++;
                            } else if (moveFrom != null && moveTo == null) {
                                moveTo = click;
                                timesClicked++;
                            }
                        }
                    }
                });
                cells[i][j] = b;
                c ^= 1;
            }
            c ^= 1;
        }
    }

    /**
     * Receive a new move from the server and update the board to show the move
     * to the client.
     *
     * @param m The move received from the server
     */
    public void updateBoard(MoveMessage m) {
        Integer[] move = m.getMove();
        if (m.getValid()) {
            pieces[move[3]][move[2]] = pieces[move[1]][move[0]];
            pieces[move[1]][move[0]] = null;
            if (m.getEnPassant()) {
                Integer[] target = m.getTarget();
                pieces[target[0]][target[1]] = null;
            }
            myTurn = !myTurn;
        } else {
            jTextField1.setForeground(Color.RED);
            jTextField1.setText("Invalid Move!");
        }
        drawPieces();
        repaint();
    }

    /**
     * Update which player's turn it is in the message box.
     *
     * @param m The message containing the new turn information
     */
    public void getTurn(MoveMessage m) {
        if (color == null) {
            setColor(m.getColor());
        }
        long time = m.getTime();
        if (myTurn) {
            if (!m.getValid()) {
                if (!firstTurn) {
                    jTextField1.setForeground(Color.RED);
                    jTextField1.setText("Invalid Move!");
                }
                firstTurn = false;
            } else {
                opponentTime += time;
                jLabel5.setText(parseTime(1));
                jTextField1.setForeground(Color.BLUE);
                jTextField1.setText("Your turn!");
            }
        } else {
            if (m.getValid()) {
                myTime += time;
                jLabel3.setText(parseTime(0));
                jTextField1.setForeground(Color.BLUE);
                jTextField1.setText("Opponent's turn!");
            }
        }
    }

    /**
     * Set the color of the player for piece control and present the color to
     * the player.
     *
     * @param c The color that the player is controlling
     */
    public void setColor(String c) {
        color = c;
        if (c.equals("white")) {
            myTurn = true;
            jTextField1.setForeground(Color.BLUE);
            jTextField1.setText("Your turn!");
        } else {
            firstTurn = false;
            jTextField1.setForeground(Color.BLUE);
            jTextField1.setText("Opponent's turn!");
        }
        jLabel1.setText("Piece Color: " + color.substring(0, 1).toUpperCase() + color.substring(1));
    }

    /**
     * Check if the color for the player is set
     *
     * @return Whether or not the color has been set
     */
    public boolean colorSet() {
        return color != null;
    }

    public void printEnd(MoveMessage m) {
        switch (m.getReason()) {
            case "checkmate":
                if (m.getColor().equals(color)) {
                    jTextField1.setForeground(Color.RED);
                    jTextField1.setText("Defeat!");
                } else {
                    jTextField1.setForeground(Color.BLUE);
                    jTextField1.setText("Victory!");
                }
                break;
            case "draw":
                jTextField1.setForeground(Color.RED);
                jTextField1.setText("Draw!");
                break;
        }
    }

    private int[] getButton(JButton b) {
        int[] click = new int[2];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (b.equals(cells[i][j])) {
                    click[0] = i;
                    click[1] = j;
                    b.setBorder(new LineBorder(Color.RED));
                }
            }
        }
        return click;
    }

    private int[] unHighlight() {
        int[] click = new int[2];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton b = cells[i][j];
                b.setBorder(UIManager.getBorder("Button.border"));
            }
        }
        timesClicked = 0;
        return click;
    }

    private String parseTime(int p) {
        String t = "";
        StringBuilder sb = new StringBuilder();
        switch (p) {
            case 0:
                String h = "" + (TimeUnit.HOURS.convert(myTime, TimeUnit.NANOSECONDS) % 24);
                h = ((h.length() == 1) ? ("0" + h) : h);
                sb.append(h);
                sb.append(":");
                String m = "" + (TimeUnit.MINUTES.convert(myTime, TimeUnit.NANOSECONDS) % 60);
                m = ((m.length() == 1) ? ("0" + m) : m);
                sb.append(m);
                sb.append(":");
                String s = "" + (TimeUnit.SECONDS.convert(myTime, TimeUnit.NANOSECONDS) % 60);
                s = ((s.length() == 1) ? ("0" + s) : s);
                sb.append(s);
                t = sb.toString();
                break;
            case 1:
                String h2 = "" + (TimeUnit.HOURS.convert(opponentTime, TimeUnit.NANOSECONDS) % 24);
                h2 = ((h2.length() == 1) ? ("0" + h2) : h2);
                sb.append(h2);
                sb.append(":");
                String m2 = "" + (TimeUnit.MINUTES.convert(opponentTime, TimeUnit.NANOSECONDS) % 60);
                m2 = ((m2.length() == 1) ? ("0" + m2) : m2);
                sb.append(m2);
                sb.append(":");
                String s2 = "" + (TimeUnit.SECONDS.convert(opponentTime, TimeUnit.NANOSECONDS) % 60);
                s2 = ((s2.length() == 1) ? ("0" + s2) : s2);
                sb.append(s2);
                t = sb.toString();
                break;
        }
        return t;
    }

    private String getPieceCode(Piece p) {
        String code = null;
        boolean c;

        if (p.getColor().equals("white")) {
            c = true;
        } else {
            c = false;
        }

        switch (p.getType()) {
            case "king":
                if (c) {
                    code = "\u2654";
                } else {
                    code = "\u265A";
                }
                break;
            case "queen":
                if (c) {
                    code = "\u2655";
                } else {
                    code = "\u265B";
                }
                break;
            case "rook":
                if (c) {
                    code = "\u2656";
                } else {
                    code = "\u265C";
                }
                break;
            case "bishop":
                if (c) {
                    code = "\u2657";
                } else {
                    code = "\u265D";
                }
                break;
            case "knight":
                if (c) {
                    code = "\u2658";
                } else {
                    code = "\u265E";
                }
                break;
            case "pawn":
                if (c) {
                    code = "\u2659";
                } else {
                    code = "\u265F";
                }
                break;

        }
        return code;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
