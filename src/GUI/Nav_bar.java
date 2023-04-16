/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.ProductBUS;
import DTO.ProductDTO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAME
 */
public class Nav_bar extends JPanel implements MouseListener {

//    public static AccountDTO account; 
    JLabel lblstore_name;

    JTextField txtfind;

    JPanel pnltools, contentpanel;

    Menus_bar menu_bar;

    JLabel lblopenmenu, lbllogout, lblnews, lblmanager_info, lblfind, lbladd, lbldelete, lblchange;

    Color main_clr = new Color(150, 150, 220);
    Color hover_clr = new Color(140, 140, 200);

    Font nav_bar_txt_font = new Font("Times New Roman", Font.CENTER_BASELINE, 16);

    Main_Frame main_frame;
    
    sup_account_info supacc_form;
            
    CardLayout cl;
    
    JTable tblpnl;
    
    String pnlname;
    
    ProductBUS prdbus = new ProductBUS();
    
    DefaultTableModel model;

    public void initcomponent(Main_Frame f, Menus_bar mnb, JPanel pnlcontent) throws IOException {

//        account = a;
        menu_bar = mnb;
        main_frame = f;
        contentpanel = pnlcontent;
           

//        this.setBounds(0, 0, 1400, 80);
        this.setPreferredSize(new Dimension(1400,80));
        this.setBackground(main_clr);
//    S    this.setBorder(new LineBorder(new Color(98,98,98),1,true));
        this.setLayout(null);

        lblstore_name = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\storage_icon.png"))));
        lblstore_name.setBounds(110, 0, 150, 80);
        lblstore_name.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        txtfind = new JTextField();
        txtfind.setBounds(340, 25, 330, 30);
//        txtfind.setText("Tìm kiếm....");
        txtfind.setForeground(new Color(90, 90, 90));
//        txtfind.setFocusable(false);
        txtfind.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 14));
        txtfind.putClientProperty("JTextField.placeholderText", "Tìm kiếm....");
        txtfind.putClientProperty("JTextField.showClearButton", true);
