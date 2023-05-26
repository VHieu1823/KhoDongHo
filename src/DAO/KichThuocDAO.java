/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDatabase.JDBCUtil;
import DTO.KichThuocDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class KichThuocDAO implements interfaceDAO<KichThuocDTO>{

    @Override
    public int insert(KichThuocDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        try {           
            String sql = "INSERT INTO kichthuoc (kichthuoc,stt) VALUES (?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getKichthuoc());
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
    public int update(KichThuocDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(KichThuocDTO t) {
         int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql = "DELETE FROM kichthuoc where stt=?";
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
    public ArrayList<KichThuocDTO> selectAll() {
        ArrayList<KichThuocDTO> kichthuoclist = new ArrayList<>();
        JDBCUtil dtb = new JDBCUtil();
        
        Connection conn = dtb.openConnection();
        try {
            String sql ="Select * from kichthuoc ";
            Statement stmt;
            
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                KichThuocDTO kichthuoc = new KichThuocDTO(rs.getString("stt"),rs.getString("kichthuoc"));
                kichthuoclist.add(kichthuoc);
            }
        
        dtb.closeConnection(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return kichthuoclist;
    }

    @Override
    public KichThuocDTO selectById(String t) {
        KichThuocDTO ketQua = new KichThuocDTO("", "");
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql = "SELECT * FROM kichthuoc where stt=?";
        try {       
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t);
            
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                ketQua = new KichThuocDTO(rs.getString("stt"), rs.getString("kichthuoc"));
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        dtb.closeConnection(conn);
        return ketQua;
    }
    
}
