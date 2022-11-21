/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.Semester;
import com.nhomsau.repository.ISemesterRepository;
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
public class SemesterRepository implements ISemesterRepository {

    @Override
    public List<Semester> findAll() {
        String sql = "SELECT * FROM [dbo].[Ky]";
        List<Semester> list = getSelectSql(sql);
        return list;
    }

    private List<Semester> getSelectSql(String sql, Object... args) {
        List<Semester> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while (rs.next()) {
                list.add(new Semester(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Semester findByID(String id) {
        String sql = "SELECT * FROM [dbo].[Ky] WHERE ID = ?";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, id);
            while (rs.next()) {
                Semester semester = new Semester(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                return semester;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Semester findByCode(String code) {
        String sql = "SELECT * FROM [dbo].[Ky] WHERE MaKy = ?";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, code);
            while (rs.next()) {
                Semester semester = new Semester(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                return semester;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
