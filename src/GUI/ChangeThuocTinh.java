/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.ChatlieuBUS;
import BUS.ChongNuocBUS;
import BUS.DoDayBUS;
import BUS.KichThuocBUS;
import DTO.ChatLieuDTO;
import DTO.ChongNuocDTO;
import DTO.DoDayDTO;
import DTO.KichThuocDTO;
import DAO.ChatlieuDAO;
import DAO.ChongNuocDAO;
import DAO.DoDayDAO;
import DAO.KichThuocDAO;
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



public class ChangeThuocTinh extends JFrame implements MouseListener{
    JPanel pnlmain,pnlfill_info,pnlheading,pnl_left,pnl_right,pnl_rightadd,pnl_rightdel;
    
    Label heading,lblheadadd,lblheaddel,lbladd,lbldel,lbldelshow1,lbldelshow2;
    
    
    JTable tblthuoctinh;
    
    JLabel[] lblthuoctinh_info = new JLabel[2];
    
    JScrollPane thttbl;
    
    JTextField[] txttt_info = new JTextField[2];
    
    DefaultTableModel model;
        
    String pathString;
    
    Font prd_info_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
    Font prd_info_font1 = new Font("Times New Roman",Font.CENTER_BASELINE,15);
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    ChatlieuBUS clbus = new ChatlieuBUS();
    
    ArrayList<ChatLieuDTO> cllist = new ArrayList<>();
    
    ChatlieuDAO cldao = new ChatlieuDAO();
    
    DoDayBUS ddbus = new DoDayBUS();
    
    ArrayList<DoDayDTO> ddlist = new ArrayList<>();
    
    DoDayDAO dddao =new DoDayDAO();
    
    KichThuocBUS ktbus = new KichThuocBUS();
    
    ArrayList<KichThuocDTO> ktlist = new ArrayList<>();
    
    KichThuocDAO ktdao = new KichThuocDAO();
    
    ChongNuocBUS cnbus = new ChongNuocBUS();
    
    ArrayList<ChongNuocDTO> cnlist = new ArrayList<>();
    
    ChongNuocDAO cndao = new ChongNuocDAO();
    

