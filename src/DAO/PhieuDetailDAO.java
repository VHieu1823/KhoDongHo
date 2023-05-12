/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DAO;

import DTO.PhieuDetailDTO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import ConnectDatabase.JDBCUtil;


public class PhieuDetailDAO implements interfaceDAO<PhieuDetailDTO>{

    @Override
    public int insert(PhieuDetailDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        try {           
            String sql = "INSERT INTO chitietphieu (MaPhieu,Loai,MaSP,DonGia) VALUES (?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaPhieu());
            pst.setString(2, t.getLoaiPhieu());
            pst.setString(3, t.getMaSP());
            pst.setString(4, t.getDonGia());

    
          
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(PhieuDetailDTO t) {
        int ketqua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql ="update Phieu  set NhaCungCap=?, NguoiNhan=?";
        try {
                  PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaPhieu());
            pst.setString(3, t.getLoaiPhieu());
            pst.setString(4, t.getMaSP());
            

            ketqua = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
            
        
        dtb.closeConnection(conn);
        return 0;          
    }

    @Override
    public int delete(PhieuDetailDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        try {
            Connection conn = dtb.openConnection();
            String sql = "DELETE FROM account WHERE MaChitiet=?";
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
    public ArrayList<PhieuDetailDTO> selectAll(){
        ArrayList<PhieuDetailDTO> phieudt_data = new ArrayList<>();
        
        JDBCUtil dtb = new JDBCUtil();
        try{
        Connection conn = dtb.openConnection();
        
        String sql ="Select * from chitietphieu ";
            Statement stmt = conn.createStatement();

   ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                PhieuDetailDTO phieudt = new PhieuDetailDTO(rs.getString("MaSP"),rs.getString("TenSP"),rs.getString("Loai"),rs.getString("MaPhieu"),rs.getString("DonGia"));
               phieudt_data.add(phieudt);
            }
        
        dtb.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return phieudt_data;
    }

    @Override
    public PhieuDetailDTO selectById(String t) {
        PhieuDetailDTO phieudt = new PhieuDetailDTO();
        JDBCUtil dtb = new JDBCUtil();
        String sql = "Select * from nhanvien ";
       
            Connection conn = dtb.openConnection();
            try {
                 PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) { 
                phieudt = new PhieuDetailDTO(rs.getString("MaSP"),rs.getString("TenSP"),rs.getString("Loai"),rs.getString("MaPhieu"),rs.getString("DonGia"));
            }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            dtb.closeConnection(conn);
        
        return phieudt;
    }
}