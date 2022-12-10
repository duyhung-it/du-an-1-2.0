/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.nhomsau.service.IDiemService;
import com.nhomsau.service.IKyService;
import com.nhomsau.service.ILopService;
import com.nhomsau.service.IManageManagerService;
import com.nhomsau.service.IMonService;
import com.nhomsau.service.INganhService;
import com.nhomsau.service.ISinhVienService;
import com.nhomsau.service.impl.DiemService;
import com.nhomsau.service.impl.KyService;
import com.nhomsau.service.impl.LopService;
import com.nhomsau.service.impl.ManageManagerService;
import com.nhomsau.service.impl.MonService;
import com.nhomsau.service.impl.NganhService;
import com.nhomsau.service.impl.SinhVienService;
import com.nhomsau.view.Form_Statistical;
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
import java.text.DecimalFormat;
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
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Admin
 */
public class Form_ThongKeHocLuc extends javax.swing.JPanel {

    /**
     * Creates new form Form_ThongKeXepLoai
     */
    private IMonService monService;
    private IKyService kyService;
    private INganhService nganhService;
    private IDiemService diemService;
    private ILopService lopService;
    private ISinhVienService sinhVienService;
    private DefaultTableModel tblModel;
    private IManageManagerService managerService;
    ChartPanel chartPanel;
    JFreeChart barChart;
    private int slgXS, slgGioi, slgKha, slgTB, slgYeu, slgTong;

    public Form_ThongKeHocLuc() {
        initComponents();
        monService = new MonService();
        lopService = new LopService();
        sinhVienService = new SinhVienService();
        kyService = new KyService();
        nganhService = new NganhService();
        diemService = new DiemService();
        managerService = new ManageManagerService();
        barChart = ChartFactory.createPieChart("Biểu đồ", null);
        chartPanel = new ChartPanel(barChart);
        pnlData.setVisible(false);
        tblHocLuc.fixTable(jScrollPane1);
        loadCBB();
        loadTable();
        loadDataThongKe();
    }

    private void loadTable() {
        tblModel = (DefaultTableModel) tblHocLuc.getModel();
        QuanLyKy ky = (QuanLyKy) cbbKy.getSelectedItem();
        QuanLyNganh nganh = (QuanLyNganh) cbbNganhHoc.getSelectedItem();
        if (ky != null && nganh != null) {
            List<Statistical> list = managerService.findTongSinhVienHocLuc(ky.getId(), nganh.getId(), 0, 10);
            slgTong = list.size();
            tblModel.setRowCount(0);
            for (Statistical st : list) {
                tblHocLuc.addRow(new Object[]{st.getCode(),
                    st.getFullname(),
                    st.getClasscode() + " - " + st.getClassname(),
                    st.getNote(),
                    st.getScore()});
            }
            initBarChart(nganh, ky);
            if (!list.isEmpty()) {
                loadDataThongKe();
            } else {
                setNull();
            }
        }
    }

    private void loadDataThongKe() {
        lblTongSinhVien.setText(String.valueOf(slgTong));
        lblGioi.setText(String.valueOf(slgGioi));
        lblKha.setText(String.valueOf(slgKha));
        lblTrungBinh.setText(String.valueOf(slgTB));
        lblYeu.setText(String.valueOf(slgYeu));
    }

    private void setNull() {
        lblTongSinhVien.setText("0");
        lblGioi.setText("0");
        lblKha.setText("0");
        lblTrungBinh.setText("0");
        lblYeu.setText("0");
    }

    private void loadCBB() {
        List<QuanLyKy> listKys = this.kyService.findAll();
        cbbKy.setLabeText("Kỳ Học");
        for (QuanLyKy ky : listKys) {
            cbbKy.addItem(ky);
        }
        List<QuanLyNganh> listNganhs = this.nganhService.findAll1();
        cbbNganhHoc.setLabeText("Ngành Học");
        if (!listNganhs.isEmpty()) {
            for (QuanLyNganh nganh : listNganhs) {
                cbbNganhHoc.addItem(nganh);
            }
        }
        
    }

