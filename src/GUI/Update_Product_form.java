/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.ProductBUS;
import DTO.AccountDTO;
import DTO.ProductDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class Update_Product_form extends JFrame implements MouseListener,KeyListener{
    
    JPanel pnlheading,pnlcontent,pnlleft,pnlright,pnlfind;
    
    JTextField txtfind,txttensp,txtthuonghieu,txtxuatsu;
    
    JLabel lblfind;
    
    Label heading,lbltensp,lblthuonghieu,lblxuatsu,lblimg;
    
    JTable tblproduct;
    
    DefaultTableModel model;
    
    JScrollPane spproduct;
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    Color text_color = new Color(80,80,80);
    Font text_font = new Font("Times New Roman",Font.CENTER_BASELINE,15);
    
    ArrayList<ProductDTO> prdlist = new ArrayList<>();
    ArrayList<ProductDTO> find_productlist = new ArrayList<>();
    
    ProductBUS productbus;
    
    AccountDTO account;
    
    Product product_form;
    
    int index;
    
    public void initcomponent(AccountDTO acc) throws IOException{
        
        productbus = new ProductBUS();
        account = acc;
        
        prdlist = productbus.getPrdlist(account.getMaKho());
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1300,700));
        this.setLayout(new BorderLayout(5,5));
        this.setLocationRelativeTo(null);
        
        pnlheading = new JPanel(new FlowLayout(1));
        
        pnlheading.setPreferredSize(new Dimension(0,100));
        pnlheading.setBorder(new EmptyBorder(30,0,0,0));
        pnlheading.setOpaque(true);
        pnlheading.setBackground(main_clr);
        
        heading = new Label("SỬA SẢN PHẨM",1);
        heading.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,22));
        heading.setForeground(new Color(240,240,240));
        
        pnlheading.add(heading);
        
        pnlcontent = new JPanel(new BorderLayout(10,0));
        pnlcontent.setOpaque(true);
        pnlcontent.setBackground(Color.white);
        
        pnlfind = new JPanel(null);
        pnlfind.setPreferredSize(new Dimension(0,50));
        
        txtfind = new JTextField();
        txtfind.setBounds(450, 5, 330, 40);
//        txtfind.setText("Tìm kiếm....");
        txtfind.setForeground(new Color(90, 90, 90));
//        txtfind.setFocusable(false);
        txtfind.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 14));
        txtfind.putClientProperty("JTextField.placeholderText", "Tìm kiếm....");
        txtfind.putClientProperty("JTextField.showClearButton", true);
        
        lblfind = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\find.png"))));
        lblfind.setOpaque(true);
        lblfind.setBackground(main_clr);
        lblfind.setBounds(790, 5, 40, 40);
        lblfind.addMouseListener(this);
        
        pnlfind.add(lblfind);
        pnlfind.add(txtfind);
        
        pnlright = new JPanel(new GridLayout(1,1));
        pnlright.setOpaque(true);
        pnlright.setBackground(Color.white);
        
        tblproduct = new JTable();
        
        model = new DefaultTableModel();
        
        model.addColumn("Tên sản phẩm");
        model.addColumn("Xuất sứ");
        model.addColumn("Thương hiệu");
        model.addColumn("Số lượng");
        
        for(ProductDTO product : prdlist){
            model.addRow(new Object[] {product.getTenSP(),product.getXuatSu(),product.getThuongHieu(),Integer.toString(product.getSoluong())});
        }
        
        tblproduct.setModel(model);
        tblproduct.addMouseListener(this);
        tblproduct.addKeyListener(this);
        
        spproduct = new JScrollPane();
        
        spproduct.setViewportView(tblproduct);
        
        pnlright.add(spproduct);
        
        pnlleft = new JPanel(null);
        pnlleft.setPreferredSize(new Dimension(400,0));
        pnlleft.setOpaque(true);
        pnlleft.setBackground(Color.white);
        
        lbltensp = new Label("Tên sản phẩm");
        lbltensp.setAlignment(1);
        lbltensp.setFont(text_font);
        lbltensp.setForeground(text_color);
        lbltensp.setBounds(40,50,100,30);
