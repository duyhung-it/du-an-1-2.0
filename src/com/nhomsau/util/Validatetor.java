/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class Validatetor {

    public static String kiemTraRong(JTextField txt, String errmess) {
        String str = txt.getText();
        if (str.isBlank()) {
            MessageInfo.msgWarning(errmess);
            txt.requestFocus();
            return null;
        }
        return str;
    }

    public static String kiemTraRong(JTextArea txt, String errmess) {
        String str = txt.getText();
        if (str.isBlank()) {
            MessageInfo.msgWarning(errmess);
            txt.requestFocus();
            return null;
        }
        return str;
    }

    public static String kiemTraRong(JPasswordField txt, String errmess) {
        String str = String.valueOf(txt.getPassword());
        if (str.isBlank()) {
            MessageInfo.msgWarning(errmess);
            txt.requestFocus();
            return null;
        }
        return str;
    }

    public static Float kiemTraSo(JTextField txt, String mes1, String mes2) {
        Float x = 0.f;
        if (kiemTraRong(txt, mes1) == null) {
            return null;
        }
        try {
            x = Float.parseFloat(txt.getText());
//            if (x < 0 || x > 10) {
//                MessageInfo.msgWarning(mes2);
//                txt.requestFocus();
//                return null;
//            }
        } catch (Exception e) {
            MessageInfo.msgWarning(mes1);
            txt.requestFocus();
            return null;
        }
        return x;
    }

    public static String kiemTraSoDienThoai(JTextField txt, String errmess) {
        if (kiemTraRong(txt, "Vui lòng nhập số điện thoại") == null) {
            return null;
        }
        String str = txt.getText();
        String fomat = "0[0-9]{9}";
        if (!str.matches(fomat)) {
            MessageInfo.msgWarning(errmess);
            txt.requestFocus();
            return null;
        }
        return str;
    }

    public static String kiemTraEmail(JTextField txt, String errmess) {
        if (kiemTraRong(txt, "Vui lòng nhập địa chỉ email") == null) {
            return null;
        }
        String str = txt.getText();
        String fomat = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if (!str.matches(fomat)) {
            MessageInfo.msgWarning(errmess);
            txt.requestFocus();
            return null;
        }
        return str;
    }
    public Date getDateYYYY(java.util.Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return Date.valueOf(sdf.format(date));
    }
    public String getDateDD(java.util.Date date) {
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date);
    }
    public java.util.Date getDateDDStr(String dateStr) {
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException ex) {
            Logger.getLogger(Validatetor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
