/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.PhieuDTO;
import DAO.PhieuDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class PhieuBUS {
    ArrayList<PhieuDTO> listphieu;
    PhieuDAO phieuDAO = new PhieuDAO();
    ArrayList<PhieuDTO> phieunhaplist = new ArrayList<>();
    ArrayList<PhieuDTO> phieuxuatlist = new ArrayList<>();

    public PhieuBUS(){
        this.listphieu = phieuDAO.selectAll();
        phieunhaplist = phieuDAO.selectphieunhap();
        phieuxuatlist = phieuDAO.selectphieuxuat();
    }

    public ArrayList<PhieuDTO> getListphieu() {
        return listphieu;
    }

    public ArrayList<PhieuDTO> getPhieunhaplist() {
        return phieunhaplist;
    }
    

    public ArrayList<PhieuDTO> getPhieuxuatlist() {
        return phieuxuatlist;
    }
    
    public void addPhieuNhap(PhieuDTO phieu){
        if(phieuDAO.insert(phieu)!=0){
            listphieu.add(phieu);
            phieunhaplist.add(phieu);
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        }
    }
    public void addPhieuXuat(PhieuDTO phieu){
        if(phieuDAO.insert(phieu)!=0){
            listphieu.add(phieu);
            phieuxuatlist.add(phieu);
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        }
    }
    
    public void delPhieuNhap(PhieuDTO phieu){
        if(phieuDAO.delete(phieu)!=0){
            listphieu.remove(phieu);
            phieunhaplist.remove(phieu);
            JOptionPane.showMessageDialog(null, "Hủy phiếu thành công");
        }
    }
    
    public void delPhieuXuat(PhieuDTO phieu){
        if(phieuDAO.delete(phieu)!=0){
            listphieu.remove(phieu);
            phieuxuatlist.remove(phieu);
            JOptionPane.showMessageDialog(null, "Hủy phiếu thành công");
        }
    }
    
}
