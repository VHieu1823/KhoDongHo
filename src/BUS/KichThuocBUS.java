/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KichThuocDAO;
import DTO.KichThuocDTO;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class KichThuocBUS {
    ArrayList<KichThuocDTO> kichthuoclist = new ArrayList<>();
    KichThuocDAO kichthuocdao = new KichThuocDAO();

    public KichThuocBUS() {
        kichthuoclist = kichthuocdao.selectAll();
    }
    public String[] getkichthuoclist(){
        int i=0;
        String[] chongnuoclist = new String[this.kichthuoclist.size()];
        for(KichThuocDTO kichthuoc : this.kichthuoclist){
            chongnuoclist[i]=kichthuoc.getKichthuoc();
            i++;
        }
        return chongnuoclist;
    }
    
}
