/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDatabase.JDBCUtil;
import DTO.ChiTietQuyenDTO;
import DTO.NhaCungCapDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class NhaCungCapDAO implements interfaceDAO<NhaCungCapDTO>{

    @Override
    public int insert(NhaCungCapDTO t) {
int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        try {           
            String sql = "INSERT INTO nhacungcap (MaNCC,TenNCC,DiaChi,Email,Hotline) VALUES (?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaNCC());
            pst.setString(2, t.getTenNCC());
            pst.setString(3, t.getDiaChi());
            pst.setString(4, t.getEmail());
            pst.setString(5, t.getHotLine());
      
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;    }

    @Override
    public int update(NhaCungCapDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        try {           
            String sql = "UPDATE nhacungcap set TenNCC=?, DiaChi=?, Email=?, Hotline=?   where MaNCC=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getTenNCC());
            pst.setString(2, t.getDiaChi());
            pst.setString(3, t.getEmail());
            pst.setString(4, t.getHotLine());
            pst.setString(5, t.getMaNCC());
            
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(NhaCungCapDTO t) {
int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql = "DELETE FROM nhacungcap where MaNCC=?";
        try {           
            
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaNCC());
            
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<NhaCungCapDTO> selectAll() {
        ArrayList<NhaCungCapDTO> ncclist = new ArrayList<>();
        JDBCUtil dtb = new JDBCUtil();
        
        Connection conn = dtb.openConnection();
        try {
            String sql ="Select * from nhacungcap ";
            Statement stmt;
            
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                NhaCungCapDTO ncc = new NhaCungCapDTO(rs.getString("MaNCC"),rs.getString("TenNCC"), rs.getString("DiaChi"), rs.getString("Email"), rs.getString("Hotline"));
                ncclist.add(ncc);
            }
        
        dtb.closeConnection(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return ncclist;
    }

    @Override
    public NhaCungCapDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
}
