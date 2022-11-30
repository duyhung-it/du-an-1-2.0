/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.Major;
import com.nhomsau.domainmodel.Manager;
import com.nhomsau.repository.IManagerRepository;
import com.nhomsau.util.DBConnection;
import com.nhomsau.viewmodel.ManageManager;
import com.nhomsau.viewmodel.Statistical;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ManagerRepository implements IManagerRepository {

    @Override
    public List<Manager> findAll() {
        String sql = "SELECT [Id] ,[MaUser] ,[HoTen] ,[NgaySinh] ,[DiaChi] ,[Email] ,[SDT] ,[MatKhau] ,[ChucVu] ,[GioiTinh] FROM [dbo].[Users] WHERE [ChucVu] = 1";
        List<Manager> list = getSelectSql(sql);
        return list;

    }

    private List<Manager> getSelectSql(String sql, Object... args) {
        List<Manager> list = new ArrayList<>();
        try {

            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while (rs.next()) {
                list.add(new Manager(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(10),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Manager findByID(String id) {
        String sql = "SELECT [Id] ,[MaUser] ,[HoTen] ,[NgaySinh] ,[DiaChi] ,[Email] ,[SDT] ,[MatKhau] ,[ChucVu] ,[GioiTinh] FROM [dbo].[Users] WHERE [ID] = ?";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, id);
            while (rs.next()) {
                Manager major = new Manager(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(10),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9));
                return major;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Manager findByCode(String code) {
        String sql = "SELECT [Id] ,[MaUser] ,[HoTen] ,[NgaySinh] ,[DiaChi] ,[Email] ,[SDT] ,[MatKhau] ,[ChucVu] ,[GioiTinh] FROM [dbo].[Users] WHERE [MaUser] = ?";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, code);
            while (rs.next()) {
                Manager major = new Manager(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(10),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9));
                return major;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Statistical> findListStudent(String idSj, String idMj, String idSe) {
        try {
            StringBuilder sqlStringBuilder = new StringBuilder();
            sqlStringBuilder.append("exec proc_thong_ke_diem_trung_binh_theo_mon ")
                    .append("'") .append(idSj).append("'").append(", ")
                    .append("'").append(idSe).append("'").append(", ")
                    .append("'").append(idMj).append("'");
            String sql = sqlStringBuilder.toString();
            System.out.println(sql);
            List<Statistical> list = new ArrayList<>();
            ResultSet rs = DBConnection.getDataFromQuery(sql);
            try {
                while (rs.next()) {
                    Statistical st = new Statistical(rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(6),
                            rs.getString(4),
                            rs.getString(5));
                    list.add(st);
                }
                return list;
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ManagerRepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            return null;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ManagerRepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Statistical> findTotalListStudent(String idNganh, String idKy) {
        try {
            StringBuilder sqlStringBuilder = new StringBuilder();
            sqlStringBuilder.append("exec proc_thong_ke_diem_trung_binh_theo_mon ")
                    .append("null") .append(", ")
                    .append("'").append(idKy).append("'").append(", ")
                    .append("'").append(idNganh).append("'");
            String sql = sqlStringBuilder.toString();
            System.out.println(sql);
            List<Statistical> list = new ArrayList<>();
            ResultSet rs = DBConnection.getDataFromQuery(sql);
            try {
                while (rs.next()) {
                    Statistical st = new Statistical(rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(6),
                            rs.getString(4),
                            rs.getString(5));
                    list.add(st);
                }
                return list;
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ManagerRepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            return null;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ManagerRepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }

}
