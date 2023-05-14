/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.KhachHangBUS;
import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import BUS.PhieuBUS;
import BUS.PhieuDetailBUS;
import BUS.ProductDetailBUS;
import DTO.NhanVienDTO;
import DTO.PhieuDTO;
import DTO.PhieuDetailDTO;
import DTO.ProductDetailDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class XuatKho extends JPanel implements MouseListener{
    
    JPanel pnlleft,pnlright,pnlleft_head,pnlleft_body,pnlright_head,pnlright_body,pnlright_foot;
    JScrollPane sptblphieuxuat;
    JTable tblphieuxuat;
    DefaultTableModel model;
    Label[] lblproduct = new Label[14];
    JLabel lbladd,lblupdate,lblmaphieu,lblnguoitao,lblmaphieu_txt,lblnguoitao_txt,lblsoluong,lblsoluong_txt,lblthanhtien,lblthanhtien_txt,lblnguoinhan;
    JComboBox lblnguoinhan_txt;
    Label lblxuat;
    JTextField[] prd_tf = new JTextField[14];
    String[] lblproduct_name = {"Tên sản phẩm","Mã sản phẩm","Xuất sứ","Thương hiệu","Đối tượng sử dụng","Chất liệu vỏ","Chất liệu dây","Chất liệu mặt","Độ dày","Kích thước","Chống nước","Nhà cung cấp","Thương hiệu","Hình ảnh"};    
    Font prd_inf_font = new Font("Times New Roman",Font.CENTER_BASELINE,16);
    Font lblprd_inf_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
    JTable tblprd;
    KhachHangBUS khachhangbus = new KhachHangBUS();
    JScrollPane spprd;
    PhieuBUS phieubus = new PhieuBUS();
    DefaultTableModel modelprd;
    NhaCungCapBUS nhacungcapbus = new NhaCungCapBUS();
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    ProductDetailBUS productdetailbus = new ProductDetailBUS();
    ArrayList<ProductDetailDTO> productlist = new ArrayList<>();
    ArrayList<ProductDetailDTO> outblist = new ArrayList<>();
    int index = -1;
    int iindex = -1;
    int sl=0;
    int pricatotal=0;
    ProductDetailDTO selectedprddetail = new ProductDetailDTO();
    ProductDetailDTO selectedprddetaill = new ProductDetailDTO();
    NhanVienBUS nhanvienbus = new NhanVienBUS();
    NhanVienDTO nhanvien;
    DsPhieuxuat dsphieuxuat_form;
    PhieuDetailBUS phieudetailbus = new PhieuDetailBUS();
    Add_outbound_form outbound_form;
    public void initcomponent(NhanVienDTO nhanvien,Add_outbound_form outbound_form) throws IOException{
        this.nhanvien  = nhanvien;
        this.outbound_form = outbound_form;
        for(ProductDetailDTO prd : productdetailbus.getallprd()){
            if(prd.getNgayXuat().equals("null")){
                productlist.add(prd);
            }
        }
        this.setLayout(new GridLayout(1,2,10,10));
//        this.setOpaque(true);
//        this.setBackground(Color.red);
        this.setBorder(new EmptyBorder(10,10,10,10));
        
        pnlleft = new JPanel(new BorderLayout(10,10));
        pnlleft.setBorder(new EmptyBorder(10,10,10,10));
        
        pnlleft_head = new JPanel(new BorderLayout(10,10));
//        pnlleft_head.setOpaque(true);
//        pnlleft_head.setBackground(Color.blue);
        
        tblprd = new JTable();
        
        modelprd = new DefaultTableModel();
        
        modelprd.addColumn("Mã sản phẩm");
        modelprd.addColumn("Tên sản phẩm");
        modelprd.addColumn("Chất liệu");
        modelprd.addColumn("Nhà cung cấp");
        modelprd.addColumn("Đơn giá");
        String chatlieu = "";
        int gia = 0;
        for(ProductDetailDTO prd : productlist){
            gia = (Integer.parseInt(prd.getGia())*110)/100;
            if(prd.getChatLieuDay().equals(prd.getChatLieuVo())){
                chatlieu=prd.getChatLieuDay();
            }
            else
                chatlieu=prd.getChatLieuVo()+"-"+prd.getChatLieuDay();
            modelprd.addRow(new Object[] {prd.getMaSP(),prd.getTenSP(),chatlieu+"-"+prd.getChatLieuMatDH(),nhacungcapbus.selectbyname(prd.getNhaCungCap()).getTenNCC(),Integer.toString(gia)});
        }
        
        tblprd.setModel(modelprd);
        tblprd.addMouseListener(this);
        
        spprd = new JScrollPane();
        
        spprd.setViewportView(tblprd);
        
        pnlleft_head.add(spprd,BorderLayout.CENTER);
        
        pnlleft_body = new JPanel(null);
        pnlleft_body.setPreferredSize(new Dimension(0,80));
        pnlleft_body.setOpaque(true);
//        pnlleft_body.setBackground(main_clr);
                
        lbladd = new JLabel(" Thêm sản phẩm");
        lbladd.setFont(lblprd_inf_font);
        lbladd.setForeground(Color.white);
        lbladd.setBounds(200,0,145,50);
        lbladd.setOpaque(true);
        lbladd.setBackground(main_clr);
        lbladd.addMouseListener(this);
        
        lblupdate = new JLabel(" Xóa");
        lblupdate.setFont(lblprd_inf_font);
        lblupdate.setForeground(Color.white);
        lblupdate.setBounds(360,0,45,50);
        lblupdate.setOpaque(true);
        lblupdate.setBackground(main_clr);
        lblupdate.addMouseListener(this);
        
        pnlleft_body.add(lbladd);
        pnlleft_body.add(lblupdate);
        
        pnlleft.add(pnlleft_body,BorderLayout.SOUTH);
        pnlleft.add(pnlleft_head,BorderLayout.CENTER);
        
        
        pnlright = new JPanel(new BorderLayout(10,10));
        pnlright.setBorder(new EmptyBorder(10,10,10,10));
        
        pnlright_head = new JPanel(null);
        pnlright_head.setPreferredSize(new Dimension(0,80));
//        pnlright_head.setOpaque(true);
//        pnlright_head.setBackground(Color.red);
        pnlright_head.setBorder(new LineBorder(new Color(120,120,120),1,true));
        
        lblmaphieu = new JLabel("Mã phiếu:");
        lblmaphieu.setBounds(20,15,85,50);
//        lblmaphieu.setOpaque(true);
//        lblmaphieu.setBackground(main_clr);
        lblmaphieu.setFont(lblprd_inf_font);
        
        lblmaphieu_txt = new JLabel(Integer.toString(phieubus.getPhieuxuatlist().size()+1));
        lblmaphieu_txt.setBounds(120,15,80,50);
//        lblmaphieu_txt.setOpaque(true);
//        lblmaphieu_txt.setBackground(main_clr);
        lblmaphieu_txt.setFont(prd_inf_font);
        
        lblnguoitao = new JLabel("Người tạo:");
        lblnguoitao.setBounds(180,15,95,50);
//        lblnguoitao.setOpaque(true);
//        lblnguoitao.setBackground(main_clr);
        lblnguoitao.setFont(lblprd_inf_font);
        
        lblnguoitao_txt = new JLabel(nhanvien.getTenNV());
        lblnguoitao_txt.setBounds(290,15,80,50);
//        lblnguoitao_txt.setOpaque(true);
//        lblnguoitao_txt.setBackground(main_clr);
        lblnguoitao_txt.setFont( prd_inf_font);
        
        lblnguoinhan = new JLabel("Người nhận:");
        lblnguoinhan.setBounds(380,15,105,50);
//        lblnguoitao.setOpaque(true);
//        lblnguoitao.setBackground(main_clr);
        lblnguoinhan.setFont(lblprd_inf_font);
        
        lblnguoinhan_txt = new JComboBox(khachhangbus.getlistkhachhang());
        lblnguoinhan_txt.setBounds(490,25,160,30);
//        lblnguoitao_txt.setOpaque(true);
//        lblnguoitao_txt.setBackground(main_clr);
        lblnguoinhan_txt.setFont( prd_inf_font);
        
        pnlright_head.add(lblmaphieu);
        pnlright_head.add(lblmaphieu_txt);
        pnlright_head.add(lblnguoitao);
        pnlright_head.add(lblnguoitao_txt);
        pnlright_head.add(lblnguoinhan);
        pnlright_head.add(lblnguoinhan_txt);
        
        pnlright_body = new JPanel(new GridLayout(1,1));
        
        tblphieuxuat = new JTable();
        
        model = new DefaultTableModel();
        
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Nhà cung cấp");
        model.addColumn("Số lượng");
        model.addColumn("Đơn giá");
        
        tblphieuxuat.setModel(model);
        tblphieuxuat.addMouseListener(this);
        
        sptblphieuxuat = new JScrollPane();
        sptblphieuxuat.setViewportView(tblphieuxuat);
        
        pnlright_body.add(sptblphieuxuat);
        
        pnlright_foot = new JPanel(null);
        pnlright_foot.setPreferredSize(new Dimension(0,80));
        
        lblsoluong = new JLabel("Số lượng:");
        lblsoluong.setFont(lblprd_inf_font);
//        lblsoluong.setOpaque(true);
//        lblsoluong.setBackground(main_clr);
        lblsoluong.setBounds(0,0,100,50);
        
        lblsoluong_txt = new JLabel(Integer.toString(sl));
        lblsoluong_txt.setFont(lblprd_inf_font);
        lblsoluong_txt.setBounds(110,0,150,50);
        
        lblthanhtien = new JLabel("Thành tiền:");
        lblthanhtien.setFont(lblprd_inf_font);
//        lblthanhtien.setOpaque(true);
//        lblthanhtien.setBackground(main_clr);
        lblthanhtien.setBounds(300,0,100,50);
        
        lblthanhtien_txt = new JLabel(Integer.toString(pricatotal));
        lblthanhtien_txt.setFont(lblprd_inf_font);
        lblthanhtien_txt.setBounds(410,0,150,50);
        
        lblxuat = new Label("Xuất kho");
        lblxuat.setFont(lblprd_inf_font);
        lblxuat.setAlignment(1);
        lblxuat.setBackground(main_clr);
        lblxuat.setForeground(Color.white);
        lblxuat.setBounds(560,0,100,50);
        lblxuat.addMouseListener(this);
        
        pnlright_foot.add(lblsoluong);
        pnlright_foot.add(lblsoluong_txt);
        pnlright_foot.add(lblthanhtien);
        pnlright_foot.add(lblthanhtien_txt);
        pnlright_foot.add(lblxuat);

        
        
        pnlright.add(pnlright_body,BorderLayout.CENTER);
        pnlright.add(pnlright_head,BorderLayout.NORTH);
        pnlright.add(pnlright_foot,BorderLayout.SOUTH);
        
        this.add(pnlleft);
        this.add(pnlright);
        
    }

    public XuatKho(NhanVienDTO nv,Add_outbound_form outbound_form) throws IOException {
        initcomponent(nv,outbound_form);
    }
    public ProductDetailDTO selectitem(ArrayList<ProductDetailDTO> list){
        this.index = tblprd.getSelectedRow();
        ProductDetailDTO a = list.get(index);
        return a;
    }

    public void setDsphieuxuat_form(DsPhieuxuat dsphieuxuat_form) {
        this.dsphieuxuat_form = dsphieuxuat_form;
    }
    
    public ProductDetailDTO selectiitem(ArrayList<ProductDetailDTO> list){
        this.iindex = tblphieuxuat.getSelectedRow();
        ProductDetailDTO a = list.get(iindex);
        return a;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==tblprd){
            selectedprddetail = selectitem(productlist);
        }
        if(e.getSource()==tblphieuxuat){
            selectedprddetaill = selectiitem(outblist);
        }
        if(e.getSource()==lbladd && selectedprddetail.getMaSP()!=null){
            
            outblist.add(selectedprddetail);
            productlist.remove(selectedprddetail);
            model.setRowCount(0);
            modelprd.setRowCount(0);
            int gia = 0;
            String chatlieu ="";
            for(ProductDetailDTO prd : productlist){
                gia = (Integer.parseInt(prd.getGia())*110)/100;
                if(prd.getChatLieuDay().equals(prd.getChatLieuVo())){
                    chatlieu=prd.getChatLieuDay();
                }
                else
                    chatlieu=prd.getChatLieuVo()+"-"+prd.getChatLieuDay();
                modelprd.addRow(new Object[] {prd.getMaSP(),prd.getTenSP(),chatlieu+"-"+prd.getChatLieuMatDH(),nhacungcapbus.selectbyname(prd.getNhaCungCap()).getTenNCC(),Integer.toString(gia)});
            }
            int giaa = 0;
            String chatlieuu ="";
            for(ProductDetailDTO prd : outblist){
                giaa = (Integer.parseInt(prd.getGia())*110)/100;
                if(prd.getChatLieuDay().equals(prd.getChatLieuVo())){
                    chatlieuu=prd.getChatLieuDay();
                }
                else
                    chatlieuu=prd.getChatLieuVo()+"-"+prd.getChatLieuDay();
                model.addRow(new Object[] {prd.getMaSP(),prd.getTenSP(),chatlieuu+"-"+prd.getChatLieuMatDH(),nhacungcapbus.selectbyname(prd.getNhaCungCap()).getTenNCC(),Integer.toString(giaa)});
            }
            sl++;
            pricatotal+=(Integer.parseInt(selectedprddetail.getGia())*110)/100;
            lblsoluong_txt.setText(Integer.toString(sl));
            lblthanhtien_txt.setText(Integer.toString(pricatotal));
            selectedprddetail = new ProductDetailDTO();
            
        }
        if(e.getSource()==lblupdate && selectedprddetaill.getMaSP()!=null){
            
            outblist.remove(selectedprddetaill);
            productlist.add(selectedprddetaill);
            model.setRowCount(0);
            modelprd.setRowCount(0);
            int gia = 0;
            String chatlieu ="";
            for(ProductDetailDTO prd : productlist){
                gia = (Integer.parseInt(prd.getGia())*110)/100;
                if(prd.getChatLieuDay().equals(prd.getChatLieuVo())){
                    chatlieu=prd.getChatLieuDay();
                }
                else
                    chatlieu=prd.getChatLieuVo()+"-"+prd.getChatLieuDay();
                modelprd.addRow(new Object[] {prd.getMaSP(),prd.getTenSP(),chatlieu+"-"+prd.getChatLieuMatDH(),nhacungcapbus.selectbyname(prd.getNhaCungCap()).getTenNCC(),Integer.toString(gia)});
            }
            int giaa = 0;
            String chatlieuu ="";
            for(ProductDetailDTO prd : outblist){
                giaa = (Integer.parseInt(prd.getGia())*110)/100;
                if(prd.getChatLieuDay().equals(prd.getChatLieuVo())){
                    chatlieuu=prd.getChatLieuDay();
                }
                else
                    chatlieuu=prd.getChatLieuVo()+"-"+prd.getChatLieuDay();
                model.addRow(new Object[] {prd.getMaSP(),prd.getTenSP(),chatlieuu+"-"+prd.getChatLieuMatDH(),nhacungcapbus.selectbyname(prd.getNhaCungCap()).getTenNCC(),Integer.toString(giaa)});
            }
            sl--;
            pricatotal-=(Integer.parseInt(selectedprddetaill.getGia())*110)/100;
            lblsoluong_txt.setText(Integer.toString(sl));
            lblthanhtien_txt.setText(Integer.toString(pricatotal));
            selectedprddetaill = new ProductDetailDTO();
        }
        if(e.getSource()==lblxuat){
            String date = java.time.LocalDate.now().toString();
            String[] splits = date.split("-");
            String redate ="";
            List<String> data = new ArrayList<String>();
            for(String item : splits){
                data.add( item); 
            }
            redate = data.get(2) +"/"+ data.get(1)+"/"+data.get(0);
            int i=0;
            while (true) {            
                if(lblnguoinhan_txt.getSelectedItem().toString().charAt(i)=='-'){
                    break;
                }
                i++;
            }
            String makh =lblnguoinhan_txt.getSelectedItem().toString().subSequence(0, i).toString();
            System.out.println(makh);
            PhieuDTO phieuxuat = new PhieuDTO(lblmaphieu_txt.getText(), "phieuxuat",nhanvien.getMaNV() , makh, redate, lblthanhtien_txt.getText());
            phieubus.addPhieuXuat(phieuxuat);
            for(ProductDetailDTO prd : outblist){
                prd.setNgayXuat(redate);
                productdetailbus.update(prd);
                PhieuDetailDTO phieu = new PhieuDetailDTO(prd.getMaSP(), prd.getTenSP(), "phieuxuat", phieuxuat.getMaPhieu(),Integer.toString((Integer.parseInt(prd.getGia())*110)/100));
                phieudetailbus.addPhieuDetail(phieu);
            }
            
            dsphieuxuat_form.showdata(phieubus.getPhieuxuatlist());
            outbound_form.dispose();
            
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
        if(e.getSource()==lbladd){
            lbladd.setBackground(hover_clr);
        }
        if(e.getSource()==lblupdate){
            lblupdate.setBackground(hover_clr);
        }
        if(e.getSource()==lblxuat){
            lblxuat.setBackground(hover_clr);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==lbladd){
            lbladd.setBackground(main_clr);
        }
        if(e.getSource()==lblupdate){
            lblupdate.setBackground(main_clr);
        }
        if(e.getSource()==lblxuat){
            lblxuat.setBackground(main_clr);
        }
    }
}
