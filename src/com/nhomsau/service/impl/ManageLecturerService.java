/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.converter.LecturerConvert;
import com.nhomsau.domainmodel.Lecturer;
import com.nhomsau.repository.ILecturerRepository;
import com.nhomsau.repository.impl.LecturerRepository;
import com.nhomsau.service.IManageLecturerService;
import com.nhomsau.viewmodel.ManageLecturer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ManageLecturerService implements IManageLecturerService {

    private final ILecturerRepository lecturerRepository;
    private final LecturerConvert _lecturerConvert;

    public ManageLecturerService() {
        this.lecturerRepository = new LecturerRepository();
        this._lecturerConvert = new LecturerConvert();
    }

    @Override
    public List<ManageLecturer> findAll() {
        List<ManageLecturer> list = new ArrayList<>();
        List<Lecturer> listLecturers = lecturerRepository.findAll();
        for (Lecturer lecturer : listLecturers) {
            list.add(_lecturerConvert.toViewModel(lecturer));
        }
        return list;
    }

    @Override
    public ManageLecturer findByCode(String code) {
        Lecturer result = lecturerRepository.findByCode(code);
        ManageLecturer lecturer = _lecturerConvert.toViewModel(result);
        return lecturer;
    }

    @Override
    public boolean insert(ManageLecturer manageLecturer) {
        Lecturer lecturer = _lecturerConvert.toDomainModel(manageLecturer);
        return lecturerRepository.insert(lecturer);
    }

    @Override
    public boolean updateLecturer(ManageLecturer lecturer) {
        Lecturer lecturerUp = _lecturerConvert.toDomainModel(lecturer);
        lecturerUp.setId(lecturerRepository.findByCode(lecturer.getCode()).getId());
        return lecturerRepository.updateLec(lecturerUp);
    }

    @Override
    public boolean deleteLec(String code) {
        String id = lecturerRepository.findByCode(code).getId();
        return lecturerRepository.deleteLec(id);
    }

}
