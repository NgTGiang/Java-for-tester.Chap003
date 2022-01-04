package javafortestter.chap003myfirsttest.example;

import javafortester.chap003myfirsttest.example.NameClass;
import javafortester.chap003myfirsttest.example.NameClassTest;
import javafortester.chap003myfirsttest.example.NameTestClass;
import javafortester.chap003myfirsttest.example.TestNameClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CheckTheClassName {

    @Test
    public void checkClassNameTestNameClass(){
        TestNameClass name = new TestNameClass();
        String className = name.getClass().getSimpleName();

        if(className.contains("Test")){
            String profix = className.substring(0,4);
            String suffix = className.substring(className.length()-4);
            String expectedResult = "Test";

            assertTrue("The name is wrong",profix.equals(expectedResult) | suffix.equals(expectedResult));
        } else{
            System.out.println("The Class name: '" +className+ "' don't have Test keyword");
            assertTrue(className.contains("Test"));
        }
    }

    @Test
    public void checkClassNameNameClassTest(){
        NameClassTest name = new NameClassTest();
        String className = name.getClass().getSimpleName();

        if(className.contains("Test")){
            String profix = className.substring(0,4);
            String suffix = className.substring(className.length()-4);
            String expectedResult = "Test";

            assertTrue("The name is wrong",profix.equals(expectedResult) | suffix.equals(expectedResult));
        } else{
            System.out.println("The Class name: '" +className+ "' don't have Test keyword");
            assertTrue(className.contains("Test"));
        }
    }

    @Test
    public void checkClassNameNameTestClass(){
        NameTestClass name = new NameTestClass();
        String className = name.getClass().getSimpleName();

        if(className.contains("Test")){
            String profix = className.substring(0,4);
            String suffix = className.substring(className.length()-4);
            String expectedResult = "Test";

            assertTrue("The name is wrong",profix.equals(expectedResult) | suffix.equals(expectedResult));
        } else{
            System.out.println("The Class name: '" +className+ "' don't have Test keyword");
            assertTrue(className.contains("Test"));
        }
    }

    @Test
    public void checkClassNameNameClass(){
        NameClass name = new NameClass();
        String className = name.getClass().getSimpleName();

        if(className.contains("Test")){
            String profix = className.substring(0,4);
            String suffix = className.substring(className.length()-4);
            String expectedResult = "Test";

            assertTrue("The name is wrong",profix.equals(expectedResult) | suffix.equals(expectedResult));
        } else{
            System.out.println("The Class name: '" +className+ "' don't have Test keyword");
            assertTrue(className.contains("Test"));
        }

    }
}
