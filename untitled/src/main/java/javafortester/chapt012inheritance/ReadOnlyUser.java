package javafortester.chapt012inheritance;

import javafortester.chap006.domainentities.User;

public class ReadOnlyUser extends User {

    public ReadOnlyUser(){
        this("username", "password");
    }

    public ReadOnlyUser(String username, String password){
        super(username, password);
    }

    public String getPermission(){
        return "Read only";
    }
}
