/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.NhanVienBUS;
import BUS.PhieuBUS;
import BUS.PhieuDetailBUS;
import BUS.ProductDetailBUS;
import DTO.AccountDTO;
import DTO.NhanVienDTO;
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
public class DsPhieu extends JPanel implements MouseListener{
    
    JTable tblphieunhap;
    
    JScrollPane spphieunhap;
    int index = -1;
    DefaultTableModel phieunhapmodel;
    ArrayList<PhieuDTO> phieunhaplist = new ArrayList<>();
    AccountDTO account;
    PhieuBUS phieubus = new PhieuBUS();
    ProductDetailBUS productdetailbus = new ProductDetailBUS();
    PhieuDetailBUS phieudetailbus = new PhieuDetailBUS();
    ArrayList<ProductDetailDTO> productlist = new ArrayList<>();
    ArrayList<PhieuDetailDTO> phieudetaillist = new ArrayList<>();
    NhanVienBUS nhanvienbus = new NhanVienBUS();
    public void initcomponent(AccountDTO acc){
        this.setLayout(new GridLayout(1,2,10,10));
        this.setBorder(new EmptyBorder(10,10,50,25));
        phieunhaplist = phieubus.getPhieunhaplist();
        account = acc;
        
        tblphieunhap = new JTable();
        
        phieunhapmodel = new DefaultTableModel();
        
        phieunhapmodel.addColumn("Mã phiếu");
        phieunhapmodel.addColumn("Người tạo");
        phieunhapmodel.addColumn("Ngày tạo");
        phieunhapmodel.addColumn("Thành tiền");
        
        for(PhieuDTO pn : phieunhaplist){
            NhanVienDTO nv = nhanvienbus.selectnhanvien(pn.getNguoiTao());
            System.out.println(pn.getNguoiTao());
            phieunhapmodel.addRow(new Object[] {pn.getMaPhieu(),nv.getTenNV(),pn.getNgayTao(),pn.getDonGia()});
        }
        
        tblphieunhap.setModel(phieunhapmodel);
        tblphieunhap.addMouseListener(this);
        
        spphieunhap = new JScrollPane();
        
        spphieunhap.setViewportView(tblphieunhap);
        
        this.add(spphieunhap);
    }
    
    public void showdata(ArrayList<PhieuDTO> list){
        phieunhapmodel.setRowCount(0);
        for(PhieuDTO pn : list){
            phieunhapmodel.addRow(new Object[] {pn.getMaPhieu(),pn.getNguoiTao(),pn.getNgayTao(),pn.getDonGia()});            
        }
        this.phieunhaplist = list;
    }

    public JTable getTblphieunhap() {
        return tblphieunhap;
    }

    public DefaultTableModel getPhieunhapmodel() {
        return phieunhapmodel;
    }
    
    public void selectitem(ArrayList<PhieuDTO> list){
        productlist.clear();
        index = tblphieunhap.getSelectedRow();
        PhieuDTO phieunhap = list.get(index);
        phieudetaillist = phieudetailbus.selectbyID(phieunhap.getMaPhieu(), phieunhap.getLoaiPhieu());
        for(PhieuDetailDTO phieu : phieudetaillist){
            productlist.add(productdetailbus.selectbyID(phieu.getMaSP(), phieu.getTenSP()));
        }
        ShowPhieu showphieu = new ShowPhieu("Phiếu nhập hàng", phieunhap,phieudetaillist, productlist);
    }
    
    public DsPhieu(AccountDTO acc) {
        initcomponent(acc);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==tblphieunhap){
            selectitem(phieunhaplist);
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
