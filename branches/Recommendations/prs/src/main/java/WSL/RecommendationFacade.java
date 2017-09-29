/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WSL;

import BOLO.Recommendation;
import BOLO.Wrappers.RecommendationList;
import BSL.Interfaces.IRecommendationAdmin;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Stuart Mathews <stumathews@gmail.com>
 */
@SOAPBinding( parameterStyle=SOAPBinding.ParameterStyle.WRAPPED,
        style=SOAPBinding.Style.RPC,
        use=SOAPBinding.Use.LITERAL)//Optional 
@WebService(serviceName = "RecommendationFacade",
        portName = "AdminFacadePort",
        targetNamespace = "http://www.stuartmathews.com/RecommendationFacade")
public class RecommendationFacade 
{
    @Autowired
    private BSL.Interfaces.IRecommendationAdmin recommendationAdmin;

        
    /**
     * GetAllRecommendations
     */
    @WebMethod(operationName = "GetAllRecommendations")
    public RecommendationList GetAllRecommendations(@WebParam(name = "token") String token) throws Exception
    {
        RecommendationList result = new RecommendationList();        
        result.items = recommendationAdmin.getAllRecommendations(token);
        return result;     
   
    }
}
