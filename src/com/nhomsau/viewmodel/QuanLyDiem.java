/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.viewmodel;

import java.math.BigDecimal;

/**
 *
 * @author Nguyen Duy Hung
 */
public class QuanLyDiem {
    
    private String idUser;
    private BigDecimal diem;
    private String ghiChu;

    public QuanLyDiem() {
    }

    public QuanLyDiem(String idUser, BigDecimal diem, String ghiChu) {
        this.idUser = idUser;
        this.diem = diem;
        this.ghiChu = ghiChu;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public BigDecimal getDiem() {
        return diem;
    }

    public void setDiem(BigDecimal diem) {
        this.diem = diem;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
