package com.revature;

import com.revature.models.Transactions;
import com.revature.models.Users;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {Transactions.class, Users.class})

class BankingApp1ApplicationTests {

	//Test 1
	@Test
	void contextLoads() {
	}

	//Test 2 : Getting correct transaction id
	@Test
	void testGetTransactionId() {
	}

	//Test 3 : Getting correct account id transaction
	@Test
	void testGetAccountTransactionId() {
	}

	//Test 4 : Getting correct transaction type
	@Test
	void testGetTransactionType1() {
	}

	//Test 5 : Getting incorrect transaction type
	@Test
	void testGetTransactionType2() {
	}

	//Test 6 : Getting correct transaction amount
	@Test
	void testGetTransactionAmount() {
	}

	//Test 7 : Getting correct user id
	@Test
	public void testGetUserId() {

	}


	//Test 8 : Getting correct first name
	@Test
	public void testGetUserFirstName() {

	}


	//Test 9 : Getting correct last name
	@Test
	public void testGetUserLastName() {

	}

	//Test 10 : Getting correct email
	@Test
	public void testGetEmail() {

	}

	//Test 11 : Getting correct username
	@Test
	public void testGetUsername() {

	}

	//Test 12 : Getting incorrect username (Case Sensitive)
	@Test
	public void testGetUsername1() {

	}

	//Test 13 : Getting username not found
	@Test
	public void testGetUsername2() {

	}

	//Test 14 : Getting correct password
	@Test
	public void testGetPassword() {

	}

	//Test 15 : Getting incorrect password (Case Sensitive)
	@Test
	public void testGetPassword1() {

	}

	//Test 16 : Getting password not found
	@Test
	public void testGetPassword2() {

	}

}
