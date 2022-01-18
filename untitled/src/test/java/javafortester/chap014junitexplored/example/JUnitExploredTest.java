package javafortester.chap014junitexplored.example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class JUnitExploredTest {

    @Test
    public void createMethodWithUsingAllOfTheAsserts(){
//      1.assertEquals
        assertEquals("3+3=6", 6,3+3);

//      2.assertFalse
        assertFalse("3+3=6",3+3 != 6);

//      3.assertTrue
        assertTrue("3+3=6",3+3 == 6);

//      4.assertArrayEquals
        assertArrayEquals("Array are not equal", new int[]{1, 2, 3}, new int[]{1, 2, 3});

//      5.assertNotNull
        Integer number = 1;
        assertNotNull("This is null", number);

//      6.assertNotSame
        assertNotSame("3+3=6", 7,3+3);

//      7.assertNull
        Integer number2 = null;
        assertNull("This is not null", number2);

//      8.assertSame
        assertSame("they are not the same", "result","result");
    }

    @Test
    public void replicatedAllTheJUnitAssertUsingAssertThat(){
//      1.assertEquals
        assertThat("assertEquals: 3+3=6",3+3, is(6));

//      2.assertFalse
        assertThat("assertFalse: false is false",false, equalTo(false));

//      3.assertTrue
        assertThat("assertTrue: true is true",true, equalTo(true));

//      4.assertArrayEquals
        assertThat(new int[]{1, 2, 3, 5}, equalTo(new int[]{1, 2, 3, 5}));

//      5.assertNotNull
        assertThat("assertNotNull: An empty string is not null",
                    "",
                    is(not(nullValue())));
        assertThat("Hello",is(notNullValue()));

//      6.assertNotSame
        assertThat("assertNotSame: ","actualResult", is(not("result")));

//      7.assertNull
        assertThat(null, is(nullValue()));

//      8.assertSame
        assertThat("assertSame: ","result", is("result"));
    }

    @Test
    public void useAllOfTheHamcrestMatchersListed(){
//      1.is
        assertThat(3, is(3));
        assertThat(3, is(equalTo(3)));
        assertThat(3, is(not(4)));

//      2.equalTo
        assertThat(3, is(equalTo(3)));
        assertThat(3, equalTo(3));

//      3.not
        assertThat(3, is(not(4)));
        assertThat(3, not(4));

//      4.containsString
        assertThat("There is a cat", containsString("is"));

//      5.endsWith
        assertThat("There is a cat", endsWith("cat"));

//      6.startsWith
        assertThat("There is a cat", startsWith("There is"));

//      7.nullValue
        assertThat(null,nullValue());
    }
}
