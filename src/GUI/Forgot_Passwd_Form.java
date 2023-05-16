/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.AccountBUS;
import DTO.AccountDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author NAME
 */
public class Forgot_Passwd_Form extends JFrame implements MouseListener {
    
    public static String Rancoded;

    public static Label lblTitle, lblrestore_code, lblgetcode, lblsubmit, lblemail;
    
    public static JLabel  lblturnback;

    public static Label[] lblnotice = new Label[2];

    public static JTextField txtemail, txtrestore_code;

    public static JPanel pnlGetaccess;

    public static Color hover_btn_color = new Color(80, 80, 150);
    public static Color btn_color = new Color(150, 150, 220);
    public static Color ntc_clr = new Color(215, 20, 20);
    
    Login_Frame login_frame;
    
    AccountDTO account;
    AccountBUS accountbus = new AccountBUS();
    public void initcomponent(Login_Frame lgf, AccountDTO a) throws IOException {

        Font lbl_txt_font = new Font("Times New Roman", Font.CENTER_BASELINE, 16);

        login_frame = lgf;
        this.account = a;
        
        this.setSize(new Dimension(400, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Quên mật khẩu");
        this.setLayout(new BorderLayout());
        this.setUndecorated(true);

        lblTitle = new Label("QUÊN MẬT KHẨU");
        lblTitle.setPreferredSize(new Dimension(0, 80));
        lblTitle.setBackground(new Color(150, 150, 220));
        lblTitle.setForeground(new Color(250, 250, 250));
        lblTitle.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 22));
        lblTitle.setAlignment(1);

        pnlGetaccess = new JPanel(null);
        pnlGetaccess.setBackground(new Color(255, 255, 255));
        pnlGetaccess.setLayout(null);

        lblemail = new Label("Email");
        lblemail.setAlignment(1);
        lblemail.setFont(lbl_txt_font);
//        lblemail.setBackground(Color.red);S
        lblemail.setBounds(60, 40, 50, 25);

        txtemail = new JTextField();
        txtemail.setBounds(120, 40, 210, 25);

        lblrestore_code = new Label("Code");
        lblrestore_code.setAlignment(1);
        lblrestore_code.setFont(lbl_txt_font);
//        lblrestore_code.setBackground(Color.red);
        lblrestore_code.setBounds(60, 120, 50, 25);

        txtrestore_code = new JTextField();
        txtrestore_code.setBounds(120, 120, 140, 25);

        for (int i = 0; i < lblnotice.length; i++) {
            lblnotice[i] = new Label();
            lblnotice[i].setBounds(120, 70 + (i * 80), 200 + (i * 60), 20);
            lblnotice[i].setForeground(ntc_clr);

            pnlGetaccess.add(lblnotice[i]);
        }

        lblgetcode = new Label("Lấy mã");
        lblgetcode.setBounds(270, 120, 60, 25);
        lblgetcode.setForeground(Color.WHITE);
        lblgetcode.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 14));
        lblgetcode.setBackground(btn_color);
        lblgetcode.setAlignment(1);
        lblgetcode.addMouseListener(this);

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

        pnlGetaccess.add(lblturnback);
        pnlGetaccess.add(lblsubmit);
        pnlGetaccess.add(lblgetcode);
        pnlGetaccess.add(lblemail);
        pnlGetaccess.add(txtemail);
        pnlGetaccess.add(lblrestore_code);
        pnlGetaccess.add(txtrestore_code);

        this.add(pnlGetaccess, BorderLayout.CENTER);
        this.add(lblTitle, BorderLayout.NORTH);

//        this.setUndecorated(true);
        this.setVisible(true);
    }

    public Forgot_Passwd_Form(Login_Frame f,AccountDTO a) throws IOException {
        initcomponent(f,a);
    }

    public void sendcode() {
        int Rancode = (int) (Math.random() * 9000) +1000;
        
        Rancoded =Integer.toString(Rancode);
        
         // Gmail username
        final String username = "heho2000101@gmail.com";
        
        // Gmail password
        final String password = "navhydqcymhrtzhs";
        
        // Receiver's email ID
        String receiver =txtemail.getText();

        // Sender's email ID
        String sender = "heho2000101@gmail.com";

        // Sending email from gmail
        String host = "smtp.gmail.com";

        // Port of SMTP
        String port = "587";

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        // Create session object passing properties and authenticator instance
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try
        {
            // Create MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set the Senders mail to From
            message.setFrom(new InternetAddress(sender));

            // Set the recipients email address
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

            // Subject of the email
            message.setSubject("Code to change password");

            // Body of the email
            message.setText(Rancoded+ " is Your Change Password Verification Code");

            // Send email.
            Transport.send(message);
            
            JOptionPane.showMessageDialog(rootPane, "Code has been send into your Email");
            
        } catch (MessagingException me)
        {
            me.printStackTrace();
        }
    
    }

//    public static void main(String[] args) {
//        Forgot_Passwd_Form a = new Forgot_Passwd_Form();
//    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == lblturnback) {
            this.dispose();
            login_frame.setVisible(true);
        }
        if(e.getSource() == lblgetcode){
            int check = 0;
            for(AccountDTO acc : accountbus.getListaccount()){
                if(acc.getEmail().equals(txtemail.getText())){
                    check = 1;
                    break;
                }
            }
            if(txtemail.getText().trim().equals("") == false && check ==1)
                sendcode();
            else{
                JOptionPane.showMessageDialog(null, "Tài khoản không tòn tại");
            }
        }
        if (e.getSource() == lblsubmit) {
            if (txtrestore_code.getText().trim().equals("") == false) {
                if(txtrestore_code.getText().equals(Rancoded)){
                    this.dispose();
                    try {
                        Change_Pass_form changepass = new Change_Pass_form(login_frame, account);
                    } catch (IOException ex) {
                        Logger.getLogger(Forgot_Passwd_Form.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    lblnotice[1].setText("Invalid code");
                }

            } else {
                lblnotice[1].setText("Invalid code");
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
        if (e.getSource() == lblgetcode) {
            lblgetcode.setBackground(hover_btn_color);
        }
        if (e.getSource() == lblsubmit) {
            lblsubmit.setBackground(hover_btn_color);
        }
        if (e.getSource() == lblturnback) {
            lblturnback.setBackground(hover_btn_color);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == lblgetcode) {
            lblgetcode.setBackground(btn_color);
        }
        if (e.getSource() == lblsubmit) {
            lblsubmit.setBackground(btn_color);
        }
        if (e.getSource() == lblturnback) {
            lblturnback.setBackground(btn_color);
        }
    }
}
