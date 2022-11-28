package com.nhomsau.view;

import com.nhomsau.service.IManageLecturerService;
import com.nhomsau.service.IManageMajorService;
import com.nhomsau.service.IManageManagerService;
import com.nhomsau.service.impl.ManageLecturerService;
import com.nhomsau.service.impl.ManageMajorService;
import com.nhomsau.service.impl.ManageManagerService;
import com.nhomsau.util.MessageInfo;
import com.nhomsau.util.Validatetor;
import com.nhomsau.viewmodel.ManageLecturer;
import com.nhomsau.viewmodel.ManageMajor;
import com.nhomsau.viewmodel.ManageManager;
import com.raven.form.*;
import com.raven.dialog.Message;
import com.raven.main.Main;
import com.raven.model.ModelCard;
import com.raven.model.ModelStudent;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import com.raven.swing.table.EventAction;
import java.awt.Color;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class Form_Lecturers extends javax.swing.JPanel {

    private final IManageMajorService _manageMajor;
    private final IManageManagerService _manageManager;
    private final IManageLecturerService _manageLecturer;
    private Validatetor validatetor;
    DefaultTableModel tblModel;
    List<ManageManager> listManagers;
    List<ManageMajor> listMajor;

    public Form_Lecturers() {
        initComponents();
        tblLecturers.fixTable(jScrollPane1);
        setOpaque(false);
        initData();
        _manageMajor = new ManageMajorService();
        _manageManager = new ManageManagerService();
        _manageLecturer = new ManageLecturerService();
        validatetor = new Validatetor();

        txtMaGV.setLabelText("  Mã giảng viên");
        txtHoTenGV.setLabelText("   Họ tên");
        txtDiaChi.setLabelText("    Địa chỉ");
        txtEmailGV.setLabelText("   Email");
        txtSDTGV.setLabelText(" Số điện thoại");
        txtMatKhauGV.setLabelText(" Mật khẩu");
        cbbMajors.setLabeText("    Ngành đào tạo");
        cbbManager.setLabeText("   Người tạo");
        listMajor = _manageMajor.findAll();
        listManagers = _manageManager.findAll();
        loadDataLecturersToTable();
        loadDataMajorToCBB();
        loadDataManagerToCBB();
    }

    private void loadDataLecturersToTable() {
        List<ManageLecturer> lists = _manageLecturer.findAll();
        tblModel = (DefaultTableModel) tblLecturers.getModel();
        tblModel.setRowCount(0);
        for (ManageLecturer lucturer : lists) {
            tblModel.addRow(new Object[]{lucturer.getCode(),
                lucturer.getFullname(),
                lucturer.getGender() == 1 ? "Nam" : "Nữ",
                validatetor.getDateDD(lucturer.getdOB()),
                lucturer.getAddress(),
                lucturer.getEmail(),
                lucturer.getPhone(),
                lucturer.getPassword(),
                lucturer.getMajor(),
                lucturer.getManager()});
        }

    }

    private void loadDataMajorToCBB() {
        cbbMajors.setModel(new DefaultComboBoxModel(listMajor.toArray()));
        cbbMajors.setSelectedIndex(-1);
    }

    private void loadDataManagerToCBB() {
        cbbManager.setModel(new DefaultComboBoxModel(listManagers.toArray()));
        cbbManager.setSelectedIndex(-1);
    }

    private void initData() {
        initCardData();
        initNoticeBoard();
        initTableData();
    }

    private void initTableData() {
//        EventAction eventAction = new EventAction() {
//            @Override
//            public void delete(ModelStudent student) {
//                showMessage("Delete Student : " + student.getName());
//            }
//
//            @Override
//            public void update(ModelStudent student) {
//                showMessage("Update Student : " + student.getName());
//            }
//        };
    }

    private void initCardData() {
//        Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PEOPLE, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
//        card1.setData(new ModelCard("New Student", 5100, 20, icon1));
//        Icon icon2 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.MONETIZATION_ON, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
//        card2.setData(new ModelCard("Income", 2000, 60, icon2));
//        Icon icon3 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.SHOPPING_BASKET, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
//        card3.setData(new ModelCard("Expense", 3000, 80, icon3));
//        Icon icon4 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.BUSINESS_CENTER, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
//        card4.setData(new ModelCard("Other Income", 550, 95, icon4));
    }

    private void initNoticeBoard() {
//        noticeBoard.addDate("04/10/2021");
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(94, 49, 238), "Hidemode", "Now", "Sets the hide mode for the component. If the hide mode has been specified in the This hide mode can be overridden by the component constraint."));
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(218, 49, 238), "Tag", "2h ago", "Tags the component with metadata name that can be used by the layout engine. The tag can be used to explain for the layout manager what the components is showing, such as an OK or Cancel button."));
//        noticeBoard.addDate("03/10/2021");
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(32, 171, 43), "Further Reading", "12:30 PM", "There are more information to digest regarding MigLayout. The resources are all available at www.migcomponents.com"));
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(50, 93, 215), "Span", "10:30 AM", "Spans the current cell (merges) over a number of cells. Practically this means that this cell and the count number of cells will be treated as one cell and the component can use the space that all these cells have."));
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(27, 188, 204), "Skip ", "9:00 AM", "Skips a number of cells in the flow. This is used to jump over a number of cells before the next free cell is looked for. The skipping is done before this component is put in a cell and thus this cells is affected by it. \"count\" defaults to 1 if not specified."));
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(238, 46, 57), "Push", "7:15 AM", "Makes the row and/or column that the component is residing in grow with \"weight\". This can be used instead of having a \"grow\" keyword in the column/row constraints."));
//        noticeBoard.scrollToTop();
    }

    private void showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelTransparent1 = new com.raven.swing.PanelTransparent();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLecturers = new com.raven.swing.table.Table();
        jLabel5 = new javax.swing.JLabel();
        txtMaGV = new com.raven.swing.textfield.TextField();
        txtHoTenGV = new com.raven.swing.textfield.TextField();
        jLabel1 = new javax.swing.JLabel();
        txtDiaChi = new com.raven.swing.textfield.TextField();
        txtEmailGV = new com.raven.swing.textfield.TextField();
        txtSDTGV = new com.raven.swing.textfield.TextField();
        txtMatKhauGV = new com.raven.swing.textfield.TextField();
        rdoNam = new com.raven.swing.radio_button.RadioButtonCustom();
        rdoNu = new com.raven.swing.radio_button.RadioButtonCustom();
        jLabel2 = new javax.swing.JLabel();
        cbbMajors = new com.raven.swing.combobox.Combobox();
        cbbManager = new com.raven.swing.combobox.Combobox();
        jPanel1 = new javax.swing.JPanel();
        btnCapNhatGV = new com.raven.swing.button.Button();
        btnTaoMoiGV = new com.raven.swing.button.Button();
        btnLuuGV = new com.raven.swing.button.Button();
        btnXoaGV = new com.raven.swing.button.Button();

        panelTransparent1.setTransparent(0.5F);

        tblLecturers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Họ tên", "Giới tính", "Ngày sinh", "Địa chỉ", "Email", "Số điện thoại", "Mật khẩu", "Ngành đào tạo", "Người tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLecturers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLecturersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLecturers);

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Danh sách giảng viên");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(69, 759, Short.MAX_VALUE))))
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setText("Ngày sinh");

        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel2.setText("Giới tính");

        cbbMajors.setSelectedIndex(-1);
        cbbMajors.setSelectedItem("null");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCapNhatGV.setText("Cập nhật");
        btnCapNhatGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatGVActionPerformed(evt);
            }
        });

        btnTaoMoiGV.setText("Tạo mới");
        btnTaoMoiGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoiGVActionPerformed(evt);
            }
        });

        btnLuuGV.setText("Lưu thông tin");
        btnLuuGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuGVActionPerformed(evt);
            }
        });

        btnXoaGV.setText("Xóa thông tin");
        btnXoaGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhatGV, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuuGV, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoMoiGV, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnLuuGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCapNhatGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoaGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTaoMoiGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoTenGV, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtEmailGV, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDTGV, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatKhauGV, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbMajors, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbManager, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txtMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdoNu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtHoTenGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(cbbMajors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(cbbManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel1)
                                .addGap(12, 12, 12)
                                .addComponent(txtEmailGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSDTGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMatKhauGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoMoiGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiGVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTaoMoiGVActionPerformed

    private void btnCapNhatGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatGVActionPerformed
        int rowSelected = tblLecturers.getSelectedRow();
        if (rowSelected < 0) {
            MessageInfo.msgWarning("Vui lòng chọn giảng viên cần cập nhật");
            return;
        }
        String code = tblLecturers.getValueAt(rowSelected, 0).toString();
        ManageLecturer lecturer = inputLecturer();
        boolean isResult = _manageLecturer.updateLecturer(lecturer);
        if (isResult) {
            MessageInfo.msgTrue("Cập nhật thành công");
        } else {
            MessageInfo.msgFalse("Cập nhật thất bại");
        }
        loadDataLecturersToTable();
        clearForm();
    }//GEN-LAST:event_btnCapNhatGVActionPerformed

    private void tblLecturersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLecturersMouseClicked
        int row = tblLecturers.getSelectedRow();
        if (row < 0) {
            return;
        }
        String code = tblLecturers.getValueAt(row, 0).toString();
        String fullname = tblLecturers.getValueAt(row, 1).toString();
        String gender = tblLecturers.getValueAt(row, 2).toString();
        String dOBstr = tblLecturers.getValueAt(row, 3).toString();
        String address = tblLecturers.getValueAt(row, 4).toString();
        String phone = tblLecturers.getValueAt(row, 6).toString();
        String email = tblLecturers.getValueAt(row, 5).toString();
        String password = tblLecturers.getValueAt(row, 7).toString();
        ManageManager manager = (ManageManager) tblLecturers.getValueAt(row, 9);
        ManageMajor major = (ManageMajor) tblLecturers.getValueAt(row, 8);
        txtMaGV.setText(code);
        txtHoTenGV.setText(fullname);
        if (gender.equalsIgnoreCase("Nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        Date dOB = validatetor.getDateDDStr(dOBstr);
        txtDiaChi.setText(address);
        txtSDTGV.setText(phone);
        txtEmailGV.setText(email);
        txtMatKhauGV.setText(password);
        int index = findIndexCBBManager(manager.getCode());
        cbbManager.setSelectedIndex(index);
        int indexMajor = findIndexCBBMajor(major.getCode());
        cbbMajors.setSelectedIndex(indexMajor);
//        cbbManager.setSelectedIndex(1);
//        cbbManager.setSelectedItem(manager);
//        for (int i = 0; i < listManagers.size(); i++) {
//            System.out.println(i + "-" + listManagers.get(i).getCode());
//            System.out.println(manager.getCode());
//            if (manager.getCode().equalsIgnoreCase(listManagers.get(i).getCode())) {
//                cbbManager.setSelectedIndex(i);
//                break;
//            }
//        }

    }//GEN-LAST:event_tblLecturersMouseClicked

    private void btnLuuGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuGVActionPerformed
        ManageLecturer manageLecturer = inputLecturer();
        if (manageLecturer != null) {
            if (_manageLecturer.findByCode(manageLecturer.getCode()) != null) {
                MessageInfo.msgWarning("Mã giáo viên đã tồn tại");
                txtMaGV.requestFocus();
                return;
            }
            if (_manageLecturer.insert(manageLecturer) == true) {
                MessageInfo.msgTrue("Thêm okw");
            } else {
                MessageInfo.msgTrue("ohh! Noooo");
            }
            loadDataLecturersToTable();
            clearForm();
        }
    }//GEN-LAST:event_btnLuuGVActionPerformed

    private void btnXoaGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGVActionPerformed
        int rowSelected = tblLecturers.getSelectedRow();
        if (rowSelected < 0) {
            MessageInfo.msgWarning("Vui lòng chọn giảng viên cần xóa");
            return;
        }
        if (MessageInfo.question("Bạn có muốn xóa không?")) {
            String code = tblLecturers.getValueAt(rowSelected, 0).toString();
            boolean isResult = _manageLecturer.deleteLec(code);
            if (isResult) {
                MessageInfo.msgTrue("Xóa thành công");
            } else {
                MessageInfo.msgFalse("Xóa thất bại");
            }
            loadDataLecturersToTable();
            clearForm();
        }
    }//GEN-LAST:event_btnXoaGVActionPerformed

    private int findIndexCBBManager(String code) {
        if (code == null) {
            return -1;
        }
        int total = listManagers.size();
        for (int i = 0; i < total; i++) {
//            ManageManager category = (ManageManager) this.cbbManager.getItemAt(i);
            if (code.equalsIgnoreCase(listManagers.get(i).getCode())) {
                return i;
            }
        }
        return -1;
    }

    private int findIndexCBBMajor(String code) {
        if (code == null) {
            return -1;
        }
        int total = listMajor.size();
        for (int i = 0; i < total; i++) {
//            ManageManager category = (ManageManager) this.cbbManager.getItemAt(i);
            if (code.equalsIgnoreCase(listMajor.get(i).getCode())) {
                return i;
            }
        }
        return -1;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.button.Button btnCapNhatGV;
    private com.raven.swing.button.Button btnLuuGV;
    private com.raven.swing.button.Button btnTaoMoiGV;
    private com.raven.swing.button.Button btnXoaGV;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.raven.swing.combobox.Combobox cbbMajors;
    private com.raven.swing.combobox.Combobox cbbManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.PanelTransparent panelTransparent1;
    private com.raven.swing.radio_button.RadioButtonCustom rdoNam;
    private com.raven.swing.radio_button.RadioButtonCustom rdoNu;
    private com.raven.swing.table.Table tblLecturers;
    private com.raven.swing.textfield.TextField txtDiaChi;
    private com.raven.swing.textfield.TextField txtEmailGV;
    private com.raven.swing.textfield.TextField txtHoTenGV;
    private com.raven.swing.textfield.TextField txtMaGV;
    private com.raven.swing.textfield.TextField txtMatKhauGV;
    private com.raven.swing.textfield.TextField txtSDTGV;
    // End of variables declaration//GEN-END:variables

    private ManageLecturer inputLecturer() {
        String code = validatetor.kiemTraRong(txtMaGV, "Mã giảng viên trống");
        if (code == null) {
            return null;
        }
        String fullname = validatetor.kiemTraRong(txtHoTenGV, "Họ tên giảng viên trống");
        if (fullname == null) {
            return null;
        }
//        Date dOB = validatetor.getDateYYYY(dchNgaySinhGV.getDate());
        String address = validatetor.kiemTraRong(txtDiaChi, "Vui lòng nhập địa chỉ!");
        if (address == null) {
            return null;
        }
        String phone = validatetor.kiemTraSoDienThoai(txtSDTGV, "Số điện thoại không đúng định dạng!");
        if (phone == null) {
            return null;
        }
        String email = validatetor.kiemTraEmail(txtEmailGV, "Địa chỉ email không đúng định dạng!");
        if (email == null) {
            return null;
        }
        String password = validatetor.kiemTraRong(txtMatKhauGV, "Vui lòng nhập mật khẩu");
        if (password == null) {
            return null;
        }
        ManageManager manager = (ManageManager) cbbManager.getSelectedItem();
        ManageMajor major = (ManageMajor) cbbMajors.getSelectedItem();

        int role = 2;
        int gender = rdoNam.isSelected() ? 0 : 1;
        return null;
//        return new ManageLecturer(code, fullname, gender, dOB, address, email, phone, password, role, manager, major);
    }

    private void clearForm() {
        txtMaGV.setText("");
        txtHoTenGV.setText("");
        txtEmailGV.setText("");
        txtDiaChi.setText("");
        txtSDTGV.setText("");
        txtMatKhauGV.setText("");
        rdoNam.isSelected();
        cbbMajors.setSelectedIndex(-1);
        cbbManager.setSelectedIndex(-1);
        tblLecturers.clearSelection();
    }

}
