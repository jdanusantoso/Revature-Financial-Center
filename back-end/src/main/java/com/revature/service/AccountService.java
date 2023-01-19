package com.revature.service;

import com.revature.daos.AccountsDAO;
import com.revature.exception.InvalidAccountTransferException;
import com.revature.exception.OverDraftException;
import com.revature.models.Accounts;
import com.revature.models.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccountService {

    private AccountsDAO accountDAO;

    @Autowired
    public void withdrawMoney(Accounts a, Double transactionAmount) {

        if(transactionAmount > a.getTransactionAmount() ){
            throw new OverDraftException();
        }

        a.setAccountBalance(a.getAccountBalance() - transactionAmount);
        accountDAO.updateAccount(a);
    }

    public void depositMoney(Accounts a, Double transactionAmount) {
        a.setAccountBalance(a.getAccountBalance() + transactionAmount);
        accountDAO.updateAccount(a);
    }

    public void withdrawMoney(Accounts a, Accounts accountHolder, Double transactionAmount) {

        if(transactionAmount > a.getTransactionAmount() ){
            throw new OverDraftException();
        }

        a.setAccountHolder(a.getAccountHolder());
        a.setAccountBalance(a.getAccountBalance() - transactionAmount);
        accountDAO.updateAccount(a);
    }

    public void depositMoney(Accounts a, Accounts accountHolderRecipient, Double transactionAmount) {
        a.setAccountHolderRecipient(a.getAccountHolderRecipient());
        a.setAccountBalance(a.getAccountBalance() + transactionAmount);
        accountDAO.updateAccount(a);
    }

    public void transferMoney(Accounts accountId, Accounts accountIdRecipient, double transactionAmount) {
        //throw an exception if theres not enough money, and stop transaction before transfering
        withdrawMoney(accountId, transactionAmount);
        depositMoney(accountIdRecipient, transactionAmount);
    }

    public void sendMoney(Accounts accountId, Accounts accountHolder, Accounts accountIdRecipient, Accounts accountHolderRecipient, double transactionAmount) {

        if(accountHolder.equals(accountHolderRecipient)){
            throw new InvalidAccountTransferException();
        }

        //throw an exception if theres not enough money, and stop transaction before transfering
        withdrawMoney(accountId, accountHolder, transactionAmount);
        depositMoney(accountIdRecipient, accountHolderRecipient, transactionAmount);
    }


}
