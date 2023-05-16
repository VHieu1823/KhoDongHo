/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDatabase.JDBCUtil;
import DTO.DoDayDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class DoDayDAO implements interfaceDAO<DoDayDTO>{

    @Override
    public int insert(DoDayDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        try {           
            String sql = "INSERT INTO doday (doday) VALUES (?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getDoday());
           
           
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(DoDayDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

       @Override
    public int delete(DoDayDTO t) {
         int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql = "DELETE FROM doday where doday=?";
        try {       
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getDoday());
            
            ketQua = pst.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        dtb.closeConnection(conn);
        return ketQua;
    
    }

    @Override
    public ArrayList<DoDayDTO> selectAll() {
        ArrayList<DoDayDTO> dodaylist = new ArrayList<>();
        JDBCUtil dtb = new JDBCUtil();
        
        Connection conn = dtb.openConnection();
        try {
            String sql ="Select * from doday ";
            Statement stmt;
            
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                DoDayDTO doday = new DoDayDTO(rs.getString("doday"));
                dodaylist.add(doday);
            }
        
        dtb.closeConnection(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return dodaylist;
    }

    @Override
    public DoDayDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
