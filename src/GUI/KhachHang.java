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
    
    JPanel pnlkhachhang,pnltbl,pnlfooter;
    
    JTable tblkhachhang;
    
    JScrollPane spkhachhang;
    
    DefaultTableModel model;
    
    ArrayList<KhachHangDTO> listkhachhang = new ArrayList<>();
    
    Label lbltongkhach,lbltongkhach_value,lbltongtien,lbltongtien_value;
    
    Font lbl_font = new Font("Times New Roamn",Font.CENTER_BASELINE,16);
    
    long tongtien = 0;
    
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
        
        showdata(khlist);
        
        spkhachhang = new JScrollPane();
        spkhachhang.setViewportView(tblkhachhang);
        
        pnltbl.add(spkhachhang);
        
        pnlfooter = new JPanel(null);
        pnlfooter.setPreferredSize(new Dimension(1400,150));
        pnlfooter.setOpaque(true);
        pnlfooter.setBackground(new Color(220,220,220));
        
        lbltongkhach = new Label("Tổng khách :");
        lbltongkhach.setForeground(footer_lbl_clr);
        lbltongkhach.setAlignment(1);
        lbltongkhach.setFont(lbl_font);
        lbltongkhach.setBounds(150,30,200,50);
        
        lbltongkhach_value = new Label(Integer.toString(listkhachhang.size()));
        lbltongkhach_value.setForeground(footer_lbl_clr);
        lbltongkhach_value.setAlignment(1);
        lbltongkhach_value.setFont(lbl_font);
        lbltongkhach_value.setBounds(360, 30, 80, 50);
        
        lbltongtien = new Label("Tổng bán :");
        lbltongtien.setForeground(footer_lbl_clr);
        lbltongtien.setAlignment(1);
        lbltongtien.setFont(lbl_font);
        lbltongtien.setBounds(490,30,100,50);
        
        lbltongtien_value = new Label(Long.toString(tongtien) + "$");
        lbltongtien_value.setForeground(footer_lbl_clr);
        lbltongtien_value.setAlignment(1);
        lbltongtien_value.setFont(lbl_font);
        lbltongtien_value.setBounds(600, 30, 150, 50);
        
        pnlfooter.add(lbltongkhach);
        pnlfooter.add(lbltongkhach_value);
        pnlfooter.add(lbltongtien);
        pnlfooter.add(lbltongtien_value);
        
        pnlkhachhang.add(pnltbl,BorderLayout.CENTER);
        pnlkhachhang.add(pnlfooter,BorderLayout.SOUTH);
        
        this.add(pnlkhachhang,BorderLayout.CENTER);
    }
     public void showdata(ArrayList<KhachHangDTO> list){
        model.setRowCount(0);
        for(KhachHangDTO kh : list){
            model.addRow(new Object[] {kh.getMaKH(),kh.getTenKh(),kh.getSDT(),kh.getTongTien()});
            this.tongtien += Long.parseLong(kh.getTongTien());
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
