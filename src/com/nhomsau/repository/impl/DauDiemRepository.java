/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.DauDiem;
import com.nhomsau.domainmodel.DauDiemMon;
import com.nhomsau.repository.IDauDiemRepository;
import com.nhomsau.util.DBConnection;
import com.nhomsau.viewmodel.QuanLyMon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Duy Hung
 */
public class DauDiemRepository implements IDauDiemRepository {


    @Override
    public List<DauDiem> findAll() {
        String sql = "SELECT * FROM Mon";
        List<DauDiem> listResults = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql);
            while(rs.next()){
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                listResults.add(new DauDiem(id, ma, ten));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResults;
    }

    @Override
    public void insert(DauDiem dd) {
        String sql = "Insert into DauDiem (MaDauDiem,TenDauDiem) values(?,?)";
        DBConnection.ExcuteDungna(sql, dd.getMaDauDiem(),dd.getTenDauDiem());
    }

    @Override
    public void delete(DauDiem dd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    final String Select_DauDiem = "select DauDiem.Id,MaDauDiem,TenDauDiem\n"
            + "from DauDiem join DauDiem_Mon on DauDiem.Id = DauDiem_Mon.IdDauDiem\n"
            + "where IdMon = ?";
    final String Select_IdDauDiem = "select Id from DauDiem where TenDauDiem = ?";
    DBConnection dBConnection;
    public DauDiemRepository() {
        dBConnection = new DBConnection();
        
    }
    
    public List<DauDiem> getDauDiems(String idMon){
        List<DauDiem> listDauDiems = new ArrayList<>();
        try {
            ResultSet rs = dBConnection.getDataFromQuery(Select_DauDiem, idMon);
            while (rs.next()) {                
                DauDiem dauDiem = mapingDauDiem(rs);
                listDauDiems.add(dauDiem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDauDiems;
    }
    
    public String getIdDauDiem(String tenDauDiem){
        String idDauDiem = "";
        try {
            ResultSet rs = dBConnection.getDataFromQuery(Select_IdDauDiem, tenDauDiem);
            while (rs.next()) {    
                idDauDiem = rs.getString("Id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idDauDiem;
    }
    
    private DauDiem mapingDauDiem(ResultSet rs){
        try {
            if(rs != null){
                String id = rs.getString("Id");
                String maDauDiem = rs.getNString("MaDauDiem");
                String tenDauDiem = rs.getNString("TenDauDiem");
                return new DauDiem(id, maDauDiem, tenDauDiem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
