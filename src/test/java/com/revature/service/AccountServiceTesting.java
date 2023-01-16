package com.revature.service;

import com.revature.models.Accounts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountService.class)
class AccountServiceTesting {

    @MockBean
    public static AccountService accountsService;

    Accounts a;
    double delta = 0.001;

    @BeforeEach
    void setUp() {
        a = new Accounts();
        a.setAccountHolder("John");
        a.setAccountBalance(4500);
        a.setTransactionAmount(0);
        a.setAccountId(1);
    }

    @AfterEach
    void reset() throws Exception {
        a = null;
    }

    //Test 6
    @Test
    void depositTest1() {
        accountsService.depositMoney(a, a.getAccountBalance());
        double actual = (a.getTransactionAmount() + a.getAccountBalance());
        assertEquals(5300, actual, 0.001);

    }

    //Test 7
    @Test
    void depositTest2() {
        accountsService.depositMoney(a, a.getAccountBalance());
        double actual = (a.getAccountBalance() +a.getTransactionAmount());
        assertEquals(5500, actual, 0.001);

    }

    //Test 8
    @Test
    void withdrawTest1() {
        accountsService.withdrawMoney(a, a.getAccountBalance());
        double actual = ( a.getAccountBalance() -a.getTransactionAmount()); //-800
        assertEquals(4500, actual, 0.001);

    }

    //Test 9
    @Test
    void withdrawTest2() {
        accountsService.withdrawMoney(a, a.getAccountBalance());
        double actual = ( a.getAccountBalance() -a.getTransactionAmount());
        assertEquals(3700, actual, 0.001);

    }

    //Test 10
    @Test
    void withdrawTest3() {
        accountsService.withdrawMoney(a, a.getAccountBalance());
        double actual = ( a.getAccountBalance() -a.getTransactionAmount()); //account transaction amount is 0
        assertEquals(4500, actual, 0.001);

    }





}


