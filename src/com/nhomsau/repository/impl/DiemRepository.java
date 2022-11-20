/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.BangDiem;
import com.nhomsau.domainmodel.Diem;
import com.nhomsau.repository.IDiemRepository;
import com.nhomsau.util.DBConnection;
import com.nhomsau.viewmodel.BangDiemTheoMon;
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
public class DiemRepository implements IDiemRepository {

    @Override
    public List<BangDiemTheoMon> thongKeDiemTheoMon(String idMon,String idKy,String idNganh,Float min,Float max) {
        String sql = "{call proc_diem_trung_binh_theo_mon(?,?,?,?,?)}";
        List<BangDiemTheoMon> listResults = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromProc(sql, idMon,idKy,idNganh,min,max);
            while(rs.next()){
                String idSv = rs.getString("IdSinhVien");
                String idLop = rs.getString("IdLop");
                double diemTB = rs.getDouble("DiemTrungBinh");
                BangDiemTheoMon bangDiemTheoMon = new BangDiemTheoMon(idSv, idLop, diemTB);
                listResults.add(bangDiemTheoMon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiemRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResults;
    }
    
    @Override
    public List<BangDiemTheoMon> thongKeDiemTatCaMon(String idNganh,String idKy,Double min, Double max){
        StringBuilder sql = new StringBuilder();
        sql.append("select Diem.IdSinhVien  ,SinhVien_Lop.IdLop 'IdLop',Diem.IdMonHoc, Sum(Diem.Diem * DauDiem_Mon.HeSo/100) 'DiemTrungBinh'");
        sql.append(" from Diem ");
        sql.append("join DauDiem_Mon on DauDiem_Mon.IdDauDiem = Diem.IdDauDiem and Diem.IdMonHoc = DauDiem_Mon.IdMon ");
        sql.append("join SinhVien_Lop on SinhVien_Lop.IdSinhVien = Diem.IdSinhVien ");
        sql.append("join Users on users.Id = Diem.IdSinhVien ");
        sql.append("join Ky_Mon on Ky_Mon.IdMon = Diem.IdMonHoc ");
        sql.append(" where users.IdNganh = ? and Ky_Mon.IdKy = ? ");
        sql.append("group by Diem.IdSinhVien  ,SinhVien_Lop.IdLop ,Diem.IdMonHoc");
        List<BangDiemTheoMon> listResults = new ArrayList<>();
        try {
            ResultSet rs = null;
            if(max != null && min != null){
            sql.append(" having Sum(Diem.Diem * DauDiem_Mon.HeSo/100) between ? and ?");
            rs = DBConnection.getDataFromQuery(sql.toString(),idNganh,idKy,min,max);
            }
            else{
                rs = DBConnection.getDataFromQuery(sql.toString(),idNganh,idKy );
            }
            while(rs.next()){
                String idSv = rs.getString("IdSinhVien");
                String idLop = rs.getString("IdLop");
                double diemTB = rs.getDouble("DiemTrungBinh");
                String idMonHoc = rs.getString("IdMonHoc");
                BangDiemTheoMon bangDiemTheoMon = new BangDiemTheoMon(idSv, idLop, diemTB);
                bangDiemTheoMon.setIdMon(idMonHoc);
                listResults.add(bangDiemTheoMon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiemRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResults;
    }
    
    final String sql="select TenDauDiem, Diem from Diem join DauDiem on Diem.IdDauDiem = DauDiem.Id where IdMonHoc = ? and IdSinhVien = '519f74ea-e199-4da0-aaa6-a2e6e3f49a2f'";
    @Override
    public List<BangDiem> getDiem(String idsv,String idMon){
        List<BangDiem> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql,idMon);
            while(rs.next()){
                String tenDiem = rs.getString(1);
                double diem = Double.valueOf(rs.getBigDecimal(2)+"");
                BangDiem b = new BangDiem(tenDiem, diem);
                list.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiemRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    DBConnection dBConnection;
    final String Insert_Sql = "insert into Diem (IdSinhVien,IdMonHoc,IdDauDiem,Diem,NgayNhap) values(?,?,?,?,getdate())";
    final String Select_Diem = "select Diem from Diem where IdSinhVien = ? and IdMonHoc = ? and IdDauDiem = ?";
    final String Update = "update Diem set Diem = ?, NgaySua = getdate() where idSinhVien = ? and IdMonHoc = ? and IdDauDiem = ?";
    final String select_sv = "select * from diem where idSinhVien = ? and IdMonHoc = ? and IdDauDiem = ?";
    
    public DiemRepository() {
        dBConnection = new DBConnection();
    }

    public float getDiem(String idSV, String idMonHoc, String idDauDiem) {
        float diem = 0;
        try {
            ResultSet rs = dBConnection.getDataFromQuery(Select_Diem, idSV, idMonHoc, idDauDiem);
            while (rs.next()) {
                diem = rs.getFloat("Diem");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return diem;
    }

    public int saveDiem(Diem d){
        int kq = DBConnection.ExcuteDungna(Insert_Sql, d.getIdSV(), d.getIdMonHoc(), d.getIdDauDiem(), d.getDiem());
        if(kq == 1){
            return 1;
        }else{
            return -1;
        }
    }
    
    public int updateDiem(Diem d){
        int kq = dBConnection.ExcuteDungna(Update, d.getDiem(), d.getIdSV(),d.getIdMonHoc(),d.getIdDauDiem());
        if(kq == 1){
            return 1;
        }else{
            return -1;
        }
    }
    
    public int checkSV(String idSV,String idMonHoc,String idDauDiem){
        
        try {
            ResultSet rs = dBConnection.getDataFromQuery(select_sv, idSV,idMonHoc,idDauDiem);
            if(rs.next()){
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiemRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