    int index = 0;
    

    
    public void initcomponent(String t) throws IOException{
//        
        this.pathString = t;
        
        cllist = cldao.selectAll();
        
        ddlist = dddao.selectAll();
        
        ktlist = ktdao.selectAll();
        
        cnlist = cndao.selectAll();
        
        this.setSize(new Dimension(950,650));
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
        
        heading = new Label("Thuộc Tính " + pathString,1);
        heading.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,25));
        heading.setForeground(new Color(200,240,240));
        
        pnlheading.add(heading);
        
        pnl_left = new JPanel(new GridLayout(1, 1));
        pnl_left.setOpaque(true);
        pnl_left.setPreferredSize(new Dimension(400,0));
        pnl_left.setBorder(new EmptyBorder(0,30,30,30));
        
        
        tblthuoctinh = new JTable();
        tblthuoctinh.addMouseListener(this);
        
        model =new DefaultTableModel();
        
        
        switch (pathString) {
            case "Chất liệu":
                model.addColumn("Chất liệu");
                model.addColumn("Loại");
                break;
                
            case "Kích thước":
                model.addColumn("Kích Thước");              
                break;
                
            case "Độ dày":
                model.addColumn("Độ dày");
                break;
                
            case "Chống nước":
                model.addColumn("Chống nước");
                break;
            default:
                throw new AssertionError();
        }
        
        
        showdata(pathString);
   
        tblthuoctinh.setModel(model);
        
        thttbl = new JScrollPane();
        
        thttbl.setViewportView(tblthuoctinh);
        
        pnl_left.add(thttbl,BorderLayout.CENTER);
        
        
        pnl_right = new JPanel();
        pnl_right.setOpaque(true);
        pnl_right.setBackground(new Color(240,240,240));
        pnl_right.setBorder(new EmptyBorder(0,0,0,0));
        pnl_right.setPreferredSize(new Dimension(600,0));



         pnl_rightdel = new JPanel(null);
        pnl_rightdel.setOpaque(true);
        pnl_rightdel.setBackground(new Color(240,240,240));
        pnl_rightdel.setBorder(new LineBorder(Color.black,1,true));
        pnl_rightdel.setPreferredSize(new Dimension(330,200));
        
       
        lblheaddel = new Label("Xóa thuộc tính "+ pathString,1);
        lblheaddel.setFont(prd_info_font);
        lblheaddel.setBackground(new Color(240,240,240));
        lblheaddel.setForeground(Color.black);
        lblheaddel.setBounds(30,20,270,35);
        lblheaddel.setAlignment(1);
        pnl_rightdel.add(lblheaddel);
        
        lbldel = new Label("XÓA",1);
        lbldel.setFont(prd_info_font);
        lbldel.setBackground(main_clr);
        lbldel.setForeground(new Color(240,240,240));
        lbldel.setBounds(110, 150, 70, 30);
        lbldel.setAlignment(1);
        lbldel.addMouseListener(this);
        pnl_rightdel.add(lbldel,BorderLayout.SOUTH);
        
        pnl_rightadd = new JPanel(null);
        pnl_rightadd.setOpaque(true);
        pnl_rightadd.setBackground(new Color(240,240,240));
        pnl_rightadd.setBorder(new LineBorder(Color.black,1,true));
        pnl_rightadd.setPreferredSize(new Dimension(330,200));
        
        lblheadadd = new Label("Thêm thuộc tính "+pathString,1);
        lblheadadd.setFont(prd_info_font);
        lblheadadd.setBackground(new Color(240,240,240));
        lblheadadd.setForeground(Color.black);
        lblheadadd.setBounds(30,20,270,35);
        lblheadadd.setAlignment(1);
        pnl_rightadd.add(lblheadadd);
        
        
         switch (pathString) {
            case "Chất liệu":
                lbldelshow1 =new Label();
               lbldelshow1.setFont(prd_info_font);
               lbldelshow1.setBounds(40, 80, 170, 40);
               pnl_rightdel.add(lbldelshow1);
               
               lbldelshow2 =new Label();
               lbldelshow2.setFont(prd_info_font);
               lbldelshow2.setBounds(210, 80, 50, 40);
               pnl_rightdel.add(lbldelshow2);
               
               lblthuoctinh_info[0] = new JLabel("Chất liệu");
               lblthuoctinh_info[0].setBounds(45,60, 170, 30);
               lblthuoctinh_info[0].setFont(prd_info_font1);
               pnl_rightadd.add(lblthuoctinh_info[0]);
               
               lblthuoctinh_info[1] = new JLabel("Loại");
               lblthuoctinh_info[1].setBounds(215,60, 170, 30);
               lblthuoctinh_info[1].setFont(prd_info_font1);
               pnl_rightadd.add(lblthuoctinh_info[1]);
               
               
               txttt_info[0] = new JTextField();
               txttt_info[0].setBounds(40, 80, 170, 40);
               pnl_rightadd.add(txttt_info[0]);
               
               txttt_info[1] = new JTextField();
               txttt_info[1].setBounds(210, 80, 50, 40);
               pnl_rightadd.add(txttt_info[1]);
                break;
            default:
                 lbldelshow1 =new Label();
               lbldelshow1.setFont(prd_info_font);
               lbldelshow1.setBounds(60, 80, 170, 40);
               pnl_rightdel.add(lbldelshow1);
               
               txttt_info[0] = new JTextField();
               txttt_info[0].setBounds(60, 80, 170, 40);
               pnl_rightadd.add(txttt_info[0]);
               
        }
        
        
        
        lbladd = new Label("THÊM",1);
        lbladd.setFont(prd_info_font);
        lbladd.setBackground(main_clr);
        lbladd.setForeground(new Color(240,240,240));
        lbladd.setBounds(110, 150, 70, 30);
        lbladd.setAlignment(1);
        lbladd.addMouseListener(this);
        pnl_rightadd.add(lbladd,BorderLayout.SOUTH);

        pnl_right.add(pnl_rightdel,BorderLayout.NORTH);
        pnl_right.add(pnl_rightadd,BorderLayout.SOUTH);

        this.add(pnlheading,BorderLayout.NORTH);
        this.add(pnlmain,BorderLayout.CENTER);
        pnlmain.add(pnl_right,BorderLayout.EAST);
        pnlmain.add(pnl_left,BorderLayout.WEST);
        
        this.setVisible(true);

        
   }

    public ChangeThuocTinh(String t) throws HeadlessException, IOException {
      
        initcomponent(t);
    }
    
    public void add(){
          if(JOptionPane.showConfirmDialog(this, "Bạn muốn thêm thuộc tính này ?",null,JOptionPane.YES_NO_OPTION) ==0){

              switch (pathString) {
                  case "Chất liệu":
                      ChatLieuDTO cl = new ChatLieuDTO(txttt_info[0].getText(),txttt_info[1].getText());
                      clbus.add(cl);
                      cllist.clear();
                      cllist = clbus.getChatlieulist();
                      break;
                  case "Độ dày":
                      DoDayDTO dd = new DoDayDTO(txttt_info[0].getText());
                      ddbus.add(dd);
                      ddlist.clear();
                      ddlist = ddbus.getDodaylist();
                      break;
                  case "Kích thước":
                      KichThuocDTO kt = new KichThuocDTO(txttt_info[0].getText());
                      ktbus.add(kt);
                      ktlist.clear();
                      ktlist = ktbus.getKTlist();
                      break;
                  case "Chống nước":
                      ChongNuocDTO cn = new ChongNuocDTO(txttt_info[0].getText());
                      cnbus.add(cn);
                      cnlist.clear();
                      cnlist = cnbus.getCNlist();
                      break;
                  default:
                      throw new AssertionError();
              }
        }
    }

    public void del()
            {
             if(JOptionPane.showConfirmDialog(this, "Bạn muốn xóa thuộc tính này ?",null,JOptionPane.YES_NO_OPTION) ==0){
              switch (pathString) {
                  case "Chất liệu":
                      ChatLieuDTO cl = new ChatLieuDTO(txttt_info[0].getText(),txttt_info[1].getText());
                      clbus.del(cl);
                      cllist.clear();
                      cllist = clbus.getChatlieulist();
                      break;
                  case "Độ dày":
                      DoDayDTO dd = new DoDayDTO(txttt_info[0].getText());
                      ddbus.del(dd);
                      ddlist.clear();
                      ddlist = ddbus.getDodaylist();
                      break;
                   case "Kích thước":
                      KichThuocDTO kt = new KichThuocDTO(txttt_info[0].getText());
                      ktbus.del(kt);
                      ktlist.clear();
                      ktlist = ktbus.getKTlist();
                      break;
                  default:
                      throw new AssertionError();
              }
        }
            }
    public void showdata(String path){
        switch (path) {
            case "Chất liệu":
                for(ChatLieuDTO cl : cllist){
                  model.addRow(new Object[] {cl.getChatlieu(),cl.getLoai()});
                 }
                break;
             case "Độ dày":
                for(DoDayDTO dd : ddlist){
                  model.addRow(new Object[] {dd.getDoday()});
                 }
                break;
             case "Kích thước":
                for(KichThuocDTO kt : ktlist){
                  model.addRow(new Object[] {kt.getKichthuoc()});
                 }
              case "Chống nước":
                for(ChongNuocDTO cn : cnlist){
                  model.addRow(new Object[] {cn.getChongnuoc()});
                 }
                break;
            default:
                throw new AssertionError();
        }
        
    }
    private void desplaydetails(int selectedRows){
    }
    public void selectitem(String path) throws IOException{
                desplaydetails(tblthuoctinh.getSelectedRow());
                this.index = tblthuoctinh.getSelectedRow();
            switch (path) {
                
            case "Chất liệu":
                ChatLieuDTO a = cllist.get(index);
                lbldelshow1.setText(a.getChatlieu());
                lbldelshow2.setText(a.getLoai());
                lbldelshow2.setBackground(Color.GREEN);
                break;
            case "Độ dày":
                DoDayDTO b = ddlist.get(index);
                lbldelshow1.setText(b.getDoday());
                break;
            case "Kích thước":
                KichThuocDTO c = ktlist.get(index);
                lbldelshow1.setText(c.getKichthuoc());
                break;
            case "Chống nước":
                ChongNuocDTO d = cnlist.get(index);
                lbldelshow1.setText(d.getChongnuoc());
                break;
            default:
                throw new AssertionError();   
        }
            lbldelshow1.setBackground(Color.GREEN);


    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==lbladd){
            add();
            showdata(pathString);
        }
        if(e.getSource()== lbldel)
            {
                del();
                showdata(pathString);
            }

        if(e.getSource() == tblthuoctinh){
            try {
                selectitem(pathString);
            } catch (IOException ex) {
                Logger.getLogger(Update_Nhanvien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public JTable gettbl(){
        return  this.tblthuoctinh;
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

       
    }

    @Override
    public void mouseExited(MouseEvent e) {
       }
      
}
