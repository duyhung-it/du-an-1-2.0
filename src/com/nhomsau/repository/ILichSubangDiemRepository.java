/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.domainmodel.LichSuaBangDiem;
import java.util.List;

/**
 *
 * @author HaTanBinh
 */
public interface ILichSubangDiemRepository {
    List<LichSuaBangDiem> getLichSudiem(String idsv);
}
