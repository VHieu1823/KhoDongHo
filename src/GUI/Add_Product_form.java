/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author NAME
 */
public class Add_Product_form extends JFrame{
    
    public void initcomponent(){
        this.setSize(new Dimension(900,600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        this.setVisible(true);
    }

    public Add_Product_form() throws HeadlessException {
        initcomponent();
    }
    
    public static void main(String[] args) {
        new Add_Product_form();
    }
      
}
