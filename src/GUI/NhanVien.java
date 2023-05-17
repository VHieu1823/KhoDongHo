package GUI;




import DTO.NhanVienDTO;
import DAO.NhanVienDAO;
import BUS.NhanVienBUS;
import DTO.ProductDTO;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import component.ImageScale;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

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
    
    
    Label[] lblinfo = new Label[8];
    
    JDateChooser calendar;
    
    String[] lblinfo_name = {"Mã nhân viên","Tên nhân viên","Giới tính","Địa chỉ","Số điện thoại","Ngày sinh","Ngày Vào"};
            

    JTextField[] txtinfo = new JTextField[7] ;
    
    JRadioButton rbtnam,rbtnu;
    
    ButtonGroup rbtgroup;
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    

    NhanVienDAO nhanvien = new NhanVienDAO();
    
    ArrayList<NhanVienDTO> nvlist = new ArrayList<>();
    
    int index =0;
    
    NhanVienDTO nv1 = new NhanVienDTO();
    
    
    public void initcomponent(NhanVienDTO a) throws IOException{
        

     
        nvlist = nhanvien.selectAll();
        nv1 = nvlist.get(0);
      
                
        this.setLayout(new GridLayout(2,1));
        this.setBorder(new EmptyBorder(5,5,5,5));
        this.setOpaque(true);
        this.setBackground(null);
        
        String[] column = {"Mã nhân viên","Tên nhân viên","Giới tính","Số điện thoại","Ngày Vào"};
        
        Dimension txtinfo_dms = new Dimension(200,30);
        Font lblinfo_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
        
        
        
        tblnhanvien = new JTable();
        tblnhanvien.addMouseListener(this);
        
        spnhanvien = new JScrollPane();
        model = new DefaultTableModel();
        

        for(int i =0;i<5;i++){
            model.addColumn(column[i]);
        }
        
        tblnhanvien.setModel(model);
        showdata(nvlist);
        
        spnhanvien.setViewportView(tblnhanvien);
        
        pnlinfor = new JPanel(new FlowLayout(0));
        pnlinfor.setOpaque(true);
        
        pnlimg = new JPanel(new BorderLayout());

        pnlimg.setBorder(new EmptyBorder(15,50,0,10));
        pnlimg.setPreferredSize(new Dimension(260,270));
        lblimg = new JLabel();
        lblimg.setSize(220,270);
        lblimg.setBorder(new LineBorder(new Color(99,99,99),1,true));

        String s = "src\\img_employee\\nhanvien.png";
        if(!"".equals(nv1.getImg())){
            
                 String img_path = nv1.getImg();
                 ImageIcon icon = new ImageIcon(ImageIO.read(new File(img_path)));
                 Image image = icon.getImage();
                 Image imgScale = image.getScaledInstance(lblimg.getWidth(), lblimg.getHeight(),Image.SCALE_SMOOTH);
                 ImageIcon scaledIcon = new ImageIcon(imgScale);
                 lblimg.setIcon(scaledIcon);
        }
        else{
                     ImageIcon icon = new ImageIcon(ImageIO.read(new File(s)));
                     Image image = icon.getImage();
                     Image imgScale = image.getScaledInstance(lblimg.getWidth(), lblimg.getHeight(),Image.SCALE_SMOOTH);
                     ImageIcon scaledIcon = new ImageIcon(imgScale);
                     lblimg.setIcon(scaledIcon);
        }
        pnlimg.add(lblimg,BorderLayout.CENTER);
        
        pnlinfo_detail = new JPanel(null);
        pnlinfo_detail.setPreferredSize(new Dimension(1060,310));
        pnlinfo_detail.setBorder(new EmptyBorder(30,50,30,0));
        

        int y_pos = 50;
        int x_pos = 20;
        int x_index = 0;
        int count = 0;
        
        for(int i = 0 ; i<lblinfo_name.length;i++){
            lblinfo[i] = new Label(lblinfo_name[i]);
            lblinfo[i].setBounds((x_pos+(450*count)),y_pos,150,30);
            lblinfo[i].setAlignment(2);
            lblinfo[i].setFont(lblinfo_font);
            
            pnlinfo_detail.add(lblinfo[i]);
            
            if(i < txtinfo.length) {
                txtinfo[i] = new JTextField();    
                txtinfo[i].setBounds((x_pos+160+(450*count)),y_pos,170,30);
                pnlinfo_detail.add(txtinfo[i]);
            }


            if(i==1 || i==3 || i == 5){
                count = 0;
                y_pos += 50;
            }
            else{
                count++;
            }

        }


        txtinfo[0].setText(nv1.getMaNV());
        txtinfo[1].setText(nv1.getTenNV());
        txtinfo[2].setText(nv1.getGioiTinh());
        txtinfo[3].setText(nv1.getDiaChi());
        txtinfo[4].setText(nv1.getSDT());
        txtinfo[5].setText(nv1.getNgaySinh());
        txtinfo[6].setText(nv1.getNgayVao());
        
        pnlinfor.add(pnlimg);
        pnlinfor.add(pnlinfo_detail);
        
        
        this.add(spnhanvien);
        this.add(pnlinfor);
    }

    
        private void desplaydetails(int selectedRows){
    }
    
    public JTable gettbl(){
        return  this.tblnhanvien;
    }
    
    public DefaultTableModel getModel(){
        return  this.model; 
    }
    public void setNhanvienlist(ArrayList<NhanVienDTO> list){
        nvlist = list;
    }

    public void showdata(ArrayList<NhanVienDTO> list){
        model.setRowCount(0);
        for(NhanVienDTO nhv : list){
            model.addRow(new Object[] {nhv.getMaNV(),nhv.getTenNV(),nhv.getGioiTinh(),nhv.getSDT(),nhv.getNgayVao()});
            }

    }
    public void selectitem(ArrayList<NhanVienDTO> list) throws IOException{
                desplaydetails(tblnhanvien.getSelectedRow());
                this.index = tblnhanvien.getSelectedRow();
                NhanVienDTO a = list.get(index);
//                lblimg.setSize(220,270);
                String s = "src\\img_employee\\nhanvien.png";
                if(!"".equals(a.getImg())){
            
                     String img_path = a.getImg();
                     ImageIcon icon = new ImageIcon(ImageIO.read(new File(img_path)));
                     Image image = icon.getImage();
                     Image imgScale = image.getScaledInstance(lblimg.getWidth(), lblimg.getHeight(),Image.SCALE_SMOOTH);
                     ImageIcon scaledIcon = new ImageIcon(imgScale);
                     lblimg.setIcon(scaledIcon);
                }
                else{
                   
                     ImageIcon icon = new ImageIcon(ImageIO.read(new File(s)));
                     Image image = icon.getImage();
                     Image imgScale = image.getScaledInstance(lblimg.getWidth(), lblimg.getHeight(),Image.SCALE_SMOOTH);
                     ImageIcon scaledIcon = new ImageIcon(imgScale);
                     lblimg.setIcon(scaledIcon);
                 }
                
                 txtinfo[0].setText(a.getMaNV());
                 txtinfo[1].setText(a.getTenNV());
                 txtinfo[2].setText(a.getGioiTinh());
                 txtinfo[3].setText(a.getDiaChi());
                 txtinfo[4].setText(a.getSDT());
                 txtinfo[5].setText(a.getNgaySinh());
                 txtinfo[6].setText(a.getNgayVao());
    }

    public NhanVien(NhanVienDTO a) throws IOException {
        initcomponent(a);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
       if(e.getSource() == tblnhanvien ){
           try {
               selectitem(nvlist);
           } catch (IOException ex) {
               Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
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
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    public void keyTyped(KeyEvent e) {
    }

    
    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        desplaydetails(tblnhanvien.getSelectedRow());
    }
   
    
    
}
