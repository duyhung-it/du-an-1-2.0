/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.viewmodel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class QuanLyMon {
    private String id;
    private String ma;
    private String ten;
    private int soBuoiHoc;
    private int tinChi;
    public QuanLyMon() {
    }

    public QuanLyMon(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public QuanLyMon(String ma, String ten, int soBuoiHoc, int tinChi) {
        this.ma = ma;
        this.ten = ten;
        this.soBuoiHoc = soBuoiHoc;
        this.tinChi = tinChi;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoBuoiHoc() {
        return soBuoiHoc;
    }

    public void setSoBuoiHoc(int soBuoiHoc) {
        this.soBuoiHoc = soBuoiHoc;
    }

    public int getTinChi() {
        return tinChi;
    }

    public void setTinChi(int tinChi) {
        this.tinChi = tinChi;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.ten;
    }
    
}
