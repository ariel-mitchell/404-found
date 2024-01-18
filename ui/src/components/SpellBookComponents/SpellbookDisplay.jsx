// SpellbookDisplay.jsx
import React from 'react';

const SpellbookDisplay = ({ selectedSpells }) => {
// Render logic for displaying selected spell in spellbook
const renderSpellbook = () => {
return selectedSpells.map((spell) => (
    <div key={spell.index}>
    <h4>{spell.name}</h4>
    <p>Level: {spell.level}</p>
    <p>Range: {spell.range}</p>
    </div>
));
};

// Render the component
return (
<div>
    <h3>Spellbook</h3>
    {renderSpellbook()} {/* Corrected function name */}
</div>
);
};

export default SpellbookDisplay;