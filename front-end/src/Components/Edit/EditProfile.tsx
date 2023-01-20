import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";

const EditProfile: React.FC<any> = () => {
  const [error, setError] = useState("");

  const [editFName, seteditFName] = useState("");
  const [editLName, seteditLName] = useState("");
  const [editEmail, seteditEmail] = useState("");

  const [accountB, setaccountBalance] = useState(0);
  const [accountHolder, setaccountHolder] = useState("");
  const [accountId, setaccountId] = useState(0);
  const [transactionAmount, settransactionAmount] = useState(0);
  const [users, setusers] = useState("");

  const appState = useSelector<any, any>((state) => state);

  const navigate = useNavigate();

  const login = async () => {
    console.log(appState.user.id);
    try {
      const response = await axios.patch(
        "http://localhost:5556/data/users/updateUserPassword/" +
          appState.user.id,
        { password: editEmail }
      );

      console.log("Start");
      console.log(response);
      if (response.status === 200) {
        console.log(response.data.email);
        setaccountBalance(response.data.firstName);
        setaccountHolder(response.data.lastName);
        setaccountId(response.data.password);
        settransactionAmount(response.data.userId);
        setusers(response.data.username);

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
    if (input.target.name === "first") {
      seteditFName(input.target.value);
    } else if (input.target.name === "last") {
      seteditLName(input.target.value);
    } else {
      seteditEmail(input.target.value);
    }
  };

  return (
    <div className="login">
      {error && <p className="error-message">{error}</p>}

      <div className="textlogin">
        <h1>Welcome to Revature Financial Center</h1>
        <h2>Edit Password Window: {appState.user.username}</h2>
        <h2>firstName: {accountB}</h2>
        <h2>lastName: {accountHolder}</h2>
        <h2>password: {accountId}</h2>
        <h2>userId: {transactionAmount}</h2>
        <h2>username: {users}</h2>
      </div>

      <div className="password">
        <input
          type="text"
          name="password"
          placeholder="password"
          onChange={gatherInput}
        />
      </div>

      <button className="login-button" onClick={login}>
        Edit Profile
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
export default EditProfile;
