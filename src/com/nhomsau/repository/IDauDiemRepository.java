/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.domainmodel.DauDiem;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IDauDiemRepository {
    List<DauDiem> findAll();
    List<DauDiem> findAllDauDiem(String id);
    String getTenDauDiem(String id);
    void insert(DauDiem dd);
    void delete(String ma);
    void update(DauDiem dd);
    int countDauDiem(String idMon,String idNganh);
    List<DauDiem> findDauDiemByMon(String idMon,String idNganh);
    DauDiem findDauDiemByTen(String tenDauDiem);
    String getIdDauDiem(String tenDauDiem);
}
