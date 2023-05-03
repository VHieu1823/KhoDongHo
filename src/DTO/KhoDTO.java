/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class KhoDTO {
    String TenKho,DiaChi;

    public String getTenKho() {
        return TenKho;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setTenKho(String TenKho) {
        this.TenKho = TenKho;
    }


    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public KhoDTO(String TenKho,String DiaChi) {
        this.TenKho = TenKho;
        this.DiaChi = DiaChi;
    }
    
    public KhoDTO(){
        
    }
}
