/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.mapper;

import com.nhomsau.viewmodel.QuanLyNganh;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nguyen Duy Hung
 */
public class NganhMapper {
    public QuanLyNganh mapRow(ResultSet rs){
        if(rs!= null){
            try {
                String id = rs.getString("Id");
                String ma = rs.getString("MaNganh");
                String ten = rs.getString("TenNganh");
                QuanLyNganh nganh = new QuanLyNganh(ma, ten);
                nganh.setId(id);
                return nganh;
            } catch (SQLException ex) {
                Logger.getLogger(NganhMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
