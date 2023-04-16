/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class NhaCungCap extends JPanel{
    
    JTable tblnhacungcap;
    
    JScrollPane spnhacungcap;
    
    DefaultTableModel model;
    
    JPanel pnltbl;
    
    public void initcomponent(){
        this.setOpaque(true);
        this.setLayout(new BorderLayout());
        
        pnltbl = new JPanel(new BorderLayout());
        pnltbl.setBorder(new EmptyBorder(10,0,0,0));
        
        spnhacungcap = new JScrollPane();
        
        tblnhacungcap = new JTable();
        
        model = new DefaultTableModel();
        
        model.addColumn("Mã nhà cung cấp");
        model.addColumn("Tên nhà cung cấp");
        model.addColumn("Email");
        model.addColumn("SDT");
        model.addColumn("Địa chỉ");
        
        tblnhacungcap.setModel(model);
        
        spnhacungcap.setViewportView(tblnhacungcap);
        
        pnltbl.add(spnhacungcap,BorderLayout.CENTER);
        
        this.add(pnltbl,BorderLayout.CENTER);
        
        
    }

    public NhaCungCap() {
        initcomponent();
    }
    
}
