import React, { useState } from "react";

import styles from './transfer.module.css'

export function Transfer() {

    const [values, setValues] = useState({

        srcId: "",
        destId: "",
        amount: ""
      });

    const onTransfer = (e: React.ChangeEvent<HTMLInputElement>) => {
        
        const {name, value} = e.target;

        setValues((prev) => {
  
        return {...prev, [name]: value}
  
        });

    };

    const onSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        //stop reloading the page
        e.preventDefault();
        //printing out to console
      console.log(values)
      // console.log(`Id ${acId} Name ${acNm} Bal ${balance}`)
  
  
      }



    

    return (
        <>
            <div className={styles.trnCont}>
                <h1> Transfer Amount </h1>
                <form onSubmit={onSubmit}>
                    <input type='number' placeholder='Source Id' name='srcId' onChange={onTransfer} />
                    <input type='number' placeholder='Destination Id' name='destId' onChange={onTransfer} />
                    <input type='number' placeholder='Amount' name='amount' onChange={onTransfer} />
                    <input type='submit' value='Transfer' />
                </form>
            </div>
        </>
    )
    
}