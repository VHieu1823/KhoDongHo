/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.AccountBUS;
import DAO.AccountDAO;
import DAO.NhanVienDAO;
import DTO.AccountDTO;
import DTO.NhanVienDTO;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



/**
 *
 * @author NAME
 */
public class Main_Frame extends JFrame{
    
    AccountDTO account ;
    
    public static JPanel pnlroot,pnlcontent;
    
    int currentcard = 1;
    NhanVienDTO nhanvien;
    NhanVienDAO nhanviendao = new NhanVienDAO();
    ArrayList<AccountDTO> acc_list = new AccountBUS().getListaccount();

//    public void initcomponent() throws IOException, SQLException{

    public void initcomponent(AccountDTO account) throws IOException, SQLException{
    
                
        this.account = account;
        
        this.nhanvien = nhanviendao.selectById(account.getMaNV());
        
        int width_frame = 1400;
        int height_frame = 800;
        
        this.setTitle("EO Store");
        this.setBackground(Color.white);
        this.setLayout(new FlowLayout(0,0,0));
        this.setSize(width_frame,height_frame);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        pnlroot = new JPanel();
        pnlroot.setPreferredSize(new Dimension(1400,720));
//        pnlroot.setLayout(new BorderLayout());
        pnlroot.setLayout(null);
        pnlroot.setOpaque(true);
//        pnlroot.setBackground(Color.red);
        
        pnlcontent = new JPanel(new BorderLayout());
        pnlcontent.setPreferredSize(new Dimension(1400,720));
        pnlcontent.setBounds(0,0,1400,720);

        Lib_Form lib = new Lib_Form();
        
        pnlcontent.add(lib,BorderLayout.CENTER);      
        
        Menus_bar menus_bar = new Menus_bar(this,this.account,pnlcontent);
        Nav_bar nav_bar = new Nav_bar(this,menus_bar,pnlcontent,this.account);
        menus_bar.getcontentpanel(pnlcontent);
        sup_account_info supacc = new sup_account_info(nhanvien, this.account);
        nav_bar.getSupacc_form(supacc);
        menus_bar.setNav_bar(nav_bar);
        nav_bar.setcurrenttable(lib.gettbl(), "Trang chủ",lib.getModel());
        
        pnlroot.add(supacc,BorderLayout.EAST);
        pnlroot.add(menus_bar,BorderLayout.WEST);
        
        pnlroot.add(pnlcontent,BorderLayout.CENTER);
        
        
        
        
        
//        this.add(pnlroot,BorderLayout.CENTER);
        this.add(nav_bar);
        this.add(pnlroot);
        
        
        this.setVisible(true);
    }
    
    public Main_Frame(AccountDTO account) throws IOException, SQLException{
        initcomponent(account);
    }
    
//    public Main_Frame() throws IOException, SQLException{
//        initcomponent();
//    }
    
//    public static void main(String[] args) throws IOException, UnsupportedLookAndFeelException, SQLException {
//        UIManager.setLookAndFeel(new FlatLightLaf());
//        Main_Frame a = new Main_Frame();
//    }
}
