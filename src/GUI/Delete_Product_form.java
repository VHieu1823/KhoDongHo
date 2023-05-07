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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Delete_Product_form extends JFrame implements KeyListener,MouseListener{
    
    JPanel pnlheading,pnlcontent,pnltbl,pnlfind;
    
    JScrollPane sptbl;
    
    JTable tblproduct;
    
    DefaultTableModel model;
    
    Label heading;
    
    JLabel lblfind;
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    ArrayList<ProductDTO> productlist = new ArrayList<>();
    ArrayList<ProductDTO> find_productlist = new ArrayList<>();
    
    ProductBUS productbus ;
    
    AccountDTO account;
    
    Product product_form;
    
    JTextField txtfind;
    
    int index;
    
    public void initcomponent(AccountDTO acc) throws IOException{
        
        account = acc;
        
        productbus = new ProductBUS();
        
        productlist = productbus.getPrdlist();
        
        this.setSize(new Dimension(1000,600));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        pnlheading = new JPanel(new FlowLayout(1));
        
        pnlheading.setPreferredSize(new Dimension(0,100));
        pnlheading.setBorder(new EmptyBorder(30,0,0,0));
        pnlheading.setOpaque(true);
        pnlheading.setBackground(main_clr);
        
        heading = new Label("XÓA SẢN PHẨM",1);
        heading.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,22));
        heading.setForeground(new Color(240,240,240));
        
        pnlheading.add(heading);
        
        pnlcontent = new JPanel(new BorderLayout());
        
        pnlfind = new JPanel(null);
        pnlfind.setPreferredSize(new Dimension(0,50));
        
        txtfind = new JTextField();
        txtfind.setBounds(310, 5, 330, 40);
//        txtfind.setText("Tìm kiếm....");
        txtfind.setForeground(new Color(90, 90, 90));
//        txtfind.setFocusable(false);
        txtfind.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 14));
        txtfind.putClientProperty("JTextField.placeholderText", "Tìm kiếm....");
        txtfind.putClientProperty("JTextField.showClearButton", true);
        
        lblfind = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\find.png"))));
        lblfind.setOpaque(true);
        lblfind.setBackground(main_clr);
        lblfind.setBounds(650, 5, 40, 40);
        lblfind.addMouseListener(this);
        
        pnlfind.add(lblfind);
        pnlfind.add(txtfind);
        
        pnltbl = new JPanel(new GridLayout(1,1));
        
        tblproduct = new JTable();
        tblproduct.addKeyListener(this);
        tblproduct.addMouseListener(this);
        
        model =new DefaultTableModel();
        
        model.addColumn("Tên Sản Phẩm");
        model.addColumn("Xuất sứ");
        model.addColumn("Thương hiệu");
        model.addColumn("Số lượng");
        
        for(ProductDTO product : productlist){
            model.addRow(new Object[] {product.getTenSP(),product.getXuatSu(),product.getThuongHieu(),Integer.toString(product.getSoluong())});
        }
        
        tblproduct.setModel(model);
        
        sptbl = new JScrollPane();
        
        sptbl.setViewportView(tblproduct);
        
        pnltbl.add(sptbl);
        
        pnlcontent.add(pnlfind,BorderLayout.NORTH);
        pnlcontent.add(pnltbl,BorderLayout.CENTER);
        
        this.add(pnlcontent,BorderLayout.CENTER);
        this.add(pnlheading,BorderLayout.NORTH);
        
        this.setVisible(true);
    }

    public Delete_Product_form(AccountDTO acc) throws HeadlessException, IOException {
        initcomponent(acc);
    }
    
    private void desplaydetails(int selectedRows){
    }
    
    public void delete(ProductDTO prd){      
        productbus.deleteProduct(prd);
        productlist.clear();
        productlist=productbus.getPrdlist();
        product_form.setProductlist(productlist);
        product_form.showdata(productlist);
        model.setRowCount(0);
        for(ProductDTO product : productlist){
            model.addRow(new Object[] {product.getTenSP(),product.getXuatSu(),product.getThuongHieu(),Integer.toString(product.getSoluong())});
        }
        
    }
    public void search(){
        if(txtfind.getText().trim().equals("")){
            model.setRowCount(0);
            productlist.clear();
            productlist = productbus.getPrdlist();
            for(ProductDTO product : productlist){
                if(product.getTenSP().toLowerCase().contains(txtfind.getText().toLowerCase())){
                    model.addRow(new Object[] {product.getTenSP(),product.getXuatSu(),product.getThuongHieu(),Integer.toString(product.getSoluong())});
                }
            }
        }
        else{
            productlist.clear();
            productlist = productbus.getPrdlist();
            model.setRowCount(0);
            find_productlist.clear();
            for(ProductDTO product : productlist){
                if(product.getTenSP().toLowerCase().contains(txtfind.getText().toLowerCase())){
                    model.addRow(new Object[] {product.getTenSP(),product.getXuatSu(),product.getThuongHieu(),Integer.toString(product.getSoluong())});
                    find_productlist.add(product);
                }
            }
            productlist.clear();
            productlist = find_productlist;
        }
           
    }
    public void selectitem(ArrayList<ProductDTO> list){
        if(JOptionPane.showConfirmDialog(pnlcontent, "Bạn muốn xóa sản phẩm này ?","Chi tiết sản phẩm",JOptionPane.YES_NO_OPTION) ==0){           
            desplaydetails(tblproduct.getSelectedRow());
            this.index =tblproduct.getSelectedRow();
                ProductDTO a = list.get(index);
                delete(a);
                
            }
    }
    
    public void setProduct_form(Product form){
        this.product_form = form;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        desplaydetails(tblproduct.getSelectedRow());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==tblproduct){
            selectitem(productlist);
        }
        if(e.getSource() == lblfind){
            search();
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
        if(e.getSource() == lblfind){
            lblfind.setBackground(hover_clr);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == lblfind){
            lblfind.setBackground(main_clr);
        }
    }
    
}
