/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.converter;

import com.nhomsau.domainmodel.Lecturer;
import com.nhomsau.repository.ILecturerRepository;
import com.nhomsau.repository.impl.LecturerRepository;
import com.nhomsau.viewmodel.ManageLecturer;

/**
 *
 * @author Admin
 */
public class LecturerConvert {

    private final MajorConvert _majorConvert;
    private final ManagerConvert _managerConvert;
    private ILecturerRepository _lectureRepository;

    public LecturerConvert() {
        this._majorConvert = new MajorConvert();
        _managerConvert = new ManagerConvert();
        _lectureRepository = new LecturerRepository();
    }

    public Lecturer toDomainModel(ManageLecturer viewModel) {
        Lecturer domain = new Lecturer();
        if (viewModel != null) {
            domain.setId(null);
            domain.setCode(viewModel.getCode());
            domain.setFullname(viewModel.getFullname());
            domain.setGender(viewModel.getGender());
            domain.setdOB(viewModel.getdOB());
            domain.setAddress(viewModel.getAddress());
            domain.setEmail(viewModel.getEmail());
            domain.setPhone(viewModel.getPhone());
            domain.setPassword(viewModel.getPassword());
            domain.setRole(viewModel.getRole());
            domain.setMajor(_majorConvert.toDomainModel(viewModel.getMajor()));
            domain.setManager(_managerConvert.toDomainModel(viewModel.getManager()));
        }
        return domain;
    }

    public ManageLecturer toViewModel(Lecturer domainModel) {
        ManageLecturer viewModel = new ManageLecturer();
        if (domainModel != null) {
            viewModel.setCode(domainModel.getCode());
            viewModel.setFullname(domainModel.getFullname());
            viewModel.setGender(domainModel.getGender());
            viewModel.setdOB(domainModel.getdOB());
            viewModel.setAddress(domainModel.getAddress());
            viewModel.setEmail(domainModel.getEmail());
            viewModel.setPhone(domainModel.getPhone());
            viewModel.setPassword(domainModel.getPassword());
            viewModel.setRole(domainModel.getRole());
            viewModel.setMajor(_majorConvert.toViewModel(domainModel.getMajor()));
            viewModel.setManager(_managerConvert.toViewModel(domainModel.getManager()));
            return viewModel;
        }
        return null;
    }
}
