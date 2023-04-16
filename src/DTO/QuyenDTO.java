/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class QuyenDTO {
    String MaQ,TenQ;

    public QuyenDTO() {
    }

    public QuyenDTO(String MaQ, String TenQ) {
        this.MaQ = MaQ;
        this.TenQ = TenQ;
    }

    public String getMaQ() {
        return MaQ;
    }

    public String getTenQ() {
        return TenQ;
    }

    public void setMaQ(String MaQ) {
        this.MaQ = MaQ;
    }

    public void setTenQ(String TenQ) {
        this.TenQ = TenQ;
    }
    
    
}
