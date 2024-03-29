import React, { useState } from "react";
import "./login.css";
import { useNavigate } from "react-router-dom";
import { loginUser } from "../../actions/UserActions";
import { useDispatch, useSelector } from "react-redux";

const Login: React.FC<any> = () => {
  const appState = useSelector<any, any>((state) => state);

  //we need this object to actually dispatch data to our store
  const dispatch = useDispatch();

  const [error, setError] = useState("");
  const user = {
    userId: 0,
    username: "",
    password: "",
  };

  //useState hooks to declare some state that will hold username and password
  const [username, setusername] = useState("");
  const [password, setpassword] = useState("");

  //we'll use this object to switch components whenever appropriate
  //this is what lets us navigate to different components with events - no more manual URL changes!
  const navigate = useNavigate();
  if (appState.user.id > 0) {
    navigate("/UserProfile"); //thanks to Routing in the App.tsx, this will switch the component.
  }

  /* when the user updates the username/password this will be called thanks to onChange
  the username OR password state will get updated based on the name of the input that's changing */
  const gatherInput = (input: any) => {
    if (input.target.name === "username") {
      setusername(input.target.value);
    } else {
      setpassword(input.target.value);
    }
  };

  const login = async () => {
    await dispatch(
      loginUser({ username, password }) as any
      //these are the states that were changed with handleChange
      //we need "as any" to make it so that the return type can be any type
    );

    console.log(appState.user.id);
    if (appState.user.id > 0) {
      navigate("/UserProfile"); //thanks to Routing in the App.tsx, this will switch the component.
    } else {
      setError("Can't finda ya brah");
    }
  };

  return (
    <div className="login">
      {error && <p className="error-message">{error}</p>}

      <div className="textlogin">
        <h1>Welcome to Revature Financial Center </h1>
        <h2>{appState.user.username}</h2>
      </div>
      <div className="user">
        <input
          type="text"
          name="username"
          placeholder="username"
          onChange={gatherInput}
        />
      </div>

      <div className="user">
        <input
          type="password"
          name="password"
          placeholder="password"
          onChange={gatherInput}
        />
      </div>

      <button className="login-button" onClick={login}>
        Login
      </button>

      <button className="register-button" onClick={() => navigate("Register")}>
        New Users Register here
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
