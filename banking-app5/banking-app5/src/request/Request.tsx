import React, { useState } from 'react'

import styles from "./request.module.css" 

export function Request() {

  //saving the values through useState
  const [values, setValues] = useState({

    person: "",
    acctId: "",
    amount: "",
    memo: ""

  });

  //onChange event to destructure, set the set the previous to the current
    const onRequest = (e: React.ChangeEvent<HTMLInputElement>) => {

      const {name, value} = e.target;

      setValues((prev) => {

        return {...prev, [name]: value}

      });

    };
    //onSubmit
    const onSubmit = (e: React.FormEvent<HTMLFormElement>) => {
      //stop reloading the page
      e.preventDefault();
      //printing out to console
    console.log(values)
    // console.log(`Id ${acId} Name ${acNm} Bal ${balance}`)


    }
  

  return (

    <div className={styles.requestCont}>
    <h1>

    {/* <form onSubmit={() => onNewCustomer}> */}
    <form onSubmit = {onSubmit}>

        <div>
            <input type="text" placeholder='Person' name='person' onChange={onRequest}></input>
        </div>

        <div>
            <input type="number" placeholder='Account Id' name='acctId' onChange={onRequest}></input>
        </div>

        <div>
            <input type="number" placeholder='Amount' name='amount' onChange={onRequest}></input>
        </div>

        <div>
            <input type="text" placeholder='Memo' name='memo' onChange={onRequest}></input>
        </div>

        <input type='submit' value='Create' />

    </form>

    </h1>
  </div>  
  )

}

export default Request