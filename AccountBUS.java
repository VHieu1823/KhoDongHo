/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import ConnectDatabase.JDBCUtil;
import DAO.AccountDAO;
import DTO.AccountDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class AccountBUS {
    
    ArrayList<AccountDTO> listaccount;
    AccountDAO accountDAO = new AccountDAO();
    
    public AccountBUS() throws SQLException{
        this.listaccount = accountDAO.selectAll();
    }

    public ArrayList<AccountDTO> getListaccount() {
        return listaccount;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
    
}
