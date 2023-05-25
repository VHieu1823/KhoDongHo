/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDatabase.JDBCUtil;
import DTO.ChatLieuDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NAME
 */
public class ChatlieuDAO implements interfaceDAO<ChatLieuDTO>{

    @Override
    public int insert(ChatLieuDTO t) {
        int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql = "INSERT INTO chatlieu (chatlieu,loai,stt) VALUES (?,?,?)";
        try {           
        
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getChatlieu());
            pst.setString(2, t.getLoai());
            pst.setString(3, t.getstt());
           
           
            ketQua = pst.executeUpdate();
            
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(ChatLieuDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(ChatLieuDTO t) {
         int ketQua = 0;
        JDBCUtil dtb = new JDBCUtil();
        Connection conn = dtb.openConnection();
        String sql = "DELETE FROM chatlieu where machatlieu=? and loai=?";
        try {       
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getstt());
            pst.setString(2, t.getLoai());
            
            ketQua = pst.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        dtb.closeConnection(conn);
        return ketQua;
    
    }

    @Override
    public ArrayList<ChatLieuDTO> selectAll() {
        ArrayList<ChatLieuDTO> chatlieulist = new ArrayList<>();
        JDBCUtil dtb = new JDBCUtil();
        
        Connection conn = dtb.openConnection();
        String sql ="Select * from chatlieu ";
        try {
            
            Statement stmt;

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                ChatLieuDTO chatlieu = new ChatLieuDTO(rs.getString("chatlieu"),rs.getString("loai"),rs.getString("stt"));
                chatlieulist.add(chatlieu);
            }
        
        dtb.closeConnection(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return  chatlieulist;
    }

    @Override
    public ChatLieuDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getslcl(){
        int i=0;
         JDBCUtil dtb = new JDBCUtil();
        
        Connection conn = dtb.openConnection();
        try {
            String sql ="Select * from chatlieu ";
            Statement stmt;
            
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("loai").equals("vỏ"))
                i++;
            }
        
        dtb.closeConnection(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    
    public int getslmat(){
        int i=0;
         JDBCUtil dtb = new JDBCUtil();
        
        Connection conn = dtb.openConnection();
        try {
            String sql ="Select * from chatlieu";
            Statement stmt;
            
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("loai").equals("mặt"))
                i++;
            }
        
        dtb.closeConnection(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    
    

    
   public String[] selectcl() {
        String[] chatlieulist = new String[getslcl()];
        JDBCUtil dtb = new JDBCUtil();
        int i=0;
        Connection conn = dtb.openConnection();
        try {
            String sql ="Select * from chatlieu ";
            Statement stmt;
            
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("loai").equals("vỏ")){
                    chatlieulist[i] = rs.getString("chatlieu");
                    i++;
                }
            }
        
        dtb.closeConnection(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return  chatlieulist;
    }
    
    public String[] selectmat() {
        String[] chatlieulist = new String[getslmat()];
        JDBCUtil dtb = new JDBCUtil();
        int i=0;
        Connection conn = dtb.openConnection();
        try {
            String sql ="Select * from chatlieu ";
            Statement stmt;
            
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("loai").equals("mặt")){
                    chatlieulist[i] = rs.getString("chatlieu");
                    i++;
                }
            }
        
        dtb.closeConnection(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return  chatlieulist;
    }

}
