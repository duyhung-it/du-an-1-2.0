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
        ResultSet rs = null;
        String sql = "select distinct Mon.* from Mon "
                + "   join Ky_Mon on Mon.Id = Ky_Mon.IdMon ";
        if(idNganh != null){
            sql += "where Ky_Mon.idNganh = ? and Ky_Mon.IdKy = ?";
            try {
                rs = DBConnection.getDataFromQuery(sql, idNganh, idKy);
            } catch (SQLException ex) {
                Logger.getLogger(MonRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
            sql += "where Ky_Mon.IdKy = ?";
            try {
                rs = DBConnection.getDataFromQuery(sql, idKy);
            } catch (SQLException ex) {
                Logger.getLogger(MonRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        List<QuanLyMon> listResult = new ArrayList<>();
        try {
             
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
                + " From Users join Lop on Users.Id = Lop.IdGiaoVien"
                + " join Mon on Lop.IdMon = Mon.Id"
                + " join Ky_Mon on Mon.Id = Ky_Mon.IdMon"
                + " where Ky_Mon.idNganh = ? and Ky_Mon.IdKy = ? and Lop.IdGiaoVien = ?";
        List<QuanLyMon> listResult = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, idNganh, idKy, idGV);
            while (rs.next()) {
                listResult.add(mapper.mapRow(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResult;
    }

    @Override
    public List<QuanLyMon> getMonDaCo(String idKy, String idNganh) {
        List<QuanLyMon> list = new ArrayList<>();
        String sql = " select MaMon,TenMon\n"
                + " from Ky_Mon join Mon on Ky_Mon.IdMon = Mon.Id\n"
                + " where Ky_Mon.IdKy = ? and Ky_Mon.idNganh = ?";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, idKy, idNganh);
            while (rs.next()) {
                String maMon = rs.getString("MaMon");
                String tenMon = rs.getNString("TenMon");
                QuanLyMon qlm = new QuanLyMon(maMon, tenMon);
                list.add(qlm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<QuanLyMon> getMonChuaCo(String idKy, String idNganh) {
        List<QuanLyMon> list = new ArrayList<>();
        String sql = "select MaMon,TenMon\n"
                + "from Mon\n"
                + "EXCEPT\n"
                + "select MaMon,TenMon\n"
                + "from Ky_Mon join Mon on Ky_Mon.IdMon = Mon.Id\n"
                + "where Ky_Mon.IdKy = ? and idNganh = ?";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, idKy, idNganh);
            while (rs.next()) {
                String maMon = rs.getString("MaMon");
                String tenMon = rs.getNString("TenMon");
                QuanLyMon qlm = new QuanLyMon(maMon, tenMon);
                list.add(qlm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String getIdMon(String maMon) {
        String idMon = "";
        String sql = "select Id from Mon where MaMon = ?";
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, maMon);
            while (rs.next()) {
                idMon = rs.getString("Id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idMon;
    }
    @Override
    public int getTinChi1(String idnganh){
        String sql="select sum(tinchi) as tinchi from mon join mon_nganh on mon.id=mon_nganh.id where idnganh=? ";
        int a=0;
        try {
            ResultSet rs=DBConnection.getDataFromQuery(sql, idnganh);
            while (rs.next()) {                
                a=rs.getInt("tinchi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    @Override
    public int getTinChi(String idnganh,String tenmon){
        String sql="select sum(tinchi) as tinchi from mon join mon_nganh on mon.id=mon_nganh.id where idnganh=? and tenmon=?";
        int a=0;
        try {
            ResultSet rs=DBConnection.getDataFromQuery(sql, idnganh,tenmon);
            while (rs.next()) {                
                a=rs.getInt("tinchi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
}
