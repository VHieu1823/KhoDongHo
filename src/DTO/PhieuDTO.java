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
    String MaPhieu,LoaiPhieu,NguoiTao,NguoiNhan,NgayTao,MaKho,DonGia,NhaCungCap;

    public String getMaPhieu() {
        return MaPhieu;
    }

    public String getLoaiPhieu() {
        return LoaiPhieu;
    }

    public String getNguoiTao() {
        return NguoiTao;
    }

    public String getNguoiNhan() {
        return NguoiNhan;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public String getMaKho() {
        return MaKho;
    }

    public String getDonGia() {
        return DonGia;
    }

    public String getNhaCungCap() {
        return NhaCungCap;
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

    public void setNguoiNhan(String NguoiNhan) {
        this.NguoiNhan = NguoiNhan;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public void setMaKho(String MaKho) {
        this.MaKho = MaKho;
    }

    public void setDonGia(String DonGia) {
        this.DonGia = DonGia;
    }

    public void setNhaCungCap(String NhaCungCap) {
        this.NhaCungCap = NhaCungCap;
    }

    public PhieuDTO(String MaPhieu, String LoaiPhieu, String NguoiTao, String NguoiNhan, String NgayTao, String MaKho, String DonGia, String NhaCungCap) {
        this.MaPhieu = MaPhieu;
        this.LoaiPhieu = LoaiPhieu;
        this.NguoiTao = NguoiTao;
        this.NguoiNhan = NguoiNhan;
        this.NgayTao = NgayTao;
        this.MaKho = MaKho;
        this.DonGia = DonGia;
        this.NhaCungCap = NhaCungCap;
    }

    public PhieuDTO() {
    }
    
    
    
    
}
