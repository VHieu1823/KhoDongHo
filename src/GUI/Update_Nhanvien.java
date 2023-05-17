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
import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;



public class Update_Nhanvien extends JFrame implements MouseListener{
    JPanel pnlmain,pnlfill_info,pnlheading,pnl_left,pnl_right;
    
    Label heading,lblupdate,lblmanv;
    
    JLabel lblimg,pnlimg;
    
    JTable tblnhanvien;
    
    JLabel[] lblnv_info = new JLabel[8];
    
    JScrollPane nhvtbl;
    
    JTextField[] txtnv_info = new JTextField[8];
    
    DefaultTableModel model;
    
    JButton btnimg = new JButton();
    
    JDateChooser calendar;
    
    JDateChooser calendar1;
    
    String[] nv_info_name = {"Mã nhân viên","Tên nhân viên","Giới Tính","Địa chỉ","Số điện thoại","Ngày Sinh","Ngày Vào"};
    
    String pathString;
    
    Font prd_info_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    NhanVienBUS nhanvienbus = new NhanVienBUS();
    
    ArrayList< NhanVienDTO> nhanvienlist = new ArrayList<>();
    
    NhanVienDAO nhvdao = new NhanVienDAO();
    
    NhanVienDTO nhvup;
    
    AccountDTO account;
    
    NhanVien nhanvien_form;
    int index = 0;
    
    Date date1,date2 ;
    
    public void initcomponent() throws IOException{
//        
        
        
        nhanvienlist = nhvdao.selectAll();
        this.setSize(new Dimension(1200,600));
        this.setLayout(new BorderLayout(10,10));
        this.setLocationRelativeTo(null);

        
        
        pnlmain = new JPanel();
        pnlmain.setOpaque(true);
        pnlmain.setLayout(new BorderLayout(10,10));

        
        pnlheading = new JPanel(new FlowLayout(1));
        
        pnlheading.setPreferredSize(new Dimension(0,100));
        pnlheading.setBorder(new EmptyBorder(0,0,0,0));
        pnlheading.setOpaque(true);
        pnlheading.setBackground(main_clr);
        
        heading = new Label("SỬA THÔNG TIN NHÂN VIÊN",1);
        heading.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,25));
        heading.setForeground(new Color(200,240,240));
        
        pnlheading.add(heading);
        
        pnl_left = new JPanel(new GridLayout(1, 1));
        pnl_left.setOpaque(true);
        pnl_left.setPreferredSize(new Dimension(400,0));
        pnl_left.setBorder(new EmptyBorder(0,30,30,30));
        
        
        tblnhanvien = new JTable();
        tblnhanvien.addMouseListener(this);
        
        model =new DefaultTableModel();
        
        model.addColumn("Mã Nhân Viên");
        model.addColumn("Tên Nhân Viên");
        
        for(NhanVienDTO nhv : nhanvienlist){
            model.addRow(new Object[] {nhv.getMaNV(),nhv.getTenNV()});
        }
      
        tblnhanvien.setModel(model);
        
        nhvtbl = new JScrollPane();
        
        nhvtbl.setViewportView(tblnhanvien);
        
        pnl_left.add(nhvtbl,BorderLayout.CENTER);
        
        
        pnl_right = new JPanel(null);
        pnl_right.setOpaque(true);
        pnl_right.setBackground(new Color(240,240,240));
        pnl_right.setBorder(new EmptyBorder(0,0,0,0));
        pnl_right.setPreferredSize(new Dimension(800,600));
