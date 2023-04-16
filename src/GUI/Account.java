/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DAO.NhanVienDAO;
import DTO.AccountDTO;
import DTO.NhanVienDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import component.ImageScale;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 *
 * @author NAME
 */
public class Account extends JPanel{
    
    JPanel pnlinfo,pnllist,pnl_left_info,pnl_right_info;
    
    JScrollPane splist;
    
    JLabel lblimg;
    
    JLabel[] lblinfo = new JLabel[5];
    
    JLabel[] lblinfo_if = new JLabel[5];
    
    JTable tbllist;
    
    DefaultTableModel model;
    
    AccountDTO account;
    
    ArrayList<AccountDTO> acclist = new ArrayList<>();

    Dimension lblinfo_dms = new Dimension(110,30);
    Dimension info_dms = new Dimension(150,30);
    
    Font lblinfo_font  = new Font("Times New Roman",Font.LAYOUT_RIGHT_TO_LEFT,16);
    Font info_font  = new Font("Times New Roman",Font.CENTER_BASELINE,14);
    
    public void initcomponent(AccountDTO a,ArrayList<AccountDTO> list) throws IOException{
        this.setOpaque(true);
//        this.setBackground(Color.yellow);
        this.setLayout(new BorderLayout(10,10));
        
        this.acclist = list;
        this.account = a;
        
        pnlinfo = new JPanel();
        pnlinfo.setOpaque(true);
//        pnlinfo.setBackground(Color.red);
        pnlinfo.setLayout(new BorderLayout(10,10));
        pnlinfo.setBorder(new EmptyBorder(10,10,10,10));
        pnlinfo.setPreferredSize(new Dimension(900,720));

        
        pnl_left_info = new JPanel();
        pnl_left_info.setLayout(new FlowLayout(1));
        pnl_left_info.setOpaque(true);
        pnl_left_info.setBackground(new Color(240,240,240));
        pnl_left_info.setBorder(new EmptyBorder(150,0,0,0));
        pnl_left_info.setPreferredSize(new Dimension(250,0));
        
        NhanVienDTO nhanvien = new NhanVienDAO().selectById(this.account.getMaNV());       
        ImageIcon img = ImageScale.scale_employee_img(new ImageIcon( ImageIO.read(new File(nhanvien.getImg()))));
        
        lblimg = new JLabel(img);
        lblimg.setBorder(new LineBorder(new Color(100,100,100), 2, true));
        
        pnl_left_info.add(lblimg);
        
        
        
        pnl_right_info = new JPanel();
        
        pnl_right_info.setOpaque(true);
//        pnl_right_info.setBackground(new Color(240,240,240));
        pnl_right_info.setLayout(new GridLayout(5,2,10,20));
        pnl_right_info.setBorder(new EmptyBorder(20,60,20,80));
        
        
        String[] txtinfo = {"Mã nhân viên :","Tên nhân viên :","Email :","Nhóm quyền :","Tình trạng :"};
        String[] info = {nhanvien.getMaNV(),nhanvien.getTenNV(),account.getEmail(),account.getMaNhomQuyen(),Integer.toString(account.getStatus())};
        
        
        for(int i = 0 ; i<4;i++){
            lblinfo[i] = new JLabel(txtinfo[i]);
            lblinfo[i].setOpaque(true);
            lblinfo[i].setFont(lblinfo_font);
//            lblinfo[i].setBackground(Color.red);
            
            lblinfo_if[i] = new JLabel(info[i]);
            lblinfo_if[i].setFont(info_font);
            lblinfo_if[i].setOpaque(true);
//            lblinfo_if[i].setBackground(Color.red);
            
            pnl_right_info.add(lblinfo[i]);
            pnl_right_info.add(lblinfo_if[i]);
        }
        
        
        pnlinfo.add(pnl_left_info,BorderLayout.WEST);
        pnlinfo.add(pnl_right_info,BorderLayout.CENTER);
        
        this.add(pnlinfo,BorderLayout.CENTER);
        account_list(this.account);
        
        
    }

    public Account(AccountDTO a,ArrayList<AccountDTO> list) throws IOException {
        initcomponent(a,list);
    }
    
    
    public void account_list(AccountDTO a){
        if(a.getMaNhomQuyen().equals("002") || a.getMaNhomQuyen().equals("001")){
            pnllist = new JPanel();
            pnllist.setOpaque(true);
//            pnllist.setBackground(Color.blue);
            pnllist.setLayout(new GridLayout(1,1));
            pnllist.setBorder(new EmptyBorder(10,10,10,10));
            
            splist = new JScrollPane();
            
            
            tbllist = new JTable();
            
            model = new DefaultTableModel();
            
            model.addColumn("Email");
            model.addColumn("Mã người dùng");
            model.addColumn("Mã nhóm quyền");
            model.addColumn("Trạng thái");
            
            for(AccountDTO account : acclist){
               model.addRow(new Object[] {account.getEmail(),account.getMaNV(),account.getMaNhomQuyen(),account.getStatus()});
            }
            
            tbllist.setModel(model);
            
            splist.setViewportView(tbllist);
            
            pnllist.add(splist);
            
            this.add(pnllist,BorderLayout.EAST);
        }
        
    }
    
    
}
