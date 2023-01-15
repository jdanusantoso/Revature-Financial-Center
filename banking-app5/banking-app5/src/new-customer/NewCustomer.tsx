import React, { useState } from 'react'

import styles from "./NewCustomer.module.css" 

export function NewCustomer() {

  //saving the values through useState
  const [values, setValues] = useState({

    acId: "",
    acNm: "",
    balance: ""
  });

  //onChange event to destructure, set the set the previous to the current
    const onChange = (e: React.ChangeEvent<HTMLInputElement>) => {

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
    <div className={styles.custCont}>
    <h1>

    {/* <form onSubmit={() => onNewCustomer}> */}
    <form onSubmit = {onSubmit}>

        <div>
            <input type="number" placeholder='Account Id' name='acId' onChange={onChange}></input>
        </div>

        <div>
            <input type="text" placeholder='Account Name' name='acNm' onChange={onChange}></input>
        </div>

        <div>
            <input type="number" placeholder='Balance' name='balance' onChange={onChange}></input>
        </div>

        <input type='submit' value='Create' />

    </form>

    </h1>

    </div>  
    
  )

}

export default NewCustomer