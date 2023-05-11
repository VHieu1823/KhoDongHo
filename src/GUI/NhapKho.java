/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.ChatlieuBUS;
import BUS.NhaCungCapBUS;
import BUS.ProductBUS;
import DTO.AccountDTO;
import DTO.ProductDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import component.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

/**
 *
 * @author NAME
 */
public class NhapKho extends JPanel implements MouseListener{
    
    JPanel pnlleft,pnlright,pnlleft_footer,pnlleft_body,pnlright_head,pnlright_body,pnlleft_footer_l,pnlleft_footer_r,pnlright_foot,pnlleft_head;
    JScrollPane sptblphieunhap,sptblsanpham;
    JTable tblphieunhap,tblsanpham;
    DefaultTableModel model,modelsanpham;
    Label[] lblproduct = new Label[9];
    JLabel lbladd,lblupdate,lblmaphieu,lblnguoitao,lblmaphieu_txt,lblnguoitao_txt,lblsoluong,lblsoluong_txt,lblthanhtien,lblthanhtien_txt;
    Label lblnhap;
    String[] lblproduct_name = {"Mã sản phẩm","Người dùng","Chất liệu vỏ","Chất liệu dây","Chất liệu mặt","Độ dày","Kích thước","Chống nước","Nhà cung cấp"};
    Font prd_inf_font = new Font("Times New Roman",Font.CENTER_BASELINE,16);
    Font lblprd_inf_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    ProductBUS productbus = new ProductBUS();
    ArrayList<ProductDTO> prdlist = new ArrayList<>();
    JComboBox cbsex,cbclvo,cbclm,cbcld,cbkt,cbdd,cbcn,cbncc;
    JTextField txtmasp;
    ChatlieuBUS chatlieubus = new ChatlieuBUS();
    NhaCungCapBUS nhacungcapbus = new NhaCungCapBUS();
    public void initcomponent() throws IOException{
        
        prdlist = productbus.getPrdlist();
        
        this.setLayout(new GridLayout(1,2,10,10));
//        this.setOpaque(true);
//        this.setBackground(Color.red);
        this.setBorder(new EmptyBorder(10,10,10,10));
        
        pnlleft = new JPanel(new BorderLayout(10,10));
        pnlleft.setBorder(new EmptyBorder(10,10,10,10));
        
        pnlleft_footer = new JPanel(new BorderLayout(10,10));
//        pnlleft_footer.setOpaque(true);
//        pnlleft_footer.setBackground(Color.blue);
        
        pnlleft_footer_l = new JPanel(null);
        pnlleft_footer_l.setPreferredSize(new Dimension(250,0));
                
        for(int i = 0;i < lblproduct.length; i++){
            lblproduct[i] = new Label(lblproduct_name[i]);
            lblproduct[i].setBounds(100, (i*30)+5, 150, 25);
            lblproduct[i].setAlignment(2);
            lblproduct[i].setFont(prd_inf_font);
            
            pnlleft_footer_l.add(lblproduct[i]);
        }
        
        pnlleft_footer_r = new JPanel(null);
        pnlleft_footer_r.setBorder(new EmptyBorder(10,10,10,100));
        
        txtmasp = new JTextField();
        txtmasp.setBounds(0,5,200,25);
        pnlleft_footer_r.add(txtmasp);
        
        cbsex = new JComboBox(new Object[] {"Nam","Nữ"});
        cbsex.setBounds(0,35,200,25);
        pnlleft_footer_r.add(cbsex);
        
        cbclvo = new JComboBox(chatlieubus.getChatlieuvolist());
        cbclvo.setBounds(0,65,200,25);
        pnlleft_footer_r.add(cbclvo);
        
        cbcld = new JComboBox(chatlieubus.getChatlieuvolist());
        cbcld.setBounds(0,95,200,25);
        pnlleft_footer_r.add(cbcld);
        
        cbclm = new JComboBox(chatlieubus.getChatlieumatlist());
        cbclm.setBounds(0,125,200,25);
        pnlleft_footer_r.add(cbclm);
        
        cbdd = new JComboBox();
        cbdd.setBounds(0,155,200,25);
        pnlleft_footer_r.add(cbdd);
        
        cbkt = new JComboBox();
        cbkt.setBounds(0,185,200,25);
        pnlleft_footer_r.add(cbkt);
        
        cbncc = new JComboBox(nhacungcapbus.getlistNCC());
        cbncc.setBounds(0,245,200,25);
        pnlleft_footer_r.add(cbncc);
        
        cbcn = new JComboBox();
        cbcn.setBounds(0,215,200,25);
        pnlleft_footer_r.add(cbcn);
        
        pnlleft_footer.add(pnlleft_footer_l,BorderLayout.WEST);
        pnlleft_footer.add(pnlleft_footer_r,BorderLayout.CENTER);
        
        pnlleft_body = new JPanel(null);
        pnlleft_body.setPreferredSize(new Dimension(0,80));
        pnlleft_body.setOpaque(true);
//        pnlleft_body.setBackground(main_clr);
                
        lbladd = new JLabel(" Thêm sản phẩm");
        lbladd.setFont(lblprd_inf_font);
        lbladd.setForeground(Color.white);
        lbladd.setBounds(230,0,145,50);
        lbladd.setOpaque(true);
        lbladd.setBackground(main_clr);
        lbladd.addMouseListener(this);
        
        lblupdate = new JLabel(" Sửa");
        lblupdate.setFont(lblprd_inf_font);
        lblupdate.setForeground(Color.white);
        lblupdate.setBounds(390,0,45,50);
        lblupdate.setOpaque(true);
        lblupdate.setBackground(main_clr);
        lblupdate.addMouseListener(this);
        
        pnlleft_body.add(lbladd);
        pnlleft_body.add(lblupdate);
        
        pnlleft_head = new JPanel(new BorderLayout(10,10));
        pnlleft_head.setPreferredSize(new Dimension(0,300));
        
        sptblsanpham = new JScrollPane();
        
        modelsanpham = new DefaultTableModel();
        modelsanpham.addColumn("Tên sản phẩm");
        modelsanpham.addColumn("Thương hiệu");
        modelsanpham.addColumn("Xuất xứ");
        
        for(ProductDTO prd : prdlist){
            modelsanpham.addRow(new Object[] {prd.getTenSP(),prd.getThuongHieu(),prd.getXuatSu()});
        }
        
        tblsanpham = new JTable(modelsanpham);
        
        sptblsanpham.setViewportView(tblsanpham);
        
        pnlleft_head.add(sptblsanpham,BorderLayout.CENTER);
        
        pnlleft.add(pnlleft_head,BorderLayout.NORTH);
        pnlleft.add(pnlleft_body,BorderLayout.SOUTH);
        pnlleft.add(pnlleft_footer,BorderLayout.CENTER);
        
        
        pnlright = new JPanel(new BorderLayout(10,10));
        pnlright.setBorder(new EmptyBorder(10,10,10,10));
        
        pnlright_head = new JPanel(null);
        pnlright_head.setPreferredSize(new Dimension(0,80));
//        pnlright_head.setOpaque(true);
//        pnlright_head.setBackground(Color.red);
        pnlright_head.setBorder(new LineBorder(new Color(120,120,120),1,true));
        
        lblmaphieu = new JLabel("Mã phiếu:");
        lblmaphieu.setBounds(70,15,90,50);
//        lblmaphieu.setOpaque(true);
//        lblmaphieu.setBackground(main_clr);
        lblmaphieu.setFont(lblprd_inf_font);
        
        lblmaphieu_txt = new JLabel();
        lblmaphieu_txt.setBounds(170,15,150,50);
//        lblmaphieu_txt.setOpaque(true);
//        lblmaphieu_txt.setBackground(main_clr);
        lblmaphieu_txt.setFont(prd_inf_font);
        
        lblnguoitao = new JLabel("Người tạo:");
        lblnguoitao.setBounds(340,15,100,50);
//        lblnguoitao.setOpaque(true);
//        lblnguoitao.setBackground(main_clr);
        lblnguoitao.setFont(lblprd_inf_font);
        
        lblnguoitao_txt = new JLabel();
        lblnguoitao_txt.setBounds(450,15,150,50);
//        lblnguoitao_txt.setOpaque(true);
//        lblnguoitao_txt.setBackground(main_clr);
        lblnguoitao_txt.setFont( prd_inf_font);
        
        pnlright_head.add(lblmaphieu);
        pnlright_head.add(lblmaphieu_txt);
        pnlright_head.add(lblnguoitao);
        pnlright_head.add(lblnguoitao_txt);
        
        pnlright_body = new JPanel(new GridLayout(1,1));
        
        tblphieunhap = new JTable();
        
        model = new DefaultTableModel();
        
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Nhà cung cấp");
        model.addColumn("Số lượng");
        model.addColumn("Đơn giá");
        
        tblphieunhap.setModel(model);
        
        sptblphieunhap = new JScrollPane();
        sptblphieunhap.setViewportView(tblphieunhap);
        
        pnlright_body.add(sptblphieunhap);
        
        pnlright_foot = new JPanel(null);
        pnlright_foot.setPreferredSize(new Dimension(0,80));
        
        lblsoluong = new JLabel("Số lượng:");
        lblsoluong.setFont(lblprd_inf_font);
//        lblsoluong.setOpaque(true);
//        lblsoluong.setBackground(main_clr);
        lblsoluong.setBounds(0,0,100,50);
        
        lblsoluong_txt = new JLabel();
        lblsoluong_txt.setFont(lblprd_inf_font);
        lblsoluong_txt.setBounds(110,0,150,50);
        
        lblthanhtien = new JLabel("Thành tiền:");
        lblthanhtien.setFont(lblprd_inf_font);
//        lblthanhtien.setOpaque(true);
//        lblthanhtien.setBackground(main_clr);
        lblthanhtien.setBounds(300,0,100,50);
        
        lblthanhtien_txt = new JLabel();
        lblthanhtien_txt.setFont(lblprd_inf_font);
        lblthanhtien_txt.setBounds(410,0,150,50);
        
        lblnhap = new Label("Nhập kho");
        lblnhap.setFont(lblprd_inf_font);
        lblnhap.setAlignment(1);
        lblnhap.setBackground(main_clr);
        lblnhap.setForeground(Color.white);
        lblnhap.setBounds(560,0,100,50);
        lblnhap.addMouseListener(this);
        
        pnlright_foot.add(lblsoluong);
        pnlright_foot.add(lblsoluong_txt);
        pnlright_foot.add(lblthanhtien);
        pnlright_foot.add(lblthanhtien_txt);
        pnlright_foot.add(lblnhap);

        
        
        pnlright.add(pnlright_body,BorderLayout.CENTER);
        pnlright.add(pnlright_head,BorderLayout.NORTH);
        pnlright.add(pnlright_foot,BorderLayout.SOUTH);
        
        this.add(pnlleft);
        this.add(pnlright);
        
    }
    
    public JTable gettbl(){
        return this.tblphieunhap;
    }

    public DefaultTableModel getModel(){
        return this.model;
    }
    
    
    
    public NhapKho() throws IOException {
        initcomponent();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==lblnhap) {
            lblnhap.setBackground(hover_clr);
        }
        if (e.getSource()==lbladd) {
            lbladd.setBackground(hover_clr);
        }
        if (e.getSource()==lblupdate) {
            lblupdate.setBackground(hover_clr);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()==lblnhap) {
            lblnhap.setBackground(main_clr);
        }
        if (e.getSource()==lbladd) {
            lbladd.setBackground(main_clr);
        }
        if (e.getSource()==lblupdate) {
            lblupdate.setBackground(main_clr);
        }
    }
    
}
