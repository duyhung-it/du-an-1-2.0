/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.viewmodel;
import java.sql.Date;
/**
 *
 * @author Nguyen Duy Hung
 */
public class LoginModel {
    private String idUser;
    private String maUser;
    private String hoTen;
    private boolean gioiTinh;
    
    private Date dOB;
    private String email;
    private String sDT;
    private String password;
    private String idNganh;
    private int chucVu;

    public LoginModel() {
    }

    public LoginModel(String idUser, String maUser, String hoTen, boolean gioiTinh, Date dOB, String email, String sDT, String password, String idNganh, int chucVu) {
        this.idUser = idUser;
        this.maUser = maUser;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.dOB = dOB;
        this.email = email;
        this.sDT = sDT;
        this.password = password;
        this.idNganh = idNganh;
        this.chucVu = chucVu;
    }

    
  
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getMaUser() {
        return maUser;
    }

    public void setMaUser(String maUser) {
        this.maUser = maUser;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getdOB() {
        return dOB;
    }

    public void setdOB(Date dOB) {
        this.dOB = dOB;
    }

    public String getIdNganh() {
        return idNganh;
    }

    public void setIdNganh(String idNganh) {
        this.idNganh = idNganh;
    }

    public int getChucVu() {
        return chucVu;
    }

    public void setChucVu(int chucVu) {
        this.chucVu = chucVu;
    }
    
    
}
