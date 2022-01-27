package javafortester.chap013moreexceptions.example;

import javafortester.chap006.domainentities.InvalidPassword;
import javafortester.chap006.domainentities.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CreatedExceptionTest {

    @Test (expected = InvalidPassword.class)
    public void constructUserWithException() throws InvalidPassword {
        User aUser = new User("username","p");
    }

    @Test
    public void createDefaultUserWithNoThrowsInvalidPasswordException(){
        User aUser = new User();
        Assert.assertEquals("password", aUser.getPassword());
    }

    @Test
    public void createUserWithInvalidPasswordExceptionMessage(){
        User aUser;
        try {
            aUser = new User("username", "p");
            fail("An Invalid Password Exception should have been thrown");
        }catch (InvalidPassword e){
            assertTrue(e.getMessage().startsWith("Password must be > 6 chars"));
        }
    }

    @Test
    public void setPasswordWithInvalidPasswordExceptionMessage(){
        User aUser = new User();
        try {
            aUser.setPassword("tiny");
            fail("An Invalid Password Exception should have been thrown");
        }catch (InvalidPassword e){
            assertTrue(e.getMessage().startsWith("Password must be > 6 chars"));
        }
    }
}
