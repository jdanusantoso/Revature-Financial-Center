package com.revature.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity //makes the class a DB table
@Table(name = "requests")
@Component
public class Requests {

    @Id //makes the field the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;

    @Column (nullable = false)
    private String accountHolderRequest;

    @Column (nullable = false)
    private String accountHolderRecipientRequest;

    @Column
    private String memoRequest;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String requestTransactionType = "income";

    @Column(nullable = false, columnDefinition="Decimal(10,2)")
    private double transactionAmount;

    //FK relationship that shows many transactions to 1 account
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "accountId")

    private Accounts account;

    public Requests() {
    }

    public Requests(int requestId, String accountHolderRequest, String accountHolderRecipientRequest, String memoRequest, String requestTransactionType, double transactionAmount, Accounts account) {
        this.requestId = requestId;
        this.accountHolderRequest = accountHolderRequest;
        this.accountHolderRecipientRequest = accountHolderRecipientRequest;
        this.memoRequest = memoRequest;
        this.requestTransactionType = requestTransactionType;
        this.transactionAmount = transactionAmount;
        this.account = account;
    }

    public Requests(int requestId, String accountHolderRequest, String accountHolderRecipientRequest, String requestTransactionType, double transactionAmount, Accounts account) {
        this.requestId = requestId;
        this.accountHolderRequest = accountHolderRequest;
        this.accountHolderRecipientRequest = accountHolderRecipientRequest;
        this.requestTransactionType = requestTransactionType;
        this.transactionAmount = transactionAmount;
        this.account = account;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getAccountHolderRequest() {
        return accountHolderRequest;
    }

    public void setAccountHolderRequest(String accountHolderRequest) {
        this.accountHolderRequest = accountHolderRequest;
    }

    public String getAccountHolderRecipientRequest() {
        return accountHolderRecipientRequest;
    }

    public void setAccountHolderRecipientRequest(String accountHolderRecipientRequest) {
        this.accountHolderRecipientRequest = accountHolderRecipientRequest;
    }

    public String getMemoRequest() {
        return memoRequest;
    }

    public void setMemoRequest(String memoRequest) {
        this.memoRequest = memoRequest;
    }

    public String getRequestTransactionType() {
        return requestTransactionType;
    }

    public void setRequestTransactionType(String requestTransactionType) {
        this.requestTransactionType = requestTransactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Requests{" +
                "requestId=" + requestId +
                ", accountHolderRequest='" + accountHolderRequest + '\'' +
                ", accountHolderRecipientRequest='" + accountHolderRecipientRequest + '\'' +
                ", memoRequest='" + memoRequest + '\'' +
                ", requestTransactionType='" + requestTransactionType + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", account=" + account +
                '}';
    }
}
