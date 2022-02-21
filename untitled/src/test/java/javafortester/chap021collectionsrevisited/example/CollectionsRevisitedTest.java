package javafortester.chap021collectionsrevisited.example;

import javafortester.chap006.domainentities.InvalidPassword;
import javafortester.chap006.domainentities.User;
import javafortester.chap021collectionsrevisited.UserComparatorDisallowDupes;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CollectionsRevisitedTest {

  /*
  Exercise1: Remove the line code: 'if(val == 0)' in 'UserComparatorDisallowDupes' class
  - The code don't work when add an object have the length equal the length of object
  we added.
   */

  @Test
  public void disallowDuplicateUserNames() throws InvalidPassword {
    User bob = new User("Bob", "pA55Word!");
    User dupebob = new User("Bob", "a0bcdHello!");
    User rich = new User("Richie", "0RichieRichieRich!");
    User dupebob2 = new User("Bob", "B0obsMightyBigBobPassword!");
    User mrBeer = new User("Stafford", "0abcdSys!");
    User boby = new User("Boby", "pA5Word!");

    SortedSet<User> userSortedList = new TreeSet<User>(new UserComparatorDisallowDupes());

    userSortedList.add(bob);
    userSortedList.add(dupebob);
    userSortedList.add(rich);
    userSortedList.add(dupebob2);
    assertEquals(2, userSortedList.size());

    userSortedList.add(mrBeer);
    assertEquals(3, userSortedList.size());

    userSortedList.add(boby);
    assertEquals("Could not add boby",4, userSortedList.size());

    User[] users = new User[userSortedList.size()];
    userSortedList.toArray(users);

    assertEquals(bob.getUsername(), users[0].getUsername());
    assertEquals(mrBeer.getUsername(), users[2].getUsername());
    assertEquals(rich.getUsername(), users[3].getUsername());
  }


  @Test
  public void accessValueInAMapInKeyOrder(){
    SortedMap<String,String> userSortedMap = new TreeMap<>();

    userSortedMap.put("Bob","password1");
    userSortedMap.put("john","password12");
    userSortedMap.put("Bobby","password12");

    SortedSet<String> keys = new TreeSet<String>(userSortedMap.keySet());

    for (String key: keys){
      System.out.println("value of " + key + ": " + userSortedMap.get(key));
    }
  }

}
