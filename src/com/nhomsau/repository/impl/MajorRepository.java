/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.Major;
import com.nhomsau.repository.IMajorRepository;
import com.nhomsau.util.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class MajorRepository implements IMajorRepository {

    @Override
    public List<Major> findAll() {
        String sql = "SELECT * FROM [dbo].[Nganh]";
        List<Major> list = getSelectSql(sql);
        return list;
    }

    private List<Major> getSelectSql(String sql, Object... args) {
        List<Major> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while (rs.next()) {
                list.add(new Major(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Major findByID(String id) {
        String sql = "SELECT * FROM [dbo].[Nganh] WHERE ID = ?";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, id);
            while (rs.next()) {
                Major major = new Major(rs.getString(1), rs.getString(2), rs.getString(3));
                return major;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MajorRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public Major findByCode(String code) {
        String sql = "SELECT * FROM [dbo].[Nganh] WHERE MaNganh = ?";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, code);
            while (rs.next()) {
                Major major = new Major(rs.getString(1), rs.getString(2), rs.getString(3));
                return major;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MajorRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
