/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Bar;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Daryl Ospina
 */
public class CtlBar extends JComponent implements Runnable {

    private Bar bar;
    private final JComponent panel;

    public CtlBar(JComponent panel) {
        this.bar = new Bar(200, 20, (int) panel.getWidth() / 2, panel.getHeight()-20);
        this.panel = panel;
        this.setBounds(0, 0, this.panel.getWidth(), this.panel.getHeight());
        this.panel.add(this);
    }

    @Override
    public void run() {
        while (true) {
            this.panel.repaint();
        }
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        grphcs.setColor(Color.PINK);
        grphcs.fillRect(this.bar.getPosX(), this.bar.getPosY(), this.bar.getWidth(), this.bar.getHeight());
    }

    public Bar getBar() {
        return this.bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public void moveRight(JComponent temp) {
        if (this.bar.getPosX() < temp.getWidth() - 200) {
            this.bar.setPosX(bar.getPosX() + 20);
        }

    }

    public void moveLeft() {
        if (this.bar.getPosX() > 0) {
            this.bar.setPosX(this.bar.getPosX() - 20);
        }

    }
}
