package com.revature.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

//All of these annotations come from the JPA (Java Persistence API)
@Entity //This annotation makes this class a DB table (or database entity in other words)
@Table(name="accounts") //This annotation lets us give the DB table a different name
@Component //We want this class to be a bean
public class Accounts {


    @Id //This will make this field the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This makes our PK serial
    private int accountId;

    //non-id columns don't technically need any annotation at all
    //BUT @Column is good for clarity and any constraints you may need

<<<<<<< HEAD
    @Column //now this column has a not null constraint
    private int accountIdRecipient;

    @Column(nullable = false) //now this column has a not null constraint
    private String accountHolder;

    @Column //now this column has a not null constraint
    private String accountHolderRecipient;

=======
    @Column(nullable = false) //now this column has a not null constraint
    private String accountHolder;

>>>>>>> 6dba3e83bd3367e06c81f8e00175b5ced0fe19b6

    @Column(columnDefinition="Decimal(10,2)")
    private double transactionAmount;

    @Column(columnDefinition="Decimal(10,2)")
    private double accountBalance;


    //FK relationship
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "transactionId")

    private Transactions transaction;

    public Accounts() {
    }

<<<<<<< HEAD
    //All fields in constructor
    public Accounts(int accountId, int accountIdRecipient, String accountHolder, String accountHolderRecipient, double transactionAmount, double accountBalance, Transactions transaction) {
        this.accountId = accountId;
        this.accountIdRecipient = accountIdRecipient;
        this.accountHolder = accountHolder;
        this.accountHolderRecipient = accountHolderRecipient;
        this.transactionAmount = transactionAmount;
        this.accountBalance = accountBalance;
        this.transaction = transaction;
    }

    //Constructor for depositing/withdrawing money
    public Accounts(int accountId, String accountHolder, String accountHolderRecipient, double transactionAmount, double accountBalance, Transactions transaction) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.accountHolderRecipient = accountHolderRecipient;
        this.transactionAmount = transactionAmount;
        this.accountBalance = accountBalance;
        this.transaction = transaction;
    }

    //Constructor for sending money


    public Accounts(int accountId, int accountIdRecipient, String accountHolder, String accountHolderRecipient, double transactionAmount, double accountBalance) {
        this.accountId = accountId;
        this.accountIdRecipient = accountIdRecipient;
        this.accountHolder = accountHolder;
        this.accountHolderRecipient = accountHolderRecipient;
        this.transactionAmount = transactionAmount;
        this.accountBalance = accountBalance;
    }

=======
>>>>>>> 6dba3e83bd3367e06c81f8e00175b5ced0fe19b6
    public Accounts(int accountId, String accountHolder, double transactionAmount, double accountBalance, Transactions transaction) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.transactionAmount = transactionAmount;
        this.accountBalance = accountBalance;
        this.transaction = transaction;
    }

    public Accounts(int accountId, String accountHolder, double accountBalance, Transactions transaction) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
        this.transaction = transaction;
    }

    public Accounts(int accountId, String accountHolder, double accountBalance) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

<<<<<<< HEAD
    public int getAccountIdRecipient() {
        return accountIdRecipient;
    }

    public void setAccountIdRecipient(int accountIdRecipient) {
        this.accountIdRecipient = accountIdRecipient;
    }

=======
>>>>>>> 6dba3e83bd3367e06c81f8e00175b5ced0fe19b6
    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

<<<<<<< HEAD
    public String getAccountHolderRecipient() {
        return accountHolderRecipient;
    }

    public void setAccountHolderRecipient(String accountHolderRecipient) {
        this.accountHolderRecipient = accountHolderRecipient;
    }

=======
>>>>>>> 6dba3e83bd3367e06c81f8e00175b5ced0fe19b6
    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Transactions getTransaction() {
        return transaction;
    }

    public void setTransaction(Transactions transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "accountId=" + accountId +
<<<<<<< HEAD
                ", accountIdRecipient='" + accountIdRecipient + '\'' +
                ", accountHolder='" + accountHolder + '\'' +
                ", accountHolderRecipient='" + accountHolderRecipient + '\'' +
=======
                ", accountHolder='" + accountHolder + '\'' +
>>>>>>> 6dba3e83bd3367e06c81f8e00175b5ced0fe19b6
                ", transactionAmount=" + transactionAmount +
                ", accountBalance=" + accountBalance +
                ", transaction=" + transaction +
                '}';
    }
}
