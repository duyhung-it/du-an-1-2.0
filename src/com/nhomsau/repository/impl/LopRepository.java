/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.Lop;
import com.nhomsau.mapper.LopMapper;
import com.nhomsau.repository.ILopRepository;
import com.nhomsau.util.DBConnection;
import com.nhomsau.viewmodel.QuanLyLop;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nguyen Duy Hung
 */
public class LopRepository implements ILopRepository{
    private final LopMapper mapper;

    public LopRepository() {
        this.mapper = new LopMapper();
    }
    
    @Override
    public Lop findById(String id) {
        List<Lop> listResult = new ArrayList<>();
        String sql = "Select * from Lop where Id = ?";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, id);
            while(rs.next()) listResult.add(this.maping(rs));
           
        } catch (SQLException ex) {
            Logger.getLogger(LopRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResult.isEmpty() ? null : listResult.get(0);
    }

    @Override
    public List<QuanLyLop> findAll() {
        String sql = Select_All_SQL;
        List<QuanLyLop> list = new ArrayList<>();
            
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql);
            while(rs.next() ){
                list.add(mapper.mapRow(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void insert(Lop lop) {
        String sql = "INSERT INTO Lop(MaLop,TenLop,IdGiaoVien,IdMon) VALUES (?,?,?,?,?)";
        DBConnection.ExcuteDungna(sql, lop.getMaLop(),lop.getTenLop(),lop.getIdGiaoVien(),lop.getIdMonHoc());
    }

    @Override
    public void update(Lop lop) {
        StringBuilder sql = new StringBuilder("UPDATE Lop SET ");
        sql.append("MaLop = ?, TenLop = ?, IdGiaoVien = ?,IdMon =? WHERE Id = ?");
        DBConnection.ExcuteDungna(sql.toString(), lop.getMaLop(),lop.getTenLop(),lop.getIdGiaoVien(),lop.getIdMonHoc());
    }

    @Override
    public void delete(String idLop) {
        String sql = "DELETE FROM Lop WHERE Id = ?";
        DBConnection.ExcuteDungna(sql, idLop);
    }
    final String Select_All_SQL = "select * from Lop";
    final String Select_All_Ten_SQL = "select * from Lop where TenLop like ?";
    final String Select_Ten_SQL = "select Id from Lop where TenLop like '%?%'";


    public List<Lop> getAllLop() {
        List<Lop> lops = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(Select_All_SQL);
            while (rs.next()) {
                Lop lop = maping(rs);
                lops.add(lop);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lops;
    }

    public Lop getLop(String tenLop) {
        Lop lop = new Lop();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(Select_All_Ten_SQL, tenLop);
            while (rs.next()) {
                lop = maping(rs);
            }
        } catch (Exception e) {
            System.out.println("1");
            e.printStackTrace();
        }
        return lop;
    }
    
    public String getIdLop(String tenLop){
        String idLop = "";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(Select_Ten_SQL, tenLop);
            while (rs.next()) {       
                idLop = rs.getString("Id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idLop;
    }

    private Lop maping(ResultSet rs) {
        try {
            if (rs != null) {
                String id = rs.getString("Id");
                String maLop = rs.getNString("MaLop");
                String tenLop = rs.getNString("TenLop");
                String idGiaoVien = rs.getString("IdGiaoVien");
                String idMon = rs.getString("IdMon");
                return new Lop(id, maLop, tenLop, idGiaoVien, idMon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public QuanLyLop findByMa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<QuanLyLop> findByTen(String ten) {
        List<QuanLyLop> lops = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(Select_All_Ten_SQL,"%"+ten+"%");
            while (rs.next()) {
                QuanLyLop lop = mapper.mapRow(rs);
                lops.add(lop);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lops;
    }
}
