/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.domainmodel.Lop;
import com.nhomsau.viewmodel.QuanLyLop;
import com.nhomsau.viewmodel.TienDoDiemModel;
import com.nhomsau.viewmodel.TrangThai;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface ILopRepository {
    Lop findById(String id);
    List<QuanLyLop> findAll();
    void insert(Lop lop);
    void update(Lop lop);
    void delete(String idLop);
    QuanLyLop findByMa(String ma);
    List<QuanLyLop> findByTen(String ten);
    List<QuanLyLop> findByMon(String idMon,String idNganh,String idKy);
    List<QuanLyLop> findIdGV(String idMon,String idNganh,String idKy,String idGV);
    List<TienDoDiemModel> thongKeTienDoTheoLop(String idDauDiem,String idMon,String idLop);
}
