/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.Subject;
import com.nhomsau.util.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.nhomsau.repository.ISubjectRepository;

/**
 *
 * @author Admin
 */
public class SubjectRepository implements ISubjectRepository {

    @Override
    public List<Subject> findAll() {
        String sql = "SELECT * FROM [dbo].[Mon]";
        List<Subject> list = getSelectSql(sql);
        return list;
    }

    private List<Subject> getSelectSql(String sql, Object... args) {
        List<Subject> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while (rs.next()) {
                list.add(new Subject(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Subject findByID(String id) {
        String sql = "SELECT * FROM [dbo].[Mon] WHERE ID = ?";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, id);
            while (rs.next()) {
                Subject major = new Subject(rs.getString(1), rs.getString(2), rs.getString(3));
                return major;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Subject findByCode(String code) {
        String sql = "SELECT * FROM [dbo].[Mon] WHERE MaMon = ?";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, code);
            while (rs.next()) {
                Subject major = new Subject(rs.getString(1), rs.getString(2), rs.getString(3));
                return major;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
