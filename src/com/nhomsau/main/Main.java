/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.main;

import com.nhomsau.domainmodel.SinhVien;
import com.nhomsau.repository.impl.DiemRepository;
import com.nhomsau.repository.impl.KyRepository;
import com.nhomsau.repository.impl.MonRepository;
import com.nhomsau.repository.impl.NganhRepository;
import com.nhomsau.repository.impl.SinhVienLopRepository;
import com.nhomsau.repository.impl.SinhVienRepository;
import com.nhomsau.service.impl.MonService;
import com.nhomsau.viewmodel.QuanLyMon;
import com.nhomsau.viewmodel.SinhVienView;
import com.raven.form.LoginFrame;
import java.util.List;
import ru.krlvm.swingacrylic.SwingAcrylic;

/**
 *
 * @author Nguyen Duy Hung
 */
public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingAcrylic.prepareSwing();
                com.raven.form.LoginFrame frame = new com.raven.form.LoginFrame();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                SwingAcrylic.processFrame(frame);
            }
        });
    }
}
