package com.raven.form;

import com.nhomsau.service.IMonService;
import com.nhomsau.service.impl.MonService;
import com.nhomsau.viewmodel.QuanLyMon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ru.krlvm.swingacrylic.SwingAcrylic;

public class Form_MonHoc extends javax.swing.JPanel {

    private final IMonService iMonService;

    private DefaultTableModel model;
    private List<QuanLyMon> dsQlMon;

    public Form_MonHoc() {
        initComponents();
        setOpaque(false);

        iMonService = new MonService();

        model = (DefaultTableModel) tblMon.getModel();

        dsQlMon = iMonService.findAll();

        txtMa.setLabelText("Mã môn");
        txtTen.setLabelText("Tên môn");
        txtTinChi.setLabelText("Số tín chỉ");
        txtSoBuoi.setLabelText("Số buổi học");

        loadTable();
    }

    private void loadTable() {
        dsQlMon = iMonService.findAll();
        model.setRowCount(0);
        for (QuanLyMon mon : dsQlMon) {
            model.addRow(new Object[]{
                mon.getMa(), mon.getTen(), mon.getTinChi(), mon.getSoBuoiHoc()
            });
        }
    }

    private QuanLyMon validateMon() {
        String ma = txtMa.getText();
        if (ma.isBlank()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã môn");
            return null;
        }
        String ten = txtTen.getText();
        if (ten.isBlank()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên môn");
            return null;
        }
        int tinChi = -1;
        try {
            tinChi = Integer.parseInt(txtTinChi.getText());
            if (tinChi < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng tín chỉ phải lớn hơn 0");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Số lượng tín chỉ phải là số");
            return null;
        }

        int buoiHoc = -1;
        try {
            buoiHoc = Integer.parseInt(txtSoBuoi.getText());
            if (tinChi < 0) {
                JOptionPane.showMessageDialog(this, "Số buổi học phải lớn hơn 0");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Số buổi học phải là số");
            return null;
        }
        QuanLyMon ql = new QuanLyMon(ma, ten, buoiHoc, tinChi);
        return ql;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnThem = new com.raven.swing.button.Button();
        txtMa = new com.raven.swing.textfield.TextField();
        txtTen = new com.raven.swing.textfield.TextField();
        lbId = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMon = new com.raven.swing.table.Table();
        btnSua = new com.raven.swing.button.Button();
        btnXoa = new com.raven.swing.button.Button();
        txtSoBuoi = new com.raven.swing.textfield.TextField();
        txtTinChi = new com.raven.swing.textfield.TextField();

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        lbId.setText("_");

        tblMon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã môn", "Tên môn", "Só tín chỉ", "Số buổi học"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMon);

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbId, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addComponent(txtTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoBuoi, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(txtTinChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(457, 457, 457))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbId)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoBuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        QuanLyMon ql = validateMon();
        if (ql != null) {
            iMonService.insert(ql);
            JOptionPane.showMessageDialog(this, "Thành công");
            loadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Thất bại");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        QuanLyMon ql = validateMon();
        if (ql != null) {
            int row = tblMon.getSelectedRow();
            if (row >= 0) {
                String id = dsQlMon.get(row).getId();
                ql.setId(id);
                iMonService.update(ql);
                JOptionPane.showMessageDialog(this, "Thành công");

            }
        } else {
            JOptionPane.showMessageDialog(this, "Thất bại");
        }
        loadTable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblMonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMonMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
        int row = tblMon.getSelectedRow();
        if (row >= 0) {

            String id = dsQlMon.get(row).getId();
            
            String tenMon = dsQlMon.get(row).getTen();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    FormHeSo fhs = new FormHeSo();
                    fhs.setIdMon(id);
                    fhs.setVisible(true);
                    fhs.setTitle(tenMon);
                    
                }
            });
//            String ma = tblMon.getValueAt(row, 0).toString();
//            String ten = tblMon.getValueAt(row, 1).toString();
//            String tinChi = tblMon.getValueAt(row, 2).toString();
//            String buoiHoc = tblMon.getValueAt(row, 3).toString();

//            lbId.setText(id);
//            txtMa.setText(ma);
//            txtTen.setText(ten);
//            txtTinChi.setText(tinChi);
//            txtSoBuoi.setText(buoiHoc);
        }
        }
    }//GEN-LAST:event_tblMonMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = tblMon.getSelectedRow();
        if (row >= 0) {
            String id = dsQlMon.get(row).getId();
            if (JOptionPane.showConfirmDialog(this, "Có muốn xóa không", "Xóa", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                iMonService.delete(id);
                loadTable();
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.button.Button btnSua;
    private com.raven.swing.button.Button btnThem;
    private com.raven.swing.button.Button btnXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbId;
    private com.raven.swing.table.Table tblMon;
    private com.raven.swing.textfield.TextField txtMa;
    private com.raven.swing.textfield.TextField txtSoBuoi;
    private com.raven.swing.textfield.TextField txtTen;
    private com.raven.swing.textfield.TextField txtTinChi;
    // End of variables declaration//GEN-END:variables
}
