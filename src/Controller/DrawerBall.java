/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author nick_
 */
public class DrawerBall extends JComponent implements Runnable {

    private final JComponent panel;
    private CtlBall ctlBall;

    public DrawerBall(JComponent panel) {
        super();
        this.setBounds(0, 0, panel.getWidth(), panel.getHeight());

        panel.add(this);

        this.panel = panel;

        ctlBall = new CtlBall();
    }

    @Override
    public void run() {

        while (true) {
            panel.repaint();
        }

    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);

        ctlBall.drawBall(grphcs, ctlBall.getBall());
    }

    public CtlBall getCtlBola() {
        return ctlBall;
    }

    public void setCtlBola(CtlBall ctlBall) {
        this.ctlBall = ctlBall;
    }

}
