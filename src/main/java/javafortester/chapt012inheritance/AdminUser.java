package javafortester.chapt012inheritance;

import javafortester.chap006.domainentities.InvalidPassword;
import javafortester.chap006.domainentities.User;

public class AdminUser extends User {

    public AdminUser() throws InvalidPassword {
        this("admin user","password");
    }
    public AdminUser(String username, String password) throws InvalidPassword {
        super(username,password);
    }

    public String getPermission(){
        return "Elevated";
    }
}
