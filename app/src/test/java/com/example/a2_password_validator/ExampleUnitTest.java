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
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void passwordTest1() throws Exception {
        //this should return false since "password" is an invalid password
        assertFalse(MainActivity.validate("password"));

        //this should still return false since I have used .toLowerCase for the password
        assertFalse(MainActivity.validate("PAssWOrD"));

        //this should return false, too short
        assertFalse(MainActivity.validate("short"));

        //this should return true, just long enough
        assertTrue(MainActivity.validate("longenuf"));

        //this should return true, longer
        assertTrue(MainActivity.validate("verylongveryvalid"));

        //this should return true since it is a valid password
        assertTrue(MainActivity.validate("validplease"));

    }

}