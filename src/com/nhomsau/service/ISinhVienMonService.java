/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.service;

import com.nhomsau.domainmodel.SinhVienMon;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface ISinhVienMonService {
    boolean insert(SinhVienMon sinhVienMon);
    void delete(String idSinhVien);
    void updateStatus(SinhVienMon sinhVienMon);
    int countSinhVienByLop(String maLop);
}
