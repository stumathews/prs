package DAL;

import BOLO.Product;
import DAL.Interfaces.IProductDAO;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is a object which manages the interaction with the db adn the product
 * This is capable of being injected as a dependency as it interfaces with IProduct
 * @author Stuart
 */
public class ProductDAO implements IProductDAO
{    
    private SessionFactory sessionFactory;

    @Autowired 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /***
    * Gets all products
    * @return
    * @throws Exception 
    */
    
    @SuppressWarnings("unchecked")
    public ArrayList<DEL.Product> getAllProducts() throws Exception
    {
        ArrayList<DEL.Product> products = new ArrayList<DEL.Product>();
        Session session = sessionFactory.getCurrentSession();		
        products = (ArrayList<DEL.Product>) session.createQuery("from Product").list();                	
        return products;
    }
    
    /**
     * Adds a product
     * @param product product to add
     * @throws Exception 
     */
    
    public void addProduct(DEL.Product product) throws Exception 
    {		
        Session session = sessionFactory.getCurrentSession();		
        session.save(product);        
    }
    
    /**
     * Delete a product by ID
     * @param productID existing product id to delete
     * @throws Exception 
     */
    
    public void deleteProductByID(String productID) throws Exception 
    {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery(String.format("delete from Product where id = %s",productID)).executeUpdate();				
    }
     
    /**
     * Retrieve a product by ID
     * @param productID existing product id to retrieve
     * @return 
     */
    
    public DEL.Product getProductByID(String productID) {
        Session session = sessionFactory.getCurrentSession();
        DEL.Product prod = new DEL.Product();
        prod =  (DEL.Product) session.get(DEL.Product.class, Long.parseLong(productID));
        return prod;
    }

    
    public BOLO.Product Convert(DEL.Product delprod)
    {
        BOLO.Product bolprod = new BOLO.Product();
        
        bolprod.setTitle(delprod.getTitle());
        bolprod.setWhatIsIt(delprod.getWhatIsIt());
        bolprod.setWhoMadeIt(delprod.getWhoMadeIt());
        bolprod.setIdentifier(delprod.getId().toString());
        
        return bolprod;
    }
}