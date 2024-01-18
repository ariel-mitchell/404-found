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
    <div className="App" style={{ textAlign: 'center', margin: '10px' }}>
      <header style={{ backgroundColor: '#282c34', padding: '20px', color: 'white', marginBottom: '10px' }}>
        Die roller
      </header>
      <DieChooser dice={Dice} setSides={(e) => setSides(parseInt(e.target.value, 10))} />
      <div style={{ margin: '5px 0', height: 'auto' }}>
        <label style={{ marginBottom: '5px', display: 'block' }}>Number of Dice: </label>
        <input type="number" min="1" value={numDice} onChange={(e) => setNumDice(parseInt(e.target.value, 10))} style={{ padding: '8px' }} />
      </div>

      <button onClick={handleClick} style={{ padding: '10px 20px', backgroundColor: '#61dafb', color: 'white', fontSize: '16px', cursor: 'pointer', marginTop: '5px' }}>
        Roll
      </button>
      <Result outcomes={outcomes} style={{ fontSize: '24px', margin: '10px 0' }} />
    </div>
  );
};

export default DieRoller;
