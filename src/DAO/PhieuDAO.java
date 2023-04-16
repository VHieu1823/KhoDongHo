/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DAO;

import DTO.PhieuDTO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import ConnectDatabase.JDBCUtil;


public class PhieuDAO implements interfaceDAO<PhieuDTO>{

    @Override
    public int insert(PhieuDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        try {           
            String sql = "INSERT INTO Phieu (MaPhieu,LoaiPhieu,NguoiTao,NguoiNhan,NgayTao,MaKho,DonGia,NhaCungCap) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaPhieu());
            pst.setString(2, t.getLoaiPhieu());
            pst.setString(3, t.getNguoiTao());
            pst.setString(4, t.getNguoiNhan());
            pst.setString(5, t.getNgayTao());
            pst.setString(6, t.getMaKho());
            pst.setString(7, t.getDonGia());
            pst.setString(8, t.getNhaCungCap());
          
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(PhieuDTO t) {
        int ketqua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql ="update Phieu  set LoaiPhieu=?,NguoiTao=?,  NhaCungCap=?, NguoiNhan=?";
        try {
                  PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaPhieu());
            pst.setString(2, t.getLoaiPhieu());
            pst.setString(3, t.getNguoiTao());
            pst.setString(4, t.getNguoiNhan());
            pst.setString(5, t.getNgayTao());
            pst.setString(6, t.getMaKho());
            pst.setString(7, t.getDonGia());
            pst.setString(8, t.getNhaCungCap());
            

            ketqua = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
            
        
        dtb.closeConnection(conn);
        return 0;          
    }

    @Override
    public int delete(PhieuDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        try {
            Connection conn = dtb.openConnection();
            String sql = "DELETE FROM account WHERE MaNV=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(2, t.getMaPhieu());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(conn);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<PhieuDTO> selectAll(){
        ArrayList<PhieuDTO> phieu_data = new ArrayList<>();
        
        JDBCUtil dtb = new JDBCUtil();
        try{
        Connection conn = dtb.openConnection();
        
        String sql ="Select * from account ";
            Statement stmt = conn.createStatement();

       ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                PhieuDTO phieu = new PhieuDTO(rs.getString("MaPhieu"),rs.getString("LoaiPhieu"), rs.getString("NguoiTao"), rs.getString("NguoiNhan"), rs.getString("NgayTao"), rs.getString("MaKho"), rs.getString("DonGia"), rs.getString("NhaCungCap"));
               phieu_data.add(phieu);
            }
        
        dtb.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return phieu_data;
    }

    @Override
    public PhieuDTO selectById(String t) {
        PhieuDTO phieu = new PhieuDTO();
        JDBCUtil dtb = new JDBCUtil();
        String sql = "Select * from nhanvien ";
       
            Connection conn = dtb.openConnection();
            try {
                 PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) { 
                 phieu = new PhieuDTO(rs.getString("MaPhieu"),rs.getString("LoaiPhieu"), rs.getString("NguoiTao"), rs.getString("NguoiNhan"), rs.getString("NgayTao"), rs.getString("MaKho"), rs.getString("DonGia"), rs.getString("NhaCungCap"));
            }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            dtb.closeConnection(conn);
        
        return phieu;
    }
}