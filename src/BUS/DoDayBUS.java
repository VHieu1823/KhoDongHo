/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DoDayDAO;
import DTO.DoDayDTO;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class DoDayBUS {
    ArrayList<DoDayDTO> dodaylist = new ArrayList<>();
    DoDayDAO dodaydao = new DoDayDAO();

    public DoDayBUS() {
        dodaylist = dodaydao.selectAll();
    }
    
    public String[] getdodaylist(){
        int i=0;
        String[] dodaylist = new String[this.dodaylist.size()];
        for(DoDayDTO doday : this.dodaylist){
            dodaylist[i]=doday.getDoday();
            i++;
        }
        return dodaylist;
    }
    
}
