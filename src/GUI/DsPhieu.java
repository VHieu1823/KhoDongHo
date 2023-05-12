/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

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
public class DsPhieu extends JPanel{
    
    JTable tblphieunhap;
    
    JScrollPane spphieunhap;
    
    DefaultTableModel phieunhapmodel;
    ArrayList<PhieuDTO> phieunhaplist = new ArrayList<>();
    AccountDTO account;
    PhieuBUS phieubus = new PhieuBUS();
    
    public void initcomponent(AccountDTO acc){
        this.setLayout(new GridLayout(1,2,10,10));
        this.setBorder(new EmptyBorder(10,10,0,25));
        phieunhaplist = phieubus.getPhieunhaplist();
        account = acc;
        
        tblphieunhap = new JTable();
        
        phieunhapmodel = new DefaultTableModel();
        
        phieunhapmodel.addColumn("Mã phiếu");
        phieunhapmodel.addColumn("Người tạo");
        phieunhapmodel.addColumn("Ngày tạo");
        phieunhapmodel.addColumn("Thành tiền");
        
        for(PhieuDTO pn : phieunhaplist){
            phieunhapmodel.addRow(new Object[] {pn.getMaPhieu(),pn.getNguoiTao(),pn.getNgayTao(),pn.getDonGia()});
        }
        
        tblphieunhap.setModel(phieunhapmodel);
        
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
    
    
    
    public DsPhieu(AccountDTO acc) {
        initcomponent(acc);
    }
}
