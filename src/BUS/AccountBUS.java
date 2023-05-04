/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.AccountDAO;
import DTO.AccountDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author NAME
 */
public class AccountBUS {
    
    ArrayList<AccountDTO> listaccount = new ArrayList<>();
    AccountDAO accountDAO = new AccountDAO();
    
    public AccountBUS(){
        this.listaccount = accountDAO.selectAll();
    }
 
    public void delAccount(AccountDTO acc){
        if(accountDAO.update(acc)!=0){
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        }
        else{
            JOptionPane.showMessageDialog(null, "Xóa không thành công");
        }
        this.listaccount.remove(acc);
        this.listaccount = accountDAO.selectAll();
    }
    
    public void addAccount(AccountDTO acc){
        if(accountDAO.insert(acc)!=0){
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        }
        else
            JOptionPane.showMessageDialog(null, "Thêm không thành công");
        this.listaccount.add(acc);
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
    
    public AccountDTO selectbyID(String manv){
        AccountDTO acc = new AccountDTO("","","",0,"","");
        for(AccountDTO a : listaccount){
            if(a.getMaNV().equals(manv)){
                acc = a;
                break;
            }
        }
        return acc;
    }
    
    public ArrayList<AccountDTO> getListaccount() {
        listaccount.clear();
        listaccount = accountDAO.selectAll();
        return this.listaccount;
    }
}
