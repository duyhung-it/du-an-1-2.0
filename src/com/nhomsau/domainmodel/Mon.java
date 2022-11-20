/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.domainmodel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class Mon {
    private String id;
    private String maMon;
    private String tenMon;
    private int tinChi;
    private int soBuoiHoc;

    public Mon() {
    }

    public Mon(String id, String maMon, String tenMon, int tinChi, int soBuoiHoc) {
        this.id = id;
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.tinChi = tinChi;
        this.soBuoiHoc = soBuoiHoc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getTinChi() {
        return tinChi;
    }

    public void setTinChi(int tinChi) {
        this.tinChi = tinChi;
    }

    public int getSoBuoiHoc() {
        return soBuoiHoc;
    }

    public void setSoBuoiHoc(int soBuoiHoc) {
        this.soBuoiHoc = soBuoiHoc;
    }
    
}
