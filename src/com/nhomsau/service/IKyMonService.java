/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhomsau.service;

import com.nhomsau.domainmodel.KyMon;

/**
 *
 * @author Admin
 */
public interface IKyMonService {
    void insert(KyMon kyMon);
    void delete(KyMon kyMon);
}
