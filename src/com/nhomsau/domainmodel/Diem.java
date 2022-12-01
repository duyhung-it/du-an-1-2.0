/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.domainmodel;

import java.util.Date;

/**
 *
 * @author Nguyen Duy Hung
 */
public class Diem {
    private String idSV;
    private String idMonHoc;
    private String idDauDiem;
    private float diem;
    private String idNguoiNhap;
    private Date ngayNhap;
    private String idNguoiSua;
    private Date ngaySua;

    public Diem() {
    }

    public Diem(String idSV, String idMonHoc, String idDauDiem, float diem, String idNguoiNhap, Date ngayNhap, String idNguoiSua, Date ngaySua) {
        this.idSV = idSV;
        this.idMonHoc = idMonHoc;
        this.idDauDiem = idDauDiem;
        this.diem = diem;
        this.idNguoiNhap = idNguoiNhap;
        this.ngayNhap = ngayNhap;
        this.idNguoiSua = idNguoiSua;
        this.ngaySua = ngaySua;
    }

    public String getIdSV() {
        return idSV;
    }

    public void setIdSV(String idSV) {
        this.idSV = idSV;
    }

    public String getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(String idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    public String getIdDauDiem() {
        return idDauDiem;
    }

    public void setIdDauDiem(String idDauDiem) {
        this.idDauDiem = idDauDiem;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public String getIdNguoiNhap() {
        return idNguoiNhap;
    }

    public void setIdNguoiNhap(String idNguoiNhap) {
        this.idNguoiNhap = idNguoiNhap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getIdNguoiSua() {
        return idNguoiSua;
    }

    public void setIdNguoiSua(String idNguoiSua) {
        this.idNguoiSua = idNguoiSua;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

}
