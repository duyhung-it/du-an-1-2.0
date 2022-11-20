/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.domainmodel.Mon;
import com.nhomsau.mapper.MonMapper;
import com.nhomsau.repository.IMonRepository;
import com.nhomsau.repository.impl.MonRepository;
import com.nhomsau.service.IMonService;
import com.nhomsau.viewmodel.QuanLyMon;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class MonService implements IMonService {
    private final IMonRepository repository;
    private final MonMapper mapper;
    public MonService() {
        this.repository = new MonRepository();
        mapper = new MonMapper();
    }
    
    @Override
    public List<QuanLyMon> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<QuanLyMon> getMonTheoNganh(String idNganh,String idKy) {
        return this.repository.getMonTheoNganh(idNganh, idKy);
    }

    @Override
    public QuanLyMon findOne(String id) {
        return this.repository.findOne(id);
    }

    @Override
    public List<QuanLyMon> findMon(String idky) {
        return this.repository.findMon(idky);
    }

    @Override
    public void insert(QuanLyMon mon) {
        Mon m = mapper.toDomainModel(mon);
        this.repository.insert(m);
    }

    @Override
    public void update(QuanLyMon mon) {
        Mon m = mapper.toDomainModel(mon);
        this.repository.update(m);
    }

    @Override
    public void delete(String idMon) {
        this.repository.delete(idMon);
    }
    
}
