/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.LichSuaBangDiem;
import com.nhomsau.repository.ILichSubangDiemRepository;
import com.nhomsau.util.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HaTanBinh
 */
public class LichSuDiemReposiroty implements ILichSubangDiemRepository{
    final String sql="select TenMon,MaMon,TenKy, Sum(Diem.Diem * DauDiem_Mon.HeSo/100) 'DiemTrungBinh'\n" +
"	from Diem " +
"	join DauDiem_Mon on DauDiem_Mon.IdDauDiem = Diem.IdDauDiem and Diem.IdMonHoc = DauDiem_Mon.IdMon " +
"	join Mon on Diem.IdMonHoc = Mon.Id " +
"	join Ky_Mon on Ky_Mon.IdMon = Diem.IdMonHoc " +
"	join Ky on Ky_Mon.IdKy = Ky.Id " +
"       where idsinhvien='519f74ea-e199-4da0-aaa6-a2e6e3f49a2f' "+
"	group by TenMon,MaMon,TenKy";
    @Override
    public List<LichSuaBangDiem> getLichSudiem(String idsv) {
         List<LichSuaBangDiem> list=new ArrayList<>();
        try {
            
            ResultSet rs=DBConnection.getDataFromQuery(sql);
            while(rs.next()){
                String tenMon=rs.getString(1);
                String maMon=rs.getString(2);
                String tenKy=rs.getString(3);
                double diem=Double.valueOf(rs.getBigDecimal(4)+"");
                String trangThai="";
                if(diem>=5){
                    trangThai="Passed";
                }else{
                    trangThai="Failed";
                }
                LichSuaBangDiem ls=new LichSuaBangDiem(tenMon, maMon, tenKy, diem,trangThai);
                list.add(ls);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichSuDiemReposiroty.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
