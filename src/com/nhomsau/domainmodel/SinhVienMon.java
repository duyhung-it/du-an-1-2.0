/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.domainmodel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class SinhVienMon {
    private String idSinhVien;
    private String idMon;
    private String tinhTrang;

    public SinhVienMon() {
    }

    public SinhVienMon(String idSinhVien, String idMon, String tinhTrang) {
        this.idSinhVien = idSinhVien;
        this.idMon = idMon;
        this.tinhTrang = tinhTrang;
    }

    public String getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(String idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public String getIdMon() {
        return idMon;
    }

    public void setIdMon(String idMon) {
        this.idMon = idMon;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
}
