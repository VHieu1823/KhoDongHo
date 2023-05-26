/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KichThuocDAO;
import DTO.ChatLieuDTO;
import DTO.KichThuocDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    public ArrayList<KichThuocDTO> getKTlist(){
        kichthuoclist= kichthuocdao.selectAll();
        return kichthuoclist;
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
    public int add(KichThuocDTO ktdto){
        int check =0;
        int success = 0;
            for(KichThuocDTO cl : kichthuoclist ){
            if(cl.getKichthuoc().equals(ktdto.getKichthuoc()) ){
                JOptionPane.showMessageDialog(null, "Kích thước đã tồn tại"); 
                check =1;
                success = 0;
            }         
            }
            if( check == 0){
                if(kichthuocdao.insert(ktdto)!=0){
                    kichthuoclist.add(ktdto);
                    success = 1;
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }else{
                    success = 0;
                    JOptionPane.showMessageDialog(null, "Thêm không thành công");
            }
        }
        return success;
    }
    public void del(KichThuocDTO kt){
        if(kichthuocdao.delete(kt)!=0){
              kichthuoclist.remove(kt);
               JOptionPane.showMessageDialog(null, "Xóa thành công");
         }else{
                JOptionPane.showMessageDialog(null, "Xóa không thành công");}
    }
    
    public KichThuocDTO selectbyid(String stt){
        return kichthuocdao.selectById(stt);
    }
}
