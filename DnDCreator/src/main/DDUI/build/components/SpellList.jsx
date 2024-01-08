import React, { useEffect, useState } from 'react';
import { getAllSpells } from './api';
import SpellCard from './SpellCard';
import AddSpellsForm from './SpellsComponents';
import './styles.css';


function SpellList() {
const [spells, setSpells] = useState([]);
useEffect(() => {
    // Fetch spells from API or localStorage on component mount
    const savedSpells = localStorage.getItem('spells');
    if (savedSpells) {
    setSpells(JSON.parse(savedSpells));
    } else {
    getAllSpells().then((fetchedSpells) => {
        setSpells(fetchedSpells);
        localStorage.setItem('spells', JSON.stringify(fetchedSpells));
    });
    }
}, []);

const handleAddSpell = (newSpell) => {
    // Logic to add the new spell to the list
    // Update the spells state with the new spell
    setSpells([...spells, newSpell]);
    //update the backend/API here
};

return (
    <div className='App'>
    <h1>Spell List</h1>
    <AddSpellsForm onAddSpell={handleAddSpell} />
    {spells.length === 0 ? (
        <span className='loading'>Loading...</span>
    ) : (
        <ul className='spells-list'>
        {spells.map((spell, index) => (
            <SpellCard key={index} spell={spell} />
        ))}
        </ul>
    )}
    </div>
);
}

export default SpellList;