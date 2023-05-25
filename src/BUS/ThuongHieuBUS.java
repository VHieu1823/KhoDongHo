/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ThuongHieuDAO;
import DTO.ThuongHieuDTO;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class ThuongHieuBUS {
    
    ThuongHieuDAO thuonghieudao = new ThuongHieuDAO();
    ArrayList<ThuongHieuDTO> thuonghieulist = new ArrayList<>();

    public ThuongHieuBUS() {
        thuonghieulist = thuonghieudao.selectAll();
    }
    
    public ArrayList<ThuongHieuDTO> getThuongHieuList(){
        return thuonghieulist;
    }
    
    public String[] getThuongHieuStringList(){
        String[] list = new String[thuonghieulist.size()];
        int i=0;
        for(ThuongHieuDTO thuonghieu : thuonghieulist){
            list[i]=thuonghieu.getTenthuonghieu();
            i++;
        }
        return  list;
    }
    
}
