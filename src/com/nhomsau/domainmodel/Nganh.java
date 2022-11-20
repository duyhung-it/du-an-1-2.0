/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.domainmodel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class Nganh {
    private String id;
    private String maNganh;
    private String tenNganh;

    public Nganh() {
    }

    public Nganh(String id, String maNganh, String tenNganh) {
        this.id = id;
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }
    
}
