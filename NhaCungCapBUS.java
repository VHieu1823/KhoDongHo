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



public class NhaCungCapBUS {
     NhaCungCapDAO nccDAO = new NhaCungCapDAO();
    ArrayList<NhaCungCapDTO> listncc;
    
    
    public NhaCungCapBUS(){
        this.listncc = nccDAO.selectAll();
        
    }

    public ArrayList<NhaCungCapDTO>  getNCC (String TenNCC){
        ArrayList<NhaCungCapDTO> ncclist = new ArrayList<>();
        for(NhaCungCapDTO ncc : this.listncc){
              if(ncc.getTenNCC().equals(TenNCC)){
                  ncclist.add(ncc);
              }
            }      
        return ncclist;
        
    }
    
    public ArrayList<NhaCungCapDTO> getlistncc(){
        return this.listncc;
    }
    public boolean updatencc(String maNCC, String tenNCC, String diaChi, String dienThoai,String email) {
        if (tenNCC.trim().equals("")) {
            return false;
        }
        if (diaChi.trim().equals("")) {
            return false;
        }
        Pattern pattern = Pattern.compile("^\\d{10}$");
        if (!pattern.matcher(dienThoai).matches()) {
            return false;
        }

        int ma = Integer.parseInt(maNCC);

        NhaCungCapDTO ncc = new NhaCungCapDTO();
        ncc.setTenNCC(tenNCC);
        ncc.setDiaChi(diaChi);
        ncc.setHotLine(dienThoai);
        ncc.setEmail(email);
        
        boolean flag = nccDAO.update(maNCC,ncc);

        if (flag) {
            print("sucess");
        } else {
            print("fail");
        }
        return flag;
    }
}
