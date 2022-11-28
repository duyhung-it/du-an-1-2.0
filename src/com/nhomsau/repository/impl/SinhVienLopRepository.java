/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.ModelSinhVienLop;
import com.nhomsau.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class SinhVienLopRepository {
    public void insert(String sv, String lop){
        String sql = "INSERT INTO SinhVien_Lop VALUES(?,?)";
        DBConnection.ExcuteDungna(sql, sv,lop);
    }
    private Connection con;

    public SinhVienLopRepository() {
        con = DBConnection.openDbConnection();
    }

    public List<ModelSinhVienLop> danhSinhVienLop() {
        List<ModelSinhVienLop> ds = new ArrayList<>();
        String sql = "select IdSinhVien,IdLop,MaUser,MaLop from SinhVien_Lop join Lop on Lop.Id=SinhVien_Lop.IdLop\n"
                + "join Users on Users.Id=SinhVien_Lop.IdSinhVien";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idSV = rs.getString("IdSinhVien");
                String idLop = rs.getString("IdLop");
                String maSV = rs.getString("MaUser");
                String maLop = rs.getString("MaLop");
                ModelSinhVienLop a = new ModelSinhVienLop();
                a.setIdSinhVien(idSV);
                a.setIdLop(idLop);
                a.setMaLop(maLop);
                a.setMaSinhVien(maSV);
                ds.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;
    }

    public Boolean themSinhVienLop(ModelSinhVienLop a) {
        int check = 0;
        String sql = "INSERT INTO SinhVien_Lop(IdSinhVien,IdLop) VALUES (?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, a.getIdSinhVien());
            ps.setString(2, a.getIdLop());
            check = ps.executeUpdate();
            return check > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void xoaSinhVienLop(ModelSinhVienLop a) {
        String sql = "DELETE FROM SinhVien_Lop WHERE IdSinhVien=? and IdLop=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, a.getIdSinhVien());
            ps.setString(2, a.getIdLop());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public Boolean suaSinhVienLop(ModelSinhVienLop a) {
        int check = 0;
        String sql = "UPDATE SinhVien_Lop SET IdSinhVien=?,IdLop=? WHERE IdSinhVien=? and IdLop=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, a.getIdSinhVien());
            ps.setString(2, a.getIdLop());
            ps.setString(3, a.getIdSinhVienCu());
            ps.setString(4, a.getIdLopCu());
            check = ps.executeUpdate();
            return check > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
