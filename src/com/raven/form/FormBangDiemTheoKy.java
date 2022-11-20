/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.nhomsau.domainmodel.BangDiem;
import com.nhomsau.viewmodel.QuanLyKy;
import com.nhomsau.viewmodel.QuanLyMon;
import com.nhomsau.repository.impl.DiemRepository;
import com.nhomsau.repository.IKyRepository;
import com.nhomsau.repository.impl.KyRepository;
import com.nhomsau.service.impl.DiemService;
import com.nhomsau.service.IDiemService;
import com.nhomsau.service.IKyService;
import com.nhomsau.service.IMonService;
import com.nhomsau.service.impl.KyService;
import com.nhomsau.service.impl.MonService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class FormBangDiemTheoKy extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    DefaultComboBoxModel cbx;
    IKyService iKyService;
    IMonService iMonService;
    IDiemService iDiemService;
    List<QuanLyKy> li;
    DefaultTableModel model;
    List<BangDiem> list;
    public FormBangDiemTheoKy() {
        initComponents();
        model = (DefaultTableModel) tbDiem.getModel();
        iKyService = new KyService();
        iMonService = new MonService();
        iDiemService=new DiemService();
        li = new ArrayList<>();
        cbcKy.setLabeText("Ky");
        cbxMon.setLabeText("Mon");
        getAllKy();
  //      loadTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDiem = new com.raven.swing.table.Table();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panelTransparent1 = new com.raven.swing.PanelTransparent();
        cbxMon = new com.raven.swing.combobox.Combobox();
        cbcKy = new com.raven.swing.combobox.Combobox();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblMon.setText("1: COM107");

        tbDiem.setBackground(new java.awt.Color(255, 255, 255));
        tbDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Tên đầu điểm", "Điểm", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbDiem);

        jLabel5.setText("1/5");

        jButton1.setText("Prev");

        jButton2.setText("Next");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addContainerGap())
        );

        panelTransparent1.setOpaque(true);

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

        cbcKy.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbcKyItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbcKy, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(cbxMon, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbcKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void getAllKy() {
        cbx = (DefaultComboBoxModel) cbcKy.getModel();
        cbx.removeAllElements();
        List<QuanLyKy> list = iKyService.findAll();
        li = iKyService.findAll();
        for (QuanLyKy k : list) {
            cbx.addElement(k);
        }
    }

   
    private void loadTable(){
        QuanLyMon mon1 = (QuanLyMon) cbxMon.getSelectedItem();
        model.setNumRows(0);
        if(mon1!= null){
        list = new DiemRepository().getDiem("",mon1.getId() );
        
        for(BangDiem b : list){
            Object[] obj = new Object[]{
                tbDiem.getRowCount()+1,
                b.getTenDauDiem(),
                b.getDiem(),
                b.getGhiCHu()
            };
            tbDiem.addRow(obj);
        }
        }
    }

    private void cbxMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMonActionPerformed
       

    }//GEN-LAST:event_cbxMonActionPerformed

    private void cbxMonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMonItemStateChanged
        // TODO add your handling code here:
        QuanLyMon mon1 = (QuanLyMon) cbxMon.getSelectedItem();
        loadTable();
        // TODO add your handling code here:
        if(mon1!= null)
        lblMon.setText(mon1.getTen());
    }//GEN-LAST:event_cbxMonItemStateChanged

    private void cbcKyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbcKyItemStateChanged
        // TODO add your handling code here:
        QuanLyKy k = (QuanLyKy) cbcKy.getSelectedItem();
        if (k != null) {
            System.out.println(k.getTen());
        }
        List<QuanLyMon> lists = this.iMonService.findMon(k.getId());
        cbxMon.removeAllItems();
        if (!lists.isEmpty()) {
            for (QuanLyMon mo : lists) {
                cbxMon.addItem(mo);
            }

        }
    }//GEN-LAST:event_cbcKyItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.combobox.Combobox cbcKy;
    private com.raven.swing.combobox.Combobox cbxMon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMon;
    private com.raven.swing.PanelTransparent panelTransparent1;
    private com.raven.swing.table.Table tbDiem;
    // End of variables declaration//GEN-END:variables
}
