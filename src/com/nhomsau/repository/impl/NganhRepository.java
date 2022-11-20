/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

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
    public List<QuanLyNganh> findAll() {
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
    
}
