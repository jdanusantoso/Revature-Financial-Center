package com.revature.daos;

import com.revature.models.Transactions;
import com.revature.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends JpaRepository<Users, Integer> {

    //This is our entire DAO for now... showing custom DAO method below

    public Optional<List<Users>> getByUsernameAndPassword(String username, String password);


}
