/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author NAME
 */
public class Add_Product_form extends JFrame{
    
    JPanel pnlmain,pnlfill_info,pnlimg,pnlheading;
    
    Label heading,lbladd,lblupdate;;
    
    JLabel lblimg;
    
    JLabel[] lblprd_info = new JLabel[3];
    
    JTextField[] txtprd_info = new JTextField[3];
    
    JButton btnimg = new JButton();
    
    String[] prd_info_name = {"Tên sản phẩm","Xuất sứ","Thương hiệu"};
    
    Font prd_info_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    public void initcomponent(){
        this.setSize(new Dimension(900,600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        
        btnimg = new JButton("chọn ảnh");
        btnimg.setBounds(160,250,100,30);
        
        lbladd = new Label("Thêm",1);
        lbladd.setFont(prd_info_font);
        lbladd.setBackground(main_clr);
        lbladd.setForeground(new Color(240,240,240));
        lbladd.setBounds(90,300,100,30);
        
        lblupdate = new Label("Sửa",1);
        lblupdate.setFont(prd_info_font);
        lblupdate.setBackground(main_clr);
        lblupdate.setForeground(new Color(240,240,240));
        lblupdate.setBounds(200,300,100,30);
        
        pnlfill_info.add(btnimg);
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

    public Add_Product_form() throws HeadlessException {
        initcomponent();
    }
    
    public static void main(String[] args) {
        new Add_Product_form();
    }
      
}
