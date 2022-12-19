/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.domainmodel.Nganh;
import com.nhomsau.repository.INganhRepository;
import com.nhomsau.repository.impl.NganhRepository;
import com.nhomsau.service.INganhService;
import com.nhomsau.viewmodel.QuanLyNganh;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class NganhService implements INganhService {
    private final NganhRepository repository;

    public NganhService() {
        this.repository = new NganhRepository();
    }
    
    @Override
    public List<QuanLyNganh> findAll1() {
        return this.repository.findAll1();
    }
    public List<Nganh> findAll() {
        List<Nganh> nganh = new ArrayList<>();
        nganh = repository.findAll();
        return nganh;
    }

    public String newNganh(Nganh nganh) {
        if (repository.save(nganh) == true) {
            return "add thanh cong";
        } else {
            return "add that bai";
        }
    }
    public String deleteNganh(String id){
        if(repository.delete(id)==true){
            return "xoa thanh cong";
            
        }else{
            return "xoa khong thanh cong";
        }
    } 
    public String updateNganh(String maNganh,String tenNganh,String id){
        if(repository.update(maNganh, tenNganh, id)==true){
            return "update thanh cong";
        }else{
            return "update khong thanh cong";
        }
    }

    @Override
    public QuanLyNganh findOne(String idNganh) {
        return this.repository.findOne(idNganh);
    }

    @Override
    public String findIdNganh(String maNganh) {
        return this.repository.findIdNganh(maNganh);
    }
    
}
