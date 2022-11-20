/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.service;

import com.nhomsau.domainmodel.BangDiem;
import com.nhomsau.viewmodel.QuanLyKy;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IKyService {
    List<QuanLyKy> findAll();
}
