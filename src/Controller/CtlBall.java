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
    private final int positionArray;
    public static int time;
    private final CtlBar barController;

    public CtlBall(JComponent panel, int positionArray, CtlBar barController) {
        this.ball = new Ball(30, 30, (int) panel.getWidth()/2, 0);
        this.panel = panel;
        this.setBounds(0, 0, this.panel.getWidth(), this.panel.getHeight());
        this.panel.add(this);
        this.image = new ImageIcon(getClass().getResource("..\\Resourses\\ballOfSoccer.jpg")).getImage();
        this.positionArray = positionArray;
        this.barController = barController;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.panel.repaint();
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                System.out.println("[Error] : "+ex);
            }
        }
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        //grphcs.drawImage(this.image, this.ball.getPosX(), this.ball.getPosY(), this);
//        if (this.ball.getPosY() > panel.getHeight() - 30) {
//            this.panel.remove(this);
//            time -= 1;
//            FrmMain.threadsBallsControllers.remove(this);
//        }else{
            grphcs.setColor(Color.red);
            grphcs.fillOval(this.ball.getPosX(), this.ball.getPosY(), this.ball.getWidth(), this.ball.getHeight());
//        }
    }

    public Ball getBall() {
        return this.ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    private void moveRight(JComponent temp) {
        if (this.ball.getPosX() < temp.getWidth() - 30) {
            this.ball.setPosX(ball.getPosX() + 50);
        }

    }

    private void moveLeft() {
        if (this.ball.getPosX() > 0) {
            this.ball.setPosX(this.ball.getPosX() - 5);
        }

    }

    private void moveDown(JComponent temp) {
        if (this.ball.getPosY() == this.barController.getBar().getPosY() - 8) {
            this.moveUp();
        }
        else if (this.ball.getPosY() < temp.getHeight() - 30) {
            this.ball.setPosY(this.ball.getPosY() + 5);
        }
    }

    private void moveUp() {
        if (this.ball.getPosY() >= 20) {
            this.ball.setPosY(this.ball.getPosY() - 5);
        }
    }
    
    public void move(){
        
    }
}
