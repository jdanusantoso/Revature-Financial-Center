package com.revature.service;

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
        a.setTransactionAmount(800);
        a.setAccountId(1);
    }

    @AfterEach
    void reset() throws Exception {
        a = null;
    }

    //Test 6
    @Test
    void withdrawTest() {
        double transactionAmount = 800;
        accountsService.depositMoney(a, transactionAmount);
        double actual = (transactionAmount + a.getAccountBalance());
        assertEquals(5300, actual, 0.001);

    }

}


