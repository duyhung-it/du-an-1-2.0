/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.DauDiem;
import com.nhomsau.domainmodel.DauDiemMon;
import com.nhomsau.repository.IDauDiemRepository;
import com.nhomsau.util.DBConnection;
import com.nhomsau.viewmodel.QuanLyMon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Duy Hung
 */
public class DauDiemRepository implements IDauDiemRepository {

    @Override
    public List<DauDiem> findAll() {
        String sql = "SELECT * FROM DauDiem";
        List<DauDiem> listResults = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql);
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                listResults.add(new DauDiem(id, ma, ten));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResults;
    }

    @Override
    public void insert(DauDiem dd) {
        String sql = "Insert into DauDiem (MaDauDiem,TenDauDiem) values(?,?)";
        DBConnection.ExcuteDungna(sql, dd.getMaDauDiem(), dd.getTenDauDiem());
    }

    @Override
    public void delete(DauDiem dd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    final String Select_DauDiem = "select DauDiem.Id,MaDauDiem,TenDauDiem\n"
            + "from DauDiem join DauDiem_Mon on DauDiem.Id = DauDiem_Mon.IdDauDiem\n"
            + "where IdMon = ?";
    final String Select_IdDauDiem = "select Id from DauDiem where TenDauDiem = ?";
    DBConnection dBConnection;

    public DauDiemRepository() {
        dBConnection = new DBConnection();

    }

    public List<DauDiem> getDauDiems(String idMon) {
        List<DauDiem> listDauDiems = new ArrayList<>();
        try {
            ResultSet rs = dBConnection.getDataFromQuery(Select_DauDiem, idMon);
            while (rs.next()) {
                DauDiem dauDiem = mapingDauDiem(rs);
                listDauDiems.add(dauDiem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDauDiems;
    }

    public String getIdDauDiem(String tenDauDiem) {
        String idDauDiem = "";
        try {
            ResultSet rs = dBConnection.getDataFromQuery(Select_IdDauDiem, tenDauDiem);
            while (rs.next()) {
                idDauDiem = rs.getString("Id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idDauDiem;
    }
    
    @Override
    public String getTenDauDiem(String idDauDiem) {
        String ten = "";
        String Select_TenDauDiem = "select dauDiem.tenDauDiem "
                + "from dauDiem join DauDiem_Mon on dauDiem.id = DauDiem_Mon.idDauDiem"
                + " where dauDiem_Mon.idDauDiem = ?";
        try {
            ResultSet rs = dBConnection.getDataFromQuery(Select_TenDauDiem, idDauDiem);
            while (rs.next()) {
                ten = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ten;
    }

    private DauDiem mapingDauDiem(ResultSet rs) {
        try {
            if (rs != null) {
                String id = rs.getString("Id");
                String maDauDiem = rs.getNString("MaDauDiem");
                String tenDauDiem = rs.getNString("TenDauDiem");
                return new DauDiem(id, maDauDiem, tenDauDiem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DauDiem> findAllDauDiem(String idMon) {
        String sql = "select distinct daudiem.id, daudiem.madaudiem ,DauDiem.TenDauDiem\n"
                + "from mon join DauDiem_Mon on mon.Id = DauDiem_Mon.IdMon\n"
                + "		join DauDiem on DauDiem_Mon.IdDauDiem = DauDiem.Id\n"
                + "except  \n"
                + "select daudiem.id, daudiem.madaudiem, DauDiem.TenDauDiem\n"
                + "from mon join DauDiem_Mon on mon.Id = DauDiem_Mon.IdMon\n"
                + "		join DauDiem on DauDiem_Mon.IdDauDiem = DauDiem.Id\n"
                + "where IdMon = ?";
        List<DauDiem> listResults = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, idMon);
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                listResults.add(new DauDiem(id, ma, ten));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResults;
    }

    @Override
    public int countDauDiem(String idMon, String idNganh) {
        StringBuilder sql = new StringBuilder("select COUNT(*)");
        sql.append(" from DauDiem_Mon join Mon_Nganh on DauDiem_Mon.IdMon = Mon_Nganh.Id");
        sql.append(" where IdMon = ? and Mon_Nganh.IdNganh = ?");
        int result = -1;
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql.toString(), idMon,idNganh);
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<DauDiem> findDauDiemByMon(String idMon, String idNganh) {
        String sql = "select DauDiem.* from DauDiem join DauDiem_Mon on DauDiem.Id = DauDiem_Mon.IdDauDiem \n" +
                    "join Mon_Nganh on DauDiem_Mon.IdMon = Mon_Nganh.Id \n" +
                    "where IdMon = ? and IdNganh = ? order by HeSo";
        List<DauDiem> listResults = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, idMon,idNganh);
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                listResults.add(new DauDiem(id, ma, ten));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResults;
    }
}
