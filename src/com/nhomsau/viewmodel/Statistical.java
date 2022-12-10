/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.viewmodel;

/**
 *
 * @author Admin
 */
public class Statistical {

    private String code;
    private String fullname;
    private double score;
    private int status;
    private String classcode;
    private String classname;

    public Statistical(String code, String fullname, double score, String classcode, String classname) {
        this.code = code;
        this.fullname = fullname;
        this.score = score;
        this.classcode = classcode;
        this.classname = classname;
    }

    public Statistical() {
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getStatus() {
        if(score > 5.0){
            return 0;
        }
        return 1;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
    public String getNote() {
        if (score > 0 && score <= 2.9) {
            return "Yếu";
        } else if (score <= 4.9) {
            return "Trung bình";
        } else if (score <= 7.9) {
            return "Khá";
        }else if (score <= 8.9) {
            return "Giỏi";
        } else {
            return "Xuất sắc";
        }
    }

}
