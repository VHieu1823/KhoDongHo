/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.NhomQuyenBUS;
import DAO.NhomQuyenDAO;
import DTO.NhomQuyenDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author NAME
 */
public class Permission extends JFrame implements MouseListener{
        
    JPanel pnlheading,pnlcontent;
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    Font prd_info_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
    Label heading,lbladd,lblupdate,lbldel;
    Color clr = new Color(230,230,230);
    String[] pnlname = {"QL Sản phẩm","QL Phiếu nhập","QL Phiếu xuất","QL Nhà cung cấp","QL Khách hàng","QL Nhân viên","QL Tài khoản","QL Phân quyền"};
    Color color = new Color(250,250,250);
    JPanel[] pnlper = new JPanel[8];
    Label[] lb = new Label[8];
    JTextField txtper_name = new JTextField();
    JRadioButton[] rbtper = new JRadioButton[24];
    NhomQuyenBUS nhomquyenbus = new NhomQuyenBUS();
    int[] quyen = new int[8];
    PhanQuyen phanquyen_form;
    
    public void initcomponent(String name){
        this.setSize(new Dimension(1200,570));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlheading = new JPanel(new GridLayout(1,1));
        pnlheading.setPreferredSize(new Dimension(0,80));
        pnlheading.setOpaque(true);
        pnlheading.setBackground(main_clr);
        
        heading = new Label(name);
        heading.setAlignment(1);
        heading.setForeground(new Color(240,240,240));
        heading.setFont(prd_info_font);
        
        pnlheading.add(heading);
        
        pnlcontent = new JPanel(new GridLayout(1,1));
        if(name.equals("Thêm nhóm quyền"))
            pnlcontent = addPer();
        if(name.equals("Sửa nhóm quyền"))
            pnlcontent = updatePer();
        if(name.equals("Xóa nhóm quyền"))
            pnlcontent = deletePer();
        
        this.add(pnlheading,BorderLayout.NORTH);
        this.add(pnlcontent,BorderLayout.CENTER);
        
        this.setVisible(true);
        
    }
    
