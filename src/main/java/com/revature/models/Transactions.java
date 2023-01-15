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

    @Column
    private int accountIdTransactionRecipient;

    @Column
    private String transactionMemo;

    @Column(nullable = false)
    private String transactionType;

    @Column(nullable = false, columnDefinition="Decimal(10,2)")
    private double transactionAmount;

    public Transactions() {
    }

    public Transactions(int transactionId, int accountIdTransaction, int accountIdTransactionRecipient, String transactionMemo, String transactionType, double transactionAmount) {
        this.transactionId = transactionId;
        this.accountIdTransaction = accountIdTransaction;
        this.accountIdTransactionRecipient = accountIdTransactionRecipient;
        this.transactionMemo = transactionMemo;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    public Transactions(int transactionId, int accountIdTransactionRecipient, String transactionMemo, String transactionType, double transactionAmount) {
        this.transactionId = transactionId;
        this.accountIdTransactionRecipient = accountIdTransactionRecipient;
        this.transactionMemo = transactionMemo;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    public Transactions(int transactionId, int accountIdTransactionRecipient, String transactionType, double transactionAmount) {
        this.transactionId = transactionId;
        this.accountIdTransactionRecipient = accountIdTransactionRecipient;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountIdTransactionSender() {
        return accountIdTransaction;
    }

    public void setAccountIdTransactionSender(int accountIdTransactionSender) {
        this.accountIdTransaction = accountIdTransactionSender;
    }

    public int getAccountIdTransactionRecipient() {
        return accountIdTransactionRecipient;
    }

    public void setAccountIdTransactionRecipient(int accountIdTransactionRecipient) {
        this.accountIdTransactionRecipient = accountIdTransactionRecipient;
    }

    public String getTransactionMemo() {
        return transactionMemo;
    }

    public void setTransactionMemo(String transactionMemo) {
        this.transactionMemo = transactionMemo;
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
                ", accountIdTransactionSender=" + accountIdTransaction +
                ", accountIdTransactionRecipient=" + accountIdTransactionRecipient +
                ", transactionMemo='" + transactionMemo + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", transactionAmount=" + transactionAmount +
                '}';
    }
}
