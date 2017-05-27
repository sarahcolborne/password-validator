package com.example.a2_password_validator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void passwordTest1() throws Exception {
    //The following test were written for stage 1
    //I have had to edit some of these tests to account for my new rules
        //this should return false since "password" is an invalid password
        assertFalse(MainActivity.validate("password"));

        //this should still return false since I have used .toLowerCase for the password
        assertFalse(MainActivity.validate("PAssWOrD"));

        //this should return false, too short
        assertFalse(MainActivity.validate("Short1!"));

        //this should return true, just long enough
        assertTrue(MainActivity.validate("lOnnuf1!"));

        //this should return true, longer
        assertTrue(MainActivity.validate("vErylongveryvalid1!"));

        //this should return true since it is a valid password
        assertTrue(MainActivity.validate("vAlidplease1!"));

    //The following tests were written for stage 2
        //these tests check for a number in the password
        assertTrue(MainActivity.validate("hEllothere1!"));
        assertTrue(MainActivity.validate("hEllo2there!"));
        assertTrue(MainActivity.validate("3Hellothere!"));
        assertFalse(MainActivity.validate("Nonumshere!"));

        //these tests check for a ! or $ in the password
        assertTrue(MainActivity.validate("Hellothere1!"));
        assertFalse(MainActivity.validate("Shouldnotwork123"));
        assertTrue(MainActivity.validate("Hellothere1$"));
        assertTrue(MainActivity.validate("A!$!$!$!$1234"));

        //these tests check for an uppercase letter in the password
        assertTrue(MainActivity.validate("THISwillPASS1$!"));
        assertFalse(MainActivity.validate(("thiswillfailohnooooo1$")));
    }

}