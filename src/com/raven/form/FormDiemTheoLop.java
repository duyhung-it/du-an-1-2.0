/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.nhomsau.domainmodel.DauDiem;
import com.nhomsau.domainmodel.SinhVien;
import com.nhomsau.service.IDauDiemService;
import com.nhomsau.service.IDiemService;
import com.nhomsau.service.IKyService;
import com.nhomsau.service.ILopService;
import com.nhomsau.service.IManageLecturerService;
import com.nhomsau.service.IMonService;
import com.nhomsau.service.INganhService;
import com.nhomsau.service.impl.DauDiemService;
import com.nhomsau.service.impl.DiemService;
import com.nhomsau.service.impl.KyService;
import com.nhomsau.service.impl.LopService;
import com.nhomsau.service.impl.ManageLecturerService;
import com.nhomsau.service.impl.MonService;
import com.nhomsau.service.impl.NganhService;
import com.nhomsau.service.impl.SinhVienService;
import com.nhomsau.viewmodel.QuanLyDiem;
import com.nhomsau.viewmodel.QuanLyGiangVien;
import com.nhomsau.viewmodel.QuanLyKy;
import com.nhomsau.viewmodel.QuanLyLop;
import com.nhomsau.viewmodel.QuanLyMon;
import com.nhomsau.viewmodel.QuanLyNganh;
import com.nhomsau.viewmodel.TienDoDiemModel;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class FormDiemTheoLop extends javax.swing.JPanel {

    /**
     * Creates new form FormDiemTheoLop
     */
    private INganhService nganhService;
    private IKyService kyService;
    private IMonService monService;
    private IDiemService diemService;
    private ILopService lopService;
    private IManageLecturerService lecturerService;
    private IDauDiemService dauDiemService;
    private SinhVienService sinhVienService;
    DefaultTableModel model;
    List<TienDoDiemModel> list;
    public FormDiemTheoLop() {
        initComponents();
        tblDiemTheoLop.fixTable(jScrollPane1);
        nganhService = new NganhService();
        kyService = new KyService();
        lecturerService = new ManageLecturerService();
        monService = new MonService();
        diemService = new DiemService();
        lopService = new LopService();
        dauDiemService = new DauDiemService();
        sinhVienService = new SinhVienService();
        model = (DefaultTableModel) tblDiemTheoLop.getModel();
        list = new ArrayList<>();
        initListDauDiem(new ArrayList<>());
        initCombox();
        CardLayout layout = (CardLayout) pnLopChiTiet.getLayout();
        layout.last(pnLopChiTiet);
        
    }
    private void initTable(){
        
    }
    private void initCombox(){
        cbxNganh.setLabeText("Ngành Học");
        cbxKy.setLabeText("Kỳ");
        cbxMon.setLabeText("Môn Học");
        List<QuanLyNganh> listNganhs = this.nganhService.findAll1();
        if(!listNganhs.isEmpty()){
            for(QuanLyNganh nganh : listNganhs){
                cbxNganh.addItem(nganh);
            }
        }
        List<QuanLyKy> listKys = this.kyService.findAll();
        for(QuanLyKy ky : listKys){
            cbxKy.addItem(ky);
        }
    }
    private void initListDauDiem(List<DauDiem> list){
        DefaultListModel<String> modelList = new DefaultListModel<>();
        modelList.removeAllElements();
        if(!list.isEmpty()){
            
            for(DauDiem dauDiem : list){
                modelList.addElement(dauDiem.toString());
            }
            
        }
        listDauDiem.setModel(modelList);
    }
    private void initColumn(String idMon,String idNganh,String idLop){
        List<DauDiem> listDauDiem = this.dauDiemService.findDauDiemByMon(idMon, idNganh);
        if(listDauDiem!= null){
            model.setColumnCount(2);
            List<SinhVien> listSinhVien = this.sinhVienService.getSinhViens(idLop);
            
            model.setNumRows(0);
            for(SinhVien sv : listSinhVien){
                tblDiemTheoLop.addRow(new Object[]{
                    sv.getMa(),sv.getHoTen()
                });
            }
            for(DauDiem d : listDauDiem){
                Object[] object = new Object[listSinhVien.size()];
                List<QuanLyDiem> listDiem = this.diemService.getDiemByMon(d.getIdDauDiem(), idMon, idLop);
                int j = 0;
                if(!listDiem.isEmpty())
                for(int i = 0 ; i < listSinhVien.size(); i++){
                    if(listSinhVien.get(i).getId().equals(listDiem.get(j).getIdUser())){
                        object[i] = listDiem.get(j).getDiem();
                        j++;
                        if(j >= listDiem.size()) break;
                    }
                }
               
               model.addColumn(d,object);
            }
            this.setInfor(listSinhVien.size());
        }
    }
    private void setInfor( int quantityStudent){
        lblSoSinhVien.setText(quantityStudent + "");
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
        cbxNganh = new com.raven.swing.combobox.Combobox();
        cbxKy = new com.raven.swing.combobox.Combobox();
        cbxMon = new com.raven.swing.combobox.Combobox();
        btnLopHoc = new com.raven.swing.button.Button();
        pnLopChiTiet = new com.raven.swing.PanelTransparent();
        panelTransparent7 = new com.raven.swing.PanelTransparent();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDiemTheoLop = new com.raven.swing.table.Table();
        panelTransparent3 = new com.raven.swing.PanelTransparent();
        panelTransparent4 = new com.raven.swing.PanelTransparent();
        jLabel1 = new javax.swing.JLabel();
        lblGiangVien = new javax.swing.JLabel();
        panelTransparent5 = new com.raven.swing.PanelTransparent();
        jLabel2 = new javax.swing.JLabel();
        lblSoSinhVien = new javax.swing.JLabel();
        panelTransparent8 = new com.raven.swing.PanelTransparent();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblThongKe = new com.raven.swing.table.Table();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        listDauDiem = new javax.swing.JList<>();
        panelTransparent6 = new com.raven.swing.PanelTransparent();
        rdoAll = new com.raven.swing.radio_button.RadioButtonCustom();
        rdoHT = new com.raven.swing.radio_button.RadioButtonCustom();
        rdoCHT = new com.raven.swing.radio_button.RadioButtonCustom();
        button2 = new com.raven.swing.button.Button();

        panelTransparent1.setOpaque(true);

        cbxNganh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxNganhItemStateChanged(evt);
            }
        });

        cbxKy.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxKyItemStateChanged(evt);
            }
        });

        cbxMon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMonItemStateChanged(evt);
            }
        });

        btnLopHoc.setText("Lớp học");
        btnLopHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLopHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxNganh, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(cbxKy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(105, 105, 105)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxMon, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pnLopChiTiet.setLayout(new java.awt.CardLayout());

        panelTransparent7.setOpaque(true);

        tblDiemTheoLop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaSV", "HoTen"
            }
        ));
        jScrollPane1.setViewportView(tblDiemTheoLop);

        jLabel1.setText("Giảng Viên:");

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
                        .addGap(41, 41, 41)
                        .addComponent(lblGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        panelTransparent4Layout.setVerticalGroup(
            panelTransparent4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Số Sinh Viên:");

        javax.swing.GroupLayout panelTransparent5Layout = new javax.swing.GroupLayout(panelTransparent5);
        panelTransparent5.setLayout(panelTransparent5Layout);
        panelTransparent5Layout.setHorizontalGroup(
            panelTransparent5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent5Layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(lblSoSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        panelTransparent5Layout.setVerticalGroup(
            panelTransparent5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSoSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelTransparent3Layout = new javax.swing.GroupLayout(panelTransparent3);
        panelTransparent3.setLayout(panelTransparent3Layout);
        panelTransparent3Layout.setHorizontalGroup(
            panelTransparent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(panelTransparent4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                .addComponent(panelTransparent5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );
        panelTransparent3Layout.setVerticalGroup(
            panelTransparent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelTransparent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTransparent4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTransparent5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panelTransparent7Layout = new javax.swing.GroupLayout(panelTransparent7);
        panelTransparent7.setLayout(panelTransparent7Layout);
        panelTransparent7Layout.setHorizontalGroup(
            panelTransparent7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTransparent3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelTransparent7Layout.setVerticalGroup(
            panelTransparent7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent7Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTransparent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pnLopChiTiet.add(panelTransparent7, "card3");

        panelTransparent8.setOpaque(true);

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã lớp", "Tên lớp", "Giáo Viên", "Ngày Cập Nhật", "Dự Kiến", "Đã nhập", "Tình trạng"
            }
        ));
        jScrollPane2.setViewportView(tblThongKe);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        listDauDiem.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listDauDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listDauDiemMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listDauDiem);

        buttonGroup1.add(rdoAll);
        rdoAll.setSelected(true);
        rdoAll.setText("Tất cả");
        rdoAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoAllMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoHT);
        rdoHT.setText("Hoàn thành");
        rdoHT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoHTMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoCHT);
        rdoCHT.setText("Chưa hoàn thành");
        rdoCHT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoCHTMouseClicked(evt);
            }
        });

        button2.setText("Xem chi tiết");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTransparent6Layout = new javax.swing.GroupLayout(panelTransparent6);
        panelTransparent6.setLayout(panelTransparent6Layout);
        panelTransparent6Layout.setHorizontalGroup(
            panelTransparent6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent6Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdoAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoCHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        panelTransparent6Layout.setVerticalGroup(
            panelTransparent6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelTransparent6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoCHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelTransparent8Layout = new javax.swing.GroupLayout(panelTransparent8);
        panelTransparent8.setLayout(panelTransparent8Layout);
        panelTransparent8Layout.setHorizontalGroup(
            panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTransparent6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTransparent8Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTransparent8Layout.setVerticalGroup(
            panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTransparent6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );

        pnLopChiTiet.add(panelTransparent8, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnLopChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnLopChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void cbxNganhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxNganhItemStateChanged
        // TODO add your handling code here:
        QuanLyKy ky =(QuanLyKy) cbxKy.getSelectedItem();
        QuanLyNganh nganh = (QuanLyNganh) cbxNganh.getSelectedItem();
        if(ky != null && nganh != null){
            
            List<QuanLyMon> listMons = this.monService.getMonTheoNganh(nganh.getId(),ky.getId());
            cbxMon.removeAllItems();
            if(!listMons.isEmpty()){
                for(QuanLyMon mon : listMons){
                    cbxMon.addItem(mon);
                }
            }
           
        }
    }//GEN-LAST:event_cbxNganhItemStateChanged

    private void cbxKyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxKyItemStateChanged
        // TODO add your handling code here:
        QuanLyKy ky =(QuanLyKy) cbxKy.getSelectedItem();
        QuanLyNganh nganh = (QuanLyNganh) cbxNganh.getSelectedItem();
        if(ky != null && nganh != null){
            System.out.println(ky.getId());
            System.out.println(nganh.getId());
        }
        List<QuanLyMon> listMons = this.monService.getMonTheoNganh(nganh.getId(),ky.getId());
        cbxMon.removeAllItems();
        if(!listMons.isEmpty()){
            for(QuanLyMon mon : listMons){
                cbxMon.addItem(mon);
            }
        }
    }//GEN-LAST:event_cbxKyItemStateChanged

    private void cbxMonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMonItemStateChanged
        // TODO add your handling code here:
        QuanLyKy ky =(QuanLyKy) cbxKy.getSelectedItem();
        QuanLyNganh nganh = (QuanLyNganh) cbxNganh.getSelectedItem();
        QuanLyMon mon = (QuanLyMon) cbxMon.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();
        model.setNumRows(0);
        if(ky != null && nganh != null){
            System.out.println(ky.getId());
            System.out.println(nganh.getId());
        }
        if(mon!= null){
            List<DauDiem> list = this.dauDiemService.findDauDiemByMon(mon.getId(), nganh.getId());
            initListDauDiem(list);
            
        }
    }//GEN-LAST:event_cbxMonItemStateChanged

    private void btnLopHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLopHocActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnLopChiTiet.getLayout();
        layout.last(pnLopChiTiet);
    }//GEN-LAST:event_btnLopHocActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnLopChiTiet.getLayout();
        QuanLyNganh nganh = (QuanLyNganh) cbxNganh.getSelectedItem();
        QuanLyMon mon = (QuanLyMon) cbxMon.getSelectedItem();
        int selectedRow = tblThongKe.getSelectedRow();
        if(selectedRow != -1){
        String maLop = (String) tblThongKe.getValueAt(selectedRow, 0);
        QuanLyLop lop = this.lopService.findByMa(maLop);
        if(lop != null){
            initColumn(mon.getId(), nganh.getId(), lop.getIdLop());
            QuanLyGiangVien giangVien = this.lecturerService.findById(lop.getIdGiaoVien());
            lblGiangVien.setText(giangVien.toString());
        }
        layout.first(pnLopChiTiet);
        }
    }//GEN-LAST:event_button2ActionPerformed

    private void listDauDiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDauDiemMouseClicked
        // TODO add your handling code here:
        String tenDauDiem = this.listDauDiem.getSelectedValue();
        String idDauDiem = this.dauDiemService.getIdDauDiem(tenDauDiem);
        if(idDauDiem != null){
            QuanLyMon mon = (QuanLyMon) cbxMon.getSelectedItem();
            list = this.lopService.thongKeTienDoTheoLop(idDauDiem, mon.getId(), null);
            loadTableTienDo(list,null);
            rdoAll.setSelected(true);
        }
    }//GEN-LAST:event_listDauDiemMouseClicked

    private void rdoAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoAllMouseClicked
        // TODO add your handling code here:
        if(rdoAll.isSelected()){
            loadTableTienDo(list, null);
        }
    }//GEN-LAST:event_rdoAllMouseClicked

    private void rdoHTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoHTMouseClicked
        // TODO add your handling code here:
        if(rdoHT.isSelected() ){
            loadTableTienDo(list, "HT");
        }
    }//GEN-LAST:event_rdoHTMouseClicked

    private void rdoCHTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoCHTMouseClicked
        // TODO add your handling code here:
        if(rdoCHT.isSelected()){
            loadTableTienDo(list, "CHT");
        }
    }//GEN-LAST:event_rdoCHTMouseClicked
    private void loadTableTienDo(List<TienDoDiemModel> list,String trangThai){
        DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();
        model.setNumRows(0);
        for(TienDoDiemModel m : list){
            int soSinhVien = this.sinhVienService.countSinhVienByLop(m.getMaLop());
            String tienDo = m.getSoSinhVienDaNhap() + "/" + soSinhVien;
            
            Object[] object = new Object[]{
                m.getMaLop(),m.getTenLop(),m.getGiangVien(),m.getNgayNhap(),"",tienDo,m.getTrangThai(soSinhVien)
            };
            if(trangThai != null){
                if(trangThai.equals(object[6].toString())){
                    tblThongKe.addRow(object);
                }
            }else{
                tblThongKe.addRow(object);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.button.Button btnLopHoc;
    private com.raven.swing.button.Button button2;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.raven.swing.combobox.Combobox cbxKy;
    private com.raven.swing.combobox.Combobox cbxMon;
    private com.raven.swing.combobox.Combobox cbxNganh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblGiangVien;
    private javax.swing.JLabel lblSoSinhVien;
    private javax.swing.JList<String> listDauDiem;
    private com.raven.swing.PanelTransparent panelTransparent1;
    private com.raven.swing.PanelTransparent panelTransparent3;
    private com.raven.swing.PanelTransparent panelTransparent4;
    private com.raven.swing.PanelTransparent panelTransparent5;
    private com.raven.swing.PanelTransparent panelTransparent6;
    private com.raven.swing.PanelTransparent panelTransparent7;
    private com.raven.swing.PanelTransparent panelTransparent8;
    private com.raven.swing.PanelTransparent pnLopChiTiet;
    private com.raven.swing.radio_button.RadioButtonCustom rdoAll;
    private com.raven.swing.radio_button.RadioButtonCustom rdoCHT;
    private com.raven.swing.radio_button.RadioButtonCustom rdoHT;
    private com.raven.swing.table.Table tblDiemTheoLop;
    private com.raven.swing.table.Table tblThongKe;
    // End of variables declaration//GEN-END:variables
}
