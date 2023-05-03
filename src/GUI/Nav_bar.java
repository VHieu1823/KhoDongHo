/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.ProductBUS;
import DAO.ChiTietPhieuDAO;
import DAO.ChiTietQuyenDAO;
import DTO.AccountDTO;
import DTO.ChiTietQuyenDTO;
import DTO.Key;
import DTO.ProductDTO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class Nav_bar extends JPanel implements MouseListener {

//    public static AccountDTO account; 
    JLabel lblstore_name;

    JTextField txtfind;

    JPanel pnltools, contentpanel;

    Menus_bar menu_bar;

    JLabel lblopenmenu, lbllogout, lblnews, lblmanager_info, lblfind, lbladd, lbldelete, lblchange;

    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);

    Font nav_bar_txt_font = new Font("Times New Roman", Font.CENTER_BASELINE, 16);

    Main_Frame main_frame;
    
    sup_account_info supacc_form;
                
    JTable tblpnl;
    
    String pnlname;
    
    AccountDTO account = new AccountDTO();
    
    ProductBUS prdbus = new ProductBUS();
    
    DefaultTableModel model;
    
    ArrayList<ProductDTO> prdlist = new ArrayList<>();
    
    ArrayList<ProductDTO> new_prdlist = new ArrayList<>();
    
    Product product_form;
    
    Key key = new Key();

    public void initcomponent(Main_Frame f, Menus_bar mnb, JPanel pnlcontent,AccountDTO acc) throws IOException {
        
        account = acc;
        menu_bar = mnb;
        main_frame = f;
        contentpanel = pnlcontent;
        prdlist = prdbus.getPrdlist(account.getMaKho());
        createkey(account);


//        this.setBounds(0, 0, 1400, 80);
        this.setPreferredSize(new Dimension(1400,80));
        this.setBackground(main_clr);
//        this.setBorder(new LineBorder(new Color(98,98,98),1,true));
        this.setLayout(null);

        lblstore_name = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\storage_icon.png"))));
        lblstore_name.setBounds(110, 0, 150, 80);
        lblstore_name.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        txtfind = new JTextField();
        txtfind.setBounds(340, 25, 330, 30);
//        txtfind.setText("Tìm kiếm....");
        txtfind.setForeground(new Color(90, 90, 90));
//        txtfind.setFocusable(false);
        txtfind.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 14));
        txtfind.putClientProperty("JTextField.placeholderText", "Tìm kiếm....");
        txtfind.putClientProperty("JTextField.showClearButton", true);
//        txtfind.addFocusListener(this);
//        txtfind.addMouseListener(this);

        lblfind = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\find.png"))));
        lblfind.setBounds(680, 15, 50, 50);
        lblfind.setOpaque(true);
        lblfind.setBackground(main_clr);
        lblfind.addMouseListener(this);

        lblmanager_info = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\manager_info.png"))));
        lblmanager_info.setBounds(1200, 15, 50, 50);
        lblmanager_info.setOpaque(true);
        lblmanager_info.setBackground(main_clr);
        lblmanager_info.addMouseListener(this);

        lblnews = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\news.png"))));
        lblnews.setBounds(1260, 15, 50, 50);
        lblnews.setOpaque(true);
        lblnews.setBackground(main_clr);
        lblnews.addMouseListener(this);

        lbllogout = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\logout.png"))));
        lbllogout.setBounds(1320, 15, 50, 50);
        lbllogout.setOpaque(true);
        lbllogout.setBackground(main_clr);
        lbllogout.addMouseListener(this);

        pnltools = new JPanel(new FlowLayout(1, 30, 2));
        pnltools.setBounds(890, 12, 270, 56);
        LineBorder tools_border = new LineBorder(Color.white, 1, true);
        pnltools.setOpaque(true);
        pnltools.setBackground(main_clr);
        pnltools.setBorder(tools_border);

        Dimension tools_dimension = new Dimension(50, 50);
        lbladd = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\add.png"))));
        lbladd.setPreferredSize(tools_dimension);
        lbladd.setOpaque(true);
        lbladd.setBackground(main_clr);
        lbladd.addMouseListener(this);

        lbldelete = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\delete.png"))));
        lbldelete.setPreferredSize(tools_dimension);
        lbldelete.setOpaque(true);
        lbldelete.setBackground(main_clr);
        lbldelete.addMouseListener(this);

        lblchange = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\change.png"))));
        lblchange.setPreferredSize(tools_dimension);
        lblchange.setOpaque(true);
        lblchange.setBackground(main_clr);
        lblchange.addMouseListener(this);

        pnltools.add(lbladd);
        pnltools.add(lbldelete);
        pnltools.add(lblchange);

        lblopenmenu = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\menus.png"))));
        lblopenmenu.setOpaque(true);
        lblopenmenu.setBounds(20, 15, 50, 50);
        lblopenmenu.setBackground(main_clr);
        lblopenmenu.setFont(nav_bar_txt_font);
        lblopenmenu.addMouseListener(this);

        this.add(lblopenmenu);
        this.add(pnltools);
        this.add(lblfind);
        this.add(lblmanager_info);
        this.add(lblnews);
        this.add(lblstore_name);
        this.add(lbllogout);
        this.add(txtfind);
        
