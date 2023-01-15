import React, { useState } from 'react'
import styles from "./account-tracker.module.css"

export function AccountTracker () {

    const [values, setValues] = useState({

        acHolder: "Joe",
        acId: "1",
        
    
      });

    //onChange event to destructure, set the set the previous to the current
    const onAccountSearch = (e: React.ChangeEvent<HTMLInputElement>) => {

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
      console.log(`Account Id ${values.acId}`)
  
  
      }  

  return (
    <div className={styles.accountCont}>
    

    {/* <form onSubmit={() => onNewCustomer}> */}
    <form onSubmit = {onSubmit}>

        <div>
            <input type="text" placeholder='Account Holder' name='acHolder' onChange={onAccountSearch}></input>
        </div>

        <input type='submit' value='Create' />
        

    </form>

    <h1> Your accounts are listed below: </h1>
    <h3>{values.acId}</h3>
   </div> 
  )
}

export default AccountTracker