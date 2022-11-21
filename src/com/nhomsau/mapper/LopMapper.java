/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.mapper;

import com.nhomsau.domainmodel.Lop;
import com.nhomsau.viewmodel.QuanLyLop;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nguyen Duy Hung
 */
public class LopMapper {
    public QuanLyLop mapRow(ResultSet rs){
        if(rs!= null){
            try {
                    String id = rs.getString(1);
                    String ma = rs.getString("MaLop");
                    String ten = rs.getString("TenLop"); 
                    String idMon = rs.getString("IdMon");
                    String idGv = rs.getString("IdGiaoVien");
                    return new QuanLyLop(id, ma, ten, idMon, idGv);
                } catch (SQLException ex) {
                Logger.getLogger(LopMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
