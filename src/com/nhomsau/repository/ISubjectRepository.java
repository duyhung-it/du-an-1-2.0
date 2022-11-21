/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.domainmodel.Subject;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ISubjectRepository {

    public List<Subject> findAll();

    public Subject findByID(String id);

    public Subject findByCode(String code);
}
