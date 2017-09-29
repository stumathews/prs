/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BOL.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * The default authority for users in the database
 * @author Stuart Mathews <stuart@stuartmathews.com>
 */
class DefaultUserAuthority implements GrantedAuthority
{
    public String getAuthority() {
        return "ROLE_USER";
    }
    
}
