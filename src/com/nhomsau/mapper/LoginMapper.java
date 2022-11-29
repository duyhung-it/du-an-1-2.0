/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.mapper;

import com.nhomsau.viewmodel.LoginModel;
import com.nhomsau.viewmodel.SinhVienView;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Duy Hung
 */
public class LoginMapper {
    public LoginModel mapRowView(ResultSet rs){
        if(rs != null){
            try {
                String id = rs.getString(1);
                String hoTen = rs.getString("HoTen");
                String ma = rs.getString("MaUser");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                String diaChi = rs.getString("DiaChi");
                Date ngaySinh = rs.getDate("NgaySinh");
                String email = rs.getString("Email");
                String sdt = rs.getString("SDT");
                String idNganh = rs.getString("idNganh");
                String password = rs.getString("MatKhau");
                int chucVu = rs.getInt("ChucVu");
                LoginModel loginModel = new LoginModel(id, ma, hoTen, gioiTinh, ngaySinh, email, sdt, password, idNganh, chucVu);
                return loginModel;
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
