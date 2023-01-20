import React, { useState } from "react";


import axios from "axios";
import { useNavigate } from "react-router-dom";






const Profile: React.FC<any> = ({ user}) => {
 
  const myUser = {
    firstname: "",
    lastname: "",
    username: "",
    password: "",
    email: ""
  };
 


  const [lastname, setNewLastname] = useState('');
  const [firstname, setNewFirstname] = useState('')
  const [username, setNewUsername] = useState('');
  const [password, setNewPassword] = useState('');
  const [email, setNewEmail] = useState('');
 
  const [editing, setEditing] = useState(false);
 
 
  const navigate = useNavigate();

 
 
 
 const handleEdit = () => {
    setEditing(true);
    setNewFirstname(user.firstname);
    setNewLastname(user.lastname);
    setNewUsername(user.username);
    setNewPassword(user.password);
    setNewEmail(user.email);
  };


  const handleCancel = () => {
    setEditing(false);
   
   
  };


  const handleSave = () => {
    // Save the changes to the server here
    setEditing(false);
  };


  return (
    <div>
      {editing ? (
        <>
          <input
            type="text"
            placeholder="Firstname"
            value={firstname}
            onChange={(e) => setNewFirstname(e.target.value)}
          />


<input
            type="text"
            placeholder="lastname"
            value={lastname}
            onChange={(e) => setNewLastname(e.target.value)}
          />
         <input
            type="text"
            placeholder="username"
            value={username}
            onChange={(e) => setNewUsername(e.target.value)}
          />


         <input
            type="text"
            placeholder="password"
            value={password}
            onChange={(e) => setNewPassword(e.target.value)}
          />


          <input
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setNewEmail(e.target.value)}
          />
     <button onClick={handleSave}>Save</button>
      <button onClick={handleCancel}>Cancel</button>
    </>
  ) : (
    <>
      <p>Firstname: {firstname || '-'}</p>
      <p>Lastname: {lastname || '-'}</p>
      <p>Username: {username || '-'}</p>
      <p>Password: {password || '-'}</p>
      <p>Email: {email || '-'}</p>
      <button onClick={handleEdit}>Edit</button>
      <button onClick={() => navigate("/dashboard")}>Home</button>
    </>
    
  )}
</div>
);
};


export default Profile;