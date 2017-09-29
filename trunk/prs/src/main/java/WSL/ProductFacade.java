
package WSL;


import BSL.IProductAdmin;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.rpc.soap.SOAPFaultException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Manages interactions with the product web services
 * @author Stuart Mathews <stuart@stuartmathews.com>
 */
@SOAPBinding( parameterStyle=SOAPBinding.ParameterStyle.WRAPPED,
        style=SOAPBinding.Style.RPC,
        use=SOAPBinding.Use.LITERAL)//Optional 
@WebService(serviceName = "ProductFacade",
        portName = "ProductFacadePort",
        targetNamespace = "http://www.stuartmathews.com/ProductFacade")
public class ProductFacade 
{    
    @Autowired
    private IProductAdmin productAdmin;
 
    /**
     * Adds a product to the database
     * @param token auth token
     * @param product to add to the db
     * @throws Exception if unable to do so
     */
    @WebMethod(operationName = "addProduct")
    public void addProduct(@WebParam(name = "token") String token,@WebParam(name = "product") DAL.DEL.Product product) throws Exception
    {
        try 
        {
            productAdmin.addProduct(token, product);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ProductFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Unable to add product.",ex);
        }
    }
    
}
