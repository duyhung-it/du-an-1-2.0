/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.converter.MajorConvert;
import com.nhomsau.domainmodel.Major;
import com.nhomsau.repository.IMajorRepository;
import com.nhomsau.repository.impl.MajorRepository;
import com.nhomsau.service.IManageMajorService;
import com.nhomsau.viewmodel.ManageMajor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ManageMajorService implements IManageMajorService{

    private final IMajorRepository _majorRepository;
    private final MajorConvert _majorConvert;
    public ManageMajorService() {
        _majorRepository = new MajorRepository();
        _majorConvert = new MajorConvert();
    }
    
    @Override
    public List<ManageMajor> findAll() {
        List<ManageMajor> list = new ArrayList<>();
        List<Major> listMajor = _majorRepository.findAll();
        for (Major major : listMajor) {
            list.add(_majorConvert.toViewModel(major));
        }
        return list;
    }
}
