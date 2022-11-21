/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.service;

import com.nhomsau.domainmodel.DauDiemMon;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IDauDiem_MonService {
    void insert(DauDiemMon dm);
    void delete(String idDauDiem, String idMon);
    List<DauDiemMon> findAll();
}
