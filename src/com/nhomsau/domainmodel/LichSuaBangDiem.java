/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.domainmodel;

/**
 *
 * @author HaTanBinh
 */
public class LichSuaBangDiem {
    private String tenMon,
                maMon,ky,trangThai;
    private double diem;

    public LichSuaBangDiem() {
    }

    public LichSuaBangDiem(String tenMon, String maMon, String ky, double diem, String trangThai) {
        this.tenMon = tenMon;
        this.maMon = maMon;
        this.ky = ky;
        this.diem = diem;
        this.trangThai = trangThai;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getKy() {
        return ky;
    }

    public void setKy(String ky) {
        this.ky = ky;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    private void trangthai(){
        
    }
}
