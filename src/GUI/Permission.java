/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.ChiTietQuyenBUS;
import BUS.NhomQuyenBUS;
import DTO.NhomQuyenDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class Permission extends JFrame implements MouseListener,ItemListener{
    NhomQuyenDTO nhomquyen;
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
    JRadioButton[] rbtper = new JRadioButton[32];
    NhomQuyenBUS nhomquyenbus = new NhomQuyenBUS();
    int[] quyen = new int[8];
    PhanQuyen phanquyen_form;
    JTable tblnhomquyen;
    JTextField name;
    DefaultTableModel model;
    ArrayList<NhomQuyenDTO> nhomquyenlist = new ArrayList<>();
    int index = 0;
    JComboBox<String> cbper = new JComboBox<>();
    String[] pername = new String[20];
    ChiTietQuyenBUS chitietquyenbus = new ChiTietQuyenBUS();
    public void initcomponent(String name,NhomQuyenDTO a){
        nhomquyen = a;
        int i =0;
        nhomquyenlist = nhomquyenbus.getNhomQuyenList();
        for(NhomQuyenDTO nq : nhomquyenbus.getNhomQuyenList()){
            pername[i] = nq.getTenNQ();
            i++;
        }
        this.setSize(new Dimension(1200,570));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        
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
        if(name.equals("Chi tiết quyền"))
            pnlcontent = selectitem(nhomquyen);
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
            lb[i].setBounds(100,10,170,30);
            
            rbtper[(i*4)] = new JRadioButton("Xem");
            rbtper[(i*4)].setFont(font);
            rbtper[(i*4)].setOpaque(true);
            rbtper[(i*4)].setBackground(color);
            rbtper[(i*4)].setBounds(400,10,100,30);
            
            rbtper[(i*4)+1] = new JRadioButton("Thêm");
            rbtper[(i*4)+1].setFont(font);
            rbtper[(i*4)+1].setOpaque(true);
            rbtper[(i*4)+1].setBackground(color);
            rbtper[(i*4)+1].setBounds(600,10,100,30);
            
            rbtper[(i*4)+2] = new JRadioButton("Xóa");
            rbtper[(i*4)+2].setFont(font);
            rbtper[(i*4)+2].setOpaque(true);
            rbtper[(i*4)+2].setBackground(color);
            rbtper[(i*4)+2].setBounds(800,10,100,30);
            
            rbtper[(i*4)+3] = new JRadioButton("Sửa");
            rbtper[(i*4)+3].setFont(font);
            rbtper[(i*4)+3].setOpaque(true);
            rbtper[(i*4)+3].setBackground(color);
            rbtper[(i*4)+3].setBounds(1000,10,100,30);
            
            pnlper[i].add(lb[i]);
            pnlper[i].add(rbtper[(i*4)]);
            pnlper[i].add(rbtper[(i*4)+1]);
            pnlper[i].add(rbtper[(i*4)+2]);
            pnlper[i].add(rbtper[(i*4)+3]);
            
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
        
        cbper = new JComboBox<>(pername);
        cbper.setBounds(260,10,200,30);
        cbper.addItemListener(this);
        
        name = new JTextField();
        name.setBounds(500,10,200,30);
        
        this.lblupdate = new Label("Lưu",1);
        lblupdate.setBounds(1000,10,100,30);
        lblupdate.setBackground(main_clr);
        lblupdate.setForeground(new Color(240,240,240));
        lblupdate.setFont(new Font("TImes New Roman",Font.CENTER_BASELINE,16));
        lblupdate.addMouseListener(this);
        
        pnlper_inf.add(lblper_name);
        pnlper_inf.add(cbper);
        pnlper_inf.add(name);
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
            lb[i].setBounds(100,10,170,30);
            
            rbtper[(i*4)] = new JRadioButton("Xem");
            rbtper[(i*4)].setFont(font);
            rbtper[(i*4)].setOpaque(true);
            rbtper[(i*4)].setBackground(color);
            rbtper[(i*4)].setBounds(400,10,100,30);
            
            rbtper[(i*4)+1] = new JRadioButton("Thêm");
            rbtper[(i*4)+1].setFont(font);
            rbtper[(i*4)+1].setOpaque(true);
            rbtper[(i*4)+1].setBackground(color);
            rbtper[(i*4)+1].setBounds(600,10,100,30);
            
            rbtper[(i*4)+2] = new JRadioButton("Xóa");
            rbtper[(i*4)+2].setFont(font);
            rbtper[(i*4)+2].setOpaque(true);
            rbtper[(i*4)+2].setBackground(color);
            rbtper[(i*4)+2].setBounds(800,10,100,30);
            
            rbtper[(i*4)+3] = new JRadioButton("Sửa");
            rbtper[(i*4)+3].setFont(font);
            rbtper[(i*4)+3].setOpaque(true);
            rbtper[(i*4)+3].setBackground(color);
            rbtper[(i*4)+3].setBounds(1000,10,100,30);
            
            pnlper[i].add(lb[i]);
            pnlper[i].add(rbtper[(i*4)]);
            pnlper[i].add(rbtper[(i*4)+1]);
            pnlper[i].add(rbtper[(i*4)+2]);
            pnlper[i].add(rbtper[(i*4)+3]);
            
            pnlupdateper.add(pnlper[i]);
        }
        
        getnqinfo();
        
        return pnlupdateper;
    }
    
    public JPanel deletePer(){
        JPanel pnldelper = new JPanel(new GridLayout(1,1));
        
        JScrollPane sptbl = new JScrollPane();
        
        tblnhomquyen = new JTable();
        tblnhomquyen.addMouseListener(this);
        
        model = new DefaultTableModel();
        
        model.addColumn("Mã nhóm quyền");
        model.addColumn("Tên nhóm quyền");
                    
        for(NhomQuyenDTO nq : nhomquyenbus.getNhomQuyenList()){
            model.addRow(new Object[] {nq.getMaNQ(),nq.getTenNQ()});
        }
        
        tblnhomquyen.setModel(model);
        
        sptbl.setViewportView(tblnhomquyen);
        
        pnldelper.add(sptbl);
        
        return pnldelper;
    }
    
    public JPanel selectitem(NhomQuyenDTO nhomquyen){
        JPanel pnl = new JPanel(null);
        JPanel pnlper_inf = new JPanel(null);
                

        pnlper_inf.setBounds(0, 0, 1200, 50);
        pnlper_inf.setBorder(new LineBorder(new Color(90,90,90),1,true));
        
        Label lblper_name = new Label("Tên nhóm quyền",2);
        lblper_name.setBounds(100,10,150,30);
        lblper_name.setFont(new Font("TImes New Roman",Font.CENTER_BASELINE,16));
        
 
        pnlper_inf.add(lblper_name);

        
        pnl.add(pnlper_inf);
        
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
            lb[i].setBounds(100,10,170,30);
            
            rbtper[(i*4)] = new JRadioButton("Xem");
            rbtper[(i*4)].setFont(font);
            rbtper[(i*4)].setOpaque(true);
            rbtper[(i*4)].setBackground(color);
            rbtper[(i*4)].setBounds(400,10,100,30);
            
            rbtper[(i*4)+1] = new JRadioButton("Thêm");
            rbtper[(i*4)+1].setFont(font);
            rbtper[(i*4)+1].setOpaque(true);
            rbtper[(i*4)+1].setBackground(color);
            rbtper[(i*4)+1].setBounds(600,10,100,30);
            
            rbtper[(i*4)+2] = new JRadioButton("Xóa");
            rbtper[(i*4)+2].setFont(font);
            rbtper[(i*4)+2].setOpaque(true);
            rbtper[(i*4)+2].setBackground(color);
            rbtper[(i*4)+2].setBounds(800,10,100,30);
            
            rbtper[(i*4)+3] = new JRadioButton("Sửa");
            rbtper[(i*4)+3].setFont(font);
            rbtper[(i*4)+3].setOpaque(true);
            rbtper[(i*4)+3].setBackground(color);
            rbtper[(i*4)+3].setBounds(1000,10,100,30);
            
            pnlper[i].add(lb[i]);
            pnlper[i].add(rbtper[(i*4)]);
            pnlper[i].add(rbtper[(i*4)+1]);
            pnlper[i].add(rbtper[(i*4)+2]);
            pnlper[i].add(rbtper[(i*4)+3]);
            
            pnl.add(pnlper[i]);
        }
        int[] per = new int[8];
        NhomQuyenDTO nq = nhomquyenbus.selectbyId(nhomquyen.getMaNQ(),nhomquyen.getTenNQ());
        per = chitietquyenbus.getlistquyen(nq.getMaNQ());
        for(int i=0;i<8;i++){
            rbtper[i*4].setSelected(false);
            rbtper[(i*4)+1].setSelected(false);
            rbtper[(i*4)+2].setSelected(false);
            rbtper[(i*4)+3].setSelected(false);
            if(per[i]==7){
                rbtper[i*4].setSelected(true);
                rbtper[(i*4)+1].setSelected(true);
                rbtper[(i*4)+2].setSelected(true);
                rbtper[(i*4)+3].setSelected(true);
            }
            else{
                if(per[i]==1||per[i]==3||per[i]==5||per[i]==7){
                    rbtper[i*4].setSelected(true);
                    rbtper[(i*4)+1].setSelected(true);
                }
                if(per[i]==2||per[i]==3||per[i]==6||per[i]==7){
                    rbtper[(i*4)].setSelected(true);
                    rbtper[(i*4)+2].setSelected(true);
                }
                if(per[i]==4||per[i]==5||per[i]==6||per[i]==7){
                    rbtper[(i*4)].setSelected(true);
                    rbtper[(i*4)+3].setSelected(true);
                }
                if(per[i]==0)
                    rbtper[(i*4)].setSelected(true);
            }
            rbtper[i*4].setEnabled(false);
            rbtper[(i*4)+1].setEnabled(false);
            rbtper[(i*4)+2].setEnabled(false);
            rbtper[(i*4)+3].setEnabled(false);
        }
        
        
        return pnl;
    }

    
    

    public Permission(String name,NhomQuyenDTO nq) throws HeadlessException {
        initcomponent(name,nq);
    }
    
    public void getnqinfo(){
        String current = "";
        int[] per = new int[8];
        current = cbper.getSelectedItem().toString();
        NhomQuyenDTO nq = nhomquyenbus.selectbyId("", current);
        per = chitietquyenbus.getlistquyen(nq.getMaNQ());
        for(int i=0;i<8;i++){
            rbtper[i*4].setSelected(false);
            rbtper[(i*4)+1].setSelected(false);
            rbtper[(i*4)+2].setSelected(false);
            rbtper[(i*4)+3].setSelected(false);
            if(per[i]==7){
                rbtper[i*4].setSelected(true);
                rbtper[(i*4)+1].setSelected(true);
                rbtper[(i*4)+2].setSelected(true);
                rbtper[(i*4)+3].setSelected(true);
            }
            else{
                if(per[i]==1||per[i]==3||per[i]==5||per[i]==7){
                    rbtper[i*4].setSelected(true);
                    rbtper[(i*4)+1].setSelected(true);
                }
                if(per[i]==2||per[i]==3||per[i]==6||per[i]==7){
                    rbtper[(i*4)].setSelected(true);
                    rbtper[(i*4)+2].setSelected(true);
                }
                if(per[i]==4||per[i]==5||per[i]==6||per[i]==7){
                    rbtper[(i*4)].setSelected(true);
                    rbtper[(i*4)+3].setSelected(true);
                }
                if(per[i]==0)
                    rbtper[(i*4)].setSelected(true);
            }
        }
    }
    
    public int[] getnewnqinfo(){        
        int[] per = new int[8];
        int check = -1;
        for(int i=0;i<8;i++){
            if(rbtper[(i*4)+1].getSelectedObjects()!=null)
                if(check>=0)
                    check+=1;
                else
                    check+=2;
            if(rbtper[(i*4)+2].getSelectedObjects()!=null)
                if(check>=0)
                    check+=2;
                else
                    check+=3;
            if(rbtper[(i*4)+3].getSelectedObjects()!=null)
                if(check>=0)
                    check+=4;
                else
                    check+=5;
            if(check < 0 || rbtper[i*4].getSelectedObjects()!=null)
                check =0;
            per[i] = check;
            System.out.println(per[i]);
            check =-1;
        }
        return per;
    }

    public void setPhanquyen_form(PhanQuyen phanquyen_form) {
        this.phanquyen_form = phanquyen_form;
    }
    
    public void selectitemupdate(ArrayList<NhomQuyenDTO> list){
        this.index = tblnhomquyen.getSelectedRow();
        NhomQuyenDTO a = list.get(index);
        nhomquyenbus.delNhomQuyen(a);
        nhomquyenlist = nhomquyenbus.getNhomQuyenList();
        phanquyen_form.showdata(nhomquyenlist);
        model.setRowCount(0);
        for(NhomQuyenDTO nq : nhomquyenbus.getNhomQuyenList()){
            model.addRow(new Object[] {nq.getMaNQ(),nq.getTenNQ()});
        }
        
    }
    
    public void selectitemdel(ArrayList<NhomQuyenDTO> list){
        if(JOptionPane.showConfirmDialog(pnlcontent, "Bạn muốn xóa nhóm quyền này ?","Xóa nhóm quyền",JOptionPane.YES_NO_OPTION) ==0){
                this.index = tblnhomquyen.getSelectedRow();
                NhomQuyenDTO a = list.get(index);
                if(nhomquyenbus.delNhomQuyen(a)!=0){
                    nhomquyenlist = nhomquyenbus.getNhomQuyenList();
                    phanquyen_form.showdata(nhomquyenlist);
                    model.setRowCount(0);
                    for(NhomQuyenDTO nq : nhomquyenbus.getNhomQuyenList()){
                        model.addRow(new Object[] {nq.getMaNQ(),nq.getTenNQ()});
                    }
                }
        }
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
        if(e.getSource()==tblnhomquyen){
            selectitemdel(nhomquyenlist);
        }
        if(e.getSource()==lblupdate){
            String current = "";
            int[] per = new int[8];
            per = getnewnqinfo();
            current = cbper.getSelectedItem().toString();
            
            NhomQuyenDTO nq = nhomquyenbus.selectbyId("", current);
            if(name.getText().trim().equals("")){
                current = cbper.getSelectedItem().toString();
            }
            else
                current = name.getText();
            nq.setTenNQ(current);
            nhomquyenbus.update(nq);
            if(chitietquyenbus.updateChiTietQuyen(per, nq)!=0){  
                phanquyen_form.showdata(nhomquyenbus.getNhomQuyenList());
                JOptionPane.showMessageDialog(null, "Thay đổi thành công");
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        getnqinfo();
    }
    
}
