/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.mapper.LoginMapper;
import com.nhomsau.repository.IUserRepository;
import com.nhomsau.util.DBConnection;
import com.nhomsau.viewmodel.LoginModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nguyen Duy Hung
 */
public class UserRepository implements IUserRepository {
    private final LoginMapper mapper;

    public UserRepository() {
        this.mapper = new LoginMapper();
    }
    
    @Override
    public LoginModel verifyLogin(String email, String password) {
        StringBuilder sql = new StringBuilder("SELECT * FROM Users ");
        sql.append("where Email = ? and MatKhau = ?");
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql.toString(), email,password);
            while(rs.next()){
                return this.mapper.mapRowView(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
