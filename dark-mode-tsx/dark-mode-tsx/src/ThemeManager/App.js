import React, { useState } from "react";
import "./App.css";
import styled, { ThemeProvider } from "styled-components";
import { light_theme, dark_theme, GlobalStyles } from "./themes.js";

const StyledApp = styled.div`
  color: ${(props) => props.theme.fontColor};
`;

function App() {
  const [theme, setTheme] = useState("light");

  const themeToggler = () => {
    theme === "light" ? setTheme("dark") : setTheme("light");
  };

  return (
    <ThemeProvider theme={theme === "light" ? light_theme : dark_theme}>
      <GlobalStyles />
      <StyledApp>
        Hello World
        <button onClick={() => themeToggler()}>Change Theme</button>
      </StyledApp>
    </ThemeProvider>
  );
}

export default App;
