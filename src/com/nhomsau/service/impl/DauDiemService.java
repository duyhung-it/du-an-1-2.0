/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.domainmodel.DauDiem;
import com.nhomsau.repository.IDauDiemRepository;
import com.nhomsau.repository.impl.DauDiemRepository;
import com.nhomsau.service.IDauDiemService;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DauDiemService implements IDauDiemService{

    private final IDauDiemRepository IDauDiemRepository;

    public DauDiemService() {
        this.IDauDiemRepository = new DauDiemRepository();
    }
    
    @Override
    public List<DauDiem> findAll() {
        return IDauDiemRepository.findAll();
    }
    
}
