import React from 'react'
import { useNavigate } from 'react-router-dom'

import styles from "./dashboard.module.css" 

export const Dashboard = () => {

  const navigate = useNavigate()

  return (
    <div className={styles.dashCont}>
        <div onClick={() => navigate('/new')}>
        New Customer
        </div>
        <div>
            Deposit
        </div>
        <div>
            WithDraw
        </div>
        <div>
            Transfer
        </div>
        <div>
            Balance
        </div>
    </div>
)
}

export default Dashboard