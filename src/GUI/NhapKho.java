/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.ChatlieuBUS;
import BUS.ChongNuocBUS;
import BUS.DoDayBUS;
import BUS.KichThuocBUS;
import BUS.NhaCungCapBUS;
import BUS.PhieuBUS;
import BUS.PhieuDetailBUS;
import BUS.ProductBUS;
import BUS.ProductDetailBUS;
import DTO.AccountDTO;
import DTO.NhanVienDTO;
import DTO.PhieuDTO;
import DTO.PhieuDetailDTO;
import DTO.ProductDTO;
import DTO.ProductDetailDTO;
import GUI.Component.NumericDocumentFilter;
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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.text.PlainDocument;

/**
 *
 * @author NAME
 */
public class NhapKho extends JPanel implements MouseListener,KeyListener{
    
    JPanel pnlleft,pnlright,pnlleft_footer,pnlleft_body,pnlright_head,pnlright_body,pnlleft_footer_l,pnlleft_footer_r,pnlright_foot,pnlleft_head;
    JScrollPane sptblphieunhap,sptblsanpham;
    JTable tblphieunhap,tblsanpham;
    DefaultTableModel model,modelsanpham;
    Label[] lblproduct = new Label[10];
    JLabel lbladd,lblupdate,lblmaphieu,lblnguoitao,lblmaphieu_txt,lblnguoitao_txt,lblsoluong,lblsoluong_txt,lblthanhtien,lblthanhtien_txt;
    Label lblnhap;
    String[] lblproduct_name = {"Mã sản phẩm","Người dùng","Chất liệu vỏ","Chất liệu dây","Chất liệu mặt","Độ dày","Kích thước","Chống nước","Nhà cung cấp","Giá"};
    Font prd_inf_font = new Font("Times New Roman",Font.CENTER_BASELINE,16);
    Font lblprd_inf_font = new Font("Times New Roman",Font.CENTER_BASELINE,20);
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    ProductBUS productbus = new ProductBUS();
    ArrayList<ProductDTO> prdlist = new ArrayList<>();
    ArrayList<ProductDetailDTO> inb_prdlist = new ArrayList<>();
    JComboBox cbsex,cbclvo,cbclm,cbcld,cbkt,cbdd,cbcn,cbncc;
    JTextField txtmasp,txtprice;
    ChatlieuBUS chatlieubus = new ChatlieuBUS();
    NhaCungCapBUS nhacungcapbus = new NhaCungCapBUS();
    DoDayBUS dodaybus = new DoDayBUS();
    ChongNuocBUS chongNuocBUS= new ChongNuocBUS();
    KichThuocBUS kichthuocbus = new KichThuocBUS();
    int index = -1;
    int iindex = -1;
    ProductDetailDTO prddetail = new ProductDetailDTO();
    ProductDTO selectedprd = new ProductDTO();
    ProductDetailDTO selectedprddetail = new ProductDetailDTO();
    int sl = 0;
    int thanhtien = 0;
    NhanVienDTO nhanvien;
    PhieuBUS phieubus = new PhieuBUS();
    DsPhieu dsphieu;
    Add_inbound_form inboundfrom;
    ProductDetailBUS productdetailbus = new ProductDetailBUS();
    PhieuDetailBUS chitietphieubus = new PhieuDetailBUS();
    public void initcomponent(NhanVienDTO nhanvien,DsPhieu dsphieu) throws IOException{
        this.nhanvien = nhanvien;
        prdlist = productbus.getPrdlist();
        this.dsphieu = dsphieu;
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
            lblproduct[i].setBounds(100, (i*28)+5, 150, 25);
            lblproduct[i].setAlignment(2);
            lblproduct[i].setFont(prd_inf_font);
            
            pnlleft_footer_l.add(lblproduct[i]);
        }
        
        pnlleft_footer_r = new JPanel(null);
        pnlleft_footer_r.setBorder(new EmptyBorder(0,10,10,100));
        
        txtmasp = new JTextField();
        PlainDocument doc1 = (PlainDocument) txtmasp.getDocument();
        doc1.setDocumentFilter(new NumericDocumentFilter());
        txtmasp.setBounds(0,5,200,25);
        pnlleft_footer_r.add(txtmasp);
        
        cbsex = new JComboBox(new Object[] {"Nam","Nữ"});
        cbsex.setBounds(0,33,200,25);
        pnlleft_footer_r.add(cbsex);
        
        cbclvo = new JComboBox(chatlieubus.getChatlieuvolist());
        cbclvo.setBounds(0,61,200,25);
        pnlleft_footer_r.add(cbclvo);
        
        cbcld = new JComboBox(chatlieubus.getChatlieuvolist());
        cbcld.setBounds(0,89,200,25);
        pnlleft_footer_r.add(cbcld);
        
