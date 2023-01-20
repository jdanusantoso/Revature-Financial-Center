import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";

const Request: React.FC<any> = () => {
  const [error, setError] = useState("");

  const [moneyResquested, moneySet] = useState("");
  const user = {
    accountHolderRequest: "Goon",
    accountHolderRecipientRequest: "David",
    memoRequest: "Treats ",
    transactionAmount: 50,
  };

  console.log(user);

  const [requestId, setrequestId] = useState(0);
  const [accountHolderRequest, setaccountHolderRequest] = useState("");
  const [accountHolderRecipientRequest, setaccountHolderRecipientRequest] =
    useState("");
  const [memoRequest, setmemoRequest] = useState("");
  const [requestTransactionType, setrequestTransactionType] = useState("");
  const [transactionAmount, settransactionAmount] = useState(0);
  const [account, setaccount] = useState("");

  const appState = useSelector<any, any>((state) => state);

  const navigate = useNavigate();

  const login = async () => {
    try {
      const response = await axios.post(
        "http://localhost:5556/data/requests/newRequest",
        user
      );

      console.log(response);
      if (response.status === 202) {
        console.log(response);

        setrequestId(response.data.requestId);
        setaccountHolderRequest(response.data.accountHolderRequest);
        setaccountHolderRecipientRequest(
          response.data.accountHolderRecipientRequest
        );
        setmemoRequest(response.data.requestTransactionType);
        settransactionAmount(response.data.transactionAmount);
        setaccount(response.data.account);

        //if the account logged in successfully, their userId won't be 0.
        if (response.data == null) {
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

  const gatherInput = (input: any) => {
    if (input.target.name === "deposit") {
      moneySet(input.target.value);
    }
  };

  return (
    <div className="login">
      {error && <p className="error-message">{error}</p>}

      <div className="textlogin">
        <h1>Welcome to Revature Financial Center</h1>
        <h2>Request Window: {appState.user.username}</h2>
        <h2>1 accountBalance: {requestId}</h2>
        <h2>2 accountHolder: {accountHolderRequest}</h2>
        <h2>3 accountId: {accountHolderRecipientRequest}</h2>
        <h2>4 transactionAmount: {memoRequest}</h2>
        <h2>5 users: {requestTransactionType}</h2>
        <h2>5 users: {transactionAmount}</h2>
        <h2>5 users: {account}</h2>
      </div>

      <div className="deposit">
        <input
          type="number"
          name="deposit"
          placeholder="deposit"
          onChange={gatherInput}
        />
      </div>

      <button className="login-button" onClick={login}>
        deposit
      </button>
      <button
        className="dashboard-button"
        onClick={() => navigate("/dashboard")}
      >
        Dashboard
      </button>
    </div>
  );
};
export default Request;
