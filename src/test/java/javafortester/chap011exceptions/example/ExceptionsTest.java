package javafortester.chap011exceptions.example;

import org.junit.Assert;
import org.junit.Test;

public class ExceptionsTest {

    @Test
    public void fixTheNullPointerExceptionInTheCode(){
        Integer age = 18;

        String ageAsString = age.toString();

        String yourAge = "You are " + ageAsString +" year old";

        Assert.assertEquals("You are 18 year old", yourAge);
    }

    @Test
    public void useADifferentExceptionInsteadOfNullPointerException(){
        Integer age = null;
        String ageAsString;

        try {
            ageAsString = age.toString();

        }catch (NullPointerException e) {
//            age = 18;
            ageAsString = age.toString();
        }

        String yourAge = "You are " + ageAsString + " year old";
        Assert.assertEquals("You are 18 year old", yourAge);
        /*
        1. Use a different exception instead of NullPointerException?
           When replacing NullPointerException with ArithmeticException
           The NullPointerException will not be caught

        2. Don’t fix the cause of the exception?
           Code in catch block threw a NullPointerException
           Because I don't add try catch for the error code in catch block.

        3. Catch a Checked Exception?
           Received a syntax error on the NoSuchMethodException line.
         */
    }

    @Test
    public void userExceptionAsAnObject(){
        Integer age = null;
        String ageAsString;

        try {
            ageAsString = age.toString();
        }catch(NullPointerException e){
            System.out.println("getMessage - " + e.getMessage());
            System.out.println("getStackTrace - " + e.getStackTrace());
            System.out.println("printStackTrace");
            e.printStackTrace();
        }
    }
}
