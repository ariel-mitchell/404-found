import React, { useState, useEffect } from "react";
import axios from "axios";
import {
  armorArray,
  magicArmorArray,
  weaponArray,
  magicWeaponArray,
  treasures,
} from "./CharacterData.jsx";
import "../styles/CharacterStyles.css";
import { Navigate } from "react-router-dom";

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
  const [equipment, setEquipment] = useState("");
  const [equipmentData, setEquipmentData] = useState(null);
  const [armor, setArmor] = useState("");
  const [magicArmor, setMagicArmor] = useState("");
  const [weapon, setWeapon] = useState("");
  const [magicWeapon, setMagicWeapon] = useState("");
  const [treasure, setTreasure] = useState("");
  const [proficiency1, setProficiency1] = useState("");
  const [proficiency2, setProficiency2] = useState("");
  const [proficienciesData, setProficienciesData] = useState(null);
  const [spell1, setSpell1] = useState("");
  const [spell2, setSpell2] = useState("");
  const [spellsData, setSpellsData] = useState(null);

  const [selectedClassData, setSelectedClassData] = useState(null);
  const [selectedRaceData, setSelectedRaceData] = useState(null);
  const [selectedSpell1Data, setSelectedSpell1Data] = useState(null);
  const [selectedSpell2Data, setSelectedSpell2Data] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const [
          classesResponse,
          racesResponse,
          alignmentResponse,
          equipmentResponse,
          proficienciesResponse,
          spellsResponse,
          backgroundResponse,
        ] = await Promise.all([
          axios.get("https://www.dnd5eapi.co/api/classes/"),
          axios.get("https://www.dnd5eapi.co/api/races/"),
          axios.get("https://www.dnd5eapi.co/api/alignments"),
          axios.get("https://www.dnd5eapi.co/api/equipment/"),
          axios.get("https://www.dnd5eapi.co/api/proficiencies/"),
          axios.get("https://www.dnd5eapi.co/api/spells/"),
          axios.get("https://api.open5e.com/v1/backgrounds/"),
        ]);

        setCharacterClassData(classesResponse.data);
        setAlignmentData(alignmentResponse.data);
        setRaceData(racesResponse.data);
        setEquipmentData(equipmentResponse.data);
        setProficienciesData(proficienciesResponse.data);
        setSpellsData(spellsResponse.data);
        setBackgroundData(backgroundResponse.data);
      } catch (error) {
        console.error("Error fetching data", error);
      }
    };

    fetchData(); // call this to render all info when component "page" loads..
  }, []);

  useEffect(() => {
    const fetchClassData = async () => {
      try {
        const response = await axios.get(
          `https://www.dnd5eapi.co/api/classes/${characterClass.toLowerCase()}`
        );
        setSelectedClassData(response.data);
      } catch (error) {
        console.error("Error fetching class data", error);
      }
    };

    if (characterClass) {
      fetchClassData();
    }
  }, [characterClass]);

  useEffect(() => {
    const fetchSpell1Data = async () => {
      try {
        const response = await axios.get(
          `https://www.dnd5eapi.co/api/spells/${spell1.toLowerCase()}`
        );
        setSelectedSpell1Data(response.data);
      } catch (error) {
        console.error("Error fetching class data", error);
      }
    };

    if (spell1) {
      fetchSpell1Data();
    }
  }, [spell1]);

  useEffect(() => {
    const fetchSpell2Data = async () => {
      try {
        const response = await axios.get(
          `https://www.dnd5eapi.co/api/classes/${spell2.toLowerCase()}`
        );
        setSelectedSpell2Data(response.data);
      } catch (error) {
        console.error("Error fetching class data", error);
      }
    };

    if (spell2) {
      fetchSpell2Data();
    }
  }, [spell2]);

  useEffect(() => {
    const fetchRaceData = async () => {
      try {
        const response = await axios.get(
          `https://www.dnd5eapi.co/api/races/${race.toLowerCase()}`
        );
        setSelectedRaceData(response.data);
      } catch (error) {
        console.error("Error fetching class data", error);
      }
    };

    if (race) {
      fetchRaceData();
    }
  }, [race]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const character = {
      characterName: characterName,
      characterClass: characterClass,
      alignment: alignment,
      race: race,
      background: background,
      proficiencyOne: proficiency1,
      proficiencyTwo: proficiency2,
      spellOne: spell1,
      spellTwo: spell2,
      equipment: equipment,
      armorChoice: armor,
      magicArmor: magicArmor,
      weapon: weapon,
      magicWeapon: magicWeapon,
      treasure: treasure,
    };
    try {
      const response = await axios.post(
        "http://localhost:8080/api/characters/create",
        character,
        { withCredentials: true }
      );
      redirect = 
      console.log(response.data);
    } catch (error) {
      console.error("Error creating character", error);
    }
  };

  function ArmorWeight(armor) {
    let armorWeightType = "";
    if (armorArray.indexOf(armor) <= 2) {
      armorWeightType = "Light Armor";
    } else if (
      armorArray.indexOf(armor) >= 3 &&
      armorArray.indexOf(armor) >= 7
    ) {
      armorWeightType = "Medium Armor";
    } else {
      armorWeightType = "Heavy Armor";
    }
    return armorWeightType;
  }

  function WeaponType(weapon) {
    let typeWeapon = "";
    if (weaponArray.indexOf(weapon) <= 9) {
      typeWeapon = "Simple Melee Weapon";
    } else if (weaponArray.indexOf(weapon) <= 18) {
      typeWeapon = "Ranged Weapon";
    } else {
      typeWeapon = "Martial Melee Weapon";
    }
    return typeWeapon;
  }

  function MagicWeaponType(magicWeapon) {
    let typeMagicWeapon = "";
    if (magicWeaponArray.indexOf(magicWeapon) <= 24) {
      typeMagicWeapon = "Magic Weapon";
    } else if (magicWeaponArray.indexOf(magicWeapon) <= 37) {
      typeMagicWeapon = "Wand";
    } else {
      typeMagicWeapon = "Staff";
    }
    return typeMagicWeapon;
  }

  const treasDesc = treasures.find((item) => item.name === treasure);

  return (
    <div id="characters">
      <h1>
        <strong>
          <u>Welcome to the 404-Found Unofficial Character Sheet!</u>
        </strong>
      </h1>
      <form onSubmit={handleSubmit}>
        <br />
        <br />
        <h3>
          <u>
            <strong>First off, every new adventurer needs a name.</strong>
          </u>
        </h3>
        <br />
        <label htmlFor="characterName">Name Your New Character Here: </label>
        <input
          id="characterName"
          type="text"
          value={characterName}
          onChange={(e) => setCharacterName(e.target.value)}
        />
        <br />
        <br />
        <hr />
        <br />
        <h3>
          <u>
            <strong>
              Now that we know who you are, tell us a little about yourself!
            </strong>
          </u>
        </h3>
        <br />
        <h4>
          Class defines what skills a character has. Think of class as what your
          character's calling is.
        </h4>
        <h4>
          Selecting a class from the drop down below will show you some of their
          areas of proficiency.
        </h4>
        <label htmlFor="classCharacter">
          <strong>Class: </strong>
        </label>
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
        {selectedClassData && (
          <div>
            <br />
            <h2>Selected Class Info:</h2>
            <container className="classSelect">
              <label htmlFor="proficiencies">
                <u>Proficiencies:</u>
              </label>
              <ul>
                {selectedClassData.proficiency_choices[0].from.options.map(
                  (option, index) =>
                    option.item.name && (
                      <li key={index} value={option.item.name}>
                        {option.item.name}
                      </li>
                    )
                )}
              </ul>
              <img src="./classes.jpg" height="500" width="700"></img>
            </container>
            <h2>
              Link to D&D Wiki for more information for more information about
              your selected class:{" "}
              {
                <a
                  href="https://www.dandwiki.com/wiki/5e_SRD:Classes"
                  target="_blank"
                >
                  {" "}
                  {selectedClassData.name}{" "}
                </a>
              }
            </h2>
          </div>
        )}
        <br />
        <hr />
        <h2>A Character's Race is what type of being they are.</h2>
        <h4>Different races have different attributes and properties</h4>
        <h4>
          <u>Enter your Race below</u>
        </h4>
        <container class="alignment">
          <label htmlFor="race">Race:</label>
          <select
            id="race"
            value={race}
            onChange={(e) => setRace(e.target.value)}
          >
            {raceData &&
              raceData.results.map((item, index) => (
                <option key={index} value={item.name}>
                  {item.name}
                </option>
              ))}
          </select>
        </container>
        {selectedRaceData && (
          <div>
            <h2>Selected Race Info:</h2>
            <ul>
              <li>
                <h4>
                  <u>Disposition:</u>
                </h4>{" "}
                {selectedRaceData.alignment}
              </li>
              {
                (selectedRaceData.map = (item) => (
                  <li key={item}>{item.alignment}</li>
                ))
              }
              <li>
                <h4>
                  <u>Longevity:</u>
                </h4>{" "}
                {selectedRaceData.age}
              </li>
              {
                (selectedRaceData.map = (item) => (
                  <li key={item}>{item.age}</li>
                ))
              }
              <li>
                <h4>
                  <u>Size:</u>
                </h4>{" "}
                {selectedRaceData.size_description}
              </li>
              {
                (selectedRaceData.map = (item) => (
                  <li key={item}>{item.size_description}</li>
                ))
              }
            </ul>
            <br />
            <img src="./races.jpg" class="center" />
            <br />
            <h2>
              Link to D&D Wiki for more information for more information about
              your selected race:{" "}
              {
                <a
                  href="https://www.dandwiki.com/wiki/5e_SRD:Classes"
                  target="_blank"
                >
                  {" "}
                  {selectedRaceData.name}{" "}
                </a>
              }
            </h2>
          </div>
        )}
        <br />
        <hr />
        <h2>Alignment is a Measure Of What Ideals You Hold</h2>
        <h4>Select an Alignment for your character below: </h4>
        <container class="alignment">
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
        </container>
        <br />
        <hr />
        <h4>Select a Background:</h4>
        <label htmlFor="background">Background:</label>
        <select
          id="background"
          value={background}
          onChange={(e) => setBackground(e.target.value)}
        >
          {" "}
          {backgroundData &&
            backgroundData.results.map((item, index) => (
              <option key={index} value={item.name}>
                {item.name}
              </option>
            ))}
        </select>
        <br />
        <hr />
        <h2>Your Load-out is an Important Part of your Character</h2>
        <h4>
          You load-out includes your armors, weapons, special equipment, and a
          piece of treasure.
        </h4>
        <br />
        <container>
          <h4>1) Select your Armor first. </h4>
          <label htmlFor="armor">Armor:</label>
          <select
            id="armor"
            value={armor}
            onChange={(e) => setArmor(e.target.value)}
          >
            {armorArray.map((item, index) => (
              <option key={index} value={item}>
                {item}
              </option>
            ))}
          </select>
          {armor && (
            <div>
              <h4>Armor Weight Class: {ArmorWeight(armor)}</h4>
            </div>
          )}
          <br />
        </container>
        <br />
        <container>
          <h4>
            2) Now select your magic buffing armor for when you engage in the
            "Dark Arts"{" "}
          </h4>
          <label htmlFor="magicArmor">Magic Armor:</label>
          <select
            id="magicArmor"
            value={magicArmor}
            onChange={(e) => setMagicArmor(e.target.value)}
          >
            {magicArmorArray.map((item, index) => (
              <option key={index} value={item}>
                {item}
              </option>
            ))}
          </select>
          <br />
        </container>
        <br />
        <container>
          <h4>
            3) Choose a weapon for yourself. Remember, different Classes are
            better with different weapons!
          </h4>
          <label htmlFor="weapon">Weapon:</label>
          <select
            id="weapon"
            value={weapon}
            onChange={(e) => setWeapon(e.target.value)}
          >
            {weaponArray.map((item, index) => (
              <option key={index} value={item}>
                {item}
              </option>
            ))}
          </select>
          {weapon && (
            <div>
              <h4>Weapon Type: {WeaponType(weapon)}</h4>
            </div>
          )}
          <br />
        </container>
        <br />
        <container>
          <h4>4) Now a Magical Weapon</h4>
          <label htmlFor="magicWeapon">Magic Weapon:</label>
          <select
            id="magicWeapon"
            value={magicWeapon}
            onChange={(e) => setMagicWeapon(e.target.value)}
          >
            {magicWeaponArray.map((item, index) => (
              <option key={index} value={item}>
                {item}
              </option>
            ))}
          </select>
          {magicWeapon && (
            <div>
              <h4>Magic Weapon Type: {MagicWeaponType(magicWeapon)}</h4>
            </div>
          )}
          <br />
        </container>
        <br />
        <container>
          <h4>5) Select a piece of Equipment to aid in your travels.</h4>
          <label htmlFor="equipment">Equipment:</label>
          <select
            id="equipment"
            value={equipment}
            onChange={(e) => setEquipment(e.target.value)}
          >
            {equipmentData &&
              equipmentData.results.map((item, index) => (
                <option key={index} value={item.name}>
                  {item.name}
                </option>
              ))}
          </select>
          <br />
        </container>
        <br />
        <container>
          <h4>
            6) Finally, select a piece of Treasure. You never know when it will
            come in handy!
          </h4>
          <label htmlFor="treasure">Treasure:</label>
          <select
            id="treasure"
            value={treasure}
            onChange={(e) => setTreasure(e.target.value)}
          >
            {treasures.map((item, index) => (
              <option key={index} value={item.name}>
                {item.name}
              </option>
            ))}
          </select>
          {treasure && (
            <div>
              <h4>Description: {treasDesc.description}</h4>
            </div>
          )}
        </container>
        <br />
        <hr />
        <h2>Select Two Proficiencies Applicable to your Class!</h2>
        <container class="spells">
          <label htmlFor="proficiency1">First Proficiency:</label>
          <select
            id="proficiency1"
            value={proficiency1}
            onChange={(e) => setProficiency1(e.target.value)}
          >
            {proficienciesData &&
              proficienciesData.results.map((item, index) => (
                <option key={index} value={item.name}>
                  {item.name}
                </option>
              ))}
          </select>
          <br />
          <br />
          <label htmlFor="proficiency2">Second Proficiency:</label>
          <select
            id="proficiency2"
            value={proficiency2}
            onChange={(e) => setProficiency2(e.target.value)}
          >
            {proficienciesData &&
              proficienciesData.results.map((item, index) => (
                <option key={index} value={item.name}>
                  {item.name}
                </option>
              ))}
          </select>
        </container>
        <br />
        <hr />
        <h2>Lastly, Time to Attune Some Spells.</h2>
        <br />
        <h4>
          Refer to the{" "}
          <a href="/Spellbook" target="_blank">
            Spellbook
          </a>{" "}
          page for more information on Spells!{" "}
        </h4>
        <br />
        <container class="spells">
          <label htmlFor="spell1">First Spell Slot:</label>
          <select
            id="spell1"
            value={spell1}
            onChange={(e) => setSpell1(e.target.value)}
          >
            {spellsData &&
              spellsData.results.map((item, index) => (
                <option key={index} value={item.name}>
                  {item.name}
                </option>
              ))}
          </select>
          <br />
          <br />
          <label htmlFor="spell2">Second Spell Slot:</label>
          <select
            id="spell2"
            value={spell2}
            onChange={(e) => setSpell2(e.target.value)}
          >
            {spellsData &&
              spellsData.results.map((item, index) => (
                <option key={index} value={item.name}>
                  {item.name}
                </option>
              ))}
          </select>
        </container>
        <br />
        <hr />
        <h1>
          Once you are satisfied with your choices, press the "Create Character"
          button to save the results to your account!
        </h1>
        <button type="submit">Create Character</button>
      </form>
    </div>
  );
}
