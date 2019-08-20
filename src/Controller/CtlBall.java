/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Ball;
import Model.Score;
import View.FrmMain;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author nick_
 */
public class CtlBall extends JComponent implements Runnable {

    private Ball ball;
    private final Image image;
    private final JComponent panel;
    private final CtlBar barController;
    private final int moveVelocity;
    public boolean dead;

    private enum Movements {
        top, down, topLeft, topRight, downLeft, downRight, missing
    };
    private Movements ballState;

    public CtlBall(JComponent panel, int positionArray, CtlBar barController) {
        this.panel = panel;
        this.dead = false;
        this.ball = new Ball(30, 30, this.calculatePosition("x"), this.calculatePosition("y"));
        this.setBounds(0, 0, this.panel.getWidth(), this.panel.getHeight());
        this.panel.add(this);
        this.image = new ImageIcon(getClass().getResource("..\\Resourses\\ballOfSoccer.jpg")).getImage();
        this.barController = barController;
        this.ballState = Movements.down;
        this.moveVelocity = 5;
    }

    @Override
    public void run() {
        while (!dead) {
            try {
                this.panel.repaint();
                Thread.sleep(FrmMain.threadsBallsControllers.size());
                this.move();
            } catch (Exception ex) {
                System.out.println("[Error] : " + ex);
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

    public void move() {
        switch (ballState) {//estado del movimiento de la bola
            case down:// Movimiento hacia abajo
                if (this.ball.getPosY() < panel.getHeight() - 30 && !(this.ballState == Movements.missing)) {//si la bola no ha tocado la parte de abajo
                    this.ball.setPosY(this.ball.getPosY() + this.moveVelocity);//la bola seguira bajando hasta que llegue a la parte de abajo
                    this.validateHitBar();//valida el toque con la barra
                } else {//si la bola no toco la barra y bajo todo
                    this.deleteBall();//elimina la bola tanto del arreglo como del panel
                    this.ballState = Movements.missing;
                }
                break;
            case top://Movimiento hacia arriba
                if (this.ball.getPosY() >= 0) {//si la bola no ha llegado a la parte de arriba
                    this.ball.setPosY(this.ball.getPosY() - this.moveVelocity);//la bola seguira subiendo hasta que toque la parte de arriba
                } else {//si la bola toca la parte de arriba
                    this.ballState = Movements.down;//se camia estado a movimiento para que rebote y se mueva hacia abajo
                }
                break;
            case topLeft://Movimiento hacia arribaIzquierda
                if ((this.ball.getPosX() >= 0 && this.ball.getPosY() >= 0) || (this.ball.getPosX() <= 0 && this.ball.getPosY() <= 0)) {//si la bola no ha llegado a la parte izquierda
                    this.ball.setPosX(this.ball.getPosX() - this.moveVelocity);//mover hacia el lado izquierdo
                    this.ball.setPosY(this.ball.getPosY() - this.moveVelocity);//mover hacia arriba
                    if (this.ball.getPosY() <= 0 && this.ball.getPosX() >= 0) {//si la bola toca la parte de arriba
                        this.ballState = Movements.downLeft;//se cambia el estado a movimiento para que se mueva hacia abajo izquierda
                    }
                    if (this.ball.getPosX() <= 0 && this.ball.getPosY() >= 0) {//si la bola toca la parte izquierda
                        this.ballState = Movements.topRight;//se cambia el estado a movimiento para que se mueva hacia arriba derecha
                    }
                }
                break;
            case downLeft://Movimiento hacia abajoIzquierda
                if (this.ball.getPosX() >= 0 && this.ball.getPosY() <= this.panel.getHeight() - 30) {//si la bola no ha tocado la parte de abajo y si no ha tocado la parte izquierda
                    this.ball.setPosX(this.ball.getPosX() - this.moveVelocity);//mover hacia la izquierda
                    this.ball.setPosY(this.ball.getPosY() + this.moveVelocity);//mover hacia abajo
                    if (this.ball.getPosX() <= 0 && this.ball.getPosY() >= 0) {//si la bola toca la parte izquierda
                        this.ballState = Movements.downRight;//Se cambia el estado a movimiento para que se mueva abajo derecha
                    }
                    this.validateHitBar();//valida el toque de la bola con la barra
                    if (this.ball.getPosY() > panel.getHeight() - 30) {//si la bola toca la parte de abajo
                        this.deleteBall();//se elimina la bola tanto del arreglo como del panel
                    }
                }
                break;
            case downRight://Movimiento hacia abajoDerecha
                if (this.ball.getPosY() <= this.panel.getHeight() - 30 && this.ball.getPosX() <= this.panel.getWidth() - 30) {//si la bola no ha tocado la parte de abajo ni la parte derecha
                    this.ball.setPosX(this.ball.getPosX() + this.moveVelocity);//mover hacia la derecha
                    this.ball.setPosY(this.ball.getPosY() + this.moveVelocity);//mover hacia abajo
                    if (this.ball.getPosX() >= this.panel.getWidth() - 30 && this.ball.getPosY() >= 0) {//si la bola toca la parte derecha
                        this.ballState = Movements.downLeft;//Se cambia el estado a movimiento para que se mueva abajo izquierda
                    }
                    this.validateHitBar();//Valida el toque de la bola con la barra
                    if (this.ball.getPosY() > panel.getHeight() - 30) {//si la bola toca la parte de abajo
                        this.deleteBall();//se elimina la bola tanto del arreglo como del panel
                    }
                }
                break;
            case topRight://Movimiento arribaDerecha
                if (this.ball.getPosX() <= this.panel.getWidth() - 30 && this.ball.getPosY() >= 0) {//si la bola no ha tocado la parte derecha y si la bola no ha tocado la parte de arriba
                    this.ball.setPosX(this.ball.getPosX() + this.moveVelocity);//mover a la derecha
                    this.ball.setPosY(this.ball.getPosY() - this.moveVelocity);//mover hacia arriba
                    if (this.ball.getPosY() <= 0 && this.ball.getPosX() >= 0) {//si la bola toca la parte de arriba
                        this.ballState = Movements.downRight;//Se cambia el estado a movimiento para que se mueva abajo derecha
                    }
                    if (this.ball.getPosX() >= this.panel.getWidth() - 30 && this.ball.getPosY() >= 0) {//si la bola toca la parte derecha
                        this.ballState = Movements.topLeft;//Se cambia el estado a movimiento para que se mueva arriba izquierda
                    }
                }
                else if (this.ball.getPosX() <= 0 && this.ball.getPosY() <= 0) {
                    this.ballState = Movements.downLeft;
                }
                break;

        }
    }

    private void validateHitBar() {
        if ((this.ball.getPosX() >= this.barController.getBar().getPosX()
                && this.ball.getPosX() <= (this.barController.getBar().getPosX() + (this.barController.getBar().getWidth() / 3)))
                && (this.ball.getPosY() > this.barController.getBar().getPosY() - 30)) {//si la bola esta en el rango de 1/3 barra (izquierda)
            this.ballState = Movements.topLeft;//se cambia el estado a movimiento para que se mueva arriba izquierda
            synActioScore(1);
        } else if ((this.ball.getPosX() >= (this.barController.getBar().getPosX() + (this.barController.getBar().getWidth() / 3))
                && this.ball.getPosX() <= (this.barController.getBar().getPosX() + ((this.barController.getBar().getWidth() / 3) * 2)))
                && (this.ball.getPosY() > this.barController.getBar().getPosY() - 30)) {//si la bola esta en el rango de 2/3 barra (centro)
            this.ballState = Movements.top;//se cambia el estado a movimiento para que se mueva arriba
            synActioScore(1);
        } else if ((this.ball.getPosX() >= (this.barController.getBar().getPosX() + ((this.barController.getBar().getWidth() / 3) * 2))
                && this.ball.getPosX() <= (this.barController.getBar().getPosX() + this.barController.getBar().getWidth()))
                && (this.ball.getPosY() > this.barController.getBar().getPosY() - 30)) {//si la bola esta en el rango de 3/3 barra (derecha)
            this.ballState = Movements.topRight;//se cambia el estado a movimiento para que se mueva arriba derecha
            synActioScore(1);
        }
    }

    private void deleteBall() {

        this.panel.remove(this);//elimina la bola del panel para no dibujarla mas
        FrmMain.threadsBallsControllers.remove(this);//remueve la bola del arreglo
        int numberBalls = FrmMain.threadsBallsControllers.size();
        FrmMain.lblNumberBall.setText("" + numberBalls);//pinta el numero actual de bolas en el arreglo      
        synchronized (this) {
            if (numberBalls == 0) {//Solo entrara aca si es la ultima bola
                JOptionPane.showMessageDialog(null, "Se ha acabado el juego");//Muestra en pantalla
                FrmMain.btnAddBall.setEnabled(false);
                FrmMain.btnStarGame.setEnabled(false);//>>Desabilida el boton de agregar y de iniciar juego
                String name = JOptionPane.showInputDialog("Ingrese el nombre");//>Pide el nombre del jugador
                if (name == null) {
                    name = "Jugador Anonimo";//Solo emtra en la condicion si en el modal le sa cancelar
                }
                int score = Integer.parseInt(FrmMain.lblScore.getText() + "");//Se solicita el valor del score
                FrmMain.ctl.listScore.add(new Score(name, score));//Se añade a la lista de score
                FrmMain.ctl.listScore();//Se actualiza

            }
        }
        synActioScore(2);//Borra puntos al score actual
        synchronized (this) {
            this.dead = true;
        }

    }

    private int calculatePosition(String orientation) {
        int number = 0;
        if (orientation.equalsIgnoreCase("x")) {
            number = ThreadLocalRandom.current().nextInt(0, this.panel.getWidth() - 30);//numeros aleatorios para el ancho
        } else {
            number = ThreadLocalRandom.current().nextInt(0, this.panel.getHeight() - 30);//numeros aleatotios para el alto
        }
        return number;
    }

    private synchronized void synActioScore(int action) {
        int score = Integer.parseInt(FrmMain.lblScore.getText() + "");//Captura el score actual
        switch (action) {
            case 1:
                score += 1; //le suma uno a la cantidad
                break;
            case 2:
                score -= 5;
                if (score < 0) {//Valida si el puntaje es negativo para que asi mo muestre dicho conjunto de numeros
                    score = 0;//Si es negativo el score pasara a ser 0
                }
                break;
        }
        FrmMain.lblScore.setText(score + "");//Se cambia el texto del score por el actual
    }
}
