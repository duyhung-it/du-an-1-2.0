/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.service;

import com.nhomsau.viewmodel.ManageLecturer;
import com.nhomsau.viewmodel.QuanLyGiangVien;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IManageLecturerService {

    public List<ManageLecturer> findAll();

    public ManageLecturer findByCode(String code);

    public boolean insert(ManageLecturer manageLecturer);

    public boolean updateLecturer(ManageLecturer lecturer);

    public boolean deleteLec(String code);
    QuanLyGiangVien findById(String id);
    List<QuanLyGiangVien> getAll();
}
