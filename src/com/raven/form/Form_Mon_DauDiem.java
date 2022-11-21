package com.raven.form;

import com.nhomsau.domainmodel.DauDiem;
import com.nhomsau.service.IDauDiemService;
import com.nhomsau.service.IMonService;
import com.nhomsau.service.impl.DauDiemService;
import com.nhomsau.service.impl.MonService;
import com.nhomsau.viewmodel.QuanLyMon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class Form_Mon_DauDiem extends javax.swing.JPanel {

    private final IMonService iMonService;
    private final IDauDiemService iDauDiemService;
    
    private final List<DauDiem> dsDauDiem;
    private final List<QuanLyMon> dsMon;
    
    public Form_Mon_DauDiem() {
        initComponents();
        setOpaque(false);   
        
        iMonService = new MonService();
        iDauDiemService = new DauDiemService();
        
        dsDauDiem = iDauDiemService.findAll();
        cbxDauDiem.setModel(new DefaultComboBoxModel(dsDauDiem.toArray()));
        
        dsMon = iMonService.findAll();
        cbxMon.setModel(new DefaultComboBoxModel(dsMon.toArray()));
        
        cbxMon.setLabeText("Môn");
        cbxDauDiem.setLabeText("Đầu điểm");
        txtHeSo.setLabelText("HeSo");
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
        btnSua = new com.raven.swing.button.Button();
        btnXoa = new com.raven.swing.button.Button();

        btnThem.setText("Thêm");

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

        btnSua.setText("Sửa");

        btnXoa.setText("Xóa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxMon, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtHeSo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxDauDiem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)))
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxDauDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txtHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.button.Button btnSua;
    private com.raven.swing.button.Button btnThem;
    private com.raven.swing.button.Button btnXoa;
    private com.raven.swing.combobox.Combobox cbxDauDiem;
    private com.raven.swing.combobox.Combobox cbxMon;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.table.Table tbl_dd_mon;
    private com.raven.swing.textfield.TextField txtHeSo;
    // End of variables declaration//GEN-END:variables
}
