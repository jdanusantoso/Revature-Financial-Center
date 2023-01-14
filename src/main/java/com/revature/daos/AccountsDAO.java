package com.revature.daos;

import com.revature.models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsDAO extends JpaRepository<Accounts, Integer> {

    //This is our entire DAO for now... showing custom DAO method below

}
