import React, { useState } from 'react'
import styles from "./incometracker.module.css"

export function IncomeTracker () {

    const [values, setValues] = useState({

        acId: "1",
        date: "",
        income: "",
        
    
      });

    //onChange event to destructure, set the set the previous to the current
    const onExpense = (e: React.ChangeEvent<HTMLInputElement>) => {

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
      console.log(`Account Id ${values.acId} Date ${values.date} Income ${values.income}`)
  
  
      }  

  return (
    <div className={styles.incomeCont}>
    <h1>

    {/* <form onSubmit={() => onNewCustomer}> */}
    <form onSubmit = {onSubmit}>

        <div>
            <input type="number" placeholder='Account Id' name='acId' onChange={onExpense}></input>
        </div>

        <input type='submit' value='Create' />
        

    </form>

    <h1 style={{ color: 'green' }}> Your expenses are listed below {values.income} </h1>

    </h1>
   </div> 
  )
}

export default IncomeTracker