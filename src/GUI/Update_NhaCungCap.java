/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.NhaCungCapBUS;
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



public class Update_NhaCungCap extends JFrame implements MouseListener{
    JPanel pnlmain,pnlfill_info,pnlheading,pnl_left,pnl_right;
    
    Label heading,lblupdate,lblmancc;
    
    JLabel lblimg,pnlimg;
    
    JTable tblncc;
    
    JLabel[] lblncc_info = new JLabel[5];
    
    JScrollPane ncctbl;
    
    JTextField[] txtnv_info = new JTextField[5];
    
    DefaultTableModel model;
    
    JButton btnimg = new JButton();
    
    JDateChooser calendar;
    
    JDateChooser calendar1;
    
    String[] ncc_info_name = {"Mã nhà cung cấp","Tên nhà cung cấp","Địa Chỉ","Email","Hotline"};
    
    String pathString;
    
    Font prd_info_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    NhaCungCapBUS nccbus = new NhaCungCapBUS();
    
    ArrayList< NhaCungCapDTO> ncclist = new ArrayList<>();
    
    NhaCungCapDAO nccdao = new NhaCungCapDAO();
    
    NhaCungCapDTO nccdto;
    
    AccountDTO account;
    
    NhaCungCap ncc_form;
    int index = 0;
    

    
    public void initcomponent() throws IOException{
//        
        
        
        ncclist = nccdao.selectAll();
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
        
        heading = new Label("SỬA THÔNG TIN NHÀ CUNG CẤP",1);
        heading.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,25));
        heading.setForeground(new Color(200,240,240));
        
        pnlheading.add(heading);
        
        pnl_left = new JPanel(new GridLayout(1, 1));
        pnl_left.setOpaque(true);
        pnl_left.setPreferredSize(new Dimension(400,0));
        pnl_left.setBorder(new EmptyBorder(0,30,30,30));
        
        
        tblncc = new JTable();
        tblncc.addMouseListener(this);
        
        model =new DefaultTableModel();
        
        model.addColumn("Mã Nhà Cung Cấp");
        model.addColumn("Tên Nhà Cung Cấp");
        
        for(NhaCungCapDTO ncc : ncclist){
            model.addRow(new Object[] {ncc.getMaNCC(),ncc.getTenNCC()});
        }
      
        tblncc.setModel(model);
        
        ncctbl = new JScrollPane();
        
        ncctbl.setViewportView(tblncc);
        
        pnl_left.add(ncctbl,BorderLayout.CENTER);
        
        
        pnl_right = new JPanel(null);
        pnl_right.setOpaque(true);
        pnl_right.setBackground(new Color(240,240,240));
        pnl_right.setBorder(new EmptyBorder(0,0,0,0));
        pnl_right.setPreferredSize(new Dimension(600,600));
//        pnl_right.setBorder(new LineBorder (new Color(100,100,100),2,true));

        int k = 100;
        int h = 30;
        for(int i = 0;i<5;i++){
            
            lblncc_info[i] = new JLabel(ncc_info_name[i]);
            
            lblncc_info[i].setBounds(k, h, 150, 30);
            lblncc_info[i].setFont(prd_info_font);
            pnl_right.add(lblncc_info[i]);
            

            
            if(  i !=0){
               txtnv_info[i] = new JTextField();
               txtnv_info[i].setBounds(k + 160,h,160,30);
               pnl_right.add(txtnv_info[i]);            
            }
            
            h+= 80;

        }
        lblmancc= new Label();
        lblmancc.setFont(prd_info_font);
        lblmancc.setBackground(new Color(135,206,235));
        lblmancc.setForeground(new Color(0,0,0));
        lblmancc.setBounds(260,30,160,30);
        pnl_right.add(lblmancc);
        
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

    public Update_NhaCungCap() throws HeadlessException, IOException {
      
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
          if(JOptionPane.showConfirmDialog(this, "Bạn muốn sửa thông tin nhà cung cấp này ?","Chi tiết nhà cung cấp",JOptionPane.YES_NO_OPTION) ==0){
                if(checkphone(txtnv_info[4].getText())== 1){
                NhaCungCapDTO new_nv = new NhaCungCapDTO(nccdto.getMaNCC(), txtnv_info[1].getText(), txtnv_info[2].getText(),txtnv_info[3].getText(),txtnv_info[4].getText());
                nccbus.updatencc(new_nv);
                System.out.println(nccdto.getMaNCC());
                ncclist.clear();
                ncclist = nccbus.getarrncc();
                this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Số điện thoại không đúng định dạng!!");
                }
        }
    }
    public void setNhaCungCapForm(NhaCungCap form)
            {
                this.ncc_form = form;
            }

    
    private void desplaydetails(int selectedRows){
    }
    public void selectitem(ArrayList<NhaCungCapDTO> list) throws IOException{
                desplaydetails(tblncc.getSelectedRow());
                this.index = tblncc.getSelectedRow();
                NhaCungCapDTO a = list.get(index);
                nccdto = a;

        lblmancc.setText(a.getMaNCC());
//        txtnv_info[0].setText(a.getMaNV());
        txtnv_info[1].setText(a.getTenNCC());
        txtnv_info[2].setText(a.getDiaChi());
        txtnv_info[3].setText(a.getEmail());
        txtnv_info[4].setText(a.getHotLine());

    }
    public void setNhaCCList(ArrayList<NhaCungCapDTO> list){
        ncclist = list;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==lblupdate){
            update();
            ncc_form.setNhaCungCapList(ncclist);
            ncc_form.showdata(ncclist);
        }

        if(e.getSource() == tblncc){
            try {
                selectitem(ncclist);
            } catch (IOException ex) {
                Logger.getLogger(Update_Nhanvien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public JTable gettbl(){
        return  this.tblncc;
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
