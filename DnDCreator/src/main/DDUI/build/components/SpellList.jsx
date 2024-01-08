import React, { useEffect, useState} from "react";
import { getAllSpells} from './api'
import SpellCard from './SpellCard';

function SpellList() {
    const {spells, setSpells} = useState([]);

    useEffect(() => {
        getAllSpells().then((spells) => {
            setSpells(spells);
            localStorage.setItem('spells', JSON.stringify(spells));
        });
    });
}