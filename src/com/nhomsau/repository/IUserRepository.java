/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.repository;

import com.nhomsau.viewmodel.LoginModel;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IUserRepository {
    LoginModel verifyLogin(String email,String password);
}
