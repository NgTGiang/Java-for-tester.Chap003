package javafortester.chap015stringrevisted.example;

import javafortester.chap006.domainentities.InvalidPassword;
import javafortester.chap006.domainentities.User;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class StringRevisitedTest {

    @Test
    public void tryUsingTheOtherEscapeCharacters(){
        System.out.println("New lines, and Tabs");
        String firstLine = "|first line\n";
        String secondLine = "|\tsecond line\n";
        String thirdLine = "|\t\tthird line\n";
        String fullLine = firstLine + secondLine + thirdLine;
        System.out.println(fullLine);

        System.out.println("Carriage return after each word");
        System.out.println("one\rtwo\rthree\rfour\rfive");

        System.out.println("Backspace after each word");
        System.out.println("one\btwo\bthree\bfour\bfive\b");

        System.out.println("Quotes and slashes");
        System.out.println("Bob\'s toy said \"DOS uses \'\\\'\"");

//      \b and \r don't work in IDE because there is no corresponding library in IDE to run them.
    }

    @Test
    public void constructAString(){
//      Construct String from String class
        String aString1 = new String();

        assertThat(aString1.length(), is(0));
        assertThat(aString1, is(notNullValue()));


//      construct String from char[] Array
        char[] charArray = {'a', 'b','c'};

        String aString2 = new String(charArray);
        assertThat(aString2, is("abc"));

        String aString3 = new String(charArray,1,2);
        assertThat(aString3, is("bc"));


//      construct String from byte[] Array
        byte[] byteArray = "This is byte array".getBytes();

        String aString4 = new String(byteArray);
        assertThat(aString4, is("This is byte array"));

        String aString5 = new String(byteArray,1,4);
        assertThat(aString5, is("his "));
    }

    @Test
    public void useRegionMatches(){
        String aString = "Hello fella";
        String subString = "young lady";

        assertThat(aString.regionMatches(9,subString,6,2), is(true));
    }

    @Test
    public void findPositionsOfAllOccurrencesInAString(){
        findPositions("Hello fella","l");
    }

    @Ignore
    public List<Integer> findPositions(String aString, String subString){
        List<Integer> results = new ArrayList<Integer>();
        int lastFoundPosition = 0;

        if(aString != null && subString != null && aString != "" && subString != ""){
            if(aString.contains(subString)){
                do{
                    lastFoundPosition = aString.indexOf(subString,lastFoundPosition);
                    if(lastFoundPosition != -1){
                        results.add(lastFoundPosition);
                        lastFoundPosition++;
                    }
                }while (lastFoundPosition != -1);

                for(int i : results){
                    System.out.print(i + ", ");
                }

                results.sort(Comparator.reverseOrder());
                System.out.println("\nPrint list with sort: ");
                for(int i : results){
                    System.out.print(i + ", ");
                }
            }else {
                throw new NullPointerException("String do not contain a subString");
            }
        }else {
            throw new NullPointerException(" Can not find with empty String or subString");
        }
        return results;
    }

    @Test
    public void useRegularExpressions() throws InvalidPassword {
        User user1 = new User("username","password2T@");
    }

    @Test
    public void checkStringBuilderResizes(){
        StringBuilder builder = new StringBuilder(5);
        assertThat(builder.capacity(), is(5));

        builder.append("Hello world");
        assertThat(builder.capacity() > 5,is(true));
    }

    @Test
    public void insertIntoAStringBuilder(){
        StringBuilder builder = new StringBuilder();

//    Insert a String into an empty StringBuilder
        builder.insert(0,"12345678");
        System.out.println(builder);

//    Insert a String in the middle
        builder.insert(builder.length()/2,"Hello");
        System.out.println(builder);

//    Insert a String on the end
        builder.insert(builder.length(),"End");
        System.out.println(builder);
    }
}
