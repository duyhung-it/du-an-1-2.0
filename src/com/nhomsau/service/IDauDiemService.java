/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.service;

import com.nhomsau.domainmodel.DauDiem;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IDauDiemService {
    List<DauDiem> findAll();
    List<DauDiem> findDauDiemByIdMon(String id);
    String getTenDauDiem(String id);
    List<DauDiem> findDauDiemByMon(String idMon,String idNganh);
}
