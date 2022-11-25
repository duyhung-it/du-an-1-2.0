/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.nhomsau.domainmodel.DauDiem;
import com.nhomsau.domainmodel.DauDiemMon;
import com.nhomsau.domainmodel.Diem;
import com.nhomsau.domainmodel.Ky;
import com.nhomsau.domainmodel.Lop;
import com.nhomsau.domainmodel.SinhVien;
import com.nhomsau.repository.impl.DauDiemRepository;
import com.nhomsau.repository.impl.DauDiemMonRepository;
import com.nhomsau.repository.impl.DiemRepository;
import com.nhomsau.repository.impl.KyRepository;
import com.nhomsau.repository.impl.LopRepository;
import com.nhomsau.repository.impl.SinhVienRepository;
import com.nhomsau.viewmodel.QuanLyKy;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public Form_Diem() throws ParseException {
        initComponents();
        tblDiem.fixTable(jScrollPane1);

        lopRepository = new LopRepository();
        dauDiemRepository = new DauDiemRepository();
        diemRepository = new DiemRepository();
        dauDiem_MonRepository = new DauDiemMonRepository();
        sinhVienRepository = new SinhVienRepository();
        kyRepository = new KyRepository();

        model = (DefaultTableModel) tblDiem.getModel();
        fillAllKy();
        fillAllLop();
    }

    private void fillAllKy() {
        cbxKy.setLabeText("Kỳ");
        List<QuanLyKy> lstKy = kyRepository.findAll();
        for (QuanLyKy ky : lstKy) {
            cbBoxModel.addElement(ky.getTen());
        }
        cbxLop.setSelectedIndex(-1);
    }

    private void fillAllLop() {
        cbxLop.setLabeText("Lớp");
        List<Lop> lops = lopRepository.getAllLop();
        for (Lop lop : lops) {
            cbBoxModel.addElement(lop.getTenLop());
        }
        cbxLop.setSelectedIndex(-1);
    }

    private void fillAllDauDiem() {
        Lop lop = lopRepository.getLop((String) cbxLop.getSelectedItem());
        List<DauDiem> listDauDiems = dauDiemRepository.getDauDiems(lop.getIdMonHoc());
        for (DauDiem dauDiem : listDauDiems) {
            dauDiemBoxModel.addElement(dauDiem.getTenDauDiem());
        }
    }

    private void loadTable(List<SinhVien> listSinhViens) {
        model.setRowCount(0);
        int i = 1;
        String dauDiem = (String) cbxDauDiem.getSelectedItem();
        String tenLop = (String) cbxLop.getSelectedItem();
        Lop lop = lopRepository.getLop(tenLop);
        String idDauDiem = dauDiemRepository.getIdDauDiem(dauDiem);
        float heSo = dauDiem_MonRepository.getHeSo(idDauDiem, lop.getIdMonHoc());
        for (SinhVien sv : listSinhViens) {
            String idSV = sinhVienRepository.getIdSV(sv.getMa());
            float diem = diemRepository.getDiem(idSV, lop.getIdMonHoc(), idDauDiem);
            model.addRow(new Object[]{i, sv.getMa(), sv.getHoTen(), dauDiem, heSo, diem});
            i++;
        }
    }

    private void save() {
        boolean validate = true;
        int rowCount = model.getRowCount();
        String dauDiem = (String) cbxDauDiem.getSelectedItem();
        String tenLop = (String) cbxLop.getSelectedItem();
        Lop lop = lopRepository.getLop(tenLop);
        String idDauDiem = dauDiemRepository.getIdDauDiem(dauDiem);
        List<SinhVien> dsSV = sinhVienRepository.getSinhViens(lop.getId());
        for (int i = 0; i < rowCount; i++) {
            String maSV = tblDiem.getValueAt(i, 1).toString();
            String diemString = tblDiem.getValueAt(i, 5).toString();
            float diemTbl = 0;
            if (diemString.isBlank()) {
                JOptionPane.showMessageDialog(this, "Không thêm được điểm cho SV có maSV= " + maSV + " do điểm để trống");
                continue;
            }
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
            String idSV = sinhVienRepository.getIdSV(maSV);
            float diem = diemRepository.getDiem(idSV, lop.getIdMonHoc(), idDauDiem);
            if (diem == diemTbl) {
                System.out.println("giong");
            } else {
                Diem d = new Diem();
                d.setIdSV(idSV);
                d.setIdMonHoc(lop.getIdMonHoc());
                d.setIdDauDiem(idDauDiem);
                d.setDiem(diemTbl);

                int checkSV = diemRepository.checkSV(idSV, lop.getIdMonHoc(), idDauDiem);
                if (checkSV == 1) {
//                    int update = diemRepository.updateDiem(d);
//                    if (update == 1) {
//                        JOptionPane.showMessageDialog(this, "Tc1");
//                    } else {
//                        JOptionPane.showMessageDialog(this, "Tb1");
//                    }
                    JOptionPane.showMessageDialog(this, "không thêm được điểm của SV có maSV = " + maSV + " vì đã tồn tại điểm");
                } else {
                    int insert = diemRepository.saveDiem(d);
                    if (insert == 1) {
                        JOptionPane.showMessageDialog(this, "Thêm điểm cho SV có MaSV = " + maSV + "Thành Công");
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm điểm cho SV có MaSV = " + maSV + "Thất bại");
                    }
                }
            }
        }
        loadTable(dsSV);
    }

    private void update() {
        boolean validate = true;
        int rowCount = model.getRowCount();
        String dauDiem = (String) cbxDauDiem.getSelectedItem();
        String tenLop = (String) cbxLop.getSelectedItem();
        Lop lop = lopRepository.getLop(tenLop);
        String idDauDiem = dauDiemRepository.getIdDauDiem(dauDiem);
        List<SinhVien> dsSV = sinhVienRepository.getSinhViens(lop.getId());
        for (int i = 0; i < rowCount; i++) {
            String maSV = tblDiem.getValueAt(i, 1).toString();
            String diemString = tblDiem.getValueAt(i, 5).toString();
            float diemTbl = 0;
            if (diemString.isBlank()) {
                JOptionPane.showMessageDialog(this, "Không Sửa được điểm cho SV có maSV= " + maSV + " do điểm để trống");
                continue;
            }
            try {
                diemTbl = Float.valueOf(diemString);
                if (diemTbl < 0) {
                    JOptionPane.showMessageDialog(this, "Không Sửa được điểm cho SV có maSV= " + maSV + " do điểm < 0");
                    continue;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Không Sửa được điểm cho SV có maSV= " + maSV + " do điểm ko phải kiếu số");
                continue;
            }
            String idSV = sinhVienRepository.getIdSV(maSV);
            float diem = diemRepository.getDiem(idSV, lop.getIdMonHoc(), idDauDiem);
            if (diem == diemTbl) {
                System.out.println("giong");
            } else {
                Diem d = new Diem();
                d.setIdSV(idSV);
                d.setIdMonHoc(lop.getIdMonHoc());
                d.setIdDauDiem(idDauDiem);
                d.setDiem(diemTbl);

                int checkSV = diemRepository.checkSV(idSV, lop.getIdMonHoc(), idDauDiem);
                if (checkSV == 1) {
                    int update = diemRepository.updateDiem(d);
                    if (update == 1) {
                        JOptionPane.showMessageDialog(this, "Sửa điểm thành công cho SV có maSV = " + maSV);
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa điểm thất bại cho SV có maSV = " + maSV);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa không thành công vì SV có maSV = " + maSV + " chưa có điểm");
                }
            }
        }
        loadTable(dsSV);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDiem = new com.raven.swing.table.Table();
        btnSave = new com.raven.swing.button.Button();
        button1 = new com.raven.swing.button.Button();
        panelTransparent3 = new com.raven.swing.PanelTransparent();
        cbxLop = new com.raven.swing.combobox.Combobox();
        cbxMon = new com.raven.swing.combobox.Combobox();
        cbxKy = new com.raven.swing.combobox.Combobox();

        setPreferredSize(new java.awt.Dimension(1027, 920));

        panelTransparent2.setOpaque(true);

        tblDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Ho Ten"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDiem.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tblDiemInputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(tblDiem);

        btnSave.setText("Thêm");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        button1.setText("Sửa");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTransparent2Layout = new javax.swing.GroupLayout(panelTransparent2);
        panelTransparent2.setLayout(panelTransparent2Layout);
        panelTransparent2Layout.setHorizontalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(panelTransparent2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelTransparent2Layout.setVerticalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        cbxLop.setToolTipText("Lớp");
        cbxLop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLopItemStateChanged(evt);
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
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTransparent3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelTransparent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTransparent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTransparent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        cbxDauDiem.removeAllItems();
        String tenLop = (String) cbxLop.getSelectedItem();
        Lop lop = lopRepository.getLop(tenLop);
        List<DauDiem> listDauDiems = dauDiemRepository.getDauDiems(lop.getIdMonHoc());
        for (DauDiem dauDiem : listDauDiems) {
            dauDiemBoxModel.addElement(dauDiem.getTenDauDiem());
        }
        cbxDauDiem.setModel(dauDiemBoxModel);
        loadTable(sinhVienRepository.getSinhViens(lop.getId()));

    }//GEN-LAST:event_cbxLopItemStateChanged

    private void tblDiemInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tblDiemInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDiemInputMethodTextChanged

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.button.Button btnSave;
    private com.raven.swing.button.Button button1;
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
