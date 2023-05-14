/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ProductDAO;
import DAO.ProductDetailDAO;
import DTO.PhieuDetailDTO;
import DTO.ProductDTO;
import DTO.ProductDetailDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author NAME
 */
public class ProductDetailBUS {
    ArrayList<ProductDetailDTO> listproduct;
    ProductDetailDAO prddetaildao = new ProductDetailDAO();
    ProductBUS productBUS = new ProductBUS();
    public ProductDetailBUS() {
        this.listproduct = prddetaildao.selectAll();
    }
    
    public void addProductDetail(ProductDetailDTO prd){
        if(prddetaildao.insert(prd)!=0){
            this.listproduct.add(prd);
            ProductDTO upprd= productBUS.selectbyID(prd.getTenSP());
            upprd.setSoluong(upprd.getSoluong()+1);
            productBUS.updateProduct(upprd);
        }
        this.listproduct = prddetaildao.selectAll();
    }
    
    public void delProductDetail(ProductDetailDTO prd){
        if(prddetaildao.delete(prd)!=0){
            this.listproduct.remove(prd);
            ProductDTO upprd= productBUS.selectbyID(prd.getTenSP());
            upprd.setSoluong(upprd.getSoluong()-1);
            productBUS.updateProduct(upprd);
        }
        this.listproduct = prddetaildao.selectAll();

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
    
    public ProductDetailDTO selectbyID(String masp,String tensp){
        ProductDetailDTO product = new ProductDetailDTO();
        for(ProductDetailDTO prd : prddetaildao.selectAll()){
            if(prd.getMaSP().equals(masp) && prd.getTenSP().equals(tensp)){
                return prd;
            }
        }
        return product;
    }
    
    public ArrayList<ProductDetailDTO> getallprd(){
        return this.listproduct;
    }
    
    public int getSoLuong(String TenSP,String kho,ArrayList<ProductDetailDTO> list) throws SQLException{
        
        ArrayList<ProductDetailDTO> productdetail = list;
        
        int i =0;
        
        for(ProductDetailDTO product : productdetail){
            if(product.getTenSP().equals(TenSP)){
                i++;
            }
        }
        return i;
    }
    
    public void update(ProductDetailDTO prd){
        prddetaildao.update(prd);
        listproduct = prddetaildao.selectAll();
        ProductDTO upprd= productBUS.selectbyID(prd.getTenSP());
            upprd.setSoluong(upprd.getSoluong()-1);
            productBUS.updateProduct(upprd);
    }
    
}
