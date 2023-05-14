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
public class Add_outbound_form extends JFrame{
    
    public void initcomponent(NhanVienDTO nv,DsPhieuxuat dsphieuxuat) throws IOException{
        this.setSize(new Dimension(1400,750));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        XuatKho xuatkho = new XuatKho(nv,this);
        xuatkho.setDsphieuxuat_form(dsphieuxuat);
        this.add(xuatkho,BorderLayout.CENTER);
        
        this.setVisible(true);
    }

    public Add_outbound_form(NhanVienDTO nv,DsPhieuxuat dsphieuxuat) throws HeadlessException, IOException {
        initcomponent(nv,dsphieuxuat);
    }
    
    
}
