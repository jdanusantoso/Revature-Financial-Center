import "./App.css";
import Form from "./component/form";
import { createContext, useState } from "react";

export const ThemeContext = createContext(null);

function App() {
  const [theme, setTheme] = useState("dark")

  const toggleTheme = () => {

    setTheme((curr) => (curr === "light" ? "dark" : "light"))

  }

  return (
    <ThemeContext.Provider value = {{theme, toggleTheme}}>
      <div className="App">
     
    </div>
    </ThemeContext.Provider>
    
  );
}

export default App;
