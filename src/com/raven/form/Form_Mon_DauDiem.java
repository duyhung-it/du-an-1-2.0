package com.raven.form;

import com.nhomsau.domainmodel.DauDiem;
import com.nhomsau.domainmodel.DauDiemMon;
import com.nhomsau.service.IDauDiemService;
import com.nhomsau.service.IDauDiem_MonService;
import com.nhomsau.service.IMonService;
import com.nhomsau.service.impl.DauDiemService;
import com.nhomsau.service.impl.DauDiem_MonService;
import com.nhomsau.service.impl.MonService;
import com.nhomsau.viewmodel.QuanLyMon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_Mon_DauDiem extends javax.swing.JPanel {

    private final IMonService iMonService;
    private final IDauDiemService iDauDiemService;
    private final IDauDiem_MonService iDauDiem_MonService;
    
    private List<DauDiem> dsDauDiem;
    private final List<QuanLyMon> dsMon;
    private List<DauDiemMon> dsDauDiem_Mon;
    
    private DefaultTableModel model;
    
    public Form_Mon_DauDiem() {
        initComponents();
        setOpaque(false);   
        
        iMonService = new MonService();
        iDauDiemService = new DauDiemService();
        iDauDiem_MonService = new DauDiem_MonService();
        
        dsMon = iMonService.findAll();
        cbxMon.setModel(new DefaultComboBoxModel(dsMon.toArray()));
        
        dsDauDiem_Mon = iDauDiem_MonService.findAll();
        
        model = (DefaultTableModel) tbl_dd_mon.getModel();
        
        cbxMon.setLabeText("Môn");
        cbxDauDiem.setLabeText("Đầu điểm");

        loadDauDiem();
//        System.out.println(iMonService.getTenMon(dsDauDiem_Mon.get(1).getIdMon()));
        loadTable();
    }
    
    private void loadTable(){
        dsDauDiem_Mon = iDauDiem_MonService.findAll();
        model.setRowCount(0);
        for (DauDiemMon dd : dsDauDiem_Mon) {
            model.addRow(new Object[] {
                iMonService.getTenMon(dd.getIdMon()),
                iDauDiemService.getTenDauDiem(dd.getIdDauDiem()),
                dd.getHeSo()
            });
        }
    }
    
    
    private void loadDauDiem(){
        String id = getIdMon();
        dsDauDiem = iDauDiemService.findDauDiemByIdMon(id);
        cbxDauDiem.setModel(new DefaultComboBoxModel(dsDauDiem.toArray()));
        
    }
    
    private String getIdMon(){
        QuanLyMon mon = (QuanLyMon) cbxMon.getSelectedItem();
        return mon.getId();
    }
    
    private String getIdDauDiem(){
        DauDiem dd = (DauDiem) cbxDauDiem.getSelectedItem();
        return dd.getIdDauDiem();
    }
    
    private DauDiemMon validateDauDiem(){
        String idMon = getIdMon();
        String idDauDiem = getIdDauDiem();
        int heSo = -1;
        try {
            heSo = Integer.parseInt(txtHeSo.getText());
            if(heSo < 0){
                JOptionPane.showMessageDialog(this, "Hệ số không được âm");
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hệ số phải là số");
            return null;
        }
        return new DauDiemMon(idDauDiem, idMon, heSo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnThem = new com.raven.swing.button.Button();
        cbxMon = new com.raven.swing.combobox.Combobox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dd_mon = new com.raven.swing.table.Table();
        cbxDauDiem = new com.raven.swing.combobox.Combobox();
        txtHeSo = new com.raven.swing.textfield.TextField();
        btnXoa = new com.raven.swing.button.Button();

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        cbxMon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMonItemStateChanged(evt);
            }
        });

        tbl_dd_mon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Môn", "Đầu điểm", "Hệ số"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_dd_mon);

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxMon, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxDauDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDauDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxMonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMonItemStateChanged
        // TODO add your handling code here:
        loadDauDiem();
    }//GEN-LAST:event_cbxMonItemStateChanged

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        DauDiemMon dd = validateDauDiem();
        if(dd != null){
            iDauDiem_MonService.insert(dd);
            JOptionPane.showMessageDialog(this, "Thành công");
            loadTable();
            loadDauDiem();
        }else{
            JOptionPane.showMessageDialog(this, "Thất bại");
        }
        txtHeSo.setText("");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = tbl_dd_mon.getSelectedRow();
        if(row >= 0){
            String id = dsDauDiem_Mon.get(row).getIdDauDiem();
            String idMon = dsDauDiem_Mon.get(row).getIdMon();
            if(JOptionPane.showConfirmDialog(this, "Có muốn xóa không?", "Xóa", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
                iDauDiem_MonService.delete(id, idMon);
                loadDauDiem();
                loadTable();
            }
            txtHeSo.setText("");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Mon_DauDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Mon_DauDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Mon_DauDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Mon_DauDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Mon_DauDiem().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.button.Button btnThem;
    private com.raven.swing.button.Button btnXoa;
    private com.raven.swing.combobox.Combobox cbxDauDiem;
    private com.raven.swing.combobox.Combobox cbxMon;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.table.Table tbl_dd_mon;
    private com.raven.swing.textfield.TextField txtHeSo;
    // End of variables declaration//GEN-END:variables
}
