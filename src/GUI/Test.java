/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


//import DAO.AccountDAO;
//import DTO.AccountDTO;
//import java.awt.BorderLayout;
//import java.awt.Dimension;
//import java.io.IOException;
//import java.util.ArrayList;
//import javax.swing.JFrame;
//import java.util.Date;
//import java.util.Timer;
//import java.util.TimerTask;
///**
// *
// * @author NAME
// */
//public class Test extends JFrame{   
//    
//    
//    
//    public void initcomponent() throws IOException{
//        this.setLayout(new BorderLayout());
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setSize(new Dimension(1400,720));
//        this.setLocationRelativeTo(null);
//        
////        NhanVienDTO ab = new NhanVienDTO("001","Vuvana","Nam","a","23","0976717851","2","");
////        
//        AccountDTO b = new AccountDTO("heho", "001", "22", 1, "1", "002");
//        
//        ArrayList<AccountDTO> list = new AccountDAO().selectAll();
//        
//        NhapKho a = new NhapKho();
//        
//        this.add(a,BorderLayout.CENTER);
//        
//        this.setVisible(true);
//        
//        
//
//
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("hi");
//            }
//        };
//        long delay = 30000;
//        Timer timer = new Timer("Timer");
//        timer.schedule(timerTask, 0, delay);
//    }
//
//
//
//    public Test() throws IOException {
//        initcomponent();
//    }
//    
//    public static void main(String[] args) throws IOException {
//        new Test();
//    }
//    
//}
import java.awt.*;

import javax.swing.*;

public class Test extends JFrame {

    public Test() throws HeadlessException {
        final JPanel panel = new JPanel();
//        panel.setBorder(BorderFactory.createLineBorder(Color.red));
        panel.setPreferredSize(new Dimension(800, 600));
        
        String[] pnlname = {"QL Sản phẩm","QL Phiếu nhập","QL Phiếu xuất","QL Nhà cung cấp","QL Khách hàng","QL Nhân viên","QL Tài khoản","QL Phân quyền"};
        
        JPanel[] pnlper = new JPanel[8];
        
        Label[] lb = new Label[8];
        
        for(int i=0;i<8;i++){
            lb[i] = new Label(pnlname[i]);
            lb[i].setBounds(0,100*i,800,100);
            panel.add(lb[i]);
        }

        final JScrollPane scroll = new JScrollPane(panel);
        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(final String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().setVisible(true);
            }
        });
    }
}