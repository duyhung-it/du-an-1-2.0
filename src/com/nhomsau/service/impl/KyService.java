/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.domainmodel.Ky;
import com.nhomsau.mapper.KyMapper;
import com.nhomsau.repository.IKyRepository;
import com.nhomsau.repository.impl.KyRepository;
import com.nhomsau.service.IKyService;
import com.nhomsau.viewmodel.QuanLyKy;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class KyService implements IKyService {

    private final IKyRepository repository;
    KyMapper kyMapper;

    public KyService() {
        this.repository = new KyRepository();
        kyMapper = new KyMapper();
    }

    @Override
    public List<QuanLyKy> findAll() {
        return this.repository.findAll();
    }
     @Override
    public void insert(QuanLyKy ky) {
        Ky k = kyMapper.toDomainModel(ky);
        this.repository.insert(k);
    }

    @Override
    public void delete(String idKy) {
        this.repository.delete(idKy);
    }

    @Override
    public void update(QuanLyKy ky) {
        Ky k = kyMapper.toDomainModel(ky);
        this.repository.update(k);
    }

    @Override
    public String getIdKy(String maKy) {
        return this.repository.getIdKy(maKy);
    }

}
