import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Home from "./components/Home.jsx";
import SpellList from "./components/SpellList.jsx";
import './Styles.css';

function App() {
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

export default App;
