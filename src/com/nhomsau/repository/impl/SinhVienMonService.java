/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.SinhVienMon;
import com.nhomsau.repository.ISinhVienMonRepository;
import com.nhomsau.service.ISinhVienMonService;

/**
 *
 * @author Nguyen Duy Hung
 */
public class SinhVienMonService implements ISinhVienMonService {
    private final ISinhVienMonRepository repository;

    public SinhVienMonService() {
        this.repository = new SinhVienMonRepository();
    }
    
    @Override
    public boolean insert(SinhVienMon sinhVienMon) {
        return this.repository.insert(sinhVienMon);
    }

    @Override
    public void delete(String idSinhVien) {
        this.repository.delete(idSinhVien);
    }

    @Override
    public void updateStatus(SinhVienMon sinhVienMon) {
        this.repository.updateStatus(sinhVienMon);
    }

    @Override
    public int countSinhVienByLop(String maLop) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
