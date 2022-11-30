/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhomsau.view;

import com.nhomsau.service.IDiemService;
import com.nhomsau.service.IKyService;
import com.nhomsau.service.ILopService;
import com.nhomsau.service.IManageMajorService;
import com.nhomsau.service.IManageManagerService;
import com.nhomsau.service.IManageSemesterService;
import com.nhomsau.service.IManageSubjectService;
import com.nhomsau.service.IMonService;
import com.nhomsau.service.INganhService;
import com.nhomsau.service.ISinhVienService;
import com.nhomsau.service.impl.DiemService;
import com.nhomsau.service.impl.KyService;
import com.nhomsau.service.impl.LopService;
import com.nhomsau.service.impl.ManageMajorService;
import com.nhomsau.service.impl.ManageManagerService;
import com.nhomsau.service.impl.ManageSemesterService;
import com.nhomsau.service.impl.ManageSubjectService;
import com.nhomsau.service.impl.MonService;
import com.nhomsau.service.impl.NganhService;
import com.nhomsau.service.impl.SinhVienService;
import com.nhomsau.viewmodel.ManageMajor;
import com.nhomsau.viewmodel.ManageSemester;
import com.nhomsau.viewmodel.ManageSubject;
import com.nhomsau.viewmodel.QuanLyKy;
import com.nhomsau.viewmodel.QuanLyMon;
import com.nhomsau.viewmodel.QuanLyNganh;
import com.nhomsau.viewmodel.Statistical;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import jdk.dynalink.beans.StaticClass;

/**
 *
 * @author Admin
 */
public class Form_Statistical extends javax.swing.JPanel {

    /**
     * Creates new form Form_Statistical
     */
    private IManageSubjectService subjectService;
    private IManageMajorService majorService;
    private IManageSemesterService semesterService;
    private IManageManagerService managerService;
    private DefaultTableModel tblModel;
    private IMonService monService;
    private IKyService kyService;
    private INganhService nganhService;
    private IDiemService diemService;
    private ILopService lopService;
    private ISinhVienService sinhVienService;
    List<Statistical> list;

    public Form_Statistical() {
        initComponents();
        managerService = new ManageManagerService();
        subjectService = new ManageSubjectService();
        majorService = new ManageMajorService();
        semesterService = new ManageSemesterService();
        monService = new MonService();
        lopService = new LopService();
        sinhVienService = new SinhVienService();
        kyService = new KyService();
        nganhService = new NganhService();
        diemService = new DiemService();
        loadCBB();
        loadTable();
    }

    private void loadCBB() {
        List<QuanLyNganh> listNganhs = this.nganhService.findAll1();
        cbbMajor.setLabeText("Ngành Học");
        if (!listNganhs.isEmpty()) {
            for (QuanLyNganh nganh : listNganhs) {
                cbbMajor.addItem(nganh);
            }
        }
        List<QuanLyMon> listMons = this.monService.findAll();

        cbbSubjects.setLabeText("Môn Học");

        List<QuanLyKy> listKys = this.kyService.findAll();
        cbbSemester.setLabeText("Kỳ Học");
        for (QuanLyKy ky : listKys) {
            cbbSemester.addItem(ky);
        }
    }

    private void loadTable() {
        tblModel = (DefaultTableModel) tblStatistical.getModel();

        QuanLyNganh major = (QuanLyNganh) cbbMajor.getSelectedItem();
        QuanLyKy semester = (QuanLyKy) cbbSemester.getSelectedItem();
        QuanLyMon subject = (QuanLyMon) cbbSubjects.getSelectedItem();
        if (subject != null) {
            List<Statistical> list = managerService.findListStudent(subject.getMa(), major.getMa(), semester.getMa());
            tblModel.setRowCount(0);
            for (Statistical st : list) {
                tblModel.addRow(new Object[]{st.getCode(),
                    st.getFullname(),
                    st.getClasscode() + " - " + st.getClassname(),
                    st.getScore() >= 5 ? "Đạt" : "Không đạt",
                    st.getScore()});
            }
        }

    }

