/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class ChiTietQuyenDTO {
    String MaChiTiet,MaNQ,TenChiTiet;
    int Quyen;

    public ChiTietQuyenDTO() {
    }

    public ChiTietQuyenDTO(String MaChiTiet, String MaNQ, String TenChiTiet,int Quyen) {
        this.MaChiTiet = MaChiTiet;
        this.MaNQ = MaNQ;
        this.Quyen = Quyen;
        this.TenChiTiet = TenChiTiet;
    }

    public String getMaChiTiet() {
        return MaChiTiet;
    }

    public String getMaNQ() {
        return MaNQ;
    }

    public int getQuyen() {
        return Quyen;
    }

    public String getTenChiTiet() {
        return TenChiTiet;
    }

    public void setQuyen(int Quyen) {
        this.Quyen = Quyen;
    }

    public void setTenChiTiet(String TenChiTiet) {
        this.TenChiTiet = TenChiTiet;
    }
    

    public void setMaChiTiet(String MaChiTiet) {
        this.MaChiTiet = MaChiTiet;
    }

    public void setMaNQ(String MaNQ) {
        this.MaNQ = MaNQ;
    }

   
    
    
}
