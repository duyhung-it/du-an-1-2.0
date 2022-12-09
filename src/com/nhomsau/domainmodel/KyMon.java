/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhomsau.domainmodel;

/**
 *
 * @author Admin
 */
public class KyMon {
    private String idKy;
    private String idMon;
    private String idNganh;

    public KyMon() {
    }

    public KyMon(String idKy, String idMon, String idNganh) {
        this.idKy = idKy;
        this.idMon = idMon;
        this.idNganh = idNganh;
    }

    public String getIdKy() {
        return idKy;
    }

    public void setIdKy(String idKy) {
        this.idKy = idKy;
    }

    public String getidMon() {
        return idMon;
    }

    public void setidMon(String iMon) {
        this.idMon = idMon;
    }

    public String getIdNganh() {
        return idNganh;
    }

    public void setIdNganh(String idNganh) {
        this.idNganh = idNganh;
    }
    
    
}
