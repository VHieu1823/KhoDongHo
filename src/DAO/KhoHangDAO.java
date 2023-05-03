/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhoDTO;
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
public class KhoHangDAO implements interfaceDAO{

   
    @Override
    public int insert(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList selectAll() {
        ArrayList<KhoDTO> listkho = new ArrayList<>();
        
        JDBCUtil dtb = new JDBCUtil();
        try{
        Connection conn = dtb.openConnection();
        
        String sql ="Select * from kho ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                KhoDTO kho = new KhoDTO(rs.getString("TenKho"), rs.getString("DiaChi"));
                listkho.add(kho);
            }
        
        dtb.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listkho;
    }

    @Override
    public Object selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
