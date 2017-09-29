
package BSL;

import BOL.IServiceAuthoriser;
import DAL.DEL.Product;
import DAL.IProductDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Business Service Layer for Product(s)
 * @author Stuart Mathews <stuart@stuartmathews.com>
 */
public class ProductAdmin implements IProductAdmin
{
    private IProductDAO productDAO;     // DB Access Object for Products
    private IServiceAuthoriser auth; // Authorisation provider
    
    @Autowired
    public void setAuth(IServiceAuthoriser auth) {
        this.auth = auth;
    }
    
    @Autowired
    public void setProductDAO(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    
    /**
     * Deletes a product 
     * @param token auth token
     * @param productID productID the id of the product to delete
     * @throws Exception if cannot delete product or auth error
     */
    public void deleteProductByID(String token, String productID) throws Exception
    {
        auth.authorise(token);
        
        try 
        {            
            productDAO.deleteProductByID(productID);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ProductAdmin.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Unable to delete product",ex);
        }
    }

    /**
     * Gets all products from the database
     * @param token auth token
     * @return ArrayList of Products
     * @throws Exception if unable to get all products
     */
    public ArrayList<Product> getAllProducts(String token) throws Exception
    {
        auth.authorise(token);
        
        try 
        {
           return productDAO.getAllProducts();
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ProductAdmin.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Unable to retrieve all products",ex);
        }
    }

    /**
     * Adds a product to the database
     * @param token auth token
     * @param prod product to add
     * @throws Exception if unable to add product
     */
    public void addProduct(String token, Product prod) throws Exception
    {        
        auth.authorise(token);    
        
        try 
        {
            productDAO.addProduct(prod);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ProductAdmin.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Unable to add product.",ex);
        }        
        
    }

    /**
     * Attempts to retrieve a product by its ID
     * @param token auth token
     * @param productID product id to fetch
     * @return a product
     * @throws Exception if unable to retrieve product by id
     */
    public Product getProductByID(String token, String productID) throws Exception 
    {
        auth.authorise(token);
        try 
        {
            return productDAO.getProductByID(productID);
        } 
        catch (Exception e) 
        {
           throw new Exception("Unable to get product by ID",e); 
        }
        
    }

   

    
}
