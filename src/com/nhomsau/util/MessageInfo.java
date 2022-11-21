/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.util;

import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class MessageInfo {

    public static void msgTrue(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public static void msgFalse(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Lỗi",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void msgWarning(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Cảnh báo",
                JOptionPane.WARNING_MESSAGE);
    }

    public static boolean question(String msg) {
        int choose = JOptionPane.showConfirmDialog(null, msg, "Xác nhân",
                JOptionPane.YES_NO_OPTION);
        if (choose == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }
}
