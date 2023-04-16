/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DAO.AccountDAO;
import DTO.AccountDTO;
import static GUI.Forgot_Passwd_Form.btn_color;
import static GUI.Forgot_Passwd_Form.lblturnback;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



/**
 *
 * @author NAME
 */
public class Change_Pass_form extends JFrame implements MouseListener{
     
    public static Color hover_btn_color = new Color(80,80,150);
    public static Color btn_color = new Color(150,150,220);
    
    public static JPanel pnlchangepasswd;
    
    public static Label lbltitle,lblguide,lblnewpass,lblrewrite,lblnotice,lblsubmit;
    
    public static JLabel lblturnback;
    
    public static JTextField txtnewpass;
    
    public static JPasswordField txtrewite;
    
    AccountDTO account;
    
    Login_Frame login_frame;
    
    public void initcomponent(Login_Frame lgf,AccountDTO account) throws IOException{
        
        this.login_frame = lgf;
        this.account = account;
        
        Font lbl_txt_font = new Font("Times New Roman", Font.CENTER_BASELINE,16);
        
        this.setSize(new Dimension(400,400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setLayout(new BorderLayout());
        
        lbltitle = new Label("KHÔI PHỤC MẬT KHẨU");
        lbltitle.setPreferredSize(new Dimension(0,80));
        lbltitle.setBackground(btn_color);
        lbltitle.setAlignment(1);
        lbltitle.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,22));
        lbltitle.setForeground(Color.white);
        lbltitle.addMouseListener(this);
        
        pnlchangepasswd = new JPanel(null);
        pnlchangepasswd.setBackground(Color.white);
        pnlchangepasswd.setLayout(null);
        
        lblguide = new Label("Tạo mật khẩu mới");
        lblguide.setBounds(100,0,200,25);
        lblguide.setAlignment(1);
        lblguide.setForeground(new Color(100,100,100));
        lblguide.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 15));
        
        lblnewpass = new Label("Mật khẩu mới");
        lblnewpass.setAlignment(1);
        lblnewpass.setBounds(60,50,110,25);
        lblnewpass.setFont(lbl_txt_font);
        
        txtnewpass = new JTextField();
        txtnewpass.setBounds(180,50,160,25);
        
        lblrewrite = new Label("Nhập lại mật khẩu");
        lblrewrite.setAlignment(1);
        lblrewrite.setBounds(30,120,140,25);
        lblrewrite.setFont(lbl_txt_font);
        
        txtrewite = new JPasswordField();
        txtrewite.setBounds(180,120,160,25);
        
        lblnotice = new Label("");
        lblnotice.setForeground(new Color(215, 20, 20));
        lblnotice.setAlignment(0);
        lblnotice.setBounds(180,150,150,20);
        
        lblsubmit = new Label("XÁC NHẬN");
        lblsubmit.setBounds(150, 190, 100, 40);
        lblsubmit.setForeground(Color.WHITE);
        lblsubmit.setFont(lbl_txt_font);
        lblsubmit.setBackground(btn_color);
        lblsubmit.setAlignment(1);
        lblsubmit.addMouseListener(this);
          
        lblturnback = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\turnback.png"))));
        lblturnback.setBounds(30, 250, 50, 50);
        lblturnback.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
        lblturnback.setOpaque(true);
        lblturnback.setBackground(btn_color);
        lblturnback.setForeground(Color.white);
        lblturnback.addMouseListener(this);
        
        pnlchangepasswd.add(txtrewite);
        pnlchangepasswd.add(txtnewpass);
        pnlchangepasswd.add(lblnotice);
        pnlchangepasswd.add(lblrewrite);
        pnlchangepasswd.add(lblnewpass);
        pnlchangepasswd.add(lblguide);
        pnlchangepasswd.add(lblsubmit);
        pnlchangepasswd.add(lblturnback);
        
        this.add(lbltitle,BorderLayout.NORTH);
        this.add(pnlchangepasswd, BorderLayout.CENTER);
        this.setVisible(true);
    }
    
    public Change_Pass_form(Login_Frame lgf, AccountDTO a) throws IOException{
        initcomponent(lgf,a);
    }

//    public static void main(String[] args) {
//        Change_Pass_form a = new Change_Pass_form();
//    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == lblturnback){
            this.dispose();
            try {
                Forgot_Passwd_Form forgorpass = new Forgot_Passwd_Form(login_frame,this.account);
            } catch (IOException ex) {
                Logger.getLogger(Change_Pass_form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == lblsubmit){
            String pass = new String (txtrewite.getPassword());
            if(txtnewpass.getText().equals(pass)){
                AccountDAO a = new AccountDAO();
                a.update(this.account);
                lblnotice.setText("");
                this.dispose();
                login_frame.setVisible(true);
                JOptionPane.showMessageDialog(rootPane, "Đổi mật khẩu thành công!");
                
            }
            else{
                lblnotice.setText("mật khẩu không trùng khớp");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == lblturnback){
            lblturnback.setBackground(hover_btn_color);
        }
        if(e.getSource() == lblsubmit){
            lblsubmit.setBackground(hover_btn_color);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == lblturnback){
            lblturnback.setBackground(btn_color);
        }
        if(e.getSource() == lblsubmit){
            lblsubmit.setBackground(btn_color);
        }
    }
    
}
