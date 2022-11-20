/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.nhomsau.service.INganhService;
import com.nhomsau.service.ISinhVienService;
import com.nhomsau.service.impl.NganhService;
import com.nhomsau.service.impl.SinhVienService;
import com.nhomsau.viewmodel.QuanLyNganh;
import com.nhomsau.viewmodel.SinhVienView;
import com.raven.dialog.Message;
import com.raven.main.Main;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ListStudentPanel extends javax.swing.JPanel {

    /**
     * Creates new form ListStudentPanel
     */
    DefaultTableModel model;
    private ISinhVienService sinhVienService;
    private INganhService nganhService;
    public ListStudentPanel() {
        initComponents();
        model = (DefaultTableModel) tblSinhVien.getModel();
        sinhVienService = new SinhVienService();
        nganhService = new NganhService();
        initDataTable();
        setOpaque(false);
        tblSinhVien.fixTable(jScrollPane2);
        this.setTextField();
        this.initCombobox();
    }
    
    private void initDataTable(){
        model = (DefaultTableModel) tblSinhVien.getModel();
        model.setNumRows(0);
        List<SinhVienView> list = this.sinhVienService.findAll();
        if(list != null);
        for(SinhVienView sv : list){
            tblSinhVien.addRow(sv.toRowTable());
        }
    }
    private void setTextField(){
        txtMa.setLabelText("Mã Sinh Viên");
        txtTen.setLabelText("Họ Tên");
        txtDiaChi.setLabelText("Địa Chỉ");
        txtSDT.setLabelText("Số Điện Thoại");
        txtEmail.setLabelText("Email");
        txtSearch.setLabelText("Tìm kiếm");
        txtDate.setLabelText("Ngày Sinh");
    }
    private void initCombobox(){
        List<QuanLyNganh> list = this.nganhService.findAll();
        cbxNganh.setLabeText("Ngành Học");
        if(!list.isEmpty()){
            for(QuanLyNganh nganh : list){
                cbxNganh.addItem(nganh);
            }
        }
        cbxGioiTinh.setLabeText("Giới Tính");
        cbxGioiTinh.addItem("Nam");
        cbxGioiTinh.addItem("Nữ");
    }
    private SinhVienView validateSinhVien(){
        QuanLyNganh nganh = (QuanLyNganh) cbxNganh.getSelectedItem();
        String ma = txtMa.getText();
        String hoTen = txtTen.getText();
        String ngaySinh = txtDate.getText();
        java.sql.Date ngayS = java.sql.Date.valueOf(ngaySinh);
        boolean gioiTinh = cbxGioiTinh.getSelectedItem().toString().equals("Nam") ? true : false;
        String diaChi = txtDiaChi.getText();
        String email = txtEmail.getText();
        String sdt = txtSDT.getText();
        SinhVienView sinhVien = new SinhVienView(ma, hoTen, ngayS, diaChi, email, sdt, gioiTinh);
        sinhVien.setIdNganh(nganh.getId());
        return sinhVien;
    }
    private void showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTransparent1 = new com.raven.swing.PanelTransparent();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSinhVien = new com.raven.swing.table.Table();
        panelTransparent2 = new com.raven.swing.PanelTransparent();
        txtMa = new com.raven.swing.textfield.TextField();
        txtTen = new com.raven.swing.textfield.TextField();
        txtSDT = new com.raven.swing.textfield.TextField();
        txtDiaChi = new com.raven.swing.textfield.TextField();
        txtEmail = new com.raven.swing.textfield.TextField();
        cbxNganh = new com.raven.swing.combobox.Combobox();
        btnThem = new com.raven.swing.button.Button();
        btnSua = new com.raven.swing.button.Button();
        button1 = new com.raven.swing.button.Button();
        txtSearch = new com.raven.swing.textfield.TextField();
        button3 = new com.raven.swing.button.Button();
        txtDate = new com.raven.swing.textfield.TextField();
        cbxGioiTinh = new com.raven.swing.combobox.Combobox();
        btnThongTin = new com.raven.swing.button.Button();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1062, 741));

        tblSinhVien.setBackground(new java.awt.Color(204, 204, 204));
        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma Sinh Vien", "Ho Ten", "Gioi Tinh", "NgaySinh", "DiaChi", "Email", "SDT", "Ten Nganh"
            }
        ));
        tblSinhVien.setMinimumSize(new java.awt.Dimension(500, 160));
        tblSinhVien.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSinhVien);

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        button1.setText("Xóa");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        button3.setText("Tìm kiếm");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        btnThongTin.setText("Thông Tin");
        btnThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongTinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTransparent2Layout = new javax.swing.GroupLayout(panelTransparent2);
        panelTransparent2.setLayout(panelTransparent2Layout);
        panelTransparent2Layout.setHorizontalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxNganh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTransparent2Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(92, 92, 92)
                .addGroup(panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTransparent2Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbxGioiTinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        panelTransparent2Layout.setVerticalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent2Layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addGroup(panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTransparent2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelTransparent2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        SinhVienView sinhVien = this.validateSinhVien();
        this.sinhVienService.insert(sinhVien);
        initDataTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVienMouseClicked
        // TODO add your handling code here:
        model = (DefaultTableModel) tblSinhVien.getModel();
        int selectedRow = tblSinhVien.getSelectedRow();
        String ma = (String) model.getValueAt(selectedRow, 0);
        String hoTen = (String) model.getValueAt(selectedRow, 1);
        String gioiTinh = (String) model.getValueAt(selectedRow, 2);
        String ngaySinh =  model.getValueAt(selectedRow, 3).toString();
        String diaChi = (String) model.getValueAt(selectedRow, 4);
        String email = (String) model.getValueAt(selectedRow, 5);
        String sdt = (String) model.getValueAt(selectedRow, 6);
        String tenNganh = (String) model.getValueAt(selectedRow, 7);
        txtDate.setText(ngaySinh);
        txtDiaChi.setText(diaChi);
        txtEmail.setText(email);
        txtMa.setText(ma);
        txtSDT.setText(sdt);
        txtTen.setText(hoTen);
        cbxGioiTinh.setSelectedItem(gioiTinh);
        cbxNganh.setSelectedItem(tenNganh);
    }//GEN-LAST:event_tblSinhVienMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        SinhVienView sinhVien = this.validateSinhVien();
        this.sinhVienService.update(sinhVien);
        initDataTable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:\
        this.sinhVienService.delete(txtMa.getText());
        initDataTable();
    }//GEN-LAST:event_button1ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        String maSV = txtSearch.getText();
        List<SinhVienView> list = new ArrayList<>();
         if(!maSV.isBlank()){
            list.add(this.sinhVienService.findByMa(maSV));
        }else{
             
             list = this.sinhVienService.findAll();
         }
         model.setNumRows(0);
         for(SinhVienView sv : list){
             if(sv!= null)
             tblSinhVien.addRow(sv.toRowTable());
         }
    }//GEN-LAST:event_button3ActionPerformed

    private void btnThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongTinActionPerformed
        // TODO add your handling code here:
        ViewStudentPanel viewStudent = new ViewStudentPanel();
        int selectedRow =tblSinhVien.getSelectedRow();
        if(selectedRow != -1){
            String ma = (String) model.getValueAt(selectedRow, 0);
            SinhVienView sv = sinhVienService.findByMa(ma);
            ThongTinSinhVien ttsv = new ThongTinSinhVien();
            ttsv.setStudent(sv);
            ttsv.setVisible(true);
        }
    }//GEN-LAST:event_btnThongTinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.button.Button btnSua;
    private com.raven.swing.button.Button btnThem;
    private com.raven.swing.button.Button btnThongTin;
    private com.raven.swing.button.Button button1;
    private com.raven.swing.button.Button button3;
    private com.raven.swing.combobox.Combobox cbxGioiTinh;
    private com.raven.swing.combobox.Combobox cbxNganh;
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.swing.PanelTransparent panelTransparent1;
    private com.raven.swing.PanelTransparent panelTransparent2;
    private com.raven.swing.table.Table tblSinhVien;
    private com.raven.swing.textfield.TextField txtDate;
    private com.raven.swing.textfield.TextField txtDiaChi;
    private com.raven.swing.textfield.TextField txtEmail;
    private com.raven.swing.textfield.TextField txtMa;
    private com.raven.swing.textfield.TextField txtSDT;
    private com.raven.swing.textfield.TextField txtSearch;
    private com.raven.swing.textfield.TextField txtTen;
    // End of variables declaration//GEN-END:variables
}
