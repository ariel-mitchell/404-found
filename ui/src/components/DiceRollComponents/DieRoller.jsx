// components/DieRoller.jsx
import React, { useState } from 'react';
import DieChooser from './DieChooser';
import Result from './Result';

const Dice = [4, 6, 8, 10, 12, 20];

const DieRoller = () => {
const [outcomes, setOutcomes] = useState([]); // Initialize with an empty array
const [numDice, setNumDice] = useState(1);
const [sides, setSides] = useState(Dice[0]);

const handleClick = () => {
const rolls = [];
for (let i = 0; i < numDice; i++) {
    rolls.push(Math.floor(Math.random() * sides) + 1);
}
console.log('Rolls:', rolls);
setOutcomes(rolls);
};

return (
<div className="App">
    <header className="App-header">
    Die roller
    </header>
    <DieChooser dice={Dice} setSides={(e) => setSides(parseInt(e.target.value, 10))} />
    <div>
    <label>Number of Dice: </label>
    <input type="number" min="1" value={numDice} onChange={(e) => setNumDice(parseInt(e.target.value, 10))} />
    </div>
    <button onClick={handleClick}>Roll</button>
    <Result outcomes={outcomes} />
</div>
);
};

export default DieRoller;