    private void loadDataThongKe() {

        int tong = tblModel.getRowCount();
        if (tong > 0) {
            int dat = 0;
            lblTongSinhVien.setText(String.valueOf(tong));
            for (int i = 0; i < tong; i++) {
                if (tblModel.getValueAt(i, 3).toString().equalsIgnoreCase("Đạt")) {
                    dat++;
                }
            }
            lblTongSinhVienDat.setText(String.valueOf(dat));
            lblTongSinhVienTruot.setText(String.valueOf(tong - dat));
        }
    }
    private void setNull(){
        lblTongSinhVien.setText("0");
        lblTongSinhVienDat.setText("0");
        lblTongSinhVienTruot.setText("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelTransparent1 = new com.raven.swing.PanelTransparent();
        panelTransparent4 = new com.raven.swing.PanelTransparent();
        jLabel1 = new javax.swing.JLabel();
        lblTongSinhVien = new javax.swing.JLabel();
        panelTransparent8 = new com.raven.swing.PanelTransparent();
        jLabel2 = new javax.swing.JLabel();
        lblTongSinhVienDat = new javax.swing.JLabel();
        panelTransparent9 = new com.raven.swing.PanelTransparent();
        jLabel3 = new javax.swing.JLabel();
        lblTongSinhVienTruot = new javax.swing.JLabel();
        panelTransparent2 = new com.raven.swing.PanelTransparent();
        rdoFullStudent = new com.raven.swing.radio_button.RadioButtonCustom();
        cbbMajor = new com.raven.swing.combobox.Combobox();
        rdoStudenPass = new com.raven.swing.radio_button.RadioButtonCustom();
        rdoStudentMiss = new com.raven.swing.radio_button.RadioButtonCustom();
        cbbSubjects = new com.raven.swing.combobox.Combobox();
        cbbSemester = new com.raven.swing.combobox.Combobox();
        button1 = new com.raven.swing.button.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStatistical = new com.raven.swing.table.Table();

        panelTransparent1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelTransparent4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Tổng sinh viên");

        lblTongSinhVien.setText("jLabel4");

        javax.swing.GroupLayout panelTransparent4Layout = new javax.swing.GroupLayout(panelTransparent4);
        panelTransparent4.setLayout(panelTransparent4Layout);
        panelTransparent4Layout.setHorizontalGroup(
            panelTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent4Layout.createSequentialGroup()
                .addGroup(panelTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTransparent4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(panelTransparent4Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(lblTongSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        panelTransparent4Layout.setVerticalGroup(
            panelTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTongSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelTransparent8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Tổng sinh viên đạt");

        lblTongSinhVienDat.setText("jLabel4");

        javax.swing.GroupLayout panelTransparent8Layout = new javax.swing.GroupLayout(panelTransparent8);
        panelTransparent8.setLayout(panelTransparent8Layout);
        panelTransparent8Layout.setHorizontalGroup(
            panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent8Layout.createSequentialGroup()
                .addGroup(panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTransparent8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(panelTransparent8Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(lblTongSinhVienDat, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelTransparent8Layout.setVerticalGroup(
            panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(lblTongSinhVienDat, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelTransparent9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Tổng sinh viên trượt:");

        lblTongSinhVienTruot.setText("jLabel4");

        javax.swing.GroupLayout panelTransparent9Layout = new javax.swing.GroupLayout(panelTransparent9);
        panelTransparent9.setLayout(panelTransparent9Layout);
        panelTransparent9Layout.setHorizontalGroup(
            panelTransparent9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent9Layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(lblTongSinhVienTruot, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        panelTransparent9Layout.setVerticalGroup(
            panelTransparent9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTongSinhVienTruot, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(panelTransparent4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(panelTransparent8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelTransparent9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelTransparent9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelTransparent8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelTransparent4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        panelTransparent2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonGroup1.add(rdoFullStudent);
        rdoFullStudent.setSelected(true);
        rdoFullStudent.setText("Tất cả");

        cbbMajor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMajorItemStateChanged(evt);
            }
        });

        buttonGroup1.add(rdoStudenPass);
        rdoStudenPass.setText("Đạt");

        buttonGroup1.add(rdoStudentMiss);
        rdoStudentMiss.setText("Trượt");

        cbbSubjects.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSubjectsItemStateChanged(evt);
            }
        });

        cbbSemester.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSemesterItemStateChanged(evt);
            }
        });

        button1.setText("Xuất file");

        javax.swing.GroupLayout panelTransparent2Layout = new javax.swing.GroupLayout(panelTransparent2);
        panelTransparent2.setLayout(panelTransparent2Layout);
        panelTransparent2Layout.setHorizontalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(cbbMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(cbbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(cbbSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelTransparent2Layout.createSequentialGroup()
                        .addGroup(panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoFullStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoStudentMiss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(158, 158, 158))
                    .addGroup(panelTransparent2Layout.createSequentialGroup()
                        .addComponent(rdoStudenPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        panelTransparent2Layout.setVerticalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent2Layout.createSequentialGroup()
                .addGroup(panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTransparent2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(rdoFullStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoStudenPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(rdoStudentMiss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTransparent2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        tblStatistical.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Lớp học", "Trạng thái", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStatistical);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelTransparent2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTransparent1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTransparent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbMajorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMajorItemStateChanged

        QuanLyKy ky = (QuanLyKy) cbbSemester.getSelectedItem();
        QuanLyNganh nganh = (QuanLyNganh) cbbMajor.getSelectedItem();

        if (ky != null && nganh != null) {
            System.out.println(ky.getId());
            System.out.println(nganh.getId());
            List<QuanLyMon> listMons = this.monService.getMonTheoNganh(nganh.getId(), ky.getId());
            cbbSubjects.removeAllItems();
            if (!listMons.isEmpty()) {
                cbbSubjects.addItem("Tất Cả");
                for (QuanLyMon mon : listMons) {
                    cbbSubjects.addItem(mon);
                }
            }

            if (cbbSubjects.getSelectedIndex() > 0) {
                QuanLyMon subject = (QuanLyMon) cbbSubjects.getSelectedItem();
                List<Statistical> list = managerService.findListStudent(subject.getMa(), nganh.getMa(), ky.getMa());
                tblModel.setRowCount(0);
                for (Statistical st : list) {
                    tblModel.addRow(new Object[]{st.getCode(),
                        st.getFullname(),
                        st.getClasscode() + " - " + st.getClassname(),
                        st.getScore() >= 5 ? "Đạt" : "Không đạt",
                        st.getScore() + " - " + st.getNote()});
                }
                if (!list.isEmpty()) {
                    loadDataThongKe();
                }else{
                    setNull();
                }
            }

        }
    }//GEN-LAST:event_cbbMajorItemStateChanged

    private void cbbSubjectsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSubjectsItemStateChanged
        QuanLyKy ky = (QuanLyKy) cbbSemester.getSelectedItem();
        QuanLyNganh nganh = (QuanLyNganh) cbbMajor.getSelectedItem();
        if (cbbSubjects.getSelectedIndex() == 0) {
            if (ky != null && nganh != null) {
                List<Statistical> list = managerService.findListStudent(null, nganh.getMa(), ky.getMa());
                tblModel.setRowCount(0);
                for (Statistical st : list) {
                    tblModel.addRow(new Object[]{st.getCode(),
                        st.getFullname(),
                        st.getClasscode() + " - " + st.getClassname(),
                        st.getScore() >= 5 ? "Đạt" : "Không đạt",
                        st.getScore() + " - " + st.getNote()});
                }
                if (!list.isEmpty()) {
                    loadDataThongKe();
                }else{
                    setNull();
                }
            }
        } else {
            QuanLyMon mon = (QuanLyMon) cbbSubjects.getSelectedItem();
            if (mon != null) {
                List<Statistical> list = managerService.findListStudent(mon.getMa(), nganh.getMa(), ky.getMa());
                tblModel.setRowCount(0);
                for (Statistical st : list) {
                    tblModel.addRow(new Object[]{st.getCode(),
                        st.getFullname(),
                        st.getClasscode() + " - " + st.getClassname(),
                        st.getScore() >= 5 ? "Đạt" : "Không đạt",
                        st.getScore() + " - " + st.getNote()});
                }
                if (!list.isEmpty()) {
                    loadDataThongKe();
                }else{
                    setNull();
                }
            }
        }
    }//GEN-LAST:event_cbbSubjectsItemStateChanged

    private void cbbSemesterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSemesterItemStateChanged
        QuanLyKy ky = (QuanLyKy) cbbSemester.getSelectedItem();
        QuanLyNganh nganh = (QuanLyNganh) cbbMajor.getSelectedItem();

        if (ky != null && nganh != null) {
            List<QuanLyMon> listMons = this.monService.getMonTheoNganh(nganh.getId(), ky.getId());
            cbbSubjects.removeAllItems();
            if (!listMons.isEmpty()) {
                cbbSubjects.addItem("Tất Cả");
                for (QuanLyMon mon : listMons) {
                    cbbSubjects.addItem(mon);
                }
            }
            if (cbbSubjects.getSelectedIndex() > 0) {
                QuanLyMon subject = (QuanLyMon) cbbSubjects.getSelectedItem();
                List<Statistical> list = managerService.findListStudent(subject.getMa(), nganh.getMa(), ky.getMa());
                tblModel.setRowCount(0);
                for (Statistical st : list) {
                    tblModel.addRow(new Object[]{st.getCode(),
                        st.getFullname(),
                        st.getClasscode() + " - " + st.getClassname(),
                        st.getScore() >= 5 ? "Đạt" : "Không đạt",
                        st.getScore() + " - " + st.getNote()});
                }
                if (!list.isEmpty()) {
                    loadDataThongKe();
                }else{
                    setNull();
                }
            }

        }
    }//GEN-LAST:event_cbbSemesterItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.button.Button button1;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.raven.swing.combobox.Combobox cbbMajor;
    private com.raven.swing.combobox.Combobox cbbSemester;
    private com.raven.swing.combobox.Combobox cbbSubjects;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTongSinhVien;
    private javax.swing.JLabel lblTongSinhVienDat;
    private javax.swing.JLabel lblTongSinhVienTruot;
    private com.raven.swing.PanelTransparent panelTransparent1;
    private com.raven.swing.PanelTransparent panelTransparent2;
    private com.raven.swing.PanelTransparent panelTransparent4;
    private com.raven.swing.PanelTransparent panelTransparent8;
    private com.raven.swing.PanelTransparent panelTransparent9;
    private com.raven.swing.radio_button.RadioButtonCustom rdoFullStudent;
    private com.raven.swing.radio_button.RadioButtonCustom rdoStudenPass;
    private com.raven.swing.radio_button.RadioButtonCustom rdoStudentMiss;
    private com.raven.swing.table.Table tblStatistical;
    // End of variables declaration//GEN-END:variables
}
