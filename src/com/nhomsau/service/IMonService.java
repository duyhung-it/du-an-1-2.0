/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.service;

import com.nhomsau.viewmodel.QuanLyMon;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IMonService {
    List<QuanLyMon> findAll();
    List<QuanLyMon> getMonTheoNganh(String idNganh,String idKy);
    QuanLyMon findOne(String id);
    List<QuanLyMon> findMon(String idky);
    void insert(QuanLyMon mon);
    void update (QuanLyMon mon);
    void delete(String idMon);
}
