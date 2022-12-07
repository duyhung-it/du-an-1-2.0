package com.raven.swing.table;

import com.nhomsau.viewmodel.SinhVienView;
import com.nhomsau.viewmodel.TrangThai;
import com.raven.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class Table extends JTable {

    private Object object;

    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
//                if (i1 == -1) {
//                    header.setHorizontalAlignment(JLabel.CENTER);
////                }
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus, int i, int i1) {
//                if (o instanceof ModelProfile) {
//                    ModelProfile data = (ModelProfile) o;
//                    Profile cell = new Profile(data);
//                    if (selected) {
//                        cell.setBackground(new Color(239, 244, 255));
//                    } else {
//                        cell.setBackground(Color.WHITE);
//                    }
//                    return cell;
//
//                } else if (o instanceof ModelAction) {
//                    ModelAction data = (ModelAction) o;
//                    Action cell = new Action(data);
//                    if (selected) {
//                        cell.setBackground(new Color(239, 244, 255));
//                    } else {
//                        cell.setBackground(Color.WHITE);
//                    }
//                    return cell;
                if (o instanceof TrangThai) {
                    JLabel lblTrangThai = new JLabel(((TrangThai) o).getValue());
                    if (lblTrangThai.getText().equalsIgnoreCase("Passed") ) {
                        lblTrangThai.setForeground(Color.GREEN);
                    } else {
                        lblTrangThai.setForeground(Color.RED);
                    }
                    if (selected) {
                        lblTrangThai.setBackground(new Color(239, 244, 255));
                    } else {
                        lblTrangThai.setBackground(Color.WHITE);
                    }
                    return lblTrangThai;
                }else if(o instanceof XSSFCell) {
                    Component com =  super.getTableCellRendererComponent(jtable, o, selected, focus, i, i1);
                    com.setBackground(Color.YELLOW);
                    setBorder(noFocusBorder);
                    com.setForeground(new Color(102, 102, 102));
                    
                    return com;
                } else {
                    if (o instanceof Double) {
                        DecimalFormat formatter = new DecimalFormat("#0.00");
                        o = formatter.format(o);
                    }
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, focus, i, i1);
                    setBorder(noFocusBorder);
                    com.setForeground(new Color(102, 102, 102));
                    if (selected) {
                        com.setBackground(new Color(239, 244, 255));
                    } else {
                        com.setBackground(Color.WHITE);
                    }
                    return com;
                }
            }
        });
    }

//    @Override
//    public TableCellEditor getCellEditor(int row, int col) {
//        if (col == 4) {
//            return new TableCellAction();
//        } else {
//            return super.getCellEditor(row, col);
//        }
//    }
    public void addRow(Object[] row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.addRow(row);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }

    public void tableHover() {
        setSelectionBackground(Color.WHITE);
        setSelectionForeground(Color.BLACK);
        this.addMouseMotionListener(new MouseMotionAdapter() {
            int hoveredRow = -1;
            int hoveredColumn = -1;

            @Override
            public void mouseMoved(MouseEvent e) {
                Point p = e.getPoint();
                hoveredRow = rowAtPoint(p);
                hoveredColumn = columnAtPoint(p);
                setRowSelectionInterval(hoveredRow, hoveredRow);

            }

            @Override
            public void mouseDragged(MouseEvent e) {
                hoveredRow = hoveredColumn = -1;
                setRowSelectionInterval(hoveredRow, hoveredRow);
            }

        });
    }
}
