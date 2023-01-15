import { useState } from "react"
import styles from './balance.module.css'

export function Balance() {

    const [values, setValues] = useState({

        acId: "",
        balance: 0
      });

    const onBalance = (e: React.ChangeEvent<HTMLInputElement>) => {
        
        const {name, value} = e.target;

        setValues((prev) => {
  
        return {...prev, [name]: values}
  
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

        <div className={styles.balCont}>
        <h1> Balance is: INT. {values.balance} </h1>
        <form onSubmit = {onSubmit}>
            <input type='number' placeholder='Account Id' name='acId'/>
            <input type='submit' value='Balance' onChange={onBalance}/>
        </form>
    </div>

    )
}

export default Balance