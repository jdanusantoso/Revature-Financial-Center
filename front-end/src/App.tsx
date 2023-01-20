import React, { useState } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Login from "./Components/Login/login";
import Register from "./Components/Register/register";
import Dashboard from "./Components/Dashboard/dashboard";
import Send from "./Components/Send/send";
import Withdraw from "./Components/Withdraw/withdraw";
import Trans from "./Components/Transfer/transfer";
import DarkMode from "./Components/DarkMode/DarkMode";
import UserProfile from "./Components/Profile/UserProfile";
import Request from "./Components/Request/request";
import EditProfile from "./Components/Edit/EditProfile";
import EmployeeContainerComponent from "./Components/EmployeeContainerComponent/EmployeeContainerComponent";

function App() {
  return (
    <div>
      <DarkMode />

      <div className="App">
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/dashboard" element={<Dashboard />} />
            <Route path="/UserProfile" element={<UserProfile />} />
            <Route path="/send" element={<Send />} />
            <Route path="/transfer" element={<Trans />} />
            <Route path="/request" element={<Request />} />
            <Route path="/withdraw" element={<Withdraw />} />
            <Route path="/editProfile" element={<EditProfile />} />
            <Route
              path="/gatherAccounts"
              element={<EmployeeContainerComponent />}
            />
          </Routes>
        </BrowserRouter>
      </div>
    </div>
  );
}

export default App;
