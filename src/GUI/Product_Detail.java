/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.ProductDetailBUS;
import DAO.ProductDetailDAO;
import DTO.AccountDTO;
import DTO.ProductDTO;
import DTO.ProductDetailDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author NAME
 */
public class Product_Detail extends JFrame implements MouseListener{
    
    Color hover_clr = new Color(140, 140, 200);
    Color main_clr = new Color(150,150,220);
    
    JPanel pnlfooter,pnlcontent,pnlProduct_Name,pnltools,pnlimg;
    
    JTable tblproduct_detail;

    JScrollPane scpproduct_detail ;
    
    DefaultTableModel model;
    
    JLabel lblexit,lblimg,lblfind;
    
    JComboBox<String> cboption;
    
    String[] option = {"Mã sản phẩm","Chất liệu","Giá","Nhà cung cấp"};
    
    JTextField txtfind;
    
    Label lblsoluong,lblsoluong_info,lblgiatri,lblgiatri_info,lblspec,lblproduct_name;
    
    ArrayList<ProductDetailDTO> productdetail_data;
    ArrayList<ProductDetailDTO> productdetail_find_data;

    
    int  soluong= 0;
    double tongtien = 0;
    String path = "";
    
    ProductDTO product;
    AccountDTO account;
    
    public void initcomponent(ProductDTO prd,AccountDTO a) throws SQLException, IOException{
        this.product = prd;
        this.account = a;
        Font lbl_font = new Font("Times New Roman",Font.CENTER_BASELINE,16);
        
        if(!product.HinhAnh.equals("null")){
            path = "src\\product_img\\"+product.HinhAnh;
        }
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1300, 600));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        this.pnlProduct_Name = new JPanel(new FlowLayout(2, 20, 10));
        this.pnlProduct_Name.setPreferredSize(new Dimension(0,80));
        this.pnlProduct_Name.setOpaque(true);
        this.pnlProduct_Name.setBackground(main_clr);
        
        this.lblproduct_name = new Label(this.product.getTenSP());
        this.lblproduct_name.setForeground(Color.white);
        this.lblproduct_name.setAlignment(0);
        this.lblproduct_name.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        
        this.lblexit = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\turnback.png"))));
        this.lblexit.setOpaque(true);
        this.lblexit.setBackground(main_clr);
        this.lblexit.addMouseListener(this);
        
        this.pnltools = new JPanel(new FlowLayout(1, 10, 10));
        LineBorder tools_border = new LineBorder(Color.white, 1, true);
        this.pnltools.setPreferredSize(new Dimension(600,50));
        this.pnltools.setOpaque(true);
        this.pnltools.setBackground(main_clr);
        this.pnltools.setBorder(tools_border);

        cboption = new JComboBox<>(option);
        
        lblfind = new JLabel( new ImageIcon(ImageIO.read(new File("src\\assets\\find.png"))));
        lblfind.setOpaque(true);
        lblfind.setBackground(main_clr);
        lblfind.addMouseListener(this);
        
        txtfind = new JTextField();
        txtfind.setPreferredSize(new Dimension(330, 30));
//        txtfind.setText("Tìm kiếm....");
        txtfind.setForeground(new Color(90, 90, 90));
//        txtfind.setFocusable(false);
        txtfind.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 14));
        txtfind.putClientProperty("JTextField.placeholderText", "Tìm kiếm....");
        txtfind.putClientProperty("JTextField.showClearButton", true);
        
        pnltools.add(cboption);
        pnltools.add(txtfind);
        pnltools.add(lblfind);
        
        this.pnlProduct_Name.add(this.lblproduct_name);
        this.pnlProduct_Name.add(this.pnltools);
        this.pnlProduct_Name.add(this.lblexit);
        
        this.pnlcontent = new JPanel(new BorderLayout(5,5));
        this.pnlcontent.setBorder(new EmptyBorder(5,5,5,5));
        this.pnlcontent.setPreferredSize(new Dimension(1000,520));
        this.pnlcontent.setOpaque(true);
        
        this.tblproduct_detail = new JTable();
        
        model =new DefaultTableModel();
        
        model.addColumn("Mã Sản Phẩm");
        model.addColumn("Tên Sản Phẩm");
        model.addColumn("Chất liệu vỏ");
        model.addColumn("Chất liệu dây");
        model.addColumn("Chất liệu mặt");
        model.addColumn("Kích thước mặt");
        model.addColumn("Độ dày");
        model.addColumn("Chống nước");
        model.addColumn("Giá");
        model.addColumn("NCC");
        
        ProductDetailBUS prdtbus = new ProductDetailBUS();
        productdetail_data  = prdtbus.getprddetaillist(prd.getTenSP());
        
        for(ProductDetailDTO product : productdetail_data){
                this.soluong ++;
                this.tongtien += Double.parseDouble(product.getGia());
                model.addRow(new Object[] {product.getMaSP(),product.getTenSP(),product.getChatLieuVo(),product.getChatLieuDay(),product.getChatLieuMatDH(),product.getKichThuocMat(),product.getDoDay(),product.getChongNuoc(),product.getGia(),product.getNhaCungCap()});
        }
        
        this.tblproduct_detail.setModel(model);
        
        this.scpproduct_detail = new JScrollPane();
        this.scpproduct_detail.setViewportView(this.tblproduct_detail);
        
        pnlimg = new JPanel(new GridLayout(1, 1));
        pnlimg.setPreferredSize(new Dimension(300,0));
        
        lblimg = new JLabel();
        
        if(!path.equals("")){
            lblimg.setIcon(new ImageIcon(ImageIO.read(new File(path)).getScaledInstance(300,540,Image.SCALE_SMOOTH)));
        }
        else{
            lblimg.setBorder(new LineBorder(new Color(90,90,90), 1, true));
            lblimg.setOpaque(true);
            lblimg.setBackground(Color.white);
        }
        
        pnlimg.add(lblimg);
        
        this.pnlcontent.add(pnlimg,BorderLayout.WEST);
        this.pnlcontent.add(scpproduct_detail,BorderLayout.CENTER);
        

        this.pnlfooter = new JPanel(new FlowLayout(0,10,10));
        this.pnlfooter.setPreferredSize(new Dimension(0,80));
        this.pnlfooter.setOpaque(true);
        this.pnlfooter.setBackground(new Color(230,230,230));
        this.pnlfooter.setBorder(new EmptyBorder(20,20,20,20));
        
        this.lblsoluong = new Label("Số lượng: ");
        this.lblsoluong.setAlignment(1);
        this.lblsoluong.setFont(lbl_font);
        
        this.lblsoluong_info = new Label(Integer.toString(this.soluong));
        this.lblsoluong_info.setAlignment(0);
        this.lblsoluong_info.setFont(lbl_font);
        
        this.lblspec = new Label(" | ");
        this.lblspec.setAlignment(1);
        this.lblspec.setFont(lbl_font);
        
        this.lblgiatri = new Label("Tổng tiền: ");
        this.lblgiatri.setAlignment(1);
        this.lblgiatri.setFont(lbl_font);
        
