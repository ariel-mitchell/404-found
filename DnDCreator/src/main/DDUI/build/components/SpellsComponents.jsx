import React, { useState } from 'react';

const AddSpellsForm = ({ onAddSpell }) => {
  const [spell, setSpell] = useState({ name: '', spells: '' });

  const handleSubmit = (e) => {
    e.preventDefault();
    // Call the onAddSpell function with the new spell data
    onAddSpell(spell);
    // Clear the form fields after submission
    setSpell({ name: '', spells: '' });
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setSpell({ ...spell, [name]: value });
  };

  return (
    <div>
      <h2>Add Spell</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor='name'>Spell Name</label>
          <input
            type='text'
            id='name'
            name='name'
            value={spell.name}
            onChange={handleInputChange}
          />
        </div>

        <div>
          <label htmlFor='spells'>Spells</label>
          <input
            type='text'
            id='spells'
            name='spells'
            value={spell.spells}
            onChange={handleInputChange}
          />
        </div>

        <input type='submit' value='Add Spell' />
      </form>
    </div>
  );
};

export default AddSpellsForm;
