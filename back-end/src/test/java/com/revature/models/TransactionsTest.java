package com.revature.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import static org.junit.Assert.*;

public class TransactionsTest{

    //Create Transactions Instance

    Transactions transaction = new Transactions(1, 1, "income", /*-*/89.00 );

    @Before
    public void setUp() throws Exception{

    }

    @After
    public void tearDown() throws Exception {

    }

    //Test 1
    @Test
    public void testGetTransactionId() {

        int expected = 1;
        int actual = transaction.getTransactionId();
        assertEquals(expected, actual);
        //fail("Not yet implemented");

    }

    //Test 2
    @Test
    public void testGetAccountIdTransaction() {

        int expected = 1;
        int actual = transaction.getAccountIdTransaction();
        assertEquals(expected, actual);
        //fail("Not yet implemented");

    }

    //Test 3
    @Test
    public void testGetTransactionType1() {

        String expected = "income";
        String actual = transaction.getTransactionType();
        assertTrue(expected.equals(actual));
        //fail("Not yet implemented");

    }

    //Test 4
    @Test
    public void testGetTransactionType2() {

        String expected = "expense";
        String actual = transaction.getTransactionType();
        assertTrue(expected.equals(actual));
        //fail("Not yet implemented");

    }

    //Test 5
    @Test
    public void testGetTransactionAmount() {

        double expected = 89.00;
        double actual = transaction.getTransactionAmount();
        assertEquals(expected, actual, 0.001);
        //fail("Not yet implemented");

    }

//    //Test 5
//    @Test
//    public void testGetTransactionAmount2() {
//
//        double expected = 89.00;
//        double actual = transaction.getTransactionAmount();
//        assertEquals(expected, actual, 0.001);
//        //fail("Not yet implemented");
//
//    }
}
