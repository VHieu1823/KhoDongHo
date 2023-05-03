/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.AccountBUS;
import BUS.KhoHangBUS;
import BUS.NhanVienBUS;
import BUS.NhomQuyenBUS;
import DTO.AccountDTO;
import DTO.KhoDTO;
import DTO.NhanVienDTO;
import DTO.NhomQuyenDTO;
import DTO.ProductDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
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
public class Add_account_form extends JFrame implements  MouseListener,KeyListener{
    
    JPanel pnlheading,pnlcontent,pnlleft,pnlright,pnlleft_top,pnlleft_bot,pnlleft_center,pnlsex;
    
    JTextField txttennv,txtmanv,txtemail,txtsdt,txtngaysinh;
    
    JPasswordField txtpass,txtpass_confirm;
    
    Label heading,lblemail,lblpass,lblpass_confirm,lbltennv,lblmanv,lblkho,lblnhomquyen,lblsdt,lblngaysinh,lblgioitinh,lbladd,lblnotice;
    
    JComboBox cbnhomquyen,cbkho;
    
    JRadioButton rbtnam,rbtnu;
        
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
    String[] b = new String[20];

    
    NhanVienBUS nhanvienbus = new NhanVienBUS();
    
    ArrayList<NhanVienDTO> nhanvienlist = new ArrayList<>();
    ArrayList<KhoDTO> kholist = new ArrayList<>();
    
    Account account_form;
    
    int index = -1;
    
    AccountBUS accountbus = new AccountBUS();
    
    KhoHangBUS khobus = new KhoHangBUS();
        
