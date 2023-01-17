import axios from 'axios';
import "./register.css"
import { useState } from "react";
import ReactDOM  from 'react-dom';



const Register = () =>{

const[username,setUsername] = useState("");
const[password,setPassword] = useState("");
const[firstname,setFirstname] = useState("");
const[lastname,setLastname] = useState("");
const[email,setEmail] = useState("");



   

return(
    <div className="Register">
        <div className='register-container'>
            <h2>Register Here</h2>
    <form onSubmit={Register}>
        <div className='labels'>
        <input
             value={username}  
             type ="username" 
             placeholder='Lsername'
             onChange={(e)=> setUsername(e.target.value)}/>

        </div>

        <div className='labels'>
        <input
             value={password}  
             type ="password" 
             placeholder='Password'
             onChange={(e)=> setPassword(e.target.value)}/>

        </div>

        <div className='labels'>
        <input
             value={firstname}  
             type ="firstname" 
             placeholder='Firstnamename'
             onChange={(e)=> setFirstname(e.target.value)}/>

        </div>

        <div className='labels'>
        <input
             value={lastname}  
             type ="lastname" 
             placeholder='Lastname'
             onChange={(e)=> setLastname(e.target.value)}/>

        </div>

        <div className='labels'>
        <input
             value={email}  
             type ="email" 
             placeholder='Email'
             onChange={(e)=> setEmail(e.target.value)}/>

        </div>

           <button className='reg-button'>Register</button>
    </form>
         
        </div>

    </div>
)

    }


export default Register
