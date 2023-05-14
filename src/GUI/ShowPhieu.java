/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import DTO.PhieuDTO;
import DTO.PhieuDetailDTO;
import DTO.ProductDetailDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class ShowPhieu extends JFrame{
    
    JPanel pnlphieuinfo,pnlphieudetail;
    Label lblnguoitao,lblmaphieu,lblngaytao,lblthanhtien,lblheader;
    JLabel txtnguoitao,txtmaphieu,txtngaytao,txtthanhtien;
    JTable tblsanpham;
    DefaultTableModel model;
    JScrollPane sptbl;
    NhaCungCapBUS nhacungcapbus = new NhaCungCapBUS();
    NhanVienBUS nhanvienbus = new NhanVienBUS();
    public void initcomponent(String name,PhieuDTO phieu,ArrayList<PhieuDetailDTO> phieulist,ArrayList<ProductDetailDTO> productlist){
        this.setSize(new Dimension(800,800));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        pnlphieuinfo = new JPanel(null);
        pnlphieuinfo.setPreferredSize(new Dimension(800,250));
        pnlphieuinfo.setOpaque(true);
        pnlphieuinfo.setBackground(Color.white);
        
        lblheader = new Label(name,1);
        lblheader.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        lblheader.setBounds(250,10,300,30);
        
        lblmaphieu = new Label("Mã phiếu:",2);
        lblmaphieu.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,16));
        lblmaphieu.setBounds(80,70,100,30);
        
        String loai= "PX";
        if(name.equals("Phiếu nhập hàng")){
            loai = "PN";
        }
        txtmaphieu = new JLabel(loai+"-"+phieu.getMaPhieu());
        txtmaphieu.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,16));
        txtmaphieu.setBounds(190,70,200,30);
        
        lblnguoitao = new Label("Người tạo:",2);
        lblnguoitao.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,16));
        lblnguoitao.setBounds(80,170,100,30);
        
        txtnguoitao = new JLabel(nhanvienbus.selectnhanvien(phieu.getNguoiTao()).getTenNV());
        txtnguoitao.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,16));
        txtnguoitao.setBounds(190,170,200,30);
        
        lblngaytao = new Label("Ngày tạo:",2);
        lblngaytao.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,16));
        lblngaytao.setBounds(420,70,100,30);
        
        txtngaytao = new JLabel(phieu.getNgayTao());
        txtngaytao.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,16));
        txtngaytao.setBounds(530,70,200,30);
        
        lblthanhtien = new Label("Thành tiền:",2);
        lblthanhtien.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,16));
        lblthanhtien.setBounds(420,170,100,30);
        
        txtthanhtien = new JLabel(phieu.getDonGia()+"$");
        txtthanhtien.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,16));
        txtthanhtien.setBounds(530,170,200,30);
        
        pnlphieuinfo.add(lblmaphieu);
        pnlphieuinfo.add(txtmaphieu);
        pnlphieuinfo.add(lblheader);
        pnlphieuinfo.add(lblngaytao);
        pnlphieuinfo.add(txtngaytao);
        pnlphieuinfo.add(lblnguoitao);
        pnlphieuinfo.add(txtnguoitao);
        pnlphieuinfo.add(lblthanhtien);
        pnlphieuinfo.add(txtthanhtien);
        
        pnlphieudetail = new JPanel(new GridLayout(1,1));
        pnlphieudetail.setBorder(new EmptyBorder(10,10,10,10));
        pnlphieudetail.setOpaque(true);
        pnlphieudetail.setBackground(new Color(230,230,230));
        
        model = new DefaultTableModel();
        
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Chất liệu");
        model.addColumn("Người sử dụng");
        model.addColumn("Nhà cung cấp");
        model.addColumn("Đơn giá");
        String chatlieu="";
        for(PhieuDetailDTO phieudt : phieulist){
            for(ProductDetailDTO prd : productlist){
                if(phieudt.getMaSP().equals(prd.getMaSP()) && phieudt.getTenSP().equals(prd.getTenSP())){
                    if(prd.getChatLieuVo().equals(prd.getChatLieuDay())){
                        chatlieu = prd.getChatLieuVo();
                    }
                    else{
                        chatlieu = prd.getChatLieuVo()+"-"+prd.getChatLieuDay();
                    }
                    model.addRow(new Object[] {prd.getMaSP(),prd.getTenSP(),chatlieu+"-"+prd.getChatLieuMatDH(),prd.getDuoiTuongSuDung(),nhacungcapbus.selectbyname(prd.getNhaCungCap()).getTenNCC(),prd.getGia()});
                }
            }
        }
        
        tblsanpham = new JTable(model);
        
        sptbl = new JScrollPane();
        sptbl.setViewportView(tblsanpham);
        
        pnlphieudetail.add(sptbl);
        
        this.add(pnlphieuinfo,BorderLayout.NORTH);
        this.add(pnlphieudetail,BorderLayout.CENTER);
        
        this.setVisible(true);
    }

    public ShowPhieu(String name,PhieuDTO phieu,ArrayList<PhieuDetailDTO> phieulist,ArrayList<ProductDetailDTO> productlist) throws HeadlessException {
        initcomponent(name,phieu,phieulist,productlist);
    }
    
    
}
