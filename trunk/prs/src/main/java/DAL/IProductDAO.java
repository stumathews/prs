/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DAL.DEL.Product;
import java.util.ArrayList;

/**
 * The interface that concerns itself with accessing data for Products.
 * Concrete classes implement this interface.
 * @author Stuart
 */
public interface IProductDAO 
{
    public ArrayList<DAL.DEL.Product> getAllProducts() throws Exception;
    public void addProduct(DAL.DEL.Product product) throws Exception;
    public void deleteProductByID(String productID) throws Exception;
    public Product getProductByID(String productID);
}
