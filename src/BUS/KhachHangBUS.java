/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class KhachHangBUS {
    ArrayList<KhachHangDTO> listkhachhang;
    KhachHangDAO khachhangdao = new KhachHangDAO();
    
    public KhachHangBUS(){
        this.listkhachhang = khachhangdao.selectAll();
    }

    public ArrayList<KhachHangDTO> getListkhachhang() {
        return listkhachhang;
    }
    public void updateKH(KhachHangDTO a){
         
        
    }
    public void deleteKH(String ma){
          
    }
    
}
