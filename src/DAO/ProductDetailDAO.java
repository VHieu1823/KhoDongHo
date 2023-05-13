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
    
    
    

    @Override
    public int insert(ProductDetailDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        try {           
            String sql = "INSERT INTO sanpham (MaSP,STT,TenSP,DoiTuongSuDung,ChatLieuVo,ChatLieuDay,ChatLieuMat,ChongNuoc,KichThuocMat,DoDay,NgayNhap,NgayXuat,Gia,NhaCungCap) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaSP());
            pst.setInt(2, t.getSTT());
            pst.setString(3, t.getTenSP());
            pst.setString(4, t.getDuoiTuongSuDung());
            pst.setString(5, t.getChatLieuVo());
            pst.setString(6, t.getChatLieuDay());
            pst.setString(7, t.getChatLieuMatDH());
            pst.setString(8, t.getChongNuoc());
            pst.setString(9, t.getKichThuocMat());
            pst.setString(10, t.getDoDay());
            pst.setString(11, t.getNgayNhap());
            pst.setString(12,"null");
            pst.setString(13, t.getGia());
            pst.setString(14, t.getNhaCungCap());


    
          
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(ProductDetailDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(ProductDetailDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        try {
            Connection conn = dtb.openConnection();
            String sql = "DELETE FROM `sanpham` WHERE MaSP=? and TenSP=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaSP());
            pst.setString(2, t.getTenSP());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(conn);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
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
                    ProductDetailDTO product = new ProductDetailDTO(rs.getString("MaSP"),rs.getInt("STT"),rs.getString("TenSP"),rs.getString("DoiTuongSuDung"),rs.getString("ChatLieuVo"),rs.getString("ChatLieuDay"),rs.getString("ChatLieuMat"),rs.getString("ChongNuoc"),rs.getString("DoDay"),rs.getString("KichThuocMat"),rs.getString("NgayNhap"),rs.getString("NgayXuat"), rs.getString("Gia"),rs.getString("NhaCungCap"));
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
    
    
    

   
    
}
