
package com.nhomsau.domainmodel;


public class ModelSinhVienLop {
    private String idSinhVien,idLop,maSinhVien,maLop,idSinhVienCu,idLopCu;

    public ModelSinhVienLop() {
    }

    public ModelSinhVienLop(String idSinhVien, String idLop, String maSinhVien, String maLop, String idSinhVienCu, String idLopCu) {
        this.idSinhVien = idSinhVien;
        this.idLop = idLop;
        this.maSinhVien = maSinhVien;
        this.maLop = maLop;
        this.idSinhVienCu = idSinhVienCu;
        this.idLopCu = idLopCu;
    }

    public String getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(String idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public String getIdLop() {
        return idLop;
    }

    public void setIdLop(String idLop) {
        this.idLop = idLop;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getIdSinhVienCu() {
        return idSinhVienCu;
    }

    public void setIdSinhVienCu(String idSinhVienCu) {
        this.idSinhVienCu = idSinhVienCu;
    }

    public String getIdLopCu() {
        return idLopCu;
    }

    public void setIdLopCu(String idLopCu) {
        this.idLopCu = idLopCu;
    }

   
}
