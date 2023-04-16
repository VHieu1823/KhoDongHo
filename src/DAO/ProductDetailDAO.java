/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDatabase.JDBCUtil;
import DTO.AccountDTO;
import DTO.ProductDTO;
import DTO.ProductDetailDTO;
import java.awt.Stroke;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class ProductDetailDAO implements interfaceDAO<ProductDetailDTO>{
    
    public static String product;
    
    

    @Override
    public int insert(ProductDetailDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(ProductDetailDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(ProductDetailDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ProductDetailDTO> selectAll() {
        ArrayList<ProductDetailDTO> productdetail = new ArrayList<>();
        
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        try {
            String sql ="Select * from sanpham ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                    ProductDetailDTO product = new ProductDetailDTO(rs.getString("MaSP"),rs.getString("TenSP"),rs.getString("DoiTuongSuDung"),rs.getString("ChatLieuVo"),rs.getString("ChatLieuDay"),rs.getString("ChatLieuMat"),rs.getString("ChongNuoc"),rs.getString("DoDay"),rs.getString("KichThuocMat"),rs.getString("NgayNhap"),rs.getString("NgayXuat"),rs.getString("TenKho"), rs.getString("Gia"),rs.getString("NhaCungCap"));
                    productdetail.add(product);
                
            }
        } catch (Exception e) {
        }
        
        return productdetail;
    }

    @Override
    public ProductDetailDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String setProduct(String t){
        return product = t;
    }
    

   
    
}
