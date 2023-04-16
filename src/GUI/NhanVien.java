/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import DTO.AccountDTO;
import DTO.NhanVienDTO;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import component.ImageScale;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class NhanVien extends  JPanel implements MouseListener,ActionListener{
    
    JTable tblnhanvien;
    
    JScrollPane spnhanvien;
    
    DefaultTableModel model;
    
    JPanel pnlinfor,pnlimg,pnlinfo_detail,pnlsex;
    
    JLabel lblimg;
    
    Label[] lblinfo = new Label[6];
    
    JDateChooser calendar;
    
    String[] lblinfo_name = {"Mã nhân viên","Tên nhân viên","Địa chỉ","Số điện thoại","Ngày sinh","Giới tính"};
            
    JTextField[] txtinfo = new JTextField[4] ;
    
    JRadioButton rbtnam,rbtnu;
    
    ButtonGroup rbtgroup;
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    NhanVienDTO nhanvien;
    
    public void initcomponent(NhanVienDTO a) throws IOException{
        
        nhanvien = a;
        
        this.setLayout(new GridLayout(2,1));
        this.setBorder(new EmptyBorder(5,5,5,5));
        this.setOpaque(true);
        this.setBackground(null);
        
        String[] column = {"Mã nhân viên","Tên nhân viên","Ngày sinh","Địa chỉ","Giới tính","Tuổi","Số điện thoại"};
        
        Dimension txtinfo_dms = new Dimension(200,30);
        Font lblinfo_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
        
        
        
        tblnhanvien = new JTable();
        spnhanvien = new JScrollPane();
        model = new DefaultTableModel();
        
        for(int i =0;i<6;i++){
            model.addColumn(column[i]);
        }
        
        tblnhanvien.setModel(model);
        
        spnhanvien.setViewportView(tblnhanvien);
        
        pnlinfor = new JPanel(new FlowLayout(0));
        pnlinfor.setOpaque(true);
        
        pnlimg = new JPanel(new BorderLayout());
        pnlimg.setBorder(new EmptyBorder(15,0,0,10));
        pnlimg.setPreferredSize(new Dimension(300,310));
        if(nhanvien.getImg().trim()!=null){
            String img_path = nhanvien.getImg();
            ImageIcon img_employee = ImageScale.scale_employee_img(new ImageIcon(ImageIO.read(new File( img_path))));
            lblimg = new JLabel(img_employee);
        }
        else{
            lblimg = new JLabel("ERRO!!");
        }
        pnlimg.add(lblimg,BorderLayout.CENTER);
        
        pnlinfo_detail = new JPanel(null);
        pnlinfo_detail.setPreferredSize(new Dimension(1060,310));
        pnlinfo_detail.setBorder(new EmptyBorder(30,50,30,0));
        
        int y_pos = 70;
        int x_pos = 50;
        int x_index = 0;
        int count = 0;
        
        for(int i = 0 ; i<lblinfo_name.length;i++){
            lblinfo[i] = new Label(lblinfo_name[i]);
            lblinfo[i].setBounds((x_pos+(440*count)),y_pos,150,30);
            lblinfo[i].setAlignment(2);
            lblinfo[i].setFont(lblinfo_font);
            
            pnlinfo_detail.add(lblinfo[i]);
            
            if(i < txtinfo.length) {
                txtinfo[i] = new JTextField();    
                txtinfo[i].setBounds((x_pos+160+(440*count)),y_pos,200,30);
                pnlinfo_detail.add(txtinfo[i]);
            }

            if(i==1 || i==3){
                count = 0;
                y_pos += 50;
            }
            else{
                count++;
            }

        }
        
        calendar = new JDateChooser();
        calendar.setDateFormatString("dd/MM/yyyy");
        calendar.setBounds(210,170,200,30);
        pnlinfo_detail.add(calendar);
                
        pnlsex = new JPanel(new GridLayout(1, 2));
        pnlsex.setBounds(650,170,200,30);
//        pnlsex.setOpaque(true);
        pnlsex.setBorder(new EmptyBorder(0,20,0,0));
//        pnlsex.setBackground(main_clr);
        
        rbtnam = new JRadioButton();
        rbtnu = new JRadioButton();
        rbtnam.setText("Nam");
        rbtnu.setText("Nữ");
        rbtnam.setFont(lblinfo_font);
        rbtnu.setFont(lblinfo_font);
        
        rbtgroup = new ButtonGroup();
        rbtgroup.add(rbtnam);
        rbtgroup.add(rbtnu);
        
        pnlsex.add(rbtnam);
        pnlsex.add(rbtnu);
        
        pnlinfo_detail.add(pnlsex);
        
        
        pnlinfor.add(pnlimg);
        pnlinfor.add(pnlinfo_detail);
        
        
        this.add(spnhanvien);
        this.add(pnlinfor);
    }

    public NhanVien(NhanVienDTO a) throws IOException {
        initcomponent(a);
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
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
}
