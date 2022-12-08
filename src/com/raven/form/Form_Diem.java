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
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
        cbxMon.setLabeText("Môn");
        cbxLop.setLabeText("Lớp");
        fillAllKy();
    }

    private void fillAllKy() {
        cbxKy.setLabeText("Kỳ");
        List<QuanLyKy> lstKy = kyRepository.findAll();
        for (QuanLyKy ky : lstKy) {
            cbxKy.addItem(ky);
        }
    }

    private String getIdMon() {
        QuanLyMon mon = (QuanLyMon) cbxMon.getSelectedItem();
        return mon.getId();
    }

    private String getIdLop() {
        QuanLyLop lop = (QuanLyLop) cbxLop.getSelectedItem();
        return lop.getIdLop();
    }

    private void save() {
        int row = tblDiem.getRowCount();
        int column = tblDiem.getColumnCount();

        QuanLyLop lop = (QuanLyLop) cbxLop.getSelectedItem();

        for (int i = 3; i < column - 1; i++) {
            String dauDiem = tblDiem.getColumnName(i);
            String idDauDiem = dauDiemRepository.getIdDauDiem(dauDiem);
            for (int j = 0; j < row; j++) {
                String maSV = tblDiem.getValueAt(j, 1).toString();
                String idSV = sinhVienRepository.getIdSV(maSV);

                Object diemOb = tblDiem.getValueAt(j, i);
                System.out.println(tblDiem.getValueAt(j, 4));
                String diemString = null;
                if (diemOb == null) {
                    diemString = Integer.MAX_VALUE + "";
                } else {
                    diemString = diemOb.toString();
                }

                float diemTbl = 0;
                try {
                    diemTbl = Float.valueOf(diemString);
                    if(diemTbl == Integer.MAX_VALUE){
                        continue;
                    }
                    if (diemTbl < 0 || diemTbl > 10) {
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

                    if (checkSV == 1) {
                        diemRepository.updateDiem(diem);
                    } else {
                        diemRepository.saveDiem(diem);
                    }
                }
            }
        }

        initColumn(getIdMon(), "D6142D6A-3F1A-4537-A680-45CA60029170", getIdLop());
    }

    private void initColumn(String idMon, String idNganh, String idLop) {
        List<DauDiem> listDauDiem = this.dauDiemRepository.findDauDiemByMon(idMon, idNganh);
        model.setColumnCount(3);
        model.setNumRows(0);

        if (!listDauDiem.isEmpty()) {
            List<SinhVien> listSinhVien = this.sinhVienRepository.getSinhViens(idLop);
            Double[] diemTrungBinh = new Double[listSinhVien.size()];

            Arrays.fill(diemTrungBinh, 0.0);
            for (SinhVien sv : listSinhVien) {
                tblDiem.addRow(new Object[]{
                    model.getRowCount() + 1, sv.getMa(), sv.getHoTen()
                });
            }
            for (DauDiem d : listDauDiem) {
                Object[] object = new Object[listSinhVien.size()];

                List<QuanLyDiem> listDiem = this.diemRepository.getDiemByMon(d.getIdDauDiem(), idMon, idLop);
                float heSo = dauDiem_MonRepository.getHeSo(d.getIdDauDiem(), idMon);
                int j = 0;
                if (!listDiem.isEmpty()) {
                    for (int i = 0; i < listSinhVien.size(); i++) {
                        if (listSinhVien.get(i).getId().equals(listDiem.get(j).getIdUser())) {
                            object[i] = listDiem.get(j).getDiem();
                            double diem = 0;
                            try {
                                diem = Double.valueOf(listDiem.get(j).getDiem() + "");

                            } catch (NumberFormatException e) {
                                diem = 0;
                            }
                            diemTrungBinh[i] += (diem * heSo / 100);
                            j++;
                            if (j >= listDiem.size()) {
                                break;
                            }
                        }
                    }
                }

                model.addColumn(d, object);

            }
            model.addColumn("Điểm tb", diemTrungBinh);
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
        btnImport = new com.raven.swing.button.Button();
        btnExport = new com.raven.swing.button.Button();
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
                "STT", "MaSV", "HoTen"
            }
        ));
        tblDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDiemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDiem);

        btnImport.setText("Import (Excel)");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        btnExport.setText("Export (Excel)");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTransparent2Layout = new javax.swing.GroupLayout(panelTransparent2);
        panelTransparent2.setLayout(panelTransparent2Layout);
        panelTransparent2Layout.setHorizontalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
            .addGroup(panelTransparent2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTransparent2Layout.setVerticalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(0, 56, Short.MAX_VALUE))
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
        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu bảng điểm không?", "Lưu",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            save();
            JOptionPane.showMessageDialog(this, "Lưu thành công");
        }
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

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        // TODO add your handling code here:
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelJtableImport = null;

        String duongDan = "E:\\FPt\\Ki_4\\excel";
        JFileChooser excelFileChooser = new JFileChooser(duongDan);
        int excelChooser = excelFileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = excelFileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);

                excelJtableImport = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelJtableImport.getSheetAt(0);

                for (int row = 1; row < excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);
                    for (int column = 3; column < excelRow.getLastCellNum() - 1; column++) {
                        XSSFCell excelCell = excelRow.getCell(column);

                        Object diemOb = tblDiem.getValueAt(row - 1, column);
                        
//                        String diemString = null;
//                        if (diemOb == null) {
//                            diemString = "0";
//                        } else {
//                            diemString = diemOb.toString();
//                        }
                        
                        if(excelCell != null){
                            System.out.println(diemOb);
                            System.out.println(excelCell.toString());
                            if(diemOb != null){
                            if(!Objects.equals(Double.valueOf(diemOb + ""), Double.valueOf(excelCell.toString()))){
                                tblDiem.setValueAt(excelCell, row - 1, column);
                            }
                            }else{
                                tblDiem.setValueAt(excelCell, row - 1, column);
                            }
                        }
                        
                    }
                }
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    }//GEN-LAST:event_btnImportActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser("E:\\FPt\\Ki_4\\excel");
        fileChooser.showSaveDialog(this);
        File saveFile = fileChooser.getSelectedFile();
        if (saveFile != null) {
            FileOutputStream fos = null;
            try {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook workbook = new SXSSFWorkbook();
                Sheet sheet = workbook.createSheet("Bang Diem");
                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblDiem.getColumnCount() - 1; i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblDiem.getColumnName(i));

                }
                for (int i = 0; i < tblDiem.getRowCount(); i++) {
                    Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < tblDiem.getColumnCount(); j++) {
                        Cell cell = row.createCell(j);
                        if (tblDiem.getValueAt(i, j) != null) {
                            cell.setCellValue(tblDiem.getValueAt(i, j).toString());
                        }
                    }
                }
                fos = new FileOutputStream(new File(saveFile.toString()));
                workbook.write(fos);
                workbook.close();
                this.openFile(saveFile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ThongKeDiemPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ThongKeDiemPanel.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ThongKeDiemPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "That Bai");
        }
    }//GEN-LAST:event_btnExportActionPerformed
    private void openFile(File file){
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(ThongKeDiemPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void tblDiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDiemMouseClicked
        // TODO add your handling code here:
        Point p = evt.getPoint();
        System.out.println(tblDiem.rowAtPoint(p));
        System.out.println(tblDiem.columnAtPoint(p));
    }//GEN-LAST:event_tblDiemMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.button.Button btnExport;
    private com.raven.swing.button.Button btnImport;
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
