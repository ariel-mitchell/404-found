import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Home from './Home.jsx';
import SpellList from './SpellList.jsx';
import './App.css';
import './Styles.css';

function Main() {
return (
    <Router>
    <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/spells" component={SpellList} />
        {/* Define more routes/components */}
    </Switch>
    </Router>
);
}

export default Main;
