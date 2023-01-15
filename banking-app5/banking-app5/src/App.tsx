import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter } from 'react-router-dom';
import {Route, Routes} from 'react-router'
import NavBar from './navbar/NavBar';
import Dashboard from './dashboard/Dashboard';
import NewCustomer from './new-customer/NewCustomer';
import Deposit  from './deposit/Deposit';
import { Withdraw } from './withdraw/withdraw';
import { Transfer } from './transfer/Transfer';
import { Balance } from './balance/Balance';
import Request from './request/Request';
import Send from './send/Send';
import { ExpenseTracker } from './expensetracker/ExpenseTracker';
import IncomeTracker from './income-tracker/IncomeTracker';
import AccountTracker from './account-tracker/AccountTracker';

function App() {

  return (
    <div className="App">
      
      <NavBar></NavBar>
      <BrowserRouter>
      <Routes>
          <Route path="/" element={<Dashboard />}/>
          <Route path="/new" element={<NewCustomer />}/>
          <Route path="/deposit" element={<Deposit />} />
          <Route path="/withdraw" element={<Withdraw />} />
          <Route path="/transfer" element={<Transfer />} />
          <Route path="/balance" element={<Balance />} />
          <Route path="/request" element={<Request />}/>
          <Route path="/send" element={<Send />}/> 
          <Route path="/account-tracker" element={<AccountTracker />}/> 
          <Route path="/income-tracker" element={<IncomeTracker />}/> 
          <Route path="/expense-tracker" element={<ExpenseTracker />}/> 
        </Routes>
      </BrowserRouter>
       
    </div>
  );
}

export default App;
