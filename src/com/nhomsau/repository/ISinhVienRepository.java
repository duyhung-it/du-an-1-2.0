/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.domainmodel.SinhVien;
import com.nhomsau.viewmodel.SinhVienView;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface ISinhVienRepository {
    List<SinhVienView> findAll();
    List<SinhVien> findAll2();
    SinhVienView findById(String id);
    void insert(SinhVien sinhVien);
    void update(SinhVien sinhVien);
    void delete(String ma);
    SinhVienView findByMa(String ma);
    List<SinhVienView> thongKeDanhSachSinhVien(String idKy,String idNganh,String idMon);
    List<SinhVienView> findSinhVienTheoLop(String idLop);
    int countSinhVienByLop(String maLop);
}