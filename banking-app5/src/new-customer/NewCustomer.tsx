import React from 'react'

import styles from "./NewCustomer.module.css" 


const NewCustomer = () => {

    const onNewCustomer = (event: React.FormEvent<HTMLInputElement>) => {

        //to avoid reloading the browser after submission
        event.preventDefault();

        const target = event.target as typeof event.target & {
            acId: { value: Text };
            acNm: { value: string };
            balance: {value: Text}
          };

        console.log(event.target)
        const acId = target.acId.value;
        const acNm = target.acNm.value;
        const balance = target.balance.value;

        console.log(`Id ${acId} Name ${acNm} Bal ${balance}`)

    }

  return (
    <h1>

    <form onSubmit={() => onNewCustomer}>

        <div>
            <input type="number" placeholder='Account Id' name='acId'></input>
        </div>

        <div>
            <input type="text" placeholder='Account Name' name='acNm'></input>
        </div>

        <div>
            <input type="number" placeholder='Balance' name='balance'></input>
        </div>

        <input type='submit' value='Create' />

    </form>

    </h1>
    
  )
}

export default NewCustomer