    private PieDataset createDataset(String idNganh, String idKy) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        String score = "Yếu";
        List<Statistical> listBangDiem = this.managerService.findTongSinhVienHocLuc(idKy, idNganh, 0, 4.9);
        slgYeu = listBangDiem.size();
        Double soLuong = Double.valueOf(listBangDiem.size() + "");
        dataset.setValue(score, soLuong);
        String scoreTB = "TB";
        List<Statistical> listBangDiemTb = this.managerService.findTongSinhVienHocLuc(idKy, idNganh, 4.9, 6.4);
        slgTB = listBangDiemTb.size();
        Double soLuongTB = Double.valueOf(listBangDiemTb.size() + "");
        dataset.setValue(scoreTB, soLuongTB);
        String scoreK = "Khá";
        List<Statistical> listBangDiemK = this.managerService.findTongSinhVienHocLuc(idKy, idNganh, 6.5, 8);
        slgKha = listBangDiemK.size();
        Double soLuongK = Double.valueOf(listBangDiemK.size() + "");
        dataset.setValue(scoreK, soLuongK);
        String scoreG = "Giỏi";
        List<Statistical> listBangDiemG = this.managerService.findTongSinhVienHocLuc(idKy, idNganh, 8, 9);
        slgGioi = listBangDiemG.size();
        Double soLuongG = Double.valueOf(listBangDiemG.size() + "");
        dataset.setValue(scoreG, soLuongG);
        String scoreXS = "Xuất sắc";
        List<Statistical> listBangDiemXS = this.managerService.findTongSinhVienHocLuc(idKy, idNganh, 9, 10);
        slgXS = listBangDiemXS.size();
        Double soLuongXS = Double.valueOf(listBangDiemXS.size() + "");
        dataset.setValue(scoreXS, soLuongXS);
        return dataset;
    }

    private void initBarChart(QuanLyNganh nganh, QuanLyKy ky) {

        String title = "Biểu đồ học lực sinh viên: " + nganh.getTen() + " " + ky.getTen();
        barChart = ChartFactory.createPieChart(title, createDataset(nganh.getId(), ky.getId()), true, true, true);
        PiePlot plot = (PiePlot) barChart.getPlot();
        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
            "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        plot.setLabelGenerator(gen);
        chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(pnlBieuDoPass.getWidth(), pnlBieuDoPass.getHeight()));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTransparent2 = new com.raven.swing.PanelTransparent();
        cbbKy = new com.raven.swing.combobox.Combobox();
        cbbNganhHoc = new com.raven.swing.combobox.Combobox();
        btnDanhSach = new com.raven.swing.button.Button();
        btnBieuDo = new com.raven.swing.button.Button();
        pnlData = new com.raven.swing.PanelTransparent();
        panelTransparent1 = new com.raven.swing.PanelTransparent();
        panelTransparent4 = new com.raven.swing.PanelTransparent();
        jLabel1 = new javax.swing.JLabel();
        lblTongSinhVien = new javax.swing.JLabel();
        panelTransparent8 = new com.raven.swing.PanelTransparent();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblXuatSac = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblGioi = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblKha = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTrungBinh = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblYeu = new javax.swing.JLabel();
        xuatfileExec = new com.raven.swing.button.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHocLuc = new com.raven.swing.table.Table();
        pnlBieuDoPass = new com.raven.swing.PanelTransparent();

        panelTransparent2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbbKy.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbKyItemStateChanged(evt);
            }
        });

        cbbNganhHoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbNganhHocItemStateChanged(evt);
            }
        });

        btnDanhSach.setText("Danh sách");
        btnDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhSachActionPerformed(evt);
            }
        });

        btnBieuDo.setText("Biểu đồ");
        btnBieuDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBieuDoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTransparent2Layout = new javax.swing.GroupLayout(panelTransparent2);
        panelTransparent2.setLayout(panelTransparent2Layout);
        panelTransparent2Layout.setHorizontalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(cbbKy, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(cbbNganhHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(301, 301, 301)
                .addComponent(btnDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelTransparent2Layout.setVerticalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbKy, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNganhHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnlData.setLayout(new java.awt.CardLayout());

        panelTransparent1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTransparent1.setOpaque(true);

        panelTransparent4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Tổng sinh viên");

        lblTongSinhVien.setText("0");

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
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelTransparent4Layout.setVerticalGroup(
            panelTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTongSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTransparent8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("Số sinh viên");

        jLabel8.setText("Xuất sắc");

        lblXuatSac.setText("0");

        jLabel9.setText("Giỏi");

        lblGioi.setText("0");

        jLabel11.setText("Khá");

        lblKha.setText("0");

        jLabel13.setText("Trung bình");

        lblTrungBinh.setText("0");

        jLabel15.setText("Yếu");

        lblYeu.setText("0");

        javax.swing.GroupLayout panelTransparent8Layout = new javax.swing.GroupLayout(panelTransparent8);
        panelTransparent8.setLayout(panelTransparent8Layout);
        panelTransparent8Layout.setHorizontalGroup(
            panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTransparent8Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblXuatSac)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblGioi)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblKha)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTrungBinh)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblYeu))
                    .addComponent(jLabel7))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        panelTransparent8Layout.setVerticalGroup(
            panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(lblYeu))
                    .addGroup(panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(lblTrungBinh))
                    .addGroup(panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(lblKha))
                    .addGroup(panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(lblGioi))
                    .addGroup(panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(lblXuatSac)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        xuatfileExec.setText("Xuất file");
        xuatfileExec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xuatfileExecActionPerformed(evt);
            }
        });

        tblHocLuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Lớp học", "Học lực", "Điểm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHocLuc);

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTransparent4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelTransparent8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(xuatfileExec, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(panelTransparent4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(xuatfileExec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(panelTransparent8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
        );

        pnlData.add(panelTransparent1, "card2");

        pnlBieuDoPass.setPreferredSize(new java.awt.Dimension(741, 300));
        pnlData.add(pnlBieuDoPass, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTransparent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(pnlData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTransparent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbKyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbKyItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKyItemStateChanged

    private void cbbNganhHocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbNganhHocItemStateChanged
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_cbbNganhHocItemStateChanged

    private void btnDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhSachActionPerformed
        pnlData.setVisible(false);
        loadTable();
        CardLayout layout = (CardLayout) pnlData.getLayout();
        layout.first(pnlData);
        pnlData.setVisible(true);
    }//GEN-LAST:event_btnDanhSachActionPerformed

    private void btnBieuDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBieuDoActionPerformed
        QuanLyKy ky = (QuanLyKy) cbbKy.getSelectedItem();
        QuanLyNganh nganh = (QuanLyNganh) cbbNganhHoc.getSelectedItem();

        initBarChart(nganh, ky);
        pnlData.setVisible(false);
        pnlBieuDoPass.removeAll();
        pnlBieuDoPass.add(chartPanel);
        CardLayout layout = (CardLayout) pnlData.getLayout();
        layout.last(pnlData);
        pnlData.setVisible(true);
    }//GEN-LAST:event_btnBieuDoActionPerformed

    private void xuatfileExecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatfileExecActionPerformed
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
                for (int i = 0; i < tblHocLuc.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblHocLuc.getColumnName(i));

                }
                for (int i = 0; i < tblHocLuc.getRowCount(); i++) {
                    Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < tblHocLuc.getColumnCount(); j++) {
                        Cell cell = row.createCell(j);
                        if (tblHocLuc.getValueAt(i, j) != null) {
                            cell.setCellValue(tblHocLuc.getValueAt(i, j).toString());
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
    }//GEN-LAST:event_xuatfileExecActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.button.Button btnBieuDo;
    private com.raven.swing.button.Button btnDanhSach;
    private com.raven.swing.combobox.Combobox cbbKy;
    private com.raven.swing.combobox.Combobox cbbNganhHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGioi;
    private javax.swing.JLabel lblKha;
    private javax.swing.JLabel lblTongSinhVien;
    private javax.swing.JLabel lblTrungBinh;
    private javax.swing.JLabel lblXuatSac;
    private javax.swing.JLabel lblYeu;
    private com.raven.swing.PanelTransparent panelTransparent1;
    private com.raven.swing.PanelTransparent panelTransparent2;
    private com.raven.swing.PanelTransparent panelTransparent4;
    private com.raven.swing.PanelTransparent panelTransparent8;
    private com.raven.swing.PanelTransparent pnlBieuDoPass;
    private com.raven.swing.PanelTransparent pnlData;
    private com.raven.swing.table.Table tblHocLuc;
    private com.raven.swing.button.Button xuatfileExec;
    // End of variables declaration//GEN-END:variables
}
