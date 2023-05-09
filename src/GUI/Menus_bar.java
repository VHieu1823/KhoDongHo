/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.AccountBUS;
import BUS.ChiTietQuyenBUS;
import BUS.NhanVienBUS;
import DTO.AccountDTO;
import DTO.ChiTietQuyenDTO;
import DTO.NhanVienDTO;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
import java.util.*;   

/**
 *
 * @author NAME
 */
public class Menus_bar extends JPanel implements MouseListener {

    Nav_bar navbar;
    
    AccountDTO account;
    
    NhanVienDTO nhanvien;
    
    ArrayList<AccountDTO> acclist;

    Main_Frame main_frame;

    Color main_color = new Color(246, 164, 82);
    Color hover_txt_color = new Color(215, 144, 74);

    Dimension items_menu_size = new Dimension(130, 40);

    Font items_menu_font = new Font("Times New Roman", Font.CENTER_BASELINE, 16);
    
    String[] commonper = {"Trang chủ", "Sản phẩm","Nhập kho","Phiếu Nhập","Xuất kho","Phiếu Xuất","Nhà cung cấp","Khách hàng","Nhân viên","Tài khoản","Phân quyền"};

    JLabel[] lblitem_menu_bar = new JLabel[11];

    JPanel rootpanel,pnlcontent,pnlUser;
    
    CardLayout cl;
    
    JLabel icstorage;
    
    Color lbl_clr = new Color(81,81,81);
    
    EmptyBorder lblitem_border = new EmptyBorder(0,3,0,0);

    String[] icon_source = {
        "src\\assets\\library.png",
        "src\\assets\\product.png",
        "src\\assets\\inbound.png",
        "src\\assets\\bill.png",
        "src\\assets\\outbound.png",
        "src\\assets\\bill_out.png",
        "src\\assets\\ncc.png",
        "src\\assets\\buyer.png",
        "src\\assets\\personnel.png",
        "src\\assets\\user.png",
        "src\\assets\\permission.png"
    };
    
    public static int index;
    
    NhanVienBUS nhanvienbus = new NhanVienBUS();

    public void initcomponent(Main_Frame f, AccountDTO a, JPanel pnlroot) throws IOException, SQLException {
        
        account = a;
        nhanvien = nhanvienbus.selectnhanvien(account.getMaNV());
        rootpanel = pnlroot;
        main_frame = f;
        acclist = new AccountBUS().getListaccount();
//        this.cl = (CardLayout) rootpanel.getLayout();
        this.setLayout(new FlowLayout(0, 0, 15));
        this.setBorder(new EmptyBorder(0,10,0,0));
        this.setBackground(main_color);
//        this.setPreferredSize(new Dimension(0, 720));
        this.setBounds(0,0,0, 720);
        
        permission(account);

    }
    
    public void getcontentpanel(JPanel content){
        pnlcontent = content;
    }

    public void openMenu(Menus_bar a) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                int content_width = b.getParent().getWidth();
                for (int i = 0; i <= 150; i++) {
                    a.setSize(i, a.getHeight());
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Menus_bar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
//                b.setSize(content_width, b.getHeight());
            }
        }).start();
    }

    public void closeMenu(Menus_bar a) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
