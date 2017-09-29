
package BOL;

import COMMON.exceptions.OutdatedTokenException;
import DAL.ITokenDAO;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Business logic to authorise login tokens
 * @author Stuart Mathews <stuart@stuartmathews.com>
 */
public class ServiceAuthoriser implements IServiceAuthoriser
{
    private ITokenDAO tokenDAO;
    private IToken tokenBOL;

    @Autowired
    public void setTokenBOL(IToken tokenBOL) 
    {        
        this.tokenBOL = tokenBOL;
    }   
        
    @Autowired
    public void setTokenDAO(ITokenDAO tokenDAO )
    {
        this.tokenDAO = tokenDAO;
    }
    /***
        * Verify that the token is correct
        * @param token from the client
        * @return true if the token exist in the db.
        */
    public void authorise(String token) throws Exception
    {
       	
        // Try and get token from the database				
        BOLO.Token bolo_token = tokenDAO.getToken(token);			
        if( tokenBOL.isValid(bolo_token) == false )
        {				
            throw new OutdatedTokenException("Token is outdated. Re-authenticate.");
        }        

    }
}
