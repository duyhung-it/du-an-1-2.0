/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.service;

import com.nhomsau.viewmodel.QuanLyNganh;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface INganhService {
    List<QuanLyNganh> findAll1();
    QuanLyNganh findOne(String idNganh);
}
