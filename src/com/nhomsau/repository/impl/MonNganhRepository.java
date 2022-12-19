/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.MonNganh;
import com.nhomsau.repository.IMonNganhRepository;
import com.nhomsau.util.DBConnection;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HaTanBinh
 */
public class MonNganhRepository implements IMonNganhRepository{
    @Override
    public List<MonNganh> findMonNganh(String idNganh){
        String sql_MonNganh="select distinct * from mon_nganh where idnganh=?";
        List<MonNganh> lists=new ArrayList<>();
        try {
            ResultSet rs=DBConnection.getDataFromQuery(sql_MonNganh, idNganh);
            while (rs.next()) {                
                lists.add(new MonNganh(rs.getString("id"), rs.getString("idNganh")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonNganhRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }
    @Override
    public List<MonNganh> findMonNganh1(String idNganh){
        String sql_MonNganh="select distinct * from mon_nganh where idnganh != ? ";
        List<MonNganh> lists=new ArrayList<>();
        try {
            ResultSet rs=DBConnection.getDataFromQuery(sql_MonNganh, idNganh);
            while (rs.next()) {                
                lists.add(mapping(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonNganhRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }
    @Override
    public void insert(MonNganh monNganh){
        String insert_sql="insert into mon_nganh(id,idnganh) values(?,?)";
        DBConnection.ExcuteDungna(insert_sql, monNganh.getMaMon(),monNganh.getMaNganh());
    }
    @Override
    public void delete(MonNganh mn){
        String sql="delete mon_nganh where id=? and idnganh=?";
        DBConnection.ExcuteDungna(sql, mn.getMaMon(),mn.getMaNganh());
    }
    public MonNganh mapping(ResultSet rs){
        if(rs!=null){
            try {
                String idMon=rs.getString("id");
                String idNganh=rs.getString("idnganh");
                return new MonNganh(idMon, idNganh);
            } catch (SQLException ex) {
                Logger.getLogger(MonNganhRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
