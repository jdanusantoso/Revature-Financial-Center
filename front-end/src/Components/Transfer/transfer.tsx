import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";

const Trans: React.FC<any> = () => {
  const [error, setError] = useState("");

  const [name1, setn1] = useState("");
  const [name2, setn2] = useState("");
  const [id1, seti1] = useState(0);
  const [id2, seti2] = useState(0);
  const [amount, setAmount] = useState(0);

  const [accountBalance, setemail] = useState("");
  const [accountHolder, setfirstName] = useState("");
  const [accountId, setlastName] = useState("");
  const [transactionAmount, setpassword] = useState("");
  const [users, setuserId] = useState(0);

  const appState = useSelector<any, any>((state) => state);

  const navigate = useNavigate();

  const login = async () => {
    try {
      const response = await axios.patch(
        "http://localhost:5556/data/accounts/sendMoney/" +
          name1 +
          "/" +
          id1 +
          "/" +
          amount,
        {}
      );
      console.log("START");
      console.log(response);
      if (response.status === 200) {
        console.log(response);

        setemail(response.data.accountBalance);
        setfirstName(response.data.accountHolder);
        setlastName(response.data.accountId);
        setpassword(response.data.transactionAmount);
        setuserId(response.data.users);

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

    try {
      const response = await axios.patch(
        "http://localhost:5556/data/accounts/sendMoney/" +
          name2 +
          "/" +
          id2 +
          "/-" +
          amount,
        {}
      );
      console.log("START2");
      console.log(response);
      if (response.status === 200) {
        console.log(response);

        setemail(response.data.accountBalance);
        setfirstName(response.data.accountHolder);
        setlastName(response.data.accountId);
        setpassword(response.data.transactionAmount);
        setuserId(response.data.users);

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
    if (input.target.name === "name1") {
      setn1(input.target.value);
    } else if (input.target.name === "name2") {
      setn2(input.target.value);
    } else if (input.target.name === "id1") {
      seti1(input.target.value);
    } else if (input.target.name === "id2") {
      seti2(input.target.value);
    } else {
      setAmount(input.target.value);
    }
  };

  return (
    <div className="login">
      {error && <p className="error-message">{error}</p>}

      <div className="textlogin">
        <h1>Welcome to Revature Financial Center</h1>
        <h2>deposit Window: {appState.user.username}</h2>
        <h2>1 accountBalance: {accountBalance}</h2>
        <h2>2 accountHolder: {accountHolder}</h2>
        <h2>3 accountId: {accountId}</h2>
        <h2>4 transactionAmount: {transactionAmount}</h2>
        <h2>5 users: {users}</h2>
      </div>

      <div className="name1">
        <input
          type="text"
          name="name1"
          placeholder="name1"
          onChange={gatherInput}
        />
      </div>

      <div className="name2">
        <input
          type="text"
          name="name2"
          placeholder="name2"
          onChange={gatherInput}
        />
      </div>

      <div className="id1">
        <input
          type="number"
          name="id1"
          placeholder="id1"
          onChange={gatherInput}
        />
      </div>

      <div className="id2">
        <input
          type="number"
          name="id2"
          placeholder="id2"
          onChange={gatherInput}
        />
      </div>
      <div className="amount">
        <input
          type="number"
          name="amount"
          placeholder="amount"
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
export default Trans;
