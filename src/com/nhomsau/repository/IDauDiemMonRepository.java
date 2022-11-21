/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.domainmodel.DauDiemMon;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IDauDiemMonRepository {
    void insert(DauDiemMon dm);
    void delete(String idDauDiem, String idMOn);
    List<DauDiemMon> findAll();
}
