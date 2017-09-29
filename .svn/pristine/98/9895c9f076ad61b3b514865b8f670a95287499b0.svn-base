package WSL;

import BOL.IToken;
import BSL.IUserAdmin;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceException;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Manages the interaction with the user web service facilities
 * @author Stuart Mathews <stuart@stuartmathews.com>
 */
@SOAPBinding( parameterStyle=SOAPBinding.ParameterStyle.WRAPPED,
        style=SOAPBinding.Style.RPC,
        use=SOAPBinding.Use.LITERAL)//Optional 
@WebService(serviceName = "UserFacade",
        portName = "UserFacadePort",
        targetNamespace = "http://www.stuartmathews.com/UserFacade")  
public class UserFacade
{
        @Autowired
        private IUserAdmin userAdmin;        
	/**
	 * Creates a new user
	 * @param token
	 * @param user
	 * @return a BOLO.User representing the new user.	 * 
	 */	
	public BOLO.User createUser(@WebParam(name="token") String token, @WebParam(name="user") String user, @WebParam(name="password") String password)
	{
            BOLO.User new_user = new BOLO.User();
            try
            {
                return userAdmin.createUser(token, user, password);		
            }
            catch( Exception error)
            {
                throw new WebServiceException(String.format("Unable to create user '%s'",new_user.getUsername()),error);
            }
	}
	
	/**
	 * Cleans out all the persisted tokens for this user. 
	 * @param token
	 * @return
	 */	
	public boolean logout(@WebParam(name="token") String token)
	{	
            try
            {                
                return userAdmin.cleanOldUserTokens(token);		
            }
            catch( Exception error)
            {
                throw new WebServiceException("Unable to logout successfully", error);
            }
	}
		
}
