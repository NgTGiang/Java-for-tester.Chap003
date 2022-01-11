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
        setPassword(password);
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        if(password.length() < 7){
            throw new IllegalArgumentException("Password must be > 6 chars");
        }
    }

    @Override
    public String toString(){
        return "username: " + username + ", password: " + password;
    }
}
