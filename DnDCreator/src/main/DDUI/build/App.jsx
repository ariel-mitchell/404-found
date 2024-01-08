import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Home from './Home.jsx';
import SpellList from './SpellList.jsx';

function App() {
  return (
    <Router>
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/spells" component={SpellList} />
      </Switch>
    </Router>
  );
}

export default App;
