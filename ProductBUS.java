package BUS;

import DAO.ProductDAO;
import DTO.ProductDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author NAME
 */
public class ProductBUS {
    ArrayList<ProductDTO> listproduct;
    ProductDAO prddao = new ProductDAO();

    public ProductBUS() {
        this.listproduct = prddao.selectAll();
    }
    
    public ArrayList<ProductDTO> getprdlist(String TenSp){
        ArrayList<ProductDTO> prdlist = new ArrayList<>();
        for(ProductDTO prd : this.listproduct){
            if(prd.getTenSP().equals(TenSp)){
                prdlist.add(prd);
            }
        }
        return prdlist;
    }
    
    public ArrayList<ProductDTO> getallprd(){
        return this.listproduct;
    }
   }