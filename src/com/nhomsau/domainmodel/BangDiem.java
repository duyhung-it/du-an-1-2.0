/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.domainmodel;

/**
 *
 * @author HaTanBinh
 */
public class BangDiem {
    private String tenDauDiem;
    private double diem;
    private String ghiCHu = "";
    public BangDiem() {
    }

    public BangDiem(String tenDauDiem, double diem) {
        this.tenDauDiem = tenDauDiem;
        this.diem = diem;
    }

    public String getTenDauDiem() {
        return tenDauDiem;
    }

    public void setTenDauDiem(String tenDauDiem) {
        this.tenDauDiem = tenDauDiem;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getGhiCHu() {
        return ghiCHu;
    }

    public void setGhiCHu(String ghiCHu) {
        this.ghiCHu = ghiCHu;
    }
    
    
}
