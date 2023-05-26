/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author NAME
 */
public class DoDayDTO {
    String stt,doday;
    public String getDoday() {
        return doday;
    }

    public void setDoday(String doday) {
        this.doday = doday;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public DoDayDTO(String stt, String doday) {
        this.stt = stt;
        this.doday = doday;
    }
    
    
}
