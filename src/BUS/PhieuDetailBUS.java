/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.PhieuDetailDTO;
import DAO.ChiTietPhieuDAO;
import DAO.PhieuDetailDAO;
import java.util.ArrayList;
public class PhieuDetailBUS {
    ArrayList<PhieuDetailDTO> listctphieu;
    PhieuDetailDAO ctphieuDAO = new PhieuDetailDAO();
    
    public PhieuDetailBUS(){
        this.listctphieu = ctphieuDAO.selectAll();
    }
    
    
    public ArrayList<PhieuDetailDTO> getctphieu(){
        return listctphieu;
    }
    public void addPhieuDetail(PhieuDetailDTO ctp){
        if(ctphieuDAO.insert(ctp)!=0){
            listctphieu.add(ctp);
        }
    }
    
    public void delPhieuDetail(PhieuDetailDTO ctp){
        if(ctphieuDAO.delete(ctp)!=0){
            listctphieu.remove(ctp);
        }
    }
    
    public ArrayList<PhieuDetailDTO> selectbyID(String maphieu,String loai){
        ArrayList<PhieuDetailDTO> list = new ArrayList<>();
        for(PhieuDetailDTO phieu : listctphieu){
            if(phieu.getMaPhieu().equals(maphieu) && phieu.getLoaiPhieu().equals(loai)){
                list.add(phieu);
            }
        }
        return list;
    }
    
    
    
    
    
    
    
    
    
}
