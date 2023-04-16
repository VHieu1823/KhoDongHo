/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import component.Image;
import component.ImageScale;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @author NAME
 */
public class prd_ls_div extends JPanel{
    
    public void initcomponent() throws IOException{
        this.setOpaque(true);
        this.setBackground(Color.red);
        this.setLayout(new BorderLayout());
        ImageIcon img = ImageScale.scale_employee_img(Image.getImg("src\\product_img\\Rolex_daydate.jpg"), 240, 200);
        JLabel image = new JLabel(img);
        
        
        this.add(image,BorderLayout.NORTH);
    }

    public prd_ls_div() throws IOException {
        initcomponent();
    }
    
}
