/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.AccountBUS;
import BUS.NhanVienBUS;
import BUS.NhomQuyenBUS;
import DAO.NhanVienDAO;
import DTO.AccountDTO;
import DTO.NhanVienDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import component.ImageScale;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author NAME
 */
public class Account extends JPanel implements MouseListener,KeyListener{
    
    JPanel pnlinfo,pnllist,pnl_left_info,pnl_right_info;
    
    JScrollPane splist;
    
    JLabel lblimg;
    
    Label lblmanv,lbltennv,lblemail,lblnq,lblstatus,lblchangepass;
    
    JTextField txtmanv,txttennv,txtemail,txtnq;

    JRadioButton rbtstatus;
    
    JTable tbllist;
    
    DefaultTableModel model;
    
    AccountDTO account;
    
    NhomQuyenBUS nhomquyenbus = new NhomQuyenBUS();
    
    ArrayList<AccountDTO> acclist = new ArrayList<>();

    Dimension lblinfo_dms = new Dimension(110,30);
    Dimension info_dms = new Dimension(150,30);
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    Font lblinfo_font  = new Font("Times New Roman",Font.LAYOUT_RIGHT_TO_LEFT,16);
    Font info_font  = new Font("Times New Roman",Font.CENTER_BASELINE,14);
    
    AccountBUS accountbus = new AccountBUS();
    
    int index=-1;
    
    public void initcomponent(AccountDTO a,ArrayList<AccountDTO> list) throws IOException{
        this.setOpaque(true);
//        this.setBackground(Color.yellow);
        this.setLayout(new BorderLayout(10,10));
        
        this.acclist = list;
        this.account = a;
        
        pnlinfo = new JPanel();
        pnlinfo.setOpaque(true);
//        pnlinfo.setBackground(Color.red);
        pnlinfo.setLayout(new BorderLayout(10,10));
        pnlinfo.setBorder(new EmptyBorder(10,10,10,10));
        pnlinfo.setPreferredSize(new Dimension(900,720));

        
        pnl_left_info = new JPanel();
        pnl_left_info.setLayout(new FlowLayout(1));
        pnl_left_info.setOpaque(true);
        pnl_left_info.setBackground(new Color(240,240,240));
        pnl_left_info.setBorder(new EmptyBorder(150,0,0,0));
        pnl_left_info.setPreferredSize(new Dimension(250,0));
        
        NhanVienDTO nhanvien = new NhanVienDAO().selectById(this.account.getMaNV());       
        ImageIcon img = ImageScale.scale_employee_img(new ImageIcon( ImageIO.read(new File(nhanvien.getImg()))));
        
        lblimg = new JLabel(img);
        lblimg.setBorder(new LineBorder(new Color(100,100,100), 2, true));
        
        pnl_left_info.add(lblimg);
        
        
        
        pnl_right_info = new JPanel(null);
        
        pnl_right_info.setOpaque(true);
//        pnl_right_info.setBackground(new Color(240,240,240));
        pnl_right_info.setBorder(new EmptyBorder(20,60,20,80));
        
        Font lbl_font = new Font("Times New Roman",Font.CENTER_BASELINE,16);
        
        lblemail = new Label("Email");
        lblemail.setBounds(50,150,120,30);
        lblemail.setAlignment(2);
        lblemail.setFont(lbl_font);
        
        txtemail = new JTextField(account.getEmail());
        txtemail.setBounds(180,150,200,30);
        
        lbltennv = new Label("Tên nhân viên");
        lbltennv.setBounds(50,250,120,30);
        lbltennv.setAlignment(2);
        lbltennv.setFont(lbl_font);
        
        txttennv = new JTextField(nhanvien.getTenNV());
        txttennv.setBounds(180,250, 200,30);
        txttennv.setEditable(false);
        
        lblmanv = new Label("Mã nhân viên");
        lblmanv.setBounds(50,200,120,30);
        lblmanv.setAlignment(2);
        lblmanv.setFont(lbl_font);
        
        txtmanv = new JTextField(nhanvien.getMaNV());
        txtmanv.setEditable(false);
        txtmanv.setBounds(180,200,200,30);

        lblnq = new Label("Nhóm quyền");
        lblnq.setBounds(50,300,120,30);
        lblnq.setAlignment(2);
        lblnq.setFont(lbl_font);
        
        txtnq = new JTextField(nhomquyenbus.selectbyId(account.getMaNhomQuyen(),"").getTenNQ());
        txtnq.setBounds(180,300,200,30);
        
        lblstatus = new Label("Tình trạng");
        lblstatus.setBounds(50,400,120,30);
        lblstatus.setAlignment(2);
        lblstatus.setFont(lbl_font);
        
        rbtstatus = new JRadioButton();
        rbtstatus.setSelected(true);
        rbtstatus.setBounds(180,400,120,30);
        
        lblchangepass = new Label("Đổi mật khẩu");
        lblchangepass.setAlignment(1);
        lblchangepass.setBounds(260,600,120,30);
        lblchangepass.setBackground(main_clr);
        lblchangepass.setForeground(new Color(240,240,240));
        lblchangepass.setFont(lblinfo_font);
        lblchangepass.addMouseListener(this);
        
        pnl_right_info.add(lblemail);
        pnl_right_info.add(txtemail);
        pnl_right_info.add(lbltennv);
        pnl_right_info.add(txttennv);
        pnl_right_info.add(lblmanv);
        pnl_right_info.add(txtmanv);
        pnl_right_info.add(lblnq);
        pnl_right_info.add(txtnq);      
        pnl_right_info.add(lblstatus);
        pnl_right_info.add(rbtstatus);
        pnl_right_info.add(lblchangepass);

        pnlinfo.add(pnl_left_info,BorderLayout.WEST);
        pnlinfo.add(pnl_right_info,BorderLayout.CENTER);
        
        this.add(pnlinfo,BorderLayout.CENTER);
        account_list(this.account);
        
        
    }

