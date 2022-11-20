/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.mapper;

import com.nhomsau.viewmodel.QuanLyKy;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nguyen Duy Hung
 */
public class KyMapper {
    public QuanLyKy mapRow(ResultSet rs){
        if(rs != null){
            try {
                String id = rs.getString(1);
                String ma = rs.getString("MaKy");
                String ten = rs.getString("TenKy");
                int nam = rs.getInt("NamHoc");
                QuanLyKy ky = new QuanLyKy(ma, ten, nam);
                ky.setId(id);
                return ky;
                } catch (SQLException ex) {
                Logger.getLogger(KyMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
