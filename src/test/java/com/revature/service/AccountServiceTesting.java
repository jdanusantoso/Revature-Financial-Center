package com.revature.service;

import com.revature.daos.AccountsDAO;
import com.revature.exception.InvalidAccountTransferException;
import com.revature.exception.InvalidAmountException;
import com.revature.exception.OverDraftException;
import com.revature.models.Accounts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountService.class)
class AccountServiceTesting {

    @MockBean
    public static AccountService accountsService;

    Accounts account;
    double delta = 0.001;

    @BeforeEach
    void setUp() throws Exception {
        account= new Accounts();
        account.setAccountHolder("John");
        account.setAccountBalance(4500);
        account.setAccountId(1);
    }

    @AfterEach
    void tearDown() throws Exception {
        account=null;
    }


    /*__________________________________Deposits___________________________________________*/


    @Test
    void AccountServiceTestingTest1() {

        accountsService.withdrawMoney(account, -800);
        System.out.print(account.getTransactionAmount());


        assertEquals(3700, account.getAccountBalance(), 0.01 );

    }


    /*__________________________________Withdrawals__________________________________________________*/



    /*
    public void withdrawMoney(Accounts a, double transactionAmount) {

        if(a.getTransactionAmount() > a.getAccountBalance()){
            throw new OverDraftException();
        }

        a.setAccountBalance(a.getAccountBalance() - transactionAmount);
        accountDAO.updateAccount(a);
    }

    public void transferMoney(Accounts a, Accounts from, Accounts to, Double transactionAmount){

        if(a.getAccountId() == a.getAccountIdReceipient()){
            throw new InvalidAccountTransferException();
        }

        withdrawMoney(from, transactionAmount);
        depositMoney(to, transactionAmount);

    }

*/

}
