/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.AccountDAO;
import DTO.AccountDTO;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class AccountBUS {
    
    ArrayList<AccountDTO> listaccount;
    AccountDAO accountDAO = new AccountDAO();
    
    public AccountBUS(){
        this.listaccount = accountDAO.selectAll();
    }

    public ArrayList<AccountDTO> getListaccount() {
        this.listaccount.clear();
        listaccount = accountDAO.selectAll();
        return listaccount;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
    
}
