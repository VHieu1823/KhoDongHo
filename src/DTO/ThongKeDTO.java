/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class ThongKeDTO {
    String thoigian;
    int von,doanhthu,loinhuan;

    public ThongKeDTO() {
    }

    public ThongKeDTO(String thoigian, int von, int doanhthu, int loinhuan) {
        this.thoigian = thoigian;
        this.von = von;
        this.doanhthu = doanhthu;
        this.loinhuan = loinhuan;
    }

    public int getDoanhthu() {
        return doanhthu;
    }

    public int getLoinhuan() {
        return loinhuan;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setDoanhthu(int doanhthu) {
        this.doanhthu = doanhthu;
    }

    public void setLoinhuan(int loinhuan) {
        this.loinhuan = loinhuan;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public void setVon(int von) {
        this.von = von;
    }

    public int getVon() {
        return von;
    }

        
    
}
