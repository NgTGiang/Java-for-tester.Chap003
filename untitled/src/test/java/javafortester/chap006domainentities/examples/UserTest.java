package javafortester.chap006domainentities.examples;

import javafortester.chap006.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void canConstructANewUser(){
        User  user = new User();

        assertEquals("default username expected",
                    "username",
                    user.getUsername());
        assertEquals("default password expected",
                    "password",
                    user.getPassword());
    }

    @Test
    public void canConstructWithUsernameAndPassword(){
        User user = new User("admin", "P@ssw0rd");

        assertEquals("default username expected",
                "admin",
                user.getUsername());
        assertEquals("default password expected",
                "P@ssw0rd",
                user.getPassword());
    }
}