//                int content_width = b.getParent().getWidth();
                for (int i = 150; i >= 0; i--) {
                    a.setSize(i, a.getHeight());
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Menus_bar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
//                b.setSize(content_width, b.getHeight());
            }
        }).start();
    }
    
    public void setNav_bar(Nav_bar navbar){
        this.navbar = navbar;
    }
    
    public int per_values(){
        return index;
    }
    
    public void switchpanel(int index) throws SQLException, IOException{
        switch (index) {
            case 0:
                rootpanel.removeAll();
                Lib_Form lib = new Lib_Form();
                navbar.setcurrenttable(lib.gettbl(),commonper[0],lib.getModel());
                rootpanel.add(lib,BorderLayout.CENTER);
                rootpanel.repaint();
                rootpanel.validate();
                break;
            case 1:
                rootpanel.removeAll();
                Product prd_form = new Product(account);
                navbar.setcurrenttable(prd_form.gettbl(),commonper[1],prd_form.getModel());
                navbar.setProductForm(prd_form);
                rootpanel.add(prd_form,BorderLayout.CENTER);
                rootpanel.repaint();
                rootpanel.validate();
                break;
            case 2:
                rootpanel.removeAll();
                NhapKho nhap_form = new NhapKho();
                navbar.setcurrenttable(nhap_form.gettbl(),commonper[2],nhap_form.getModel());
                rootpanel.add(nhap_form,BorderLayout.CENTER);
                rootpanel.repaint();
                rootpanel.validate();
                break;
            case 3:
                rootpanel.removeAll();
                DsPhieu dsphieu_form = new DsPhieu(account);
                rootpanel.add(dsphieu_form,BorderLayout.CENTER);
                rootpanel.repaint();
                rootpanel.validate();
                break;
            case 4:
                rootpanel.removeAll();
                XuatKho xuat_form = new XuatKho();
                rootpanel.add(xuat_form,BorderLayout.CENTER);
                rootpanel.repaint();
                rootpanel.validate();
                break;
            case 5:
                rootpanel.removeAll();
                DsPhieuxuat dsphieuxuat = new DsPhieuxuat(account);
                rootpanel.add(dsphieuxuat,BorderLayout.CENTER);
                rootpanel.repaint();
                rootpanel.validate();
                break;
            case 6:
                rootpanel.removeAll();
                NhaCungCap ncc_form  = new NhaCungCap();
                rootpanel.add(ncc_form,BorderLayout.CENTER);
                rootpanel.repaint();
                rootpanel.validate();
                break;
            case 7:
                rootpanel.removeAll();
                KhachHang khach_form = new KhachHang();
                rootpanel.add(khach_form,BorderLayout.CENTER);
                rootpanel.repaint();
                rootpanel.validate();
                break;
            case 8:
                rootpanel.removeAll();
                NhanVien nv_form = new NhanVien(nhanvien);
                navbar.setcurrenttable(nv_form.gettbl(),commonper[8],nv_form.getModel());
                navbar.setNhanVienForm(nv_form);
                rootpanel.add(nv_form,BorderLayout.CENTER);
                rootpanel.repaint();
                rootpanel.validate();
                break;
            case 9:
                rootpanel.removeAll();
                Account acc_form = new Account(account,acclist );
                navbar.setAccount_form(acc_form);
                navbar.setcurrenttable(acc_form.getTbllist(), commonper[9], acc_form.getModel());
                rootpanel.add(acc_form,BorderLayout.CENTER);
                rootpanel.repaint();
                rootpanel.validate();
                break;
            case 10:
                rootpanel.removeAll();
                PhanQuyen per_form = new PhanQuyen();
                navbar.setPer_form(per_form);
                navbar.setcurrenttable(per_form.getTblper(), commonper[10], per_form.getModel());
                rootpanel.add(per_form,BorderLayout.CENTER);
                rootpanel.repaint();
                rootpanel.validate();
                break;
            default:
                throw new AssertionError();
        }
    }

    public void permission(AccountDTO account) throws IOException {
        ArrayList<ChiTietQuyenDTO> quyenlist = new ChiTietQuyenBUS().getquyen(account.getMaNhomQuyen());
        ArrayList<Integer> per = new ArrayList<>();
        per.add(0);       
        per.add(6);
        per.add(7);
        per.add(9);
        for(ChiTietQuyenDTO a : quyenlist){
            if(a.getTenChiTiet().equals("SanPham") && a.getQuyen()>0){
                per.add(1);
            }
            if(a.getTenChiTiet().equals("NhapKho") && a.getQuyen()>0){
                per.add(2);
                per.add(3);
            }
            if(a.getTenChiTiet().equals("XuatKho") && a.getQuyen()>0){
                per.add(4);
                per.add(5);
            }
            if(a.getTenChiTiet().equals("NhanSu") && a.getQuyen()>0){
                per.add(8);
                per.add(10);
            }     
        }
        
        Collections.sort(per);
        
        for (int i : per) {
            ImageIcon img = new ImageIcon(ImageIO.read(new File(icon_source[i])));
            lblitem_menu_bar[i] = new JLabel(commonper[i],img,JLabel.LEFT);
            lblitem_menu_bar[i].setBorder(lblitem_border);
            lblitem_menu_bar[i].setOpaque(true);
            lblitem_menu_bar[i].setForeground(lbl_clr);
            lblitem_menu_bar[i].setPreferredSize(items_menu_size);
            lblitem_menu_bar[i].setBackground(main_color);
            lblitem_menu_bar[i].setFont(items_menu_font);
            lblitem_menu_bar[i].addMouseListener(this);

            this.add(lblitem_menu_bar[i]);
        }

            
    }

    public Menus_bar(Main_Frame f, AccountDTO account, JPanel rootpanel) throws IOException, SQLException {
        initcomponent(f, account, rootpanel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(int i =0; i<lblitem_menu_bar.length;i++){
            if(e.getSource() == lblitem_menu_bar[i]){
                try {
                    //                String name = Integer.toString(i);
                    switchpanel(i);
                } catch (SQLException ex) {
                    Logger.getLogger(Menus_bar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Menus_bar.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    closeMenu(this);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Menus_bar.class.getName()).log(Level.SEVERE, null, ex);
                }
//                this.cl.show(rootpanel,name);
                
            }
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

        for (int i = 0; i < lblitem_menu_bar.length; i++) {
            if (e.getSource() == lblitem_menu_bar[i]) {
                lblitem_menu_bar[i].setBackground(hover_txt_color);
            }
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        for (int i = 0; i < lblitem_menu_bar.length; i++) {
            if (e.getSource() == lblitem_menu_bar[i]) {
                lblitem_menu_bar[i].setBackground(main_color);
            }
        }
    }

}
