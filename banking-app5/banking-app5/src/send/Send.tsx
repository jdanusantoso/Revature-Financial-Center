import React, { useState } from 'react'

import styles from "./send.module.css" 

export function Send() {

  //saving the values through useState
  const [values, setValues] = useState({

    person: "",
    acctId: "",
    amount: "",
    date: "",
    memo: ""

  });

  //onChange event to destructure, set the set the previous to the current
    const onSend = (e: React.ChangeEvent<HTMLInputElement>) => {

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
    console.log(`Person ${values.person} Account Id ${values.acctId} Amount ${values.amount} Date ${values.date} Memo ${values.memo}`)


    }
  

  return (

    <div className={styles.sendCont}>
    <h1>

    {/* <form onSubmit={() => onNewCustomer}> */}
    <form onSubmit = {onSubmit}>

        <div>
            <input type="text" placeholder='Person' name='person' onChange={onSend}></input>
        </div>

        <div>
            <input type="number" placeholder='Account Id' name='acctId' onChange={onSend}></input>
        </div>

        <div>
            <input type="number" placeholder='Amount' name='amount' onChange={onSend}></input>
        </div>

        <div>
            <input type="number" placeholder='Date' name='date' onChange={onSend}></input>
        </div>

        <div>
            <input type="text" placeholder='Memo' name='memo' onChange={onSend}></input>
        </div>

        <input type='submit' value='Create' />

    </form>

    </h1>
  </div>  
  )

}

export default Send