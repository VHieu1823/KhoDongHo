/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.PhieuDTO;
import DAO.PhieuDAO;
import java.util.ArrayList;



public class PhieuBUS {
    ArrayList<PhieuDTO> listphieu;
    PhieuDAO phieuDAO = new PhieuDAO();
    
    public PhieuBUS(){
        this.listphieu = phieuDAO.selectAll();
    }
    public ArrayList<PhieuDTO> getlistPhieu(){
        return listphieu;
    }
}
