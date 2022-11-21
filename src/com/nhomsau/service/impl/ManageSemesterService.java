/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.converter.SemesterConvert1;
import com.nhomsau.domainmodel.Semester;
import com.nhomsau.repository.ISemesterRepository;
import com.nhomsau.repository.impl.SemesterRepository;
import com.nhomsau.service.IManageMajorService;
import com.nhomsau.service.IManageSemesterService;
import com.nhomsau.viewmodel.ManageSemester;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ManageSemesterService implements IManageSemesterService{

    private final ISemesterRepository _semesterRepository;
    private final SemesterConvert1 _semesterConvert;
    public ManageSemesterService() {
        _semesterRepository = new SemesterRepository();
        _semesterConvert = new SemesterConvert1();
    }
    
    @Override
    public List<ManageSemester> findAll() {
        List<ManageSemester> list = new ArrayList<>();
        List<Semester> listMajor = _semesterRepository.findAll();
        for (Semester semester : listMajor) {
            list.add(_semesterConvert.toViewModel(semester));
        }
        return list;
    }
}
