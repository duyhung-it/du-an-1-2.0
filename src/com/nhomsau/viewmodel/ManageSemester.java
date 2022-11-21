/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.viewmodel;

/**
 *
 * @author Admin
 */
public class ManageSemester {

    private String code;
    private String name;
    private int schoolYear;

    public ManageSemester() {
    }

    public ManageSemester(String code, String name, int schoolYear) {
        this.code = code;
        this.name = name;
        this.schoolYear = schoolYear;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    @Override
    public String toString() {
        return code + " - " +name;
    }

}
