// src/components/SpellBookComponents/Spellbook.jsx
import React, { useEffect, useState } from "react";
import { getAllSpells } from "./SpellApiFunctions";
import SpellCard from "./SpellCard";


const Spellbook = () => {
const [spells, setSpells] = useState([]);
const [searchQuery, setSearchQuery] = useState("");
const [filteredSpells, setFilteredSpells] = useState([]);

useEffect(() => {
const savedSpells = localStorage.getItem("spells");

if (savedSpells) {
    setSpells(JSON.parse(savedSpells));
}

getAllSpells().then((spells) => {
    setSpells(spells);
    localStorage.setItem("spells", JSON.stringify(spells));
});
}, []);

useEffect(() => {
// Filter spells based on the search query
const filtered = spells.filter((spell) =>
    spell.name.toLowerCase().includes(searchQuery.toLowerCase())
);
setFilteredSpells(filtered);
}, [searchQuery, spells]);

return (
<body class="spells">
<container>
<div className="Spellbook container mt-3">
    <div className="mb-3">
    <input
        type="text"
        className="form-control"
        placeholder="Search spells..."
        value={searchQuery}
        onChange={(e) => setSearchQuery(e.target.value)}
    />
    </div>
    <div className="row">
    {filteredSpells.length === 0 && (
        <span className="loading col text-center">No spells found.</span>
    )}
    {filteredSpells.map((spell) => (
        <div key={spell.index} className="col mb-4">
        <div className="card h-100 d-flex justify-content-center align-items-center">
            <SpellCard spell={spell} />
        </div>
        </div>
    ))}
    </div>
</div>
</container>
</body>
);
};

export default Spellbook;