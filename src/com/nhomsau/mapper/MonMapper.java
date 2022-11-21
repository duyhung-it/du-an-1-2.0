/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.mapper;

import com.nhomsau.domainmodel.Mon;
import com.nhomsau.viewmodel.QuanLyKy;
import com.nhomsau.viewmodel.QuanLyMon;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author Nguyen Duy Hung
 */
public class MonMapper {
    public QuanLyMon mapRow(ResultSet rs){
        if(rs != null){
            try {
                String id = rs.getString("Id");
                String ma = rs.getString("MaMon");
                String ten = rs.getString("TenMon");
                int tinChi = rs.getInt("TinChi");
                int soBuoiHoc = rs.getInt("SoBuoiHoc");
                QuanLyMon mon = new QuanLyMon(ma, ten,soBuoiHoc,tinChi);
                mon.setId(id);
                return mon;
                } catch (SQLException ex) {
                Logger.getLogger(KyMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    public Mon toDomainModel(QuanLyMon viewModel){
        if(viewModel != null){
            Mon result = new Mon();
            result.setId(viewModel.getId());
            result.setMaMon(viewModel.getMa());
            result.setSoBuoiHoc(viewModel.getSoBuoiHoc());
            result.setTenMon(viewModel.getTen());
            result.setTinChi(viewModel.getTinChi());
            return result;
        }
        return null;
    }
}
