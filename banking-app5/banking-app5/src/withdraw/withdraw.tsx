import { useState } from 'react';
import styles from './withdraw.module.css'

export function Withdraw() {

    const [values, setValues] = useState({

        acId: "",
        amount: ""
      });

    const onWithdraw = (e: React.ChangeEvent<HTMLInputElement>) => {

        const {name, value} = e.target;

        setValues((prev) => {
  
        return {...prev, [name]: value}
  
        });
    
    }

    const onSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        
        e.preventDefault()

        console.log(values)

        //console.log(`Id ${acId} Amount ${amount}`)

    }    
        
    
    return (
        <>
            <div className={styles.wthCont}>
                <h1> Withdraw Amount </h1>
                <form onSubmit={onSubmit}>
                    <input type='number' placeholder='Account Id' name='acId' onChange={onWithdraw}/>
                    <input type='number' placeholder='Amount' name='amount' onChange={onWithdraw} />
                    <input type='submit' value='Withdraw' />
                </form>
            </div>
        </>
    )
    
}