    public JPanel addPer(){
        JPanel pnladdper = new JPanel(null);
        
        JPanel pnlper_inf = new JPanel(null);      
        
        pnlper_inf.setBounds(0, 0, 1200, 50);
        pnlper_inf.setBorder(new LineBorder(new Color(90,90,90),1,true));
        
        Label lblper_name = new Label("Tên nhóm quyền",2);
        lblper_name.setBounds(100,10,150,30);
        lblper_name.setFont(new Font("TImes New Roman",Font.CENTER_BASELINE,16));
        
        txtper_name = new JTextField();
        txtper_name.setBounds(260,10,200,30);
        
        this.lbladd = new Label("Thêm",1);
        lbladd.setBounds(1000,10,100,30);
        lbladd.setBackground(main_clr);
        lbladd.setForeground(new Color(240,240,240));
        lbladd.setFont(new Font("TImes New Roman",Font.CENTER_BASELINE,16));
        lbladd.addMouseListener(this);
        
        pnlper_inf.add(lblper_name);
        pnlper_inf.add(txtper_name);
        pnlper_inf.add(lbladd);
        
        pnladdper.add(pnlper_inf);
        
        for(int i=0;i<8;i++){
            pnlper[i] = new JPanel(null);
            pnlper[i].setBounds(0,50*i+50,1200,50);
            if(i%2==1){
                pnlper[i].setOpaque(true);
                color = clr;
                pnlper[i].setBackground(color);
            }
            else{
                color = new Color(240,240,240);
            }
            
            Font font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
            
            lb[i] = new Label(pnlname[i],2);
            lb[i].setFont(font);
            lb[i].setBackground(color);
            lb[i].setBounds(150,10,170,30);
            
            rbtper[(i*3)] = new JRadioButton("Thêm");
            rbtper[(i*3)].setFont(font);
            rbtper[(i*3)].setOpaque(true);
            rbtper[(i*3)].setBackground(color);
            rbtper[(i*3)].setBounds(500,10,100,30);
            
            rbtper[(i*3)+1] = new JRadioButton("Xóa");
            rbtper[(i*3)+1].setFont(font);
            rbtper[(i*3)+1].setOpaque(true);
            rbtper[(i*3)+1].setBackground(color);
            rbtper[(i*3)+1].setBounds(700,10,100,30);
            
            rbtper[(i*3)+2] = new JRadioButton("Sửa");
            rbtper[(i*3)+2].setFont(font);
            rbtper[(i*3)+2].setOpaque(true);
            rbtper[(i*3)+2].setBackground(color);
            rbtper[(i*3)+2].setBounds(900,10,100,30);
            
            pnlper[i].add(lb[i]);
            pnlper[i].add(rbtper[(i*3)]);
            pnlper[i].add(rbtper[(i*3)+1]);
            pnlper[i].add(rbtper[(i*3)+2]);
            
            pnladdper.add(pnlper[i]);
        }
        
        
        return pnladdper;
    }
    public JPanel updatePer(){
        JPanel pnlupdateper = new JPanel(null);
        
        JPanel pnlper_inf = new JPanel(null);
                
        
        
        
        pnlper_inf.setBounds(0, 0, 1200, 50);
        pnlper_inf.setBorder(new LineBorder(new Color(90,90,90),1,true));
        
        Label lblper_name = new Label("Tên nhóm quyền",2);
        lblper_name.setBounds(100,10,150,30);
        lblper_name.setFont(new Font("TImes New Roman",Font.CENTER_BASELINE,16));
        
        JTextField txtper_name = new JTextField();
        txtper_name.setBounds(260,10,200,30);
        
        this.lblupdate = new Label("Lưu",1);
        lblupdate.setBounds(1000,10,100,30);
        lblupdate.setBackground(main_clr);
        lblupdate.setForeground(new Color(240,240,240));
        lblupdate.setFont(new Font("TImes New Roman",Font.CENTER_BASELINE,16));
        
        pnlper_inf.add(lblper_name);
        pnlper_inf.add(txtper_name);
        pnlper_inf.add(lblupdate);
        
        pnlupdateper.add(pnlper_inf);
        
        for(int i=0;i<8;i++){
            pnlper[i] = new JPanel(null);
            pnlper[i].setBounds(0,50*i+50,1200,50);
            if(i%2==1){
                pnlper[i].setOpaque(true);
                color = clr;
                pnlper[i].setBackground(color);
            }
            else{
                color = new Color(240,240,240);
            }
            
            Font font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
            
            lb[i] = new Label(pnlname[i],2);
            lb[i].setFont(font);
            lb[i].setBackground(color);
            lb[i].setBounds(150,10,170,30);
            
            rbtper[(i*3)] = new JRadioButton("Thêm");
            rbtper[(i*3)].setFont(font);
            rbtper[(i*3)].setOpaque(true);
            rbtper[(i*3)].setBackground(color);
            rbtper[(i*3)].setBounds(500,10,100,30);
            
            rbtper[(i*3)+1] = new JRadioButton("Xóa");
            rbtper[(i*3)+1].setFont(font);
            rbtper[(i*3)+1].setOpaque(true);
            rbtper[(i*3)+1].setBackground(color);
            rbtper[(i*3)+1].setBounds(700,10,100,30);
            
            rbtper[(i*3)+2] = new JRadioButton("Sửa");
            rbtper[(i*3)+2].setFont(font);
            rbtper[(i*3)+2].setOpaque(true);
            rbtper[(i*3)+2].setBackground(color);
            rbtper[(i*3)+2].setBounds(900,10,100,30);
            
            pnlper[i].add(lb[i]);
            pnlper[i].add(rbtper[(i*3)]);
            pnlper[i].add(rbtper[(i*3)+1]);
            pnlper[i].add(rbtper[(i*3)+2]);
            
            pnlupdateper.add(pnlper[i]);
        }
        
        
        return pnlupdateper;
    }
    
    public JPanel deletePer(){
        JPanel pnldelper = new JPanel(null);
        
        
                    
        
        return pnldelper;
    }

    
    

    public Permission(String name) throws HeadlessException {
        initcomponent(name);
    }
    
    public static void main(String[] args) {
        new Permission("Thêm nhóm quyền");
    }

    public int[] getnewnqinfo(){
        int[] per = new int[8];
        int check = 0;
        for(int i=0;i<8;i++){
            if(rbtper[(i*3)].getSelectedObjects()!=null)
                check +=1;
            if(rbtper[(i*3)+1].getSelectedObjects()!=null)
                check+=2;
            if(rbtper[(i*3)+2].getSelectedObjects()!=null)
                check+=4;
            per[i] = check;
            check =0;
        }
        return per;
    }

    public void setPhanquyen_form(PhanQuyen phanquyen_form) {
        this.phanquyen_form = phanquyen_form;
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==lbladd){  
            quyen = getnewnqinfo();
            NhomQuyenDTO nq = new NhomQuyenDTO(Integer.toString(nhomquyenbus.getNhomQuyenList().size()+1),txtper_name.getText());
            if(nhomquyenbus.addNhomQuyen(nq, quyen)==1){
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                phanquyen_form.showdata(nhomquyenbus.getNhomQuyenList());
                this.dispose();
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
    
}
