package javafortester.chap006.domainentities;

import javafortester.chap005testwithourownclasses.domainobject.TestAppEnv;

public class User {
    private String username;
    private String password;
    private TestAppEnv testAppEnv;

    public User() {
//        this("username", "password");
        username = "username";
        password = "password";
}

    public User(String username, String password) throws InvalidPassword {
        this.username = username;
        setPassword(this.password = password);
        this.testAppEnv = new TestAppEnv();
    }

    public String getUrl(){
        return TestAppEnv.getUrl();
    }

    public String getPermission(){
        return "Normal";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidPassword{
        if(password.length() < 7){
            throw new InvalidPassword("Password must be > 6 chars");
        }

        if(!password.matches(".*[0123456789]+.*")){
            throw new InvalidPassword("Password must have a digit");
        }

        if(!password.matches(".*[A-Z]+.*")){
            throw new InvalidPassword("password must have an uppercase letter");
        }

        if(!password.matches(".*[!@#$%^&*].*")){
            throw new InvalidPassword("password must have a special character");
        }
    }

    @Override
    public String toString(){
        return "username: " + username + ", password: " + password;
    }
}
