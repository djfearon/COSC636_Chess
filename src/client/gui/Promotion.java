/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui;

import chess.core.pieces.Pawn;
import chess.core.pieces.Piece;
import java.awt.Font;
import java.awt.Insets;

/**
 *
 * @author ragilmore0
 */
public class Promotion extends javax.swing.JFrame {

    private static Pawn piece;
    private int y;
    private int x;
    private String color;
    String returnType;

    /**
     * Creates new form Promotion
     */
    public Promotion(Pawn piece) {
        this.piece = piece;
        this.color = this.piece.getColor();
        this.y = this.piece.getYPos();
        this.x = this.piece.getXPos();
        this.setTitle("Promotion!");

        initComponents();
        setButtons(color);

    }

    private void setButtons(String color) {
        this.jButtonRookPromo.setFont(new Font("Code2000", Font.PLAIN, 24));
        this.jButtonBishopPromo.setFont(new Font("Code2000", Font.PLAIN, 24));
        this.jButtonKnightPromo.setFont(new Font("Code2000", Font.PLAIN, 24));
        this.jButtonQueenPromo.setFont(new Font("Code2000", Font.PLAIN, 24));

        if (color.equals("white")) {
            this.jButtonRookPromo.setText("\u2656");
            this.jButtonBishopPromo.setText("\u2657");
            this.jButtonKnightPromo.setText("\u2658");
            this.jButtonQueenPromo.setText("\u2655");

        } else {

            this.jButtonRookPromo.setText("\u265C");
            this.jButtonBishopPromo.setText("\u265D");
            this.jButtonKnightPromo.setText("\u265E");
            this.jButtonQueenPromo.setText("\u265B");
        }
        this.jButtonRookPromo.setMargin(new Insets(0, 0, 0, 0));
        this.jButtonBishopPromo.setMargin(new Insets(0, 0, 0, 0));
        this.jButtonKnightPromo.setMargin(new Insets(0, 0, 0, 0));
        this.jButtonQueenPromo.setMargin(new Insets(0, 0, 0, 0));

    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButtonRookPromo = new javax.swing.JButton();
        jButtonBishopPromo = new javax.swing.JButton();
        jButtonKnightPromo = new javax.swing.JButton();
        jButtonQueenPromo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Promotion");

        jButtonRookPromo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonRookPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRookPromoActionPerformed(evt);
            }
        });

        jButtonBishopPromo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonBishopPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBishopPromoActionPerformed(evt);
            }
        });

        jButtonKnightPromo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonKnightPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKnightPromoActionPerformed(evt);
            }
        });

        jButtonQueenPromo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonQueenPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQueenPromoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonRookPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBishopPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonKnightPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonQueenPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRookPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBishopPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonKnightPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonQueenPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBishopPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBishopPromoActionPerformed
        this.returnType = "bishop";
    }//GEN-LAST:event_jButtonBishopPromoActionPerformed

    private void jButtonKnightPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKnightPromoActionPerformed
        this.returnType = "knight";
    }//GEN-LAST:event_jButtonKnightPromoActionPerformed

    private void jButtonQueenPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQueenPromoActionPerformed
        this.returnType = "queen";
    }//GEN-LAST:event_jButtonQueenPromoActionPerformed

    private void jButtonRookPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRookPromoActionPerformed
        this.returnType = "rook";
    }//GEN-LAST:event_jButtonRookPromoActionPerformed

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
            java.util.logging.Logger.getLogger(Promotion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Promotion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Promotion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Promotion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        piece = new Pawn(1, 2, "black", "pawn");
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Promotion(piece).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonBishopPromo;
    private javax.swing.JButton jButtonKnightPromo;
    private javax.swing.JButton jButtonQueenPromo;
    private javax.swing.JButton jButtonRookPromo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
