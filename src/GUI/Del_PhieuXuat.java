/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.KhachHangBUS;
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
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
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
public class Del_PhieuXuat extends JFrame implements MouseListener{
    
    JPanel pnlheading,pnlcontent;
    Label heading;
    JScrollPane sptbl;
    JTable tblphieuxuat;
    DefaultTableModel model;
    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);
    PhieuBUS phieubus = new PhieuBUS();
    NhanVienBUS nhanvienbus = new NhanVienBUS();
    int index = -1;
    PhieuDetailBUS phieudetailbus = new PhieuDetailBUS();
    ProductDetailBUS productdetailbus = new ProductDetailBUS();
    DsPhieuxuat phieuxuat;
    KhachHangBUS khachhangbus = new KhachHangBUS();
    public void initcomponent(){
        this.setSize(1200,600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        pnlheading = new JPanel(new GridLayout(1,1));
        pnlheading.setPreferredSize(new Dimension(0,80));
        pnlheading.setOpaque(true);
        
        heading = new Label("Hủy phiếu",1);
        heading.setForeground(new Color(240,240,240));
        heading.setBackground(main_clr);
        heading.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        
        pnlheading.add(heading);
        
        pnlcontent = new JPanel(new GridLayout(1,1));
        pnlcontent.setBorder(new EmptyBorder(10,10,10,10));
        
        model = new DefaultTableModel();
        
        model.addColumn("Mã phiếu xuất");
        model.addColumn("Người tạo");
        model.addColumn("Người nhận");
        model.addColumn("Ngày tạo");
        model.addColumn("Thành tiền");
        
        for(PhieuDTO pn : phieubus.getPhieuxuatlist()){
            NhanVienDTO nv = nhanvienbus.selectnhanvien(pn.getNguoiTao());
            System.out.println(pn.getNguoiTao());
            model.addRow(new Object[] {pn.getMaPhieu(),nv.getTenNV(),khachhangbus.selectbyid(pn.getNguoiNhan()).getTenKh(),pn.getNgayTao(),pn.getDonGia()});
        }
        
        tblphieuxuat = new JTable(model);
        tblphieuxuat.addMouseListener(this);
        
        sptbl = new JScrollPane();
        sptbl.setViewportView(tblphieuxuat);
        
        pnlcontent.add(sptbl);
        
        this.add(pnlcontent,BorderLayout.CENTER);
        this.add(pnlheading,BorderLayout.NORTH);
        
        this.setVisible(true);
    }

    public Del_PhieuXuat() throws HeadlessException {
        initcomponent();
    }

    public void setPhieuxuat(DsPhieuxuat phieuxuat) {
        this.phieuxuat = phieuxuat;
    }

     public void selectitem(ArrayList<PhieuDTO> list){
        if(JOptionPane.showConfirmDialog(pnlcontent, "Bạn muốn hủy phiếu này ?","Hủy phiếu",JOptionPane.YES_NO_OPTION) ==0){
                this.index = tblphieuxuat.getSelectedRow();
                PhieuDTO del_phieu = list.get(index);
                ArrayList<PhieuDetailDTO> del_ctp = phieudetailbus.selectbyID(del_phieu.getMaPhieu(),del_phieu.getLoaiPhieu());
                    for(PhieuDetailDTO ctp : del_ctp){
                        ProductDetailDTO del_ctsp = productdetailbus.selectbyID(ctp.getMaSP(),ctp.getTenSP());
                        del_ctsp.setNgayXuat("null");
                        phieudetailbus.delPhieuDetail(ctp);
                        productdetailbus.refund(del_ctsp);
                    }
                    phieubus.delPhieuXuat(del_phieu);
            }
        phieuxuat.showdata(phieubus.getPhieuxuatlist());
        this.dispose();
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==tblphieuxuat){
            selectitem(phieubus.getPhieuxuatlist());
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
