/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import DTO.ProductDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import ConnectDatabase.JDBCUtil;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author NAME
 */
public class ProductDAO implements interfaceDAO<ProductDTO>{

    @Override
    public int insert(ProductDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        try {           
            String sql = "INSERT INTO danhmucsanpham (TenSP,ThuongHieu,XuatSu,SoLuong,Img,STT) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getTenSP());
            pst.setString(2, t.getThuongHieu());
            pst.setString(3, t.getXuatSu());
            pst.setInt(4, t.getSoluong());
            pst.setString(5, t.getHinhAnh());
            pst.setString(6, t.getStt());
          
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(ProductDTO t) {
        int ketqua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql ="update danhmucsanpham set TenSP=?,SoLuong=?,XuatSu=?,ThuongHieu=?,Img=?,Status=? where STT=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getTenSP());
            pst.setString(3, t.getXuatSu());
            pst.setString(5, t.getHinhAnh());
            pst.setString(4, t.getThuongHieu());
            pst.setInt(2, t.getSoluong());
            pst.setString(6, "1");
            pst.setString(7, t.getStt());


            ketqua = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
            
        
        dtb.closeConnection(conn);
        return 0;     
    }

    @Override
    public int delete(ProductDTO t) {
        int ketqua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql ="update danhmucsanpham set Status=0 where TenSP=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getTenSP());
            
            ketqua = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
            
        
        dtb.closeConnection(conn);
        return 0;     
    }

    @Override
    public ArrayList<ProductDTO> selectAll() {
        ArrayList<ProductDTO> product_data = new ArrayList<>();
        
        
        JDBCUtil dtb = new JDBCUtil();
        
        Connection conn = dtb.openConnection();
        try {
            String sql ="Select * from danhmucsanpham where Status=1";
            Statement stmt;
            
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                ProductDTO product = new ProductDTO(rs.getString("STT"),rs.getString("TenSP"), rs.getString("XuatSu"),rs.getString("Img"),rs.getString("ThuongHieu") ,rs.getInt("SoLuong"));
                product_data.add(product);
            }
        
        dtb.closeConnection(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return product_data;
    }
    
    public ArrayList<ProductDTO> select() {
        ArrayList<ProductDTO> product_data_all = new ArrayList<>();
        
        
        JDBCUtil dtb = new JDBCUtil();
        
        Connection conn = dtb.openConnection();
        try {
            String sql ="Select * from danhmucsanpham";
            Statement stmt;
            
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                ProductDTO product = new ProductDTO(rs.getString("STT"),rs.getString("TenSP"), rs.getString("XuatSu"),rs.getString("Img"),rs.getString("ThuongHieu") ,rs.getInt("SoLuong"));
                product_data_all.add(product);
            }
        
        dtb.closeConnection(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return product_data_all;
    }

    @Override
    public ProductDTO selectById(String t) {
        ProductDTO product = new ProductDTO();
        
        
        JDBCUtil dtb = new JDBCUtil();
        
        Connection conn = dtb.openConnection();
        try {
            String sql ="Select * from danhmucsanpham";
            Statement stmt;
            
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("TenSP").equals(t))
                    product = new ProductDTO(rs.getString("STT"),rs.getString("TenSP"), rs.getString("XuatSu"),rs.getString("Img"),rs.getString("ThuongHieu"),rs.getInt("SoLuong"));
                    break;
            }
        
        dtb.closeConnection(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return product;
    }
    
    
}