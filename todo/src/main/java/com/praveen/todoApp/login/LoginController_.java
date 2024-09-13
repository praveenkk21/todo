package com.praveen.todoApp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

//@Controller
@SessionAttributes("username")
public class LoginController_ {

    @Autowired
    private AuthenticationService_ authenticationService;

    @RequestMapping(value="login",method=RequestMethod.GET)
    public String loginPageEnter(){
        return "goToLogin";
    }
    @RequestMapping(value="login",method=RequestMethod.POST)
    public String loginPageEnter2(){
        return "loginPage";
    }
    @RequestMapping(value="login-page",method=RequestMethod.GET)
    public String loginPagePost(){
        return "loginPage";
    }
    @RequestMapping(value="login-page",method=RequestMethod.POST)
    public String loginPageGet(@RequestParam String username, @RequestParam String password,ModelMap map){

        if(authenticationService.authenticate(username,password))
        {
            map.put("username",username);
            map.put("password",password);
            return "welcomePage";

        }
      map.put("errorMessage","Invalid Credentials");
        return "loginPage";
    }

    @RequestMapping("home-page")
    public String homePage() {
        return "welcomePage";
    }
}
