package com.revature.daos;

import com.revature.models.Accounts;
import com.revature.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TransactionsDAO extends JpaRepository<Transactions, Integer> {

    //This is our entire DAO for now... showing custom DAO method below

    @Query("select t from Transactions t where t.transactionType = ?expense")
    public Optional<List<Transactions>> getByTransaction(String transactionType);


}