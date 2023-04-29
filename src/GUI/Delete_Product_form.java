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
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class Delete_Product_form extends JFrame implements KeyListener,MouseListener{
    
    JPanel pnlheading,pnlcontent;
    
    JScrollPane sptbl;
    
    JTable tblproduct;
    
    DefaultTableModel model;
    
    Label heading;
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    ArrayList<ProductDTO> productlist = new ArrayList<>();
    
    ProductBUS productbus ;
    
    AccountDTO account;
    
    Product product_form;
    
    int index;
    
    public void initcomponent(AccountDTO acc){
        
        account = acc;
        
        productbus = new ProductBUS();
        
        productlist = productbus.getPrdlist(account.getMaKho());
        
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
        
        pnlcontent = new JPanel(new GridLayout(1,1  ));
        
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
        
        this.add(sptbl,BorderLayout.CENTER);
        this.add(pnlheading,BorderLayout.NORTH);
        
        this.setVisible(true);
    }

    public Delete_Product_form(AccountDTO acc) throws HeadlessException {
        initcomponent(acc);
    }
    
    private void desplaydetails(int selectedRows){
    }
    
    public void delete(ProductDTO prd){      
        productbus.deleteProduct(prd);
        productlist.clear();
        productlist=productbus.getPrdlist(account.getMaKho());
        product_form.setProductlist(productlist);
        product_form.showdata(productlist);
        model.setRowCount(0);
        for(ProductDTO product : productlist){
            model.addRow(new Object[] {product.getTenSP(),product.getXuatSu(),product.getThuongHieu(),Integer.toString(product.getSoluong())});
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
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
