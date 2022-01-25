package javafortester.chap010introducingcollection.example;

import javafortester.chap006.domainentities.InvalidPassword;
import javafortester.chap006.domainentities.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CollectionExample {

    @Test
    public void useAForLoopInsteadOfAWhileLoopTest() {
        String[] someDays = {"Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday", "Sunday"};
        List<String> days = Arrays.asList(someDays);

        /* Or another way
        List<String> days = new ArrayList<String>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        */

        int count = 0;
        while (!days.get(count).equals("Monday")) {
            count++;
        }
        Assert.assertEquals("Monday is at position " + count,
                0,
                count);

        for (int forCount = 0; !days.get(forCount).equals("Monday"); forCount++) {
            Assert.assertEquals("Monday is at position " + forCount,
                    0,
                    forCount);
        }
    }

    @Test
    public void createAndManipulateACollectionOfUsersTest() throws InvalidPassword {
//    Create a Collection of Users
        Collection users = new ArrayList();

//    Assert that the size() ==0 and isEmpty() == true
        Assert.assertEquals(0, users.size());
        Assert.assertTrue(users.isEmpty());

//    Create two User objects
        User user1 = new User("user1", "Password");
        User user2 = new User("user2", "Password");

//    Add the User objects to the collection
        users.add(user1);
        users.add(user2);

//    Assert that the size() == 2 and isEmpty() == false
        Assert.assertEquals(2, users.size());
        Assert.assertFalse(users.isEmpty());

        for (Object user : users) {
            System.out.println(user);
        }

//    Create a second collection with two different users
        Collection secondUsers = new ArrayList();
        User otherUser1 = new User("second user1", "Password");
        User otherUser2 = new User("second user2", "Password");
        secondUsers.add(otherUser1);
        secondUsers.add(otherUser2);

//    addAll the second collection to the first collection
        users.addAll(secondUsers);
        System.out.println("\nCollection after addAll:");
        for (Object user : users) {
            System.out.println(user);
        }

//    Check that the first collection now contains objects from the second collection
        Assert.assertEquals(4, users.size());
        Assert.assertTrue(users.containsAll(users));
        Assert.assertTrue(users.contains(otherUser1));
        Assert.assertTrue(users.contains(otherUser2));

//    RemoveAll the User object from the second collection
        users.removeAll(secondUsers);
        Assert.assertEquals(2, users.size());
        Assert.assertFalse(users.isEmpty());

//    Clear the first collection
        users.clear();
        Assert.assertEquals(0, users.size());
        Assert.assertTrue(users.isEmpty());
    }

    @Test
    public void createAndManipulateAListOfUsersTest() throws InvalidPassword {
//    Create the List
        List<User> usersList = new ArrayList<>();

//    Create two User object
        User users1 = new User("User list 1", "password");
        User users2 = new User("User list 2", "password");

//    Add a User to the list
        usersList.add(users1);
        usersList.add(users2);
        Assert.assertEquals(2, usersList.size());
        Assert.assertEquals(0, usersList.indexOf(users1));
        Assert.assertEquals(1, usersList.indexOf(users2));
        System.out.println("\nAdd a User to the list");
        for (Object user : usersList) {
            System.out.println(user);
        }

//    Add a User to the front of the list
        User users3 = new User("User list 3", "password");
        usersList.add(0, users3);
        Assert.assertEquals(0, usersList.indexOf(users3));
        System.out.println("\nAdd a User to the front of the list");
        for (Object user : usersList) {
            System.out.println(user);
        }
    }

    @Test
    public void createAndManipulateASetOfUsers() throws InvalidPassword {
//    Create a User
        User user = new User("user", "password");

//    Add the User to the Set
        Set<User> userSet = new HashSet<User>();
        userSet.add(user);

//    Add the User to the Set again
        userSet.add(user);

//    Check that the User has only been added to the Set once
        Assert.assertEquals(1, userSet.size());
    }

    @Test
    public void createAndManipulateAMapOfUserObjectsTest() throws InvalidPassword {
//    Create a Map of User objects
        Map<String, User> mapUser = new HashMap<>();
        Assert.assertEquals(0, mapUser.size());

//    Create two User objects
        User user1 = new User("user1", "password");
        User user2 = new User("user2", "password");

//    Add both User objects to the map using the same key
        mapUser.put(user1.getUsername(), user1);
        mapUser.put(user1.getUsername(), user2);
//        mapUser.put("hello", user2);

//    Check that only one User object has been added
        Assert.assertEquals(1, mapUser.size());
    }
}
