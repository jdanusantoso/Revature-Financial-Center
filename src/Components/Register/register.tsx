import axios from 'axios';
import "./register.css"
import { useState } from "react";
import ReactDOM  from 'react-dom';



const Register = () =>{

const[{username,password,repeatPassword, firstname,lastname,email}, setRegisterData] = useState({
    username:"",
    password:"",
    repeatPassword:"",
    firstname:"",
    lastname:"",
    email:""

})
const[error,setError] = useState('')

   const register = (event: React.FormEvent) =>{
       event.preventDefault();
       if(password === repeatPassword){

       }else{
        setError('Passwords must match,please try again')
       }


   }

return(
    <div className="Register">
        <div className='register-container'>
            <h2>Register Here</h2>
        <form onSubmit={Register}>
        <div className='labels'>
       <label htmlFor="username">username</label>
       <input value={username}  type ="text" name='username' placeholder='username' onChange={(event)=> setRegisterData ({
        username: event.target.value,
        password,
        repeatPassword,
        firstname,
        lastname,
        email })} />
        </div>
        <div className='labels'>
        <label htmlFor="password">Password</label> 
        <input value={password}  type = "password" name='password' placeholder='password' onChange={(event)=> setRegisterData ({
        username,
        password: event.target.value,
        repeatPassword,
        firstname,
        lastname,
        email })} />
        </div>
        <div className='labels'>
        <label htmlFor="repeatPassword">Repeat Password</label> 
        <input value={repeatPassword} type="password" name='repeatPassword' placeholder='password' onChange={(event)=> setRegisterData ({
        username,
        password,
        repeatPassword: event.target.value,
        firstname,
        lastname,
        email })} />
        </div>
        <div className='labels'>
        <label htmlFor="firstname">Firstname</label> 
        <input value={firstname} type ="text" name='firstname' placeholder='firstname' onChange={(event)=> setRegisterData ({
        username,
        password,
        repeatPassword,
        firstname: event.target.value,
        lastname,
        email })} />
        </div>
        <div className='labels'>
        <label htmlFor="lastname">Lastname</label> 
        <input value={lastname} type ="text" name='lastname' placeholder='lastname' onChange={(event)=> setRegisterData ({
        username,
        password,
        repeatPassword,
        firstname,
        lastname: event.target.value,
        email })} />
        </div>
        <div className='labels'>
        <label htmlFor="email">Email</label> 
        <input value={email} type ="email"name='email' placeholder='email' onChange={(event)=> setRegisterData ({
        username,
        password,
        repeatPassword,
        firstname,
        lastname,
        email: event.target.value
         })} />
        </div>
        <button className='reg-button'>Register</button>
        {error.length > 0 && <p>(error)</p>}
        </form>
         
        </div>

    </div>
)

    }


export default Register
