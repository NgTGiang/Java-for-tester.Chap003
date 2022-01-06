package javafortester.chap008selectionsanddecisions.example;

import javafortester.chap008selectionsanddecisions.NestedIfElseHorror;
import javafortester.chap008selectionsanddecisions.SwitchClass;
import org.junit.Test;

import static javafortester.chap008selectionsanddecisions.MyCat.catOrCats;
import static org.junit.Assert.*;

public class TernaryOperator {

    @Test
    public void catOrCatsTest(){
        assertEquals("2 == cats", "cats", catOrCats(2));
    }

    @Test
    public void assertTrueIfTrueTest(){
        boolean truthy = true;
        if(truthy)
            assertTrue(truthy);
        if(truthy){
            assertTrue(truthy);
            assertFalse(!truthy);
            System.out.println("Truthy is: "+truthy);
        }
    }

    @Test
    public void assertTrueElseAssertFalse(){
        boolean truthy = true;

        if(truthy)
            assertTrue(truthy);
        else
            assertFalse(truthy);

        if(truthy){
            assertTrue(truthy);
            assertFalse(!truthy);
            System.out.println("Truthy is: "+truthy);
        } else {
            assertTrue(!truthy);
            assertFalse(truthy);
            System.out.println("Truthy is: "+truthy);
        }
    }

    @Test
    public void nestedIfElseHorrorTest(){
        NestedIfElseHorror test = new NestedIfElseHorror();
        test.horrorOfNestedIfElse(true,true);
        test.horrorOfNestedIfElse(true, false);
        test.horrorOfNestedIfElse(false, true);
        test.horrorOfNestedIfElse(false, false);
    }

    @Test
    public void switchOnShortCodeTest(){
        assertEquals("United Kingdom",
                    "United Kingdom",
                    SwitchClass.countrySwitch("uK"));
        assertEquals("United States",
                    "United States",
                    SwitchClass.countrySwitch("US"));
        assertEquals("United States",
                    "United States",
                    SwitchClass.countrySwitch("UsA"));
        assertEquals("France",
                    "France",
                    SwitchClass.countrySwitch("fr"));
        assertEquals("Sweden",
                    "Sweden",
                    SwitchClass.countrySwitch("SE"));
        assertEquals("Rest Of World",
                    "Rest Of World",
                    SwitchClass.countrySwitch("other"));
    }

    @Test
    public void switchOnInt(){
        assertEquals("One", "One",
                SwitchClass.numberSwitch(1));

        assertEquals("Two", "Two",
                SwitchClass.numberSwitch(2));

        assertEquals("Three", "Three",
                SwitchClass.numberSwitch(3));

        assertEquals("Four", "Four",
                SwitchClass.numberSwitch(4));

        assertEquals("Too big", "Too big",
                SwitchClass.numberSwitch(5));

        assertEquals("Too small", "Too small",
                SwitchClass.numberSwitch(0));
    }
}
