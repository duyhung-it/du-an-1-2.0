/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.domainmodel.Ky;
import com.nhomsau.viewmodel.QuanLyKy;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IKyRepository {
    List<QuanLyKy> findAll();
    void insert(Ky ky);
    void delete(String maKy);
}
