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

    private final IDauDiemRepository dauDiemRepository;

    public DauDiemService() {
        this.dauDiemRepository = new DauDiemRepository();
    }
    
    @Override
    public List<DauDiem> findAll() {
        return dauDiemRepository.findAll();
    }

    @Override
    public List<DauDiem> findDauDiemByIdMon(String id) {
        return dauDiemRepository.findAllDauDiem(id);
    }
    
    @Override
    public String getTenDauDiem(String id){
        return dauDiemRepository.getTenDauDiem(id);
    }

    @Override
    public List<DauDiem> findDauDiemByMon(String idMon, String idNganh) {
        return this.dauDiemRepository.findDauDiemByMon(idMon, idNganh);
    }

    @Override
    public String getIdDauDiem(String tenDauDiem) {
        return this.dauDiemRepository.getIdDauDiem(tenDauDiem);
    }
}
