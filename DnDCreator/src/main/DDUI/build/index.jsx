import React from 'react';
import ReactDOM from 'react-dom';
import Main from './Main.jsx';
import Home from "./components/Home.jsx";

const rootElement = document.getElementById('root');

ReactDOM.render(
  <React.StrictMode>
    <Main />
    <Home />
  </React.StrictMode>,
  rootElement
);
