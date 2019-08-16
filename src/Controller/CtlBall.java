/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Ball;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author nick_
 */
public class CtlBall extends javax.swing.JFrame {

    private Ball ball;
    private Image image = new ImageIcon(getClass().getResource("..\\Resourses\\ballOfSoccer.jpg")).getImage();

    public CtlBall() {
        ball = new Ball(30,30);

    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void moveRight(JComponent temp) {
        if (ball.getPosX() < temp.getWidth() - 30) {
            ball.setPosX(ball.getPosX() + 5);
        }

    }

    public void moveLeft() {
        if (ball.getPosX() > 0) {
            ball.setPosX(ball.getPosX() - 5);
        }

    }

    public void moveDown(JComponent temp) {
        if (ball.getPosY() < temp.getHeight() - 30) {
            ball.setPosY(ball.getPosY() + 5);
        }

    }

    public void moveUp() {
        if (ball.getPosY() >= 5) {
            ball.setPosY(ball.getPosY() - 5);
        }
    }

    public void drawBall(Graphics gui, Ball temp) {
        //gui.setColor(Color.yellow);
        //gui.fillOval(temp.getPosX(), temp.getPosY(), temp.getWidth(), temp.getHeight());
        gui.drawImage(image, temp.getPosX(), temp.getPosY(), this);
    }

}
