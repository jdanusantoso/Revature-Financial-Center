import React, { useState } from 'react'
import styles from "./expensetracker.module.css"

export function ExpenseTracker () {

    const [values, setValues] = useState({

        acId: "",
        date: "",
        expense: "",
        
    
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
      console.log(`Account Id ${values.acId} Date ${values.date} Expense ${values.expense}`)
  
  
      }  

  return (
    <div className={styles.expCont}>
    <h1>

    {/* <form onSubmit={() => onNewCustomer}> */}
    <form onSubmit = {onSubmit}>

        <div>
            <input type="number" placeholder='Account Id' name='acId' onChange={onExpense}></input>
        </div>

        <input type='submit' value='Create' />
        

    </form>

    <h1 style={{ color: 'red' }}> Balance is: Expenses. {values.expense} </h1>

    </h1>
   </div> 
  )
}

export default ExpenseTracker