/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.KhachHangBUS;
import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import com.mysql.cj.x.protobuf.MysqlxResultset;
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
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class Add_KhachHang extends JFrame implements MouseListener{
    JPanel pnlmain,pnlfill_info,pnlheading;
    
    Label heading,lbladd;;
        
    JLabel[] lblkh_info = new JLabel[2];
    
    JTextField[] txtkh_info = new JTextField[2];
    

    String[] kh_info_name = {"Tên khách hàng","SDT"};
    
    
    Font prd_info_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
        
    ArrayList<KhachHangDTO> khlist = new ArrayList<>();
    
    KhachHangDAO khdao = new KhachHangDAO();
    
    KhachHangBUS khbus = new KhachHangBUS();
    
    KhachHang khachhang_form;
    
    public void initcomponent(){
//        account = acc;
        
        khlist = khdao.selectAll();
        this.setSize(new Dimension(1000,600));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        pnlmain = new JPanel(new BorderLayout());
        
        pnlheading = new JPanel(new FlowLayout(1));
        
        pnlheading.setPreferredSize(new Dimension(0,100));
        pnlheading.setBorder(new EmptyBorder(30,0,0,0));
        pnlheading.setOpaque(true);
        pnlheading.setBackground(main_clr);
        
        heading = new Label("THÊM KHÁCH HÀNG",1);
        heading.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,25));
        heading.setForeground(new Color(240,240,240));
        
        pnlheading.add(heading);
        
        pnlfill_info = new JPanel(null);
        pnlfill_info.setBorder(new EmptyBorder(0,20,10,10));
        
        
        int count = 0;
        for(int i =0;i<2;i++){
            
            lblkh_info[i] = new JLabel(kh_info_name[i]);
            
            lblkh_info[i].setBounds(100 +(count * 400), 120+5, 180, 30);
            lblkh_info[i].setFont(prd_info_font);

               txtkh_info[i] = new JTextField();
               txtkh_info[i].setBounds(260 + (count * 400),120,180,30);
               pnlfill_info.add(txtkh_info[i]);            
            pnlfill_info.add(lblkh_info[i]);
            count++;
        }
        

        lbladd = new Label("Thêm",1);
        lbladd.setFont(prd_info_font);
        lbladd.setBackground(main_clr);
        lbladd.setForeground(new Color(240,240,240));
        lbladd.setBounds(410,350,100,30);
        lbladd.addMouseListener(this);

        

        pnlfill_info.add(lbladd);
        
        pnlmain.add(pnlfill_info,BorderLayout.CENTER);
        
        this.add(pnlheading,BorderLayout.NORTH);
        this.add(pnlmain,BorderLayout.CENTER);
        
        this.setVisible(true);
    }

    public Add_KhachHang() throws HeadlessException {
      
        initcomponent();
    }
    
        
    public int checkphone(String str){
        
         String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";

        boolean kt = str.matches(reg);
                if (kt == false) {
                    return 0;
        } else {
            return 1;
        }
    }


    public void add(){
        if(txtkh_info[0] == null || txtkh_info[1] == null ){
            JOptionPane.showMessageDialog(null, "Thiếu thông tin!!");
        }
        else{
         
        if(checkphone(txtkh_info[1].getText()) == 1){
            KhachHangDTO new_kh = new KhachHangDTO(Integer.toString(khbus.getKhachHanglist().size()+1), txtkh_info[0].getText(), txtkh_info[1].getText(),"0");
            khbus.addKh(new_kh);
            khlist = khbus.getKhachHanglist();
            this.dispose();
        }
        else{
           JOptionPane.showMessageDialog(this, "Số điện thoại không đúng định dạng!!");
        } 
        }
    }
    public void setKhachHang_form(KhachHang form)
            {
                this.khachhang_form= form;
            }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==lbladd){
            add();
            khachhang_form.setKhachHanglist(khlist);
            khachhang_form.showdata(khlist);
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

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == lbladd){
            lbladd.setBackground(main_clr);
        }

    }
      
}
