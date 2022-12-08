/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.service;

import com.nhomsau.domainmodel.SinhVien;
import com.nhomsau.viewmodel.SinhVienView;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface ISinhVienService {
     List<SinhVienView> findAll();
     SinhVienView findById(String id);
     void insert(SinhVienView sinhVien);
     void update(SinhVienView sinhVien);
     void delete(String ma);
     SinhVienView findByMa(String ma);
     List<SinhVienView> findSinhVienTheoLop(String idLop);
     int countSinhVienByLop(String maLop);
}
