/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.converter.ManagerConvert;
import com.nhomsau.domainmodel.Major;
import com.nhomsau.domainmodel.Manager;
import com.nhomsau.domainmodel.Semester;
import com.nhomsau.domainmodel.Subject;
import com.nhomsau.repository.IMajorRepository;
import com.nhomsau.repository.IManagerRepository;
import com.nhomsau.repository.ISemesterRepository;
import com.nhomsau.repository.ISubjectRepository;
import com.nhomsau.repository.impl.MajorRepository;
import com.nhomsau.repository.impl.ManagerRepository;
import com.nhomsau.repository.impl.SemesterRepository;
import com.nhomsau.repository.impl.SubjectRepository;
import com.nhomsau.service.IManageManagerService;
import com.nhomsau.viewmodel.ManageManager;
import com.nhomsau.viewmodel.Statistical;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ManageManagerService implements IManageManagerService {

    private final ManagerConvert _managerConvert;
    private final IManagerRepository _manageRepository;
    private final ISubjectRepository _subjectRepository;
    private final IMajorRepository _majorRepository;
    private final ISemesterRepository _semesterRepository;

    public ManageManagerService() {
        this._managerConvert = new ManagerConvert();
        this._manageRepository = new ManagerRepository();
        this._subjectRepository = new SubjectRepository();
        this._majorRepository = new MajorRepository();
        this._semesterRepository = new SemesterRepository();
    }

    @Override
    public List<ManageManager> findAll() {
        List<Manager> listManager = _manageRepository.findAll();
        List<ManageManager> list = new ArrayList<>();
        for (Manager manager : listManager) {
            list.add(_managerConvert.toViewModel(manager));
        }
        return list;
    }

    @Override
    public List<Statistical> findListStudent(String code, String code1, String code2) {
        Subject subject = _subjectRepository.findByCode(code);
        Major major = _majorRepository.findByCode(code1);
        Semester semester = _semesterRepository.findByCode(code2);
        List<Statistical> list = _manageRepository.findListStudent(subject.getId(), major.getId(), semester.getId());
        return list;
    }

}
