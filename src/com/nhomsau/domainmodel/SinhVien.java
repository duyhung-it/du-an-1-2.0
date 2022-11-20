/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.domainmodel;
import java.sql.Date;
/**
 *
 * @author Nguyen Duy Hung
 */
public class SinhVien {
    private String id;
    String ma;
    private String hoTen;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String email;
    private String sdt;
    private String matKhau;
    private String idNganh;
    private String idNguoiTao;

    public SinhVien(String id, String ma, String hoTen, boolean gioiTinh, Date ngaySinh, String diaChi, String email, String sdt, String matKhau, String idNganh) {
        this.id = id;
        this.ma = ma;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.idNganh = idNganh;
    }

    public SinhVien(String ma, String hoTen, boolean gioiTinh, Date ngaySinh, String diaChi, String email, String sdt, String idNganh) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.idNganh = idNganh;
    }

    public SinhVien(String id, String ma, String hoTen, boolean gioiTinh, Date ngaySinh, String diaChi, String email, String sdt, String matKhau, String idNganh, String idNguoiTao) {
        this.id = id;
        this.ma = ma;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.idNganh = idNganh;
        this.idNguoiTao = idNguoiTao;
    }


    
    public SinhVien() {
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getIdNganh() {
        return idNganh;
    }

    public void setIdNganh(String idNganh) {
        this.idNganh = idNganh;
    }
    
}
