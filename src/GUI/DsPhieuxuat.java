/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import BUS.PhieuBUS;
import DTO.AccountDTO;
import DTO.PhieuDTO;
import java.awt.GridLayout;
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
public class DsPhieuxuat extends JPanel{
    JTable tblphieuxuat;
    
    JScrollPane spphieuxuat;
    
    DefaultTableModel phieuxuatmodel;
    NhanVienBUS nhanvienbus = new NhanVienBUS();
    AccountDTO account;
    PhieuBUS phieubus = new PhieuBUS();
    ArrayList<PhieuDTO> phieulist = new ArrayList<>();
    KhachHangBUS khachhangbus = new KhachHangBUS();
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
        
        spphieuxuat = new JScrollPane();
        
        spphieuxuat.setViewportView(tblphieuxuat);
        
        this.add(spphieuxuat);
        
    }
    
    public void showdata(ArrayList<PhieuDTO> list){
        for(PhieuDTO phieuxuat : list){
            phieuxuatmodel.addRow(new Object[] {phieuxuat.getMaPhieu(),nhanvienbus.selectnhanvien(phieuxuat.getNguoiTao()).getTenNV(),phieuxuat.getNguoiNhan(),phieuxuat.getNgayTao(),phieuxuat.getDonGia()});
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

    
}
