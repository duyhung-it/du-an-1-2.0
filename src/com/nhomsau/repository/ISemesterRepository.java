/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.domainmodel.Semester;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ISemesterRepository {

    public List<Semester> findAll();

    public Semester findByID(String id);

    public Semester findByCode(String code);
}
