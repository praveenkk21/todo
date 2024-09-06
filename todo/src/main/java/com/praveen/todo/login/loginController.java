package com.praveen.todo.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class loginController {

    @RequestMapping(value="login-page",method=RequestMethod.GET)
    public String loginPagePost(){
        return "loginPage";
    }

    @RequestMapping(value="login-page",method=RequestMethod.POST)
    public String loginPageGet(@RequestParam String name, @RequestParam String password, ModelMap map){
        map.put("name",name);
        map.put("password",password);
        return "welocmePage";
    }
}
