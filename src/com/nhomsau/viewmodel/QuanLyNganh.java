/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.viewmodel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class QuanLyNganh {
    private String ma;
    private String ten;
    private String id;
    public QuanLyNganh() {
    }

    public QuanLyNganh(String ma, String ten, String id) {
        this.ma = ma;
        this.ten = ten;
        this.id = id;
    }

    public QuanLyNganh(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.toString().equals(this.getTen())) return true;
        return false;
    }
    
    @Override
    public String toString() {
        return this.ten;
    }
    
}
