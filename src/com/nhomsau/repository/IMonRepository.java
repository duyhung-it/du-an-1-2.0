/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.domainmodel.Mon;
import com.nhomsau.viewmodel.QuanLyMon;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IMonRepository {
    List<QuanLyMon> findAll();
    List<QuanLyMon> getMonTheoNganh(String idNganh,String idKy); 
    QuanLyMon findOne(String idMon);
    void insert(Mon mon);
    void delete(String idMon);
    void update(Mon mon);
    List<QuanLyMon> findMon(String idky);
    String getTenMon(String id);
}
