/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import BUS.ProductBUS;
import BUS.ProductDetailBUS;
import DAO.ProductDAO;
import DAO.ProductDetailDAO;
import DTO.AccountDTO;
import DTO.ProductDTO;
import DTO.ProductDetailDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class Product extends JPanel implements MouseListener,KeyListener{
    
    DefaultTableModel model;
    
    Nav_bar nav_bar;
    
    JTable tblsanpham;
    
    JPanel pnlfooter,pnlcontent;
    
    Label lblsoluongsp,lbltongtien,lblsoluongsp_info,lbltongtien_info;
    
    JScrollPane spsanpham;
    
    AccountDTO account;
        
    ArrayList<ProductDTO> productlist = new ArrayList<>();
    
    ArrayList<ProductDetailDTO> prddetaillist = new ArrayList<>();
    
    ProductDetailBUS prddetailbus = new ProductDetailBUS();
    
    ProductBUS productbus ;
    
    int total = 0;
    int index = -1;
    double total_price = 0;
    
    public void initcomponent(AccountDTO a) throws SQLException{
        this.setOpaque(true);
        this.setBackground(Color.BLUE);
        this.setLayout(new BorderLayout());
        
        this.account = a;
        
        productbus = new ProductBUS();
        
        productlist = productbus.getPrdlist(account.getMaKho());
                
        pnlcontent = new JPanel(new GridLayout(1,1));
        
        tblsanpham = new JTable();
//        tblsanpham.setEnabled(false);
        tblsanpham.addKeyListener(this);
        tblsanpham.addMouseListener(this);
        
        model =new DefaultTableModel();
        
        model.addColumn("Tên Sản Phẩm");
        model.addColumn("Xuất sứ");
        model.addColumn("Thương hiệu");
        model.addColumn("Số lượng");
        
        showdata(productlist,model);
        
        spsanpham = new JScrollPane();
        spsanpham.setViewportView(tblsanpham);
        
        pnlcontent.add(spsanpham);
        
        pnlfooter = new JPanel(null);
        pnlfooter.setPreferredSize(new Dimension(this.getWidth(),150));
        pnlfooter.setOpaque(true);
        pnlfooter.setBackground(new Color(230,230,230));
        
        Font footer_lbl_font = new Font("Times New Roman",Font.CENTER_BASELINE,16);
        Color footer_lbl_clr = new Color(90,90,90);
        
        lblsoluongsp = new Label("Tổng số lượng sản phẩm:");
        lblsoluongsp.setAlignment(1);
        lblsoluongsp.setFont(footer_lbl_font);
        lblsoluongsp.setForeground(footer_lbl_clr);
        lblsoluongsp.setBounds(150,30,200,50);
        
        lblsoluongsp_info = new Label(Integer.toString(this.total));
        lblsoluongsp_info.setAlignment(1);
        lblsoluongsp_info.setFont(footer_lbl_font);
        lblsoluongsp_info.setForeground(footer_lbl_clr);
        lblsoluongsp_info.setBounds(360, 30, 80, 50);
        
        lbltongtien = new Label("Tổng giá trị:");
        lbltongtien.setAlignment(1);
        lbltongtien.setFont(footer_lbl_font);
        lbltongtien.setForeground(footer_lbl_clr);
        lbltongtien.setBounds(490,30,100,50);
        
        lbltongtien_info = new Label(Double.toString(total_price)+"$");
        lbltongtien_info.setAlignment(1);
        lbltongtien_info.setFont(footer_lbl_font);
        lbltongtien_info.setForeground(footer_lbl_clr);
        lbltongtien_info.setBounds(600, 30, 80, 50);
        
        
        pnlfooter.add(lbltongtien);
        pnlfooter.add(lbltongtien_info);
        pnlfooter.add(lblsoluongsp);
        pnlfooter.add(lblsoluongsp_info);
        
        
        this.add(pnlfooter,BorderLayout.SOUTH);
        this.add(pnlcontent,BorderLayout.CENTER);
        
    }
    private void desplaydetails(int selectedRows){
    }
    
    public JTable gettbl(){
        return  this.tblsanpham;
    }
    
    public DefaultTableModel getModel(){
        return  this.model; 
    }
    
    public void showdata(ArrayList<ProductDTO> list,DefaultTableModel model){
        model.setRowCount(0);
        for(ProductDTO product : list){
            prddetaillist = prddetailbus.getprddetaillist(product.getTenSP());
            for(ProductDetailDTO prddetail : prddetaillist){
                this.total ++;
                this.total_price += Double.parseDouble(prddetail.getGia());
            }
            model.addRow(new Object[] {product.getTenSP(),product.getXuatSu(),product.getThuongHieu(),Integer.toString(product.getSoluong())});
            }
        tblsanpham.setModel(model);
    }
    
    public void selectitem(ArrayList<ProductDTO> list){
        if(JOptionPane.showConfirmDialog(pnlcontent, "Bạn muốn xem chi tiết của sản phẩm này ?","Chi tiết sản phẩm",JOptionPane.YES_NO_OPTION) ==0){
                desplaydetails(tblsanpham.getSelectedRow());
                this.index = tblsanpham.getSelectedRow();
                ProductDTO a = list.get(index);
                try {
                    new Product_Detail(a,this.account);
                            } catch (SQLException ex) {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
    public void setProductlist(ArrayList<ProductDTO> list){
        productlist = list; 
    }
    
//    public void setNav_bar(Nav_bar nav_bar){
//        this.nav_bar = nav_bar;
//    }
    
    public Product(AccountDTO a) throws SQLException{
        initcomponent(a);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == tblsanpham ){
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        desplaydetails(tblsanpham.getSelectedRow());
    }
   
}
