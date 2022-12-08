/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.SinhVienMon;
import com.nhomsau.repository.ISinhVienMonRepository;
import com.nhomsau.util.DBConnection;

/**
 *
 * @author Nguyen Duy Hung
 */
public class SinhVienMonRepository implements ISinhVienMonRepository{

    @Override
    public void insert(SinhVienMon sinhVienMon) {
        String sql = "INSERT INTO [dbo].[SinhVien_Mon] ([IdSinhVien],[IdMon],[TinhTrang]) " +
                    " VALUES (?,?,?)";
        DBConnection.ExcuteDungna(sql, sinhVienMon.getIdSinhVien(),sinhVienMon.getIdMon(),sinhVienMon.getTinhTrang());
    }

    @Override
    public void delete(String idSinhVien) {
        String sql = "DELETE FROM SinhVien_Mon where IdSinhVien = ?";
        DBConnection.ExcuteDungna(sql, idSinhVien);
    }

    @Override
    public void updateStatus(SinhVienMon sinhVienMon) {
        String sql = "UPDATE [dbo].[SinhVien_Mon]\n" +
                    "   SET [TinhTrang] = ? " +
                    "   WHERE [IdSinhVien] = ? and [IdMon] = ?";
        DBConnection.ExcuteDungna(sql, sinhVienMon.getTinhTrang(),sinhVienMon.getIdSinhVien(),sinhVienMon.getIdMon());
    }

    @Override
    public int countSinhVienByLop(String maLop) {
        String sql = "select count(*) 'SoSinhVien' from Lop\n" +
                    " join SinhVien_Lop on Lop.Id = SinhVien_Lop.IdLop\n" +
                    " where MaLop = ?";
        return -1;
    }
    
}
