/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.KhachHangBUS;
import DTO.KhachHangDTO;
import DAO.KhachHangDAO;
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



public class Update_KhachHang extends JFrame implements MouseListener{
    JPanel pnlmain,pnlfill_info,pnlheading,pnl_left,pnl_right;
    
    Label heading,lblupdate,lblmaKH;
        
    JTable tblkh;
    
    JLabel[] lblkh_info = new JLabel[4];
    
    JScrollPane khtbl;
    
    JTextField[] txtkh_info = new JTextField[4];
    
    DefaultTableModel model;
    

    
    String[] kh_info_name = {"Mã khách hàng","Tên khách hàng","SDT","Tổng Tiền"};
       
    Font prd_info_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    KhachHangBUS khbus = new KhachHangBUS();
    
    ArrayList<KhachHangDTO> khlist = new ArrayList<>();
    
    KhachHangDAO khdao = new KhachHangDAO();
    
    KhachHangDTO khdto;
       
    KhachHang kh_form;
    int index = 0;
    

    
    public void initcomponent() throws IOException{
//        
        
        
        khlist = khdao.selectAll();
        this.setSize(new Dimension(850,650));
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
        
        heading = new Label("SỬA THÔNG TIN KHÁCH HÀNG",1);
        heading.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,25));
        heading.setForeground(new Color(240,240,240));
        
        pnlheading.add(heading);
        
        pnl_left = new JPanel(new GridLayout(1, 1));
        pnl_left.setOpaque(true);
        pnl_left.setPreferredSize(new Dimension(400,0));
        pnl_left.setBorder(new EmptyBorder(0,30,30,30));
        
        
        tblkh = new JTable();
        tblkh.addMouseListener(this);
        
        model =new DefaultTableModel();
        
        model.addColumn("Mã Khách Hàng");
        model.addColumn("Tên Khách Hàng");
        
        for(KhachHangDTO kh : khlist){
            model.addRow(new Object[] {kh.getMaKH(),kh.getTenKh()});
        }
      
        tblkh.setModel(model);
        
        khtbl = new JScrollPane();
        
        khtbl.setViewportView(tblkh);
        
        pnl_left.add(khtbl,BorderLayout.CENTER);
        
        
        pnl_right = new JPanel(null);
        pnl_right.setOpaque(true);
        pnl_right.setBackground(new Color(240,240,240));
        pnl_right.setBorder(new EmptyBorder(0,0,0,0));
        pnl_right.setPreferredSize(new Dimension(500,600));
//        pnl_right.setBorder(new LineBorder (new Color(100,100,100),2,true));

        int k = 100;
        int h = 30;
        for(int i = 0;i<4;i++){
            
            lblkh_info[i] = new JLabel(kh_info_name[i]);
            
            lblkh_info[i].setBounds(k, h, 150, 30);
             lblkh_info[i].setFont(prd_info_font);
            pnl_right.add(lblkh_info[i]);
            

            
            if(  i !=0){
               txtkh_info[i] = new JTextField();
               txtkh_info[i].setBounds(k + 160,h,160,30);
               pnl_right.add(txtkh_info[i]);            
            }
            
            h+= 80;

        }
        lblmaKH= new Label();
        lblmaKH.setFont(prd_info_font);
        lblmaKH.setBackground(new Color(135,206,235));
        lblmaKH.setForeground(new Color(0,0,0));
        lblmaKH.setBounds(260,30,160,30);
        pnl_right.add(lblmaKH);
        
        lblupdate= new Label("Hoàn Thành",1);
        lblupdate.setFont(prd_info_font);
        lblupdate.setBackground(main_clr);
        lblupdate.setForeground(new Color(240,240,240));
        lblupdate.setBounds(230,420,130,35);
        lblupdate.addMouseListener(this);
        lblupdate.setAlignment(1);


        pnl_right.add(lblupdate);

        this.add(pnlheading,BorderLayout.NORTH);
        this.add(pnlmain,BorderLayout.CENTER);
        pnlmain.add(pnl_right,BorderLayout.EAST);
        pnlmain.add(pnl_left,BorderLayout.WEST);
        
        this.setVisible(true);

        
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
          if(JOptionPane.showConfirmDialog(this, "Bạn muốn sửa thông tin khách hàng này ?","Chi tiết khách hàng",JOptionPane.YES_NO_OPTION) ==0){
                if(checkphone(txtkh_info[2].getText())== 1){
                KhachHangDTO new_nv = new KhachHangDTO(khdto.getMaKH(), txtkh_info[1].getText(), txtkh_info[2].getText(),khdto.getTongTien());
                khbus.updatekh(new_nv);
                khlist.clear();
                khlist = khbus.getKhachHanglist();
                this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Số điện thoại không đúng định dạng!!");
                }
        }
    }
    public void setKhachHang_Form(KhachHang form)
            {
                this.kh_form = form;
            }

    
    private void desplaydetails(int selectedRows){
    }
    public void selectitem(ArrayList<KhachHangDTO> list) throws IOException{
                desplaydetails(tblkh.getSelectedRow());
                this.index = tblkh.getSelectedRow();
                KhachHangDTO a = list.get(index);
                khdto = a;

        lblmaKH.setText(a.getMaKH());
//        txtnv_info[0].setText(a.getMaNV());
        txtkh_info[1].setText(a.getTenKh());
        txtkh_info[2].setText(a.getSDT());
        txtkh_info[3].setText(a.getTongTien());

    }
    public void setKHList(ArrayList<KhachHangDTO> list){
        khlist = list;
    }
    
    public Update_KhachHang() throws  IOException {
      
      initcomponent();
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==lblupdate){
            update();
            kh_form.setKhachHanglist(khlist);
            kh_form.showdata(khlist);
        }

        if(e.getSource() == tblkh){
            try {
                selectitem(khlist);
            } catch (IOException ex) {
                Logger.getLogger(Update_Nhanvien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public JTable gettbl(){
        return  this.tblkh;
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
