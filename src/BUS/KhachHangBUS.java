/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class KhachHangBUS {
    ArrayList<KhachHangDTO> listkhachhang;
    KhachHangDAO khachhangdao = new KhachHangDAO();
    
    public KhachHangBUS(){
        this.listkhachhang = khachhangdao.selectAll();
    }

    public ArrayList<KhachHangDTO> getListkhachhang() {
        return listkhachhang;
    }
    public boolean updateKH(String ma,String ten,String tuoi,String phai,String diachi,String sdt){
        if(ten.trim().equals("")){
            return false;
        }
        if(sdt.trim().equals("")){
            return false;
        }
        KhachHangDTO kh = new KhachHangDTO();
        kh.setTenKh(ten);
        kh.setSDT(sdt);
        kh.setDiaChi(diachi);
        kh.setGioiTinh(diachi);
        kh.setTuoi(tuoi);
        boolean up = khachhangdao.update(ma,kh);
        if(up){
            print("...");
        }else{
            print("...");
        }
    }
    public boolean deleteKH(String ma){
           boolean flag = false;
        try {
            int maKH = Integer.parseInt(ma);

            flag = khachhangdao.delete(maKH);
        } catch (Exception e) {
            print("Chua chon khach hang");
        }
        if (flag) {
            print("Sucess");
        } else {
            print("fail");
        }
        return flag;
    }
    
}
