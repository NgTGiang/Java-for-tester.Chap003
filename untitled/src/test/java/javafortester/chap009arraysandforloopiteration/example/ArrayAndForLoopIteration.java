package javafortester.chap009arraysandforloopiteration.example;

import javafortester.chap006.domainentities.User;
import javafortester.chap009arraysandforloopiteration.MultipleArray;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ArrayAndForLoopIteration {

    @Test
    public void createAnArrayOfUserTest(){
        User[] arrayUsers = new User [3];
        arrayUsers[0] = new  User("user1", "passuser");
        arrayUsers[1] = new  User("user2", "passuser");
        arrayUsers[2] = new  User("user3", "passuser");

        assertEquals("user1", arrayUsers[0].getUsername());
        assertEquals("user2", arrayUsers[1].getUsername());
        assertEquals("user3", arrayUsers[2].getUsername());
    }

    @Test
    public void createAnArrayOf100Users(){
        User[] users = new User[100];

        for(int i = 0; i < 100; i++){
            users[i] = new User("user"+(i+1),"password"+(i+1));
            System.out.println(users[i].getUsername() + ", "+ users[i].getPassword());
        }

        int userId = 1;
        for(User user : users){
            assertEquals("user"+ userId, user.getUsername());
            assertEquals("password"+ userId, user.getPassword());
            userId++;

        }
    }

    @Test
    public void sortWorkdaysArrayAndAssertResultTest(){
        String[] workdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        Arrays.sort(workdays);
        for( int i = 0; i < workdays.length; i++ ){
           System.out.println(workdays[i]);
        }

        assertEquals("Friday", workdays[0]);
        assertEquals("Monday", workdays[1]);
        assertEquals("Thursday", workdays[2]);
        assertEquals("Tuesday", workdays[3]);
        assertEquals("Wednesday", workdays[4]);
    }

    @Test
    public void sortWorkdaysArrayMixedCaseTest(){
        String[] workdays = {"monday", "Tuesday", "Wednesday", "thursday", "Friday"};

        for( int i = 0; i < workdays.length; i++ ){
            workdays[i].toUpperCase();
        }

        Arrays.sort(workdays);

        assertEquals("FRIDAY", workdays[0]);
        assertEquals("MONDAY", workdays[1]);
        assertEquals("THURDAY", workdays[2]);
        assertEquals("TUESDAY", workdays[3]);
        assertEquals("WEDNESDAY", workdays[4]);
    }

    @Test
    public void print2DIntArray(){
       //Create Triangle
       int[][] triangle = new int [16][];

       for(int row = 0; row < triangle.length; row++){
           triangle[row] = new int[row+1];
           for (int i = 0; i < row+1; i++){
               triangle[row][i] = i;
           }
       }

       MultipleArray intArray = new MultipleArray();
       intArray.print2DIntArray(triangle);
    }
}
