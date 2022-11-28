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

    public QuanLyDiem() {
    }

    public QuanLyDiem(String idUser, BigDecimal diem) {
        this.idUser = idUser;
        this.diem = diem;
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

    
    
}
