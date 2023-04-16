/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

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
public class Lib_Form extends JPanel{
    
    DefaultTableModel model;
    
    JTable tbllib;
    
    JScrollPane splib;
    
    public void initcomponent(){
        this.setOpaque(true);
        this.setBackground(null);
        this.setLayout(new GridLayout(1,1));
        this.setBorder(new EmptyBorder(5,5,0,20));
        
        this.tbllib = new JTable();
        
        this.model = new DefaultTableModel();
        
        for(int i = 1;i<=4;i++){
            this.model.addColumn(i);
        }
        
        this.tbllib.setModel(model);
        
        splib = new JScrollPane();
        splib.setViewportView(this.tbllib);
        
        
        this.add(splib);
        
        
    }
    
    public JTable gettbl(){
        return this.tbllib;
    }
    
    public DefaultTableModel getModel(){
        return this.model;
    }
    
    private void desplaydetails(int selectedRows){
    }
    
    public Lib_Form(){
        initcomponent();
    }
    
    public static void main(String[] args) {
        Lib_Form a = new Lib_Form();
    }
    
}
