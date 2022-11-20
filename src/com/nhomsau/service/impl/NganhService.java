/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.repository.INganhRepository;
import com.nhomsau.repository.impl.NganhRepository;
import com.nhomsau.service.INganhService;
import com.nhomsau.viewmodel.QuanLyNganh;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class NganhService implements INganhService {
    private final INganhRepository repository;

    public NganhService() {
        this.repository = new NganhRepository();
    }
    
    @Override
    public List<QuanLyNganh> findAll() {
        return this.repository.findAll();
    }
    
}
