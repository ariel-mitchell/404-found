import React, { useState } from 'react';

const AddSpellsForm = () => {
  // Define state for spell and spells
const [spell, setSpell] = useState({ name: '', spells: '' });

  // Handle form submission
const handleSubmit = (e) => {
    e.preventDefault();
    // Add logic here to handle form submission, e.g., API calls
    console.log('Submitted:', spell);
};

  // Handle input changes
const handleInputChange = (e) => {
    const { name, value } = e.target;
    setSpell({ ...spell, [name]: value });
};

return (
    <div>
    <h1>Add Spells</h1>

    <form onSubmit={handleSubmit}>
        <div>
        <label htmlFor="name">Spell Name</label>
        <input
            type="text"
            id="name"
            name="name"
            value={spell.name}
            onChange={handleInputChange}
        />
        </div>

        <div>
        <label htmlFor="spells">Spells</label>
        <input
            type="text"
            id="spells"
            name="spells"
            value={spell.spells}
            onChange={handleInputChange}
        />
        </div>

        <input type="submit" value="Add Spell" />
    </form>
    </div>
);
};

export default AddSpellsForm;