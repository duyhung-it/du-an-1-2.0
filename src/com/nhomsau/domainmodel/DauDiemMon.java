/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.domainmodel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class DauDiemMon {
    private String idDauDiem;
    private String idMon;
    private int heSo;

    public DauDiemMon() {
    }

    public DauDiemMon(String idDauDiem, String idMon, int heSo) {
        this.idDauDiem = idDauDiem;
        this.idMon = idMon;
        this.heSo = heSo;
    }

    public String getIdDauDiem() {
        return idDauDiem;
    }

    public void setIdDauDiem(String idDauDiem) {
        this.idDauDiem = idDauDiem;
    }

    public String getIdMon() {
        return idMon;
    }

    public void setIdMon(String idMon) {
        this.idMon = idMon;
    }

    public int getHeSo() {
        return heSo;
    }

    public void setHeSo(int heSo) {
        this.heSo = heSo;
    }
    
}
