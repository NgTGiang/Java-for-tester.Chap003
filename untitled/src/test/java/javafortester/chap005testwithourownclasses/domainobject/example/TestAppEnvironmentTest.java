package javafortester.chap005testwithourownclasses.domainobject.example;

import javafortester.chap005testwithourownclasses.domainobject.TestAppEnv;
//import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestAppEnvironmentTest {

    @Test
    public void canGetUrlStatically(){
        assertEquals("Returns Hard Coded URL", "http://192.123.0.3:67", TestAppEnv.getUrl());
    }
    /* 1. When replace the String with the int, the program will error
          Because the return value of method is String.

        2.When replace the String literal "http://192.123.0.3:67" with null and run the @Test method.
          The assert method will run with result False
          Because the expected result and the actual result is not the same.
     */

    @Test
    public void canGetDomainAndPortStatically(){
        assertEquals("Just the Domain","192.123.0.3",TestAppEnv.DOMAIN);
        assertEquals("Just the Port","67",TestAppEnv.PORT);
    }
}
