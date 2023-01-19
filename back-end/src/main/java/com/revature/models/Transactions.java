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

    @Column(nullable = false, columnDefinition = "Decimal(10,2)")
    private double transactionAmount;

    //FK relationship that shows many transactions to 1 account
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId")

    private Accounts account;

    public Transactions() {
    }

    public Transactions(int transactionId, int accountIdTransaction, String transactionType, double transactionAmount, Accounts account) {
        this.transactionId = transactionId;
        this.accountIdTransaction = accountIdTransaction;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.account = account;
    }

}