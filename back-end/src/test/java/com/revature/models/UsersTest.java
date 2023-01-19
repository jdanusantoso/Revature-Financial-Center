package com.revature.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Transactions.class)
public class UsersTest {

    //Create Transactions Instance

    Users user = new Users(4, "Nettie", "Canape", "ncanapea@columbia.edu", "ncanapea", "Zg1pVyaUfPfm" );

    @Before
    public void setUp() throws Exception{

    }

    @After
    public void tearDown() throws Exception {

    }

    //Test 7
    @Test
    public void testGetUserId() {

        int expected = 4;
        int actual = user.getUserId();
        assertEquals(expected, actual);


    }


    //Test 8
    @Test
    public void testGetUserFirstName() {

        String expected = "Nettie";
        String actual = user.getFirstName();
        assertEquals(expected, actual);


    }

    //Test 9
    @Test
    public void testGetUserLastName() {

        String expected = "Canape";
        String actual = user.getLastName();
        assertEquals(expected, actual);


    }

    //Test 10
    @Test
    public void testGetEmail() {

        String expected = "ncanapea@columbia.edu";
        String actual = user.getEmail();
        assertEquals(expected, actual);
        //fail("Not yet implemented");

    }

    //Test 11
    @Test
    public void testGetUsername() {

        String expected = "ncanapea";
        String actual = user.getUsername();
        assertTrue(expected.equals(actual));
        //fail("Not yet implemented");

    }

    //Test 12
    @Test
    public void testGetUsername1() {

        String expected = "Ncanapea";
        String actual = user.getUsername();
        fail("Username cannot be found. Check your casing");

    }

    //Test 13
    @Test
    public void testGetUsername2() {

        String expected = "bubblesu";
        String actual = user.getPassword();
        fail("Username cannot be found. Please type it in again");

    }

    //Test 14
    @Test
    public void testGetPassword() {

        String expected = "zg1pVyaUfPfm";
        String actual = user.getPassword();
        fail("Password cannot be found. Check your casing");

    }

    //Test 15
    @Test
    public void testGetPassword1() {

        String expected = "Zg1pVyaUfPfm";
        String actual = user.getPassword();
        assertTrue(expected.equals(actual));


    }

    //Test 16
    @Test
    public void testGetPassword2() {

        String expected = "bubbles";
        String actual = user.getPassword();
        fail("Password cannot be found. Please type it in again");

    }



}
