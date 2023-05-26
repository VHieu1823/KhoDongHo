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
            String sql = "INSERT INTO sanpham (MaSP,STT,DoiTuongSuDung,ChatLieuVo,ChatLieuDay,ChatLieuMat,ChongNuoc,KichThuocMat,DoDay,NgayNhap,NgayXuat,Gia,NhaCungCap,GiaXuat) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaSP());
            pst.setString(2, t.getSTT());
            pst.setString(3, t.getDuoiTuongSuDung());
            pst.setString(4, t.getChatLieuVo());
            pst.setString(5, t.getChatLieuDay());
            pst.setString(6, t.getChatLieuMatDH());
            pst.setString(7, t.getChongNuoc());
            pst.setString(8, t.getKichThuocMat());
            pst.setString(9, t.getDoDay());
            pst.setString(10, t.getNgayNhap());
            pst.setString(11,"null");
            pst.setString(12, t.getGia());
            pst.setString(13, t.getNhaCungCap());
            pst.setString(14, t.getGiaXuat());
            System.out.println("hi");
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
        int ketqua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql ="update sanpham set NgayXuat=? where MaSP=? and TenSP=?";
        try {
                  PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getNgayXuat());
            pst.setString(2, t.getMaSP());
            pst.setString(3, t.getSTT());

            ketqua = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
            
        
        dtb.closeConnection(conn);
        return ketqua;      
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
            pst.setString(2, t.getSTT());
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
                    ProductDetailDTO product = new ProductDetailDTO(rs.getString("MaSP"),rs.getString("STT"),rs.getString("DoiTuongSuDung"),rs.getString("ChatLieuVo"),rs.getString("ChatLieuDay"),rs.getString("ChatLieuMat"),rs.getString("ChongNuoc"),rs.getString("DoDay"),rs.getString("KichThuocMat"),rs.getString("NgayNhap"),rs.getString("NgayXuat"), rs.getString("Gia"),rs.getString("NhaCungCap"),rs.getString("GiaXuat"));
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
