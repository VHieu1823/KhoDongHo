/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietQuyenDAO;
import DTO.ChiTietQuyenDTO;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class ChiTietQuyenBUS {
    ArrayList<ChiTietQuyenDTO> quyenlist = new ArrayList<>();
    ChiTietQuyenDAO chitietquyendao = new ChiTietQuyenDAO();

    public ChiTietQuyenBUS() {
        this.quyenlist = chitietquyendao.selectAll();
    }
    
    public  ArrayList<ChiTietQuyenDTO> selectall(){
        return quyenlist;
    }

    public int addChiTietQuyen(ChiTietQuyenDTO ctq){
        int check = 0;
        if(chitietquyendao.insert(ctq)!=0){
            quyenlist.add(ctq);
            check = 1;
        }
        return check;
    }
    
    public  ArrayList<ChiTietQuyenDTO> getquyen(String MaNQ){
        
        ArrayList<ChiTietQuyenDTO> quyen = new ArrayList<>();
        for(ChiTietQuyenDTO ctq : quyenlist){
            if(ctq.getMaNQ().equals(MaNQ)){
                quyen.add(ctq);
            }
        }
        return quyen;
    }
    
    
    
}
