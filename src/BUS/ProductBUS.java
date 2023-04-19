/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ProductDAO;
import DTO.ProductDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author NAME
 */
public class ProductBUS {
    ArrayList<ProductDTO> prdlistall = new ArrayList<>();
    ArrayList<ProductDTO> prdlist = new ArrayList<>();
    ProductDAO prddao = new ProductDAO();

    public ArrayList<ProductDTO> getPrdlist(String kho) {
        for(ProductDTO prd : prdlistall){
            if(prd.getKho().equals(kho)){
                prdlist.add(prd);
            }
        }
        return prdlist;
    }
    
    public void addProduct(ProductDTO prd){
        int check =0;
        for(ProductDTO product : prdlistall){
            if(product.getTenSP().equals(prd.getTenSP()) && product.getKho().equals(prd.getKho())){
                JOptionPane.showMessageDialog(null, "Sản phẩm đã tồn tại"); 
                check =1;
            }         
        }
        if( check == 0){
                if(prddao.insert(prd)!=0){
                    prdlist.add(prd);
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }else{
                    JOptionPane.showMessageDialog(null, "Thêm không thành công");}
        }
    }
    
    public void deleteProduct(ProductDTO prd){
        int check =0;
        for(ProductDTO product : prdlistall){
            if(product.getTenSP().equals(prd.getTenSP()) && product.getKho().equals(prd.getKho())){
                check =1;
                break;
            }         
        }
        if( check == 1){
                if(prddao.delete(prd)!=0){
                    prdlist.add(prd);
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                }else{
                    JOptionPane.showMessageDialog(null, "Xóa không thành công");}
        }
        else{
            JOptionPane.showMessageDialog(null, "Sản phẩm không tồn tại");}
        
    }
    
    
    public ProductBUS() {
        this.prdlistall = prddao.selectAll();
    }
    
    
}
