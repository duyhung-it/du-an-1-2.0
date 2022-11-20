/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.domainmodel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class Lop {
    private String id;
    private String maLop;
    private String tenLop;
    private String idGiaoVien;
    private String idMonHoc;

    public Lop() {
    }

    public Lop(String id, String maLop, String tenLop, String idGiaoVien, String idMonHoc) {
        this.id = id;
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.idGiaoVien = idGiaoVien;
        this.idMonHoc = idMonHoc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getIdGiaoVien() {
        return idGiaoVien;
    }

    public void setIdGiaoVien(String idGiaoVien) {
        this.idGiaoVien = idGiaoVien;
    }

    public String getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(String idMonHoc) {
        this.idMonHoc = idMonHoc;
    }
    
}
