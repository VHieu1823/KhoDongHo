/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import ConnectDatabase.JDBCUtil;

import java.util.ArrayList;
import java.sql.ResultSet;


/**
 *
 * @author NAME
 */
public class NhanVienDAO implements interfaceDAO<NhanVienDTO> {

    @Override
    public int insert(NhanVienDTO t) {
        int i = 0;
        return i;
    }

    @Override
    public int update(NhanVienDTO t) {
        int i = 0;
        return i;
    }

    @Override
    public int delete(NhanVienDTO t) {
        int i = 0;
        return i;
    }

    @Override
    public ArrayList<NhanVienDTO> selectAll() {
        ArrayList<NhanVienDTO> listnhanvien = new ArrayList<>();
        
        JDBCUtil dtb = new JDBCUtil();
        try{
        Connection conn = dtb.openConnection();
        
        String sql ="Select * from nhanvien ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(!rs.getString("TenNV").equals("admin")){
                    NhanVienDTO nhanvien = new NhanVienDTO(rs.getString("MaNV"), rs.getString("TenNV"),rs.getString("GioiTinh"), rs.getString("DiaChi"),rs.getString("NgayVao"),rs.getString("SDT"),rs.getString("NgaySinh"),rs.getString("img"));
                    listnhanvien.add(nhanvien);
                }
            }
        
        dtb.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listnhanvien;
    }

    @Override
    public NhanVienDTO selectById(String t) {
        NhanVienDTO nhanvien = new NhanVienDTO();
        JDBCUtil dtb = new JDBCUtil();
        String sql = "Select * from nhanvien ";
       
            Connection conn = dtb.openConnection();
            try {
                Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("MaNV").equals(t)){
                nhanvien = new NhanVienDTO(rs.getString("MaNV"),rs.getString("TenNV"), rs.getString("GioiTinh"), rs.getString("DiaChi"), rs.getString("NgayVao"), rs.getString("SDT"),rs.getString("NgaySinh"),rs.getString("img"));
                break;
                }
            }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            dtb.closeConnection(conn);
        
        return nhanvien;
    }
    
    public NhanVienDTO select(String manv) {
        NhanVienDTO nv = new NhanVienDTO();
        JDBCUtil dtb = new JDBCUtil();
        try{
        Connection conn = dtb.openConnection();
        
        String sql ="Select * from nhanvien ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("MaNV").equals(manv))
                nv = new NhanVienDTO(rs.getString("MaNV"), rs.getString("TenNV"),rs.getString("GioiTinh"), rs.getString("DiaChi"),rs.getString("NgayVao"),rs.getString("SDT"),rs.getString("NgaySinh"),rs.getString("img"));
            }
        
        dtb.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return nv;
    }
}
