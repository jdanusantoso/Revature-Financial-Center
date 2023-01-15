package com.revature.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity //makes the class a DB table
@Table(name = "transactions")
@Component
public class Transactions {

    @Id //makes the field the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @Column(nullable = false)
    private int accountIdTransaction;
    @Column(nullable = false)
    private String transactionType;

    @Column(nullable = false, columnDefinition="Decimal(10,2)")
    private double transactionAmount;

    public Transactions() {
    }

    public Transactions(int transactionId, int accountIdTransaction, String transactionType, double transactionAmount) {
        this.transactionId = transactionId;
        this.accountIdTransaction = accountIdTransaction;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }


    public int getAccountIdTransaction() {
        return accountIdTransaction;
    }

    public void setAccountIdTransaction(int accountIdTransaction) {
        this.accountIdTransaction = accountIdTransaction;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transactionId=" + transactionId +
                ", accountIdTransaction=" + accountIdTransaction +
                ", transactionType='" + transactionType + '\'' +
                ", transactionAmount=" + transactionAmount +
                '}';
    }
}
