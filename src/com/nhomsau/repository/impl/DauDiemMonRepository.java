/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.DauDiemMon;
import com.nhomsau.repository.IDauDiemMonRepository;
import com.nhomsau.util.DBConnection;
import java.sql.ResultSet;

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
    public void delete(String idDauDiem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
}
