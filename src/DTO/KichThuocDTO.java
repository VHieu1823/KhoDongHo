/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class KichThuocDTO {
    String stt,kichthuoc;

    public String getKichthuoc() {
        return kichthuoc;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getStt() {
        return stt;
    }

    public void setKichthuoc(String kichthuoc) {
        this.kichthuoc = kichthuoc;
    }

    public KichThuocDTO(String stt, String kichthuoc) {
        this.stt = stt;
        this.kichthuoc = kichthuoc;
    }

    
    
}
