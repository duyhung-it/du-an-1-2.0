/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.converter.SubjectConvert;
import com.nhomsau.domainmodel.Subject;
import com.nhomsau.repository.IMajorRepository;
import com.nhomsau.service.IManageMajorService;
import com.nhomsau.viewmodel.ManageSubject;
import com.nhomsau.viewmodel.ManageMajor;
import java.util.ArrayList;
import java.util.List;
import com.nhomsau.repository.ISubjectRepository;
import com.nhomsau.repository.impl.SubjectRepository;
import com.nhomsau.service.IManageSubjectService;

/**
 *
 * @author Admin
 */
public class ManageSubjectService implements IManageSubjectService{

    private final ISubjectRepository _classRepository;
    private final SubjectConvert _majorConvert;
    public ManageSubjectService() {
        _classRepository = new SubjectRepository();
        _majorConvert = new SubjectConvert();
    }
    
    @Override
    public List<ManageSubject> findAll() {
        List<ManageSubject> list = new ArrayList<>();
        List<Subject> listClass = _classRepository.findAll();
        for (Subject classr : listClass) {
            list.add(_majorConvert.toViewModel(classr));
        }
        return list;
    }
}
