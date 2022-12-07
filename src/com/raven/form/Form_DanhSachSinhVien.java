/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import com.nhomsau.domainmodel.Lop;
import com.nhomsau.domainmodel.SinhVien;
import com.nhomsau.repository.impl.KyRepository;
import com.nhomsau.repository.impl.LopRepository;
import com.nhomsau.service.IMonService;
import com.nhomsau.service.IUserSevice;
import com.nhomsau.service.impl.MonService;
import com.nhomsau.service.impl.SinhVienService;
import com.nhomsau.service.impl.UserService;
import com.nhomsau.util.CheckLogin;
import com.nhomsau.viewmodel.LoginModel;
import com.nhomsau.viewmodel.QuanLyKy;
import com.nhomsau.viewmodel.QuanLyLop;
import com.nhomsau.viewmodel.QuanLyMon;
import com.nhomsau.viewmodel.SinhVienView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Form_DanhSachSinhVien extends javax.swing.JPanel {

    /**
     * Creates new form ok
     */
    LopRepository lopRepository;
    SinhVienService sinhVienService;
    DefaultTableModel model;
    KyRepository kyRepository;
    IMonService monService;
    LoginModel loginModel;

    public Form_DanhSachSinhVien() {
        initComponents();
        if (CheckLogin.isLogin()) {
            loginModel = CheckLogin.loginModel;
        }
        tblSinhVien.fixTable(jScrollPane1);
        model = (DefaultTableModel) tblSinhVien.getModel();
        lopRepository = new LopRepository();
        sinhVienService = new SinhVienService();
        kyRepository = new KyRepository();
        monService = new MonService();
        cbxKy.setLabeText("Kỳ");
        cbxMon.setLabeText("Môn");
        cbxLop.setLabeText("Lớp");
        txtTimKiem.setLabelText("Tìm kiếm theo maSV");
        fillAllKy();
//        loadTable(getSinhViens());
    }

    private void fillAllKy() {
        cbxKy.setLabeText("Kỳ");
        List<QuanLyKy> lstKy = kyRepository.findAll();
        for (QuanLyKy ky : lstKy) {
            cbxKy.addItem(ky);
        }
    }

//    private List<SinhVien> getSinhViens() {
//        List<SinhVien> listSinhViens = new ArrayList<>();
//        QuanLyLop lop = (QuanLyLop) cbxLop.getSelectedItem();
//        if (lop != null) {
//            listSinhViens = sinhVienService.getSinhViens(lop.getIdLop());
//        }
//        return listSinhViens;
//    }

    private void loadTable(List<SinhVienView> list) {
        model.setRowCount(0);
        int i = 1;
        for (SinhVienView sv : list) {

            model.addRow(new Object[]{i, sv.getMa(), sv.getHoTen(), sv.getNgaySinh(), sv.getDiaChi(), sv.getEmail(), sv.getSDT(),sv.getSDT()});
            i++;
        }
    }

//    private List<SinhVien> fillAllSinhVien(){
//        String tenLop = cbxLop.getLabeText();
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTransparent1 = new com.raven.swing.PanelTransparent();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSinhVien = new com.raven.swing.table.Table();
        cbxLop = new com.raven.swing.combobox.Combobox();
        txtTimKiem = new com.raven.swing.textfield.TextField();
        cbxMon = new com.raven.swing.combobox.Combobox();
        cbxKy = new com.raven.swing.combobox.Combobox();

        panelTransparent1.setOpaque(true);

        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "MÃ ", "Họ tên", "Ngày sinh", "Địa chỉ", "Email", "SĐT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSinhVien);

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbxLop.setToolTipText("Lớp");
        cbxLop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLopItemStateChanged(evt);
            }
        });

        txtTimKiem.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtTimKiemPropertyChange(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });

        cbxMon.setToolTipText("Lớp");
        cbxMon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMonItemStateChanged(evt);
            }
        });

        cbxKy.setToolTipText("Lớp");
        cbxKy.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxKyItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbxKy, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(cbxMon, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxLop, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxLopItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLopItemStateChanged
        // TODO add your handling code here:
        List<SinhVienView> listSinhViens = new ArrayList<>();
        QuanLyLop lop = (QuanLyLop) cbxLop.getSelectedItem();
        if (lop != null) {
            listSinhViens = sinhVienService.findSinhVienTheoLop(lop.getIdLop());
            loadTable(listSinhViens);
        } else {
            loadTable(listSinhViens);
        }

    }//GEN-LAST:event_cbxLopItemStateChanged

    private void txtTimKiemPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtTimKiemPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemPropertyChange

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
//         TODO add your handling code here:
//        String timKiem = txtTimKiem.getText();
//        List<SinhVien> list = new ArrayList<>();
//        List<SinhVien> listSinhViens = new ArrayList<>();
//        String tenLop = (String) cbxLop.getSelectedItem();
//        Lop lop = lopRepository.getLop(tenLop);
//        String idLop = lop.getId();
//        listSinhViens = sinhVienService.getSinhViens(idLop);
//        for (SinhVien sv : listSinhViens) {
//            if (sv.getMa().contains(timKiem)) {
//                list.add(sv);
//            }
//        }
//            loadTable(list);
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        // TODO add your handling code here:
        String timKiem = txtTimKiem.getText();
        List<SinhVienView> list = new ArrayList<>();
        List<SinhVienView> listSinhViens = new ArrayList<>();
        QuanLyLop lop = (QuanLyLop) cbxLop.getSelectedItem();
        listSinhViens = sinhVienService.findSinhVienTheoLop(lop.getIdLop());
        for (SinhVienView sv : listSinhViens) {
            if (sv.getMa().contains(timKiem)) {
                list.add(sv);
            }
        }
        loadTable(list);
    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void cbxMonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMonItemStateChanged
        // TODO add your handling code here:
        QuanLyKy ky = (QuanLyKy) cbxKy.getSelectedItem();
        QuanLyMon mon = (QuanLyMon) cbxMon.getSelectedItem();
        cbxLop.removeAllItems();
        if (mon != null) {
            List<QuanLyLop> listLop = this.lopRepository.findIdGV(mon.getId(), loginModel.getIdNganh(), ky.getId(),loginModel.getIdUser());

            for (QuanLyLop lop : listLop) {
                cbxLop.addItem(lop);
            }
        }
    }//GEN-LAST:event_cbxMonItemStateChanged

    private void cbxKyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxKyItemStateChanged
        // TODO add your handling code here:
        QuanLyKy ky = (QuanLyKy) cbxKy.getSelectedItem();
        if (loginModel != null) {
            List<QuanLyMon> listMon = monService.getMonTheoGV(loginModel.getIdNganh(), ky.getId(),loginModel.getIdUser());
            cbxMon.removeAllItems();
            for (QuanLyMon mon : listMon) {
                cbxMon.addItem(mon);
            }
        }
    }//GEN-LAST:event_cbxKyItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.combobox.Combobox cbxKy;
    private com.raven.swing.combobox.Combobox cbxLop;
    private com.raven.swing.combobox.Combobox cbxMon;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.PanelTransparent panelTransparent1;
    private com.raven.swing.table.Table tblSinhVien;
    private com.raven.swing.textfield.TextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
