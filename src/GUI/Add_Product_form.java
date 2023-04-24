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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import component.ImageScale;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author NAME
 */
public class Add_Product_form extends JFrame implements MouseListener{
    
    JPanel pnlmain,pnlfill_info,pnlimg,pnlheading;
    
    Label heading,lbladd,lblupdate,lblchooseimg;
    
    JLabel lblimg;
    
    JLabel[] lblprd_info = new JLabel[3];
    
    JTextField[] txtprd_info = new JTextField[3];
    
    String[] prd_info_name = {"Tên sản phẩm","Xuất sứ","Thương hiệu"};
    
    Font prd_info_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    ProductBUS productbus = new ProductBUS();
    
    ArrayList<ProductDTO> list = new ArrayList<>();
    
    AccountDTO account;
    
    Product product_form;
    
    DefaultTableModel model ;
    
    String path="";
    
    public void initcomponent(AccountDTO acc){
        account = acc;
        
        list = productbus.getPrdlist(account.getMaKho());
        
        this.setSize(new Dimension(900,600));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        pnlmain = new JPanel(new BorderLayout());
        
        pnlheading = new JPanel(new FlowLayout(1));
        
        pnlheading.setPreferredSize(new Dimension(0,100));
        pnlheading.setBorder(new EmptyBorder(30,0,0,0));
        pnlheading.setOpaque(true);
        pnlheading.setBackground(main_clr);
        
        heading = new Label("THÊM SẢN PHẨM",1);
        heading.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,22));
        heading.setForeground(new Color(240,240,240));
        
        pnlheading.add(heading);
        
        pnlfill_info = new JPanel(null);
        pnlfill_info.setBorder(new EmptyBorder(10,20,10,10));
        
        for(int i =0;i<3;i++){
            lblprd_info[i] = new JLabel(prd_info_name[i]);
            lblprd_info[i].setBounds(90, 100+(i*50), 120, 30);
            lblprd_info[i].setFont(prd_info_font);
//            lblprd_info[i].setOpaque(true);
//            lblprd_info[i].setBackground(Color.red);

            txtprd_info[i] = new JTextField();
            txtprd_info[i].setBounds(220,100+(i*50),200,30);
            
            pnlfill_info.add(lblprd_info[i]);
            pnlfill_info.add(txtprd_info[i]);
        }
        
        lblchooseimg = new Label("Chọn ảnh",1);
        lblchooseimg.setBounds(220,250,100,30);
        lblchooseimg.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,14));
        lblchooseimg.setBackground(Color.white);
        lblchooseimg.setForeground(new Color(90,90,90));
        lblchooseimg.addMouseListener(this);
        
        lbladd = new Label("Thêm",1);
        lbladd.setFont(prd_info_font);
        lbladd.setBackground(main_clr);
        lbladd.setForeground(new Color(240,240,240));
        lbladd.setBounds(150,300,100,30);
        lbladd.addMouseListener(this);
        
        lblupdate = new Label("Sửa",1);
        lblupdate.setFont(prd_info_font);
        lblupdate.setBackground(main_clr);
        lblupdate.setForeground(new Color(240,240,240));
        lblupdate.setBounds(260,300,100,30);
        lblupdate.addMouseListener(this);
        
        pnlfill_info.add(lblchooseimg);
        pnlfill_info.add(lbladd);
        pnlfill_info.add(lblupdate);
        
        pnlimg = new JPanel(new GridLayout(1,1));
        pnlimg.setPreferredSize(new Dimension(350,0));
        pnlimg.setBorder(new EmptyBorder(60,20,100,80));
//        pnlimg.setOpaque(true);
//        pnlimg.setBackground(main_clr);
        
        lblimg = new JLabel();
        lblimg.setBorder(new LineBorder(new Color(99,99,99),1,true));
//        lblimg.setOpaque(true);
//        lblimg.setBackground(Color.red);
        
        pnlimg.add(lblimg);
        
        pnlmain.add(pnlimg,BorderLayout.EAST);
        pnlmain.add(pnlfill_info,BorderLayout.CENTER);
        
        this.add(pnlheading,BorderLayout.NORTH);
        this.add(pnlmain,BorderLayout.CENTER);
        this.setVisible(true);
    }

    public Add_Product_form(AccountDTO account) throws HeadlessException {
        initcomponent(account);
    }
    
    public String openBrowser(){
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            String type = jfc.getTypeDescription(selectedFile);
            if(type.equals("JPG File")){
                path = jfc.getName(selectedFile) + ".jpg";
            }
        }
        return path;
    }

    public void setProduct_form(Product form){
        this.product_form = form;
    }
    
    public void add(){     
        ProductDTO new_prd = new ProductDTO(txtprd_info[0].getText(), txtprd_info[1].getText(), this.path, txtprd_info[2].getText(),account.getMaKho(), 0);
        if(productbus.addProduct(new_prd)==1){
            list.clear();
            list = productbus.getPrdlist(account.getMaKho());
            System.out.println(list.size());
            this.dispose();
        }   
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==lbladd){
            add();
            model = product_form.getModel();
            product_form.setProductlist(list);
            product_form.showdata(list, model);
        }
        if(e.getSource()==lblchooseimg){
            try {
                String path = openBrowser();
                System.out.println(path);
                ImageIcon Img = new ImageIcon(ImageIO.read(new File("src\\product_img\\"+path)));
                ImageIcon scaledIcon = ImageScale.scale_product_img(Img);
                lblimg.setIcon(scaledIcon);
            } catch (IOException ex) {
                Logger.getLogger(Add_Product_form.class.getName()).log(Level.SEVERE, null, ex);
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
        if(e.getSource() == lbladd){
            lbladd.setBackground(hover_clr);
        }
        if(e.getSource() == lblupdate){
            lblupdate.setBackground(hover_clr);
        }
        if(e.getSource() == lblchooseimg){
            lblchooseimg.setBackground(new Color(200,200,200));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == lbladd){
            lbladd.setBackground(main_clr);
        }
        if(e.getSource() == lblupdate){
            lblupdate.setBackground(main_clr);
        }
        if(e.getSource() == lblchooseimg){
            lblchooseimg.setBackground(Color.white);
        }
    }
      
}
