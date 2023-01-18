import React, { useState } from "react";
import axios from "axios";
import "./login.css";
import { useNavigate } from "react-router-dom";
import Register from "../Register/register";
import Dashboard from "../Dashboard/dashboard";

const Login: React.FC<any> = () => {
  const [error, setError] = useState("");
  const user = {
    id: 0,
    accountHolder: "",
    accountBalance: 0,
  };

  //useState hooks to declare some state that will hold accountHolder and accountBalance
  const [accountHolder, setaccountHolder] = useState("");
  const [accountBalance, setaccountBalance] = useState("");

  //we'll use this object to switch components whenever appropriate
  //this is what lets us navigate to different components with events - no more manual URL changes!
  const navigate = useNavigate();

  /* when the user updates the accountHolder/accountBalance this will be called thanks to onChange
  the accountHolder OR accountBalance state will get updated based on the name of the input that's changing */
  const gatherInput = (input: any) => {
    if (input.target.name === "accountHolder") {
      console.log("Hello");
      setaccountHolder(input.target.value);
    } else {
      setaccountBalance(input.target.value);
    }
  };

  const login = async () => {
    //send an HTTP POST request with axios, and store the response in a variable that we can use
    const response = await axios.post(
      "http://localhost:5556/data/accounts/new",
      {
        accountHolder,
        accountBalance,
      }
    );

    if (response.status === 202) {
      //if the login was successful...

      console.log(response);

      //populate our user object from above with the incoming data from the server
      user.id = response.data.id;
      user.accountHolder = response.data.accountHolder;
      user.accountBalance = response.data.accountBalance;

      //if the user logged in successfully, their id won't be 0.
      if (user.id > 0) {
        navigate("/balance"); //thanks to navigate, we can route to the home component automatically
      }
    } else {
      console.log("ERROR");
    }
  };
  return (
    <div className="login">
      {error && <p className="error-message">{error}</p>}

      <div className="textlogin">
        <h1>Welcome to Revature Financial Center </h1>
      </div>
      <div className="user">
        <input
          type="text"
          name="accountHolder"
          placeholder="accountHolder"
          onChange={gatherInput}
        />
      </div>

      <div className="user">
        <input
          type="number"
          name="accountBalance"
          placeholder="accountBalance"
          onChange={gatherInput}
        />
      </div>

      <button className="login-button" onClick={login}>
        Login
      </button>

      <button className="register-button" onClick={() => navigate("Register")}>
        {" "}
        New Users Register here{" "}
      </button>

      <div className="disclaimer">
        <p>
          YOU AGREE THAT YOUR USE OF ANY REMOTE BANKING SERVICE AND ALL
          INFORMATION AND CONTENT (INCLUDING THAT OF THIRD PARTIES) IS AT YOUR
          RISK AND IS PROVIDED ON AN “AS IS” AND “AS AVAILABLE” BASIS. WE
          DISCLAIM ALL WARRANTIES OF ANY KIND AS TO THE USE OF ANY REMOTE
          BANKING SERVICE, WHETHER EXPRESS OR IMPLIED, INCLUDING, BUT NOT
          LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
          PARTICULAR PURPOSE AND NONINFRINGEMENT. WE MAKE NO WARRANTY THAT ANY
          REMOTE BANKING SERVICE WILL MEET YOUR REQUIREMENTS OR WILL BE
          UNINTERRUPTED, TIMELY, SECURE, OR ERROR-FREE. WE MAKE NO WARRANTY THAT
          THE RESULTS THAT MAY BE OBTAINED WILL BE ACCURATE OR RELIABLE OR THAT
          ANY ERRORS IN ANY REMOTE BANKING SERVICE OR TECHNOLOGY WILL BE
          CORRECTED. LIMITATION OF LIABILITY. YOU AGREE THAT WE WILL NOT BE
          LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, CONSEQUENTIAL OR
          EXEMPLARY DAMAGES, INCLUDING, BUT NOT LIMITED TO, DAMAGES FOR LOSS OF
          PROFITS, GOODWILL, USE, DATA OR OTHER LOSSES INCURRED BY YOU OR ANY
          THIRD PARTY ARISING FROM OR RELATED TO THE USE OF, INABILITY TO USE,
          OR THE TERMINATION OF THE USE OF ANY REMOTE BANKING SERVICE,
          REGARDLESS OF THE FORM OF ACTION OR CLAIM (WHETHER CONTRACT, TORT,
          STRICT LIABILITY OR OTHERWISE), EVEN IF WE HAVE BEEN INFORMED OF THE
          POSSIBILITY THEREOF, EXCEPT AS OTHERWISE REQUIRED BY LAW.
        </p>
      </div>
    </div>
  );
};
export default Login;
