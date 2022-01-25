package javafortester.chap008selectionsanddecisions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NestedIfElseHorror {

    public void horrorOfNestedIfElse(boolean truthy, boolean falsey) {
        if (truthy) {
            if (!falsey) {
                if (truthy && !falsey)
                    if (truthy || falsey) {
                        System.out.println(" True |  False");
                        assertTrue(truthy);
                        assertFalse(falsey);
                    }
            } else {
                System.out.println(" True |  True");
                assertTrue(truthy);
                assertTrue(falsey);
            }
        } else{
            if (!truthy){
                if(falsey){
                    System.out.println(" False |  True");
                    assertTrue(falsey);
                    assertFalse(truthy);
                } else {
                    System.out.println(" False |  False");
                    assertFalse(truthy);
                    assertFalse(falsey);
                }
            }
        }
    }
}
