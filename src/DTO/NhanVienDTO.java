/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class NhanVienDTO {
    String MaNV,TenNV,GioiTinh,DiaChi,NgayVao,SDT,NgaySinh,Img,HocVan;

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        this.Img = img;
    }
     public String getHocVan() {
        return HocVan;
    }

    public void setHocVan(String HocVan) {
        this.HocVan = HocVan;
    }
    
    
    public String getMaNV() {
        return MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    

    public String getNgayVao() {
        return NgayVao;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    

    public void setNgayVao(String NgayVao) {
        this.NgayVao = NgayVao;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getSDT() {
        return SDT;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    

    public NhanVienDTO(String MaNV, String TenNV, String GioiTinh, String DiaChi, String SDT,String NgaySinh, String NgayVao,String HocVan,String img) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.NgayVao = NgayVao;
        this.SDT = SDT;
        this.NgaySinh = NgaySinh;
        this.Img = img;
        this.HocVan = HocVan;
    }

    

    public NhanVienDTO() {
    }
    
    
}
