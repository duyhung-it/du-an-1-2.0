/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.domainmodel.BangDiem;
import com.nhomsau.viewmodel.BangDiemTheoMon;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IDiemRepository {
    List<BangDiemTheoMon> thongKeDiemTheoMon(String idMon,String idKy,String idNganh);
    List<BangDiemTheoMon> thongKeDiemTatCaMon(String idNganh, String idKy);
    List<BangDiem> getDiem(String idsv,String idmon);
}
