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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class Update_Product_form extends JFrame{
    
    JPanel pnlheading,pnlcontent,pnlleft,pnlright;
    
    Label heading;
    
    JTable tblproduct;
    
    DefaultTableModel model;
    
    JScrollPane spproduct;
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    public void initcomponent(){
        
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
        
        pnlcontent = new JPanel(new BorderLayout(10,10));
        
        pnlright = new JPanel(new GridLayout(1,1));
        
        tblproduct = new JTable();
        
        model = new DefaultTableModel();
        
        model.addColumn("Tên sản phẩm");
        model.addColumn("Xuất sứ");
        model.addColumn("Thương hiệu");
        model.addColumn("Số lượng");
        
        tblproduct.setModel(model);
        
        spproduct = new JScrollPane();
        
        spproduct.setViewportView(tblproduct);
        
        pnlright.add(spproduct);
        
        pnlleft = new JPanel();
        
        pnlleft.setPreferredSize(new Dimension(400,0));
        
        
        pnlcontent.add(pnlleft,BorderLayout.WEST);
        pnlcontent.add(pnlright,BorderLayout.CENTER);
        
        this.add(pnlcontent,BorderLayout.CENTER);
        this.add(pnlheading,BorderLayout.NORTH);
        
        this.setVisible(true);
    }

    public Update_Product_form() throws HeadlessException {
        initcomponent();
    }
    
    public static void main(String[] args) {
        new Update_Product_form();
    }
    
}
