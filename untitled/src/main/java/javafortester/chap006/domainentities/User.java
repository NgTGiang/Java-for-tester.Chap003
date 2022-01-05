package javafortester.chap006.domainentities;

public class User {
    private String username;
    private String password;

    public User(){
        this("username", "password");
//        username = "username";
//        password = "password";
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}