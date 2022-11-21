/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.DauDiemMon;
import com.nhomsau.repository.IDauDiemMonRepository;
import com.nhomsau.util.DBConnection;
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
public class DauDiemMonRepository implements IDauDiemMonRepository {

    @Override
    public void insert(DauDiemMon dm) {
        String sql = "Insert into DauDiem_Mon values (?,?,?)";
        DBConnection.ExcuteDungna(sql, dm.getIdDauDiem(),dm.getIdMon(),dm.getHeSo());
    }

    @Override
    public void delete(String idDauDiem, String idMon) {
        String delete_sql = "delete from DauDiem_Mon where idDauDiem = ? and idMon = ?";
        dBConnection.ExcuteDungna(delete_sql, idDauDiem, idMon);
    }
    
    DBConnection dBConnection;
    final String Select_Heso_SQL = "select HeSo\n"
            + "from DauDiem_Mon\n"
            + "where IdDauDiem = ? and IdMon = ?";

    public DauDiemMonRepository() {
        dBConnection = new DBConnection();
    }
    
    public float getHeSo(String idDauDiem, String idMon){
        float heSo = 0;
        try {
            ResultSet rs = dBConnection.getDataFromQuery(Select_Heso_SQL, idDauDiem, idMon);   
            while (rs.next()) { 
                heSo = rs.getFloat("HeSo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return heSo;
    }

    @Override
    public List<DauDiemMon> findAll() {
        String select_sql  = "select * from DauDiem_Mon join mon on DauDiem_Mon.IdMon = Mon.id";
        List<DauDiemMon> dsDauDiemMon = new ArrayList<>();
        try {
            ResultSet rs = dBConnection.getDataFromQuery(select_sql);
            while(rs.next()){
                String idMon = rs.getString("IdMon");
                String idDauDiem = rs.getString("IdDauDiem");
                int heSo = rs.getInt("HeSo");
                
                DauDiemMon dauDiemMon = new DauDiemMon(idDauDiem, idMon, heSo);
                dsDauDiemMon.add(dauDiemMon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DauDiemMonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDauDiemMon;
    }
}
