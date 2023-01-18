package com.revature.BankingApp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.revature") //we need this to scan for Spring Beans
@EnableJpaRepositories("com.revature.daos") //register our DAO as a bean (since it's interfaces)
@EntityScan("com.revature") //register our model classes as DB entities
public class BankingApp1Application {

	public static void main(String[] args) {

		SpringApplication.run(BankingApp1Application.class, args);



	}


}