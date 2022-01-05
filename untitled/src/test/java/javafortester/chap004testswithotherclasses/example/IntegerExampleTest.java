package javafortester.chap004testswithotherclasses.example;

import org.junit.Assert;
import org.junit.Test;

public class IntegerExampleTest {
    @Test
    public void integerExplorationNumber11(){
        Integer number = 11;
        Assert.assertTrue(number+" to Hexadecimal is b",Integer.toHexString(number).equals("b"));
    }

    @Test
    public void integerExplorationNumber10(){
        Integer number = 10;
        Assert.assertTrue(number+" to Hexadecimal is a",Integer.toHexString(number).equals("a"));
    }

    @Test
    public void integerExplorationNumber3(){
        Integer number = 3;
        Assert.assertTrue(number+" to Hexadecimal is 3",Integer.toHexString(number).equals("3"));
    }

    @Test
    public void integerExplorationNumber21(){
        Integer number = 21;
        Assert.assertTrue(number+" to Hexadecimal is 15",Integer.toHexString(number).equals("15"));
    }

    @Test
    public void confirmMinIntegerSize(){
        Assert.assertTrue("Min of integer is -2147483648", Integer.MIN_VALUE ==(-2147483648));
    }

    @Test
    public void confirmMaxIntegerSize(){
        Assert.assertTrue("Max of integer is 2147483647", Integer.MAX_VALUE ==(2147483647));
    }
}
