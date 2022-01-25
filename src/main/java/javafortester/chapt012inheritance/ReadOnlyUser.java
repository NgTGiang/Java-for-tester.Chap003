package javafortester.chapt012inheritance;

import javafortester.chap006.domainentities.InvalidPassword;
import javafortester.chap006.domainentities.User;

public class ReadOnlyUser extends User {

    public ReadOnlyUser() throws InvalidPassword {
        this("username", "password");
    }

    public ReadOnlyUser(String username, String password) throws InvalidPassword {
        super(username, password);
    }

    public String getPermission(){
        return "Read only";
    }
}
