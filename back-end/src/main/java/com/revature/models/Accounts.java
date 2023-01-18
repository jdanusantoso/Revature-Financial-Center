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

    @Column //now this column has a not null constraint
    private int accountIdRecipient;

    @Column(nullable = false) //now this column has a not null constraint
    private String accountHolder;

    @Column //now this column has a not null constraint
    private String accountHolderRecipient;


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

    //Constructor for transfering money

    public Accounts(int accountId, int accountIdRecipient, double transactionAmount) {
        this.accountId = accountId;
        this.accountIdRecipient = accountIdRecipient;
        this.transactionAmount = transactionAmount;
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

    public int getAccountIdRecipient() {
        return accountIdRecipient;
    }

    public void setAccountIdRecipient(int accountIdRecipient) {
        this.accountIdRecipient = accountIdRecipient;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountHolderRecipient() {
        return accountHolderRecipient;
    }

    public void setAccountHolderRecipient(String accountHolderRecipient) {
        this.accountHolderRecipient = accountHolderRecipient;
    }

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
                ", accountIdRecipient='" + accountIdRecipient + '\'' +
                ", accountHolder='" + accountHolder + '\'' +
                ", accountHolderRecipient='" + accountHolderRecipient + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", accountBalance=" + accountBalance +
                ", transaction=" + transaction +
                '}';
    }
}
