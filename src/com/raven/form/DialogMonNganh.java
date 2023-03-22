/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.raven.form;

import com.nhomsau.domainmodel.KyMon;
import com.nhomsau.domainmodel.MonNganh;
import com.nhomsau.domainmodel.Nganh;
import com.nhomsau.repository.IMonNganhRepository;
import com.nhomsau.repository.IMonRepository;
import com.nhomsau.repository.INganhRepository;
import com.nhomsau.repository.impl.MonNganhRepository;
import com.nhomsau.repository.impl.MonRepository;
import com.nhomsau.repository.impl.NganhRepository;
import com.nhomsau.service.IMonService;
import com.nhomsau.service.INganhService;
import com.nhomsau.service.impl.MonService;
import com.nhomsau.service.impl.NganhService;
import com.nhomsau.viewmodel.QuanLyNganh;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HaTanBinh
 */
public class DialogMonNganh extends javax.swing.JDialog {

    /**
     * Creates new form DialogMonNganh
     */
    IMonService iMonService;
    IMonNganhRepository iMonNganhRepository;
    INganhService iNganhService;
    List<MonNganh> list;
    DefaultTableModel model;
    IMonRepository iMonRepository;
    DefaultComboBoxModel cbx;
    INganhRepository iNganhRepository;
    private Nganh nganh;
    public DialogMonNganh(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        iMonService = new MonService();
        iNganhService = new NganhService();
        iMonRepository = new MonRepository();
        iNganhRepository = new NganhRepository();
        iMonNganhRepository = new MonNganhRepository();
        list = new ArrayList<>();       
//        findAllNganh();
    }

    public Nganh getNganh() {
        return nganh;
    }

    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
        loadTable();
        loadTable1();
    }

//    public void findAllNganh() {
//        cbx = (DefaultComboBoxModel) cbxNganh.getModel();
//        cbx.removeAllElements();
//        List<QuanLyNganh> list = this.iNganhService.findAll1();
//        for (QuanLyNganh nganh : list) {
//            cbx.addElement(nganh);
//        }
//        
//    }

    private void loadTable() {
        model = (DefaultTableModel) tbMonCo.getModel();
        String id = "";
        if(nganh != null){
            id = this.iNganhRepository.findIdNganh(nganh.getMaNganh());
            list = iMonNganhRepository.findMonNganh(id);
        model.setRowCount(0);
        for (MonNganh mn : list) {
            model.addRow(new Object[]{iMonRepository.getTenMonNganh(mn.getMaMon())});
            System.out.println(mn.getMaNganh());
        }
        }
        
    }

    private void loadTable1() {
        model = (DefaultTableModel) tbMonKhong.getModel();
        if(nganh != null){
            list = iMonNganhRepository.findMonNganh1(nganh.getId());
            model.setRowCount(0);
            for (MonNganh mn : list) {
                model.addRow(new Object[]{iMonRepository.getTenMonNganh(mn.getMaMon())});
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMonCo = new com.raven.swing.table.Table();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMonKhong = new com.raven.swing.table.Table();
        txtMon = new javax.swing.JTextField();
        btnThem = new com.raven.swing.button.Button();
        btnXoa = new com.raven.swing.button.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbMonCo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "tên môn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMonCo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMonCoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMonCo);

        tbMonKhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Môn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMonKhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMonKhongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbMonKhong);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtMon.setEditable(false);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMon, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(txtMon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbMonKhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMonKhongMouseClicked
        // TODO add your handling code here:
        //int index=tbMonKhong.getSelectedRow();
       // txtMon.setText(tbMonKhong.getValueAt(index, 1).toString());
        
    }//GEN-LAST:event_tbMonKhongMouseClicked

    private void tbMonCoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMonCoMouseClicked
        // TODO add your handling code here:
       // int index=tbMonCo.getSelectedRow();
       // txtMon.setText(tbMonKhong.getValueAt(index, 1).toString());
        
    }//GEN-LAST:event_tbMonCoMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        int selectRow = tbMonKhong.getSelectedRow();
        if(nganh != null)
        if (selectRow >= 0) {
            txtMon.setText(tbMonKhong.getValueAt(selectRow, 0).toString());
            String idMon = this.iMonRepository.getIdByName(tbMonKhong.getValueAt(selectRow, 0).toString());
            MonNganh mn=new MonNganh(idMon,nganh.getId());
            this.iMonNganhRepository.insert(mn);
            loadTable();
            loadTable1();
            txtMon.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Bạn cần chọn 1 dòng trên bảng Môn chưa có!");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int selectRow = tbMonCo.getSelectedRow();
        if(nganh != null)
        if (selectRow >= 0) {
            String idMon = this.iMonRepository.getIdByName(tbMonKhong.getValueAt(selectRow, 0).toString());
            MonNganh mn=new MonNganh(idMon, nganh.getId());
            int kq = JOptionPane.showConfirmDialog(this, "Xác Nhận", "Xóa", JOptionPane.YES_NO_OPTION);
            if (kq == JOptionPane.YES_OPTION) {
                this.iMonNganhRepository.delete(mn);
                JOptionPane.showMessageDialog(this,"Xóa thành công");
                loadTable();
                loadTable1();
            }else{
                JOptionPane.showMessageDialog(this,"Xóa không thành công");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn cần chọn 1 dòng trên bảng Môn đã có!");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DialogMonNganh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogMonNganh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogMonNganh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogMonNganh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogMonNganh dialog = new DialogMonNganh(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.button.Button btnThem;
    private com.raven.swing.button.Button btnXoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.swing.table.Table tbMonCo;
    private com.raven.swing.table.Table tbMonKhong;
    private javax.swing.JTextField txtMon;
    // End of variables declaration//GEN-END:variables
}