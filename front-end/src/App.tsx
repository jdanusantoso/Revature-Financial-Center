import React, { useState } from "react";
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
import DarkMode from "./Components/DarkMode/DarkMode";
import UserProfile from "./Components/Profile/UserProfile";
import Request from "./Components/Request/request";
import { EmployeeContainerComponent } from "./Components/EmployeeContainerComponent/EmployeeContainerComponent";
import EditPass from "./Components/Edit/edit";
import EditProfile from "./Components/Edit/EditProfile";

function App() {
  const [name, setUserName] = useState("");
  return (
    <div>
      <DarkMode />

      <div className="App">
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/dashboard" element={<Dashboard />} />
            <Route path="/account" element={<Account />} />
            <Route path="/user" element={<Profile />} />
            <Route path="/UserProfile" element={<UserProfile />} />
            <Route path="/profile" element={<Profile />} />
            <Route path="/send" element={<Send />} />
            <Route path="/transactions" element={<Transactions />} />
            <Route path="/emp" element={<EmployeeContainerComponent />} />
            <Route path="/transfer" element={<Transfer />} />
            <Route path="/request" element={<Request />} />
            <Route path="/withdraw" element={<Withdraw />} />
            <Route path="/edit" element={<EditPass />} />
            <Route path="/editProfile" element={<EditProfile />} />
          </Routes>
        </BrowserRouter>
      </div>
    </div>
  );
}

export default App;
