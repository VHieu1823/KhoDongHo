/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.NhomQuyenBUS;
import DTO.NhomQuyenDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class Add_account_form extends JFrame implements  MouseListener,KeyListener{
    
    JPanel pnlheading,pnlcontent,pnlleft,pnlright,pnlleft_top,pnlleft_bot,pnlleft_center;
    
    Label heading,lblemail,lblpass,lblpass_confirm,lbltennv,lblmanv,lblkho,lblnhomquyen,lblsdt,lblngaysinh,lblgioitinh,lbladd;
    
    JComboBox cbnhomquyen;
    
    JTable tblnv;
    
    DefaultTableModel model;
    
    JScrollPane sptblnv;
        
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    Color text_color = new Color(80,80,80);
    Font text_font = new Font("Times New Roman",Font.CENTER_BASELINE,15);
    Font prd_info_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
    
    ArrayList<NhomQuyenDTO> nhomquyenlist = new ArrayList<>();
    
    NhomQuyenBUS nhomquyenbus = new NhomQuyenBUS();
    
    String[] a = new String[20];
    
    public void initcomponent(){

        nhomquyenlist = nhomquyenbus.getNhomQuyenList();
        
        int i=0;
        for(NhomQuyenDTO nq : nhomquyenlist){
            if(nq.getTenNQ().equals("admin"))
                continue;
            a[i] = nq.getTenNQ();
            i++;
        }
        
        this.setSize(new Dimension(1000,600));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlheading = new JPanel(new FlowLayout(1));
        
        pnlheading.setPreferredSize(new Dimension(0,100));
        pnlheading.setBorder(new EmptyBorder(30,0,0,0));
        pnlheading.setOpaque(true);
        pnlheading.setBackground(main_clr);
        
        heading = new Label("Thêm tài khoản",1);
        heading.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,22));
        heading.setForeground(new Color(240,240,240));
        
        pnlheading.add(heading);
        
        pnlcontent = new JPanel(new BorderLayout());
        
        pnlleft = new JPanel(new BorderLayout(5,5));
        pnlleft.setBorder(new EmptyBorder(5,5,5,5));
        pnlleft.setPreferredSize(new Dimension(600,0));
        pnlleft.setOpaque(true);
        pnlleft.setBackground(Color.white);
        
        pnlleft_top = new JPanel(null);
        pnlleft_top.setOpaque(true);
        pnlleft_top.setBackground(Color.white);
        pnlleft_top.setBorder(new LineBorder(text_color,1,true));
        pnlleft_top.setPreferredSize(new Dimension(0,200));
        
        
        lbltennv = new Label("Tên Nhân Viên");
        lbltennv.setAlignment(0);
        lbltennv.setBounds(30,30,150,30);
        lbltennv.setForeground(text_color);
        lbltennv.setFont(text_font);
        
        lblmanv = new Label("Mã Nhân Viên");
        lblmanv.setAlignment(0);
        lblmanv.setBounds(360,30,100,30);
        lblmanv.setForeground(text_color);
        lblmanv.setFont(text_font);
        
        lblsdt = new Label("SDT");
        lblsdt.setAlignment(0);
        lblsdt.setBounds(30,80,50,30);
        lblsdt.setForeground(text_color);
        lblsdt.setFont(text_font);
        
        lblngaysinh = new Label("Ngày Sinh");
        lblngaysinh.setAlignment(0);
        lblngaysinh.setBounds(250,80,100,30);
        lblngaysinh.setForeground(text_color);
        lblngaysinh.setFont(text_font);
        
        lblgioitinh = new Label("Giới Tính");
        lblgioitinh.setAlignment(0);
        lblgioitinh.setBounds(30,130,100,30);
        lblgioitinh.setForeground(text_color);
        lblgioitinh.setFont(text_font);
        
        lblkho = new Label("Kho");
        lblkho.setAlignment(0);
        lblkho.setBounds(400,130,50,30);
        lblkho.setForeground(text_color);
        lblkho.setFont(text_font);
        
        pnlleft_top.add(lbltennv);
        pnlleft_top.add(lblmanv);
        pnlleft_top.add(lblsdt);
        pnlleft_top.add(lblngaysinh);
        pnlleft_top.add(lblgioitinh);
        pnlleft_top.add(lblkho);
        
        pnlleft_center = new JPanel(null);
        pnlleft_center.setOpaque(true);
        pnlleft_center.setBackground(Color.white);
        pnlleft_center.setBorder(new LineBorder(text_color,1,true));

        lblemail = new Label("Email");
        lblemail.setAlignment(0);
        lblemail.setBounds(30,30,50,30);
        lblemail.setForeground(text_color);
        lblemail.setFont(text_font);
        
        lblnhomquyen = new Label("Nhóm quyền");
        lblnhomquyen.setAlignment(0);
        lblnhomquyen.setBounds(280,30,100,30);
        lblnhomquyen.setForeground(text_color);
        lblnhomquyen.setFont(text_font);
        
        cbnhomquyen = new JComboBox(a);
        cbnhomquyen.setBounds(390,30,150,30);
        
        lblpass = new Label("Nhập Mật Khẩu");
        lblpass.setAlignment(0);
        lblpass.setBounds(30,80,150,30);
        lblpass.setForeground(text_color);
        lblpass.setFont(text_font);
        
        lblpass_confirm = new Label("Nhập Lại Mật Khẩu");
        lblpass_confirm.setAlignment(0);
        lblpass_confirm.setBounds(30,130,150,30);
        lblpass_confirm.setForeground(text_color);
        lblpass_confirm.setFont(text_font);
        
        pnlleft_center.add(cbnhomquyen);
        pnlleft_center.add(lblemail);
        pnlleft_center.add(lblnhomquyen);
        pnlleft_center.add(lblpass);
        pnlleft_center.add(lblpass_confirm);
        
        pnlleft_bot = new JPanel(null);
        pnlleft_bot.setOpaque(true);
        pnlleft_bot.setBackground(Color.white);
        pnlleft_bot.setPreferredSize(new Dimension(0,50));
        
        lbladd = new Label("Thêm tài khoản");
        lbladd.setBounds(220,10,150,30);
        lbladd.setAlignment(1);
        lbladd.setBackground(main_clr);
        lbladd.setFont(prd_info_font);
        lbladd.setForeground(new Color(240,240,240));
        lbladd.addMouseListener(this);
        
        pnlleft_bot.add(lbladd);
        
        pnlleft.add(pnlleft_center,BorderLayout.CENTER);
        pnlleft.add(pnlleft_top,BorderLayout.NORTH);
        pnlleft.add(pnlleft_bot,BorderLayout.SOUTH);
        
        pnlright = new JPanel(new BorderLayout(5,5));
        pnlright.setBorder(new EmptyBorder(5,5,5,5));
        pnlright.setOpaque(true);
        pnlright.setBackground(Color.white);
        
        model = new DefaultTableModel();
        
        model.addColumn("Mã Nhân Viên");
        model.addColumn("Tên Nhân Viên");
        model.addColumn("SDT");
        model.addColumn("Ngày Sinh");
        
        tblnv = new JTable(model);
        
        sptblnv = new JScrollPane();
        
        sptblnv.setViewportView(tblnv);

        pnlright.add(sptblnv,BorderLayout.CENTER);
        
        pnlcontent.add(pnlleft,BorderLayout.WEST);
        pnlcontent.add(pnlright,BorderLayout.CENTER);
        
        
        this.add(pnlheading,BorderLayout.NORTH);
        this.add(pnlcontent,BorderLayout.CENTER);
        
        this.setVisible(true);
    }

    public Add_account_form() throws HeadlessException {
        initcomponent();
    }
    
    public static void main(String[] args) {
        new Add_account_form();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==lbladd){
            lbladd.setBackground(hover_clr);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==lbladd){
            lbladd.setBackground(main_clr);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
