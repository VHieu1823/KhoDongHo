/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import BUS.AccountBUS;
import DTO.AccountDTO;
import DTO.NhanVienDTO;
import java.awt.CardLayout;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author NAME
 */
public class sup_account_info extends JPanel implements MouseListener{
    
    JPanel pnlaccount_detail,pnloverview,rootpanel;
    
    JLabel lblavt;
    
    Color main_clr = new Color(230,230,230);
    
    JLabel[] lblaccinfo = new JLabel[4];
    
    JLabel[] lblaccinfo_show = new JLabel[4];
    
    NhanVienDTO nhanvien;
    
    AccountDTO account;
    
    String[] lblaccinfo_tag = {"Mã nhân viên:","Tên nhân viên:","Số điện thoại:","Email:"};    
    
    CardLayout cl;
    
    Font lblaccinfo_font = new Font("Times New Roamn",Font.LAYOUT_RIGHT_TO_LEFT,14);
    
    ArrayList<AccountDTO> listacc ;

        
    public void initcomponent(NhanVienDTO nv, AccountDTO acc) throws IOException, SQLException{
        this.setOpaque(true);
        this.setBackground(new Color(220,220,220));
        this.setLayout(new FlowLayout(1,10,10));
        this.setPreferredSize(new Dimension(300,350));
        this.setBounds(1080, 0, 300, 0);
        
        nhanvien = nv;
        account = acc;
        
        listacc = new AccountBUS().getListaccount();
        
        String[] accinfo = {nhanvien.getMaNV(),nhanvien.getTenNV(),nhanvien.getSDT(),account.getEmail()};
        
        pnlaccount_detail = new JPanel();
        pnlaccount_detail.setLayout(new FlowLayout(1));
        pnlaccount_detail.setBorder(new LineBorder(main_clr, 5, true));
//        pnlaccount_detail.setPreferredSize(new Dimension(280,70));
        pnlaccount_detail.setOpaque(true);
        pnlaccount_detail.setBackground(main_clr);
        
        lblavt = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\avt.png"))));
        lblavt.setPreferredSize(new Dimension(260,50));
        lblavt.setOpaque(true);
        lblavt.setBackground(main_clr);
        lblavt.addMouseListener(this);
        
        pnlaccount_detail.add(lblavt);
        
        pnloverview = new JPanel();
        pnloverview.setLayout(new GridLayout(5,2,15,5));
        pnloverview.setPreferredSize(new Dimension(280,250));
        pnloverview.setOpaque(true);
        pnloverview.setBorder(new LineBorder(main_clr, 5, true));
        pnloverview.setBackground(main_clr);
        
        
        
        for(int i = 0;i < 4 ; i++){
            lblaccinfo[i] = new JLabel(lblaccinfo_tag[i]);
            lblaccinfo[i].setFont(lblaccinfo_font);
            lblaccinfo[i].setBackground(Color.red);
            
            lblaccinfo_show[i] = new JLabel(accinfo[i]);
            lblaccinfo_show[i].setFont(lblaccinfo_font);
            
            pnloverview.add(lblaccinfo[i]);
            pnloverview.add(lblaccinfo_show[i]);
        }
        
        
        
        this.add(pnlaccount_detail);
        this.add(pnloverview);

    }
    public sup_account_info(NhanVienDTO nv, AccountDTO acc) throws IOException, SQLException{
        initcomponent(nv,acc);
    }
    
    public JPanel setcontentpnl(JPanel pnl){
        return rootpanel = pnl;
    }
    
    
    public void openMenu(sup_account_info a) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 350; i++) {
                    a.setSize(300, i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(sup_account_info.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    public void closeMenu(sup_account_info a) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 350; i >= 0; i--) {
                    a.setSize(300, i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(sup_account_info.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == lblavt){
            try {
                Account acc_form = new Account(account, listacc);
                rootpanel.removeAll();
                rootpanel.add(acc_form);
                rootpanel.repaint();
                rootpanel.validate();
            } catch (IOException ex) {
                Logger.getLogger(sup_account_info.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                this.openMenu(this);
            } catch (InterruptedException ex) {
                Logger.getLogger(sup_account_info.class.getName()).log(Level.SEVERE, null, ex);
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
        if(e.getSource() == lblavt){
            lblavt.setBackground(new Color(200,200,200));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == lblavt){
            lblavt.setBackground(main_clr);
        }
    }
    
}
