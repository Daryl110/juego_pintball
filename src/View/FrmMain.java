package View;

import Controller.CtlBall;
import Controller.CtlBar;
import Controller.CtlTableScore;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FrmMain extends javax.swing.JFrame {

    public static ArrayList<CtlBall> threadsBallsControllers;
    private CtlBar barController;
    public static CtlTableScore ctl;

    public FrmMain() {
        initComponents();
        this.threadsBallsControllers = new ArrayList<>();
        this.drawBar();
        this.btnAddBall.setEnabled(false);
        this.btnRestartGame.setEnabled(false);
        ctl = new CtlTableScore();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        pnlDraw = new javax.swing.JPanel();
        btnAddBall = new javax.swing.JButton();
        btnStarGame = new javax.swing.JButton();
        btnRestartGame = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNumberBall = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblScore = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jTabbedPane1.setFocusable(false);
        jTabbedPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabbedPane1KeyPressed(evt);
            }
        });

        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });

        pnlDraw.setBackground(new java.awt.Color(255, 255, 255));
        pnlDraw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlDraw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pnlDrawKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlDrawLayout = new javax.swing.GroupLayout(pnlDraw);
        pnlDraw.setLayout(pnlDrawLayout);
        pnlDrawLayout.setHorizontalGroup(
            pnlDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );
        pnlDrawLayout.setVerticalGroup(
            pnlDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        btnAddBall.setText("Add Ball");
        btnAddBall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBallActionPerformed(evt);
            }
        });
        btnAddBall.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddBallKeyPressed(evt);
            }
        });

        btnStarGame.setText("Start Game");
        btnStarGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStarGameActionPerformed(evt);
            }
        });
        btnStarGame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnStarGameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnStarGameKeyTyped(evt);
            }
        });

        btnRestartGame.setText("Restart Game");
        btnRestartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartGameActionPerformed(evt);
            }
        });
        btnRestartGame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnRestartGameKeyPressed(evt);
            }
        });

        jLabel1.setText("Score:");
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel1KeyPressed(evt);
            }
        });

        lblScore.setText("00000");
        lblScore.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblScoreKeyPressed(evt);
            }
        });

        jLabel2.setText("N° Balls");
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel2KeyPressed(evt);
            }
        });

        lblNumberBall.setText("00000");
        lblNumberBall.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblNumberBallKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pnlDraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddBall)
                            .addComponent(jLabel1)
                            .addComponent(lblScore)
                            .addComponent(jLabel2)
                            .addComponent(lblNumberBall)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnStarGame)
                        .addGap(18, 18, 18)
                        .addComponent(btnRestartGame)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAddBall)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblScore)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lblNumberBall))
                    .addComponent(pnlDraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStarGame)
                    .addComponent(btnRestartGame))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Game", jPanel2);

        tblScore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "#", "NickName", "Score"
            }
        ));
        jScrollPane1.setViewportView(tblScore);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Scores", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddBallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBallActionPerformed
        CtlBall ballController = new CtlBall(this.pnlDraw, this.threadsBallsControllers.size(), this.barController);
        Thread threadBallController = new Thread(ballController, this.threadsBallsControllers.size() + "");
        this.threadsBallsControllers.add(ballController);
        threadBallController.start();
        this.lblNumberBall.setText("" + this.threadsBallsControllers.size());
    }//GEN-LAST:event_btnAddBallActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        moveBar(evt);
    }//GEN-LAST:event_formKeyPressed

    private void btnAddBallKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddBallKeyPressed
        moveBar(evt);
    }//GEN-LAST:event_btnAddBallKeyPressed

    private void btnRestartGameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRestartGameKeyPressed
        moveBar(evt);
    }//GEN-LAST:event_btnRestartGameKeyPressed

    private void btnStarGameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnStarGameKeyPressed
        moveBar(evt);
    }//GEN-LAST:event_btnStarGameKeyPressed

    private void pnlDrawKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnlDrawKeyPressed
        moveBar(evt);
    }//GEN-LAST:event_pnlDrawKeyPressed

    private void jTabbedPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabbedPane1KeyPressed
        moveBar(evt);
    }//GEN-LAST:event_jTabbedPane1KeyPressed

    private void btnStarGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStarGameActionPerformed
        startGame();
    }//GEN-LAST:event_btnStarGameActionPerformed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        moveBar(evt);
    }//GEN-LAST:event_jPanel2KeyPressed

    private void lblNumberBallKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblNumberBallKeyPressed
        moveBar(evt);
    }//GEN-LAST:event_lblNumberBallKeyPressed

    private void lblScoreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblScoreKeyPressed
        moveBar(evt);
    }//GEN-LAST:event_lblScoreKeyPressed

    private void jLabel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyPressed
        moveBar(evt);
    }//GEN-LAST:event_jLabel1KeyPressed

    private void jLabel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyPressed
        moveBar(evt);
    }//GEN-LAST:event_jLabel2KeyPressed

    private void btnStarGameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnStarGameKeyTyped
        moveBar(evt);
    }//GEN-LAST:event_btnStarGameKeyTyped

    private void btnRestartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartGameActionPerformed
        pnlDraw.removeAll();
        for (int i = 0; i < this.threadsBallsControllers.size(); i++) {
            this.threadsBallsControllers.get(i).dead = true;
            this.threadsBallsControllers.set(i, null);
        }
        this.threadsBallsControllers = new ArrayList<>();
        this.drawBar();
        lblScore.setText("0000");
        try {
            JOptionPane.showMessageDialog(this, "Esta cargando el nuevo juego");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        startGame();
    }//GEN-LAST:event_btnRestartGameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAddBall;
    private javax.swing.JButton btnRestartGame;
    public static javax.swing.JButton btnStarGame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JLabel lblNumberBall;
    public static javax.swing.JLabel lblScore;
    private javax.swing.JPanel pnlDraw;
    public static javax.swing.JTable tblScore;
    // End of variables declaration//GEN-END:variables

    private void drawBar() {
        this.barController = new CtlBar(this.pnlDraw);
        Thread threadBarController = new Thread(barController);
        threadBarController.start();
    }

    private void moveBar(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            this.barController.moveLeft();
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.barController.moveRight(this.pnlDraw);
        }
    }

    private void startGame() {
        for (int i = 0; i < 30; i++) {
            CtlBall ballController = new CtlBall(this.pnlDraw, this.threadsBallsControllers.size(), this.barController);
            Thread threadBallController = new Thread(ballController, this.threadsBallsControllers.size() + "");
            this.threadsBallsControllers.add(ballController);
            threadBallController.start();
            this.lblNumberBall.setText("" + this.threadsBallsControllers.size());
        }
        this.btnStarGame.setEnabled(false);
        this.btnRestartGame.setEnabled(true);
        this.btnAddBall.setEnabled(true);
        this.pnlDraw.requestFocus();
    }

}
