/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.Nganh;
import com.nhomsau.mapper.NganhMapper;
import com.nhomsau.repository.INganhRepository;
import com.nhomsau.util.DBConnection;
import com.nhomsau.viewmodel.QuanLyNganh;
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
public class NganhRepository implements INganhRepository {
    private final NganhMapper mapper;

    public NganhRepository() {
        this.mapper = new NganhMapper();
    }
    
    @Override
    public List<QuanLyNganh> findAll1() {
        String sql = "SELECT * FROM Nganh";
        List<QuanLyNganh> listResults = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql);
            while(rs.next()){
                listResults.add(mapper.mapRow(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NganhRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResults;
    }

    @Override
    public QuanLyNganh findOne(String idNganh) {
        String sql = "SELECT * FROM Nganh where Id = ?";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql,idNganh);
            while(rs.next()) return mapper.mapRow(rs);
        } catch (SQLException ex) {
            Logger.getLogger(MonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    String insert_sql = "insert into nganh (id,manganh,tennganh) values (newid(),?,?)";
    String update_sql = "update nganh set manganh=?,tennganh=? where id=?";
    String delete_sql = "delete from nganh where id=?";
    String select_sql_all = "select * from nganh";
    List<Nganh> listNganh;


    public List<Nganh> findAll() {
          listNganh=new ArrayList<>();
        try {
            ResultSet rs=DBConnection.getDataFromQuery(select_sql_all);
            while (rs.next()) {                
                listNganh.add(mapping(rs));
            }
            return listNganh;
        } catch (SQLException ex) {
            Logger.getLogger(NganhRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Nganh mapping(ResultSet rs) {
        if (rs != null) {
            try {
                String id = rs.getString("id");
                String maNganh=rs.getString("maNganh");
                String tenNganh=rs.getString("tennganh");
                return new Nganh(id, maNganh, tenNganh);
            } catch (SQLException ex) {
                Logger.getLogger(NganhRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    public boolean save(Nganh nganh){
        int check=0;
        check=DBConnection.ExcuteDungna(insert_sql,nganh.getMaNganh(),nganh.getTenNganh());
        return check>0;
    }
    public boolean delete(String id){
        int check=0;
        check=DBConnection.ExcuteDungna(delete_sql, id);
        return check>0;
    }
    public boolean update(String maNganh,String tenNganh,String id){
        int check=0;
        check=DBConnection.ExcuteDungna(update_sql, maNganh,tenNganh,id);
        return check>0;
    }
    private Nganh getNganh(String sql,Object... args){
        try {
            ResultSet rs=DBConnection.getDataFromQuery(sql, args);
            while (rs.next()) {                
                return mapping(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NganhRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
