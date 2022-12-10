/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.util;

import com.nhomsau.viewmodel.LoginModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Duy Hung
 */
public class Writor<T> {
    public void wirte(T t){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("login.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Writor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Writor.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(Writor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public T read(){
        try {
            FileInputStream fis = new FileInputStream("login.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            T model = null;
                 model = (T) ois.readObject();
            return model;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Writor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Writor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Writor.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
}
