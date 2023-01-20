package com.revature.daos;

import com.revature.models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountsDAOTesting extends JpaRepository<Accounts, Integer> {

    //This is our entire DAO for now... showing custom DAO method below

    public Optional<List<Accounts>> findByAccountHolder(String accountHolder);


    @Transactional
    @Modifying
    @Query("update Accounts a set a.accountBalance = ?1 where a.accountId = ?2")
    public void updateAccount(Accounts a);
}
