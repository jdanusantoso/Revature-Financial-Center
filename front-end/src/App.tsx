import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Login from "./Components/Login/login";
import Register from "./Components/Register/register";
import Dashboard from "./Components/Dashboard/dashboard";
import Account from "./Components/Account/account";
import Profile from "./Components/Profile/profile";
import Send from "./Components/Send/send";
import Withdraw from "./Components/Withdraw/withdraw";
import Transfer from "./Components/Transfer/transfer";
import Transactions from "./Components/Transactions/transactions";
import { BudgetOverview } from "./Components/budget/BudgetOverview";
import UserProfile from "./Components/Profile/UserProfile";

const homeBudgets = [
  {
    budgeted: 500,
    spent: 200,
    category: "Food",
  },
];

const loginUser = [
  {
    usrName: "Goon",
    passWord: "Bug",
  },
];

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login user_profile={loginUser} />} />
          <Route path="/register" element={<Register />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/account" element={<Account />} />

          <Route
            path="/prof"
            element={<UserProfile user_profile={loginUser} />}
          />

          <Route path="/send" element={<Send />} />
          <Route path="/transactions" element={<Transactions />} />
          <Route path="/transfer" element={<Transfer />} />
          <Route path="/withdraw" element={<Withdraw />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
//<Route path="/profile" element={<Profile />} />
