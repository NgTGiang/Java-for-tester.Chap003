package javafortestter.chap003myfirsttest.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyFirstTest {
    @Test
    public void canAddTwoPlusTwo(){
        int answer = 2+2;
        assertEquals("2+2=4", 4, answer);
    }

    @Test
    public void canAddTwoSubtractTwo(){
        int result = 2 -2;
        assertEquals("2-2=0", 0, result);
    }

    @Test
    public void canAddFourDivideTwo(){
        int result = 4/2;
        assertEquals("4/2 = 2", 2, result);
    }

    @Test
    public void canAddTwoMultiplyTwo(){
        int result = 2*2;
        assertEquals("2*2 = 4", 4, result);
    }
}
