/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhomQuyenDAO;
import DTO.ChiTietQuyenDTO;
import DTO.NhomQuyenDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author NAME
 */
public class NhomQuyenBUS {
    
    ArrayList<NhomQuyenDTO> nhomquyen_list = new ArrayList<>();
    NhomQuyenDAO nhomquyendao = new NhomQuyenDAO();
    ChiTietQuyenBUS chitietquyenbus = new ChiTietQuyenBUS();

    public NhomQuyenBUS() {
        nhomquyen_list = nhomquyendao.selectAll();
    }
    
    public ArrayList<NhomQuyenDTO> getNhomQuyenList(){  
        return nhomquyen_list;
    }
    
    public String[] getStringlist(){
        String[] rs = new String[nhomquyen_list.size()];
        int i=0;
        for(NhomQuyenDTO nq : nhomquyen_list){
                rs[i] = nq.getTenNQ();
                i++;
        }
        return rs;
    }
    
    public NhomQuyenDTO selectbyId(String nhomquyen,String tennq){
        NhomQuyenDTO rs = new NhomQuyenDTO();
        for(NhomQuyenDTO nq : nhomquyen_list){
            if(nq.getMaNQ().equals(nhomquyen) || nq.getTenNQ().equals(tennq)){
                rs = nq;
                break;
            }
        }
        return rs;
    }
    
    public int addNhomQuyen(NhomQuyenDTO nq,int[] per){
        int success = 0;
        int check = 1;
        int mactq = chitietquyenbus.selectall().size()/8;
        String[] name = {"KhachHang","NCC","NhanSu","NhapKho","PhanQuyen","SanPham","TaiKhoan","XuatKho"};
        if (nhomquyendao.insert(nq)!=0){
            for(int i=0;i<8;i++){
                ChiTietQuyenDTO chitietquyen = new ChiTietQuyenDTO(Integer.toString(mactq+1), nq.getMaNQ(), name[i],per[i]);
                if(chitietquyenbus.addChiTietQuyen(chitietquyen)==0){
                    JOptionPane.showMessageDialog(null, "Lỗi không thể thêm quyền");
                    check = 0;
                    break;
                }
            }
            if(check == 1){
                nhomquyen_list.add(nq);
                success =1;
            }
        }
            
        return success;
    }
    
    public int delNhomQuyen(NhomQuyenDTO nq){
        int success = 0;
        if(chitietquyenbus.delChiTietQuyen(nq.getMaNQ())!=0){
            if(nhomquyendao.delete(nq)!=0){
                success=1;
                nhomquyen_list.remove(nq);
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            }
        }
        return success;
    }
    
    public void update(NhomQuyenDTO nq){
        if(nhomquyendao.update(nq)==0){
            JOptionPane.showMessageDialog(null, "Thay đổi không thành công");
        }
        else
            nhomquyen_list = nhomquyendao.selectAll();
    }
    
}
