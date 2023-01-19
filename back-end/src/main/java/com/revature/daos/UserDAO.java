package com.revature.daos;

import com.revature.models.Transactions;
import com.revature.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDAO extends JpaRepository<Users, Integer> {

    public Optional<List<Users>> getByUsernameAndPassword(String username, String password);



}
