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
import com.nhomsau.viewmodel.QuanLyKy;
import com.nhomsau.viewmodel.QuanLyMon;
import com.nhomsau.viewmodel.QuanLyNganh;
import com.nhomsau.viewmodel.Statistical;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

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
    ChartPanel chartPanel;
    JFreeChart barChart;

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

        chartPanel = new ChartPanel(barChart);
        pnlTrDaTa.setVisible(false);
        tblStatistical.fixTable(jScrollPane1);
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
        QuanLyKy ky = (QuanLyKy) cbbSemester.getSelectedItem();
        QuanLyNganh nganh = (QuanLyNganh) cbbMajor.getSelectedItem();
        if (cbbSubjects.getSelectedIndex() == 0) {
            if (ky != null && nganh != null) {
                List<Statistical> list = managerService.findTotalListStudentToMinMax(nganh.getId(), ky.getId(), 0, 10);
                tblModel.setRowCount(0);
                for (Statistical st : list) {
                    tblModel.addRow(new Object[] { st.getCode(),
                            st.getFullname(),
                            st.getClasscode() + " - " + st.getClassname(),
                            st.getScore() >= 5 ? "Đạt" : "Không đạt",
                            st.getScore() + " - " + st.getNote() });
                }
                if (!list.isEmpty()) {
                    loadDataThongKe();
                } else {
                    setNull();
                }
            }
        } else {
            QuanLyMon mon = (QuanLyMon) cbbSubjects.getSelectedItem();
            if (mon != null) {
                List<Statistical> list = managerService.findListStudent(mon.getMa(), nganh.getMa(), ky.getMa(), 0, 10);
                tblModel.setRowCount(0);
                for (Statistical st : list) {
                    tblModel.addRow(new Object[] { st.getCode(),
                            st.getFullname(),
                            st.getClasscode() + " - " + st.getClassname(),
                            st.getScore() >= 5 ? "Đạt" : "Không đạt",
                            st.getScore() + " - " + st.getNote() });
                }
                initBarChart(nganh, ky, mon);
                if (!list.isEmpty()) {
                    loadDataThongKe();
                } else {
                    setNull();
                }
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

    private void setNull() {
        lblTongSinhVien.setText("0");
        lblTongSinhVienDat.setText("0");
        lblTongSinhVienTruot.setText("0");
    }

    private CategoryDataset createDataset(String idNganh, String idKy, String idMon) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String score = "Yếu";
        List<Statistical> listBangDiem = this.managerService.findTotalListStudent(idMon, idNganh, idKy, 0, 5);
        Double soLuong = Double.valueOf(listBangDiem.size() + "");
        dataset.addValue(soLuong, score, "Yếu");
        String scoreTB = "TB";
        List<Statistical> listBangDiemTb = this.managerService.findTotalListStudent(idMon, idNganh, idKy, 5, 6.5);
        Double soLuongTB = Double.valueOf(listBangDiemTb.size() + "");
        dataset.addValue(soLuongTB, scoreTB, "Trung bình");
        String scoreK = "Khá";
        List<Statistical> listBangDiemK = this.managerService.findTotalListStudent(idMon, idNganh, idKy, 6.5, 8);
        Double soLuongK = Double.valueOf(listBangDiemK.size() + "");
        dataset.addValue(soLuongK, scoreK, "Khá");
        String scoreG = "Giỏi";
        List<Statistical> listBangDiemG = this.managerService.findTotalListStudent(idMon, idNganh, idKy, 8, 9);
        Double soLuongG = Double.valueOf(listBangDiemG.size() + "");
        dataset.addValue(soLuongG, scoreG, "Giỏi");
        String scoreXS = "Xuất sắc";
        List<Statistical> listBangDiemXS = this.managerService.findTotalListStudent(idMon, idNganh, idKy, 9, 10);
        Double soLuongXS = Double.valueOf(listBangDiemG.size() + "");
        dataset.addValue(soLuongXS, scoreXS, "Xuất sắc");
        return dataset;
    }

    private void initBarChart(QuanLyNganh nganh, QuanLyKy ky, QuanLyMon mon) {
        if (mon != null) {
            String title = "Biểu đồ xếp loại sinh viên: " + mon.getTen() + " " + ky.getTen();
            barChart = ChartFactory.createBarChart(
                    title,
                    "Học lực",
                    "Số lượng",
                    createDataset(nganh.getId(), ky.getId(), mon.getId()),
                    PlotOrientation.VERTICAL,
                    true, true, false);
            chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(pnlTrDaTa.getWidth(), pnlTrDaTa.getHeight()));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelTransparent2 = new com.raven.swing.PanelTransparent();
        cbbMajor = new com.raven.swing.combobox.Combobox();
        cbbSubjects = new com.raven.swing.combobox.Combobox();
        cbbSemester = new com.raven.swing.combobox.Combobox();
        button1 = new com.raven.swing.button.Button();
        button2 = new com.raven.swing.button.Button();
        pnlTrDaTa = new com.raven.swing.PanelTransparent();
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
        rdoStudentMiss = new com.raven.swing.radio_button.RadioButtonCustom();
        rdoStudenPass = new com.raven.swing.radio_button.RadioButtonCustom();
        rdoFullStudent = new com.raven.swing.radio_button.RadioButtonCustom();
        xuatfileExec = new com.raven.swing.button.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStatistical = new com.raven.swing.table.Table();
        pnlBieuDoPass = new com.raven.swing.PanelTransparent();

        panelTransparent2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTransparent2.setOpaque(true);

        cbbMajor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMajorItemStateChanged(evt);
            }
        });

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

        button1.setText("Danh sách");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setText("Biểu đồ");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTransparent2Layout = new javax.swing.GroupLayout(panelTransparent2);
        panelTransparent2.setLayout(panelTransparent2Layout);
        panelTransparent2Layout.setHorizontalGroup(
                panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent2Layout
                                .createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(cbbMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 203,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58,
                                        Short.MAX_VALUE)
                                .addComponent(cbbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 203,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(cbbSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 203,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)));
        panelTransparent2Layout.setVerticalGroup(
                panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelTransparent2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(panelTransparent2Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbbMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 57,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbbSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 57,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 57,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(29, Short.MAX_VALUE)));

        pnlTrDaTa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlTrDaTa.setLayout(new java.awt.CardLayout());

        panelTransparent1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTransparent1.setOpaque(true);

        panelTransparent4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Tổng sinh viên");

        lblTongSinhVien.setText("jLabel4");

        javax.swing.GroupLayout panelTransparent4Layout = new javax.swing.GroupLayout(panelTransparent4);
        panelTransparent4.setLayout(panelTransparent4Layout);
        panelTransparent4Layout.setHorizontalGroup(
                panelTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelTransparent4Layout.createSequentialGroup()
                                .addGroup(panelTransparent4Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelTransparent4Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1))
                                        .addGroup(panelTransparent4Layout.createSequentialGroup()
                                                .addGap(93, 93, 93)
                                                .addComponent(lblTongSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(20, Short.MAX_VALUE)));
        panelTransparent4Layout.setVerticalGroup(
                panelTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelTransparent4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTongSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        panelTransparent8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Tổng sinh viên đạt");

        lblTongSinhVienDat.setText("jLabel4");

        javax.swing.GroupLayout panelTransparent8Layout = new javax.swing.GroupLayout(panelTransparent8);
        panelTransparent8.setLayout(panelTransparent8Layout);
        panelTransparent8Layout.setHorizontalGroup(
                panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelTransparent8Layout.createSequentialGroup()
                                .addGroup(panelTransparent8Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelTransparent8Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2))
                                        .addGroup(panelTransparent8Layout.createSequentialGroup()
                                                .addGap(109, 109, 109)
                                                .addComponent(lblTongSinhVienDat,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 94,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        panelTransparent8Layout.setVerticalGroup(
                panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelTransparent8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(1, 1, 1)
                                .addComponent(lblTongSinhVienDat, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                panelTransparent9Layout.createSequentialGroup()
                                        .addContainerGap(81, Short.MAX_VALUE)
                                        .addComponent(lblTongSinhVienTruot, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)));
        panelTransparent9Layout.setVerticalGroup(
                panelTransparent9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelTransparent9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTongSinhVienTruot, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        buttonGroup1.add(rdoStudentMiss);
        rdoStudentMiss.setText("Trượt");
        rdoStudentMiss.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdoStudentMissItemStateChanged(evt);
            }
        });

        buttonGroup1.add(rdoStudenPass);
        rdoStudenPass.setText("Đạt");
        rdoStudenPass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdoStudenPassItemStateChanged(evt);
            }
        });

        buttonGroup1.add(rdoFullStudent);
        rdoFullStudent.setSelected(true);
        rdoFullStudent.setText("Tất cả");
        rdoFullStudent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdoFullStudentItemStateChanged(evt);
            }
        });

        xuatfileExec.setText("Xuất file");
        xuatfileExec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xuatfileExecActionPerformed(evt);
            }
        });

        tblStatistical.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null }
                },
                new String[] {
                        "Mã sinh viên", "Họ tên", "Lớp học", "Trạng thái", "Ghi chú"
                }) {
            boolean[] canEdit = new boolean[] {
                    true, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStatistical);

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
                panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelTransparent1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelTransparent4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelTransparent8, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelTransparent9, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)
                                .addGroup(panelTransparent1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelTransparent1Layout.createSequentialGroup()
                                                .addComponent(rdoStudenPass, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(xuatfileExec, javax.swing.GroupLayout.PREFERRED_SIZE, 97,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelTransparent1Layout.createSequentialGroup()
                                                .addGroup(panelTransparent1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(rdoStudentMiss,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(rdoFullStudent,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addComponent(jScrollPane1));
        panelTransparent1Layout.setVerticalGroup(
                panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelTransparent1Layout.createSequentialGroup()
                                .addGroup(panelTransparent1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelTransparent1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(rdoFullStudent, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelTransparent1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(rdoStudenPass,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(xuatfileExec,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rdoStudentMiss, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelTransparent1Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addGroup(panelTransparent1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(panelTransparent8,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(panelTransparent4,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(panelTransparent9,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 342,
                                        Short.MAX_VALUE)));

        pnlTrDaTa.add(panelTransparent1, "card2");

        pnlBieuDoPass.setPreferredSize(new java.awt.Dimension(741, 300));
        pnlTrDaTa.add(pnlBieuDoPass, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelTransparent2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pnlTrDaTa, javax.swing.GroupLayout.PREFERRED_SIZE, 971,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelTransparent2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlTrDaTa, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void cbbMajorItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbbMajorItemStateChanged

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
                List<Statistical> list = managerService.findListStudent(subject.getMa(), nganh.getMa(), ky.getMa(), 0,
                        10);
                tblModel.setRowCount(0);
                for (Statistical st : list) {
                    tblModel.addRow(new Object[] { st.getCode(),
                            st.getFullname(),
                            st.getClasscode() + " - " + st.getClassname(),
                            st.getScore() >= 5 ? "Đạt" : "Không đạt",
                            st.getScore() + " - " + st.getNote() });
                }
                if (!list.isEmpty()) {
                    loadDataThongKe();
                } else {
                    setNull();
                }
            }

        }
    }// GEN-LAST:event_cbbMajorItemStateChanged

    private void cbbSubjectsItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbbSubjectsItemStateChanged
        QuanLyKy ky = (QuanLyKy) cbbSemester.getSelectedItem();
        QuanLyNganh nganh = (QuanLyNganh) cbbMajor.getSelectedItem();
        if (cbbSubjects.getSelectedIndex() == 0) {
            if (ky != null && nganh != null) {
                List<Statistical> list = managerService.findTotalListStudentToMinMax(nganh.getId(), ky.getId(), 0, 10);
                tblModel.setRowCount(0);
                for (Statistical st : list) {
                    tblModel.addRow(new Object[] { st.getCode(),
                            st.getFullname(),
                            st.getClasscode() + " - " + st.getClassname(),
                            st.getScore() >= 5 ? "Đạt" : "Không đạt",
                            st.getScore() + " - " + st.getNote() });
                }
                if (!list.isEmpty()) {
                    loadDataThongKe();
                } else {
                    setNull();
                }
            }
        } else {
            QuanLyMon mon = (QuanLyMon) cbbSubjects.getSelectedItem();
            if (mon != null) {
                List<Statistical> list = managerService.findListStudent(mon.getMa(), nganh.getMa(), ky.getMa(), 0, 10);
                tblModel.setRowCount(0);
                for (Statistical st : list) {
                    tblModel.addRow(new Object[] { st.getCode(),
                            st.getFullname(),
                            st.getClasscode() + " - " + st.getClassname(),
                            st.getScore() >= 5 ? "Đạt" : "Không đạt",
                            st.getScore() + " - " + st.getNote() });
                }
                initBarChart(nganh, ky, mon);
                if (!list.isEmpty()) {
                    loadDataThongKe();
                } else {
                    setNull();
                }
            }
        }
    }// GEN-LAST:event_cbbSubjectsItemStateChanged

    private void cbbSemesterItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbbSemesterItemStateChanged
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
                List<Statistical> list = managerService.findListStudent(subject.getMa(), nganh.getMa(), ky.getMa(), 0,
                        10);
                tblModel.setRowCount(0);
                for (Statistical st : list) {
                    tblModel.addRow(new Object[] { st.getCode(),
                            st.getFullname(),
                            st.getClasscode() + " - " + st.getClassname(),
                            st.getScore() >= 5 ? "Đạt" : "Không đạt",
                            st.getScore() + " - " + st.getNote() });
                }
                if (!list.isEmpty()) {
                    loadDataThongKe();
                } else {
                    setNull();
                }
            }

        }
    }// GEN-LAST:event_cbbSemesterItemStateChanged

    private void rdoStudenPassItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_rdoStudenPassItemStateChanged

        stateChange();
    }// GEN-LAST:event_rdoStudenPassItemStateChanged

    private void rdoFullStudentItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_rdoFullStudentItemStateChanged
        stateChange();
    }// GEN-LAST:event_rdoFullStudentItemStateChanged

    private void rdoStudentMissItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_rdoStudentMissItemStateChanged
        stateChange();
    }// GEN-LAST:event_rdoStudentMissItemStateChanged

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_button1ActionPerformed
        pnlTrDaTa.setVisible(false);
        loadTable();
        CardLayout layout = (CardLayout) pnlTrDaTa.getLayout();
        layout.first(pnlTrDaTa);
        pnlTrDaTa.setVisible(true);
    }// GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_button2ActionPerformed
        pnlTrDaTa.setVisible(false);
        pnlBieuDoPass.removeAll();
        pnlBieuDoPass.add(chartPanel);
        CardLayout layout = (CardLayout) pnlTrDaTa.getLayout();
        layout.last(pnlTrDaTa);
        pnlTrDaTa.setVisible(true);
    }// GEN-LAST:event_button2ActionPerformed

    private void xuatfileExecActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_xuatfileExecActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showSaveDialog(this);
        String duongdan = fileChooser.getSelectedFile().getPath();
        File saveFile = new File(duongdan);
        if (saveFile != null) {
            FileOutputStream fos = null;
            try {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook workbook = new SXSSFWorkbook();
                Sheet sheet = workbook.createSheet("Bang Diem");
                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblStatistical.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblStatistical.getColumnName(i));

                }
                for (int i = 0; i < tblStatistical.getRowCount(); i++) {
                    Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < tblStatistical.getColumnCount(); j++) {
                        Cell cell = row.createCell(j);
                        if (tblStatistical.getValueAt(i, j) != null) {
                            cell.setCellValue(tblStatistical.getValueAt(i, j).toString());
                        }
                    }
                }
                fos = new FileOutputStream(new File(saveFile.toString()));
                workbook.write(fos);
                workbook.close();
            } catch (FileNotFoundException ex) {
                // Logger.getLogger(Form_Statistical.class.getName()).log(Level.SEVERE, null,
                // ex);
            } catch (IOException ex) {
                // Logger.getLogger(Form_Statistical.class.getName()).log(Level.SEVERE, null,
                // ex);
            } finally {
                try {
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Form_Statistical.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "That Bai");
        }
    }// GEN-LAST:event_xuatfileExecActionPerformed

    private void stateChange() {
        QuanLyKy ky = (QuanLyKy) cbbSemester.getSelectedItem();
        QuanLyNganh nganh = (QuanLyNganh) cbbMajor.getSelectedItem();
        List<Statistical> list = new ArrayList<>();
        if (cbbSubjects.getSelectedIndex() == 0) {
            if (ky != null && nganh != null) {
                if (rdoStudenPass.isSelected()) {
                    list = managerService.findTotalListStudentToMinMax(nganh.getId(), ky.getId(), 5.0, 10.0);
                }
                if (rdoStudentMiss.isSelected()) {
                    list = managerService.findTotalListStudentToMinMax(nganh.getId(), ky.getId(), 0, 5);
                }
                if (rdoFullStudent.isSelected()) {
                    list = managerService.findTotalListStudentToMinMax(nganh.getId(), ky.getId(), 0, 10.0);
                }
                tblModel.setRowCount(0);
                for (Statistical st : list) {
                    tblModel.addRow(new Object[] { st.getCode(),
                            st.getFullname(),
                            st.getClasscode() + " - " + st.getClassname(),
                            st.getScore() >= 5 ? "Đạt" : "Không đạt",
                            st.getScore() + " - " + st.getNote() });
                }
                // if (!list.isEmpty()) {
                // loadDataThongKe();
                // } else {
                // setNull();
                // }
            }
        } else {
            QuanLyMon mon = (QuanLyMon) cbbSubjects.getSelectedItem();
            if (mon != null) {
                if (rdoStudenPass.isSelected()) {
                    list = managerService.findListStudent(mon.getMa(), nganh.getMa(), ky.getMa(), 5, 10);
                }
                if (rdoStudentMiss.isSelected()) {
                    list = managerService.findListStudent(mon.getMa(), nganh.getMa(), ky.getMa(), 0, 5);
                }
                if (rdoFullStudent.isSelected()) {
                    list = managerService.findListStudent(mon.getMa(), nganh.getMa(), ky.getMa(), 0, 10);
                }
                tblModel.setRowCount(0);
                for (Statistical st : list) {

                    tblModel.addRow(new Object[] { st.getCode(),
                            st.getFullname(),
                            st.getClasscode() + " - " + st.getClassname(),
                            st.getScore() >= 5 ? "Đạt" : "Không đạt",
                            st.getScore() + " - " + st.getNote() });
                }
                // if (!list.isEmpty()) {
                // loadDataThongKe();
                // } else {
                // setNull();
                // }
            }

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.button.Button button1;
    private com.raven.swing.button.Button button2;
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
    private com.raven.swing.PanelTransparent pnlBieuDoPass;
    private com.raven.swing.PanelTransparent pnlTrDaTa;
    private com.raven.swing.radio_button.RadioButtonCustom rdoFullStudent;
    private com.raven.swing.radio_button.RadioButtonCustom rdoStudenPass;
    private com.raven.swing.radio_button.RadioButtonCustom rdoStudentMiss;
    private com.raven.swing.table.Table tblStatistical;
    private com.raven.swing.button.Button xuatfileExec;
    // End of variables declaration//GEN-END:variables
}
