/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.domainmodel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class DauDiem {
    private String idDauDiem;
    private String maDauDiem;
    private String tenDauDiem;

    public DauDiem() {
    }

    public DauDiem(String idDauDiem, String maDauDiem, String tenDauDiem) {
        this.idDauDiem = idDauDiem;
        this.maDauDiem = maDauDiem;
        this.tenDauDiem = tenDauDiem;
    }

    public String getIdDauDiem() {
        return idDauDiem;
    }

    public void setIdDauDiem(String idDauDiem) {
        this.idDauDiem = idDauDiem;
    }

    public String getMaDauDiem() {
        return maDauDiem;
    }

    public void setMaDauDiem(String maDauDiem) {
        this.maDauDiem = maDauDiem;
    }

    public String getTenDauDiem() {
        return tenDauDiem;
    }

    public void setTenDauDiem(String tenDauDiem) {
        this.tenDauDiem = tenDauDiem;
    }

    @Override
    public String toString() {
        return this.tenDauDiem;
    }
    
}
