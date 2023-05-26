/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDatabase.JDBCUtil;
import DTO.ChongNuocDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class ChongNuocDAO implements interfaceDAO<ChongNuocDTO>{

   @Override
    public int insert(ChongNuocDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        try {           
            String sql = "INSERT INTO chongnuoc (chongnuoc,stt) VALUES (?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getChongnuoc());
            pst.setString(2, t.getStt());

           
           
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(ChongNuocDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(ChongNuocDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql = "DELETE FROM chongnuoc where stt=?";
        try {       
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getStt());
            
            ketQua = pst.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        dtb.closeConnection(conn);
        return ketQua;
    
    }

    @Override
    public ArrayList<ChongNuocDTO> selectAll() {
        ArrayList<ChongNuocDTO> chongnuoclist = new ArrayList<>();
        JDBCUtil dtb = new JDBCUtil();
        
        Connection conn = dtb.openConnection();
        try {
            String sql ="Select * from chongnuoc ";
            Statement stmt;
            
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                ChongNuocDTO chongnuoc = new ChongNuocDTO(rs.getString("stt"),rs.getString("chongnuoc"));
                chongnuoclist.add(chongnuoc);
            }
        
        dtb.closeConnection(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return chongnuoclist;
    }

    @Override
    public ChongNuocDTO selectById(String t) {
        ChongNuocDTO ketQua = new ChongNuocDTO("", "");
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql = "SELECT * FROM chongnuoc where stt=?";
        try {       
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t);
            
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                ketQua = new ChongNuocDTO(rs.getString("stt"), rs.getString("chongnuoc"));
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        dtb.closeConnection(conn);
        return ketQua;
    }
    
}
