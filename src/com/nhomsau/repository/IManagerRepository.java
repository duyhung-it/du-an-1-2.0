/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.domainmodel.Manager;
import com.nhomsau.viewmodel.Statistical;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IManagerRepository {

    public List<Manager> findAll();

    public Manager findByID(String id);

    public Manager findByCode(String code);

    public List<Statistical> findListStudent(String idSj, String idMj, String idSe, double minScore, double maxScore);

    public List<Statistical> findTotalListStudent(String idMon, String idNganh, String idKy, double minScore, double maxScore);

    public List<Statistical> findTotalListStudent(String idNganh, String idKy, double minScore, double maxScore);

}
