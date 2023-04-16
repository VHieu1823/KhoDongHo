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
    String MaChitiet,MaSP,loaiPhieu,MaPhieu;
    int Soluong;

    public String getMaChitiet() {
        return MaChitiet;
    }

    public String getMaSP() {
        return MaSP;
    }

    public String getMaPhieu() {
        return MaPhieu;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setMaChitiet(String MaChitiet) {
        this.MaChitiet = MaChitiet;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public void setMaPhieu(String MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public String getLoaiPhieu() {
        return loaiPhieu;
    }

    public void setLoaiPhieu(String loaiPhieu) {
        this.loaiPhieu = loaiPhieu;
    }

    
    
    
    public PhieuDetailDTO() {
    }

    public PhieuDetailDTO(String MaChitiet, String MaSP, String loaiPhieu, String MaPhieu, int Soluong) {
        this.MaChitiet = MaChitiet;
        this.MaSP = MaSP;
        this.MaPhieu = MaPhieu;
        this.Soluong = Soluong;
        this.loaiPhieu = loaiPhieu;
    }
    
    
}
