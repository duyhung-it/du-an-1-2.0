/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.Mon;
import com.nhomsau.mapper.MonMapper;
import com.nhomsau.repository.IMonRepository;
import com.nhomsau.util.DBConnection;
import com.nhomsau.viewmodel.QuanLyMon;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Duy Hung
 */
public class MonRepository implements IMonRepository {

    private final MonMapper mapper;
    String sql = "select * from mon";
    String selectAll_find_ten = "select * from mon join ky_mon on mon.id=ky_mon.idmon  where idky=?";
    List<QuanLyMon> list;

    public MonRepository() {
        this.mapper = new MonMapper();
    }

    @Override
    public List<QuanLyMon> findAll() {
        String sql = "SELECT * FROM Mon";
        List<QuanLyMon> listResults = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql);
            while (rs.next()) {
                listResults.add(mapper.mapRow(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResults;
    }

    @Override
    public QuanLyMon findOne(String idMon) {
        String sql = "SELECT * FROM Mon where Id = ?";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, idMon);
            while (rs.next()) {
                return mapper.mapRow(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Mon mon) {
        String sql = "Insert into Mon(MaMon,TenMon,TinChi,SoBuoiHoc) values(?,?,?,?)";
        DBConnection.ExcuteDungna(sql, mon.getMaMon(), mon.getTenMon(), mon.getTinChi(), mon.getSoBuoiHoc());

    }

    @Override
    public void delete(String idMon) {
        String sql = "Delete from Mon where Id = ?";
        DBConnection.ExcuteDungna(sql, idMon);
    }

    @Override
    public List<QuanLyMon> getMonTheoNganh(String idNganh, String idKy) {
        String sql = "select Mon.* from Mon join Mon_Nganh on Mon.Id = Mon_Nganh.Id\n"
                + "                   join Ky_Mon on Mon.Id = Ky_Mon.IdMon "
                + "where Mon_Nganh.IdNganh = ? and Ky_Mon.IdKy = ?";
        List<QuanLyMon> listResult = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, idNganh, idKy);
            while (rs.next()) {
                listResult.add(mapper.mapRow(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResult;
    }

    @Override
    public List<QuanLyMon> findMon(String idky) {
        return getSelectSql(selectAll_find_ten, idky);
    }

    public List<QuanLyMon> getSelectSql(String sql, Object... args) {
        list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while (rs.next()) {
                list.add(mapping(rs));
            }
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }

    private QuanLyMon mapping(ResultSet rs) {

        try {
            if (rs != null) {
                String id = rs.getString("Id");
                String mamon = rs.getString("MaMon");
                String tenmon = rs.getString("tenmon");
                int tinChi = rs.getInt("TinChi");
                int soBuoi = rs.getInt("SoBuoiHoc");
                QuanLyMon mon = new QuanLyMon(mamon, tenmon, tinChi, soBuoi);
                mon.setId(id);
                return mon;

            }
        } catch (SQLException ex) {
            Logger.getLogger(KyRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(Mon mon) {
        String sql = "UPDATE Mon SET MaMon=?,TenMon=?,TinChi=?,SoBuoiHoc=? WHERE Id=?";
        DBConnection.ExcuteDungna(sql, mon.getMaMon(), mon.getTenMon(), mon.getTinChi(), mon.getSoBuoiHoc(), mon.getId());
    }

    @Override
    public String getTenMon(String id) {
        String ten = null;
        String select_Mon = "select DISTINCT mon.tenMon\n"
                + "from mon join dauDiem_mon on mon.id = DauDiem_Mon.idMon"
                + " where dauDiem_Mon.idMon = ?";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(select_Mon, id);
            while (rs.next()) {
                ten = rs.getNString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ten;
    }

    @Override
    public List<QuanLyMon> getMonTheoGV(String idNganh, String idKy, String idGV) {
        String sql = "select Mon.*\n"
                +" From Users join Lop on Users.Id = Lop.IdGiaoVien"
                +" join Mon on Lop.IdMon = Mon.Id"
                +" join Ky_Mon on Mon.Id = Ky_Mon.IdMon"
                +" where Users.IdNganh = ? and Ky_Mon.IdKy = ? and Lop.IdGiaoVien = ?";
        List<QuanLyMon> listResult = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, idNganh, idKy,idGV);
            while (rs.next()) {
                listResult.add(mapper.mapRow(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResult;
    }
}
