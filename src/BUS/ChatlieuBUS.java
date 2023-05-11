/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChatlieuDAO;
import DTO.ChatLieuDTO;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class ChatlieuBUS {
    ChatlieuDAO chatlieudao = new ChatlieuDAO();
    String[] chatlieumatlist = new String[chatlieudao.getslmat()];
    String[] chatlieuvolist = new String[chatlieudao.getslcl()];

    public ChatlieuBUS() {
        this.chatlieumatlist = chatlieudao.selectmat();
        this.chatlieuvolist = chatlieudao.selectcl();
    }

    public String[] getChatlieumatlist() {
        return chatlieumatlist;
    }

    public String[] getChatlieuvolist() {
        return chatlieuvolist;
    }

    
    
    
    
    
    
}
