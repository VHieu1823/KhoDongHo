/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDatabase.JDBCUtil;
import DTO.XuatXuDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class XuatXuDAO implements interfaceDAO<XuatXuDTO>{

    @Override
    public int insert(XuatXuDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql = "INSERT INTO thuonghieu (maxuatxu,xuatxu) VALUES (?,?)";
        try {           
        
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaxuatxu());
            pst.setString(2, t.getXuatxu());
           
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(XuatXuDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql = "UPDATE from thuonghieu xuatxu=? where maxuatxu=?";
        try {           
        
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(2, t.getMaxuatxu());
            pst.setString(1, t.getXuatxu());
           
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(XuatXuDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<XuatXuDTO> selectAll() {
        ArrayList<XuatXuDTO> xuatxulist = new ArrayList<>();
        JDBCUtil dtb = new JDBCUtil();
        
        Connection conn = dtb.openConnection();
        String sql ="Select * from xuatxu ";
        try {
            Statement stmt;

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                XuatXuDTO xuatxu = new XuatXuDTO(rs.getString("maxuatxu"), rs.getString("xuatxu"));
                xuatxulist.add(xuatxu);
            }
        
        dtb.closeConnection(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return  xuatxulist;
    }

    @Override
    public XuatXuDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
