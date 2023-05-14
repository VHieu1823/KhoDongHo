/*
 * Click nbfs:nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs:nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author NAME
 */
public class Test{   
//public class Test extends JFrame{   

    
    
    public void initcomponent() throws IOException{
//        this.setLayout(new BorderLayout());
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setSize(new Dimension(1400,720));
//        this.setLocationRelativeTo(null);
//        
//        
//       
////        NhapKho a = new NhapKho();
//        
////        this.add(a,BorderLayout.CENTER);
//        
//        this.setVisible(true);
        int i=0;
        String t = "123-VTH";
        while (true) {            
            if(t.charAt(i)=='-'){
                System.out.println(i);
                break;
            }
            i++;
        }
        System.out.println(t.substring(0, i));
        System.out.println("Nhap: ");
        Scanner sc = new Scanner(System.in);
        String c = sc.nextLine();
        if(t.contains(c)){
            System.out.println("true");
        }
        else
            System.out.println("false");

//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("hi");
//            }
//        };
//        long delay = 30000;
//        Timer timer = new Timer("Timer");
//        timer.schedule(timerTask, 0, delay);
    }



    public Test() throws IOException {
        initcomponent();
    }
    
    public static void main(String[] args) throws IOException {
        new Test();
    }
    
}
