/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.converter;

import com.nhomsau.domainmodel.Subject;
import com.nhomsau.repository.impl.SubjectRepository;
import com.nhomsau.viewmodel.ManageSubject;
import com.nhomsau.repository.ISubjectRepository;

/**
 *
 * @author Admin
 */
public class SubjectConvert {

    private ISubjectRepository classRepository;

    public SubjectConvert() {
        classRepository = new SubjectRepository();
    }

    public Subject toDomainModel(ManageSubject manageClass) {
        Subject classr = new Subject();
        if (manageClass != null) {
            classr.setId(classRepository.findByCode(manageClass.getCode()).getId());
            classr.setCode(manageClass.getCode());
            classr.setName(manageClass.getName());
        }
        return classr;
    }

    public ManageSubject toViewModel(Subject major) {
        ManageSubject manageClass = new ManageSubject();
        if (major != null) {
            manageClass.setCode(major.getCode());
            manageClass.setName(major.getName());
        }
        return manageClass;
    }
}
