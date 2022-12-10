/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.service;

import com.nhomsau.viewmodel.ManageManager;
import com.nhomsau.viewmodel.Statistical;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IManageManagerService {

    public List<ManageManager> findAll();

    public List<Statistical> findListStudent(String code, String code1, String code2, double minScore, double maxScore);

    public List<Statistical> findTotalListStudent(String idMon, String idNganh, String idKy, double minScore, double maxScore);

    public List<Statistical> findTotalListStudentToMinMax(String idNganh, String idKy, double minScore, double maxScore);

    public List<Statistical> findTongSinhVienHocLuc(String idKy, String idNganh, double minScore, double maxScore);
    
}
