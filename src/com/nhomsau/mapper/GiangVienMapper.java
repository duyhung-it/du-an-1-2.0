/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.mapper;

import com.nhomsau.viewmodel.QuanLyGiangVien;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nguyen Duy Hung
 */
public class GiangVienMapper {
    public QuanLyGiangVien mapRow(ResultSet rs){
        if(rs!= null){
            try {
                String id = rs.getString(1);
                String hoTen = rs.getString("HoTen");
                String ma = rs.getString("MaUser");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                String diaChi = rs.getString("DiaChi");
                Date ngaySinh = rs.getDate("NgaySinh");
                String email = rs.getString("Email");
                String sdt = rs.getString("SDT");
                String idNganh = rs.getString("IdNganh");
                return new QuanLyGiangVien(id, idNganh, hoTen, gioiTinh, ngaySinh, diaChi, email, sdt, idNganh);
            } catch (SQLException ex) {
                Logger.getLogger(GiangVienMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
