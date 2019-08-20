/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Score;
import View.FrmMain;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nick_
 */
public class CtlTableScore {

    ArrayList<Score> listScore;

    public CtlTableScore() {
        this.listScore = new ArrayList();
    }

    public void listScore() {
        orderBubble(listScore);
        String[] nombreColumnas = {"#", "Nombre", "puntaje"};

        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas);

        for (int i = 0; i < this.listScore.size(); i++) {
            modelo.addRow(new Object[]{
                i + 1,
                this.listScore.get(i).getNombre(),
                this.listScore.get(i).getPuntaje()});
        }

        FrmMain.tblScore.setModel(modelo);

    }

    private void orderBubble(ArrayList<Score> list) {
        int iteration = 1;// establece el lugar hasta donde se iterará
        boolean permutation;
        do {
            permutation = false;// valida que el ciclo no sea infinito
            for (int i = 0; i < list.size() - iteration; i++) {
                if (list.get(i).getPuntaje() <= (list.get(i + 1).getPuntaje())) {
                    permutation = true;
                    changePosition(list, i, i + 1);
                }
            }
            iteration++;// elimina la iteracion de una posicion,
            // ya que el mayor ya estaria de ultimo
        } while (permutation);
    }

    private void changePosition(ArrayList<Score> array, int i, int j) {
        Score temp;
        temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

}
