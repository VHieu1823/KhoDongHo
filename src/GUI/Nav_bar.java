/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.AccountBUS;
import BUS.ProductBUS;
import DTO.NhanVienDTO;
import DAO.NhanVienDAO;
import BUS.NhanVienBUS;
import BUS.NhomQuyenBUS;
import DAO.ChiTietPhieuDAO;
import DAO.ChiTietQuyenDAO;
import DTO.AccountDTO;
import DTO.ChiTietQuyenDTO;
import DTO.Key;
import DTO.NhomQuyenDTO;
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
    
    NhanVienDAO nhanvien = new NhanVienDAO();
    
    ProductBUS prdbus = new ProductBUS();
    
    NhomQuyenBUS nhomquyenbus = new NhomQuyenBUS();
    
    DefaultTableModel model;
    
    ArrayList<ProductDTO> prdlist = new ArrayList<>();
    
    ArrayList<ProductDTO> new_prdlist = new ArrayList<>();
    
    ArrayList<NhanVienDTO> nvlist = new ArrayList<>();
    
    ArrayList<NhanVienDTO> new_nvlist = new ArrayList<>();
    
    ArrayList<NhomQuyenDTO> perlist = new ArrayList<>();
    
    ArrayList<NhomQuyenDTO> new_perlist = new ArrayList<>();
    
    Product product_form;
    
    Account account_form;
    
    NhanVien nhanvien_form;
    
    PhanQuyen per_form;
        
    Key key = new Key();

    public void initcomponent(Main_Frame f, Menus_bar mnb, JPanel pnlcontent,AccountDTO acc) throws IOException {
        
        account = acc;
        menu_bar = mnb;
        main_frame = f;
        contentpanel = pnlcontent;
        createkey(account);
        nvlist = nhanvien.selectAll();


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
        this.add(lblstore_name);
        this.add(lbllogout);
        this.add(txtfind);
        
        
    }

    public Nav_bar(Main_Frame f, Menus_bar mnb, JPanel contentpanel,AccountDTO a) throws IOException {
        initcomponent(f, mnb, contentpanel,a);
    }

    public Key getKey(){
        return this.key;
    }
    
    public void getSupacc_form(sup_account_info a){
        this.supacc_form = a;
    }
    
    public void setProductForm(Product prd_form){
        this.product_form = prd_form;
    }
    
    public void setNhanVienForm(NhanVien nhanvien_form){
        this.nhanvien_form = nhanvien_form;
    }    
    public void setAccount_form(Account account_form) {
        this.account_form = account_form;
    }

    public void setPer_form(PhanQuyen per_form) {
        this.per_form = per_form;
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
        String[] tenq = {"NhanSu","PhanQuyen","NhapKho","XuatKho","SanPham","TaiKhoan","NhaCungCap","KhachHang"};
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
                case "KhachHang":
                    if(per.getQuyen()==7){
                        key.setAdd_khachhang(1);
                        key.setDel_khachhang(1);
                        key.setUpdate_khachhang(1);
                    }
                    else{
                        if(per.getQuyen()==1 || per.getQuyen()==3 || per.getQuyen()==5){
                            key.setAdd_khachhang(1);
                        }
                        if(per.getQuyen()==2 || per.getQuyen()==3 || per.getQuyen()==6){
                            key.setDel_khachhang(1);
                        }
                        if(per.getQuyen()==4 || per.getQuyen()==5 || per.getQuyen()==6){
                            key.setUpdate_khachhang(1);
                        }
                    }
                    break;
                case "NhaCungCap":
                    if(per.getQuyen()==7){
                        key.setAdd_ncc(1);
                        key.setDel_ncc(1);
                        key.setUpdate_ncc(1);
                    }
                    else{
                        if(per.getQuyen()==1 || per.getQuyen()==3 || per.getQuyen()==5){
                            key.setAdd_ncc(1);
                        }
                        if(per.getQuyen()==2 || per.getQuyen()==3 || per.getQuyen()==6){
                            key.setDel_ncc(1);
                        }
                        if(per.getQuyen()==4 || per.getQuyen()==5 || per.getQuyen()==6){
                            key.setUpdate_ncc(1);
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
                
            case "Nhân viên":
                if(key.getDel_nv()==1){
                Delete_Nhanvien delete_nhv = new Delete_Nhanvien(account);
                delete_nhv.setNhanVien_form(nhanvien_form);
                }
                else
                    JOptionPane.showMessageDialog(null, "Không đủ quyền hạn thao tác chức năng này");
                break;
                
            case "Tài khoản":
                if(key.getDel_acc()==1){
                    if(JOptionPane.showConfirmDialog(null, "Bạn muốn xóa tài khoản này","Notice", JOptionPane.YES_NO_OPTION)==0){
                        account_form.deleteAcc();
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Không đủ quyền hạn thao tác chức năng này");
                break;
            case "Phân quyền":
                if(key.getDel_per()==1){
                    Permission del_per = new Permission("Xóa nhóm quyền");
                    del_per.setPhanquyen_form(per_form);
                }
                else
                    JOptionPane.showMessageDialog(null, "Không đủ quyền hạn thao tác chức năng này");
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public void add(){
            switch (pnlname) {
            case "Sản phẩm":
                if(key.getAdd_sp()==1){
                    Add_Product_form addprd_form = new Add_Product_form(account);
                    addprd_form.setProduct_form(product_form);
                }
                else
                    JOptionPane.showMessageDialog(null, "Không đủ quyền hạn thao tác chức năng này");
                break;
            case "Nhân viên":
                if(key.getAdd_nv()==1){
                    AddNhanVien add_nhanvien = new AddNhanVien();
                    add_nhanvien.setNhanvien_form(nhanvien_form);
                }
                else
                    JOptionPane.showMessageDialog(null, "Không đủ quyền hạn thao tác chức năng này");
                break;
                    
            case "Tài khoản":
                if(key.getAdd_acc()==1){
                    Add_account_form add_account_form = new Add_account_form();
                    add_account_form.setAccount_form(account_form);
                }
                else
                    JOptionPane.showMessageDialog(null, "Không đủ quyền hạn thao tác chức năng này");
                break;
            case "Phân quyền":
                if(key.getAdd_per()==1){
                    Permission add_per = new Permission("Thêm nhóm quyền");
                    add_per.setPhanquyen_form(per_form);
                }
                else
                    JOptionPane.showMessageDialog(null, "Không đủ quyền hạn thao tác chức năng này");
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
            case "Tài khoản":
                if(key.getUpdate_acc()==1){
                    if(JOptionPane.showConfirmDialog(null, "Bạn muốn thay đổi thông tin tài khoản này","Notice", JOptionPane.YES_NO_OPTION)==0){
                        account_form.updateAcc();
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Không đủ quyền hạn thao tác chức năng này");
                break;
            case "Phân quyền":
                if(key.getUpdate_per()==1){
                    Permission update_per = new Permission("Sửa nhóm quyền");
                    update_per.setPhanquyen_form(per_form);
                }
                else
                    JOptionPane.showMessageDialog(null, "Không đủ quyền hạn thao tác chức năng này");
                break;


            case "Nhân viên":
                    Update_Nhanvien update_nv = new Update_Nhanvien();
                    update_nv.setNhanvien_form(nhanvien_form);
                break;            
            default:
                throw new AssertionError();
        }
    }
    
    public void search(){
        prdlist = prdbus.getPrdlist();
        switch (pnlname) {
            case "Sản phẩm":
                if(txtfind.getText().trim().toLowerCase().equals("")){
                    product_form.setProductlist(prdlist);
                    product_form.showdata(prdlist);
                }
                else{
                    model.setRowCount(0);
                    new_prdlist.removeAll(new_prdlist);
                    for(ProductDTO product : prdlist){
                        if(product.getTenSP().toLowerCase().contains(txtfind.getText().toLowerCase()) || product.getThuongHieu().toLowerCase().contains(txtfind.getText().toLowerCase()) || product.getXuatSu().toLowerCase().contains(txtfind.getText().toLowerCase())){
                            new_prdlist.add(product);
                        }
                    }
                    product_form.showdata(new_prdlist);
                    product_form.setProductlist(new_prdlist);
                }
                break;
            case "Nhân viên":
                if(txtfind.getText().trim().equals("")){
                    nhanvien_form.setNhanvienlist(nvlist);
                    nhanvien_form.showdata(nvlist);
                }
                else{
                    model.setRowCount(0);
                    new_nvlist.removeAll(new_nvlist);
                    for(NhanVienDTO nhv : nvlist){
                        if(nhv.getTenNV().toLowerCase().contains(txtfind.getText().toLowerCase())||nhv.getMaNV().contains(txtfind.getText())||nhv.getSDT().contains(txtfind.getText())||nhv.getNgayVao().contains(txtfind.getText())||nhv.getGioiTinh().toLowerCase().contains(txtfind.getText().toLowerCase())){
                            new_nvlist.add(nhv);
                        }
                    }
                    nhanvien_form.showdata(new_nvlist);
                    nhanvien_form.setNhanvienlist(new_nvlist);
                }
                break;       
            case "Phân quyền":
                perlist = nhomquyenbus.getNhomQuyenList();
                if(txtfind.getText().trim().equals("")){
                    per_form.showdata(perlist);
                }
                else{
                    model.setRowCount(0);
                    new_perlist.removeAll(new_perlist);
                    for(NhomQuyenDTO nq : perlist){
                        if(nq.getMaNQ().contains(txtfind.getText()) || nq.getTenNQ().toLowerCase().contains(txtfind.getText().toLowerCase())){
                            new_perlist.add(nq);
                        }
                    }
                    per_form.showdata(new_perlist);
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
