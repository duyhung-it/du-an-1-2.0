/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.domainmodel.Lop;
import com.nhomsau.repository.ILopRepository;
import com.nhomsau.repository.impl.LopRepository;
import com.nhomsau.service.ILopService;
import com.nhomsau.viewmodel.QuanLyLop;
import com.nhomsau.viewmodel.TienDoDiemModel;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class LopService implements ILopService{
    private final LopRepository repository;

    public LopService() {
        this.repository = new LopRepository();
    }
    
    @Override
    public Lop findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void insert(Lop lop) {
        this.repository.insert(lop);
    }

    @Override
    public void update(Lop lop) {
        this.repository.update(lop);
    }

    @Override
    public List<QuanLyLop> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void delete(String idLop) {
        this.repository.delete(idLop);
    }

    @Override
    public QuanLyLop findByMa(String ma) {
        return this.repository.findByMa(ma);
    }

    @Override
    public List<QuanLyLop> findByTen(String ten) {
        return this.repository.findByTen(ten);
    }

    @Override
    public List<QuanLyLop> findByMon(String idMon,String idNganh,String idKy) {
        return this.repository.findByMon(idMon, idNganh, idKy);
    }

    @Override
    public List<TienDoDiemModel> thongKeTienDoTheoLop(String idDauDiem, String idMon, String idLop) {
        return this.repository.thongKeTienDoTheoLop(idDauDiem, idMon, idLop);
    }
}
