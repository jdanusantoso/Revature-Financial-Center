import React from "react";
import { useNavigate } from "react-router-dom";
import Account from "../Account/account";
import Profile from "../Profile/profile";
import { useState } from "react";

import "./dashboard.css";
import { useDispatch, useSelector } from "react-redux";

const Dashboard: React.FC<any> = (props: any) => {
  const navigate = useNavigate();
  const appState = useSelector<any, any>((state) => state);
  const dispatch = useDispatch();

  const [error, setError] = useState("");
  const user = {
    userId: 0,
    username: props.username,
    password: props.password,
  };

  console.log(user);

  const logout = () => {
    //setError("");
    navigate("/");
  };

  return (
    <div className="dashCont">
      <div className="welcome">
        <h1>Welcome User</h1>
        <h2>User: {appState.user.username}</h2>
      </div>
      <button className="userpro" onClick={() => navigate("/Profile")}>
        View User Profile
      </button>

      <h3 className="dashboardmenu">Dashboard</h3>

      <div className="depo">
        <button className="income" onClick={() => navigate("/Transactions")}>
          View Transactions
        </button>
      </div>

      <div className="depo">
        <button className="account" onClick={() => navigate("/Account")}>
          View Accounts
        </button>
      </div>

      <div className="depo">
        <button className="withdraw" onClick={() => navigate("/Withdraw")}>
          Withdraw
        </button>
      </div>

      <div className="depo">
        <button className="transfer" onClick={() => navigate("/Transfer")}>
          Transfer Money between Accounts
        </button>
      </div>

      <div className="depo">
        <button className="send" onClick={() => navigate("/Send")}>
          Send Money
        </button>
      </div>

      <button className="logout-button" onClick={logout}>
        Logout
      </button>
    </div>
  );
};

export default Dashboard;
