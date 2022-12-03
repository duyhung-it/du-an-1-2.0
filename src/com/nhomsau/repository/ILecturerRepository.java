/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.domainmodel.Lecturer;
import com.nhomsau.viewmodel.ManageLecturer;
import com.nhomsau.viewmodel.QuanLyGiangVien;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ILecturerRepository {

    public List<Lecturer> findAll();

    public Lecturer findByCode(String code);
    
    public Lecturer findByCode2(String code);

    public boolean insert(Lecturer lecturer);

    public boolean updateLec(Lecturer lecturerUp);

    public boolean deleteLec(String id);
    QuanLyGiangVien findById(String id);
    List<QuanLyGiangVien> getAll();
    
}