        cbclm = new JComboBox(chatlieubus.getChatlieumatlist());
        cbclm.setBounds(0,117,200,25);
        pnlleft_footer_r.add(cbclm);
        
        cbdd = new JComboBox(dodaybus.getdodaylist());
        cbdd.setBounds(0,145,200,25);
        pnlleft_footer_r.add(cbdd);
        
        cbkt = new JComboBox(kichthuocbus.getkichthuoclist());
        cbkt.setBounds(0,173,200,25);
        pnlleft_footer_r.add(cbkt);
        
        cbcn = new JComboBox(chongNuocBUS.getchongnuoclist());
        cbcn.setBounds(0,201,200,25);
        pnlleft_footer_r.add(cbcn);
        
        cbncc = new JComboBox(nhacungcapbus.getlistNCC());
        cbncc.setBounds(0,229,200,25);
        pnlleft_footer_r.add(cbncc);
        
        txtprice = new JTextField();
        PlainDocument doc = (PlainDocument) txtprice.getDocument();
        doc.setDocumentFilter(new NumericDocumentFilter());
        txtprice.setBounds(0,257,200,25);
        pnlleft_footer_r.add(txtprice);
        
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
        
        lblupdate = new JLabel(" Xóa");
        lblupdate.setFont(lblprd_inf_font);
        lblupdate.setForeground(Color.white);
        lblupdate.setBounds(390,0,45,50);
        lblupdate.setOpaque(true);
        lblupdate.setBackground(main_clr);
        lblupdate.addMouseListener(this);
        
        pnlleft_body.add(lbladd);
        pnlleft_body.add(lblupdate);
        
        pnlleft_head = new JPanel(new BorderLayout(10,10));
        pnlleft_head.setPreferredSize(new Dimension(0,290));
        
        sptblsanpham = new JScrollPane();
        
        modelsanpham = new DefaultTableModel();
        modelsanpham.addColumn("Tên sản phẩm");
        modelsanpham.addColumn("Thương hiệu");
        modelsanpham.addColumn("Xuất xứ");
        
        for(ProductDTO prd : prdlist){
            modelsanpham.addRow(new Object[] {prd.getTenSP(),prd.getThuongHieu(),prd.getXuatSu()});
        }
        
        tblsanpham = new JTable(modelsanpham);
        tblsanpham.addMouseListener(this);
        tblsanpham.addKeyListener(this);
        
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
        
        lblmaphieu_txt = new JLabel(Integer.toString(phieubus.getPhieunhaplist().size()+1));
        lblmaphieu_txt.setBounds(170,15,150,50);
//        lblmaphieu_txt.setOpaque(true);
//        lblmaphieu_txt.setBackground(main_clr);
        lblmaphieu_txt.setFont(prd_inf_font);
        
        lblnguoitao = new JLabel("Người tạo:");
        lblnguoitao.setBounds(340,15,100,50);
//        lblnguoitao.setOpaque(true);
//        lblnguoitao.setBackground(main_clr);
        lblnguoitao.setFont(lblprd_inf_font);
        
        lblnguoitao_txt = new JLabel(this.nhanvien.getTenNV());
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
        model.addColumn("Đơn giá ($)");
        
        tblphieunhap.setModel(model);
        tblphieunhap.addMouseListener(this);
        
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
        
        lblsoluong_txt = new JLabel(Integer.toString(sl));
        lblsoluong_txt.setFont(lblprd_inf_font);
        lblsoluong_txt.setBounds(110,0,150,50);
        
        lblthanhtien = new JLabel("Thành tiền:");
        lblthanhtien.setFont(lblprd_inf_font);
//        lblthanhtien.setOpaque(true);
//        lblthanhtien.setBackground(main_clr);
        lblthanhtien.setBounds(300,0,100,50);
        
        lblthanhtien_txt = new JLabel(Integer.toString(thanhtien));
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
    
    private void desplaydetails(int selectedRows){
    }

    public void setInboundfrom(Add_inbound_form inboundfrom) {
        this.inboundfrom = inboundfrom;
    }
    
    public ProductDTO selectitem(ArrayList<ProductDTO> list){
        desplaydetails(tblsanpham.getSelectedRow());
        this.index = tblsanpham.getSelectedRow();
        ProductDTO a = list.get(index);
        return a;
    }
    
    public ProductDetailDTO selectiitem(ArrayList<ProductDetailDTO> list){
        desplaydetails(tblphieunhap.getSelectedRow());
        this.iindex = tblphieunhap.getSelectedRow();
        ProductDetailDTO a = list.get(iindex);
        return a;
    }
    
    public NhapKho(NhanVienDTO nv,DsPhieu dsphieu) throws IOException {
        initcomponent(nv,dsphieu);
    }
    
