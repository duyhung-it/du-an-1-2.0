/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.service.impl;

import com.nhomsau.domainmodel.LichSuaBangDiem;
import com.nhomsau.repository.ILichSubangDiemRepository;
import com.nhomsau.repository.impl.LichSuDiemReposiroty;
import com.nhomsau.service.ILichSuBangDiemService;
import java.util.List;

/**
 *
 * @author HaTanBinh
 */
public class LichSuDiemService implements ILichSuBangDiemService{
    private final ILichSubangDiemRepository iLichSubangDiem;
    public LichSuDiemService(){
        iLichSubangDiem=new LichSuDiemReposiroty();
    }


    @Override
    public List<LichSuaBangDiem> getLichSudiem(String idsv) {
        List<LichSuaBangDiem> list=iLichSubangDiem.getLichSudiem(idsv);
        return list;
    }
}
