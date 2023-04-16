/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

/**
 *
 * @author NAME
 */
public class buyerdisplay extends JFrame{
    
    JPanel pnl_prdlist,navbar;
    
    JPanel[] prd_ls = new JPanel[8];
    
    Color main_clr = new Color(150, 150, 220);
    
    public void initcomponent(){
        this.setSize(new Dimension(1080,1000));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        navbar = new JPanel();
        navbar.setOpaque(true);
        navbar.setBackground(main_clr);
        navbar.setPreferredSize(new Dimension(0,100));
        
        pnl_prdlist = new JPanel();
        pnl_prdlist.setOpaque(true);
        pnl_prdlist.setBackground(Color.red);
        pnl_prdlist.setLayout(new FlowLayout(0, 20, 20));
        
        for(int i = 0;i<8;i++){
            prd_ls[i] = new JPanel();
            prd_ls[i].setPreferredSize(new Dimension(240,380));
            
            pnl_prdlist.add(prd_ls[i]);
        }
        
        
        this.add(navbar,BorderLayout.NORTH);
        this.add(pnl_prdlist,BorderLayout.CENTER);
        
        
        this.setVisible(true);
    }

    public buyerdisplay(){
        initcomponent();
    }
    
    public static void main(String[] args) {
        new buyerdisplay();
    }
    
}
