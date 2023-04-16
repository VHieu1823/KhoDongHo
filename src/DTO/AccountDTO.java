/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class AccountDTO {
    
    public String Email,Passwd,MaKho,MaNhomQuyen,MaNV;
    public int Status;

    public String getEmail() {
        return Email;
    }

    public String getMaNhomQuyen() {
        return MaNhomQuyen;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    

    public void setMaNhomQuyen(String MaNhomQuyen) {
        this.MaNhomQuyen = MaNhomQuyen;
    }

    public String getPasswd() {
        return Passwd;
    }

    public int getStatus() {
        return Status;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPasswd(String Passwd) {
        this.Passwd = Passwd;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getMaKho() {
        return MaKho;
    }

    

    public void setMaKho(String MaKho) {
        this.MaKho = MaKho;
    }

   

    public AccountDTO(String Email,String MaNV, String Passwd, int Status, String MaKho,String MaNhomQuyen) {
        this.Email = Email;
        this.Passwd = Passwd;
        this.MaKho = MaKho;
        this.MaNhomQuyen = MaNhomQuyen;
        this.Status = Status;
        this.MaNV = MaNV;
    }
    
    
    
    public AccountDTO() {
    }

    

    
    
    
    
    
    
    
    
}
