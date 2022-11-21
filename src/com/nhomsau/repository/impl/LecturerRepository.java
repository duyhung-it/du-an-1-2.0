/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhomsau.repository.impl;

import com.nhomsau.domainmodel.Lecturer;
import com.nhomsau.domainmodel.Major;
import com.nhomsau.repository.ILecturerRepository;
import com.nhomsau.repository.IMajorRepository;
import com.nhomsau.repository.IManagerRepository;
import com.nhomsau.util.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class LecturerRepository implements ILecturerRepository {

    private MajorRepository _majorRepository;
    private ManagerRepository _managerRepository;

    public LecturerRepository() {
        _majorRepository = new MajorRepository();
        _managerRepository = new ManagerRepository();
    }

    @Override
    public List<Lecturer> findAll() {
        String sql = "SELECT [Id] ,[MaUser] ,[HoTen] ,[NgaySinh] ,[DiaChi] ,[Email] ,[SDT] ,[MatKhau] ,[ChucVu] ,[IdNganh] ,[IdNguoiTao] ,[GioiTinh] FROM [dbo].[Users] WHERE [ChucVu] = 2";
        List<Lecturer> list = getSelectSql(sql);
        return list;
    }

    private List<Lecturer> getSelectSql(String sql, Object... args) {
        try {
            List<Lecturer> list = new ArrayList<>();
            ResultSet rs = DBConnection.getDataFromQuery(sql);
            while (rs.next()) {
                Lecturer result = new Lecturer(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(12),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        _managerRepository.findByID(rs.getString(11)),
                        _majorRepository.findByID(rs.getString(10)));
                list.add(result);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(LecturerRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Lecturer getResultSet(ResultSet rs) {
        try {
            Lecturer result = new Lecturer(rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(12),
                    rs.getDate(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getInt(9),
                    _managerRepository.findByID(rs.getString(11)),
                    _majorRepository.findByID(rs.getString(10)));
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Lecturer findByCode(String code) {
        try {
            String sql = "SELECT [Id] ,[MaUser] ,[HoTen] ,[NgaySinh] ,[DiaChi] ,[Email] ,[SDT] ,[MatKhau] ,[ChucVu] ,[IdNganh] ,[IdNguoiTao] ,[GioiTinh] FROM [dbo].[Users] WHERE [MaUser] = ?";
            ResultSet rs = DBConnection.getDataFromQuery(sql, code);
            if (rs != null) {
                try {
                    while (rs.next()) {
                        Lecturer result = new Lecturer(rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getInt(12),
                                rs.getDate(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getString(8),
                                rs.getInt(9),
                                _managerRepository.findByID(rs.getString(11)),
                                _majorRepository.findByID(rs.getString(10)));
                        return result;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LecturerRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LecturerRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean insert(Lecturer lecturer) {
        String sql = "INSERT INTO [dbo].[Users]\n"
                + "           ([MaUser]\n"
                + "           ,[HoTen]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[DiaChi]\n"
                + "           ,[Email]\n"
                + "           ,[SDT]\n"
                + "           ,[MatKhau]\n"
                + "           ,[ChucVu]\n"
                + "           ,[IdNganh]\n"
                + "           ,[IdNguoiTao]\n"
                + "           ,[GioiTinh])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?)";
        int result = DBConnection.ExcuteDungna(sql, lecturer.getCode(),
                lecturer.getFullname(),
                lecturer.getdOB(),
                lecturer.getAddress(),
                lecturer.getEmail(),
                lecturer.getPhone(),
                lecturer.getPassword(),
                lecturer.getRole(),
                lecturer.getMajor().getId(),
                //                null,
                //                null,
                lecturer.getManager().getId(),
                lecturer.getGender());
        return result > 0;
    }

    @Override
    public Lecturer findByCode2(String code) {
        try {
            String sql = "";
            ResultSet rs = DBConnection.getDataFromQuery(sql, code);
            while (rs.next()) {
                Lecturer result = new Lecturer(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(12),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        _managerRepository.findByID(rs.getString(11)),
                        _majorRepository.findByID(rs.getString(10)));
                return result;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LecturerRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean updateLec(Lecturer lecturerUp) {
        String sql = "UPDATE [dbo].[Users]\n"
                + "   SET [MaUser] = ?\n"
                + "      ,[HoTen] = ?\n"
                + "      ,[NgaySinh] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[SDT] = ?\n"
                + "      ,[MatKhau] = ?\n"
                + "      ,[ChucVu] = ?\n"
                + "      ,[IdNganh] = ?\n"
                + "      ,[IdNguoiTao] = ?\n"
                + "      ,[GioiTinh] = ?\n"
                + " WHERE [Id] = ?";
        int result = DBConnection.ExcuteDungna(sql, lecturerUp.getCode(),
                lecturerUp.getFullname(),
                lecturerUp.getdOB(),
                lecturerUp.getAddress(),
                lecturerUp.getEmail(),
                lecturerUp.getPhone(),
                lecturerUp.getPassword(),
                lecturerUp.getRole(),
                lecturerUp.getMajor().getId(),
                lecturerUp.getManager().getId(),
                lecturerUp.getGender(),
                lecturerUp.getId());
        return result > 0;
    }

    @Override
    public boolean deleteLec(String id) {
        String sql = "DELETE FROM [dbo].[Users] WHERE [Id] = ?";
        int result = DBConnection.ExcuteDungna(sql, id);
        return result > 0;
    }

}
