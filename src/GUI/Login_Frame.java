/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;



import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author NAME
 */
public class Login_Frame extends JFrame {

    BorderLayout Frame_Border = new BorderLayout();
    Dimension Frame_Size = new Dimension(800, 400);
    
    private void initcomponent() throws IOException, SQLException {
        this.setTitle("EO Store");
        this.setSize(Frame_Size);
        this.setLayout(Frame_Border);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setBackground(Color.yellow);
        this.setResizable(false);

        Login_Form login_form = new Login_Form(this);
        JPanel banner = Banner();

        this.add(banner, BorderLayout.WEST);
        this.add(login_form, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public Login_Frame() throws IOException, SQLException {
        initcomponent();
    }

    public JPanel Banner() throws IOException {

        JLabel lblimg = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\bglogin.png"))));
        JPanel banner = new JPanel();
        banner.setPreferredSize(new Dimension(400, 0));
        
        banner.add(lblimg);
        
        
        return banner;
    }

    

    public static void main(String[] args) throws UnsupportedLookAndFeelException, IOException, SQLException {
        UIManager.setLookAndFeel(new FlatIntelliJLaf());
        UIManager.put("Table.showVerticalLines", false);
        UIManager.put("Table.showHorizontalLines", true);
        UIManager.put("TextComponent.arc", 5);
        UIManager.put("ScrollBar.thumbArc", 999);
        UIManager.put("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));
        UIManager.put("Button.iconTextGap", 10);
        UIManager.put("PasswordField.showRevealButton", true);
        UIManager.put("Table.selectionBackground", new Color(240, 247, 250));
        UIManager.put("Table.selectionForeground", new Color(0, 0, 0));
        UIManager.put("Table.scrollPaneBorder", new EmptyBorder(0, 0, 0, 0));
        UIManager.put("Table.rowHeight", 40);
        UIManager.put("TabbedPane.selectedBackground", Color.white);
        UIManager.put("TableHeader.height", 40);
        UIManager.put("TableHeader.font", UIManager.getFont("h4.font"));
        UIManager.put("TableHeader.background", new Color(242, 242, 242));
        UIManager.put("TableHeader.separatorColor", new Color(242, 242, 242));
        UIManager.put("TableHeader.bottomSeparatorColor", new Color(242, 242, 242));
        Login_Frame a = new Login_Frame();
    }

}
