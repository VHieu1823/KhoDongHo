/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class ChatLieuDTO {
    String chatlieu,loai,stt;

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getstt() {
        return stt;
    }

    public void setstt(String stt) {
        this.stt = stt;
    }
   
    public String getChatlieu() {
        return chatlieu;
    }

    public void setChatlieu(String chatlieu) {
        this.chatlieu = chatlieu;
    }

    public ChatLieuDTO(String chatlieu, String loai, String stt) {
        this.chatlieu = chatlieu;
        this.loai = loai;
        this.stt = stt;
    }

    
}
