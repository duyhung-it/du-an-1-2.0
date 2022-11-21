/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.converter;

import com.nhomsau.domainmodel.Semester;
import com.nhomsau.repository.ISemesterRepository;
import com.nhomsau.repository.impl.SemesterRepository;
import com.nhomsau.viewmodel.ManageSemester;

/**
 *
 * @author Admin
 */
public class SemesterConvert1 {

    private ISemesterRepository semesterRepository;

    public SemesterConvert1() {
        semesterRepository = new SemesterRepository();
    }

    public Semester toDomainModel(ManageSemester manageSemester) {
        Semester semester = new Semester();
        if (manageSemester != null) {
            semester.setId(semesterRepository.findByCode(manageSemester.getCode()).getId());
            semester.setCode(manageSemester.getCode());
            semester.setName(manageSemester.getName());
        }
        return semester;
    }

    public ManageSemester toViewModel(Semester semester) {
        ManageSemester manageSemester = new ManageSemester();
        if (manageSemester != null) {
            manageSemester.setCode(semester.getCode());
            manageSemester.setName(semester.getName());
        }
        return manageSemester;
    }
}
