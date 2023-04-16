/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class XuatKho extends JPanel{
    
    JPanel pnlleft,pnlright,pnlleft_head,pnlleft_body,pnlright_head,pnlright_body,pnlright_foot;

    JScrollPane sptblphieuxuat;
    
    JTable tblphieuxuat;
    
    DefaultTableModel model;
       
    Label[] lblproduct = new Label[14];
    
    JLabel lbladd,lblupdate,lblmaphieu,lblnguoitao,lblmaphieu_txt,lblnguoitao_txt,lblsoluong,lblsoluong_txt,lblthanhtien,lblthanhtien_txt,lblnguoinhan,lblnguoinhan_txt;
    
    Label lblxuat;
    
    JTextField[] prd_tf = new JTextField[14];
    
    String[] lblproduct_name = {"Tên sản phẩm","Mã sản phẩm","Xuất sứ","Thương hiệu","Đối tượng sử dụng","Chất liệu vỏ","Chất liệu dây","Chất liệu mặt","Độ dày","Kích thước","Chống nước","Nhà cung cấp","Thương hiệu","Hình ảnh"};
    
    Font prd_inf_font = new Font("Times New Roman",Font.CENTER_BASELINE,16);
    Font lblprd_inf_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);

    JTable tblprd;
    
    JScrollPane spprd;
    
    DefaultTableModel modelprd;
    
    Color main_clr = new Color(150, 150, 220);
        
    public void initcomponent() throws IOException{
        this.setLayout(new GridLayout(1,2,10,10));
//        this.setOpaque(true);
//        this.setBackground(Color.red);
        this.setBorder(new EmptyBorder(10,10,10,10));
        
        pnlleft = new JPanel(new BorderLayout(10,10));
        pnlleft.setBorder(new EmptyBorder(10,10,10,10));
        
        pnlleft_head = new JPanel(new BorderLayout(10,10));
//        pnlleft_head.setOpaque(true);
//        pnlleft_head.setBackground(Color.blue);
        
        tblprd = new JTable();
        
        modelprd = new DefaultTableModel();
        
        modelprd.addColumn("Mã sản phẩm");
        modelprd.addColumn("Tên sản phẩm");
        modelprd.addColumn("Đơn giá");
        modelprd.addColumn("Nhà cung cấp");
        
        tblprd.setModel(modelprd);
        
        spprd = new JScrollPane();
        
        spprd.setViewportView(tblprd);
        
        pnlleft_head.add(spprd,BorderLayout.CENTER);
        
        pnlleft_body = new JPanel(null);
        pnlleft_body.setPreferredSize(new Dimension(0,80));
        pnlleft_body.setOpaque(true);
//        pnlleft_body.setBackground(main_clr);
                
        lbladd = new JLabel(" Thêm sản phẩm");
        lbladd.setFont(lblprd_inf_font);
        lbladd.setForeground(Color.white);
        lbladd.setBounds(200,0,145,50);
        lbladd.setOpaque(true);
        lbladd.setBackground(main_clr);
        
        lblupdate = new JLabel(" Sửa");
        lblupdate.setFont(lblprd_inf_font);
        lblupdate.setForeground(Color.white);
        lblupdate.setBounds(360,0,45,50);
        lblupdate.setOpaque(true);
        lblupdate.setBackground(main_clr);
        
        pnlleft_body.add(lbladd);
        pnlleft_body.add(lblupdate);
        
        pnlleft.add(pnlleft_body,BorderLayout.SOUTH);
        pnlleft.add(pnlleft_head,BorderLayout.CENTER);
        
        
        pnlright = new JPanel(new BorderLayout(10,10));
        pnlright.setBorder(new EmptyBorder(10,10,10,10));
        
        pnlright_head = new JPanel(null);
        pnlright_head.setPreferredSize(new Dimension(0,80));
//        pnlright_head.setOpaque(true);
//        pnlright_head.setBackground(Color.red);
        pnlright_head.setBorder(new LineBorder(new Color(120,120,120),1,true));
        
        lblmaphieu = new JLabel("Mã phiếu:");
        lblmaphieu.setBounds(20,15,85,50);
//        lblmaphieu.setOpaque(true);
//        lblmaphieu.setBackground(main_clr);
        lblmaphieu.setFont(lblprd_inf_font);
        
        lblmaphieu_txt = new JLabel();
        lblmaphieu_txt.setBounds(120,15,80,50);
//        lblmaphieu_txt.setOpaque(true);
//        lblmaphieu_txt.setBackground(main_clr);
        lblmaphieu_txt.setFont(prd_inf_font);
        
        lblnguoitao = new JLabel("Người tạo:");
        lblnguoitao.setBounds(210,15,95,50);
//        lblnguoitao.setOpaque(true);
//        lblnguoitao.setBackground(main_clr);
        lblnguoitao.setFont(lblprd_inf_font);
        
        lblnguoitao_txt = new JLabel();
        lblnguoitao_txt.setBounds(320,15,80,50);
//        lblnguoitao_txt.setOpaque(true);
//        lblnguoitao_txt.setBackground(main_clr);
        lblnguoitao_txt.setFont( prd_inf_font);
        
        lblnguoinhan = new JLabel("Người nhận:");
        lblnguoinhan.setBounds(410,15,105,50);
//        lblnguoitao.setOpaque(true);
//        lblnguoitao.setBackground(main_clr);
        lblnguoinhan.setFont(lblprd_inf_font);
        
        lblnguoinhan_txt = new JLabel();
        lblnguoinhan_txt.setBounds(520,15,80,50);
//        lblnguoitao_txt.setOpaque(true);
//        lblnguoitao_txt.setBackground(main_clr);
        lblnguoinhan_txt.setFont( prd_inf_font);
        
        pnlright_head.add(lblmaphieu);
        pnlright_head.add(lblmaphieu_txt);
        pnlright_head.add(lblnguoitao);
        pnlright_head.add(lblnguoitao_txt);
        pnlright_head.add(lblnguoinhan);
        pnlright_head.add(lblnguoinhan_txt);
        
        pnlright_body = new JPanel(new GridLayout(1,1));
        
        tblphieuxuat = new JTable();
        
        model = new DefaultTableModel();
        
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Nhà cung cấp");
        model.addColumn("Số lượng");
        model.addColumn("Đơn giá");
        
        tblphieuxuat.setModel(model);
        
        sptblphieuxuat = new JScrollPane();
        sptblphieuxuat.setViewportView(tblphieuxuat);
        
        pnlright_body.add(sptblphieuxuat);
        
        pnlright_foot = new JPanel(null);
        pnlright_foot.setPreferredSize(new Dimension(0,80));
        
        lblsoluong = new JLabel("Số lượng:");
        lblsoluong.setFont(lblprd_inf_font);
//        lblsoluong.setOpaque(true);
//        lblsoluong.setBackground(main_clr);
        lblsoluong.setBounds(0,0,100,50);
        
        lblsoluong_txt = new JLabel();
        lblsoluong_txt.setFont(lblprd_inf_font);
        lblsoluong_txt.setBounds(110,0,150,50);
        
        lblthanhtien = new JLabel("Thành tiền:");
        lblthanhtien.setFont(lblprd_inf_font);
//        lblthanhtien.setOpaque(true);
//        lblthanhtien.setBackground(main_clr);
        lblthanhtien.setBounds(300,0,100,50);
        
        lblthanhtien_txt = new JLabel();
        lblthanhtien_txt.setFont(lblprd_inf_font);
        lblthanhtien_txt.setBounds(410,0,150,50);
        
        lblxuat = new Label("Xuất kho");
        lblxuat.setFont(lblprd_inf_font);
        lblxuat.setAlignment(1);
        lblxuat.setBackground(main_clr);
        lblxuat.setForeground(Color.white);
        lblxuat.setBounds(560,0,100,50);
        
        pnlright_foot.add(lblsoluong);
        pnlright_foot.add(lblsoluong_txt);
        pnlright_foot.add(lblthanhtien);
        pnlright_foot.add(lblthanhtien_txt);
        pnlright_foot.add(lblxuat);

        
        
        pnlright.add(pnlright_body,BorderLayout.CENTER);
        pnlright.add(pnlright_head,BorderLayout.NORTH);
        pnlright.add(pnlright_foot,BorderLayout.SOUTH);
        
        this.add(pnlleft);
        this.add(pnlright);
        
    }

    public XuatKho() throws IOException {
        initcomponent();
    }
}
