/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.domainmodel.SinhVienMon;
import com.nhomsau.viewmodel.SinhVienView;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface ISinhVienMonRepository {
//    List<SinhVienView> findAll();
//    SinhVienView findByMon(String idMon);
    void insert(SinhVienMon sinhVienMon);
    void delete(String idSinhVien);
    void updateStatus(SinhVienMon sinhVienMon);
    int countSinhVienByLop(String maLop);
}