//        txtfind.addFocusListener(this);
//        txtfind.addMouseListener(this);

        lblfind = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\find.png"))));
        lblfind.setBounds(680, 15, 50, 50);
        lblfind.setOpaque(true);
        lblfind.setBackground(main_clr);
        lblfind.addMouseListener(this);

        lblmanager_info = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\manager_info.png"))));
        lblmanager_info.setBounds(1200, 15, 50, 50);
        lblmanager_info.setOpaque(true);
        lblmanager_info.setBackground(main_clr);
        lblmanager_info.addMouseListener(this);

        lblnews = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\news.png"))));
        lblnews.setBounds(1260, 15, 50, 50);
        lblnews.setOpaque(true);
        lblnews.setBackground(main_clr);
        lblnews.addMouseListener(this);

        lbllogout = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\logout.png"))));
        lbllogout.setBounds(1320, 15, 50, 50);
        lbllogout.setOpaque(true);
        lbllogout.setBackground(main_clr);
        lbllogout.addMouseListener(this);

        pnltools = new JPanel(new FlowLayout(1, 30, 2));
        pnltools.setBounds(890, 12, 270, 56);
        LineBorder tools_border = new LineBorder(Color.white, 1, true);
        pnltools.setOpaque(true);
        pnltools.setBackground(main_clr);
        pnltools.setBorder(tools_border);

        Dimension tools_dimension = new Dimension(50, 50);
        lbladd = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\add.png"))));
        lbladd.setPreferredSize(tools_dimension);
        lbladd.setOpaque(true);
        lbladd.setBackground(main_clr);
        lbladd.addMouseListener(this);

        lbldelete = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\delete.png"))));
        lbldelete.setPreferredSize(tools_dimension);
        lbldelete.setOpaque(true);
        lbldelete.setBackground(main_clr);
        lbldelete.addMouseListener(this);

        lblchange = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\change.png"))));
        lblchange.setPreferredSize(tools_dimension);
        lblchange.setOpaque(true);
        lblchange.setBackground(main_clr);
        lblchange.addMouseListener(this);

        pnltools.add(lbladd);
        pnltools.add(lbldelete);
        pnltools.add(lblchange);

        lblopenmenu = new JLabel(new ImageIcon(ImageIO.read(new File("src\\assets\\menus.png"))));
        lblopenmenu.setOpaque(true);
        lblopenmenu.setBounds(20, 15, 50, 50);
        lblopenmenu.setBackground(main_clr);
        lblopenmenu.setFont(nav_bar_txt_font);
        lblopenmenu.addMouseListener(this);

        this.add(lblopenmenu);
        this.add(pnltools);
        this.add(lblfind);
        this.add(lblmanager_info);
        this.add(lblnews);
        this.add(lblstore_name);
        this.add(lbllogout);
        this.add(txtfind);
        
    }

    public Nav_bar(Main_Frame f, Menus_bar mnb, JPanel contentpanel) throws IOException {
        initcomponent(f, mnb, contentpanel);
    }

    public void getSupacc_form(sup_account_info a){
        this.supacc_form = a;
    }
    
    public void setcurrenttable(JTable tbl,String pnlname,DefaultTableModel md){
        this.tblpnl = tbl;
        this.pnlname = pnlname;
        this.model = md;
    }
    
    public void search(){
        ArrayList<ProductDTO> prdlist = prdbus.getPrdlist();
        switch (pnlname) {
            case "Sản phẩm":
                ArrayList<ProductDTO> list = new ArrayList<>();
                pnltools.setEnabled(false);
                model.setRowCount(0);
                for(ProductDTO prd : prdlist)
                    if(prd.getTenSP().contains(txtfind.getText())){   
                        list.add(prd);
                        model.addRow(new Object[] {prd.getTenSP(),prd.getXuatSu(),prd.getThuongHieu(),Integer.toString(prd.getSoluong())});
                    }   
                
                break;
            default:
                throw new AssertionError();
        }
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == lblfind){
            search();
        }
        if (e.getSource() == lbllogout) {
            int option = JOptionPane.showConfirmDialog(main_frame, "Bạn muốn đăng xuất ?", "Logout", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                main_frame.dispose();
                try {
                    Login_Frame login_frame = new Login_Frame();
                } catch (IOException ex) {
                    Logger.getLogger(Nav_bar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Nav_bar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == lblopenmenu) {
            if (menu_bar.getWidth() == 150) {
                try {
                    menu_bar.closeMenu(menu_bar);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Menus_bar.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (menu_bar.getWidth() == 0)
                        try {
                    menu_bar.openMenu(menu_bar);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Menus_bar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(e.getSource() != lblopenmenu){
            if (menu_bar.getWidth() == 150) {
                try {
                    menu_bar.closeMenu(menu_bar);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Menus_bar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(e.getSource() == lblmanager_info){
            if(supacc_form.getHeight() == 350){
                try {
                    supacc_form.closeMenu(supacc_form);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sup_account_info.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else {
                if (supacc_form.getHeight() == 0)
                        try {
                    supacc_form.openMenu(supacc_form);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sup_account_info.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(e.getSource() != lblmanager_info){
            if (supacc_form.getHeight() == 350) {
                try {
                    supacc_form.closeMenu(supacc_form);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sup_account_info.class.getName()).log(Level.SEVERE, null, ex);
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
        if (e.getSource() == lbllogout) {
            lbllogout.setBackground(hover_clr);
        }
        if (e.getSource() == lblnews) {
            lblnews.setBackground(hover_clr);
        }
        if (e.getSource() == lblmanager_info) {
            lblmanager_info.setBackground(hover_clr);
        }
        if (e.getSource() == lblfind) {
            lblfind.setBackground(hover_clr);
        }
        if (e.getSource() == lblfind) {
            lblfind.setBackground(hover_clr);
        }
        if (e.getSource() == lbladd) {
            lbladd.setBackground(hover_clr);
        }
        if (e.getSource() == lbldelete) {
            lbldelete.setBackground(hover_clr);
        }
        if (e.getSource() == lblchange) {
            lblchange.setBackground(hover_clr);
        }
        if (e.getSource() == lblopenmenu) {
            lblopenmenu.setBackground(hover_clr);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == lbllogout) {
            lbllogout.setBackground(main_clr);
        }
        if (e.getSource() == lblnews) {
            lblnews.setBackground(main_clr);
        }
        if (e.getSource() == lblmanager_info) {
            lblmanager_info.setBackground(main_clr);
        }
        if (e.getSource() == lblfind) {
            lblfind.setBackground(main_clr);
        }
        if (e.getSource() == lbladd) {
            lbladd.setBackground(main_clr);
        }
        if (e.getSource() == lbldelete) {
            lbldelete.setBackground(main_clr);
        }
        if (e.getSource() == lblchange) {
            lblchange.setBackground(main_clr);
        }
        if (e.getSource() == lblopenmenu) {
            lblopenmenu.setBackground(main_clr);
        }
    }

//    @Override
//    public void focusGained(FocusEvent e) {
//        if (e.getSource() == txtfind) {
//            if(menu_bar.getWidth()!=0){
//                try {
//                    menu_bar.closeMenu(menu_bar);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Nav_bar.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if (txtfind.getText().trim().equals("Tìm kiếm....")) {
//                txtfind.setText("");
//            }
//        }
//    }   
//    @Override
//    public void focusLost(FocusEvent e) {
//        if (e.getSource() == txtfind) {
//            if (txtfind.getText().trim().equals("")) {
//                txtfind.setText("Tìm kiếm....");
//                txtfind.setBounds(340, 25, 330, 30);
//                lblfind.setBounds(680, 15, 50, 50);
//            }
//
//        }
//    }

   
}
