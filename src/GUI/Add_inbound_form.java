/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.NhanVienDTO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author NAME
 */
public class Add_inbound_form extends JFrame{
    
    NhanVienDTO nhanvien;
    
    public void initcomponent(NhanVienDTO nhanvien,DsPhieu dsphieu) throws IOException{
        this.setSize(new Dimension(1400,750));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        this.nhanvien = nhanvien;
        
        NhapKho nhapkhoform = new NhapKho(this.nhanvien,dsphieu);
        nhapkhoform.setInboundfrom(this);
        this.add(nhapkhoform,BorderLayout.CENTER);
        
        this.setVisible(true);
    }

    public Add_inbound_form(NhanVienDTO nv,DsPhieu dsphieu) throws HeadlessException, IOException {
        initcomponent(nv,dsphieu);
    }
    
    
}
