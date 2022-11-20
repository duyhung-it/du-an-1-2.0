/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.domainmodel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class Ky {
    private String id;
    private String maKy;
    private String tenKy;
    private int namHoc;

    public Ky() {
    }

    public Ky(String id, String maKy, String tenKy, int namHoc) {
        this.id = id;
        this.maKy = maKy;
        this.tenKy = tenKy;
        this.namHoc = namHoc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaKy() {
        return maKy;
    }

    public void setMaKy(String maKy) {
        this.maKy = maKy;
    }

    public String getTenKy() {
        return tenKy;
    }

    public void setTenKy(String tenKy) {
        this.tenKy = tenKy;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }
    
}