//        lbltensp.setBackground(main_clr);
        
        lblxuatsu = new Label("Xuất xứ");
        lblxuatsu.setAlignment(1);
        lblxuatsu.setFont(text_font);
        lblxuatsu.setForeground(text_color);
        lblxuatsu.setBounds(40,95,100,30);
//        lblxuatsu.setBackground(main_clr);
        
        lblthuonghieu = new Label("Thương hiệu");
        lblthuonghieu.setAlignment(1);
        lblthuonghieu.setFont(text_font);
        lblthuonghieu.setForeground(text_color);
        lblthuonghieu.setBounds(40,140,100,30);
//        lblthuonghieu.setBackground(main_clr);
        
        txttensp = new JTextField();
        txttensp.setBounds(150,50,200,30);
        
        txtxuatsu = new JTextField();
        txtxuatsu.setBounds(150,95,200,30);
        
        txtthuonghieu = new JTextField();
        txtthuonghieu.setBounds(150,140,200,30);
        
        pnlleft.add(lbltensp);
        pnlleft.add(lblxuatsu);
        pnlleft.add(lblthuonghieu);
        pnlleft.add(txttensp);
        pnlleft.add(txtxuatsu);
        pnlleft.add(txtthuonghieu);
        
        pnlcontent.add(pnlfind,BorderLayout.NORTH);
        pnlcontent.add(pnlleft,BorderLayout.WEST);
        pnlcontent.add(pnlright,BorderLayout.CENTER);
        
        this.add(pnlcontent,BorderLayout.CENTER);
        this.add(pnlheading,BorderLayout.NORTH);
        
        this.setVisible(true);
    }

    public Update_Product_form(AccountDTO acc) throws HeadlessException, IOException {
        initcomponent(acc);
    }
    
    public void setProduct_form(Product form){
        this.product_form = form;
    }
    
    private void desplaydetails(int selectedRows){
    }
    
    public void setdata(String tensp, String thuonghieu, String xuatxu, String img){
        txttensp.setText(tensp);
        txtxuatsu.setText(xuatxu);
        txtthuonghieu.setText(thuonghieu);
        
    }

    public void selectitem(ArrayList<ProductDTO> list){                  
        desplaydetails(tblproduct.getSelectedRow());
        this.index =tblproduct.getSelectedRow();
        ProductDTO a = list.get(index);
        setdata(a.getTenSP(), a.getThuongHieu(), a.getXuatSu(), a.getHinhAnh());       
    }
    
    public void search(){
        if(txtfind.getText().trim().equals("")){
            model.setRowCount(0);
            prdlist.clear();
            prdlist = productbus.getPrdlist(account.getMaKho());
            for(ProductDTO product : prdlist){
                if(product.getTenSP().toLowerCase().contains(txtfind.getText().toLowerCase())){
                    model.addRow(new Object[] {product.getTenSP(),product.getXuatSu(),product.getThuongHieu(),Integer.toString(product.getSoluong())});
                }
            }
        }
        else{
            model.setRowCount(0);
            prdlist.clear();
            prdlist = productbus.getPrdlist(account.getMaKho());
            find_productlist.clear();
            for(ProductDTO product : prdlist){
                if(product.getTenSP().toLowerCase().contains(txtfind.getText().toLowerCase())){
                    model.addRow(new Object[] {product.getTenSP(),product.getXuatSu(),product.getThuongHieu(),Integer.toString(product.getSoluong())});
                    find_productlist.add(product);
                }
            }
            prdlist.clear();
            prdlist = find_productlist;
        }
           
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==lblfind){
            search();
        }
        if (e.getSource()==tblproduct) {
            selectitem(prdlist);
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
        if(e.getSource()==lblfind){
            lblfind.setBackground(hover_clr);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==lblfind){
            lblfind.setBackground(main_clr);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
