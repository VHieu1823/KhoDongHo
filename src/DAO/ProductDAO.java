/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import DTO.ProductDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import ConnectDatabase.JDBCUtil;
import java.util.ArrayList;


/**
 *
 * @author NAME
 */
public class ProductDAO implements interfaceDAO<ProductDTO>{

    @Override
    public int insert(ProductDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(ProductDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(ProductDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ProductDTO> selectAll() {
        ArrayList<ProductDTO> product_data = new ArrayList<>();
        
        
        JDBCUtil dtb = new JDBCUtil();
        
        Connection conn = dtb.openConnection();
        try {
            String sql ="Select * from danhmucsanpham ";
            Statement stmt;
            
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                ProductDTO product = new ProductDTO(rs.getString("TenSP"), rs.getString("XuatSu"),rs.getString("Img"),rs.getString("ThuongHieu"),rs.getString("TenKho") ,rs.getInt("Status"),rs.getInt("SoLuong"));
                product_data.add(product);
            }
        
        dtb.closeConnection(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return product_data;
    }

    @Override
    public ProductDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}