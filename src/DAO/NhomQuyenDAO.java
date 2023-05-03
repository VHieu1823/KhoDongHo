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
import java.sql.ResultSet;

/**
 *
 * @author NAME
 */
public class NhomQuyenDAO implements interfaceDAO<NhomQuyenDTO>{

    @Override
    public int insert(NhomQuyenDTO t) {
        int i=0;
        return i;
    }

    @Override
    public int update(NhomQuyenDTO t) {
        int i=0;
        return i;
    }

    @Override
    public int delete(NhomQuyenDTO t) {
    int i=0;
        return i;
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
