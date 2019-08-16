/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Ball;
import java.awt.Graphics;
import java.awt.Image;
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

    public CtlBall(JComponent panel) {
        this.ball = new Ball(30,30);
        this.panel = panel;
        this.setBounds(0, 0, this.panel.getWidth(), this.panel.getHeight());
        this.panel.add(this);
        this.image = new ImageIcon(getClass().getResource("..\\Resourses\\ballOfSoccer.jpg")).getImage();
    }

    @Override
    public void run() {
        while (true) {
            this.panel.repaint();
        }
    }
    
    @Override
    public void paint(Graphics grphcs) {
        try {
            super.paint(grphcs);
            grphcs.drawImage(this.image, this.ball.getPosX(), this.ball.getPosY(), this);
            Thread.sleep(20);
            this.moveDown(panel);
        } catch (InterruptedException ex) {
            Logger.getLogger(CtlBall.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Ball getBall() {
        return this.ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void moveRight(JComponent temp) {
        if (this.ball.getPosX() < temp.getWidth() - 30) {
            this.ball.setPosX(ball.getPosX() + 50);
        }

    }

    public void moveLeft() {
        if (this.ball.getPosX() > 0) {
            this.ball.setPosX(this.ball.getPosX() - 5);
        }

    }

    public void moveDown(JComponent temp) {
        if (this.ball.getPosY() < temp.getHeight() - 30) {
            this.ball.setPosY(this.ball.getPosY() + 5);
        }

    }

    public void moveUp() {
        if (this.ball.getPosY() >= 5) {
            this.ball.setPosY(this.ball.getPosY() - 5);
        }
    }

}
