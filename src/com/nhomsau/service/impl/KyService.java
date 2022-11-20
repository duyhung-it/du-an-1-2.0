/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

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

    public KyService() {
        this.repository = new KyRepository();
    }
    
    @Override
    public List<QuanLyKy> findAll() {
        return this.repository.findAll();
    }
    
}
