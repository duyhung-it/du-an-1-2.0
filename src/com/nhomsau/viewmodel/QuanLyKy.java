/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.viewmodel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class QuanLyKy {
    private String ma;
    private String id;
    private String ten;
    private int nam;

    public QuanLyKy() {
    }

    public QuanLyKy(String ma, String ten, int nam) {
        this.ma = ma;
        this.ten = ten;
        this.nam = nam;
    }

    public QuanLyKy(String ma, String id, String ten, int nam) {
        this.ma = ma;
        this.id = id;
        this.ten = ten;
        this.nam = nam;
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

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.ten + " " + this.nam;
    }
    
}
