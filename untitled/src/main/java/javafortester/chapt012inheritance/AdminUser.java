package javafortester.chapt012inheritance;

import javafortester.chap006.domainentities.User;

public class AdminUser extends User {

    public AdminUser(){
        this("admin user","password");
    }
    public AdminUser(String username, String password){
        super(username,password);
    }

    public String getPermission(){
        return "Elevated";
    }
}
