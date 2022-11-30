/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.SinhVien;
import com.nhomsau.mapper.SinhVienMapper;
import com.nhomsau.repository.ISinhVienRepository;
import com.nhomsau.util.DBConnection;
import com.nhomsau.viewmodel.SinhVienView;
import java.sql.Date;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nguyen Duy Hung
 */
public class SinhVienRepository implements ISinhVienRepository{
    private final SinhVienMapper mapper;


    public SinhVienRepository() {
        this.mapper = new SinhVienMapper();
    }
    
    @Override
    public List<SinhVienView> findAll() {
        String sql = "{call proc_danh_sach_sinh_vien(null)}";
        List<SinhVienView> listResults = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromProc(sql);
            while(rs.next()){
                listResults.add(mapper.mapRowView(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResults;
    }
    public static void main(String[] args) {
        System.out.println(new SinhVienRepository().findAll().get(0));
    }

    @Override
    public List<SinhVien> findAll2() {
        String sql = "select * from users where ChucVu = ?";
        List<SinhVien> listResults = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql,1);
            while(rs.next()){
                listResults.add(mapper.mapRowDomain(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResults;
    }

    @Override
    public SinhVienView findById(String id) {
        String sql = "{call proc_danh_sach_sinh_vien(?)}";
        List<SinhVienView> listResults = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromProc(sql,id);
            while(rs.next()){
                listResults.add(mapper.mapRowView(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResults.isEmpty() ? null : listResults.get(0);
    }

    @Override
    public void insert(SinhVien s) {
        String sql ="INSERT INTO [dbo].[Users]([MaUser],[HoTen],[GioiTinh],[NgaySinh],[DiaChi],[Email],[SDT],[ChucVu],[IdNganh],[MatKhau])" +
                    " VALUES (?,?,?,?,?,?,?,?,?,?)";
        DBConnection.ExcuteDungna(sql,s.getMa(),s.getHoTen(),s.isGioiTinh(),s.getNgaySinh(),
                                    s.getDiaChi(),s.getEmail(),s.getSdt(),1,s.getIdNganh(),"123");
    }

    @Override
    public void update(SinhVien s) {
        StringBuilder sql = new StringBuilder("UPDATE [dbo].[Users] ");
        sql.append("set HoTen = ?, GioiTinh = ?, NgaySinh = ?,");
        sql.append("DiaChi = ?, Email = ?, SDT = ? where MaUser = ?");
        DBConnection.ExcuteDungna(sql.toString(),s.getHoTen(),s.isGioiTinh(),s.getNgaySinh(),
                                    s.getDiaChi(),s.getEmail(),s.getSdt(),s.getMa());
    }

    @Override
    public void delete(String ma) {
        String sql = "DELETE FROM [dbo].[Users] where MaUser = ? ";
        DBConnection.ExcuteDungna(sql, ma);
    }

    @Override
    public SinhVienView findByMa(String ma) {
        StringBuilder sql = new StringBuilder();
        sql.append("select u.Id,u.MaUser,u.HoTen,u.GioiTinh,u.NgaySinh,u.DiaChi,u.Email,u.SDT,n.TenNganh ");
        sql.append("from Users as u,Nganh as n ");
        sql.append("where u.IdNganh = n.Id and u.ChucVu = 1 and u.MaUser = ? ");
        sql.append("order by u.MaUser");
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql.toString(),ma);
            while(rs.next()){
                return mapper.mapRowView(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    DBConnection dBConnection;
    final String Select_SinhVien_SQl = "select Id,MaUser,HoTen,GioiTinh,NgaySinh,DiaChi,Email,SDT,MatKhau,ChucVu,IdNganh,IdNguoitao\n"
            + "from Users join SinhVien_Lop on Users.Id = SinhVien_Lop.IdSinhVien\n"
            + "where IdLop = ? order by HoTen";
    final String select_idSV = "select Id from Users where MaUser = ?";
    public List<SinhVien> getSinhViens(String idLop){
        List<SinhVien> listSinhViens = new ArrayList<>();
        try {
            ResultSet rs = dBConnection.getDataFromQuery(Select_SinhVien_SQl, idLop);
            while (rs.next()) {                
                SinhVien sinhVien = maping(rs);
                listSinhViens.add(sinhVien);
            }
        } catch (Exception e) {
            System.out.println("1");
            e.printStackTrace();
        }
        return listSinhViens;
    }
    
    public String getIdSV(String maSV){
        String idSV = "";
        try {
            ResultSet rs = dBConnection.getDataFromQuery(select_idSV, maSV);
            while (rs.next()) {                
                idSV = rs.getString("Id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idSV;
    }
    
    private SinhVien maping(ResultSet rs){
        try {
            if(rs != null){
                String id =rs.getString("Id");
                String ma = rs.getNString("MaUser");
                String hoTen = rs.getNString("HoTen");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String diaChi = rs.getNString("DiaChi");
                String email = rs.getNString("Email");
                String SDT = rs.getNString("SDT");
                String matKhau = rs.getNString("MatKhau");
                int chucVu = rs.getInt("ChucVu");
                String idNganh = rs.getString("IdNganh");
                String idNguoiTao = rs.getString("IdNguoiTao");
                return new SinhVien(id, ma, hoTen, gioiTinh, ngaySinh, diaChi, email, SDT, matKhau, idNganh, idNguoiTao);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("1");
        }
        return null;
    }

    @Override
    public List<SinhVienView> thongKeDanhSachSinhVien(String idKy, String idNganh, String idMon) {
        return null;
    }
}
