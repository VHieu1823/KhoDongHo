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
import DTO.AccountDTO;
import DTO.PhieuDTO;
import DTO.PhieuDetailDTO;
import DTO.ProductDetailDTO;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class DsPhieuxuat extends JPanel implements MouseListener{
    JTable tblphieuxuat;
    
    JScrollPane spphieuxuat;
    
    DefaultTableModel phieuxuatmodel;
    NhanVienBUS nhanvienbus = new NhanVienBUS();
    AccountDTO account;
    PhieuBUS phieubus = new PhieuBUS();
    ArrayList<PhieuDTO> phieulist = new ArrayList<>();
    KhachHangBUS khachhangbus = new KhachHangBUS();
    int index = -1;
    ArrayList<PhieuDetailDTO> phieudetaillist = new ArrayList<>();
    PhieuDetailBUS phieudetailbus = new PhieuDetailBUS();
    ArrayList<ProductDetailDTO> productlist = new ArrayList<>();
    ProductDetailBUS productdetailbus= new ProductDetailBUS();
    public void initcomponent(AccountDTO acc){
        this.setLayout(new GridLayout(1,2,10,10));
        this.setBorder(new EmptyBorder(10,10,50,25));
        
        account = acc;
        phieulist = phieubus.getPhieuxuatlist();
        tblphieuxuat = new JTable();
        
        phieuxuatmodel = new DefaultTableModel();
        
        phieuxuatmodel.addColumn("Mã phiếu");
        phieuxuatmodel.addColumn("Người tạo");
        phieuxuatmodel.addColumn("Người nhận");
        phieuxuatmodel.addColumn("Ngày tạo");
        phieuxuatmodel.addColumn("Thành tiền");
        
        for(PhieuDTO phieuxuat : phieulist){
            phieuxuatmodel.addRow(new Object[] {phieuxuat.getMaPhieu(),nhanvienbus.selectnhanvien(phieuxuat.getNguoiTao()).getTenNV(),khachhangbus.selectbyid(phieuxuat.getNguoiNhan()).getTenKh(),phieuxuat.getNgayTao(),phieuxuat.getDonGia()});
        }
        
        tblphieuxuat.setModel(phieuxuatmodel);
        tblphieuxuat.addMouseListener(this);
        
        spphieuxuat = new JScrollPane();
        
        spphieuxuat.setViewportView(tblphieuxuat);
        
        this.add(spphieuxuat);
        
    }
    
    public void showdata(ArrayList<PhieuDTO> list){
        phieuxuatmodel.setRowCount(0);
        for(PhieuDTO phieuxuat : list){
            phieuxuatmodel.addRow(new Object[] {phieuxuat.getMaPhieu(),nhanvienbus.selectnhanvien(phieuxuat.getNguoiTao()).getTenNV(),khachhangbus.selectbyid(phieuxuat.getNguoiNhan()).getTenKh(),phieuxuat.getNgayTao(),phieuxuat.getDonGia()});
        }
        phieulist = list;
    }

    public DefaultTableModel getPhieuxuatmodel() {
        return phieuxuatmodel;
    }

    public JTable getTblphieuxuat() {
        return tblphieuxuat;
    }
    
    
    public DsPhieuxuat(AccountDTO acc) {
        initcomponent(acc);
    }

    public void selectitem(ArrayList<PhieuDTO> list){
        productlist.clear();
        index = tblphieuxuat.getSelectedRow();
        PhieuDTO phieunhap = list.get(index);
        phieudetaillist = phieudetailbus.selectbyID(phieunhap.getMaPhieu(), phieunhap.getLoaiPhieu());
        for(PhieuDetailDTO phieu : phieudetaillist){
            productlist.add(productdetailbus.selectbyID(phieu.getMaSP(), phieu.getTenSP()));
        }
        ShowPhieu showphieu = new ShowPhieu("Phiếu xuất hàng", phieunhap,phieudetaillist, productlist);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==tblphieuxuat){
            selectitem(phieulist);
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
