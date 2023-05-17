/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.KhachHangBUS;
import DTO.KhachHangDTO;
import DAO.KhachHangDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class KhachHang extends JPanel{
    
    JPanel pnlkhachhang,pnltbl;
    
    JTable tblkhachhang;
    
    JScrollPane spkhachhang;
    
    DefaultTableModel model;
    
    ArrayList<KhachHangDTO> listkhachhang = new ArrayList<>();
    
    
    Font lbl_font = new Font("Times New Roamn",Font.CENTER_BASELINE,16);
    
//    long tongtien = 0;
    
    Color footer_lbl_clr = new Color(90,90,90);
    
    ArrayList<KhachHangDTO> khlist = new ArrayList<>();
    
    KhachHangDAO khdao = new KhachHangDAO();
    
    public void initcomponent(){
        this.setOpaque(true);
        this.setLayout(new BorderLayout());
        
        pnlkhachhang = new JPanel(new BorderLayout());
//        pnlkhachhang.setBorder(new EmptyBorder(10,10,10,10));
        

        pnltbl = new JPanel(new GridLayout(1,1));
                
        khlist = khdao.selectAll();
        
        tblkhachhang = new JTable();
        
        model = new DefaultTableModel();
        
        model.addColumn("Mã khách hàng");
        model.addColumn("Tên khách hàng");
        model.addColumn("Số điện thoại");
        model.addColumn("Tổng tiền bán");
        
        tblkhachhang.setModel(model);
        System.out.println(khlist.size());
        showdata(khlist);
        
        spkhachhang = new JScrollPane();
        spkhachhang.setViewportView(tblkhachhang);
        
        pnltbl.add(spkhachhang);
        
               
        pnlkhachhang.add(pnltbl,BorderLayout.CENTER);
        
        this.add(pnlkhachhang,BorderLayout.CENTER);
    }
     public void showdata(ArrayList<KhachHangDTO> list){
        model.setRowCount(0);
        for(KhachHangDTO kh : list){
            model.addRow(new Object[] {kh.getMaKH(),kh.getTenKh(),kh.getSDT(),kh.getTongTien()});
//            this.tongtien += Long.parseLong(kh.getTongTien().trim());
        }
        tblkhachhang.setModel(model);
    }

    public DefaultTableModel getModel(){
           return  this.model; 
    }
    public JTable gettbl(){
        return  this.tblkhachhang;
    }
    public void setKhachHanglist(ArrayList<KhachHangDTO> list){
       khlist = list;
    }
    
    public KhachHang() {
        initcomponent();
    }
    
}
