/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDatabase.JDBCUtil;
import DTO.ChiTietQuyenDTO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author NAME
 */
public class ChiTietQuyenDAO implements interfaceDAO<ChiTietQuyenDTO>{

    @Override
    public int insert(ChiTietQuyenDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(ChiTietQuyenDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(ChiTietQuyenDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ChiTietQuyenDTO> selectAll() {
        ArrayList<ChiTietQuyenDTO> quyen = new ArrayList<>();
        JDBCUtil dtb = new JDBCUtil();
        
        Connection conn = dtb.openConnection();
        try {
            String sql ="Select * from chitietquyen ";
            Statement stmt;
            
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                ChiTietQuyenDTO chitietquyen = new ChiTietQuyenDTO(rs.getString("MaCTQ"), rs.getString("MaNQ"), rs.getString("TenCTQ"), rs.getInt("Quyen"));
                quyen.add(chitietquyen);
            }
        
        dtb.closeConnection(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return quyen;
    }

    @Override
    public ChiTietQuyenDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
