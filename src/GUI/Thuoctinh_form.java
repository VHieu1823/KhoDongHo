/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author NAME
 */
public class Thuoctinh_form extends  JPanel{
    
    Label[] lblitem = new Label[4];
    String[] lblname = {"Chất liệu","Độ dày","Kích thước","C/N chống nước"};
    
    
    public void initcomponent(){
        this.setLayout(new GridLayout(2,2,10,10));
        this.setOpaque(true);
        this.setBackground(new Color(240,240,240));
        this.setBorder(new EmptyBorder(10,10,50,25));
        
        for(int i=0;i<4;i++){
            lblitem[i] = new Label(lblname[i],1);
            lblitem[i].setBackground(Color.white);
            lblitem[i].setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
            lblitem[i].setForeground(new Color(90,90,90));
            
            this.add(lblitem[i]);
        }
    }

    public Thuoctinh_form() {
        initcomponent();
    }
    
    
}
