/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.domainmodel.BangDiem;
import com.nhomsau.viewmodel.BangDiemTheoMon;
import com.nhomsau.viewmodel.QuanLyDiem;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IDiemRepository {
    List<BangDiemTheoMon> thongKeDiemTheoMon(String idMon,String idKy,String idNganh,Float min, Float max);
    List<BangDiemTheoMon> thongKeDiemTatCaMon(String idNganh, String idKy, Double min, Double max);
    List<BangDiem> getDiem(String idsv,String idmon);
    List<QuanLyDiem> getDiemByMon(String idDauDiem,String idMon,String idLop);
    BangDiemTheoMon getDiemTrungBinhTheoId(String idSV,String idKy,String idNganh,String idMon);
}
