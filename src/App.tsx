import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './Components/Login/login';
import Register from './Components/Register/register';
import './App.css';

function App() {
  return (
    <div className="App">
    <BrowserRouter>
    <Routes>
      <Route path='' element ={<Login/>}/>
      <Route path='register' element={<Register/>}/>
    </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;
