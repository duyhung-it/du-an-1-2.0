/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.viewmodel;
import java.sql.Date;
/**
 *
 * @author Nguyen Duy Hung
 */
public class TienDoDiemModel {
    private String maLop;
    private String tenLop;
    private String giangVien;
    private Date ngayNhap;
    private int soSinhVienDaNhap;
    private TrangThai trangThai;

    public TienDoDiemModel() {
    }

    public TienDoDiemModel(String maLop, String tenLop, String giangVien, Date ngayNhap, int soSinhVienDaNhap) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.giangVien = giangVien;
        this.ngayNhap = ngayNhap;
        this.soSinhVienDaNhap = soSinhVienDaNhap;
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

    public String getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(String giangVien) {
        this.giangVien = giangVien;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getSoSinhVienDaNhap() {
        return soSinhVienDaNhap;
    }

    public void setSoSinhVienDaNhap(int soSinhVienDaNhap) {
        this.soSinhVienDaNhap = soSinhVienDaNhap;
    }

    public TrangThai getTrangThai(int tongSinhVien) {
        String value = "";
        if(soSinhVienDaNhap < tongSinhVien){
            value = "CHT";
        }else{
            value = "HT";
        }
        return new TrangThai(value);
    }

    
    
}
