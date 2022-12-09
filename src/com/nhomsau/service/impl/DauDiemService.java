/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.domainmodel.DauDiem;
import com.nhomsau.repository.IDauDiemRepository;
import com.nhomsau.repository.impl.DauDiemRepository;
import com.nhomsau.service.IDauDiemService;
import com.nhomsau.viewmodel.QuanLyDauDiem;
import java.util.ArrayList;
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

    @Override
    public void insert(QuanLyDauDiem dauDiem) {
        if(dauDiem != null){
        DauDiem dd = new DauDiem();
        dd.setMaDauDiem(dauDiem.getMa());
        dd.setTenDauDiem(dauDiem.getTen());
        this.dauDiemRepository.insert(dd);
        }
    }

    @Override
    public void update(QuanLyDauDiem dauDiem) {
        if(dauDiem != null){
        DauDiem dd = new DauDiem();
        dd.setMaDauDiem(dauDiem.getMa());
        dd.setTenDauDiem(dauDiem.getTen());
        this.dauDiemRepository.update(dd);
        }
    }

    @Override
    public void delete(String ma) {
        this.dauDiemRepository.delete(ma);
    }

    @Override
    public List<QuanLyDauDiem> findAllView() {
        List<QuanLyDauDiem> listResult = new ArrayList<>();
        List<DauDiem> list = this.dauDiemRepository.findAll();
        for(DauDiem dd : list){
            listResult.add(new QuanLyDauDiem(dd.getMaDauDiem(), dd.getTenDauDiem()));
        }
        return listResult;
    }
}
