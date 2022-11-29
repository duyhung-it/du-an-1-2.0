/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.repository.IUserRepository;
import com.nhomsau.repository.impl.UserRepository;
import com.nhomsau.service.IUserSevice;
import com.nhomsau.viewmodel.LoginModel;
import jdk.javadoc.doclet.Reporter;

/**
 *
 * @author Nguyen Duy Hung
 */
public class UserService implements IUserSevice {
    private final IUserRepository repository;

    public UserService() {
        this.repository = new UserRepository();
    }
    
    @Override
    public LoginModel verifyLogin(String email, String password) {
        return this.repository.verifyLogin(email, password);
    }
    
}
