/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHangDTO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import ConnectDatabase.JDBCUtil;
/**
 *
 * @author NAME
 */
public class KhachHangDAO implements interfaceDAO<KhachHangDTO>{

    @Override
    public int insert(KhachHangDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(KhachHangDTO t) {
        int ketqua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql ="update khachhang set TenKH=?,TongTien=?,SDT=? where MaKH=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getTenKh());
            pst.setString(2, t.getTongTien());
            pst.setString(3, t.getSDT());
            pst.setString(4, t.getMaKH());

            ketqua = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
                    
        dtb.closeConnection(conn);
        return ketqua;  
    }

    @Override
    public int delete(KhachHangDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<KhachHangDTO> selectAll() {
        ArrayList<KhachHangDTO> khachhang_data = new ArrayList<>();
        
        JDBCUtil dtb = new JDBCUtil();
        try{
        Connection conn = dtb.openConnection();
        
        String sql ="Select * from khachhang ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                KhachHangDTO khachhang = new KhachHangDTO(rs.getString("MaKH"),rs.getString("TenKH"),rs.getString("SDT"),rs.getString("TongTien"));
                khachhang_data.add(khachhang);
            }
        
        dtb.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return khachhang_data;
    }

    @Override
    public KhachHangDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    

    
}
