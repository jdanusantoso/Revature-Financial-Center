import React from "react";
import { useNavigate } from "react-router-dom";
import { useState } from "react";

import "./dashboard.css";
import { useDispatch, useSelector } from "react-redux";

const Dashboard: React.FC<any> = (props: any) => {
  const navigate = useNavigate();
  const appState = useSelector<any, any>((state) => state);
  const [logB, setB] = useState("");

  const [error, setError] = useState("");
  const user = {
    userId: 0,
    username: props.username,
    password: props.password,
  };

  console.log(user);

  const logout = () => {
    //setError("");
    appState.user.username = "";
    appState.user.password = "";
    appState.user.id = 0;
    navigate("/");
  };

  return (
    <div className="dashCont">
      <div className="welcome">
        <h1>Welcome {appState.user.username}</h1>
      </div>

      <h3 className="dashboard-menu">Dashboard</h3>

      <div className="depo">
        <button className="button" onClick={() => navigate("/UserProfile")}>
          UserProfile
        </button>

        <div className="depo">
          <button className="button" onClick={() => navigate("/editProfile")}>
            Edit Profile
          </button>
        </div>

        <div className="depo">
          <button className="button" onClick={() => navigate("/withdraw")}>
            Withdraw
          </button>
        </div>

        <div className="depo">
          <button className="button" onClick={() => navigate("/transfer")}>
            Transfer Money between Accounts
          </button>
        </div>

        <div className="depo">
          <button className="button" onClick={() => navigate("/request")}>
            Request Money
          </button>
        </div>

        <div className="depo">
          <button className="button" onClick={() => navigate("/send")}>
            Send Money
          </button>
        </div>

        <div className="depo">
          <button
            className="button"
            onClick={() => navigate("/gatherAccounts")}
          >
            View All User Accounts
          </button>
        </div>

        <button className="button" onClick={logout}>
          Log Out
        </button>
      </div>
    </div>
  );
};

export default Dashboard;
