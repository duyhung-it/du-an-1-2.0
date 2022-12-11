package com.raven.form;

import com.nhomsau.domainmodel.SinhVien;
import com.nhomsau.repository.INganhRepository;
import com.nhomsau.repository.ISinhVienRepository;
import com.nhomsau.repository.impl.NganhRepository;
import com.nhomsau.repository.impl.SinhVienRepository;
import com.nhomsau.service.ISinhVienService;
import com.nhomsau.service.impl.SinhVienService;
import com.nhomsau.util.CheckLogin;
import com.nhomsau.viewmodel.LoginModel;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;

public class FormThongTinSv extends javax.swing.JPanel {

    ISinhVienService iSinhVienService;
    ISinhVienRepository iSinhVienRepository;
    List<SinhVien> lists;
    private LoginModel modelLogin;
    private INganhRepository iNganhRepository;
    Form_DoiMatKhau doiMatKhau;
    public FormThongTinSv() {
        initComponents();
        doiMatKhau = new Form_DoiMatKhau();
        panelTransparent1.add(doiMatKhau);
        setOpaque(false);
        iSinhVienService = new SinhVienService();
        iSinhVienRepository = new SinhVienRepository();
        iNganhRepository=new NganhRepository();
        if (CheckLogin.isLogin()) {
            modelLogin = CheckLogin.loginModel;
        }
        lists = new ArrayList<>();
        txtDiaChi.setLabelText("Địa Chỉ");
        txtEmail.setLabelText("EMail");
        txtHoTen.setLabelText("Họ Và Tên");
        txtMa.setLabelText("Mã Cá Nhân");
        txtNgaySinh.setLabelText("Ngày Sinh");
        txtSdt.setLabelText("SDT");
        txtGioiTinh.setLabelText("Giới tính");
        txtNganh.setLabelText("Ngành");
        ThongTinCaNhan();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new com.raven.swing.table.Table();
        pnThongTin = new com.raven.swing.PanelTransparent();
        jLabel2 = new javax.swing.JLabel();
        button1 = new com.raven.swing.button.Button();
        jPanel1 = new javax.swing.JPanel();
        txtMa = new com.raven.swing.textfield.TextField();
        txtHoTen = new com.raven.swing.textfield.TextField();
        txtNgaySinh = new com.raven.swing.textfield.TextField();
        jLabel3 = new javax.swing.JLabel();
        txtGioiTinh = new com.raven.swing.textfield.TextField();
        jPanel2 = new javax.swing.JPanel();
        txtEmail = new com.raven.swing.textfield.TextField();
        txtDiaChi = new com.raven.swing.textfield.TextField();
        txtSdt = new com.raven.swing.textfield.TextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNganh = new com.raven.swing.textfield.TextField();
        pnDoiMatKhau = new com.raven.swing.PanelTransparent();
        button2 = new com.raven.swing.button.Button();
        panelTransparent1 = new com.raven.swing.PanelTransparent();

        table2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table2);

        setLayout(new java.awt.CardLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel2.setText("Thông tin cá nhân");

        button1.setText("Doi mat khau");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtMa.setEditable(false);

        txtHoTen.setEditable(false);

        txtNgaySinh.setEditable(false);

        jLabel3.setText("Thông tin cá nhân");

        txtGioiTinh.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtEmail.setEditable(false);
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtDiaChi.setEditable(false);

        txtSdt.setEditable(false);

        jLabel5.setText("Thông tin liên hê");

        txtNganh.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNganh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
        pnThongTin.setLayout(pnThongTinLayout);
        pnThongTinLayout.setHorizontalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinLayout.createSequentialGroup()
                .addGap(0, 206, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnThongTinLayout.setVerticalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(pnThongTin, "card2");

        button2.setText("<Tro lai");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnDoiMatKhauLayout = new javax.swing.GroupLayout(pnDoiMatKhau);
        pnDoiMatKhau.setLayout(pnDoiMatKhauLayout);
        pnDoiMatKhauLayout.setHorizontalGroup(
            pnDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoiMatKhauLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTransparent1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDoiMatKhauLayout.createSequentialGroup()
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(723, Short.MAX_VALUE))))
        );
        pnDoiMatKhauLayout.setVerticalGroup(
            pnDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoiMatKhauLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(pnDoiMatKhau, "card3");
    }// </editor-fold>//GEN-END:initComponents
    private void ThongTinCaNhan() {
        lists = iSinhVienRepository.findAll3(modelLogin.getIdUser());
        //SinhVienView sv=new SinhVienView();
        if (lists != null) {
            for (SinhVien sv : lists) {
                txtDiaChi.setText(sv.getDiaChi());
                txtEmail.setText(sv.getEmail());
                txtHoTen.setText(sv.getHoTen());
                txtMa.setText(sv.getMa());
                txtNgaySinh.setText(sv.getNgaySinh() + "");
                txtSdt.setText(sv.getSdt());
                txtGioiTinh.setText(sv.getNgaySinh() + "");
                if (sv.isGioiTinh()) {
                    txtGioiTinh.setText("Nam");
                } else {
                    txtGioiTinh.setText("Nữ");
                }
            }
        }
            if(modelLogin.getIdNganh() != null)
            txtNganh.setText(iNganhRepository.findTen(modelLogin.getIdNganh()));

    }
    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
           
           panelTransparent1.setVisible(false);
           panelTransparent1.removeAll();
           panelTransparent1.add(doiMatKhau);
           panelTransparent1.repaint();
           panelTransparent1.setVisible(true);
           CardLayout layout = (CardLayout) this.getLayout();
           layout.last(this);
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) this.getLayout();
        layout.first(this);
    }//GEN-LAST:event_button2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.button.Button button1;
    private com.raven.swing.button.Button button2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.swing.PanelTransparent panelTransparent1;
    private com.raven.swing.PanelTransparent pnDoiMatKhau;
    private com.raven.swing.PanelTransparent pnThongTin;
    private com.raven.swing.table.Table table2;
    private com.raven.swing.textfield.TextField txtDiaChi;
    private com.raven.swing.textfield.TextField txtEmail;
    private com.raven.swing.textfield.TextField txtGioiTinh;
    private com.raven.swing.textfield.TextField txtHoTen;
    private com.raven.swing.textfield.TextField txtMa;
    private com.raven.swing.textfield.TextField txtNganh;
    private com.raven.swing.textfield.TextField txtNgaySinh;
    private com.raven.swing.textfield.TextField txtSdt;
    // End of variables declaration//GEN-END:variables
}
