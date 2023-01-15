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
    private int accountTransId;
    @Column(nullable = false)
    private String expenseType;

    @Column(nullable = false, columnDefinition="Decimal(10,2)")
    private double TransactionAmount;

    public Transactions() {
    }

    public Transactions(int transactionId, int accountTransId, String expenseType, double transactionAmount) {
        this.transactionId = transactionId;
        this.accountTransId = accountTransId;
        this.expenseType = expenseType;
        TransactionAmount = transactionAmount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountTransId() {
        return accountTransId;
    }

    public void setAccountTransId(int accountTransId) {
        this.accountTransId = accountTransId;
    }


    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public double getTransactionAmount() {
        return TransactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        TransactionAmount = transactionAmount;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transactionId=" + transactionId +
                ", accountTransId=" + accountTransId +
                ", expenseType='" + expenseType + '\'' +
                ", TransactionAmount=" + TransactionAmount +
                '}';
    }
}
