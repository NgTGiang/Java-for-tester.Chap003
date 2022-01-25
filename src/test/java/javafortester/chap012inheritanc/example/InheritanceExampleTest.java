package javafortester.chap012inheritanc.example;

import javafortester.chapt012inheritance.EnvironmentUser;
import javafortester.chapt012inheritance.ReadOnlyUser;
import org.junit.Assert;
import org.junit.Test;

public class InheritanceExampleTest {

    @Test
    public void createAnEnvironmentUser() throws javafortester.chap006.domainentities.InvalidPassword {
        EnvironmentUser enuser = new EnvironmentUser();

        Assert.assertEquals("username", enuser.getUsername());
        Assert.assertEquals("http://192.123.0.3:67", enuser.getUrl());
    }

    @Test
    public void createAReadOnlyUser() throws javafortester.chap006.domainentities.InvalidPassword {
        ReadOnlyUser readOnlyUser = new ReadOnlyUser();

        Assert.assertEquals("username", readOnlyUser.getUsername());
        Assert.assertEquals("password", readOnlyUser.getPassword());
        Assert.assertEquals("Read only", readOnlyUser.getPermission());
    }
    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionExpected(){
        Integer age=null;
        age.toString();
    }
    public class InvalidPassword extends Exception {
        public InvalidPassword(String message) {
            super(message);
        }
    }

}
