/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.converter;

import com.nhomsau.domainmodel.Major;
import com.nhomsau.repository.IMajorRepository;
import com.nhomsau.repository.impl.MajorRepository;
import com.nhomsau.viewmodel.ManageMajor;

/**
 *
 * @author Admin
 */
public class MajorConvert {

    private IMajorRepository majorRepository;

    public MajorConvert() {
        majorRepository = new MajorRepository();
    }

    public Major toDomainModel(ManageMajor manageMajor) {
        Major major = new Major();
        if (manageMajor != null) {
            major.setId(majorRepository.findByCode(manageMajor.getCode()).getId());
            major.setCode(manageMajor.getCode());
            major.setName(manageMajor.getName());
        }
        return major;
    }

    public ManageMajor toViewModel(Major major) {
        ManageMajor manageMajor = new ManageMajor();
        if (major != null) {
            manageMajor.setCode(major.getCode());
            manageMajor.setName(major.getName());
        }
        return manageMajor;
    }
}
