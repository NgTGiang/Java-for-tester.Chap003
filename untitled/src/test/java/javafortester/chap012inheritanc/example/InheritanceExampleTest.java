package javafortester.chap012inheritanc.example;

import javafortester.chapt012inheritance.EnvironmentUser;
import javafortester.chapt012inheritance.ReadOnlyUser;
import org.junit.Assert;
import org.junit.Test;

public class InheritanceExampleTest {

    @Test
    public void createAnEnvironmentUser(){
        EnvironmentUser enuser = new EnvironmentUser();

        Assert.assertEquals("username", enuser.getUsername());
        Assert.assertEquals("http://192.123.0.3:67", enuser.getUrl());
    }

    @Test
    public void createAReadOnlyUser(){
        ReadOnlyUser readOnlyUser = new ReadOnlyUser();

        Assert.assertEquals("username", readOnlyUser.getUsername());
        Assert.assertEquals("password", readOnlyUser.getPassword());
        Assert.assertEquals("Read only", readOnlyUser.getPermission());
    }
}
