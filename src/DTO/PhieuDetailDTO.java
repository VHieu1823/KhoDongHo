/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class PhieuDetailDTO {
    String MaSP,TenSP,loaiPhieu,MaPhieu,DonGia;

    public String getMaSP() {
        return MaSP;
    }

    public String getMaPhieu() {
        return MaPhieu;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public void setMaPhieu(String MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public String getLoaiPhieu() {
        return loaiPhieu;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }
    
    
    
    public void setLoaiPhieu(String loaiPhieu) {
        this.loaiPhieu = loaiPhieu;
    }

    public String getDonGia() {
        return DonGia;
    }

    public void setDonGia(String DonGia) {
        this.DonGia = DonGia;
    }

    
    
    
    public PhieuDetailDTO() {
    }

    public PhieuDetailDTO( String MaSP,String TenSP, String loaiPhieu, String MaPhieu,String DonGia) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MaPhieu = MaPhieu;
        this.DonGia = DonGia;
        this.loaiPhieu = loaiPhieu;
    }
    
    
}
