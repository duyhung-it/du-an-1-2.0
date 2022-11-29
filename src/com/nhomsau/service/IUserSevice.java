/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhomsau.service;

import com.nhomsau.viewmodel.LoginModel;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IUserSevice {
    LoginModel verifyLogin(String email,String password);
}
