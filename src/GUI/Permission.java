/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author NAME
 */
public class Permission extends JFrame{
        
    JPanel pnlheading,pnlcontent;
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    Font prd_info_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
    Label heading;
    
    
    
    public void initcomponent(String name){
        this.setSize(new Dimension(1200,760));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlheading = new JPanel(new GridLayout(1,1));
        pnlheading.setPreferredSize(new Dimension(0,80));
        pnlheading.setOpaque(true);
        pnlheading.setBackground(main_clr);
        
        heading = new Label(name);
        heading.setAlignment(1);
        heading.setForeground(new Color(240,240,240));
        heading.setFont(prd_info_font);
        
        pnlheading.add(heading);
        
        pnlcontent = new JPanel(new GridLayout(1,1));
        pnlcontent.add(addPer());
        
        this.add(pnlheading,BorderLayout.NORTH);
        this.add(pnlcontent,BorderLayout.CENTER);
        
        this.setVisible(true);
    }
    
    public JPanel addPer(){
        JPanel pnladdper = new JPanel(null);
        
        String[] pnlname = {"QL Sản phẩm","QL Phiếu nhập","QL Phiếu xuất","QL Nhà cung cấp","QL Khách hàng","QL Nhân viên","QL Tài khoản","QL Phân quyền"};
        
        JPanel[] pnlper = new JPanel[8];
        
        Label[] lb = new Label[8];
        
        JRadioButton[] rbtper = new JRadioButton[24];
        
        Color clr = new Color(230,230,230);
        
        Color color = new Color(250,250,250);
        
        for(int i=0;i<8;i++){
            pnlper[i] = new JPanel(null);
            pnlper[i].setBounds(0,80*i,1200,80);
            if(i%2==1){
                pnlper[i].setOpaque(true);
                color = clr;
                pnlper[i].setBackground(color);
            }
            else{
                color = new Color(240,240,240);
            }
            
            Font font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
            
            lb[i] = new Label(pnlname[i],2);
            lb[i].setFont(font);
            lb[i].setBackground(color);
            lb[i].setBounds(150,25,170,30);
            
            rbtper[(i*3)] = new JRadioButton("Thêm");
            rbtper[(i*3)].setFont(font);
            rbtper[(i*3)].setOpaque(true);
            rbtper[(i*3)].setBackground(color);
            rbtper[(i*3)].setBounds(500,25,100,30);
            
            rbtper[(i*3)+1] = new JRadioButton("Xóa");
            rbtper[(i*3)+1].setFont(font);
            rbtper[(i*3)+1].setOpaque(true);
            rbtper[(i*3)+1].setBackground(color);
            rbtper[(i*3)+1].setBounds(700,25,100,30);
            
            rbtper[(i*3)+2] = new JRadioButton("Sửa");
            rbtper[(i*3)+2].setFont(font);
            rbtper[(i*3)+2].setOpaque(true);
            rbtper[(i*3)+2].setBackground(color);
            rbtper[(i*3)+2].setBounds(900,25,100,30);
            
            pnlper[i].add(lb[i]);
            pnlper[i].add(rbtper[(i*3)]);
            pnlper[i].add(rbtper[(i*3)+1]);
            pnlper[i].add(rbtper[(i*3)+2]);
            
            pnladdper.add(pnlper[i]);
        }
        
        
        return pnladdper;
    }
    

    public Permission(String name) throws HeadlessException {
        initcomponent(name);
    }
    
    public static void main(String[] args) {
        new Permission("Thêm nhóm quyền");
    }
    
}
