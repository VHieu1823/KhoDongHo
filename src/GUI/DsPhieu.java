/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.AccountDTO;
import java.awt.GridLayout;
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
    
    JTable tblphieuxuat,tblphieunhap;
    
    JScrollPane spphieuxuat,spphieunhap;
    
    DefaultTableModel phieuxuatmodel,phieunhapmodel;
    
    AccountDTO account;
    
    public void initcomponent(AccountDTO acc){
        this.setLayout(new GridLayout(1,2,10,10));
        this.setBorder(new EmptyBorder(10,10,0,25));
        
        account = acc;
        
        tblphieunhap = new JTable();
        
        phieunhapmodel = new DefaultTableModel();
        
        phieunhapmodel.addColumn("Mã phiếu");
        phieunhapmodel.addColumn("Người tạo");
        phieunhapmodel.addColumn("Ngày tạo");
        phieunhapmodel.addColumn("Thành tiền");
        
        tblphieunhap.setModel(phieunhapmodel);
        
        spphieunhap = new JScrollPane();
        
        spphieunhap.setViewportView(tblphieunhap);
        
        tblphieuxuat = new JTable();
        
        phieuxuatmodel = new DefaultTableModel();
        
        phieuxuatmodel.addColumn("Mã phiếu");
        phieuxuatmodel.addColumn("Người tạo");
        phieuxuatmodel.addColumn("Người nhập");
        phieuxuatmodel.addColumn("Ngày tạo");
        phieuxuatmodel.addColumn("Thành tiền");
        
        tblphieuxuat.setModel(phieuxuatmodel);
        
        spphieuxuat = new JScrollPane();
        
        spphieuxuat.setViewportView(tblphieuxuat);
        
        per_access();
        
    }
    
    public void per_access(){
        switch (account.getMaNhomQuyen()) {
            case "001":
                this.add(spphieunhap);
                this.add(spphieuxuat);
                break;
            
            default:
                throw new AssertionError();
        }
       
    }

    public DsPhieu(AccountDTO acc) {
        initcomponent(acc);
    }
}
