/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class NhaCungCap extends JPanel{
    
    JTable tblnhacungcap;
    
    JScrollPane spnhacungcap;
    
    DefaultTableModel model;
    
    JPanel pnltbl;
    
    NhaCungCapDAO nccdao = new NhaCungCapDAO();
    ArrayList<NhaCungCapDTO> ncclist = new ArrayList<>();
    
    public void initcomponent(){
        
        ncclist = nccdao.selectAll();
        
        this.setOpaque(true);
        this.setLayout(new BorderLayout());
        
        pnltbl = new JPanel(new BorderLayout());
        pnltbl.setBorder(new EmptyBorder(10,0,0,0));
        
        spnhacungcap = new JScrollPane();
        
        tblnhacungcap = new JTable();
        
        model = new DefaultTableModel();
        
        model.addColumn("Mã nhà cung cấp");
        model.addColumn("Tên nhà cung cấp");
        model.addColumn("Địa chỉ");
        model.addColumn("Email");
        model.addColumn("Hotline");

        

        showdata(ncclist);
        
        spnhacungcap.setViewportView(tblnhacungcap);
        
        pnltbl.add(spnhacungcap,BorderLayout.CENTER);
        
        this.add(pnltbl,BorderLayout.CENTER);
        
        
    }
    public void showdata(ArrayList<NhaCungCapDTO> list){
        model.setRowCount(0);
        for(NhaCungCapDTO ncc : list){
            model.addRow(new Object[] {ncc.getMaNCC(),ncc.getTenNCC(),ncc.getDiaChi(),ncc.getEmail(),ncc.getHotLine()});
        }
        tblnhacungcap.setModel(model);
    }
    public DefaultTableModel getModel(){
           return  this.model; 
    }
    public JTable gettbl(){
        return  this.tblnhacungcap;
    }
    public void setNhaCungCapList(ArrayList<NhaCungCapDTO> list){
        ncclist = list;
    }
            
    public NhaCungCap() {
        initcomponent();
    }
    
}
