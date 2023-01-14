package com.revature.daos;

import com.revature.models.Accounts;
import com.revature.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsDAO extends JpaRepository<Transactions, Integer> {

    //This is our entire DAO for now... showing custom DAO method below

}