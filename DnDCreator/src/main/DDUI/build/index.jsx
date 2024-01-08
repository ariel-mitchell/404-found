import React from 'react';
import ReactDOM from 'react-dom';
import Main from './Main.jsx'; // Import your Main component

const rootElement = document.getElementById('root');

ReactDOM.render(
  <React.StrictMode>
    <Main />
  </React.StrictMode>,
  rootElement
);
