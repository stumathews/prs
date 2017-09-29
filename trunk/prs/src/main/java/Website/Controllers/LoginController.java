package Website.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

   
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) 
    {        
        return "Login";
    }
   

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        String errorMsg = "Login failed.";
        model.addAttribute("error", true);
        model.addAttribute("errorMsg", errorMsg);
        return "Login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "Login";
    }

    @RequestMapping(value = "/sessiontimeout", method = RequestMethod.GET)
    public String sessionTimeout(ModelMap model) {
        String errorMsg = "Session has expired. Please login";
        model.addAttribute("error", true);        
        model.addAttribute("errorMsg", errorMsg);
        return "Login";
    }
}