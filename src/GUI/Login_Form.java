/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.AccountBUS;
import DAO.AccountDAO;
import DTO.AccountDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author NAME
 */
public class Login_Form extends JPanel implements MouseListener {

    public static ArrayList<AccountDTO> acc_data = new ArrayList<>();
    
    public static Login_Frame login_frame;

    public static AccountDTO account;

    public static Label[] login_btn = new Label[2];
    public static Color hover_btn_color = new Color(80, 80, 150);
    public static Color btn_color = new Color(150, 150, 220);

    public static TextField login_textf = new TextField();
    public static JPasswordField login_passwd = new JPasswordField();
    public static Label[] login_label = new Label[3];

    public static Label login_title, login_form_name;

    public void initcomponent(Login_Frame f) throws SQLException {
//        LineBorder login_form_border = new LineBorder(new Color(100, 100, 100), 0, true);
        String[] login_label_name = {"Username", "Password", ""};
        String[] login_btn_name = {"Đăng nhập", "Quên mật khẩu ?"};
        
        login_frame = f;
        AccountBUS accbus = new AccountBUS();
        acc_data = accbus.getListaccount();
        Font notice_font = new Font("Times New Roman", Font.CENTER_BASELINE, 14);
        Font text_font = new Font("Times New Roman", Font.CENTER_BASELINE, 18);
        Font btn_font = new Font("Times New Roman", Font.CENTER_BASELINE, 15);

        this.setLayout(null);
        this.setBackground(Color.white);
//        login_form.setOpaque(true);

        login_title = new Label("KHO ĐỒNG HỒ");
        login_title.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 30));
        login_title.setForeground(Color.BLACK);
        login_title.setBounds(70, 30, 250, 50);
        login_title.setAlignment(1);

        login_form_name = new Label("Đăng nhập tài khoản");
        login_form_name.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 15));
        login_form_name.setForeground(new Color(100, 100, 100));
//        login_form_name.setBackground(Color.red);
        login_form_name.setBounds(70, 80, 250, 20);
        login_form_name.setAlignment(1);

        this.add(login_form_name);
        this.add(login_title);

        for (int i = 0; i < login_label_name.length; i++) {
            login_label[i] = new Label(login_label_name[i]);

            if (login_label_name[i].equals("") == false) {
                login_label[i].setFont(text_font);
                login_label[i].setBounds(60, 120 + (i * 50), 100, 50);
                login_label[i].setAlignment(1);

                this.add(login_label[i]);

            } else {
                login_label[i].setFont(notice_font);
                login_label[i].setForeground(new Color(215, 20, 20));
                login_label[i].setAlignment(1);
                login_label[i].setBounds(150, (120 + (i * 55)) - 10, 180, 30);

                this.add(login_label[i]);
            }
        }

        login_textf.setBounds(170, 120 + 15, 150, 20);
        login_textf.setText("hieuvt2381@gmail.com");

        login_passwd.setBounds(170, 170 + 15, 150, 20);
        login_passwd.setText("23");

        this.add(login_passwd);
        this.add(login_textf);

        for (int i = 0; i < login_btn_name.length; i++) {

            login_btn[i] = new Label(login_btn_name[i]);
            login_btn[i].setAlignment(1);
            login_btn[i].setBounds((70 + (i * 120)), 300, 100 + (40 * i), 30);
            login_btn[i].setFont(btn_font);
            login_btn[i].setBackground(btn_color);
            login_btn[i].setForeground(Color.WHITE);
            login_btn[i].addMouseListener(this);

            this.add(login_btn[i]);

        }

        

    }

    public static int checkinfo() {
        int check = -1;
        String pass = new String(login_passwd.getPassword());
        for (AccountDTO a : acc_data) {
            if (login_textf.getText().equals(a.getEmail())) {
                if (pass.equals(a.getPasswd())) {
                    account = a;
                    check = 1;
                } else {
                    check = 0;
                    login_label[2].setText("Sai mật khẩu");
                }
            }
        }
        if(check == -1){
            login_label[2].setText("Tài khoản không tồn tại");
        }
        return check;
    }

    public Login_Form(Login_Frame f) throws SQLException {
        initcomponent(f);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == login_btn[1]) {
            
            try {
                login_frame.setVisible(false);
                Forgot_Passwd_Form forgotpass = new Forgot_Passwd_Form(login_frame,account);
            } catch (IOException ex) {
                Logger.getLogger(Login_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == login_btn[0]) {
            
            if (checkinfo() == 1) {
                login_frame.dispose();
                try {
                    Main_Frame main_frame = new Main_Frame(account);
                } catch (IOException ex) {
                    Logger.getLogger(Login_Form.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Login_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        if (e.getSource() == login_btn[0]) {
            login_btn[0].setBackground(hover_btn_color);

        }
        if (e.getSource() == login_btn[1]) {
            login_btn[1].setBackground(hover_btn_color);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == login_btn[0]) {
            login_btn[0].setBackground(btn_color);

        }
        if (e.getSource() == login_btn[1]) {
            login_btn[1].setBackground(btn_color);

        }
    }
}
