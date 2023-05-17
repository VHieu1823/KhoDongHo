/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhomQuyenDTO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import ConnectDatabase.JDBCUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author NAME
 */
public class NhomQuyenDAO implements interfaceDAO<NhomQuyenDTO>{

    @Override
    public int insert(NhomQuyenDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        try {           
            String sql = "INSERT INTO nhomquyen (MaNhomQuyen,TenNQ) VALUES (?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaNQ());
            pst.setString(2, t.getTenNQ());
            
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(NhomQuyenDTO t) {
        System.out.println(t.getMaNQ());
         int ketqua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql ="update nhomquyen set TenNQ=? where MaNhomQuyen=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getTenNQ());
            pst.setString(2, t.getMaNQ());
            

            ketqua = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
                    
        dtb.closeConnection(conn);
        return ketqua;  
    }

    @Override
    public int delete(NhomQuyenDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        try {           
            String sql = "DELETE from nhomquyen where MaNhomQuyen=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaNQ());
          
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<NhomQuyenDTO> selectAll() {
        ArrayList<NhomQuyenDTO> list = new ArrayList<>();
        JDBCUtil dtb = new JDBCUtil();
        try{
        Connection conn = dtb.openConnection();
        
        String sql ="Select * from nhomquyen ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
               NhomQuyenDTO nhomquyen = new NhomQuyenDTO(rs.getString("MaNhomQuyen"),rs.getString("TenNQ"));
               list.add(nhomquyen);
            }
        
        dtb.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return list;
    }

    @Override
    public NhomQuyenDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
