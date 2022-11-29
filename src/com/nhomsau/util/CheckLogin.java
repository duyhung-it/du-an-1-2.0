/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.util;

import com.nhomsau.viewmodel.LoginModel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class CheckLogin {
    public static LoginModel loginModel;

    public CheckLogin() {
        
    }
    public LoginModel getModel(){
        return loginModel;
    }
    public void setLogin(LoginModel model){
        this.loginModel = loginModel;
    }
    public static boolean isLogin(){
        if(loginModel == null) return false;
        return true;
    }
}
