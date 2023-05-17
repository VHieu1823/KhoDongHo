/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.KhachHangBUS;
import DTO.AccountDTO;
import DTO.KhachHangDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class Delete_KhachHang extends JFrame implements KeyListener,MouseListener{
    
    JPanel pnlheading,pnlcontent;
    
    JScrollPane khtbl;
    
    JTable tblkh;
    
    DefaultTableModel model;
    
    Label heading;
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    ArrayList<KhachHangDTO> khlist = new ArrayList<>();
    
    KhachHangBUS khbus;
    
    AccountDTO account;
    
    KhachHang kh_form;
    
    
    int index;
    
    public void initcomponent(){
//        account = acc;
        
        khbus = new KhachHangBUS();
       
        

        khlist = khbus.getKhachHanglist();
        
        this.setSize(new Dimension(1000,600));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        pnlheading = new JPanel(new FlowLayout(1));
        
        pnlheading.setPreferredSize(new Dimension(0,100));
        pnlheading.setBorder(new EmptyBorder(30,0,0,0));
        pnlheading.setOpaque(true);
        pnlheading.setBackground(main_clr);
        
        heading = new Label("XÓA Khách Hàng",1);
        heading.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,22));
        heading.setForeground(new Color(240,240,240));
        
        pnlheading.add(heading);
        
        pnlcontent = new JPanel(new GridLayout(1,1  ));
        
        tblkh = new JTable();
        tblkh.addKeyListener(this);
        tblkh.addMouseListener(this);
        
        model =new DefaultTableModel();
        
        model.addColumn("Mã Khách Hàng");
        model.addColumn("Tên Khách Hàng");
        model.addColumn("Số Điện Thoại");
        
        for(KhachHangDTO kh : khlist){
            model.addRow(new Object[] {kh.getMaKH(),kh.getTenKh(),kh.getSDT()});
        }
      
        tblkh.setModel(model);
        
        khtbl = new JScrollPane();
        
        khtbl.setViewportView(tblkh);
        
        this.add(khtbl,BorderLayout.CENTER);
        this.add(pnlheading,BorderLayout.NORTH);
        
        this.setVisible(true);
     }
     public void delete(KhachHangDTO kh){      
        khbus.delkh(kh);
        khlist.clear();
        khlist = khbus.getListkhachhang();

        model.setRowCount(0);
        for(KhachHangDTO khachhang : khlist){
            model.addRow(new Object[] {khachhang.getMaKH(),khachhang.getTenKh(),khachhang.getSDT()});
        }
    }

    public Delete_KhachHang() throws HeadlessException {
        initcomponent();
    }
    
    private void desplaydetails(int selectedRows){
    }
    
    public void selectitem(ArrayList<KhachHangDTO> list){
        if(JOptionPane.showConfirmDialog(pnlcontent, "Bạn muốn xóa nhà cung cấp này ?","Chi tiết nhà cung cấp",JOptionPane.YES_NO_OPTION) ==0){           
            desplaydetails(tblkh.getSelectedColumn());
            this.index =tblkh.getSelectedRow();
                KhachHangDTO a = list.get(index);
                delete(a);
            }
    }
    
    public void setKhachHang_form(KhachHang form){
        this.kh_form = form;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        desplaydetails(tblkh.getSelectedRow());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==tblkh){
            selectitem(khlist);

            kh_form.setKhachHanglist(khlist);
            kh_form.showdata(khlist);
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
    
}
