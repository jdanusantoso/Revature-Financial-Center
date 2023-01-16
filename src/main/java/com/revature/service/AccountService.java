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

    public void transferMoney(Accounts a, Accounts from, Accounts to, Double transactionAmount){

        if(a.getAccountId() == a.getAccountIdRecipient()){
            throw new InvalidAccountTransferException();
        }

        withdrawMoney(from, transactionAmount);
        depositMoney(to, transactionAmount);
        accountDAO.updateAccount(a);

    }

}
