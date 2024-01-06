const BASE_URL = "https://www.dnd5eapi.co"

export async function getSpells() {
    const response = await fetch(`${BASE_URL}/api/spells`);
    return await response.json();
}
export async function getClasses() {
    const response = await fetch(`${BASE_URL}/api/classes`);
    return await response.json();
}
