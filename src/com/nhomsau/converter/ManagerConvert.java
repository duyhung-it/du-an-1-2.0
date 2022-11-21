/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.converter;

import com.nhomsau.domainmodel.Manager;
import com.nhomsau.repository.IManagerRepository;
import com.nhomsau.repository.impl.ManagerRepository;
import com.nhomsau.viewmodel.ManageManager;

/**
 *
 * @author Admin
 */
public class ManagerConvert {
    private IManagerRepository managerRepository;

    public ManagerConvert() {
        managerRepository = new ManagerRepository();
    }
    

    public Manager toDomainModel(ManageManager viewModel) {
        Manager domain = new Manager();
        if (viewModel != null) {
            domain.setId(managerRepository.findByCode(viewModel.getCode()).getId());
            domain.setCode(viewModel.getCode());
            domain.setFullname(viewModel.getName());
        }
        return domain;
    }

    public ManageManager toViewModel(Manager domainModel) {
        ManageManager viewModel = new ManageManager();
        if (domainModel != null) {
            viewModel.setCode(domainModel.getCode());
            viewModel.setName(domainModel.getFullname());
        }
        return viewModel;
    }
}
