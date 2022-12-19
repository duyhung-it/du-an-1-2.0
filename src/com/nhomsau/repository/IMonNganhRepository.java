/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.domainmodel.MonNganh;
import java.util.List;

/**
 *
 * @author HaTanBinh
 */
public interface IMonNganhRepository {
    List<MonNganh> findMonNganh1(String idNganh);
    List<MonNganh> findMonNganh(String idNganh);
    void insert(MonNganh monNganh);
    void delete(MonNganh mn);
}
