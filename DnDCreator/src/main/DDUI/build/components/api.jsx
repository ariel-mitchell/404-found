const BASE_URL = 'https://www.dnd5eapi.co';

export async function getAllSpells() {
const response = await fetch(`${BASE_URL}/api/spells`);
const spells = await response.json();


const spellDetails = await Promise.all(
    spells.results.map((spell) => fetch(`${BASE_URL}${spell.url}`).then((res) => res.json()))
);

return spellDetails;
}

