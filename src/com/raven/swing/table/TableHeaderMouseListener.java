/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.swing.table;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Nguyen Duy Hung
 */
public class TableHeaderMouseListener extends MouseAdapter {
    private JTable table;
     
    public TableHeaderMouseListener(JTable table) {
        this.table = table;
    }
     
    public void mouseClicked(MouseEvent event) {
        Point point = event.getPoint();
        int column = table.columnAtPoint(point);
         
        JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked");
         
        // do your real thing here...
    }
}
