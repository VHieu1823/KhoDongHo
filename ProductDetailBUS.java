/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ProductDetailDAO;
import DTO.ProductDetailDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class ProductDetailBUS {
    ArrayList<ProductDetailDTO> listproduct;
    ProductDetailDAO prddao = new ProductDetailDAO();

    public ProductDetailBUS() {
        this.listproduct = prddao.selectAll();
    }
    
    public ArrayList<ProductDetailDTO> getprddetaillist(String TenSp){
        ArrayList<ProductDetailDTO> prdlist = new ArrayList<>();
        for(ProductDetailDTO prd : this.listproduct){
            if(prd.getTenSP().equals(TenSp)){
                prdlist.add(prd);
            }
        }
        return prdlist;
    }
    
    public ArrayList<ProductDetailDTO> getallprd(){
        return this.listproduct;
    }
    
    public static int getSoLuong(String TenSP,String kho,ArrayList<ProductDetailDTO> list) throws SQLException{
        
        ArrayList<ProductDetailDTO> productdetail = list;
        
        int i =0;
        
        for(ProductDetailDTO product : productdetail){
            if(product.getKho().equals(kho) && product.getTenSP().equals(TenSP)){
                i++;
            }
        }
        return i;
    }
    
    
}
