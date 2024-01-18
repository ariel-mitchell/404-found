// SpellList.jsx
import React from 'react';

const SpellList = ({ spells, setSelectedSpells }) => {
// Render logic for displaying spells with buttons to add to spellbook
const renderSpells = () => {
return spells.map((spell) => (
    <div key={spell.index}>
    <h4>{spell.name}</h4>
    <button onClick={() => addToSpellbook(spell)}>Add to Spellbook</button>
    </div>
));
};

// Add selected spell to the spellbook
const addToSpellbook = (spell) => {
setSelectedSpells((prevSpells) => [...prevSpells, spell]);
};

// Render the component
return (
<div>
    <h3>Spell List</h3>
    {renderSpells()}
</div>
);
};

export default SpellList;