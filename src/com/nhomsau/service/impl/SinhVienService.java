/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.domainmodel.SinhVien;
import com.nhomsau.mapper.SinhVienMapper;
import com.nhomsau.repository.ISinhVienRepository;
import com.nhomsau.repository.impl.SinhVienRepository;
import com.nhomsau.service.ISinhVienService;
import com.nhomsau.viewmodel.SinhVienView;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class SinhVienService implements ISinhVienService {
    private final SinhVienRepository repository;
    private final SinhVienMapper mapper;

    
    public List<SinhVien> getSinhViens(String idLop){
        return repository.getSinhViens(idLop);
    }
    public SinhVienService() {
        this.repository = new SinhVienRepository();
        mapper = new SinhVienMapper();
    }
    
    @Override
    public List<SinhVienView> findAll() {
        return repository.findAll();
    }

    @Override
    public SinhVienView findById(String id) {
        return repository.findById(id);
    }

    @Override
    public void insert(SinhVienView sinhVien) {
        SinhVien s = mapper.toDomainModel(sinhVien);
        this.repository.insert(s);
    }

    @Override
    public void update(SinhVienView sinhVien) {
        SinhVien s = mapper.toDomainModel(sinhVien);
        this.repository.update(s);
    }

    @Override
    public void delete(String ma) {
        this.repository.delete(ma);
    }

    @Override
    public SinhVienView findByMa(String ma) {
        return this.repository.findByMa(ma);
    }

    @Override
    public List<SinhVienView> findSinhVienTheoLop(String idLop) {
        return this.repository.findSinhVienTheoLop(idLop);
    }
    
}