//        pnl_right.setBorder(new LineBorder (new Color(100,100,100),2,true));

        int k = 50;
        int h = 30;
        for(int i = 0;i<7;i++){
            
            lblnv_info[i] = new JLabel(nv_info_name[i]);
            
            lblnv_info[i].setBounds(k, h, 130, 30);
            lblnv_info[i].setFont(prd_info_font);
            pnl_right.add(lblnv_info[i]);
            

            
            if( i != 5 && i !=0 && i != 6){
               txtnv_info[i] = new JTextField();
               txtnv_info[i].setBounds(k + 140,h,140,27);
               pnl_right.add(txtnv_info[i]);            
            }
            
            h+= 50;

        }
        lblmanv= new Label();
        lblmanv.setFont(prd_info_font);
        lblmanv.setBackground(new Color(135,206,235));
        lblmanv.setForeground(new Color(0,0,0));
        lblmanv.setBounds(190,30,140,30);
        pnl_right.add(lblmanv);
        
        calendar = new JDateChooser();
        calendar.setDateFormatString("dd/MM/yyyy");
        calendar.setBounds(190,278,140,30);
        pnl_right.add(calendar);  
        
        calendar1 = new JDateChooser();
        calendar1.setDateFormatString("dd/MM/yyyy");
        calendar1.setBounds(190,328,140,30);
        pnl_right.add(calendar1); 
       
         
        btnimg = new JButton("Chọn ảnh");
        btnimg.setBounds(390,180,80,30);
        btnimg.addMouseListener(this);
        

        pnlimg = new JLabel();
        pnlimg.setBounds(500, 50, 190, 250);
        pnlimg.setBorder(new LineBorder(new Color(99,99,99),1,true));
        

        lblupdate= new Label("Hoàn Thành",1);
        lblupdate.setFont(prd_info_font);
        lblupdate.setBackground(main_clr);
        lblupdate.setForeground(new Color(240,240,240));
        lblupdate.setBounds(370,380,130,30);
        lblupdate.addMouseListener(this);
        lblupdate.setAlignment(1);

        
        pnl_right.add(btnimg);
        pnl_right.add(lblupdate);

        lblimg = new JLabel();
        lblimg.setBorder(new LineBorder(new Color(99,99,99),1,true));

        pnlimg.add(lblimg);
        pnl_right.add(pnlimg);
   
        this.add(pnlheading,BorderLayout.NORTH);
        this.add(pnlmain,BorderLayout.CENTER);
        pnlmain.add(pnl_right,BorderLayout.EAST);
        pnlmain.add(pnl_left,BorderLayout.WEST);
        
        this.setVisible(true);

        
    }

    public Update_Nhanvien() throws HeadlessException, IOException {
      
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

    public void update(){
          if(JOptionPane.showConfirmDialog(this, "Bạn muốn sửa thông tin nhân viên này ?","Chi tiết nhân viên",JOptionPane.YES_NO_OPTION) ==0){
                if(checkphone(txtnv_info[4].getText())== 1){
                NhanVienDTO new_nv = new NhanVienDTO(nhvup.getMaNV(), txtnv_info[1].getText(), txtnv_info[2].getText(),txtnv_info[3].getText(),txtnv_info[4].getText(),((JTextField)calendar.getDateEditor().getUiComponent()).getText(),((JTextField)calendar1.getDateEditor().getUiComponent()).getText(),nhvup.getImg(),nhvup.getStatus());
                nhanvienbus.updatenv(new_nv);
                System.out.println(nhvup.getMaNV());
                nhanvienlist.clear();
                nhanvienlist = nhanvienbus.getNhanvienList();
                this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Số điện thoại không đúng định dạng!!");
                }
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
        nhvup.setImg(pathString);
    }
    
    private void desplaydetails(int selectedRows){
    }
    public void selectitem(ArrayList<NhanVienDTO> list) throws IOException{
                desplaydetails(tblnhanvien.getSelectedRow());
                this.index = tblnhanvien.getSelectedRow();
                NhanVienDTO a = list.get(index);
                nhvup = a;
//                lblimg.setSize(220,270);
    
                String s = "src\\img_employee\\nhanvien.png";
                if(!"".equals(a.getImg())){
            
                     String img_path = a.getImg();
                     ImageIcon icon = new ImageIcon(ImageIO.read(new File(img_path)));
                     Image image = icon.getImage();
                     Image imgScale = image.getScaledInstance(pnlimg.getWidth(), pnlimg.getHeight(),Image.SCALE_SMOOTH);
                     ImageIcon scaledIcon = new ImageIcon(imgScale);
                     pnlimg.setIcon(scaledIcon);
                }
                else{
                     ImageIcon icon = new ImageIcon(ImageIO.read(new File(s)));
                     Image image = icon.getImage();
                     Image imgScale = image.getScaledInstance(pnlimg.getWidth(), pnlimg.getHeight(),Image.SCALE_SMOOTH);
                     ImageIcon scaledIcon = new ImageIcon(imgScale);
                     pnlimg.setIcon(scaledIcon);
                 }
        if(a.getNgaySinh() != null){
            
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
            try {
               date1 = formatter1.parse(a.getNgaySinh());
            } catch (ParseException ex) {
               Logger.getLogger(Update_Nhanvien.class.getName()).log(Level.SEVERE, null, ex);
            }
            calendar.setDate(date1);
        }
        if(a.getNgayVao()!= null){
            
            SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
            try {
               date1 = formatter2.parse(a.getNgayVao());
            } catch (ParseException ex) {
               Logger.getLogger(Update_Nhanvien.class.getName()).log(Level.SEVERE, null, ex);
            }
            calendar1.setDate(date1);
        }
        

        lblmanv.setText(a.getMaNV());
//        txtnv_info[0].setText(a.getMaNV());
        txtnv_info[1].setText(a.getTenNV());
        txtnv_info[2].setText(a.getGioiTinh());
        txtnv_info[3].setText(a.getDiaChi());
        txtnv_info[4].setText(a.getSDT());
    
//        txtnv_info[6].setText(a.getNgayVao());
    }
    public void setNhanvienlist(ArrayList<NhanVienDTO> list){
        nhanvienlist = list;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==lblupdate){
            update();
            nhanvien_form.setNhanvienlist(nhanvienlist);
            nhanvien_form.showdata(nhanvienlist);
        }
        if(e.getSource()== btnimg){
            selectimg();
        }
        if(e.getSource() == tblnhanvien){
            try {
                selectitem(nhanvienlist);
            } catch (IOException ex) {
                Logger.getLogger(Update_Nhanvien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public JTable gettbl(){
        return  this.tblnhanvien;
    }
    
    public DefaultTableModel getModel(){
        return  this.model; 
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if(e.getSource() == lblupdate){
            lblupdate.setBackground(hover_clr);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == lblupdate){
            lblupdate.setBackground(main_clr);
        }
    }
      
}
