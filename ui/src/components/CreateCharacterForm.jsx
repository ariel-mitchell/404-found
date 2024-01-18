import React, { useState, useEffect } from "react";
import axios from "axios";

export default function CreateCharacterForm() {
  const [characterName, setCharacterName] = useState("");
  const [characterClass, setCharacterClass] = useState("");
  const [characterClassData, setCharacterClassData] = useState(null);
  const [alignment, setAlignment] = useState("");
  const [alignmentData, setAlignmentData] = useState(null);
  const [race, setRace] = useState("");
  const [raceData, setRaceData] = useState(null);
  const [background, setBackground] = useState("");
  const [backgroundData, setBackgroundData] = useState(null);
  const [loadout, setLoadout] = useState([]);
  const [proficiencies, setProficiencies] = useState([]);
  const [proficienciesData, setProficienciesData] = useState(null);
  const [spells, setSpells] = useState([]);
  const [spellsData, setSpellsData] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const [
          classesResponse,
          alignmentResponse,
          racesResponse,
          backgroundsResponse,
          proficienciesResponse,
          spellsResponse,
        ] = await Promise.all([
          axios.get("https://www.dnd5eapi.co/api/classes/"),
          axios.get("https://www.dnd5eapi.co/api/alignments"),
          axios.get("https://www.dnd5eapi.co/api/races/"),
          axios.get("https://www.dnd5eapi.co/api/backgrounds/"),
          axios.get("https://www.dnd5eapi.co/api/proficiencies/"),
          axios.get("https://www.dnd5eapi.co/api/spells/"),
        ]);

        setCharacterClassData(classesResponse.data);
        setAlignmentData(alignmentResponse.data);
        setRaceData(racesResponse.data);
        setBackgroundData(backgroundsResponse.data);
        setProficienciesData(proficienciesResponse.data);
        setSpellsData(spellsResponse.data);
      } catch (error) {
        console.error("Error fetching data", error);
      }
    };

    fetchData();
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const character = {
      name: characterName,
      characterClass: characterClass,
      alignment: alignment,
      race: race,
      background: background,
      loadout: loadout,
      proficiencies: proficiencies,
      spells: spells,
    };
    try {
      const response = await axios.post(
        "http://localhost:8080/api/characters",
        character
      );
      console.log(response.data);
    } catch (error) {
      console.error("Error creating character", error);
    }
  };

  return (
    <div id="characters">
      <h1>Create a Character!</h1>
      <form onSubmit={handleSubmit}>
        <label htmlFor="characterName">Name:</label>
        <input
          id="characterName"
          type="text"
          value={characterName}
          onChange={(e) => setCharacterName(e.target.value)}
        />
        <label htmlFor="classCharacter">Class:</label>
        <select
          id="characterClass"
          value={characterClass}
          onChange={(e) => setCharacterClass(e.target.value)}
        >
          {characterClassData &&
            characterClassData.results.map((item, index) => (
              <option key={index} value={item.name}>
                {item.name}
              </option>
            ))}
        </select>
        <label htmlFor="alignmentCharacter">Alignment:</label>
        <select
          id="alignment"
          value={alignment}
          onChange={(e) => setAlignment(e.target.value)}
        >
          {alignmentData &&
            alignmentData.results.map((item, index) => (
              <option key={index} value={item.name}>
                {item.name}
              </option>
            ))}
        </select>
        <label htmlFor="alignmentCharacter">Race:</label>
        <select
          id="race"
          value={alignment}
          onChange={(e) => setRace(e.target.value)}
        >
          {raceData &&
            raceData.results.map((item, index) => (
              <option key={index} value={item.name}>
                {item.name}
              </option>
            ))}
        </select>
        <label htmlFor="backgroundCharacter">Background:</label>
        <select
          id="background"
          value={background}
          onChange={(e) => setBackground(e.target.value)}
        >
          {backgroundData &&
            backgroundData.results.map((item, index) => (
              <option key={index} value={item.name}>
                {item.name}
              </option>
            ))}
        </select>
        <label htmlFor="loadout">Loadout:</label>
        <input
          id="loadout"
          type="text"
          value={loadout}
          onChange={(e) => setLoadout(e.target.value)}
        />
        <label htmlFor="proficiencies">Proficiencies:</label>
        <select
          id="proficiencies"
          value={proficiencies}
          multiple={true}
          onChange={(e) => setProficiencies(Array.from(e.target.selectedOptions, option => option.value))}
        >
          {proficienciesData &&
            proficienciesData.results.map((item, index) => (
              <option key={index} value={item.name}>
                {item.name}
              </option>
            ))}
        </select>
        <label htmlFor="spells">Spells:</label>
        <select
          id="spells"
          value={spells}
          multiple={true}
          onChange={(e) => setSpells(Array.from(e.target.selectedOptions, option => option.value))}
        >
          {spellsData &&
            spellsData.results.map((item, index) => (
              <option key={index} value={item.name}>
                {item.name}
              </option>
            ))}
        </select>
        <button type="submit">Create Character</button>
      </form>
    </div>
  );
}
