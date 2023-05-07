/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.NhanVienBUS;
import DTO.AccountDTO;
import DTO.NhanVienDTO;
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
public class Delete_Nhanvien extends JFrame implements KeyListener,MouseListener{
    
    JPanel pnlheading,pnlcontent;
    
    JScrollPane nhvtbl;
    
    JTable tblnhanvien;
    
    DefaultTableModel model;
    
    Label heading;
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    ArrayList< NhanVienDTO> nhanvienlist = new ArrayList<>();
    
    NhanVienBUS nhvbus;
    
    AccountDTO account;
    
    NhanVien nhanvien_form;
    
    
    int index;
    
    public void initcomponent(AccountDTO acc){
        account = acc;
        
        nhvbus = new NhanVienBUS();
       
        
        nhanvienlist = nhvbus.getNhanvienList();
        
        this.setSize(new Dimension(1000,600));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        pnlheading = new JPanel(new FlowLayout(1));
        
        pnlheading.setPreferredSize(new Dimension(0,100));
        pnlheading.setBorder(new EmptyBorder(30,0,0,0));
        pnlheading.setOpaque(true);
        pnlheading.setBackground(main_clr);
        
        heading = new Label("XÓA NHÂN VIÊN",1);
        heading.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,22));
        heading.setForeground(new Color(240,240,240));
        
        pnlheading.add(heading);
        
        pnlcontent = new JPanel(new GridLayout(1,1  ));
        
        tblnhanvien = new JTable();
        tblnhanvien.addKeyListener(this);
        tblnhanvien.addMouseListener(this);
        
        model =new DefaultTableModel();
        
        model.addColumn("Mã Nhân Viên");
        model.addColumn("Tên Nhân Viên");
        model.addColumn("Số Điện Thoại");
        model.addColumn("Địa Chỉ");
        
        for(NhanVienDTO nhv : nhanvienlist){
            model.addRow(new Object[] {nhv.getMaNV(),nhv.getTenNV(),nhv.getSDT(),nhv.getDiaChi()});
        }
      
        tblnhanvien.setModel(model);
        
        nhvtbl = new JScrollPane();
        
        nhvtbl.setViewportView(tblnhanvien);
        
        this.add(nhvtbl,BorderLayout.CENTER);
        this.add(pnlheading,BorderLayout.NORTH);
        
        this.setVisible(true);
    }
     public void delete(NhanVienDTO nhanvien){      
        nhvbus.deletenv(nhanvien);
//        nhanvienlist.clear();
        nhanvienlist.clear();
        nhanvienlist = nhvbus.getNhanvienList();
//        NhanVienDTO a = new NhanVienDTO();
//        a = nhanvienlist.get(2);
//        System.out.println(a.getTenNV());
//          nhanvien_form.setNhanvienlist(nhanvienlist);
        
//        a = nhanvien_form.nvlist.get(1);
//         System.out.println(a.getTenNV());
        
        model.setRowCount(0);
        for(NhanVienDTO nhv : nhanvienlist){
            model.addRow(new Object[] {nhv.getMaNV(),nhv.getTenNV(),nhv.getGioiTinh(),nhv.getDiaChi(),nhv.getSDT(),nhv.getNgaySinh(),nhv.getNgayVao()});
        }
//        nhanvien_form.callshow(nhanvienlist);
        
        
    }

    public Delete_Nhanvien(AccountDTO acc) throws HeadlessException {
        initcomponent(acc);
    }
    
    private void desplaydetails(int selectedRows){
    }
    
    public void selectitem(ArrayList<NhanVienDTO> list){
        if(JOptionPane.showConfirmDialog(pnlcontent, "Bạn muốn xóa nhân viên này ?","Chi tiết nhân viên",JOptionPane.YES_NO_OPTION) ==0){           
            desplaydetails(tblnhanvien.getSelectedColumn());
            this.index =tblnhanvien.getSelectedRow();
                NhanVienDTO a = list.get(index);
                delete(a);
            }
    }
    
    public void setNhanVien_form(NhanVien form){
        this.nhanvien_form = form;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        desplaydetails(tblnhanvien.getSelectedRow());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==tblnhanvien){
            selectitem(nhanvienlist);
            nhanvien_form.setNhanvienlist(nhanvienlist);
            nhanvien_form.showdata(nhanvienlist);
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
