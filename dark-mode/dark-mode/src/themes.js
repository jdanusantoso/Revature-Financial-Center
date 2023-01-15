import { createGlobalStyle } from "styled-components";

export const light_theme = {

    body: "#fff",
    fontColor: "#000"

};

export const dark_theme = {

    body: "#000",
    fontColor: "#fff"

};

export const GlobalStyles = createGlobalStyle`

    body{

        background-color: ${props => props.theme.body}

    }
`