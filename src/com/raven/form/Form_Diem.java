/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.nhomsau.domainmodel.DauDiem;
import com.nhomsau.domainmodel.Diem;
import com.nhomsau.domainmodel.Lop;
import com.nhomsau.domainmodel.SinhVien;
import com.nhomsau.repository.impl.DauDiemRepository;
import com.nhomsau.repository.impl.DauDiemMonRepository;
import com.nhomsau.repository.impl.DiemRepository;
import com.nhomsau.repository.impl.KyRepository;
import com.nhomsau.repository.impl.LopRepository;
import com.nhomsau.repository.impl.SinhVienRepository;
import com.nhomsau.service.IMonService;
import com.nhomsau.service.impl.MonService;
import com.nhomsau.util.CheckLogin;
import com.nhomsau.viewmodel.QuanLyDiem;
import com.nhomsau.viewmodel.QuanLyKy;
import com.nhomsau.viewmodel.QuanLyLop;
import com.nhomsau.viewmodel.QuanLyMon;
import com.nhomsau.viewmodel.QuanLyNganh;
import java.text.ParseException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class Form_Diem extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    DefaultTableModel model;
    DefaultComboBoxModel<String> cbBoxModel;
    DefaultComboBoxModel<String> dauDiemBoxModel;
    LopRepository lopRepository;
    DauDiemRepository dauDiemRepository;
    SinhVienRepository sinhVienRepository;
    DiemRepository diemRepository;
    DauDiemMonRepository dauDiem_MonRepository;
    KyRepository kyRepository;
    IMonService monService;
    
    public Form_Diem() throws ParseException {
        initComponents();
        tblDiem.fixTable(jScrollPane1);
        tblDiem.setShowHorizontalLines(true);
        tblDiem.setShowVerticalLines(true);
        monService = new MonService();
        lopRepository = new LopRepository();
        dauDiemRepository = new DauDiemRepository();
        diemRepository = new DiemRepository();
        dauDiem_MonRepository = new DauDiemMonRepository();
        sinhVienRepository = new SinhVienRepository();
        kyRepository = new KyRepository();
        model = (DefaultTableModel) tblDiem.getModel();
        fillAllKy();
        
    }

    private void fillAllKy() {
        cbxKy.setLabeText("Kỳ");
        List<QuanLyKy> lstKy = kyRepository.findAll();
        for (QuanLyKy ky : lstKy) {
            cbxKy.addItem(ky);
        }
    }

    private void loadTable(List<SinhVien> listSinhViens) {
//        model.setRowCount(0);
//        int i = 1;
////        String dauDiem = (String) cbxDau.getSelectedItem();
//        String tenLop = (String) cbxLop.getSelectedItem();
//        Lop lop = lopRepository.getLop(tenLop);
//        String idDauDiem = dauDiemRepository.getIdDauDiem(dauDiem);
//        float heSo = dauDiem_MonRepository.getHeSo(idDauDiem, lop.getIdMonHoc());
//        for (SinhVien sv : listSinhViens) {
//            String idSV = sinhVienRepository.getIdSV(sv.getMa());
//            float diem = diemRepository.getDiem(idSV, lop.getIdMonHoc(), idDauDiem);
//            model.addRow(new Object[]{i, sv.getMa(), sv.getHoTen(), dauDiem, heSo, diem});
//            i++;
//        }
    }

    private String getIdMon() {
        QuanLyMon mon = (QuanLyMon) cbxMon.getSelectedItem();
        return mon.getId();
    }

    private String getIdLop(){
        QuanLyLop lop = (QuanLyLop) cbxLop.getSelectedItem();
        return lop.getIdLop();
    }
    private void save() {
        int row = tblDiem.getRowCount();
        int column = tblDiem.getColumnCount();

        QuanLyLop lop = (QuanLyLop) cbxLop.getSelectedItem();

        for (int i = 4; i < column; i++) {
            String dauDiem = tblDiem.getColumnName(i);
            String idDauDiem = dauDiemRepository.getIdDauDiem(dauDiem);
            for (int j = 0; j < row; j++) {
                System.out.println("row" + j + "col" + i);
                String maSV = tblDiem.getValueAt(j, 1).toString();
                String idSV = sinhVienRepository.getIdSV(maSV);
                String diemString = null;
                Object diemOb = tblDiem.getValueAt(j, i);
                if(diemOb == null){
                    diemString = "0";
                }else{
                    diemString = diemOb.toString();
                }
                
                float diemTbl = 0;
                try {
                    diemTbl = Float.valueOf(diemString);
                    if (diemTbl < 0) {
                        JOptionPane.showMessageDialog(this, "Không thêm được điểm cho SV có maSV= " + maSV + " do điểm < 0");
                        continue;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Không thêm được điểm cho SV có maSV= " + maSV + " do điểm ko phải kiếu số");
                    continue;
                }
                float diemCheck = diemRepository.getDiem(idSV, getIdMon(), idDauDiem);
                if (diemTbl != diemCheck) {
                    Diem diem = new Diem();
                    diem.setIdSV(idSV);
                    diem.setIdMonHoc(getIdMon());
                    diem.setIdDauDiem(idDauDiem);
                    diem.setDiem(diemTbl);
                    
                    int checkSV = diemRepository.checkSV(idSV, lop.getIdMon(), idDauDiem);
                    if(checkSV == 1){
                        diemRepository.updateDiem(diem);
                    }else{
                        diemRepository.saveDiem(diem);
                    }
                }
            }
        }
        initColumn(getIdMon(), "D6142D6A-3F1A-4537-A680-45CA60029170", getIdLop());
    }
//    private void save() {
//        int rowCount = model.getRowCount();
//        String tenLop = (String) cbxLop.getSelectedItem();
//        Lop lop = lopRepository.getLop(tenLop);
////        String idDauDiem = dauDiemRepository.getIdDauDiem(dauDiem);
//        List<SinhVien> dsSV = sinhVienRepository.getSinhViens(lop.getId());
//        for (int i = 0; i < rowCount; i++) {
//            String maSV = tblDiem.getValueAt(i, 1).toString();
//            String diemString = tblDiem.getValueAt(i, 5).toString();
//            float diemTbl = 0;
//            if (diemString.isBlank()) {
//                JOptionPane.showMessageDialog(this, "Không thêm được điểm cho SV có maSV= " + maSV + " do điểm để trống");
//                continue;
//            }
//            try {
//                diemTbl = Float.valueOf(diemString);
//                if (diemTbl < 0) {
//                    JOptionPane.showMessageDialog(this, "Không thêm được điểm cho SV có maSV= " + maSV + " do điểm < 0");
//                    continue;
//                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(this, "Không thêm được điểm cho SV có maSV= " + maSV + " do điểm ko phải kiếu số");
//                continue;
//            }
//            String idSV = sinhVienRepository.getIdSV(maSV);
//            float diem = diemRepository.getDiem(idSV, lop.getIdMonHoc(), idDauDiem);
//            if (diem == diemTbl) {
//                System.out.println("giong");
//            } else {
//                Diem d = new Diem();
//                d.setIdSV(idSV);
//                d.setIdMonHoc(lop.getIdMonHoc());
//                d.setIdDauDiem(idDauDiem);
//                d.setDiem(diemTbl);
//
//                int checkSV = diemRepository.checkSV(idSV, lop.getIdMonHoc(), idDauDiem);
//                if (checkSV == 1) {
////                    int update = diemRepository.updateDiem(d);
////                    if (update == 1) {
////                        JOptionPane.showMessageDialog(this, "Tc1");
////                    } else {
////                        JOptionPane.showMessageDialog(this, "Tb1");
////                    }
//                    JOptionPane.showMessageDialog(this, "không thêm được điểm của SV có maSV = " + maSV + " vì đã tồn tại điểm");
//                } else {
//                    int insert = diemRepository.saveDiem(d);
//                    if (insert == 1) {
//                        JOptionPane.showMessageDialog(this, "Thêm điểm cho SV có MaSV = " + maSV + "Thành Công");
//                    } else {
//                        JOptionPane.showMessageDialog(this, "Thêm điểm cho SV có MaSV = " + maSV + "Thất bại");
//                    }
//                }
//            }
//        }
//        loadTable(dsSV);
//    }

    private void initColumn(String idMon, String idNganh, String idLop) {
        List<DauDiem> listDauDiem = this.dauDiemRepository.findDauDiemByMon(idMon, idNganh);
        model.setColumnCount(4);
        model.setNumRows(0);
        if (!listDauDiem.isEmpty()) {

            List<SinhVien> listSinhVien = this.sinhVienRepository.getSinhViens(idLop);
            for (SinhVien sv : listSinhVien) {
                tblDiem.addRow(new Object[]{
                    model.getRowCount() + 1, sv.getMa(), sv.getHoTen()
                });
            }
            for (DauDiem d : listDauDiem) {
                Object[] object = new Object[listSinhVien.size()];
                List<QuanLyDiem> listDiem = this.diemRepository.getDiemByMon(d.getIdDauDiem(), idMon, idLop);
                int j = 0;
                if (!listDiem.isEmpty()) {
                    for (int i = 0; i < listSinhVien.size(); i++) {
                        if (listSinhVien.get(i).getId().equals(listDiem.get(j).getIdUser())) {
                            object[i] = listDiem.get(j).getDiem();
                            j++;
                            if (j >= listDiem.size()) {
                                break;
                            }
                        }
                    }
                }

                model.addColumn(d, object);
            }

        }
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
        panelTransparent2 = new com.raven.swing.PanelTransparent();
        btnSave = new com.raven.swing.button.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDiem = new com.raven.swing.table.Table();
        panelTransparent3 = new com.raven.swing.PanelTransparent();
        cbxLop = new com.raven.swing.combobox.Combobox();
        cbxMon = new com.raven.swing.combobox.Combobox();
        cbxKy = new com.raven.swing.combobox.Combobox();

        setPreferredSize(new java.awt.Dimension(1027, 920));

        panelTransparent2.setOpaque(true);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        tblDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "MaSV", "HoTen", "Ghi chú"
            }
        ));
        jScrollPane1.setViewportView(tblDiem);

        javax.swing.GroupLayout panelTransparent2Layout = new javax.swing.GroupLayout(panelTransparent2);
        panelTransparent2.setLayout(panelTransparent2Layout);
        panelTransparent2Layout.setHorizontalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTransparent2Layout.setVerticalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cbxLop.setToolTipText("Lớp");
        cbxLop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLopItemStateChanged(evt);
            }
        });

        cbxMon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMonItemStateChanged(evt);
            }
        });

        cbxKy.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxKyItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelTransparent3Layout = new javax.swing.GroupLayout(panelTransparent3);
        panelTransparent3.setLayout(panelTransparent3Layout);
        panelTransparent3Layout.setHorizontalGroup(
            panelTransparent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxKy, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxMon, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(cbxLop, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTransparent3Layout.setVerticalGroup(
            panelTransparent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(panelTransparent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addComponent(panelTransparent3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTransparent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTransparent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTransparent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxLopItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLopItemStateChanged
        // TODO add your handling code here:   

        QuanLyLop lop = (QuanLyLop) cbxLop.getSelectedItem();
        QuanLyKy ky = (QuanLyKy) cbxKy.getSelectedItem();
        QuanLyMon mon = (QuanLyMon) cbxMon.getSelectedItem();
        if (lop != null) {
            initColumn(mon.getId(), "D6142D6A-3F1A-4537-A680-45CA60029170", lop.getIdLop());
        } else {
            initColumn(null, null, null);
        }

    }//GEN-LAST:event_cbxLopItemStateChanged

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbxKyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxKyItemStateChanged
        // TODO add your handling code here:
        QuanLyKy ky = (QuanLyKy) cbxKy.getSelectedItem();
        List<QuanLyMon> listMon = monService.getMonTheoNganh("D6142D6A-3F1A-4537-A680-45CA60029170", ky.getId());
        cbxMon.removeAllItems();
        for (QuanLyMon mon : listMon) {
            cbxMon.addItem(mon);
        }
    }//GEN-LAST:event_cbxKyItemStateChanged

    private void cbxMonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMonItemStateChanged
        // TODO add your handling code here:
        QuanLyKy ky = (QuanLyKy) cbxKy.getSelectedItem();
        QuanLyMon mon = (QuanLyMon) cbxMon.getSelectedItem();
        cbxLop.removeAllItems();
        if (mon != null) {
            List<QuanLyLop> listLop = this.lopRepository.findByMon(mon.getId(), "D6142D6A-3F1A-4537-A680-45CA60029170", ky.getId());

            for (QuanLyLop lop : listLop) {
                cbxLop.addItem(lop);
            }
        }
    }//GEN-LAST:event_cbxMonItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.button.Button btnSave;
    private com.raven.swing.combobox.Combobox cbxKy;
    private com.raven.swing.combobox.Combobox cbxLop;
    private com.raven.swing.combobox.Combobox cbxMon;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.PanelTransparent panelTransparent1;
    private com.raven.swing.PanelTransparent panelTransparent2;
    private com.raven.swing.PanelTransparent panelTransparent3;
    private com.raven.swing.table.Table tblDiem;
    // End of variables declaration//GEN-END:variables
}
