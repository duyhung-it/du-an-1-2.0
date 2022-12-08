/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.KyMon;
import com.nhomsau.repository.IKyMonRepository;
import com.nhomsau.util.DBConnection;

/**
 *
 * @author Admin
 */
public class KyMonRepository implements IKyMonRepository{

    public KyMonRepository() {
        
    }
    
    

    @Override
    public void insert(KyMon kyMon) {
        String sql = "insert into Ky_Mon values(?,?,?)";
        DBConnection.ExcuteDungna(sql, kyMon.getidMon(),kyMon.getIdKy(),kyMon.getIdNganh());
    }

    @Override
    public void delete(KyMon kyMon) {
        String sql = "delete Ky_Mon where IdMon = ? and IdKy = ? and idNganh = ?";
        DBConnection.ExcuteDungna(sql, kyMon.getidMon(),kyMon.getIdKy(),kyMon.getIdNganh());
    }
    
}
