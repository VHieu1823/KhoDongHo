/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class ChongNuocDTO {
    String stt,chongnuoc;

    public String getChongnuoc() {
        return chongnuoc;
    }

    public void setChongnuoc(String chongnuoc) {
        this.chongnuoc = chongnuoc;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getStt() {
        return stt;
    }

    public ChongNuocDTO(String stt, String chongnuoc) {
        this.stt = stt;
        this.chongnuoc = chongnuoc;
    }

        
}
