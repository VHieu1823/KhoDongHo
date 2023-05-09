/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class PhanQuyen extends JPanel{
    
    JTable tblper;
    
    JScrollPane spper;
    
    DefaultTableModel model;
    
    public void initcomponent(){
        this.setOpaque(true);
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(5,5,0,20));
        
        tblper = new JTable();
        
        model = new DefaultTableModel();
                
        model.addColumn("Mã nhóm quyền");
        model.addColumn("Tên nhóm quyền");
        
        tblper.setModel(model);
        
        spper = new JScrollPane();
        
        spper.setViewportView(tblper);
        
        this.add(spper,BorderLayout.CENTER);
        
    }

    public PhanQuyen() {
        initcomponent();
    }

    public JTable getTblper() {
        return tblper;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    
    
}
