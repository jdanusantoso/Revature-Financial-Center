package com.revature.service;

import com.revature.daos.AccountsDAO;
import com.revature.exception.InvalidAccountTransferException;
import com.revature.models.Accounts;
import com.revature.models.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccountService {

    private AccountsDAO accountDAO;

    @Autowired
    public AccountService(AccountsDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void depositMoney(Accounts a, double transactionAmount) {
        a.setAccountBalance(a.getAccountBalance() + transactionAmount);
        accountDAO.updateAccount(a);
    }

    public void withdrawMoney(Accounts a, double transactionAmount) {
        a.setAccountBalance(a.getAccountBalance() - transactionAmount);
        accountDAO.updateAccount(a);
    }

    public void transferMoney(Accounts accountId, Accounts accountIdRecipient, Double transactionAmount){

        if(accountId != accountIdRecipient){
            throw new InvalidAccountTransferException();
        }

        withdrawMoney(accountId, transactionAmount);
        depositMoney(accountIdRecipient, transactionAmount);


    }

    public void sendMoney(Accounts accountId, Accounts accountHolder, Accounts accountHolderRecipient, Accounts accountIdRecipient, Double transactionAmount){

        if(accountHolder == accountHolderRecipient){
            throw new InvalidAccountTransferException();
        }

        withdrawMoney(accountId, transactionAmount);
        depositMoney(accountIdRecipient, transactionAmount);


    }



}
