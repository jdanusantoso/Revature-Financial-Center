import React, { useState } from 'react';

import styles from './Deposit.module.css'

export function Deposit() {

    const [values, setValues] = useState({

        acId: "",
        amount: ""
      });

    const onDeposit = (e: React.ChangeEvent<HTMLInputElement>) => {
        
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

        //saving the values through useState
    

        /*event.preventDefault()

        const target = event.target as typeof event.target & {
            acId: { value: Text };
            amount: {value: Text}
          };

        console.log(event.target)
        const acId = target.acId.value;
        const amount = target.amount.value;

        console.log(`Id ${acId} Amount ${amount}`)*/

    


    return (
        <div className={styles.depCont}>
            <h1> Deposit Amount </h1>
            <form onSubmit = {onSubmit}>
                <input type='number' placeholder='Account Id' name='acId' onChange={onDeposit}/>
                <input type='number' placeholder='Amount' name='amount' onChange={onDeposit}/>
                <input type='submit' value='Deposit' />
            </form>
        </div>
    )
}

export default Deposit