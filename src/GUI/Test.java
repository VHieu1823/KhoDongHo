/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import DAO.AccountDAO;
import DTO.AccountDTO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author NAME
 */
public class Test extends JFrame{   
    
    
    
    public void initcomponent() throws IOException{
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(1400,720));
        this.setLocationRelativeTo(null);
        
//        NhanVienDTO ab = new NhanVienDTO("001","Vuvana","Nam","a","23","0976717851","2","");
//        
        AccountDTO b = new AccountDTO("heho", "001", "22", 1, "1", "002");
        
        ArrayList<AccountDTO> list = new AccountDAO().selectAll();
        
        NhapKho a = new NhapKho();
        
        this.add(a,BorderLayout.CENTER);
        
        this.setVisible(true);
        
        


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("hi");
            }
        };
        long delay = 30000;
        Timer timer = new Timer("Timer");
        timer.schedule(timerTask, 0, delay);
    }



    public Test() throws IOException {
        initcomponent();
    }
    
    public static void main(String[] args) throws IOException {
        new Test();
    }
    
}
