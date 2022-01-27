package javafortester.chap018propertiesandpropertyfiles.example;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PropertiesAndPropertyFilesTest {

    @Test
    public void createAndListPropertiesObject(){
//    Creates a Properties object
        Properties properties = new Properties();

//    Add the following “key, value” pairs: name=bob, gender=male, password=paSSw0rd
        properties.setProperty("name","Bob");
        properties.setProperty("gender","male");
        properties.setProperty("password","paSSw0rd");

//    Assert that the size of the Properties object is 3
        assertThat(properties.size(), is(3));

//    Output the “key, value” pairs to the console by iterating over the keys
        for(String keyword : properties.stringPropertyNames()){
            System.out.println("key: "+ keyword +"\t | "+
                               "value: " + properties.getProperty(keyword));
        }

//    Use the list method to output the properties
        properties.list(System.out);

//    Assert that the Properties object contains the key gender
        assertTrue(properties.containsKey("gender"));

//    Assert that the value of the property name is bob
        assertThat(properties.getProperty("name"), is("Bob"));

//    Use getProperty with a default value and assert that the value of key "permission" is "Admin"
        assertEquals("Admin", properties.getProperty("permisstion","Admin"));
    }

    @Test
    public void outputTheSystemPropertiesObject(){
        System.getProperties().list(System.out);
    }

    @Test
    public void storeAndLoadASavedPropertiesFile() throws IOException {
//    Create a Properties object
        Properties properties = new Properties();

//    Add some "key,value" pairs to the Properties
        properties.setProperty("key1", "value1");
        properties.setProperty("key2", "value2");

//    Store the Properties file in the "java.io.tmpdir
        String tempDirectory = System.getProperty("java.io.tmpdir");
        String tempResourceFilePath = tempDirectory + "tempFile.properties";

        FileOutputStream fileOutputStream = new FileOutputStream(tempResourceFilePath);
        properties.store(fileOutputStream, "File has been stored");

        fileOutputStream.close();

//    Read the Properties file and assert on the values
        FileReader fileReader = new FileReader(tempResourceFilePath);
        try {
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            fileReader.close();
        }
        assertThat(properties.getProperty("key1"), is("value1"));
        assertThat(properties.getProperty("key2"), is("value2"));

//    Delete the Properties file when you are finished
        new File(tempDirectory).delete();
    }

}
