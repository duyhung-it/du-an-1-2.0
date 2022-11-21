/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.service;

import com.nhomsau.viewmodel.ManageSemester;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IManageSemesterService {

    public List<ManageSemester> findAll();
    
}
