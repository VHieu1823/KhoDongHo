/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.ProductBUS;
import DTO.AccountDTO;
import DTO.ProductDTO;
import component.ImageScale;
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
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class Update_Product_form extends JFrame implements MouseListener,KeyListener{
    
    JPanel pnlheading,pnlcontent,pnlleft,pnlright,pnlfind;
    
    JTextField txtfind,txttensp,txtthuonghieu,txtxuatsu,txtimg;
    
    JLabel lblfind,lblbrowser,lblimg_show;
    
    Label heading,lbltensp,lblthuonghieu,lblxuatsu,lblimg,lblupdate;
    
    JTable tblproduct;
    
    DefaultTableModel model;
    
    JScrollPane spproduct;
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    Color text_color = new Color(80,80,80);
    Font text_font = new Font("Times New Roman",Font.CENTER_BASELINE,15);
    Font prd_info_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
    
    ArrayList<ProductDTO> prdlist = new ArrayList<>();
    ArrayList<ProductDTO> find_productlist = new ArrayList<>();
    
    ProductBUS productbus;
    
    AccountDTO account;
    
    Product product_form;
    
    int index;
    String stt = "-1";
    int sl = -1;
    String path="";
    String source = "";
    
    public void initcomponent(AccountDTO acc) throws IOException{
        
        productbus = new ProductBUS();
        account = acc;
        
        prdlist = productbus.getPrdlist();
        
        this.setSize(new Dimension(1300,700));
        this.setLayout(new BorderLayout(5,0));
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
        
        pnlcontent = new JPanel(new BorderLayout(10,5));
        pnlcontent.setOpaque(true);
        pnlcontent.setBorder(new EmptyBorder(0,5,5,5));
        pnlcontent.setBackground(Color.white);
        
        pnlfind = new JPanel(null);
        pnlfind.setOpaque(true);
        pnlfind.setBackground(Color.white);
        pnlfind.setPreferredSize(new Dimension(0,50));
        
        txtfind = new JTextField();
        txtfind.setBounds(450, 5, 330, 40);
//        txtfind.setText("Tìm kiếm....");
        txtfind.setForeground(new Color(120, 120, 120));
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
        pnlright.setBorder(new LineBorder(new Color(90,90,90),1,true));
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
        lbltensp.setBounds(40,10,100,30);
//        lbltensp.setBackground(main_clr);
        
        lblxuatsu = new Label("Xuất xứ");
        lblxuatsu.setAlignment(1);
        lblxuatsu.setFont(text_font);
        lblxuatsu.setForeground(text_color);
        lblxuatsu.setBounds(40,55,100,30);
//        lblxuatsu.setBackground(main_clr);
        
        lblthuonghieu = new Label("Thương hiệu");
        lblthuonghieu.setAlignment(1);
        lblthuonghieu.setFont(text_font);
        lblthuonghieu.setForeground(text_color);
        lblthuonghieu.setBounds(40,100,100,30);
//        lblthuonghieu.setBackground(main_clr);

        lblimg = new Label("Hình ảnh");
        lblimg.setAlignment(1);
        lblimg.setFont(text_font);
        lblimg.setForeground(text_color);
        lblimg.setBounds(40,145,100,30);
        
        txttensp = new JTextField();
        txttensp.setBounds(150,10,200,30);
        
        txtxuatsu = new JTextField();
        txtxuatsu.setBounds(150,55,200,30);
        
        txtthuonghieu = new JTextField();
        txtthuonghieu.setBounds(150,100,200,30);
        
        txtimg = new JTextField();
        txtimg.setBounds(150,145,160,30);
        
        lblbrowser = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\browser.png"))));
        lblbrowser.setBounds(320,145,30,30);
        lblbrowser.setOpaque(true);
        lblbrowser.setBackground(Color.white);
        lblbrowser.addMouseListener(this);
        
        lblimg_show = new JLabel();
        lblimg_show.setBounds(150,185,200,260);
        lblimg_show.setBorder(new LineBorder(new Color(90,90,90),1,true));
        
        lblupdate = new Label("Sửa",1);
        lblupdate.setFont(prd_info_font);
        lblupdate.setBackground(main_clr);
        lblupdate.setForeground(new Color(240,240,240));
        lblupdate.setBounds(300,460,100,30);
        lblupdate.addMouseListener(this);
        
        pnlleft.add(lbltensp);
        pnlleft.add(lblxuatsu);
        pnlleft.add(lblthuonghieu);
        pnlleft.add(lblimg);
        pnlleft.add(txttensp);
        pnlleft.add(txtxuatsu);
        pnlleft.add(txtthuonghieu);
        pnlleft.add(txtimg);
        pnlleft.add(lblbrowser);
        pnlleft.add(lblupdate);
        pnlleft.add(lblimg_show);
        
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
    
    public void setdata(ProductDTO prd) throws IOException{
        txttensp.setText(prd.getTenSP());
        txtxuatsu.setText(prd.getXuatSu());
        txtthuonghieu.setText(prd.getThuongHieu());
        this.stt = prd.getStt();
        this.sl = prd.getSoluong();
        if(!prd.getHinhAnh().equals("null")){
            txtimg.setText("src\\product_img\\"+prd.getHinhAnh());
            ImageIcon img = ImageScale.scale_employee_img(new ImageIcon(ImageIO.read(new File(txtimg.getText()))));
            lblimg_show.setIcon(img);
        }
        else{
            lblimg_show.setIcon(null);
            txtimg.setText("");
        }
    }

    public void selectitem(ArrayList<ProductDTO> list) throws IOException{                  
        desplaydetails(tblproduct.getSelectedRow());
        this.index =tblproduct.getSelectedRow();
        ProductDTO a = list.get(index);
        setdata(a);       
    }
    
    public void search(){
        if(txtfind.getText().trim().equals("")){
            model.setRowCount(0);
            prdlist.clear();
            prdlist = productbus.getPrdlist();
            for(ProductDTO product : prdlist){
                if(product.getTenSP().toLowerCase().contains(txtfind.getText().toLowerCase())){
                    model.addRow(new Object[] {product.getTenSP(),product.getXuatSu(),product.getThuongHieu(),Integer.toString(product.getSoluong())});
                }
            }
        }
        else{
            model.setRowCount(0);
            prdlist.clear();
            prdlist = productbus.getPrdlist();
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
    
    public static void copyFile(String sourceFile,String name)throws IOException {
        File src = new File(sourceFile);
        
        File dest = new File("C:\\Users\\NAME\\OneDrive\\Documents\\GitHub\\KhoDongHo\\src\\product_img\\"+name);
        try {
            Files.copy(src.toPath(), dest.toPath());
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update() throws IOException{
        String url ="";
        if(txtimg.getText().equals("")){
            url="null";
        }
        else{
            url = txtimg.getText();
            copyFile(source, path);
        }
        ProductDTO product = new ProductDTO(this.stt,txttensp.getText(),txtxuatsu.getText(),url,txtthuonghieu.getText(),this.sl);
        productbus.updateProduct(product);
        model.setRowCount(0);
        prdlist = productbus.getPrdlist();
        for(ProductDTO prd : prdlist){
            model.addRow(new Object[] {prd.getTenSP(),prd.getXuatSu(),prd.getThuongHieu(),Integer.toString(prd.getSoluong())});
        }
        product_form.setProductlist(prdlist);
        product_form.showdata(prdlist);
        
    }
    
    public String openBrowser() throws IOException{
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        
        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            this.source = selectedFile.getPath();
            String type = jfc.getTypeDescription(selectedFile);
            if(type.equals("JPG File")){
                path = jfc.getName(selectedFile) + ".jpg";
            }
            if(type.equals("PNG File")){
                path = jfc.getName(selectedFile) + ".png";
            }           
            System.out.println(path);
            ImageIcon Img = new ImageIcon(ImageIO.read(new File(selectedFile.getPath())));
            ImageIcon scaledIcon = ImageScale.scale_product_img(Img);
            lblimg_show.setIcon(scaledIcon);
        }
        return path;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==lblfind){
            search();
        }
        if (e.getSource()==tblproduct) {
            try {
                selectitem(prdlist);
            } catch (IOException ex) {
                Logger.getLogger(Update_Product_form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==lblbrowser){
            try {
                path = openBrowser();
                txtimg.setText("src\\product_img\\"+path);
            } catch (IOException ex) {
                Logger.getLogger(Update_Product_form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==lblupdate){
            try {
                update();
            } catch (IOException ex) {
                Logger.getLogger(Update_Product_form.class.getName()).log(Level.SEVERE, null, ex);
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
        if(e.getSource()==lblfind){
            lblfind.setBackground(hover_clr);
        }
        if(e.getSource()==lblupdate){
            lblupdate.setBackground(hover_clr);
        }
        if(e.getSource()==lblbrowser){
            lblbrowser.setBackground(new Color(210,210,210));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==lblfind){
            lblfind.setBackground(main_clr);
        }
        if(e.getSource()==lblupdate){
            lblupdate.setBackground(main_clr);
        }
        if(e.getSource()==lblbrowser){
            lblbrowser.setBackground(Color.white);
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
