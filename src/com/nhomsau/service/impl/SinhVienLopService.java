/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.domainmodel.ModelSinhVienLop;
import com.nhomsau.repository.impl.SinhVienLopRepository;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class SinhVienLopService {
    private SinhVienLopRepository sinhVienLopRepository;

    public SinhVienLopService() {
        sinhVienLopRepository = new SinhVienLopRepository();
    }

    public List<ModelSinhVienLop> danhSinhVienLop() {
        return sinhVienLopRepository.danhSinhVienLop();
    }

    public String themSinhVienLop(ModelSinhVienLop a) {
        if (sinhVienLopRepository.themSinhVienLop(a) == true) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    public void xoaSinhVienLop(ModelSinhVienLop a) {
        sinhVienLopRepository.xoaSinhVienLop(a);
    }

    public String suaSinhVienLop(ModelSinhVienLop a) {
        if (sinhVienLopRepository.suaSinhVienLop(a) == true) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }
}
