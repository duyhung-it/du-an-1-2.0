/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.Ky;
import com.nhomsau.mapper.KyMapper;
import com.nhomsau.repository.IKyRepository;
import com.nhomsau.util.DBConnection;
import com.nhomsau.viewmodel.QuanLyKy;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
/**
 *
 * @author Nguyen Duy Hung
 */
public class KyRepository implements IKyRepository{
    private final KyMapper mapper;

    public KyRepository() {
        this.mapper = new KyMapper();
    }
    
    @Override
    public List<QuanLyKy> findAll() {
        String sql = "SELECT * FROM Ky";
        List<QuanLyKy> listResults = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql);
            while(rs.next()){
                listResults.add(mapper.mapRow(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KyRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResults;
    }

    @Override
    public void insert(Ky ky) {
        String sql = "Insert into Ky(MaKy,TenKy,NamHoc) values (?,?,?)";
        DBConnection.ExcuteDungna(sql, ky.getMaKy(),ky.getTenKy(),ky.getNamHoc());
    }

    @Override
    public void delete(String idKy) {
        String sql = "Delete from Ky where Id = ?";
        DBConnection.ExcuteDungna(sql, idKy);
    }
    
    @Override
    public void update(Ky ky) {
        String sql = "Update Ky set TenKy = ? ,NamHoc = ? where Id = ?";
        DBConnection.ExcuteDungna(sql,ky.getTenKy(),ky.getNamHoc(),ky.getId());
    }
}
