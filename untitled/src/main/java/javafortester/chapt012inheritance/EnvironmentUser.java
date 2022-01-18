package javafortester.chapt012inheritance;

import javafortester.chap005testwithourownclasses.domainobject.TestAppEnv;
import javafortester.chap006.domainentities.InvalidPassword;
import javafortester.chap006.domainentities.User;

public class EnvironmentUser extends User {
    public EnvironmentUser() throws InvalidPassword {
    }

    public String getUrl(){
        return TestAppEnv.getUrl();
    }
}
