/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDatabase;

import java.sql.*;


/**
 *
 * @author NAME
 */
public class JDBCUtil {
    public static Connection openConnection(){
        Connection conn = null;
        
        try {
            
            String url = "jdbc:mySQL://localhost:3306/doanjv";
            String username = "root";
            String password = "";
            
            conn = DriverManager.getConnection(url,username,password);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return conn;
    }
    
    public static void closeConnection(Connection conn){
        
        try {
            if(conn != null){
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
