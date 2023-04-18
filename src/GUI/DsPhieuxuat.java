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
public class DsPhieuxuat extends JPanel{
    JTable tblphieuxuat;
    
    JScrollPane spphieuxuat;
    
    DefaultTableModel phieuxuatmodel;
    
    AccountDTO account;
    
    public void initcomponent(AccountDTO acc){
        this.setLayout(new GridLayout(1,2,10,10));
        this.setBorder(new EmptyBorder(10,10,0,25));
        
        account = acc;
        
        tblphieuxuat = new JTable();
        
        phieuxuatmodel = new DefaultTableModel();
        
        phieuxuatmodel.addColumn("Mã phiếu");
        phieuxuatmodel.addColumn("Người tạo");
        phieuxuatmodel.addColumn("Người nhận");
        phieuxuatmodel.addColumn("Ngày tạo");
        phieuxuatmodel.addColumn("Thành tiền");
        
        tblphieuxuat.setModel(phieuxuatmodel);
        
        spphieuxuat = new JScrollPane();
        
        spphieuxuat.setViewportView(tblphieuxuat);
        
        this.add(spphieuxuat);
        
    }

    public DsPhieuxuat(AccountDTO acc) {
        initcomponent(acc);
    }

    
}
