package com.raven.form;

import com.nhomsau.domainmodel.Nganh;
import com.nhomsau.service.impl.NganhService;
import java.util.ArrayList;
import java.util.List;
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
        btnSua = new com.raven.swing.Button();
        btnThem = new com.raven.swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNganh = new com.raven.swing.table.Table();
        btnXoa = new com.raven.swing.Button();
        button4 = new com.raven.swing.Button();

        btnSua.setText("SUA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setText("THEM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

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

        btnXoa.setText("XOA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        button4.setText("CLear");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
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
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:

        Nganh ng = validateNganh();
        if (ng != null) {
            List<Nganh> n = nganhService.findAll();
        }
        JOptionPane.showMessageDialog(this, nganhService.newNganh(ng));
        loadTable();

    }//GEN-LAST:event_btnThemActionPerformed
    private void clear() {
        txtMa.setText("");
        txtTen.setText("");
    }
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
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
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
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
    }//GEN-LAST:event_btnXoaActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_button4ActionPerformed

    private void tbNganhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNganhMouseClicked
        // TODO add your handling code here:
        int selectRow = tbNganh.getSelectedRow();
        txtMa.setText(tbNganh.getValueAt(selectRow, 1).toString());
        txtTen.setText(tbNganh.getValueAt(selectRow, 2).toString());

    }//GEN-LAST:event_tbNganhMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button btnSua;
    private com.raven.swing.Button btnThem;
    private com.raven.swing.Button btnXoa;
    private com.raven.swing.Button button4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.table.Table tbNganh;
    private com.raven.swing.textfield.TextField txtMa;
    private com.raven.swing.textfield.TextField txtTen;
    // End of variables declaration//GEN-END:variables
}
