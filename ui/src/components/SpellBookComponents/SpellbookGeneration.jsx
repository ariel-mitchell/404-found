// SpellbookGenerator.jsx
import React, { useState, useEffect } from 'react';
import axios from 'axios'; // Import Axios
import SpellList from './SpellList';
import SpellbookDisplay from './SpellbookDisplay';
import './Spellbook.css';

const SpellbookGenerator = () => {
// State for storing fetched spells and selected spells
const [spells, setSpells] = useState([]);
const [selectedSpells, setSelectedSpells] = useState([]);

// Fetch spells from D&D 5e API when the component mounts
useEffect(() => {
const fetchSpells = async () => {
    try {
    // Make a GET request to the D&D 5e API for spells
    const response = await axios.get('https://www.dnd5eapi.co/api/spells');
    
    // Extract the results from the response
    const fetchedSpells = response.data.results;
    
    // Update the state with the fetched spells
    setSpells(fetchedSpells);
    } catch (error) {
    // Handle errors if the request fails
    console.error('Error fetching spells:', error);
    }
};

// Call the fetchSpells function when the component mounts
fetchSpells();
}, []);

// Render the component
return (
<div>
    <h2>Spellbook Generator</h2>
    {/* Spell list component */}
    <SpellList spells={spells} setSelectedSpells={setSelectedSpells} />
    {/* Spellbook display component */}
    <SpellbookDisplay selectedSpells={selectedSpells} />
</div>
);
};

export default SpellbookGenerator;