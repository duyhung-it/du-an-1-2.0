package com.raven.form;

import com.nhomsau.domainmodel.Nganh;
import com.nhomsau.service.impl.NganhService;
import com.nhomsau.viewmodel.QuanLyNganh;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormNganh extends javax.swing.JPanel {

    NganhService nganhService;
    List<Nganh> listNganh;
    DefaultTableModel model;

    public FormNganh() {
        initComponents();
        nganhService = new NganhService();
        model = (DefaultTableModel) tbNganh.getModel();
        listNganh = new ArrayList<>();
        setOpaque(false);
        loadTable();
        txtMa.setLabelText("ma nganh");
        txtTen.setLabelText("ten nganh");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMa = new com.raven.swing.textfield.TextField();
        txtTen = new com.raven.swing.textfield.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNganh = new com.raven.swing.table.Table();
        btnAdd = new com.raven.swing.button.Button();
        btnUpdate = new com.raven.swing.button.Button();
        btnDelete = new com.raven.swing.button.Button();
        btnClear = new com.raven.swing.button.Button();
        button6 = new com.raven.swing.button.Button();

        tbNganh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ma Ky", "Ten Ky"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbNganh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNganhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNganh);

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        button6.setText("thêm môn vào ngành");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(232, 232, 232))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void loadTable() {
        listNganh = nganhService.findAll();
        model.setRowCount(0);
        for (Nganh ng : listNganh) {
            model.addRow(new Object[]{ng.getId(), ng.getMaNganh(), ng.getTenNganh()});
        }
    }

    private Nganh validateNganh() {
        String id = "";
        String ma = txtMa.getText();
        if (ma.isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được để trống mã");
            return null;
        }
        String ten = txtTen.getText();
        if (ten.isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được để trống mã");
            return null;
        }
        return new Nganh(id, ma, ten);
    }    private void clear() {
        txtMa.setText("");
        txtTen.setText("");
    }
    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_button4ActionPerformed

    private void tbNganhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNganhMouseClicked
        // TODO add your handling code here:
        int selectRow = tbNganh.getSelectedRow();
        txtMa.setText(tbNganh.getValueAt(selectRow, 1).toString());
        txtTen.setText(tbNganh.getValueAt(selectRow, 2).toString());

    }//GEN-LAST:event_tbNganhMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
        Nganh ng = validateNganh();
        if (ng != null) {
            List<Nganh> n = nganhService.findAll();
        }
        JOptionPane.showMessageDialog(this, nganhService.newNganh(ng));
        loadTable();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        int selectRow = tbNganh.getSelectedRow();
        if (selectRow < 0) {
            JOptionPane.showMessageDialog(this, "Bạn cần chọn 1 Nganh cần update");
            return;
        }
        String id = tbNganh.getValueAt(selectRow, 0).toString();
        String ma=txtMa.getText();
        String ten = txtTen.getText();
        if (ten.isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên");
            return;
        }
        JOptionPane.showMessageDialog(this, nganhService.updateNganh(ma,ten, id));
        loadTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectRow = tbNganh.getSelectedRow();
        if (selectRow < 0) {
            JOptionPane.showMessageDialog(this, "Bạn cần chọn 1 Chức Vụ cần xóa trên bảng");
            return;
        }
        String id = tbNganh.getValueAt(selectRow, 0).toString();
        int xacNhan = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoa ngnanh nầy không", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (xacNhan == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, nganhService.deleteNganh(id));
            loadTable();
            clear();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
         clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        // TODO add your handling code here:
        DialogMonNganh monNganh =  new DialogMonNganh(new JFrame(), true);
        Nganh nganh = this.validateNganh();
        nganh.setId(nganhService.findIdNganh(nganh.getMaNganh()));
        monNganh.setNganh(nganh);
        monNganh.setVisible(true);
    }//GEN-LAST:event_button6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.button.Button btnAdd;
    private com.raven.swing.button.Button btnClear;
    private com.raven.swing.button.Button btnDelete;
    private com.raven.swing.button.Button btnUpdate;
    private com.raven.swing.button.Button button6;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.table.Table tbNganh;
    private com.raven.swing.textfield.TextField txtMa;
    private com.raven.swing.textfield.TextField txtTen;
    // End of variables declaration//GEN-END:variables
}
