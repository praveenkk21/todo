package com.praveen.todoApp.login;

import org.springframework.stereotype.Service;

@Service
public class authenticationService {
    public boolean authenticate(String username, String password){
        boolean isvalidusername=!(username.isEmpty());
        boolean isvalidpassword=password.equalsIgnoreCase("demo");
        return isvalidusername && isvalidpassword;
    }
}
