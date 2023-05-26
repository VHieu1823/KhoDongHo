/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DoDayDAO;
import DTO.DoDayDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    public ArrayList<DoDayDTO> getDodaylist(){
        return dodaylist;
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
        public int add(DoDayDTO dddto){
        int check =0;
        int success = 0;
            for(DoDayDTO dd : dodaylist ){
            if(dd.getDoday().equals(dddto.getDoday()) ){
                JOptionPane.showMessageDialog(null, "Độ dày đã tồn tại"); 
                check =1;
                success = 0;
            }         
            }
            if( check == 0){
                if(dodaydao.insert(dddto)!=0){
                    dodaylist.add(dddto);
                    success = 1;
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }else{
                    success = 0;
                    JOptionPane.showMessageDialog(null, "Thêm không thành công");
            }
        }
        return success;
    }
    public void del(DoDayDTO dd){
        if(dodaydao.delete(dd)!=0){
              dodaylist.remove(dd);
               JOptionPane.showMessageDialog(null, "Xóa thành công");
         }else{
                JOptionPane.showMessageDialog(null, "Xóa không thành công");}
    }
    
    public DoDayDTO selectbyid(String stt){
        return dodaydao.selectById(stt);
    }
}
