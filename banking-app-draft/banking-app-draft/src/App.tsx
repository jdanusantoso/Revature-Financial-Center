import React from 'react';
import { BrowserRouter, Route, Routes, } from 'react-router-dom';
import './App.css';
import Login from './Components/Login/login';
import Register from './Components/Register/register';
import Dashboard from './Components/Dashboard/dashboard';
import Account from './Components/Account/account';
import Profile from './Components/Profile/profile';
import Send from './Components/Send/send';
import Withdraw from './Components/Withdraw/withdraw';
import Transfer from './Components/Transfer/transfer';
import Transactions from './Components/Transactions/transactions';
import DarkMode from "./DarkMode";



function App() {
 
 
  return (
    <div className="App">
       <DarkMode />
    <BrowserRouter>
    <Routes>
      <Route path='/' element ={<Login/>}/>
      <Route path="/register" element={<Register/>}/>
      <Route path= "/dashboard" element= {<Dashboard/>}/>
      <Route path="/account" element= {<Account/>} />
      <Route path="/profile" element= {<Profile/>} />
      <Route path="/send" element= {<Send/>} />
      <Route path="/transactions" element= {<Transactions/>} />
      <Route path="/transfer" element= {<Transfer/>} />
      <Route path="/withdraw" element= {<Withdraw/>} />

    
    </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;
