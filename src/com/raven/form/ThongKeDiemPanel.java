/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.nhomsau.domainmodel.Lop;
import com.nhomsau.service.IDiemService;
import com.nhomsau.service.IKyService;
import com.nhomsau.service.ILopService;
import com.nhomsau.service.IMonService;
import com.nhomsau.service.INganhService;
import com.nhomsau.service.ISinhVienService;
import com.nhomsau.service.impl.DiemService;
import com.nhomsau.service.impl.KyService;
import com.nhomsau.service.impl.LopService;
import com.nhomsau.service.impl.MonService;
import com.nhomsau.service.impl.NganhService;
import com.nhomsau.service.impl.SinhVienService;
import com.nhomsau.viewmodel.BangDiemTheoMon;
import com.nhomsau.viewmodel.QuanLyKy;
import com.nhomsau.viewmodel.QuanLyMon;
import com.nhomsau.viewmodel.QuanLyNganh;
import com.nhomsau.viewmodel.SinhVienView;
import com.raven.swing.table.Table;
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
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ThongKeDiemPanel extends javax.swing.JPanel {

    /**
     * Creates new form ThongKeDiemPanel
     */
    private IMonService monService;
    private IKyService kyService;
    private INganhService nganhService;
    private IDiemService diemService;
    private ILopService lopService;
    private ISinhVienService sinhVienService;
    private List<BangDiemTheoMon> list;
    public ThongKeDiemPanel() {
        initComponents();
        monService = new MonService();
        lopService = new LopService();
        sinhVienService = new SinhVienService();
        kyService = new KyService();
        nganhService = new NganhService();
        diemService = new DiemService();
        pnTable.setVisible(false);
        table1.fixTable(jScrollPane1);
        initData();
    }
    private void showTable(){
        Object[] obj = new BangDiemTheoMon().toColumn();
        if(obj != null){
        DefaultTableModel model = new DefaultTableModel(obj,0);
        table1.setModel(model);
            initTable(this.list);
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

        jPanel = new com.raven.swing.PanelTransparent();
        cbxKy = new com.raven.swing.combobox.Combobox();
        cbxNganh = new com.raven.swing.combobox.Combobox();
        cbxMon = new com.raven.swing.combobox.Combobox();
        btnPreview = new com.raven.swing.button.Button();
        btnExport = new com.raven.swing.button.Button();
        txtMin = new com.raven.swing.textfield.TextField();
        jLabel1 = new javax.swing.JLabel();
        txtMax = new com.raven.swing.textfield.TextField();
        btnLoc = new com.raven.swing.button.Button();
        pnTable = new com.raven.swing.PanelTransparent();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();

        setOpaque(false);

        jPanel.setOpaque(true);

        cbxKy.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxKyItemStateChanged(evt);
            }
        });

        cbxNganh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxNganhItemStateChanged(evt);
            }
        });

        cbxMon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMonItemStateChanged(evt);
            }
        });
        cbxMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMonActionPerformed(evt);
            }
        });

        btnPreview.setText("Preview");
        btnPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviewActionPerformed(evt);
            }
        });

        btnExport.setText("Export ");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel1.setText("To");

        btnLoc.setText("Loc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxNganh, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(cbxKy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxMon, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(btnPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPreview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pnTable.setOpaque(true);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout pnTableLayout = new javax.swing.GroupLayout(pnTable);
        pnTable.setLayout(pnTableLayout);
        pnTableLayout.setHorizontalGroup(
            pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnTableLayout.setVerticalGroup(
            pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTableLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviewActionPerformed
        // TODO add your handling code here:
        pnTable.setVisible(false);
        
        showTable();
        pnTable.setVisible(true);
    }//GEN-LAST:event_btnPreviewActionPerformed

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
            cbxMon.addItem("Tất Cả");
            for(QuanLyMon mon : listMons){
                cbxMon.addItem(mon);
            }
        }
        
    }//GEN-LAST:event_cbxKyItemStateChanged

    private void cbxNganhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxNganhItemStateChanged
        // TODO add your handling code here:
        QuanLyKy ky =(QuanLyKy) cbxKy.getSelectedItem();
        QuanLyNganh nganh = (QuanLyNganh) cbxNganh.getSelectedItem();
        
        if(ky != null && nganh != null){
            List<QuanLyMon> listMons = this.monService.getMonTheoNganh(nganh.getId(),ky.getId());
            cbxMon.removeAllItems();
            if(!listMons.isEmpty()){
                cbxMon.addItem("Tất Cả");
                for(QuanLyMon mon : listMons){
                    cbxMon.addItem(mon);
                }
            }
        }

    }//GEN-LAST:event_cbxNganhItemStateChanged

    private void cbxMonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMonItemStateChanged
        // TODO add your handling code here:
        QuanLyKy ky =(QuanLyKy) cbxKy.getSelectedItem();
        QuanLyNganh nganh = (QuanLyNganh) cbxNganh.getSelectedItem();
        if(cbxMon.getSelectedIndex() == 0){
            if(ky != null && nganh != null){
             list = this.diemService.thongKeDiemTaCaMon(nganh.getId(), ky.getId(),null,null);
            }
        } else{
            QuanLyMon mon = (QuanLyMon) cbxMon.getSelectedItem();
            if(mon!= null){
            list = this.diemService.thongKeDiemTheoMon(mon.getId(),nganh.getId(),ky.getId(),null,null);
            }
        }
    }//GEN-LAST:event_cbxMonItemStateChanged

    private void cbxMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbxMonActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser("C:\\Users\\Nguyen Duy Hung\\OneDrive\\Documents\\Export Java File");
        fileChooser.showSaveDialog(this);
        File saveFile = fileChooser.getSelectedFile();
        if(saveFile != null){
            FileOutputStream fos = null;
            try {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook workbook = new SXSSFWorkbook();
                Sheet sheet = workbook.createSheet("Bang Diem");
                Row rowCol = sheet.createRow(0);
                for(int i = 0 ; i < table1.getColumnCount(); i++){
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(table1.getColumnName(i));
                    
                }   for(int i = 0; i < table1.getRowCount(); i++){
                    Row row =sheet.createRow(i+1);
                    for(int j = 0 ; j < table1.getColumnCount(); j++){
                        Cell cell = row.createCell(j);
                        if(table1.getValueAt(i, j) != null)
                        {
                            cell.setCellValue(table1.getValueAt(i, j).toString());
                        }
                    }
                }   
                fos = new FileOutputStream(new File(saveFile.toString()));
                workbook.write(fos);
                workbook.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ThongKeDiemPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ThongKeDiemPanel.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if(fos != null)
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(ThongKeDiemPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "That Bai");
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        // TODO add your handling code here:
        QuanLyKy ky =(QuanLyKy) cbxKy.getSelectedItem();
        QuanLyNganh nganh = (QuanLyNganh) cbxNganh.getSelectedItem();
        float min = Float.valueOf(txtMin.getText());
        float max = Float.valueOf(txtMax.getText());
        if(cbxMon.getSelectedIndex() == 0){
            if(ky != null && nganh != null){
             list = this.diemService.thongKeDiemTaCaMon(nganh.getId(), ky.getId(),(double)min,(double)max);
            }
        } else{
            QuanLyMon mon = (QuanLyMon) cbxMon.getSelectedItem();
            if(mon!= null){
            list = this.diemService.thongKeDiemTheoMon(mon.getId(),nganh.getId(),ky.getId(),null,null);
            }
        }
        showTable();
    }//GEN-LAST:event_btnLocActionPerformed
    private void initData(){
        initCombobox();
        txtMax.setLabelText("Max");
        txtMin.setLabelText("Min");
    }
    private void initCombobox(){
        List<QuanLyNganh> listNganhs = this.nganhService.findAll1();
        cbxNganh.setLabeText("Ngành Học");
        if(!listNganhs.isEmpty()){
            for(QuanLyNganh nganh : listNganhs){
                cbxNganh.addItem(nganh);
            }
        }
        List<QuanLyMon> listMons = this.monService.findAll();
        
        cbxMon.setLabeText("Môn Học");
//        if(!listMons.isEmpty()){
//            for(QuanLyMon mon : listMons){
//                cbxMon.addItem(mon);
//            }
//        }
        List<QuanLyKy> listKys = this.kyService.findAll();
        cbxKy.setLabeText("Kỳ Học");
        for(QuanLyKy ky : listKys){
            cbxKy.addItem(ky);
        }
    }
    private void initTable(List<BangDiemTheoMon> list){
        if(cbxMon.getSelectedIndex() != 0){
            QuanLyMon mon = (QuanLyMon) cbxMon.getSelectedItem();
            QuanLyKy ky = (QuanLyKy) cbxKy.getSelectedItem();
            if(mon!= null){
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                model.setNumRows(0);
                for(BangDiemTheoMon b : list){
                    SinhVienView sinhVienView = this.sinhVienService.findById(b.getIdSv());
                    Lop lop = this.lopService.findById(b.getIdLop());
                    Object[] obj = new Object[]{
                        table1.getModel().getRowCount()+ 1,
                        mon.getTen(),
                        mon.getMa(),
                        ky.getTen()+ " " + ky.getNam(),
                        sinhVienView.getHoTen(),

                        sinhVienView.getMa(),
                        lop.getTenLop(),
                        mon.getTinChi(),
                        b.getDiemTB()
                    };
                    table1.addRow(obj);
                }
            }
        } else{
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                model.setNumRows(0);
                QuanLyKy ky = (QuanLyKy) cbxKy.getSelectedItem();
                for(BangDiemTheoMon b : list){
                    SinhVienView sinhVienView = this.sinhVienService.findById(b.getIdSv());
                    Lop lop = this.lopService.findById(b.getIdLop());
                    QuanLyMon mon = this.monService.findOne(b.getIdMon());
                    Object[] obj = new Object[]{
                        table1.getModel().getRowCount()+ 1,
                        mon.getTen(),
                        mon.getMa(),
                        ky.getTen()+ " " + ky.getNam(),
                        sinhVienView.getHoTen(),

                        sinhVienView.getMa(),
                        lop.getTenLop(),
                        mon.getTinChi(),
                        b.getDiemTB(),
                        b.getTrangThai()
                    };
                    table1.addRow(obj);
                }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.button.Button btnExport;
    private com.raven.swing.button.Button btnLoc;
    private com.raven.swing.button.Button btnPreview;
    private com.raven.swing.combobox.Combobox cbxKy;
    private com.raven.swing.combobox.Combobox cbxMon;
    private com.raven.swing.combobox.Combobox cbxNganh;
    private javax.swing.JLabel jLabel1;
    private com.raven.swing.PanelTransparent jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.PanelTransparent pnTable;
    private com.raven.swing.table.Table table1;
    private com.raven.swing.textfield.TextField txtMax;
    private com.raven.swing.textfield.TextField txtMin;
    // End of variables declaration//GEN-END:variables
}
