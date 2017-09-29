/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Website.Controllers;

import BOL.IServiceAuthoriser;
import BSL.ILoginAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Common functionality shared across controllers
 * @author Stuart Mathews <stuart@stuartmathews.com>
 */

@Component
public class Common 
{
    private static ILoginAdmin loginAdmin;
    private static IServiceAuthoriser auth;

    @Autowired
    public static void setAuth(IServiceAuthoriser auth) {
        Common.auth = auth;
    }
    
    
    @Autowired
    public void setLoginAdmin(ILoginAdmin loginAdmin) {
        Common.loginAdmin = loginAdmin;
    }
    
    /**
    * Returns the authentication token based on administrator credentials. Uses 
    * LoginAdmin authentication facility
    * @return
    * @throws Exception 
    */
    public static String GetGenAdminAuthToken() throws Exception 
    {                
        return loginAdmin.authenticate("administrator", "apps3cur3");
    }
}
