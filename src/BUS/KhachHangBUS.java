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
        listkhachhang =  khachhangdao.selectAll();
        return listkhachhang;
    }
    public KhachHangDTO selectbyid(String makh){
        KhachHangDTO khachhang = new KhachHangDTO();
        for(KhachHangDTO kh : listkhachhang){
            if(kh.getMaKH().equals(makh)){
                return kh;
            }
        }
        return khachhang;
    }
    
    
    public String[] getlistkhachhang() {
        String[] list = new String[listkhachhang.size()];
        int i=0;
        for(KhachHangDTO kh : listkhachhang){
            if(kh.getMaKH().equals("0"))
                continue;
            list[i] = kh.getMaKH()+"-"+kh.getTenKh();
            i++;
        }
        return list;
    }
    
    public ArrayList<KhachHangDTO> getKhachHanglist() {
        listkhachhang.clear();
        listallkhachhang= khachhangdao.selectAll();
        for(KhachHangDTO khachhang : listallkhachhang)
            {
                listkhachhang.add(khachhang);
            }
        return listkhachhang;
    }
    
    public void delkh(KhachHangDTO kh){
        if(khachhangdao.delete(kh) != 0 ){
           listkhachhang.remove(kh);
           JOptionPane.showMessageDialog(null, "Xóa thành công");
        }else{
                    JOptionPane.showMessageDialog(null, "Xóa không thành công");}
    }

    public int addKh(KhachHangDTO kh){
        int check =0;
        int success = 0;
            for(KhachHangDTO khdto : listkhachhang ){
            if(khdto.getMaKH().equals(kh.getMaKH()) ){
                JOptionPane.showMessageDialog(null, "Khách Hàng đã tồn tại"); 
                check =1;
                success = 0;
            }         
            }
            if( check == 0){
                if(khachhangdao.insert(kh)!=0){
                    listkhachhang.add(kh);
                    success = 1;
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }else{
                    success = 0;
                    JOptionPane.showMessageDialog(null, "Thêm không thành công");
            }
        }
        return success;
    }
    public void updatekh(KhachHangDTO a) {

        if(khachhangdao.update(a) != 0){
            this.listkhachhang.clear();
            this.listkhachhang = khachhangdao.selectAll();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            
        }
       else{
         JOptionPane.showMessageDialog(null, "Sửa không thành công");
        }
    }
    
}
