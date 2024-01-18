// components/DieChooser.jsx
import React from 'react';

const DieChooser = ({ dice, setSides }) => {
  return (
    <div style={{ margin: 0, padding: 0, display: 'inline-block', height: 'auto' }}>
      <label style={{ display: 'block', marginBottom: '5px' }}>Select a Die: </label>
      {/* Dropdown to choose the type of die */}
      <select onChange={setSides} style={{ padding: '8px' }}>
        {dice.map((die) => (
          <option key={die} value={die}>
            d{die} - {getDieDescription(die)}
          </option>
        ))}
      </select>
    </div>
  );
};




// Function to get the description of the die based on its sides
const getDieDescription = (sides) => {
switch (sides) {
case 4:
    return '4-sided die (D4)';
case 6:
    return '6-sided die (D6)';
case 8:
    return '8-sided die (D8)';
case 10:
    return '10-sided die (D10)';
case 12:
    return '12-sided die (D12)';
case 20:
    return '20-sided die (D20)';
default:
    return '';
}
};

export default DieChooser;
