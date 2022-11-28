/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.service;

import com.nhomsau.domainmodel.BangDiem;
import com.nhomsau.repository.impl.DiemRepository;
import com.nhomsau.viewmodel.BangDiemTheoMon;
import com.nhomsau.viewmodel.QuanLyDiem;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IDiemService {
    List<BangDiemTheoMon> thongKeDiemTheoMon(String idMon,String idNganh,String idKy,Float min,Float max);
    List<BangDiemTheoMon> thongKeDiemTaCaMon(String idNganh,String idKy,Double min,Double max);
    List<BangDiem> getDiem(String idsv,String idmon);
    List<QuanLyDiem> getDiemByMon(String idDauDiem,String idMon,String idLop);
}