    public void checkproduct(ProductDetailDTO prd){
        int check = 1;
                    for(ProductDetailDTO prod : productdetailbus.getprddetaillist(prd.getTenSP())){
                        if (prod.getTenSP().equals(prd.getTenSP())&&prod.getMaSP().equals(prd.getMaSP())) {
                            check = 0;
                            break;
                        }
                        else
                            check = 1;
                    }
        if(inb_prdlist.size()>0 && check == 1){
            for(ProductDetailDTO product : inb_prdlist){
                if(!product.getMaSP().equals(txtmasp.getText())||!product.getTenSP().equals(selectedprd.getTenSP())){
                    check = 1;
                }
                else 
                    check = 0;
            }
        }
        else if(check == 1){
            check = 1;
        }
        if (check ==1) {
            thanhtien += Integer.parseInt(prd.getGia());
            sl ++;
            lblsoluong_txt.setText(Integer.toString(sl));
            lblthanhtien_txt.setText(Integer.toString(thanhtien));
            inb_prdlist.add(prd);
            model.addRow(new Object[] {txtmasp.getText(),selectedprd.getTenSP(),cbncc.getSelectedItem().toString(),txtprice.getText()});
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==tblsanpham){
            selectedprd = selectitem(prdlist);
        }
        if(e.getSource()==tblphieunhap){
            selectedprddetail = selectiitem(inb_prdlist);
        }
        if(e.getSource()==lbladd ){
            if(selectedprd.getTenSP()!=null){
            String date = java.time.LocalDate.now().toString();
            String[] splits = date.split("-");
            String redate ="";
            List<String> data = new ArrayList<String>();
            for(String item : splits){
                data.add( item); 
            }
            redate = data.get(2) +"/"+ data.get(1)+"/"+data.get(0);
            String giaxuat = Integer.toString((Integer.parseInt(txtprice.getText())*110)/100);
                if(txtprice.getText().equals("")){
                    JOptionPane.showMessageDialog(this,"Bạn chưa nhập giá sản phẩm");
                }else{
                prddetail = new ProductDetailDTO(txtmasp.getText(),selectedprd.getStt(), selectedprd.getTenSP(), cbsex.getSelectedItem().toString(), cbclvo.getSelectedItem().toString(),cbcld.getSelectedItem().toString(), cbclm.getSelectedItem().toString(), cbcn.getSelectedItem().toString(), cbdd.getSelectedItem().toString(), cbkt.getSelectedItem().toString(), redate, "null", txtprice.getText(),nhacungcapbus.selectbyID(cbncc.getSelectedItem().toString()).getMaNCC(),giaxuat );
                checkproduct(prddetail);
                    }
            }
            else
                JOptionPane.showMessageDialog(this,"Bạn chưa chọn sản phẩm");
        }
        if(e.getSource()==lblnhap){
            String date = java.time.LocalDate.now().toString();
            String[] splits = date.split("-");
            String redate ="";
            List<String> data = new ArrayList<String>();
            for(String item : splits){
                data.add( item); 
            }
            redate = data.get(2) +"/"+ data.get(1)+"/"+data.get(0);
            PhieuDTO phieunhap = new PhieuDTO(lblmaphieu_txt.getText(), "phieunhap", nhanvien.getMaNV(),redate , lblthanhtien_txt.getText());
            phieubus.addPhieuNhap(phieunhap);
            dsphieu.showdata(phieubus.getPhieunhaplist());
            for(ProductDetailDTO prd : inb_prdlist){
                productdetailbus.addProductDetail(prd);
                String giaxuat = "";
                PhieuDetailDTO chitietphieu = new PhieuDetailDTO(prd.getMaSP(),prd.getTenSP(), "phieunhap", phieunhap.getMaPhieu(), prd.getGia());
                chitietphieubus.addPhieuDetail(chitietphieu);
            }
            inboundfrom.dispose();
        }
        if(e.getSource()==lblupdate && selectedprddetail.getMaSP()!=null){
            sl--;
            thanhtien-=Integer.parseInt(selectedprddetail.getGia());
            lblsoluong_txt.setText(Integer.toString(sl));
            lblthanhtien_txt.setText(Integer.toString(thanhtien));
            inb_prdlist.remove(selectedprddetail);
            model.setRowCount(0);
            for(ProductDetailDTO prd : inb_prdlist){
                model.addRow(new Object[] {prd.getMaSP(),prd.getTenSP(),nhacungcapbus.selectbyname(prd.getNhaCungCap()).getTenNCC(),prd.getGia()});
            }
            selectedprddetail = new ProductDetailDTO();
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        desplaydetails(tblsanpham.getSelectedRow());
    }
    
}
