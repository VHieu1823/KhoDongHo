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
    
    JTable tblphieunhap;
    
    JScrollPane spphieunhap;
    
    DefaultTableModel phieunhapmodel;
    
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
        
        this.add(spphieunhap);
    }

    public DsPhieu(AccountDTO acc) {
        initcomponent(acc);
    }
}
