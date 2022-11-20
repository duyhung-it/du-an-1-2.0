/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.swing.table;

import javax.swing.JTable;
  import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.*;
/**
 *
 * @author Nguyen Duy Hung
 */


public class RollOverTable extends JTable {

    private int rollOverRowIndex = -1;

    public RollOverTable(TableModel model) {
        super(model);
        RollOverListener lst = new RollOverListener();
        addMouseMotionListener(lst);
        addMouseListener(lst);
    }

    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        if( isRowSelected(row) || (row == rollOverRowIndex) ) {
            c.setForeground(getSelectionForeground());
            c.setBackground(getSelectionBackground());
        }
        else {
            c.setForeground(getForeground());
            c.setBackground(getBackground());
        }
        return c;
    }


    private class RollOverListener extends MouseInputAdapter {

        public void mouseExited(MouseEvent e) {
            rollOverRowIndex = -1;
            repaint();
        }

        public void mouseMoved(MouseEvent e) {
            int row = rowAtPoint(e.getPoint());
            if( row != rollOverRowIndex ) {
                rollOverRowIndex = row;
                repaint();
            }
        }
    }
}  

