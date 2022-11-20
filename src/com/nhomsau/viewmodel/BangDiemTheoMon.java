/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.viewmodel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class BangDiemTheoMon {
    private String idSv;
    private String idLop;
    private double diemTB;
    private String trangThai;
    private String idMon;
    private String idKy;
    public BangDiemTheoMon() {
    }

    public BangDiemTheoMon(String idSv, String idLop) {
        this.idSv = idSv;
        this.idLop = idLop;
    }

    public BangDiemTheoMon(String idSv, String idLop, double diemTB) {
        this.idSv = idSv;
        this.idLop = idLop;
        this.diemTB = diemTB;
    }

    public String getIdSv() {
        return idSv;
    }

    public void setIdSv(String idSv) {
        this.idSv = idSv;
    }

    public String getIdLop() {
        return idLop;
    }

    public void setIdLop(String idLop) {
        this.idLop = idLop;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public String getTrangThai() {
        return this.diemTB >= 5 ? "Đạt" : "Trượt";
    }

    public String getIdMon() {
        return idMon;
    }

    public void setIdMon(String idMon) {
        this.idMon = idMon;
    }

    public String getIdKy() {
        return idKy;
    }

    public void setIdKy(String idKy) {
        this.idKy = idKy;
    }
    
    public Object[] toColumn(){
        return new Object[]{
            "STT",
            "Tên Môn",
            "Mã Môn",
            "Kỳ",
            "Họ Tên",
            "Ma Sinh Viên",
            "Lớp",
            "Số tín chỉ",
            "Điểm Trung Bình",
            "Trạng thái",
        };
    }
}
