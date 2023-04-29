/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author NAME
 */
public class Update_Product_form extends JFrame{
    
    public void initcomponent(){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1000,600));
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        
        
        
        this.setVisible(true);
    }

    public Update_Product_form() throws HeadlessException {
        initcomponent();
    }
    
    public static void main(String[] args) {
        new Update_Product_form();
    }
    
}
