/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.util.DBConnection;

/**
 *
 * @author Nguyen Duy Hung
 */
public class SinhVienLopRepository {
    public void insert(String sv, String lop){
        String sql = "INSERT INTO SinhVien_Lop VALUES(?,?)";
        DBConnection.ExcuteDungna(sql, sv,lop);
    }
}
