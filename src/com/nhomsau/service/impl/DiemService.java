/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.domainmodel.BangDiem;
import com.nhomsau.repository.IDiemRepository;
import com.nhomsau.repository.impl.DiemRepository;
import com.nhomsau.service.IDiemService;
import com.nhomsau.viewmodel.BangDiemTheoMon;
import com.nhomsau.viewmodel.QuanLyDiem;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class DiemService implements IDiemService {
    private final IDiemRepository repository;

    public DiemService() {
        this.repository = new DiemRepository();
    }
    
    @Override
    public List<BangDiemTheoMon> thongKeDiemTheoMon(String idMon,String idNganh,String idKy,Float min,Float max) {
        return this.repository.thongKeDiemTheoMon(idMon, idKy, idNganh, min, max);
    }

    @Override
    public List<BangDiemTheoMon> thongKeDiemTaCaMon(String idNganh, String idKy,Double min,Double max) {
        return this.repository.thongKeDiemTatCaMon(idNganh, idKy,min,max);
    }

    @Override
    public List<BangDiem> getDiem(String idsv, String idmon) {
        return this.repository.getDiem(idsv, idmon);
    }

    @Override
    public List<QuanLyDiem> getDiemByMon(String idDauDiem, String idMon, String idLop) {
        return this.repository.getDiemByMon(idDauDiem, idMon, idLop);
    }
    
}
