/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author NAME
 */
public class Image {
    
    public static ImageIcon getImg(String path) throws IOException{
        ImageIcon img = new ImageIcon(ImageIO.read(new File("src\\assets\\"+path)));
//        System.out.println();
        return img;
    }
    
}
