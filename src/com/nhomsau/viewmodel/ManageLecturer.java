/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.viewmodel;

import com.raven.swing.table.EventAction;
import com.raven.swing.table.ModelAction;
import com.raven.swing.table.ModelProfile;
import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class ManageLecturer {

    private String code;
    private String fullname;
    private int gender;
    private Date dOB;
    private String address;
    private String email;
    private String phone;
    private String password;
    private int role;
    private ManageManager manager;
    private ManageMajor major;

    public ManageLecturer() {
    }

    public ManageLecturer(String code, String fullname, int gender, Date dOB, String address, String email, String phone, String password, int role, ManageManager manager, ManageMajor major) {
        this.code = code;
        this.fullname = fullname;
        this.gender = gender;
        this.dOB = dOB;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.manager = manager;
        this.major = major;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getdOB() {
        return dOB;
    }

    public void setdOB(Date dOB) {
        this.dOB = dOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public ManageManager getManager() {
        return manager;
    }

    public void setManager(ManageManager manager) {
        this.manager = manager;
    }

    public ManageMajor getMajor() {
        return major;
    }

    public void setMajor(ManageMajor major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return code + "-" + fullname;
    }
;

}
