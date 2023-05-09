/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import ConnectDatabase.JDBCUtil;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.sql.ResultSet;


/**
 *
 * @author NAME
 */
public class NhanVienDAO implements interfaceDAO<NhanVienDTO> {

     @Override
    public int insert(NhanVienDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        try {           
            String sql = "INSERT INTO nhanvien (MaNV,TenNV,GioiTinh,DiaChi,SDT,NgaySinh,NgayVao,Img) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaNV());
            pst.setString(2, t.getTenNV());
            pst.setString(3, t.getGioiTinh());
            pst.setString(4, t.getDiaChi());
            pst.setString(5, t.getSDT());
            pst.setString(6, t.getNgaySinh());
            pst.setString(7, t.getNgayVao());
            pst.setString(8, t.getImg());

          
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(NhanVienDTO t) {
        int ketqua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql ="UPDATE nhanvien set TenNV=?,GioiTinh=?,SDT=?,DiaChi=?,NgaySinh=?,Img=? where MaNV=?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getTenNV());
            pst.setString(2, t.getGioiTinh());
            pst.setString(3, t.getSDT());
            pst.setString(4, t.getDiaChi());
            pst.setString(5, t.getNgaySinh());
            pst.setString(6, t.getImg());
            pst.setString(7, t.getMaNV());


            
            

            ketqua = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        dtb.closeConnection(conn);
        return ketqua;          
    }

    @Override
    public int delete(NhanVienDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql = "DELETE FROM nhanvien where MaNV=?";
        try {       
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaNV());
            
            ketQua = pst.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        dtb.closeConnection(conn);
        return ketQua;
    }


    @Override
    public ArrayList<NhanVienDTO> selectAll() {
        ArrayList<NhanVienDTO> listnhanvien = new ArrayList<>();
        
        JDBCUtil dtb = new JDBCUtil();
        try{
        Connection conn = dtb.openConnection();
        
        String sql ="Select * from nhanvien ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                NhanVienDTO nhanvien = new NhanVienDTO(rs.getString("MaNV"), rs.getString("TenNV"),rs.getString("GioiTinh"), rs.getString("DiaChi"),rs.getString("SDT"),rs.getString("NgaySinh"),rs.getString("NgayVao"),rs.getString("img"));
                listnhanvien.add(nhanvien);
            }
        
        dtb.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listnhanvien;
    }

    @Override
    public NhanVienDTO selectById(String t) {
        NhanVienDTO nhanvien = new NhanVienDTO();
        JDBCUtil dtb = new JDBCUtil();
        String sql = "Select * from nhanvien ";
       
            Connection conn = dtb.openConnection();
            try {
                Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("MaNV").equals(t)){
                nhanvien = new NhanVienDTO(rs.getString("MaNV"), rs.getString("TenNV"),rs.getString("GioiTinh"), rs.getString("DiaChi"),rs.getString("SDT"),rs.getString("NgaySinh"),rs.getString("NgayVao"),rs.getString("img"));
                break;
                }
            }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            dtb.closeConnection(conn);
        
        return nhanvien;
    }

}
