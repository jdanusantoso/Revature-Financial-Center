import logo from './logo.svg';
import './App.css';
import React, {useState} from 'react';
import axios from 'axios'

function App() {
  //setting up use state
  const [quote, setQuote] = useState('')

  //get axios call
  const getQuote = () => {
    axios.get('https://api.quotable.io/random')
    .then(response => {
      console.log(response.data.content)
      setQuote(response.data.content)
    }).catch(err => {
      console.log(err)
    })
  }

  return (
    <div className="App">
      <button onClick={getQuote}>Get Quote</button>
      {/* Get the quote and put it in p tag or leave it as null */}
      {quote ? <p>{quote}</p> : null}
       {/* {quote && <p>{quote}</p>} */}
    </div>
  );
}

export default App;
