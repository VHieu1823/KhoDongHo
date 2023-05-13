/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;



public class NhaCungCapBUS {
     NhaCungCapDAO nccDAO = new NhaCungCapDAO();
<<<<<<< HEAD
    ArrayList<NhaCungCapDTO> listncc;
    ArrayList< NhaCungCapDTO> listallncc = new ArrayList<>();
=======
    ArrayList<NhaCungCapDTO> listncc =new ArrayList<>();
    ArrayList<NhaCungCapDTO> listallncc = new ArrayList<>();
    
>>>>>>> b5d61d900c04f4a2ad0927248e4241ce5d26512d
    
    
    public NhaCungCapBUS(){
        this.listncc = nccDAO.selectAll();
        
    }
    public ArrayList<NhaCungCapDTO> getarrncc(){
<<<<<<< HEAD
         listncc.clear();
         listallncc = nccDAO.selectAll();
         for(NhaCungCapDTO ncc: listallncc){
             listncc.add(ncc);
         }
         return listncc;
    
}
    
=======
        listncc.clear();
        listallncc =nccDAO.selectAll();
        for(NhaCungCapDTO ncc: listallncc){
            listncc.add(ncc);
        }
        return listncc;
    }
    
    public NhaCungCapDTO selectbyID(String tenncc){
        NhaCungCapDTO nhacungcap = new NhaCungCapDTO();
        for(NhaCungCapDTO ncc : listncc){
            if(ncc.getTenNCC().equals(tenncc)){
                nhacungcap = ncc;
                break;
            }
        }
        return nhacungcap;
    }
>>>>>>> b5d61d900c04f4a2ad0927248e4241ce5d26512d

    public ArrayList<NhaCungCapDTO>  getNCC (String TenNCC){
        ArrayList<NhaCungCapDTO> ncclist = new ArrayList<>();
        this.listncc.clear();
        this.listncc = nccDAO.selectAll();
        for(NhaCungCapDTO ncc : this.listncc){
              if(ncc.getTenNCC().equals(TenNCC)){
                  ncclist.add(ncc);
              }
            }      
        return ncclist;
        
    }
    
    public String[]  getlistNCC (){
        String[] ncclist = new String[this.listncc.size()];
        int i=0;
        for(NhaCungCapDTO ncc : this.listncc){
                  ncclist[i]=ncc.getTenNCC();
                  i++;
            }      
        return ncclist;
        
    }
    
    public ArrayList<NhaCungCapDTO> getlistnhcc(){
        return this.listncc;
    }
    
<<<<<<< HEAD
    public int addNCC(NhaCungCapDTO ncc){
=======
        public int addNCC(NhaCungCapDTO ncc){
>>>>>>> b5d61d900c04f4a2ad0927248e4241ce5d26512d
        int check =0;
        int success = 0;
            for(NhaCungCapDTO nccdto : listncc ){
            if(nccdto.getMaNCC().equals(ncc.getMaNCC()) ){
                JOptionPane.showMessageDialog(null, "Nhà cung cấp đã tồn tại"); 
                check =1;
                success = 0;
            }         
            }
            if( check == 0){
                if(nccDAO.insert(ncc)!=0){
                    listncc.add(ncc);
                    success = 1;
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }else{
                    success = 0;
                    JOptionPane.showMessageDialog(null, "Thêm không thành công");
            }
        }
        return success;
    }
<<<<<<< HEAD
    
    public void updatencc(NhaCungCapDTO a) {

        if(nccDAO.update(a) != 0){
            this.listncc.clear();
            this.listncc = nccDAO.selectAll();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            
        }
       else{
         JOptionPane.showMessageDialog(null, "Sửa không thành công");
        }
    }
       public void delncc(NhaCungCapDTO ncc){
=======

    public void updatencc(NhaCungCapDTO ncc) {
        if(nccDAO.update(ncc) != 0){
            listncc.clear();
            listncc = nccDAO.selectAll();
             JOptionPane.showMessageDialog(null, "Sửa thành công");
             }
        else{
           JOptionPane.showMessageDialog(null, "Sửa không thành công");
         }  
    }
    public void delncc(NhaCungCapDTO ncc){
>>>>>>> b5d61d900c04f4a2ad0927248e4241ce5d26512d
        if(nccDAO.delete(ncc)!=0){
              listncc.remove(ncc);
               JOptionPane.showMessageDialog(null, "Xóa thành công");
         }else{
                JOptionPane.showMessageDialog(null, "Xóa không thành công");}
    }
}
