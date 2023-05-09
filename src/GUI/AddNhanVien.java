/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.NhanVienBUS;
import DTO.AccountDTO;
import DTO.NhanVienDTO;
import DAO.NhanVienDAO;
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



public class AddNhanVien extends JFrame implements MouseListener{
JPanel pnlmain,pnlfill_info,pnlheading;
    
    Label heading,lbladd;;
    
    JLabel lblimg,pnlimg;
    
    JLabel[] lblnv_info = new JLabel[8];
    
    JTextField[] txtnv_info = new JTextField[8];
    
    JButton btnimg = new JButton();
    JDateChooser calendar;
    JDateChooser calendar1;
    
    String[] nv_info_name = {"Mã nhân viên","Tên nhân viên","Giới Tính","Địa chỉ","Số điện thoại","Ngày Sinh","Ngày Vào"};
    
    String pathString="";
    
    Font prd_info_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    NhanVienBUS nhanvienbus = new NhanVienBUS();
    
    ArrayList<NhanVienDTO> nvlist = new ArrayList<>();
    
    NhanVienDAO nhvdao = new NhanVienDAO();
    
    NhanVienDTO nhanvien;
    
    AccountDTO account;
    NhanVien nhanvien_form;
    
    public void initcomponent(){
//        account = acc;
        
        nvlist = nhvdao.selectAll();
        this.setSize(new Dimension(1200,600));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        pnlmain = new JPanel(new BorderLayout());
        
        pnlheading = new JPanel(new FlowLayout(1));
        
        pnlheading.setPreferredSize(new Dimension(0,100));
        pnlheading.setBorder(new EmptyBorder(30,0,0,0));
        pnlheading.setOpaque(true);
        pnlheading.setBackground(main_clr);
        
        heading = new Label("THÊM NHÂN VIÊN",1);
        heading.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,25));
        heading.setForeground(new Color(200,240,240));
        
        pnlheading.add(heading);
        
        pnlfill_info = new JPanel(null);
        pnlfill_info.setBorder(new EmptyBorder(0,20,10,10));
        
        int k = 50;
        int h = 120;
        int count = 0;
        for(int i =0;i<7;i++){
            
            lblnv_info[i] = new JLabel(nv_info_name[i]);
            
            lblnv_info[i].setBounds(k +(count * 400), h+5, 125, 21);
            lblnv_info[i].setFont(prd_info_font);
//            lblprd_info[i].setOpaque(true);
//            lblprd_info[i].setBackground(Color.red);
            
            if( i != 5 ){
               txtnv_info[i] = new JTextField();
               txtnv_info[i].setBounds(k + (count * 400) + 150,h,150,30);
               pnlfill_info.add(txtnv_info[i]);            
            }
            pnlfill_info.add(lblnv_info[i]);
            
            
            if(i==1 || i==3 || i == 5 || i == 7){
                h += 50;
                count = 0;
            }else{
                count ++;
            }

        }
        calendar = new JDateChooser();
        calendar.setDateFormatString("dd/MM/yyyy");
        calendar.setBounds(600,220,150,30);
        pnlfill_info.add(calendar);  
       
//        calendar1 = new JDateChooser(); 
//        calendar1.setDateFormatString("dd/MM/yyyy");
//        calendar1.setBounds(600,270,150,30);
//        pnlfill_info.add(calendar1); 

        String date = java.time.LocalDate.now().toString();
        String[] splits = date.split("-");
        String redate ="";
        List<String> data = new ArrayList<String>();
          for(String item : splits){
              data.add( item); 
          }
          redate = data.get(2) +"/"+ data.get(1)+"/"+data.get(0);
//        StringBuilder str = new StringBuilder(date);
        txtnv_info[6].setText(redate);
        
        btnimg = new JButton("Chọn ảnh");
        btnimg.setBounds(800,200,80,30);
        btnimg.addMouseListener(this);
        
        pnlimg = new JLabel();
        pnlimg.setBounds(920, 50, 230, 300);
        pnlimg.setBorder(new LineBorder(new Color(99,99,99),1,true));
        

        lbladd = new Label("Thêm",1);
        lbladd.setFont(prd_info_font);
        lbladd.setBackground(main_clr);
        lbladd.setForeground(new Color(240,240,240));
        lbladd.setBounds(410,350,100,30);
        lbladd.addMouseListener(this);

        
        pnlfill_info.add(btnimg);
        pnlfill_info.add(lbladd);
        
     
//        pnlimg.setOpaque(true);
//        pnlimg.setBackground(main_clr);
//        
        lblimg = new JLabel();
        lblimg.setBorder(new LineBorder(new Color(99,99,99),1,true));

        
        pnlimg.add(lblimg);
        
        pnlmain.add(pnlimg);
        pnlmain.add(pnlfill_info,BorderLayout.CENTER);
        
        this.add(pnlheading,BorderLayout.NORTH);
        this.add(pnlmain,BorderLayout.CENTER);
        
        this.setVisible(true);
    }

    public AddNhanVien() throws HeadlessException {
      
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
        if(checkphone(txtnv_info[4].getText()) == 1){

        NhanVienDTO new_nv = new NhanVienDTO(txtnv_info[0].getText(), txtnv_info[1].getText(), txtnv_info[2].getText(),txtnv_info[3].getText(),txtnv_info[4].getText(),((JTextField)calendar.getDateEditor().getUiComponent()).getText(),txtnv_info[6].getText(),pathString);
        nhanvienbus.addNhanVien(new_nv);
        nvlist.clear();
        nvlist = nhanvienbus.getNhanvienList();
        this.dispose();
        }
        else{
           JOptionPane.showMessageDialog(this, "Số điện thoại không đúng định dạng!!");
        }   
    }
    public void setNhanvien_form(NhanVien form)
            {
                this.nhanvien_form = form;
            }
    public void selectimg(){
        JFileChooser img = new JFileChooser("C:\\Users\\Admin\\Documents\\GitHub\\KhoDongHo\\src\\img_employee");
        img.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnValue = img.showOpenDialog(this);

        if(returnValue == JFileChooser.APPROVE_OPTION){
            File file= img.getSelectedFile();
            pathString = file.getAbsolutePath();
            pathString =  pathString.substring(42);
//            System.out.println(pathString);
            BufferedImage b;
            try {
                b = ImageIO.read(file);
//                pnlimg.setIcon(new ImageIcon(b));
                
                 ImageIcon icon = new ImageIcon(ImageIO.read(file));
                 Image image = icon.getImage();
                 Image imgScale = image.getScaledInstance(pnlimg.getWidth(), pnlimg.getHeight(),Image.SCALE_SMOOTH);
                 ImageIcon scaledIcon = new ImageIcon(imgScale);
                 pnlimg.setIcon(scaledIcon);
                
                
            } catch (Exception e) {
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==lbladd){
            add();
            nhanvien_form.setNhanvienlist(nvlist);
            nhanvien_form.showdata(nvlist);
        }
        if(e.getSource()== btnimg){
            selectimg();
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
