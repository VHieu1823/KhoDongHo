/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.lang.reflect.Array;


import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author NAME
 */
public class NhanVienBUS {
    
    ArrayList<NhanVienDTO> listnhanvien = new ArrayList<>();
    ArrayList<NhanVienDTO> listallnhv = new ArrayList<>();
    NhanVienDAO nhanviendao = new NhanVienDAO();

    public NhanVienBUS(){
        listnhanvien = nhanviendao.selectAll();
    }
    public  ArrayList<NhanVienDTO> getNhanvienList() {
        this.listnhanvien.clear();
         this.listallnhv = nhanviendao.selectAll();
         for(NhanVienDTO nhv : listallnhv){   
                listnhanvien.add(nhv);

        }
         
        return listnhanvien;
  
    }
    
        
    public int addNhanVien(NhanVienDTO nhv){
        int check =0;
        int success = 0;
        if(nhv.getMaNV().equals("") || nhv.getTenNV().equals("") || nhv.getDiaChi().equals("")){
            JOptionPane.showMessageDialog(null, "Thiếu thông tin");
            success = 0;
        }
        else{
            for(NhanVienDTO nvdto : listnhanvien ){
            if(nvdto.getMaNV().equals(nhv.getMaNV()) ){
                JOptionPane.showMessageDialog(null, "Nhân viên đã tồn tại"); 
                check =1;
                success = 0;
            }         
            }
            if( check == 0){
                if(nhanviendao.insert(nhv)!=0){
                    listnhanvien.add(nhv);
                    success = 1;
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }else{
                    success = 0;
                    JOptionPane.showMessageDialog(null, "Thêm không thành công");}
            }
        }
        return success;
    }
    
    
     
    public NhanVienDTO selectnhanvien(String MaNV){
        NhanVienDTO target = new NhanVienDTO();
        for(NhanVienDTO nhanvien : listnhanvien){
            if(nhanvien.getMaNV().equals(MaNV)){
                return nhanvien;
            }
        }
        return target;
    }
    public void updatenv(NhanVienDTO nhv){
     if(nhanviendao.update(nhv) != 0){
         this.listallnhv.clear();
         this.listallnhv = nhanviendao.selectAll();
         JOptionPane.showMessageDialog(null, "Sửa thành công");

         }
     else{
         JOptionPane.showMessageDialog(null, "Sửa không thành công");

     }
    }
    public void deletenv(NhanVienDTO nhanvien){
        int del = 0;
        for(NhanVienDTO nhv : listallnhv){
            if(nhv.getMaNV().equals(nhanvien.getMaNV())){
                del = 1;
                break;
            }
        }
        if( del == 1){
                if(nhanviendao.delete(nhanvien)!=0){
                    listnhanvien.remove(nhanvien);
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                }else{
                    JOptionPane.showMessageDialog(null, "Xóa không thành công");}
        }
        else{
            JOptionPane.showMessageDialog(null, "Nhan Vien không tồn tại");
            }
       
     }
}
