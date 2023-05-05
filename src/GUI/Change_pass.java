/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.AccountDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author NAME
 */

public class Change_pass extends JFrame implements MouseListener{
    
    JPanel pnlheading,pnlconfirm;
    
    Label lblheading,lblverify,lblold_pass,lblnew_pass,lblconfirm;

    JPasswordField pfold_pass,pfnew_pass,pfconfirm;
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    public void initcomponent(AccountDTO acc){
        this.setSize(new Dimension(400,400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        pnlheading = new JPanel(new GridLayout(1,1));
        pnlheading.setPreferredSize(new Dimension(0,80));
        pnlheading.setOpaque(true);
        pnlheading.setBackground(main_clr);
        
        lblheading = new Label("Đổi mật khẩu");
        lblheading.setAlignment(1);
        lblheading.setForeground(new Color(240,240,240));
        lblheading.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        
        pnlheading.add(lblheading);
        
        pnlconfirm = new JPanel(null);
        
        lblverify = new Label("Xác nhận");
        lblverify.setAlignment(1);
        lblverify.setBackground(main_clr);
        lblverify.setForeground(new Color(240,240,240));
        lblverify.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,16));
        lblverify.setBounds(120,220,140,30);
        lblverify.addMouseListener(this);
        
        Font lbl_font = new Font("Times New Roman",Font.CENTER_BASELINE,14);
        
        lblold_pass = new Label("Mật khẩu hiện tại");
        lblold_pass.setAlignment(2);
        lblold_pass.setFont(lbl_font);
        lblold_pass.setBounds(20,30,130,30);
        
        pfold_pass = new JPasswordField();
        pfold_pass.setBounds(160,30,200,30);
        
        lblnew_pass = new Label("Mật khẩu mới");
        lblnew_pass.setAlignment(2);
        lblnew_pass.setFont(lbl_font);
        lblnew_pass.setBounds(20,80,130,30);
        
        pfnew_pass = new JPasswordField();
        pfnew_pass.setBounds(160,80,200,30);
        
        lblconfirm = new Label("Nhập lại mật khẩu");
        lblconfirm.setAlignment(2);
        lblconfirm.setFont(lbl_font);
        lblconfirm.setBounds(20,130,130,30);
        
        pfconfirm = new JPasswordField();
        pfconfirm.setBounds(160,130,200,30);
        
        pnlconfirm.add(lblold_pass);
        pnlconfirm.add(pfold_pass);
        pnlconfirm.add(lblnew_pass);
        pnlconfirm.add(pfnew_pass);
        pnlconfirm.add(lblconfirm);
        pnlconfirm.add(pfconfirm);
        pnlconfirm.add(lblverify);
        
        this.add(pnlheading,BorderLayout.NORTH);
        this.add(pnlconfirm,BorderLayout.CENTER);
        
        this.setVisible(true);
    }
    public Change_pass(AccountDTO acc) throws HeadlessException {
        initcomponent(acc);
    }
    
    public static void main(String[] args) {
        AccountDTO acc = new AccountDTO("A", "001", "a", 1, "AAA", "001");
        new Change_pass(acc);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==lblverify){
            lblverify.setBackground(hover_clr);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==lblverify){
            lblverify.setBackground(main_clr);
        }
    }
    
}
