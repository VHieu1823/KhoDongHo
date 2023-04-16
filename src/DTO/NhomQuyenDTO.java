/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class NhomQuyenDTO {
    String MaNQ,TenNQ;

    public NhomQuyenDTO() {
    }

    public NhomQuyenDTO(String MaNQ, String TenNQ) {
        this.MaNQ = MaNQ;
        this.TenNQ = TenNQ;
    }

    public String getMaNQ() {
        return MaNQ;
    }

    public String getTenNQ() {
        return TenNQ;
    }

    public void setMaNQ(String MaNQ) {
        this.MaNQ = MaNQ;
    }

    public void setTenNQ(String TenNQ) {
        this.TenNQ = TenNQ;
    }
    
}
