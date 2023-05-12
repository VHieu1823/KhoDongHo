/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDatabase.JDBCUtil;
import DTO.PhieuDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class ChiTietPhieuDAO implements interfaceDAO<PhieuDetailDTO>{

    @Override
    public int insert(PhieuDetailDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        try {           
            String sql = "INSERT INTO chitietphieu (MaSP,TenSP,Loai,MaPhieu,DonGia) VALUES (?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaSP());
            pst.setString(2, t.getTenSP());
            pst.setString(3, t.getLoaiPhieu());
            pst.setString(4, t.getMaPhieu());
            pst.setString(5, t.getDonGia());

    
          
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(PhieuDetailDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PhieuDetailDTO> selectAll() {
        ArrayList<PhieuDetailDTO> list = new ArrayList<>();
        
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        try {
            String sql ="Select * from chitietphieu ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                PhieuDetailDTO chitietphieu = new PhieuDetailDTO(rs.getString("MaSP"),rs.getString("TenSP"), rs.getString("Loai"), rs.getString("MaPhieu"), rs.getString("DonGia"));
                list.add(chitietphieu);
            }
        } catch (Exception e) {
        }
        
        return list;
    }

    @Override
    public PhieuDetailDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
