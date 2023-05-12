/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import DTO.AccountDTO;
import DTO.NhaCungCapDTO;
import DAO.NhaCungCapDAO;
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



public class Add_NhaCungCap extends JFrame implements MouseListener{
JPanel pnlmain,pnlfill_info,pnlheading;
    
    Label heading,lbladd;;
    
    JLabel lblimg,pnlimg;
    
    JLabel[] lblnv_info = new JLabel[5];
    
    JTextField[] txtnv_info = new JTextField[8];
    
    JButton btnimg = new JButton();
    JDateChooser calendar;
    JDateChooser calendar1;
    
    String[] nv_info_name = {"Mã nhà cung cấp","Tên nhà cung cấp","Địa chỉ","Email","Hotline"};
    
    String pathString="";
    
    Font prd_info_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    NhaCungCapBUS nccbus = new NhaCungCapBUS();
    
    ArrayList<NhaCungCapDTO> ncclist = new ArrayList<>();
    
    NhaCungCapDAO nccdao = new NhaCungCapDAO();
    
    NhanVienBUS nhanvien;
    
    AccountDTO account;
    NhaCungCap nhacungcap_form;
    
    public void initcomponent(){
//        account = acc;
        
        ncclist = nccdao.selectAll();
        this.setSize(new Dimension(1000,600));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        pnlmain = new JPanel(new BorderLayout());
        
        pnlheading = new JPanel(new FlowLayout(1));
        
        pnlheading.setPreferredSize(new Dimension(0,100));
        pnlheading.setBorder(new EmptyBorder(30,0,0,0));
        pnlheading.setOpaque(true);
        pnlheading.setBackground(main_clr);
        
        heading = new Label("THÊM NHÀ CUNG CẤP",1);
        heading.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,25));
        heading.setForeground(new Color(200,240,240));
        
        pnlheading.add(heading);
        
        pnlfill_info = new JPanel(null);
        pnlfill_info.setBorder(new EmptyBorder(0,20,10,10));
        
        int k = 100;
        int h = 120;
        int count = 0;
        for(int i =0;i<5;i++){
            
            lblnv_info[i] = new JLabel(nv_info_name[i]);
            
            lblnv_info[i].setBounds(k +(count * 400), h+5, 180, 30);
            lblnv_info[i].setFont(prd_info_font);

            if( i != 5 ){
               txtnv_info[i] = new JTextField();
               txtnv_info[i].setBounds(k + (count * 400) + 160,h,180,30);
               pnlfill_info.add(txtnv_info[i]);            
            }
            pnlfill_info.add(lblnv_info[i]);
   
            if(i==1 || i==3 ){
                h += 70;
                count = 0;
            }else{
                count ++;
            }

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

    public Add_NhaCungCap() throws HeadlessException {
      
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
        if(txtnv_info[0] == null || txtnv_info[1] == null || txtnv_info[2] == null || txtnv_info[3] == null || txtnv_info[4] == null){
            JOptionPane.showMessageDialog(null, "Thiếu thông tin!!");
        }
        else{
         
        if(checkphone(txtnv_info[4].getText()) == 1){

            NhaCungCapDTO new_ncc = new NhaCungCapDTO(txtnv_info[0].getText(), txtnv_info[1].getText(), txtnv_info[2].getText(),txtnv_info[3].getText(),txtnv_info[4].getText());
            nccbus.addNCC(new_ncc);
            ncclist.clear();
            ncclist = nccbus.getarrncc();
            this.dispose();
        }
        else{
           JOptionPane.showMessageDialog(this, "Số điện thoại không đúng định dạng!!");
        } 
        }
    }
    public void setNhaCungCap_form(NhaCungCap form)
            {
                this.nhacungcap_form= form;
            }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==lbladd){
            add();
            nhacungcap_form.setNhaCungCapList(ncclist);
            nhacungcap_form.showdata(ncclist);
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
