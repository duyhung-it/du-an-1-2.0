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
    void insert(DauDiem dd);
    void delete(DauDiem dd);
}
