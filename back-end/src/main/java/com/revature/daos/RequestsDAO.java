package com.revature.daos;

import com.revature.models.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestsDAO extends JpaRepository<Requests, Integer> {

    //This is our entire DAO for now... showing custom DAO method below

    //public Optional<List<Users>> getByUsernameAndPassword(String username, String password);



}
