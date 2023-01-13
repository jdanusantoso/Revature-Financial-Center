import React from "react";
import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter } from "react-router-dom";
import { Route, Routes } from "react-router";
import NavBar from "./navbar/NavBar";
import Dashboard from "./dashboard/Dashboard";
import NewCustomer from "./new-customer/NewCustomer";
import Deposit from "./deposit/Deposit";
import { Withdraw } from "./withdraw/withdraw";
import { Transfer } from "./transfer/Transfer";
import { Balance } from "./balance/Balance";
import DarkMode from "./DarkMode";

function App() {
  return (
    <div className="App">
      <DarkMode />
      <NavBar></NavBar>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Dashboard />} />
          <Route path="/new" element={<NewCustomer />} />
          <Route path="/deposit" element={<Deposit />} />
          <Route path="/withdraw" element={<Withdraw />} />
          <Route path="/transfer" element={<Transfer />} />
          <Route path="/balance" element={<Balance />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
