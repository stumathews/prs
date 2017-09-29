
package DAL;

import java.util.ArrayList;
import org.hibernate.HibernateException;

/**
 * Contract for implementations of user data access objects
 * @author Stuart Mathews <stuart@stuartmathews.com>
 */
public interface IUserDAO 
{
    public BOLO.User createUser(String username, String password) throws Exception;
    public DAL.DEL.User retrieve(String username, String password) throws Exception;
    public boolean exists(String username, String password) throws Exception;
    public BOLO.User getUser(String username, String password) throws HibernateException, Exception;
    public ArrayList<DAL.DEL.User> getAllUsers() throws Exception;
    public void deleteUser(String username) throws Exception;
    public DAL.DEL.User getUser(String username) throws Exception;
}
