const BASE_URL = "https://www.dnd5eapi.co"

export async function getSpells() {
    const response = await fetch(`${BASE_URL}/api/spells`);
    const spells = await response.json();
    return await response.json();

    const spellDetails await Promise.all( 
        spells.results.map((spells) => fetch(`${BASE_URL}${spells.url}`).then((res) => res.json()))
    );
}
export async function getClasses() {
    const response = await fetch(`${BASE_URL}/api/classes`);
    return await response.json();
}

return spellDetails;

