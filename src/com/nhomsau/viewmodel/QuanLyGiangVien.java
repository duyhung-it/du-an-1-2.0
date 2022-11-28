/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.viewmodel;

/**
 *
 * @author Nguyen Duy Hung
 */
import java.sql.Date;
public class QuanLyGiangVien {
    private String id;
    private String maGiangVien;
    private String hoTen;
    private boolean gioiTinh;
    private Date dOB;
    private String diaChi;
    private String email;
    private String sdt;
    private String idNganh;

    public QuanLyGiangVien() {
    }

    public QuanLyGiangVien(String id, String maGiangVien, String hoTen, boolean gioiTinh, Date dOB, String diaChi, String email, String sdt, String idNganh) {
        this.id = id;
        this.maGiangVien = maGiangVien;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.dOB = dOB;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
        this.idNganh = idNganh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getdOB() {
        return dOB;
    }

    public void setdOB(Date dOB) {
        this.dOB = dOB;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getIdNganh() {
        return idNganh;
    }

    public void setIdNganh(String idNganh) {
        this.idNganh = idNganh;
    }

    @Override
    public String toString() {
        return maGiangVien + "-" + hoTen;
    }
    
}
