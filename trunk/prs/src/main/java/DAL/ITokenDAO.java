/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.util.ArrayList;

/**
 * Contract for implementing new Data access objects for tokens
 * @author Stuart Mathews <stuart@stuartmathews.com>
 */
public interface ITokenDAO {
    public void storeToken(BOLO.Token token, String username, String password ) throws Exception;
    public BOLO.Token getToken(String token) throws Exception;
    public void cleanOldUserTokens(String token) throws Exception;
    public ArrayList<DAL.DEL.Token> GetAllTokens() throws Exception;
    
}
