/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.NhomQuyenBUS;
import DTO.NhomQuyenDTO;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class PhanQuyen extends JPanel implements MouseListener{
    
    JTable tblper;
    
    JScrollPane spper;
    
    DefaultTableModel model;
    
    ArrayList<NhomQuyenDTO> nhomquyenlist = new ArrayList<>();
    
    NhomQuyenBUS nhomquyenbus = new NhomQuyenBUS();
    int index = 0;
    public void initcomponent(){
        
        nhomquyenlist = nhomquyenbus.getNhomQuyenList();
        
        this.setOpaque(true);
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(5,5,0,20));
        
        tblper = new JTable();
        tblper.addMouseListener(this);
        
        model = new DefaultTableModel();
                
        model.addColumn("Mã nhóm quyền");
        model.addColumn("Tên nhóm quyền");
        
        for(NhomQuyenDTO nq : nhomquyenlist){
            model.addRow(new Object[] {nq.getMaNQ(),nq.getTenNQ()} );
        }
        
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

    public void showdata(ArrayList<NhomQuyenDTO> list){
        model.setRowCount(0);
        for(NhomQuyenDTO nq : list){
            model.addRow(new Object[] {nq.getMaNQ(),nq.getTenNQ()} );
        }
        nhomquyenlist = list;
    }

    public void selectitem(){
        index = tblper.getSelectedRow();
        NhomQuyenDTO nhomquyen = nhomquyenlist.get(index);
        Permission show_per_inf = new Permission("Chi tiết quyền",nhomquyen);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==tblper){
            selectitem();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
