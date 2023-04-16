/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class KhachHangDTO {
    String MaKH,TenKh,TongTien,SDT;

    public String getMaKH() {
        return MaKH;
    }

    public String getTenKh() {
        return TenKh;
    }

   

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setTenKh(String TenKh) {
        this.TenKh = TenKh;
    }

   

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTongTien() {
        return TongTien;
    }

    public void setTongTien(String TongTien) {
        this.TongTien = TongTien;
    }
    

    public KhachHangDTO() {
    }

    public KhachHangDTO(String MaKH, String TenKh,String SDT,String tongtien) {
        this.MaKH = MaKH;
        this.TenKh = TenKh;
        this.TongTien = tongtien;
        this.SDT = SDT;
    }
    
    
    
}
