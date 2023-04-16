/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class EmployeeDTO {
    
    public String MaNV,TenNV,SDT,GioTinh,NgaySinh,Email,Img_dir;

    public String getEmail() {
        return Email;
    }

    public String getGioTinh() {
        return GioTinh;
    }

    public String getImg_dir() {
        return Img_dir;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setGioTinh(String GioTinh) {
        this.GioTinh = GioTinh;
    }

    public void setImg_dir(String Img_dir) {
        this.Img_dir = Img_dir;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public EmployeeDTO(){
        
    }

    public EmployeeDTO(String MaNV, String TenNV, String SDT, String GioTinh, String NgaySinh, String Email, String Img_dir) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.SDT = SDT;
        this.GioTinh = GioTinh;
        this.NgaySinh = NgaySinh;
        this.Email = Email;
        this.Img_dir = Img_dir;
    }
    
    
    
    
}