//        System.out.println(key.getAdd_nv()+" "+key.getDel_nv()+" "+key.getUpdate_nv());
//        System.out.println(key.getAdd_per()+" "+key.getDel_per()+" "+key.getUpdate_per());
//        System.out.println(key.getAdd_inb()+" "+key.getDel_inb()+" "+key.getUpdate_inb());
//        System.out.println(key.getAdd_sp()+" "+key.getDel_sp()+" "+key.getUpdate_sp());
    }

    public Nav_bar(Main_Frame f, Menus_bar mnb, JPanel contentpanel,AccountDTO a) throws IOException {
        initcomponent(f, mnb, contentpanel,a);
    }

    public void getSupacc_form(sup_account_info a){
        this.supacc_form = a;
    }
    
    public void setProductForm(Product prd_form){
        this.product_form = prd_form;
    }
    
    public void setcurrenttable(JTable tbl,String pnlname,DefaultTableModel md){
        this.tblpnl = tbl;
        this.pnlname = pnlname;
        this.model = md;
    }
    
    public void createkey(AccountDTO acc){
        String t = "";
        ChiTietQuyenDAO chitietquyendao = new ChiTietQuyenDAO();
        ChiTietQuyenDTO per = new ChiTietQuyenDTO();
        String[] tenq = {"NhanSu","PhanQuyen","NhapKho","XuatKho","SanPham","TaiKhoan"};
        for(int i=0;i<tenq.length;i++){
            per = chitietquyendao.select( tenq[i], account.getMaNhomQuyen());
            t = tenq[i];
            switch (t) {
                case "NhanSu":
                    if(per.getQuyen()==7){
                        key.setAdd_nv(1);
                        key.setDel_nv(1);
                        key.setUpdate_nv(1);
                    }
                    else{
                        if(per.getQuyen()==1 || per.getQuyen()==3 || per.getQuyen()==5){
                            key.setAdd_nv(1);
                        }
                        if(per.getQuyen()==2 || per.getQuyen()==3 || per.getQuyen()==6){
                            key.setDel_nv(1);
                        }
                        if(per.getQuyen()==4 || per.getQuyen()==5 || per.getQuyen()==6){
                            key.setUpdate_nv(1);
                        }
                    }
                    break;
                case "PhanQuyen":
                    if(per.getQuyen()==7){
                        key.setAdd_per(1);
                        key.setDel_per(1);
                        key.setUpdate_per(1);
                    }
                    else{
                        if(per.getQuyen()==1 || per.getQuyen()==3 || per.getQuyen()==5){
                            key.setAdd_per(1);
                        }
                        if(per.getQuyen()==2 || per.getQuyen()==3 || per.getQuyen()==6){
                            key.setDel_per(1);
                        }
                        if(per.getQuyen()==4 || per.getQuyen()==5 || per.getQuyen()==6){
                            key.setUpdate_per(1);
                        }
                    }
                    break;
                case "NhapKho":
                    if(per.getQuyen()==7){
                        key.setAdd_inb(1);
                        key.setDel_inb(1);
                        key.setUpdate_inb(1);
                    }
                    else{
                        if(per.getQuyen()==1 || per.getQuyen()==3 || per.getQuyen()==5){
                            key.setAdd_inb(1);
                        }
                        if(per.getQuyen()==2 || per.getQuyen()==3 || per.getQuyen()==6){
                            key.setDel_inb(1);
                        }
                        if(per.getQuyen()==4 || per.getQuyen()==5 || per.getQuyen()==6){
                            key.setUpdate_inb(1);
                        }
                    }
                    break;
                case "XuatKho":
                    if(per.getQuyen()==7){
                        key.setAdd_outb(1);
                        key.setDel_outb(1);
                        key.setUpdate_outb(1);
                    }
                    else{
                        if(per.getQuyen()==1 || per.getQuyen()==3 || per.getQuyen()==5){
                            key.setAdd_outb(1);
                        }
                        if(per.getQuyen()==2 || per.getQuyen()==3 || per.getQuyen()==6){
                            key.setDel_outb(1);
                        }
                        if(per.getQuyen()==4 || per.getQuyen()==5 || per.getQuyen()==6){
                            key.setUpdate_outb(1);
                        }
                    }
                    break;
                case "SanPham":
                    if(per.getQuyen()==7){
                        key.setAdd_sp(1);
                        key.setDel_sp(1);
                        key.setUpdate_sp(1);
                    }
                    else{
                        if(per.getQuyen()==1 || per.getQuyen()==3 || per.getQuyen()==5){
                            key.setAdd_sp(1);
                        }
                        if(per.getQuyen()==2 || per.getQuyen()==3 || per.getQuyen()==6){
                            key.setDel_sp(1);
                        }
                        if(per.getQuyen()==4 || per.getQuyen()==5 || per.getQuyen()==6){
                            key.setUpdate_sp(1);
                        }
                    }
                    break;
                case "TaiKhoan":
                    if(per.getQuyen()==7){
                        key.setAdd_acc(1);
                        key.setDel_acc(1);
                        key.setUpdate_acc(1);
                    }
                    else{
                        if(per.getQuyen()==1 || per.getQuyen()==3 || per.getQuyen()==5){
                            key.setAdd_acc(1);
                        }
                        if(per.getQuyen()==2 || per.getQuyen()==3 || per.getQuyen()==6){
                            key.setDel_acc(1);
                        }
                        if(per.getQuyen()==4 || per.getQuyen()==5 || per.getQuyen()==6){
                            key.setUpdate_acc(1);
                        }
                    }
                    break;
                default:
                    throw new AssertionError();
            }

        }
    }
    
    public void del() throws HeadlessException, IOException{
        switch (pnlname) {
            case "Sản phẩm":
                if(key.getDel_sp()==1){
                    Delete_Product_form delete_form = new Delete_Product_form(account);
                    delete_form.setProduct_form(product_form);  
                }
                else
                    JOptionPane.showMessageDialog(null, "Không đủ quyền hạn thao tác chức năng này");
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public void add(){
        System.out.println(pnlname);
        switch (pnlname) {
            case "Sản phẩm":
                if(key.getAdd_sp()==1){
                    Add_Product_form addprd_form = new Add_Product_form(account);
                    addprd_form.setProduct_form(product_form);
                }
                else
                    JOptionPane.showMessageDialog(null, "Không đủ quyền hạn thao tác chức năng này");
                break;
            case "Tài khoản":
                if(key.getAdd_acc()==1){
                    Add_account_form add_account_form = new Add_account_form();
                }
                
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public void update() throws HeadlessException, IOException{
        switch (pnlname) {
            case "Sản phẩm":
                if(key.getUpdate_sp()==1){
                    Update_Product_form update_form = new Update_Product_form(account);
                    update_form.setProduct_form(product_form);
                }
                else
                    JOptionPane.showMessageDialog(null, "Không đủ quyền hạn thao tác chức năng này");
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public void search(){
        switch (pnlname) {
            case "Sản phẩm":
                if(txtfind.getText().trim().equals("")){
                    product_form.setProductlist(prdlist);
                    product_form.showdata(prdlist);
                }
                else{
                    model.setRowCount(0);
                    new_prdlist.removeAll(new_prdlist);
                    for(ProductDTO product : prdlist){
                        if(product.getTenSP().toLowerCase().contains(txtfind.getText().toLowerCase())){
                            new_prdlist.add(product);
                        }
                    }
                    product_form.showdata(new_prdlist);
                    product_form.setProductlist(new_prdlist);
                }
                break;
            default:
                throw new AssertionError();
        }
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == lblfind){
            search();
        }
        if(e.getSource()==lbladd){
            add();
        }
        if(e.getSource()==lblchange){
            try {
                update();
            } catch (HeadlessException ex) {
                Logger.getLogger(Nav_bar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Nav_bar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==lbldelete){
            try {
                del();
            } catch (HeadlessException ex) {
                Logger.getLogger(Nav_bar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Nav_bar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == lbllogout) {
            int option = JOptionPane.showConfirmDialog(main_frame, "Bạn muốn đăng xuất ?", "Logout", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                main_frame.dispose();
                try {
                    Login_Frame login_frame = new Login_Frame();
                } catch (IOException ex) {
                    Logger.getLogger(Nav_bar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Nav_bar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == lblopenmenu) {
            if (menu_bar.getWidth() == 150) {
                try {
                    menu_bar.closeMenu(menu_bar);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Menus_bar.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (menu_bar.getWidth() == 0)
                        try {
                    menu_bar.openMenu(menu_bar);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Menus_bar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(e.getSource() != lblopenmenu){
            if (menu_bar.getWidth() == 150) {
                try {
                    menu_bar.closeMenu(menu_bar);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Menus_bar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(e.getSource() == lblmanager_info){
            if(supacc_form.getHeight() == 350){
                try {
                    supacc_form.closeMenu(supacc_form);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sup_account_info.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else {
                if (supacc_form.getHeight() == 0)
                        try {
                    supacc_form.openMenu(supacc_form);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sup_account_info.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(e.getSource() != lblmanager_info){
            if (supacc_form.getHeight() == 350) {
                try {
                    supacc_form.closeMenu(supacc_form);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sup_account_info.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        if (e.getSource() == lbllogout) {
            lbllogout.setBackground(hover_clr);
        }
        if (e.getSource() == lblnews) {
            lblnews.setBackground(hover_clr);
        }
        if (e.getSource() == lblmanager_info) {
            lblmanager_info.setBackground(hover_clr);
        }
        if (e.getSource() == lblfind) {
            lblfind.setBackground(hover_clr);
        }
        if (e.getSource() == lblfind) {
            lblfind.setBackground(hover_clr);
        }
        if (e.getSource() == lbladd) {
            lbladd.setBackground(hover_clr);
        }
        if (e.getSource() == lbldelete) {
            lbldelete.setBackground(hover_clr);
        }
        if (e.getSource() == lblchange) {
            lblchange.setBackground(hover_clr);
        }
        if (e.getSource() == lblopenmenu) {
            lblopenmenu.setBackground(hover_clr);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == lbllogout) {
            lbllogout.setBackground(main_clr);
        }
        if (e.getSource() == lblnews) {
            lblnews.setBackground(main_clr);
        }
        if (e.getSource() == lblmanager_info) {
            lblmanager_info.setBackground(main_clr);
        }
        if (e.getSource() == lblfind) {
            lblfind.setBackground(main_clr);
        }
        if (e.getSource() == lbladd) {
            lbladd.setBackground(main_clr);
        }
        if (e.getSource() == lbldelete) {
            lbldelete.setBackground(main_clr);
        }
        if (e.getSource() == lblchange) {
            lblchange.setBackground(main_clr);
        }
        if (e.getSource() == lblopenmenu) {
            lblopenmenu.setBackground(main_clr);
        }
    }
}
