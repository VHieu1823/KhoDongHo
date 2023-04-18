/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.PhieuDetailDTO;
import DAO.ChiTietPhieuDAO;
import java.util.ArrayList;
public class PhieuDetailBUS {
    ArrayList<PhieuDetailDTO> listctphieu;
    ChiTietPhieuDAO ctphieuDAO = new ChiTietPhieuDAO();
    
    public PhieuDetailBUS(){
        this.listctphieu = ctphieuDAO.selectAll();
    }
    
    
    public ArrayList<PhieuDetailDTO> getctphieu(){
        return listctphieu;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
