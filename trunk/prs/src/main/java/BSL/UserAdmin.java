/**
 * Represents the User service administration layer
 */
package BSL;

import BOL.IServiceAuthoriser;
import BOL.IUser;
import DAL.DEL.User;
import DAL.IUserDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Business Service layer for User entities
 * @author Stuart Mathews <stuart@stuartmathews.com>
 */
public class UserAdmin implements IUserAdmin
{
    @Autowired
    private IServiceAuthoriser serviceAuthoriser;  
    @Autowired
    private IUserDAO userDAO;
    @Autowired
    private IUser userBOL;
    
    /***
    * Creates a new user
    * @param token the token that represents your authenticated status
    * @param username the intended name of the new user to be created.
    */
    public BOLO.User createUser( String token, String username, String password) throws Exception
    {
        serviceAuthoriser.authorise(token);//authorise provided token
        
        try
        {      
            return userBOL.createUser(username, password);
        }
        catch( Exception e)
        {
            Logger.getLogger(ProductAdmin.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Unable to create user",e);
        }
    }

    /**
     * Gets all the users in the database
     * @param token auth token
     * @return list of user entities in the database
     * @throws Exception if error getting entities or auth issue
     */
    public ArrayList<User> getAllUsers(String token) throws Exception
    {
        serviceAuthoriser.authorise(token);
        try 
        {
            return userBOL.getAllUsers();
        } catch (Exception e) 
        {
            Logger.getLogger(ProductAdmin.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Unable to retrieve list of user entities",e);
        }
    }


    /**
     * Deletes a named user
     * @param token auth token
     * @param username named user to delete
     * @throws Exception 
     */
    public void deleteUser(String token, String username) throws Exception 
    {
        serviceAuthoriser.authorise(token);
        try 
        {
            userBOL.deleteUser(username);            
        } catch (Exception e) 
        {
            Logger.getLogger(ProductAdmin.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Unable to delete user",e);
        }
    }

    public boolean cleanOldUserTokens(String token) throws Exception 
    {
        serviceAuthoriser.authorise(token);
        try 
        {
           return userBOL.cleanOldUserTokens(token); 
        } 
        catch (Exception e) 
        {
            throw new Exception("Unable to clear out old user tokens",e);
        }
        
    }

   
		
}
