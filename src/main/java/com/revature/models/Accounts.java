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

    @Column(nullable = false) //now this column has a not null constraint
    private String accountHolder;

    @Column
    private double accountBalance;

    public Accounts() {
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

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "accounts{" +
                "accountId=" + accountId +
                ", accountHolder='" + accountHolder + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
