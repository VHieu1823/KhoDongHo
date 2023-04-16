/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author NAME
 */
public class lblmenu_item extends JLabel{
    Color main_color = new Color(246, 164, 82);
    Dimension items_menu_size = new Dimension(130, 40);
    EmptyBorder lblitem_border = new EmptyBorder(0,3,0,0);
    Font items_menu_font = new Font("Times New Roman", Font.CENTER_BASELINE, 18);
    Color lbl_clr = new Color(81,81,81);
    public void initcomponent(String name,ImageIcon icon){
            this.setText(name);
            this.setIcon(icon);
            this.setHorizontalAlignment(JLabel.LEFT);
            this.setBorder(lblitem_border);
            this.setOpaque(true);
            this.setForeground(lbl_clr);
            this.setPreferredSize(items_menu_size);
            this.setBackground(main_color);
            this.setFont(items_menu_font);
    }

    public lblmenu_item(String name,ImageIcon icon) {
        initcomponent(name,icon);
    }
    
    
}
