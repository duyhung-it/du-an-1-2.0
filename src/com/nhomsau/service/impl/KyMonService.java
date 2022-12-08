/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhomsau.service.impl;

import com.nhomsau.domainmodel.KyMon;
import com.nhomsau.repository.IKyMonRepository;
import com.nhomsau.repository.impl.KyMonRepository;
import com.nhomsau.service.IKyMonService;

/**
 *
 * @author Admin
 */
public class KyMonService implements IKyMonService{

    private IKyMonRepository kyMonRepository;
    public KyMonService() {
        kyMonRepository = new KyMonRepository();
    }
    
    

    @Override
    public void insert(KyMon kyMon) {
        this.kyMonRepository.insert(kyMon);
    }

    @Override
    public void delete(KyMon kyMon) {
        this.kyMonRepository.delete(kyMon);
    }
    
}
