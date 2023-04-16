/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import DTO.AccountDTO;
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
public class AccountDAO implements interfaceDAO<AccountDTO>{

    @Override
    public int insert(AccountDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        try {           
            String sql = "INSERT INTO account (Email,Passwd,Status,MaKho,MaNhomQuyen,MaNV) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getEmail());
            pst.setString(2, t.getPasswd());
            pst.setInt(3, t.getStatus());
            pst.setString(4, t.getMaKho());
            pst.setString(4, t.getMaNhomQuyen());
            pst.setString(5, t.getMaNV());
            pst.setString(6, t.getEmail());
          
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(AccountDTO t) {
        int ketqua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql ="update account set Passwd=?, MaKho=?, MaNhomQuyen=?, Status=? where Email=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getPasswd());
            pst.setString(2, t.getMaKho());
            pst.setString(3, t.getMaNhomQuyen());
            pst.setInt(4, t.getStatus());
            pst.setString(5, t.getEmail());

            ketqua = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
            
        
        dtb.closeConnection(conn);
        return 0;          
    }

    @Override
    public int delete(AccountDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        try {
            Connection conn = dtb.openConnection();
            String sql = "DELETE FROM account WHERE MaNV=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaNV());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(conn);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<AccountDTO> selectAll(){
        ArrayList<AccountDTO> acc_data = new ArrayList<>();
        
        JDBCUtil dtb = new JDBCUtil();
        try{
        Connection conn = dtb.openConnection();
        
        String sql ="Select * from account ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                AccountDTO account = new AccountDTO(rs.getString("Email"),rs.getString("MaNV"), rs.getString("Passwd"),rs.getInt("Status"), rs.getString("MaKho"),rs.getString("MaNhomQuyen"));
                acc_data.add(account);
            }
        
        dtb.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return acc_data;
    }

    @Override
    public AccountDTO selectById(String t) {
        AccountDTO account = new AccountDTO();
        JDBCUtil dtb = new JDBCUtil();
        String sql = "Select * from nhanvien ";
       
            Connection conn = dtb.openConnection();
            try {
                 PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) { 
                account = new AccountDTO(rs.getString("Email"),rs.getString("MaNV"), rs.getString("Passwd"),rs.getInt("Status"), rs.getString("MaKho"),rs.getString("MaNhomQuyen"));
            }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            dtb.closeConnection(conn);
        
        return account;
    }
    
    

   
        
    
}
