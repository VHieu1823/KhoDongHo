/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChongNuocDAO;
import DTO.ChongNuocDTO;
import DTO.KichThuocDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    public ArrayList<ChongNuocDTO> getCNlist(){
        chongnuoclist = chongnuocdao.selectAll();
        return chongnuoclist;
    }
    public int add(ChongNuocDTO cndto){
        int check =0;
        int success = 0;
            for(ChongNuocDTO cn : chongnuoclist ){
            if(cn.getChongnuoc().equals(cndto.getChongnuoc()) ){
                JOptionPane.showMessageDialog(null, "Thuộc tính đã tồn tại"); 
                check =1;
                success = 0;
            }         
            }
            if( check == 0){
                if(chongnuocdao.insert(cndto)!=0){
                    chongnuoclist.add(cndto);
                    success = 1;
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }else{
                    success = 0;
                    JOptionPane.showMessageDialog(null, "Thêm không thành công");
            }
        }
        return success;
    }
    public void del(ChongNuocDTO cn){
        if(chongnuocdao.delete(cn)!=0){
              chongnuoclist.remove(cn);
               JOptionPane.showMessageDialog(null, "Xóa thành công");
         }else{
                JOptionPane.showMessageDialog(null, "Xóa không thành công");}
    }
    
    public ChongNuocDTO selectbyid(String stt){
        return chongnuocdao.selectById(stt);
    }

}
