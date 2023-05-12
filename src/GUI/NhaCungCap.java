/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.NhaCungCapBUS;
import DTO.NhaCungCapDTO;
import java.awt.BorderLayout;
import java.awt.Color;
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
public class NhaCungCap extends JPanel{
    
    JTable tblnhacungcap;
    
    JScrollPane spnhacungcap;
    
    DefaultTableModel model;
    
    JPanel pnltbl;
    
    ArrayList<NhaCungCapDTO> ncclist = new ArrayList<>();
    NhaCungCapBUS nhacungcapbus = new NhaCungCapBUS();
    
    public void initcomponent(){
        this.setOpaque(true);
        this.setLayout(new BorderLayout());
        ncclist = nhacungcapbus.getlistncc();
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
        
        for(NhaCungCapDTO ncc : ncclist){
            model.addRow(new Object[] {ncc.getMaNCC(),ncc.getTenNCC(),ncc.getEmail(),ncc.getHotLine(),ncc.getDiaChi()});
        }
        
        tblnhacungcap.setModel(model);
        
        spnhacungcap.setViewportView(tblnhacungcap);
        
        pnltbl.add(spnhacungcap,BorderLayout.CENTER);
        
        this.add(pnltbl,BorderLayout.CENTER);
        
        
    }
    
    public void showdata(ArrayList<NhaCungCapDTO> list ){
        for(NhaCungCapDTO ncc : list){
            model.addRow(new Object[] {ncc.getMaNCC(),ncc.getTenNCC(),ncc.getEmail(),ncc.getHotLine(),ncc.getDiaChi()});
        }
        ncclist = list;
    }

    public NhaCungCap() {
        initcomponent();
    }
    
}