    public void initcomponent(){

        nhomquyenlist = nhomquyenbus.getNhomQuyenList();
                
        nhanvienlist = nhanvienbus.getNhanVienList();
        
        kholist = khobus.getListKho();
        
        
        
        
        this.setSize(new Dimension(1000,600));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
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
        lbltennv.setBounds(30,30,110,30);
        lbltennv.setForeground(text_color);
        lbltennv.setFont(text_font);

        txttennv = new JTextField();
        txttennv.setBounds(150, 30, 180, 30);
        txttennv.setEditable(false);
        
        lblmanv = new Label("Mã Nhân Viên");
        lblmanv.setAlignment(0);
        lblmanv.setBounds(360,30,100,30);
        lblmanv.setForeground(text_color);
        lblmanv.setFont(text_font);
        
        txtmanv = new JTextField();
        txtmanv.setBounds(470,30,100,30);
        txtmanv.setEditable(false);
        
        lblsdt = new Label("SDT");
        lblsdt.setAlignment(0);
        lblsdt.setBounds(30,80,50,30);
        lblsdt.setForeground(text_color);
        lblsdt.setFont(text_font);
        
        txtsdt = new JTextField();
        txtsdt.setBounds(80,80,180,30);
        txtsdt.setEditable(false);
        
        lblngaysinh = new Label("Ngày Sinh");
        lblngaysinh.setAlignment(0);
        lblngaysinh.setBounds(290,80,80,30);
        lblngaysinh.setForeground(text_color);
        lblngaysinh.setFont(text_font);
        
        txtngaysinh = new JTextField();
        txtngaysinh.setBounds(380,80,190,30);
        txtngaysinh.setEditable(false);
        
        lblgioitinh = new Label("Giới Tính");
        lblgioitinh.setAlignment(0);
        lblgioitinh.setBounds(30,130,80,30);
        lblgioitinh.setForeground(text_color);
        lblgioitinh.setFont(text_font);

        pnlsex = new JPanel(null);
        pnlsex.setOpaque(true);
        pnlsex.setBackground(Color.white);
        pnlsex.setBounds(110,125,210,40);
        pnlsex.setBorder(new LineBorder(new Color(90,90,90),1,true));
        
        ButtonGroup group = new ButtonGroup();
        
        rbtnam = new JRadioButton("Nam");
        rbtnam.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,16));
        rbtnam.setOpaque(true);
        rbtnam.setBackground(Color.white);
        rbtnam.setBounds(20,5,100,30);
        rbtnam.setEnabled(false);
        
        rbtnu = new JRadioButton("Nữ");
        rbtnu.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,16));
        rbtnu.setOpaque(true);
        rbtnu.setBackground(Color.white);
        rbtnu.setBounds(120,5,80,30);
        rbtnu.setEnabled(false);
        
        group.add(rbtnam);
        group.add(rbtnu);
        
        pnlsex.add(rbtnam);
        pnlsex.add(rbtnu);
        
        lblkho = new Label("Kho");
        lblkho.setAlignment(0);
        lblkho.setBounds(350,130,40,30);
        lblkho.setForeground(text_color);
        lblkho.setFont(text_font);
        
        cbkho = new JComboBox();
        for(KhoDTO kho : kholist){
            cbkho.addItem(kho.getTenKho());
        }
        cbkho.setBounds(400,130,100,30);
        
        pnlleft_top.add(lbltennv);
        pnlleft_top.add(txttennv);
        pnlleft_top.add(lblmanv);
        pnlleft_top.add(txtmanv);
        pnlleft_top.add(lblsdt);
        pnlleft_top.add(txtsdt);
        pnlleft_top.add(lblngaysinh);
        pnlleft_top.add(txtngaysinh);
        pnlleft_top.add(lblgioitinh);
        pnlleft_top.add(pnlsex);
        pnlleft_top.add(lblkho);
        pnlleft_top.add(cbkho);
        
        pnlleft_center = new JPanel(null);
        pnlleft_center.setOpaque(true);
        pnlleft_center.setBackground(Color.white);
        pnlleft_center.setBorder(new LineBorder(text_color,1,true));

        lblemail = new Label("Email");
        lblemail.setAlignment(0);
        lblemail.setBounds(30,30,50,30);
        lblemail.setForeground(text_color);
        lblemail.setFont(text_font);
        
        txtemail = new JTextField();
        txtemail.setBounds(80,30,170,30);
        
        lblnhomquyen = new Label("Nhóm quyền");
        lblnhomquyen.setAlignment(0);
        lblnhomquyen.setBounds(280,30,100,30);
        lblnhomquyen.setForeground(text_color);
        lblnhomquyen.setFont(text_font);
        
        cbnhomquyen = new JComboBox();
        for(NhomQuyenDTO nq : nhomquyenlist){
            if(nq.getTenNQ().equals("admin"))
                continue;
            cbnhomquyen.addItem(nq.getTenNQ());
        }
        cbnhomquyen.setBounds(390,30,150,30);
        
        lblpass = new Label("Nhập Mật Khẩu");
        lblpass.setAlignment(0);
        lblpass.setBounds(30,80,150,30);
        lblpass.setForeground(text_color);
        lblpass.setFont(text_font);
        
        txtpass = new JPasswordField();
        txtpass.setBounds(180,80,200,30);
        
        lblpass_confirm = new Label("Nhập Lại Mật Khẩu");
        lblpass_confirm.setAlignment(0);
        lblpass_confirm.setBounds(30,130,150,30);
        lblpass_confirm.setForeground(text_color);
        lblpass_confirm.setFont(text_font);
        
        txtpass_confirm = new JPasswordField();
        txtpass_confirm.setBounds(180,130,200,30);
        
        lblnotice = new Label();
        lblnotice.setBounds(180,165,200,20);
        lblnotice.setForeground(Color.red);
        
        pnlleft_center.add(cbnhomquyen);
        pnlleft_center.add(lblemail);
        pnlleft_center.add(txtemail);
        pnlleft_center.add(lblnhomquyen);
        pnlleft_center.add(lblpass);
        pnlleft_center.add(txtpass);
        pnlleft_center.add(lblpass_confirm);
        pnlleft_center.add(txtpass_confirm);
        pnlleft_center.add(lblnotice);
        
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
        
        for(NhanVienDTO nv : nhanvienlist){
            model.addRow(new Object[] {nv.getMaNV(),nv.getTenNV(),nv.getSDT(),nv.getNgaySinh()});
        }
        
        tblnv = new JTable(model);
        tblnv.addMouseListener(this);
        tblnv.addKeyListener(this);
        
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

    public void setAccount_form(Account account_form) {
        this.account_form = account_form;
    }
    
    private void desplaydetails(int selectedRows){
    }
    
    public void selectitem(ArrayList<NhanVienDTO> list){
        desplaydetails(tblnv.getSelectedRow());
        this.index = tblnv.getSelectedRow();
        AccountDTO account = new AccountDTO();
        NhanVienDTO a = list.get(index);
        account = accountbus.selectbyID(a.getMaNV());
        txttennv.setText(a.getTenNV());
        txtmanv.setText(a.getMaNV());
        txtsdt.setText(a.getSDT());
        txtngaysinh.setText(a.getNgaySinh());
        for(int i=0;i<cbkho.getItemCount();i++){
            if(cbkho.getItemAt(i).equals(account.getMaKho())){
                cbkho.setSelectedItem(account.getMaKho());
                break;
            }
        }
        if(a.getGioiTinh().equals("Nam")){
            rbtnam.setSelected(true);
        }
        else{
            rbtnu.setSelected(true);
        }
        
    }
    
    public void add(){
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==lbladd){
            if(!new String(txtpass.getPassword()).equals(new String(txtpass_confirm.getPassword())))
                lblnotice.setText("Sai mật khẩu");
            else{
                add();
                account_form.showdata();
            }
        }
        if(e.getSource()==tblnv){
            selectitem(nhanvienlist);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
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
        desplaydetails(tblnv.getSelectedRow());
    }
    
    
}
