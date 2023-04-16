/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import component.ImageScale;

/**
 *
 * @author NAME
 */
public class Account_info extends JPanel{
    
    
    public void initcomponent() throws IOException{
        this.setBounds(0,0,1400,720);
        this.setOpaque(true);
        this.setBackground(Color.red);
        this.setLayout(new BorderLayout());
        
        
        
        ImageIcon img =  ImageScale.scale_employee_img(new ImageIcon( ImageIO.read(new File("src\\img_employee\\vth.jpg"))));
        
        JLabel label = new JLabel(img);
        label.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        label.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.WHITE, 5),
            BorderFactory.createLineBorder(Color.BLACK, 5)));
        
        this.add(label,BorderLayout.CENTER);
    }
        
    public Account_info() throws IOException{
        initcomponent();
    }
}
