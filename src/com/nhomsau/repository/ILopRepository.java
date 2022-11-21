/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.domainmodel.Lop;
import com.nhomsau.viewmodel.QuanLyLop;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface ILopRepository {
    Lop findById(String id);
    List<QuanLyLop> findAll();
    void insert(Lop lop);
    void update(Lop lop);
    void delete(String idLop);
    QuanLyLop findByMa(String ma);
    List<QuanLyLop> findByTen(String ten);
}
