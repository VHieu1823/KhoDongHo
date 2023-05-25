/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import DTO.ChatLieuDTO;
import DTO.ChongNuocDTO;
import DTO.DoDayDTO;
import DTO.KichThuocDTO;
import java.awt.HeadlessException;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NAME
 */
public class Thuoctinh_form extends  JPanel  implements MouseListener{
    
    Label[] lblitem = new Label[6];
    String[] lblname = {"Chất liệu","Độ dày","Kích thước","Chống nước","Thương hiệu","Xuất xứ"};
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    
    public void initcomponent(){
        this.setLayout(new GridLayout(2,3,10,10));
        this.setOpaque(true);
        this.setBackground(new Color(240,240,240));
        this.setBorder(new EmptyBorder(10,10,50,25));
        
        for(int i=0;i<6;i++){
            lblitem[i] = new Label(lblname[i],1);
            lblitem[i].setBackground(Color.white);
            lblitem[i].setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
            lblitem[i].setForeground(new Color(90,90,90));
            lblitem[i].addMouseListener(this);
            this.add(lblitem[i]);
            
        }
    }

    public Thuoctinh_form() {
        initcomponent();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == lblitem[0])
        {
            try {
                ChangeThuocTinh newtt = new ChangeThuocTinh(lblname[0]);
            } catch (HeadlessException ex) {
                Logger.getLogger(Thuoctinh_form.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Thuoctinh_form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == lblitem[1])
        {
            try {
                ChangeThuocTinh newtt = new ChangeThuocTinh(lblname[1]);
            } catch (HeadlessException ex) {
                Logger.getLogger(Thuoctinh_form.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Thuoctinh_form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == lblitem[2])
        {
            try {
                ChangeThuocTinh newtt = new ChangeThuocTinh(lblname[2]);
            } catch (HeadlessException ex) {
                Logger.getLogger(Thuoctinh_form.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Thuoctinh_form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == lblitem[3])
        {
            try {
                ChangeThuocTinh newtt = new ChangeThuocTinh(lblname[3]);
            } catch (HeadlessException ex) {
                Logger.getLogger(Thuoctinh_form.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Thuoctinh_form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == lblitem[4])
        {
            try {
                ChangeThuocTinh newtt = new ChangeThuocTinh(lblname[4]);
            } catch (HeadlessException ex) {
                Logger.getLogger(Thuoctinh_form.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Thuoctinh_form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == lblitem[5])
        {
            try {
                ChangeThuocTinh newtt = new ChangeThuocTinh(lblname[5]);
            } catch (HeadlessException ex) {
                Logger.getLogger(Thuoctinh_form.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Thuoctinh_form.class.getName()).log(Level.SEVERE, null, ex);
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
        if(e.getSource()==lblitem[0]){
            lblitem[0].setBackground(new Color(230,230,230));
        }
     
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==lblitem[0]){
            lblitem[0].setBackground(Color.white);
        }
    }
    
}
