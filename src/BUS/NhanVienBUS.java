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
    
}
