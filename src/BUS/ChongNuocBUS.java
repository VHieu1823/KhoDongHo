/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChongNuocDAO;
import DTO.ChongNuocDTO;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class ChongNuocBUS {
    ArrayList<ChongNuocDTO> chongnuoclist = new ArrayList<>();
    ChongNuocDAO chongnuocdao = new ChongNuocDAO();

    public ChongNuocBUS() {
        chongnuoclist = chongnuocdao.selectAll();
    }
    
    public String[] getchongnuoclist(){
        int i=0;
        String[] chongnuoclist = new String[this.chongnuoclist.size()];
        for(ChongNuocDTO chongnuoc : this.chongnuoclist){
            chongnuoclist[i]=chongnuoc.getChongnuoc();
            i++;
        }
        return chongnuoclist;
    }

}
