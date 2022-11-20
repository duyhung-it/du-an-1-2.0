/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.mapper;

import com.nhomsau.domainmodel.SinhVien;
import com.nhomsau.viewmodel.SinhVienView;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
/**
 *
 * @author Nguyen Duy Hung
 */
public class SinhVienMapper {
    public SinhVienView mapRowView(ResultSet rs){
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
                String tenNganh = rs.getString("TenNganh");
                SinhVienView sv = new SinhVienView(ma, hoTen, ngaySinh, diaChi, email, sdt, tenNganh);
                sv.setId(id);
                sv.setGioiTinh(gioiTinh);
                return sv;
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    public SinhVien mapRowDomain(ResultSet rs){
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
                SinhVien sv = new SinhVien(ma, hoTen, gioiTinh,ngaySinh, diaChi, email, sdt, "");
                sv.setId(id);
                return sv;
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    public SinhVien toDomainModel(SinhVienView viewModel){
        if(viewModel != null){
            SinhVien result = new SinhVien();
            result.setDiaChi(viewModel.getDiaChi());
            result.setEmail(viewModel.getEmail());
            result.setGioiTinh(viewModel.isGioiTinh());
            result.setHoTen(viewModel.getHoTen());
            result.setIdNganh(viewModel.getIdNganh());
            result.setMa(viewModel.getMa());
            result.setNgaySinh(viewModel.getNgaySinh());
            result.setSdt(viewModel.getSDT());
            return result;
        }
        return null;
    }
}
