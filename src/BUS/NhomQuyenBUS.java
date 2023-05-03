/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhomQuyenDAO;
import DTO.NhomQuyenDTO;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class NhomQuyenBUS {
    
    ArrayList<NhomQuyenDTO> nhomquyen_list = new ArrayList<>();
    NhomQuyenDAO nhomquyendao = new NhomQuyenDAO();
    
    public ArrayList<NhomQuyenDTO> getNhomQuyenList(){
        nhomquyen_list.clear();
        nhomquyen_list = nhomquyendao.selectAll();
        
        return nhomquyen_list;
    }
    
}
