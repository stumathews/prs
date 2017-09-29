/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package COMMON.exceptions;

/**
 *
 * @author Stuart Mathews <stuart@stuartmathews.com>
 */
public class OutdatedTokenException extends Exception 
{

    public OutdatedTokenException(String token_is_outdated_Reauthenticate) 
    {
        super(token_is_outdated_Reauthenticate);
    }
    
}
