/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietQuyenDAO;
import DTO.ChiTietQuyenDTO;
import DTO.NhomQuyenDTO;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class ChiTietQuyenBUS {
    ArrayList<ChiTietQuyenDTO> quyenlist = new ArrayList<>();
    ChiTietQuyenDAO chitietquyendao = new ChiTietQuyenDAO();
    int[] per = new int[8];

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
    
    public int delChiTietQuyen(String manq){
        int check = 0;
        if(chitietquyendao.deletectq(manq)!=0){
            quyenlist = chitietquyendao.selectAll();
            check =1;
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
    
    public int[] getlistquyen(String manq){
        int i = 0;
        for(ChiTietQuyenDTO ctq : quyenlist){
            if(ctq.getMaNQ().equals(manq)){
                per[i] = ctq.getQuyen();
                i++;
            }
        }
        
        return per;
    }
    
    public int updateChiTietQuyen(int[] per,NhomQuyenDTO nq){
        int check = 1;
        int i=0;
        String[] per_name = {"KhachHang","NCC","NhanSu","NhapKho","PhanQuyen","SanPham","TaiKhoan","XuatKho"};
        for(ChiTietQuyenDTO ctq : getquyen(nq.getMaNQ())){
            ctq.setQuyen(per[i]);
                        System.out.println(ctq.getQuyen());
            if(chitietquyendao.update(ctq)==0){
                check = 0;
            }
            i++;
        }
        return check;
    }
    
    
}
