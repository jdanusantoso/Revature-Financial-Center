
import axios from "axios";
import { User } from "../store/types"
import { LOGIN_USER } from "./ActionTypes";


interface UserLogin {
    username: string,
    password: string
}

//dispatch:any? this means we can send (or dispatch) any object to the store from this function
export const loginUser = (loginCreds:UserLogin) => async (dispatch:any) => {

    //create an empty object of type IUser - this will get filled on successful login
    let loggedInUser: User;
    console.log(loginCreds.username);
    try {
       

        console.log("Start")
        //send my HTTP request with axios, and put it into a variable we can use
        const response = await axios.get(
            "http://localhost:5556/data/users/login?username="+loginCreds.username+"&password="+loginCreds.password
          );
          console.log(response)
        if(response.status === 200) { //if the login was successful...
            
            console.log("Username "+response.data[0].userId) //to see the data coming back

            //populate our loggedInUser variable based on the data sent back from the server
            //this is the payload of new data we're going to dispatch to the store
            loggedInUser = {
                id: response.data[0].userId,
                username: response.data[0].username,
                password: response.data[0].password
            }

            //now we actually DISPATCH (send) this data to the store and reducers 
            //see UserReducer, see store.ts
            //notice in the reducers, this is the type of data we need for the Action object
            return dispatch({
                type: LOGIN_USER,
                payload: loggedInUser
            })

        }

    } catch (e) {
        console.log("LOGIN FAILED!")
    }

}