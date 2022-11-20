/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.viewmodel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class QuanLyLop {
    private String idLop;
    private String maLop;
    private String tenLop;
    private String idMon;
    private String idGiaoVien;

    public QuanLyLop() {
    }

    public QuanLyLop(String idLop, String maLop, String tenLop, String idMon, String idGiaoVien) {
        this.idLop = idLop;
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.idMon = idMon;
        this.idGiaoVien = idGiaoVien;
    }

    public String getIdLop() {
        return idLop;
    }

    public void setIdLop(String idLop) {
        this.idLop = idLop;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getIdMon() {
        return idMon;
    }

    public void setIdMon(String idMon) {
        this.idMon = idMon;
    }

    public String getIdGiaoVien() {
        return idGiaoVien;
    }

    public void setIdGiaoVien(String idGiaoVien) {
        this.idGiaoVien = idGiaoVien;
    }

    @Override
    public String toString() {
        return this.tenLop;
    }
    
}
