/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ProductDAO;
import DTO.ProductDTO;
import java.util.ArrayList;

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
        for(ProductDTO product : prdlist){
            if(product.getTenSP().equals(prd.getTenSP())==false && prd.getKho().equals(product.getKho())){
                if(prddao.insert(prd)!=0){
                    prdlist.add(prd);
                }
            }
        }
    }
    
    
    public ProductBUS() {
        this.prdlist = prddao.selectAll();
    }
    
    
}
