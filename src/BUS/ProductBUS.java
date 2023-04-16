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
    ArrayList<ProductDTO> prdlist = new ArrayList<>();
    ProductDAO prddao = new ProductDAO();

    public ArrayList<ProductDTO> getPrdlist() {
        return prdlist;
    }
    
    
    public ProductBUS() {
        this.prdlist = prddao.selectAll();
    }
    
    
}
