/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author NAME
 */
public class ImageScale {
    
    public static ImageIcon scale_employee_img(ImageIcon a){
        
        Image img = a.getImage();
        Image scaledImg = img.getScaledInstance(200, 260, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        
        return scaledIcon;
    }
    
}
