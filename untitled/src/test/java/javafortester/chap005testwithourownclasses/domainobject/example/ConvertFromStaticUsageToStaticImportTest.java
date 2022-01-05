package javafortester.chap005testwithourownclasses.domainobject.example;

//2. Convert the import of TestAppEnv to an import static of the DOMAIN and the PORT
//import static javafortester.chap005testwithourownclasses.domainobject.TestAppEnv.DOMAIN;
//import static javafortester.chap005testwithourownclasses.domainobject.TestAppEnv.PORT;

//1. Convert the assertEquals import static to an import of just the Assert
import org.junit.Assert;

import org.junit.Test;

//3. Convert the import of TestAppEnv to an import static of everything in TestAppEnv
import static javafortester.chap005testwithourownclasses.domainobject.TestAppEnv.*;

public class ConvertFromStaticUsageToStaticImportTest {
    @Test
    public void canGetUrlStatically(){
        Assert.assertEquals("Returns Hard Coded URL", "http://192.123.0.3:67", getUrl());
    }

    @Test
    public void canGetDomainAndPortStatically(){
        Assert.assertEquals("Just the Domain","192.123.0.3",DOMAIN);
        Assert.assertEquals("Just the Port","67",PORT);
    }
}
