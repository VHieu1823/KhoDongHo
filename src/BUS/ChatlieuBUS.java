/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChatlieuDAO;
import DTO.ChatLieuDTO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author NAME
 */
public class ChatlieuBUS {
    ChatlieuDAO chatlieudao = new ChatlieuDAO();
    String[] chatlieumatlist = new String[chatlieudao.getslmat()];
    String[] chatlieuvolist = new String[chatlieudao.getslcl()];
    ArrayList<ChatLieuDTO> chatlieulist = new ArrayList<>();
    

    public ChatlieuBUS() {
        this.chatlieumatlist = chatlieudao.selectmat();
        this.chatlieuvolist = chatlieudao.selectcl();
        chatlieulist = chatlieudao.selectAll();
    }

    public ArrayList<ChatLieuDTO> getChatlieulist(){
        chatlieulist = chatlieudao.selectAll();
        return chatlieulist;
    }
    public String[] getChatlieumatlist() {
        return chatlieumatlist;
    }

    public String[] getChatlieuvolist() {
        return chatlieuvolist;
    }
    public int add(ChatLieuDTO cldto){
        int check =0;
        int success = 0;
            for(ChatLieuDTO cl : chatlieulist ){
            if(cl.getChatlieu().equals(cldto.getChatlieu()) ){
                JOptionPane.showMessageDialog(null, "Chất liệu đã tồn tại"); 
                check =1;
                success = 0;
            }         
            }
            if( check == 0){
                if(chatlieudao.insert(cldto)!=0){
                    chatlieulist.add(cldto);
                    success = 1;
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }else{
                    success = 0;
                    JOptionPane.showMessageDialog(null, "Thêm không thành công");
            }
        }
        return success;
    }
    
    
    public void del(ChatLieuDTO cl){
        if(chatlieudao.delete(cl)!=0){
              chatlieulist.remove(cl);
               JOptionPane.showMessageDialog(null, "Xóa thành công");
         }else{
                JOptionPane.showMessageDialog(null, "Xóa không thành công");}
    }

    
    
    
    
    
    
}
