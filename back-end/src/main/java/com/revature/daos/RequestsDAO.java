package com.revature.daos;

import com.revature.models.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestsDAO extends JpaRepository<Requests, Integer> {


    //public Optional<List<Users>> getByUsernameAndPassword(String username, String password);



}
