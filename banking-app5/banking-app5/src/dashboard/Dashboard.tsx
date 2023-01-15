import React from 'react'
import { useNavigate } from 'react-router-dom'

import styles from "./dashboard.module.css" 

export const Dashboard = () => {

  const navigate = useNavigate()

  return (
    <div className={styles.dashCont}>
        
        <div onClick={() => navigate('/new')}>
        New Account
        </div>
        <div onClick={() => navigate('/deposit')}>
            Deposit
        </div>
        <div onClick={() => navigate('/withdraw')}>
            WithDraw
        </div>
        <div onClick={() => navigate('/transfer')}>
            Transfer
        </div>
        <div onClick={() => navigate('/balance')}>
            Balance
        </div>

        <div onClick={() => navigate('/request')}>
            Request
        </div>

        <div onClick={() => navigate('/send')}>
            Send
        </div>

        <div onClick={() => navigate('/account-tracker')}>
            Account Tracker
        </div>

        <div onClick={() => navigate('/income-tracker')}>
            Income Tracker
        </div>

        <div onClick={() => navigate('/expense-tracker')}>
            Expense Tracker
        </div>
    </div>
)
}

export default Dashboard