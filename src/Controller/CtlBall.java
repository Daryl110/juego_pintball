/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Ball;
import View.FrmMain;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author nick_
 */
public class CtlBall extends JComponent implements Runnable {

    private Ball ball;
    private final Image image;
    private final JComponent panel;
    public static int time;
    private final CtlBar barController;

    private enum Movements {
        top, down, topLeft, topRight, downLeft, downRight
    };
    private Movements ballState;

    public CtlBall(JComponent panel, int positionArray, CtlBar barController) {
        this.panel = panel;
        this.ball = new Ball(30, 30, this.calculatePosition("x"), this.calculatePosition("y"));
        this.setBounds(0, 0, this.panel.getWidth(), this.panel.getHeight());
        this.panel.add(this);
        this.image = new ImageIcon(getClass().getResource("..\\Resourses\\ballOfSoccer.jpg")).getImage();
        this.barController = barController;
        this.ballState = Movements.down;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.panel.repaint();
                Thread.sleep(10);
                this.move();
            } catch (InterruptedException ex) {
                Logger.getLogger(CtlBall.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        grphcs.setColor(Color.red);
        grphcs.fillOval(this.ball.getPosX(), this.ball.getPosY(), this.ball.getWidth(), this.ball.getHeight());
    }

    public Ball getBall() {
        return this.ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    int velocity = 5;

    public void move() {
        switch (ballState) {
            case down:
                if (this.ball.getPosY() < panel.getHeight() - 30) {
                    this.ball.setPosY(this.ball.getPosY() + this.velocity);
                    this.validateHitBar();
                } else {
                    this.deleteBall();
                }
                break;
            case top:
                if (this.ball.getPosY() >= 0) {
                    this.ball.setPosY(this.ball.getPosY() - this.velocity);
                } else {
                    this.ballState = Movements.down;
                }
                break;
            case topLeft:
                if (this.ball.getPosX() >= 0 && this.ball.getPosY() >= 0) {
                    this.ball.setPosX(this.ball.getPosX() - this.velocity);
                    this.ball.setPosY(this.ball.getPosY() - this.velocity);
                    if (this.ball.getPosY() <= 0 && this.ball.getPosX() >= 0) {
                        this.ballState = Movements.downLeft;
                    }
                    if (this.ball.getPosX() <= 0 && this.ball.getPosY() >= 0) {
                        this.ballState = Movements.topRight;
                    }
                }
                break;
            case downLeft:
                if (this.ball.getPosX() >= 0 && this.ball.getPosY() <= this.panel.getHeight() - 30) {
                    this.ball.setPosX(this.ball.getPosX() - this.velocity);
                    this.ball.setPosY(this.ball.getPosY() + this.velocity);
                    if (this.ball.getPosX() <= 0 && this.ball.getPosY() >= 0) {
                        this.ballState = Movements.downRight;
                    }
                    this.validateHitBar();
                    if (this.ball.getPosY() > panel.getHeight() - 30) {
                        this.deleteBall();
                    }
                }
                break;
            case downRight:
                if (this.ball.getPosY() <= this.panel.getHeight() - 30) {
                    this.ball.setPosX(this.ball.getPosX() + this.velocity);
                    this.ball.setPosY(this.ball.getPosY() + this.velocity);
                    if (this.ball.getPosX() >= this.panel.getWidth() - 30 && this.ball.getPosY() >= 0) {
                        this.ballState = Movements.downLeft;
                    }
                    this.validateHitBar();
                    if (this.ball.getPosY() > panel.getHeight() - 30) {
                        this.deleteBall();
                    }
                }
                break;
            case topRight:
                if (this.ball.getPosX() <= this.panel.getWidth() - 30 && this.ball.getPosY() >= 0) {
                    this.ball.setPosX(this.ball.getPosX() + this.velocity);
                    this.ball.setPosY(this.ball.getPosY() - this.velocity);
                    if (this.ball.getPosY() <= 0 && this.ball.getPosX() >= 0) {
                        this.ballState = Movements.downRight;
                    }
                    if (this.ball.getPosX() >= this.panel.getWidth() - 30 && this.ball.getPosY() >= 0) {
                        this.ballState = Movements.topLeft;
                    }
                }
                break;

        }
    }

    private void validateHitBar() {
        if ((this.ball.getPosX() >= this.barController.getBar().getPosX()
                && this.ball.getPosX() <= (this.barController.getBar().getPosX() + (this.barController.getBar().getWidth() / 3)))
                && (this.ball.getPosY() > this.barController.getBar().getPosY() - 30)) {
            this.ballState = Movements.topLeft;
        } else if ((this.ball.getPosX() >= (this.barController.getBar().getPosX() + (this.barController.getBar().getWidth() / 3))
                && this.ball.getPosX() <= (this.barController.getBar().getPosX() + ((this.barController.getBar().getWidth() / 3) * 2)))
                && (this.ball.getPosY() > this.barController.getBar().getPosY() - 30)) {
            this.ballState = Movements.top;
        } else if ((this.ball.getPosX() >= (this.barController.getBar().getPosX() + ((this.barController.getBar().getWidth() / 3) * 2))
                && this.ball.getPosX() <= (this.barController.getBar().getPosX() + this.barController.getBar().getWidth()))
                && (this.ball.getPosY() > this.barController.getBar().getPosY() - 30)) {
            this.ballState = Movements.topRight;
        }
    }

    private void deleteBall() {
        this.panel.remove(this);
        time -= 1;
        FrmMain.threadsBallsControllers.remove(this);
        FrmMain.lblNumberBall.setText("" + FrmMain.threadsBallsControllers.size());
    }

    private int calculatePosition(String orientation) {
        int number = 0;
        if (orientation.equalsIgnoreCase("x")) {
            number = ThreadLocalRandom.current().nextInt(0, this.panel.getWidth() - 30);
        }else{
            number = ThreadLocalRandom.current().nextInt(0, this.panel.getHeight() - 30);
        }
        return number;
    }
}
