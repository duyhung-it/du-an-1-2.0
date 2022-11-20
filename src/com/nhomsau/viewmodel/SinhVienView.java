/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.viewmodel;

import com.raven.swing.table.EventAction;
import com.raven.swing.table.ModelAction;
import java.text.DecimalFormat;
import java.sql.Date;

/**
 *
 * @author Nguyen Duy Hung
 */
public class SinhVienView {
    private String id;
    private String ma;
    private String hoTen;
    private Date ngaySinh;
    private String diaChi;
    private String email;
    private String SDT;
    private String nganhHoc;
    private boolean gioiTinh;
    private String idNganh;
    public SinhVienView() {
    }

    public SinhVienView(String ma, String hoTen, Date ngaySinh, String diaChi, String email, String SDT, String nganhHoc) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.email = email;
        this.SDT = SDT;
        this.nganhHoc = nganhHoc;
    }

    public SinhVienView(String ma, String hoTen, Date ngaySinh, String diaChi, String email, String SDT, boolean gioiTinh) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.email = email;
        this.SDT = SDT;
        this.gioiTinh = gioiTinh;
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

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
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

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getIdNganh() {
        return idNganh;
    }

    public void setIdNganh(String idNganh) {
        this.idNganh = idNganh;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }
        public Object[] toRowTable() {
            DecimalFormat df = new DecimalFormat("$#,##0.00");
        return new Object[]{this.ma, this.hoTen,this.gioiTinh ? "Nam" : "Nữ",this.ngaySinh, this.diaChi, this.email,this.SDT, this.nganhHoc};
    }
}
