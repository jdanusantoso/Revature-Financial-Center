import React, { useState } from "react";
import axios from "axios";
import "./account.css";
import { useNavigate } from "react-router-dom";

const Login: React.FC<any> = () => {
  const [error, setError] = useState("");
  const account = {
    idNum: 0,
    accountId: 0,
    accountIdRecipient: 0,
    accountHolder: "",
    accountHolderRecipient: "",
    transactionAmount: 0.0,
    accountBalance: 0.0,
    accountRecipientBalance: 0.0,
    users: "",
  };

  //useState hooks to declare some state that will hold username and password
  const [idNum, setId] = useState("");
  const [accountId, setaccountId] = useState("");
  const [accountIdRecipient, setaccountIdRecipient] = useState("");
  const [accountHolder, setidaccountHolderNum] = useState("");
  const [accountHolderRecipient, setaccountHolderRecipient] = useState("");
  const [transactionAmount, settransactionAmount] = useState("");
  const [accountBalance, setaccountBalance] = useState("");
  const [accountRecipientBalance, setaccountRecipientBalance] = useState("");
  const [users, setusers] = useState("");
  //we'll use this object to switch components whenever appropriate
  //this is what lets us navigate to different components with events - no more manual URL changes!
  const navigate = useNavigate();

  /* when the account updates the username/password this will be called thanks to onChange
  the username OR password state will get updated based on the name of the input that's changing */
  const gatherInputs = (input: any) => {
    if (input.target.name === "accountNum") {
      setId(input.target.value);
    }
  };

  const login = async () => {
    //send an HTTP POST request with axios, and store the response in a variable that we can use
    try {
      const response = await axios.get(
        "http://localhost:5556/data/accounts/accountIdRecipient/" + idNum
      );
      console.log(response);
      if (response.status === 200) {
        account.accountId = response.data.accountId;
        account.accountIdRecipient = response.data.accountIdRecipient;
        account.accountHolder = response.data.accountHolder;
        account.accountHolderRecipient = response.data.accountHolderRecipient;
        account.transactionAmount = response.data.transactionAmount;
        account.accountBalance = response.data.accountBalance;
        account.accountRecipientBalance = response.data.accountRecipientBalance;
        account.users = response.data.users;

        setaccountId(response.data.accountId);
        setaccountIdRecipient(response.data.accountIdRecipient);
        setidaccountHolderNum(response.data.accountHolder);
        setaccountHolderRecipient(response.data.accountHolderRecipient);
        settransactionAmount(response.data.transactionAmount);
        setaccountBalance(response.data.accountBalance);
        setaccountRecipientBalance(response.data.accountRecipientBalance);
        setusers(response.data.users);

        //if the account logged in successfully, their userId won't be 0.
        if (response.data[0].accountId == null) {
          console.log("Error");
        } else {
          //populate our account object from above with the incoming data from the server
        }
      } else {
        console.log("ERROR" + response);
      }
    } catch (error) {
      const err = error as Error;
      setError("account Already Found");
    }
  };

  return (
    <div className="login">
      {error && <p className="error-message">{error}</p>}

      <div className="textlogin">
        <h1>Welcome to Revature Financial Center</h1>
      </div>
      <div className="account">
        <input
          type="number"
          name="accountNum"
          placeholder="accountNum"
          onChange={gatherInputs}
        />
      </div>

      <button className="login-button" onClick={login}>
        Search
      </button>

      <div className="account-display">
        <p>Account ID: {accountId}</p>
        <p>accountIdRecipient: {accountIdRecipient}</p>
        <p>accountHolder: {accountHolder}</p>
        <p>accountHolderRecipient: {accountHolderRecipient}</p>
        <p>transactionAmount: {transactionAmount}</p>
        <p>accountBalance: {accountBalance}</p>
        <p>accountRecipientBalance: {accountRecipientBalance}</p>
        <p>users: {users}</p>
      </div>
    </div>
  );
};
export default Login;
