/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhoHangDAO;
import DTO.KhoDTO;
import java.util.ArrayList;

public class KhoHangBUS {
    ArrayList<KhoDTO> listkho;
    KhoHangDAO khoDAO = new KhoHangDAO();
    
    public KhoHangBUS(){
        this.listkho = khoDAO.selectAll();
    }
    
    public ArrayList<KhoDTO> getListKho(){
        listkho.clear();
        listkho = khoDAO.selectAll();
        return listkho;
    }
    
}
