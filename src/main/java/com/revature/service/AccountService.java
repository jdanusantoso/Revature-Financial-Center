package com.revature.service;

import com.revature.daos.AccountsDAO;
import com.revature.exception.InvalidAccountTransferException;
import com.revature.exception.InvalidAmountException;
import com.revature.exception.OverDraftException;
import com.revature.models.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccountService {

    private AccountsDAO accountDAO;

    @Autowired
    public AccountService(AccountsDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public /*void*/ double depositMoney(Accounts a, double transactionAmount) {

        if (transactionAmount <= 0){
            System.out.println("Please enter an appropriate amount.");
        }

        double newAccountBalance =(a.getAccountBalance() + transactionAmount);

        a.setAccountBalance(newAccountBalance);
        accountDAO.updateAccount(a);
        return a.getAccountBalance();
    }

    public /*void*/ double withdrawMoney(Accounts a, double transactionAmount) {

        if(a.getTransactionAmount() > a.getAccountBalance()){
            throw new OverDraftException();
        }

        return (a.getAccountBalance() - transactionAmount);
//        a.setAccountBalance(newWithdrawalAccountBalance);
//        accountDAO.updateAccount(a);
//        return a.getAccountBalance();
    }

    public void transferMoney(Accounts a, Accounts from, Accounts to, Double transactionAmount){

        if(a.getAccountId() == a.getAccountIdReceipient()){
            throw new InvalidAccountTransferException();
        }

        withdrawMoney(from, transactionAmount);
        depositMoney(to, transactionAmount);

    }



}
