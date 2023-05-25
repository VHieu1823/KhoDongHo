/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.XuatXuDAO;
import DTO.XuatXuDTO;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class XuatXuBUS {
    XuatXuDAO xuatxudao = new XuatXuDAO();
    ArrayList<XuatXuDTO> xuatxulist = new ArrayList<>();

    public XuatXuBUS() {
        xuatxulist = xuatxudao.selectAll();
    }

    public ArrayList<XuatXuDTO> getXuatxulist() {
        return xuatxulist;
    }
    
    public String[] getXuatxuStringList(){
        String[] list = new String[xuatxulist.size()];
        int i=0;
        for(XuatXuDTO xuatxu : xuatxulist){
            list[i] = xuatxu.getXuatxu();
            i++;
        }
        return list;
    }
    
}
