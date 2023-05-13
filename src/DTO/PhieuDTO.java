/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class PhieuDTO {
    String MaPhieu,LoaiPhieu,NguoiTao,NgayTao,DonGia;

    public String getMaPhieu() {
        return MaPhieu;
    }

    public String getLoaiPhieu() {
        return LoaiPhieu;
    }

    public String getNguoiTao() {
        return NguoiTao;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public String getDonGia() {
        return DonGia;
    }

    public void setMaPhieu(String MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public void setLoaiPhieu(String LoaiPhieu) {
        this.LoaiPhieu = LoaiPhieu;
    }

    public void setNguoiTao(String NguoiTao) {
        this.NguoiTao = NguoiTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public void setDonGia(String DonGia) {
        this.DonGia = DonGia;
    }

    public PhieuDTO(String MaPhieu, String LoaiPhieu, String NguoiTao, String NgayTao, String DonGia) {
        this.MaPhieu = MaPhieu;
        this.LoaiPhieu = LoaiPhieu;
        this.NguoiTao = NguoiTao;
        this.NgayTao = NgayTao;
        this.DonGia = DonGia;
    }

    public PhieuDTO() {
    }
    
    
    
    
}