    public Account(AccountDTO a,ArrayList<AccountDTO> list) throws IOException {
        initcomponent(a,list);
    }

    public void setAcclist(ArrayList<AccountDTO> acclist) {
        this.acclist = acclist;
    }

    
    
    public JTable getTbllist() {
        return tbllist;
    }

    public DefaultTableModel getModel() {
        return model;
    }
    
    
    
    public void account_list(AccountDTO a){
        if(a.getMaNhomQuyen().equals("2") || a.getMaNhomQuyen().equals("1")){
            pnllist = new JPanel();
            pnllist.setOpaque(true);
//            pnllist.setBackground(Color.blue);
            pnllist.setLayout(new GridLayout(1,1));
            pnllist.setBorder(new EmptyBorder(10,10,10,10));
            pnllist.setPreferredSize(new Dimension(650,0));
            
            splist = new JScrollPane();
            
            
            tbllist = new JTable();
            
            model = new DefaultTableModel();
            
            model.addColumn("Email");
            model.addColumn("Mã người dùng");
            model.addColumn("Mã nhóm quyền");
            model.addColumn("Trạng thái");
            
            for(AccountDTO account : acclist){
            if(!nhomquyenbus.selectbyId(account.getMaNhomQuyen(),"").getTenNQ().equals("admin"))                
               model.addRow(new Object[] {account.getEmail(),account.getMaNV(),nhomquyenbus.selectbyId(account.getMaNhomQuyen(),"").getTenNQ(),account.getStatus()});
            }
            
            tbllist.setModel(model);
            tbllist.addMouseListener(this);
            tbllist.addKeyListener(this);
            
            splist.setViewportView(tbllist);
            
            pnllist.add(splist);
            
            this.add(pnllist,BorderLayout.EAST);
        }
        
    }
    public void showdata(){
        this.acclist.clear();
        model.setRowCount(0);
        this.acclist = accountbus.getListaccount();
        tbllist.removeAll();
        for(AccountDTO acc : acclist){
            if(acc.getMaNhomQuyen().equals("001"))
                continue;
            model.addRow(new Object[] {acc.getEmail(),acc.getMaNV(),nhomquyenbus.selectbyId(acc.getMaNhomQuyen(),"").getTenNQ(),acc.getStatus()});            
        }
        tbllist.setModel(model);
    }
    private void desplaydetails(int selectedRows){
    }
    
    public void selectitem(ArrayList<AccountDTO> list) throws IOException{
        NhanVienBUS nhanvienbus = new NhanVienBUS();
        desplaydetails(tbllist.getSelectedRow());
        this.index = tbllist.getSelectedRow();
        AccountDTO acc = acclist.get(index);
        NhanVienDTO nv = new NhanVienDTO();
        nv = nhanvienbus.selectnhanvien(acc.getMaNV());
        txtemail.setText(acc.getEmail());
        txtmanv.setText(nv.getMaNV());
        txttennv.setText(nv.getTenNV());
        txtnq.setText(nhomquyenbus.selectbyId(acc.getMaNhomQuyen(),"").getTenNQ());
        ImageIcon img = ImageScale.scale_employee_img(new ImageIcon( ImageIO.read(new File(nv.getImg()))));
        
        lblimg.setIcon(img);
        
    }
    
    public void updateAcc(){
        int status = -1;
        if(rbtstatus.isSelected()){
            status = 1;
        }
        else{
            status = 0;
        }
        AccountDTO acc = new AccountDTO(txtemail.getText(), txtmanv.getText(),"", status, nhomquyenbus.selectbyId("", txtnq.getText()).getMaNQ());
        accountbus.updateAccount(acc);
        acclist.clear();
        acclist = accountbus.getListaccount();
        showdata();
    }
    
    public void deleteAcc(){
        AccountDTO acc = new AccountDTO(txtemail.getText(), "", "", 0, "");
        accountbus.delAccount(acc);
        acclist.clear();
        acclist = accountbus.getListaccount();
        showdata();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==tbllist){
            try {
                selectitem(acclist);
            } catch (IOException ex) {
                Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==lblchangepass){
            if(txtemail.getText().equals(account.getEmail())){
                Change_pass change_pass_form = new Change_pass(account);
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
        if(e.getSource()==lblchangepass){
            lblchangepass.setBackground(hover_clr);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==lblchangepass){
            lblchangepass.setBackground(main_clr);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        desplaydetails(tbllist.getSelectedRow());
    }
    
}
