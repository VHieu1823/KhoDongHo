/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.NhaCungCapBUS;
import DTO.AccountDTO;
import DTO.NhaCungCapDTO;
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
public class Delete_NhaCungCap extends JFrame implements KeyListener,MouseListener{
    
    JPanel pnlheading,pnlcontent;
    
    JScrollPane nhvtbl;
    
    JTable tblncc;
    
    DefaultTableModel model;
    
    Label heading;
    
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    
    ArrayList< NhaCungCapDTO> ncclist = new ArrayList<>();
    
    NhaCungCapBUS nccbus;
    
    AccountDTO account;
    
    NhaCungCap ncc_form;
    
    
    int index;
    
    public void initcomponent(){
//        account = acc;
        
        nccbus = new NhaCungCapBUS();
       
        
        ncclist = nccbus.getlistnhcc();
        ncclist = nccbus.getarrncc();
        
        this.setSize(new Dimension(1000,600));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        pnlheading = new JPanel(new FlowLayout(1));
        
        pnlheading.setPreferredSize(new Dimension(0,100));
        pnlheading.setBorder(new EmptyBorder(30,0,0,0));
        pnlheading.setOpaque(true);
        pnlheading.setBackground(main_clr);
        
        heading = new Label("XÓA NHÀ CUNG CẤP",1);
        heading.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,22));
        heading.setForeground(new Color(240,240,240));
        
        pnlheading.add(heading);
        
        pnlcontent = new JPanel(new GridLayout(1,1  ));
        
        tblncc = new JTable();
        tblncc.addKeyListener(this);
        tblncc.addMouseListener(this);
        
        model =new DefaultTableModel();
        
        model.addColumn("Mã Nhà Cung Cấp");
        model.addColumn("Tên Nhà Cung Cấp");
        model.addColumn("Địa Chỉ");
        
        for(NhaCungCapDTO ncc : ncclist){
            model.addRow(new Object[] {ncc.getMaNCC(),ncc.getTenNCC(),ncc.getDiaChi()});
        }
      
        tblncc.setModel(model);
        
        nhvtbl = new JScrollPane();
        
        nhvtbl.setViewportView(tblncc);
        
        this.add(nhvtbl,BorderLayout.CENTER);
        this.add(pnlheading,BorderLayout.NORTH);
        
        this.setVisible(true);
    }
     public void delete(NhaCungCapDTO nhcc){      
        nccbus.delncc(nhcc);
        ncclist.clear();
        ncclist = nccbus.getlistnhcc();

        model.setRowCount(0);
        for(NhaCungCapDTO ncc : ncclist){
            model.addRow(new Object[] {ncc.getMaNCC(),ncc.getTenNCC(),ncc.getDiaChi()});
        }
    }

    public Delete_NhaCungCap() throws HeadlessException {
        initcomponent();
    }
    
    private void desplaydetails(int selectedRows){
    }
    
    public void selectitem(ArrayList<NhaCungCapDTO> list){
        if(JOptionPane.showConfirmDialog(pnlcontent, "Bạn muốn xóa nhà cung cấp này ?","Chi tiết nhà cung cấp",JOptionPane.YES_NO_OPTION) ==0){           
            desplaydetails(tblncc.getSelectedColumn());
            this.index =tblncc.getSelectedRow();
                NhaCungCapDTO a = list.get(index);
                delete(a);
            }
    }
    
    public void setNhaCungCap_form(NhaCungCap form){
        this.ncc_form = form;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        desplaydetails(tblncc.getSelectedRow());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==tblncc){
            selectitem(ncclist);

            ncc_form.setNhaCungCapList(ncclist);
            ncc_form.showdata(ncclist);
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