//        String txtgia = product.getGia().trim().replaceAll("[^\\d.]", "");
//        Double gia = Double.parseDouble(txtgia.replaceAll("\\.", ""))*this.soluong;
        
        this.lblgiatri_info = new Label(Double.toString(this.tongtien)+"$");
//        this.lblgiatri_info = new Label(Double.toString(gia));
        this.lblgiatri_info.setAlignment(0);
        this.lblgiatri_info.setFont(lbl_font);
        
        this.pnlfooter.add(this.lblsoluong);
        this.pnlfooter.add(this.lblsoluong_info);
        this.pnlfooter.add(lblspec);
        this.pnlfooter.add(this.lblgiatri);
        this.pnlfooter.add(this.lblgiatri_info);
        
        this.add(pnlProduct_Name,BorderLayout.NORTH);
        this.add(pnlfooter,BorderLayout.SOUTH);
        this.add(pnlcontent,BorderLayout.CENTER);
        
        this.setVisible(true);
        
        
    }
    
    public Product_Detail(ProductDTO prd,AccountDTO a) throws SQLException, IOException{
        initcomponent(prd,a);
    }
    
//    public static void main(String[] args) throws SQLException {
//        String name = "ROLEX DAYDATE";
//        Product_Detail a = new Product_Detail(name);
//    }
    
    public void showdata(ArrayList<ProductDetailDTO> list){
        model.setRowCount(0);
        for(ProductDetailDTO product : list){
                model.addRow(new Object[] {product.getMaSP(),product.getTenSP(),product.getChatLieuVo(),product.getChatLieuDay(),product.getChatLieuMatDH(),product.getKichThuocMat(),product.getDoDay(),product.getChongNuoc(),product.getGia(),product.getNhaCungCap()});
        }
        
        this.tblproduct_detail.setModel(model);
    }
    
    public void search(){
        productdetail_find_data = new ArrayList<>();
        String option = (String) cboption.getSelectedItem();
        if(!txtfind.getText().equals("")){
            switch (option) {
                case "Mã sản phẩm":
                    for(ProductDetailDTO prd : productdetail_data){
                        if(prd.getMaSP().toLowerCase().trim().contains(txtfind.getText().toLowerCase().trim())){
                            productdetail_find_data.add(prd);
                            System.out.println(prd.getMaSP());
                        }
                    }
                    break;
                case "Chất liệu":
                    for(ProductDetailDTO prd : productdetail_data){
                        if(prd.getChatLieuVo().toLowerCase().trim().contains(txtfind.getText().toLowerCase().trim())){
                            productdetail_find_data.add(prd);
                            System.out.println(prd.getMaSP());
                        }
                    }
                    break;
                case "Giá":
                    for(ProductDetailDTO prd : productdetail_data){
                        if(prd.getGia().toLowerCase().trim().contains(txtfind.getText().toLowerCase().trim())){
                            productdetail_find_data.add(prd);
                            System.out.println(prd.getMaSP());
                        }
                    }
                    break;
                case "Nhà cung cấp":
                    for(ProductDetailDTO prd : productdetail_data){
                        if(prd.getNhaCungCap().toLowerCase().trim().contains(txtfind.getText().toLowerCase().trim())){
                            productdetail_find_data.add(prd);
                            System.out.println(prd.getMaSP());
                        }
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            showdata(productdetail_find_data);
        }
        else{
            showdata(productdetail_data);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == lblexit){
            this.dispose();
        }
        if (e.getSource()==lblfind) {
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
        if(e.getSource() == lblexit){
            this.lblexit.setBackground(hover_clr);
        }
        
        if (e.getSource() == lblfind) {
            lblfind.setBackground(hover_clr);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == lblexit){
            this.lblexit.setBackground(main_clr);
        }
        
        if (e.getSource() == lblfind) {
            lblfind.setBackground(main_clr);
        }
    }
    
}
