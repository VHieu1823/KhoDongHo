/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;

import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class NhanVienBUS {
    
    ArrayList<NhanVienDTO> listnhanvien;
    NhanVienDAO nhanviendao = new NhanVienDAO();

    public NhanVienBUS() {
        this.listnhanvien = nhanviendao.selectAll();
    }
    
    public ArrayList<NhanVienDTO> getNhanVienList(){
        this.listnhanvien.clear();
        listnhanvien = nhanviendao.selectAll();
        return listnhanvien;
    }
    
    public NhanVienDTO selectnhanvien(String MaNV){
        NhanVienDTO target = new NhanVienDTO();
        for(NhanVienDTO nhanvien : listnhanvien){
            if(nhanvien.getMaNV().equals(MaNV)){
                target = nhanvien;
                break;
            }
        }
        return target;
    }
     
    public NhanVienDTO selectbyid(String MaNV){
        NhanVienDTO target = new NhanVienDTO();
        target = nhanviendao.select(MaNV);
        return target;
    }
//    public boolean updatenv(String ma,String ten,String hocvan, String phai, String diachi, String ngayvao, String SDT,String ngaysinh,String img){
//        if(ten.trim().equals("")){
//            return false;
//        }
//        if(phai.trim().equals("")){
//            return false;
//        }
//        if(img.trim().equals("")){
//            return false;
//        }
//        if(ngayvao.trim().equals("")){
//            return false;
//        }
//        NhanVienDTO nv= new NhanVienDTO();
//        nv.setTenNV(ten);
//        nv.setGioiTinh(phai);
//        nv.setDiaChi(diachi);
//        nv.setImg(img);
//        nv.setNgaySinh(ngaysinh);
//        nv.setNgayVao(ngayvao);
//        int up = nhanviendao.update(ma,nv);
//        if(up){
//
//        }else
//        {
//
//        }
//        return up;
//    }
//    public boolean deletenv(String ma){
//        boolean del = false;
//        try{
//            String MaNV = ma;
//            del = nhanviendao.delete(MaNV);
//            
//        }catch (Exception e){
//            
//        }
//        if(del != 0){
//            
//        }
//    }
}
