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
        this.prdlistall.clear();
        this.prdlistall = prddao.selectAll();
        for(ProductDTO prd : prdlistall){
            if(prd.getKho().equals(kho)){
                prdlist.add(prd);
            }
        }
        return prdlist;
    }
    
    public int addProduct(ProductDTO prd){
        int check =0;
        int success = 0;
        if(prd.getTenSP().equals("") || prd.getThuongHieu().equals("") || prd.getXuatSu().equals("")){
            JOptionPane.showMessageDialog(null, "Thiếu thông tin");
            success = 0;
        }
        else{
            for(ProductDTO product : prdlistall){
            if(product.getTenSP().equals(prd.getTenSP()) && product.getKho().equals(prd.getKho())){
                JOptionPane.showMessageDialog(null, "Sản phẩm đã tồn tại"); 
                check =1;
                success = 0;
            }         
            }
            if( check == 0){
                if(prddao.insert(prd)!=0){
                    prdlist.add(prd);
                    success = 1;
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }else{
                    success = 0;
                    JOptionPane.showMessageDialog(null, "Thêm không thành công");}
            }
        }
        return success;
    }
    
    public void updateProduct(ProductDTO prd){
        if(prddao.update(prd)!=0){
            System.out.println("cc");
            this.prdlistall.clear();
            this.prdlistall = prddao.selectAll();
        }
    }
    
    public void deleteProduct(ProductDTO prd){
        int check =0;
        int sl=0;
        for(ProductDTO product : prdlistall){
            if(product.getTenSP().equals(prd.getTenSP()) && product.getKho().equals(prd.getKho())){
                sl=product.getSoluong();
                check =1;
                break;
            }         
        }
        if( check == 1 && sl==0){
                if(prddao.delete(prd)!=0 && sl==0){
                    prdlist.remove(prd);
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                }
        }
        else{   
            if(sl==0){    
                JOptionPane.showMessageDialog(null, "Sản phẩm không tồn tại");}
            else{
                JOptionPane.showMessageDialog(null, "Vẫn còn sản phẩm liên quan, không thể xóa");
            }
        }     
        
    }
    
    public int getProduct_amount(String kho){
        int amount;
        ArrayList<ProductDTO> listall = new ArrayList<>();
        listall = prddao.select();
        for(ProductDTO a : listall){
            if(!a.getKho().equals(kho)){
                listall.remove(a);
            }
        }
        return amount=listall.size();
    }
    
    public int checkproduct(ProductDTO product){
        int check = 0;
        int count = 0;
        ArrayList<ProductDTO> ls = new ArrayList<>();
        ls = prddao.select();
        for(ProductDTO a :  ls){
            count++;
            if(product.getTenSP().equals(a.getTenSP())){
                check = count;
                break;
            }
        }
        return check;
    }
    
    public ProductBUS() {
        this.prdlistall = prddao.selectAll();
    }
    
    
}
