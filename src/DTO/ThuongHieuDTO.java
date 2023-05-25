/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class ThuongHieuDTO {
    
    String tenthuonghieu,mathuonghieu;

    public String getMathuonghieu() {
        return mathuonghieu;
    }

    public String getTenthuonghieu() {
        return tenthuonghieu;
    }

    public void setMathuonghieu(String mathuonghieu) {
        this.mathuonghieu = mathuonghieu;
    }

    public void setTenthuonghieu(String tenthuonghieu) {
        this.tenthuonghieu = tenthuonghieu;
    }

    public ThuongHieuDTO() {
    }

    public ThuongHieuDTO(String tenthuonghieu, String mathuonghieu) {
        this.tenthuonghieu = tenthuonghieu;
        this.mathuonghieu = mathuonghieu;
    }
    
    
    
}
