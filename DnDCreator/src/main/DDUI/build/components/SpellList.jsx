import React, { useEffect, useState } from 'react';
import { getAllSpells } from './api';
import SpellCard from './SpellCard';

function SpellList() {
const [spells, setSpells] = useState([]);

useEffect(() => {
    getAllSpells().then((spells) => {
    setSpells(spells);
    localStorage.setItem('spells', JSON.stringify(spells));
    });
}, []);
return (
    <div className='App'>
        {spells.length === 0 && <span className='loading'>Loading...</span>}
        <ul className='spells-list'>
            {spells.map((spell) => (
                    <SpellCard key={spell.index} spell={spell} />
                ))}    
        </ul>    
        </div>
    );
}

export default SpellList;