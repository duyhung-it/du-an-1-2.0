/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.domainmodel.DauDiemMon;
import com.nhomsau.repository.IDauDiemMonRepository;
import com.nhomsau.repository.impl.DauDiemMonRepository;
import com.nhomsau.service.IDauDiem_MonService;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DauDiem_MonService implements IDauDiem_MonService{

    private final IDauDiemMonRepository iDauDiemMonRepository;

    public DauDiem_MonService() {
        this.iDauDiemMonRepository = new DauDiemMonRepository();
    }
    
    @Override
    public List<DauDiemMon> findAll() {
        return iDauDiemMonRepository.findAll();
    }

    @Override
    public void insert(DauDiemMon dm) {
        iDauDiemMonRepository.insert(dm);
    }

    @Override
    public void delete(String idDauDiem, String idMon) {
        iDauDiemMonRepository.delete(idDauDiem, idMon);
    }
    
}
