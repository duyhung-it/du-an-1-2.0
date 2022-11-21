/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.domainmodel.Major;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IMajorRepository {

    public List<Major> findAll();

    public Major findByID(String id);
    public Major findByCode(String code);
}
