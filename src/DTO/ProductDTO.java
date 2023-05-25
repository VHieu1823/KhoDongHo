/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class ProductDTO {
    String stt,TenSP,XuatSu,HinhAnh,ThuongHieu;
    int soluong;
    
    public String getThuongHieu() {
        return ThuongHieu;
    }

   

    public void setThuongHieu(String ThuongHieu) {
        this.ThuongHieu = ThuongHieu;
    }

    public String getTenSP() {
        return TenSP;
    }

    public String getXuatSu() {
        return XuatSu;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    
    

    public String getHinhAnh() {
        return HinhAnh;
    }

    
    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public void setXuatSu(String XuatSu) {
        this.XuatSu = XuatSu;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    
    

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    
    public ProductDTO() {
    }

    public ProductDTO(String stt,String TenSP, String XuatSu , String HinhAnh, String ThuongHieu,int soluong) {
        this.stt = stt;
        this.TenSP = TenSP;
        this.XuatSu = XuatSu;
        this.HinhAnh = HinhAnh;
        this.ThuongHieu = ThuongHieu;
        this.soluong = soluong;
    }

    

        
    
}
