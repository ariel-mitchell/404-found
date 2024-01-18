import React, { useState, useEffect, useContext } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faPencilAlt } from "@fortawesome/free-solid-svg-icons";
import axios from "axios";
import { AuthUserContext } from "../AuthUser";
import "../styles/DisplayCharacters.css";
//button style not my favorite, but it works for now
export default function DisplayCharacters({}) {
  const [characters, setCharacters] = useState([]);
  const [characterDetails, setCharacterDetails] = useState({}); // this is the character object that will be passed to the edit form
  const [editingField, setEditingField] = useState(null); // this is the field that will be edited
  const authUser = useContext(AuthUserContext); // here for reference, not needed with backend call

  // This page is way to long. Will refactor to make it easier to read. Focusing on functionality for now.

  const fetchCharacters = async () => {
    const userInSession = await axios.get(
      // this fetches user from session, and grabs id from backend method
      "http://localhost:8080/api/currentUserId",
      { withCredentials: true },
    );
    const currentUserId = userInSession.data;
    try {
      const response = await axios.get(
        `http://localhost:8080/api/characters/${currentUserId}`,
        { withCredentials: true },
      );
      setCharacters(response.data);
    } catch (error) {
      console.error("Error fetching characters", error);
    }
  };

  useEffect(() => {
    fetchCharacters();
  }, []);

  const handleEditClick = (field, character) => {
    setEditingField(field);
    setCharacterDetails(character);
  };

  const deleteCharacter = async (id) => {
    const userConfirmation = window.confirm('Are you sure you want to delete this character?');
    if (userConfirmation) {
      try {
        const response = await axios.delete(`http://localhost:8080/api/characters/delete/${id}`, { withCredentials: true });
        console.log(response.data);
        fetchCharacters(); // Refresh your characters list
      } catch (error) {
        console.error('Error deleting character', error);
      }
    }
  };

  const handleSave = async (event) => {
    if (event.key === "Enter" || event.type === "blur") {
      try {
        const response = await axios.put(
          `http://localhost:8080/api/characters/${characterDetails.id}`,
          characterDetails,
          setEditingField(null),
          { withCredentials: true }, // this sends a valid request each time the user presses enter after editing a field or clicks away.
        );
        console.log(response.data);
        fetchCharacters();
      } catch (error) {
        console.error("Error updating character", error);
      }
    }
  };
  return (
    <div className="title">
      <h1>User's Characters</h1>
      <img src="./ui/public/dnd-5e-spells-wizard.webp" class="center" />
      <div className="character-grid">
        {characters.map((character, index) => (
          <div key={index} className="character">
            <p>
            <button onClick={() => deleteCharacter(character.id)}>Delete</button>
              Name:
              {editingField === "characterName" &&
              character.id === characterDetails.id ? ( // ternary conditonal to check if the field is being edited and if the character id matches the character id of the character being edited
                <input
                  value={characterDetails.characterName}
                  onChange={(
                    e, // on change of the input, the character details state is updated with the new value
                  ) =>
                    setCharacterDetails({
                      ...characterDetails, // this is a spread operator that copies the character details object
                      characterName: e.target.value,
                    })
                  }
                  onBlur={handleSave}
                  onKeyDown={handleSave}
                  autoFocus
                />
              ) : (
                <>
                  {character.characterName}
                  <button
                    className="same-size-button"
                    onClick={() => handleEditClick("characterName", character)}
                  >
                    <FontAwesomeIcon icon={faPencilAlt} />
                  </button>
                </>
              )}
            </p>
            <p>
              Class:
              {editingField === "characterClass" &&
              character.id === characterDetails.id ? (
                <input
                  value={characterDetails.characterClass}
                  onChange={
                    (e) =>
                      setCharacterDetails({
                        ...characterDetails,
                        characterClass: e.target.value, //i add the spread operator to each field so that the other fields are not overwritten when the user edits a field
                      }) // this is achieved because the character details state is updated with the new value, and the spread operator copies the other fields
                  }
                  onBlur={handleSave}
                  onKeyDown={handleSave}
                />
              ) : (
                <>
                  {character.characterClass}
                  <button
                    className="same-size-button"
                    onClick={() => handleEditClick("characterClass", character)}
                  >
                    <FontAwesomeIcon icon={faPencilAlt} />
                  </button>
                </>
              )}
            </p>
            <p>
              Race:
              {editingField === "race" &&
              character.id === characterDetails.id ? (
                <input
                  value={characterDetails.race}
                  onChange={(e) =>
                    setCharacterDetails({
                      ...characterDetails,
                      race: e.target.value,
                    })
                  }
                  onBlur={handleSave}
                  onKeyDown={handleSave}
                />
              ) : (
                <>
                  {character.race}
                  <button
                    className="same-size-button"
                    onClick={() => handleEditClick("race", character)}
                  >
                    <FontAwesomeIcon icon={faPencilAlt} />
                  </button>
                </>
              )}
            </p>
            <p>
              Alignment:
              {editingField === "alignment" &&
              character.id === characterDetails.id ? (
                <input
                  value={characterDetails.alignment}
                  onChange={(e) =>
                    setCharacterDetails({
                      ...characterDetails,
                      alignment: e.target.value,
                    })
                  }
                  onBlur={handleSave}
                  onKeyDown={handleSave}
                />
              ) : (
                <>
                  {character.alignment}
                  <button
                    className="same-size-button"
                    onClick={() => handleEditClick("alignment", character)}
                  >
                    <FontAwesomeIcon icon={faPencilAlt} />
                  </button>
                </>
              )}
            </p>
            <p>
              Background:
              {editingField === "background" &&
              character.id === characterDetails.id ? (
                <input
                  value={characterDetails.background}
                  onChange={(e) =>
                    setCharacterDetails({
                      ...characterDetails,
                      background: e.target.value,
                    })
                  }
                  onBlur={handleSave}
                  onKeyDown={handleSave}
                />
              ) : (
                <>
                  {character.background}
                  <button
                    className="same-size-button"
                    onClick={() => handleEditClick("background", character)}
                  >
                    <FontAwesomeIcon icon={faPencilAlt} />
                  </button>
                </>
              )}
            </p>
            <p>
              Armor:
              {editingField === "armorChoice" &&
              character.id === characterDetails.id ? (
                <input
                  value={characterDetails.armorChoice}
                  onChange={(e) =>
                    setCharacterDetails({
                      ...characterDetails,
                      armorChoice: e.target.value,
                    })
                  }
                  onBlur={handleSave}
                  onKeyDown={handleSave}
                />
              ) : (
                <>
                  {character.armorChoice}
                  <button
                    className="same-size-button"
                    onClick={() => handleEditClick("armorChoice", character)}
                  >
                    <FontAwesomeIcon icon={faPencilAlt} />
                  </button>
                </>
              )}
            </p>
            Magic Armor:
            {editingField === "magicArmor" &&
            character.id === characterDetails.id ? (
              <input
                value={characterDetails.magicArmor}
                onChange={(e) =>
                  setCharacterDetails({
                    ...characterDetails,
                    magicArmor: e.target.value,
                  })
                }
                onBlur={handleSave}
                onKeyDown={handleSave}
              />
            ) : (
              <>
                {character.magicArmor}
                <button
                  className="same-size-button"
                  onClick={() => handleEditClick("magicArmor", character)}
                >
                  <FontAwesomeIcon icon={faPencilAlt} />
                </button>
              </>
            )}
            Weapon:
            {editingField === "weapon" &&
            character.id === characterDetails.id ? (
              <input
                value={characterDetails.weapon}
                onChange={(e) =>
                  setCharacterDetails({
                    ...characterDetails,
                    weapon: e.target.value,
                  })
                }
                onBlur={handleSave}
                onKeyDown={handleSave}
              />
            ) : (
              <>
                {character.weapon}
                <button
                  className="same-size-button"
                  onClick={() => handleEditClick("weapon", character)}
                >
                  <FontAwesomeIcon icon={faPencilAlt} />
                </button>
              </>
            )}
            Magic Weapon:
            {editingField === "magicWeapon" &&
            character.id === characterDetails.id ? (
              <input
                value={characterDetails.magicWeapon}
                onChange={(e) =>
                  setCharacterDetails({
                    ...characterDetails,
                    magicWeapon: e.target.value,
                  })
                }
                onBlur={handleSave}
                onKeyDown={handleSave}
              />
            ) : (
              <>
                {character.magicWeapon}
                <button
                  className="same-size-button"
                  onClick={() => handleEditClick("magicWeapon", character)}
                >
                  <FontAwesomeIcon icon={faPencilAlt} />
                </button>
              </>
            )}
            Equipment:
            {editingField === "equipment" &&
            character.id === characterDetails.id ? (
              <input
                value={characterDetails.equipment}
                onChange={(e) =>
                  setCharacterDetails({
                    ...characterDetails,
                    equipment: e.target.value,
                  })
                }
                onBlur={handleSave}
                onKeyDown={handleSave}
              />
            ) : (
              <>
                {character.equipment}
                <button
                  className="same-size-button"
                  onClick={() => handleEditClick("magicWeapon", character)}
                >
                  <FontAwesomeIcon icon={faPencilAlt} />
                </button>
              </>
            )}
            Treasure:
            {editingField === "treasure" &&
            character.id === characterDetails.id ? (
              <input
                value={characterDetails.equipment}
                onChange={(e) =>
                  setCharacterDetails({
                    ...characterDetails,
                    treasure: e.target.value,
                  })
                }
                onBlur={handleSave}
                onKeyDown={handleSave}
              />
            ) : (
              <>
                {character.treasure}
                <button
                  className="same-size-button"
                  onClick={() => handleEditClick("treasure", character)}
                >
                  <FontAwesomeIcon icon={faPencilAlt} />
                </button>
              </>
            )}
            First Proficiency:
            {editingField === "proficiencyOne" &&
            character.id === characterDetails.id ? (
              <input
                value={characterDetails.proficiencyOne}
                onChange={(e) =>
                  setCharacterDetails({
                    ...characterDetails,
                    proficiencyOne: e.target.value,
                  })
                }
                onBlur={handleSave}
                onKeyDown={handleSave}
              />
            ) : (
              <>
                {character.proficiencyOne}
                <button
                  className="same-size-button"
                  onClick={() => handleEditClick("proficiencyOne", character)}
                >
                  <FontAwesomeIcon icon={faPencilAlt} />
                </button>
              </>
            )}
            Second Proficiency:
            {editingField === "proficiencyTwo" &&
            character.id === characterDetails.id ? (
              <input
                value={characterDetails.proficiencyTwo}
                onChange={(e) =>
                  setCharacterDetails({
                    ...characterDetails,
                    proficiencyTwo: e.target.value,
                  })
                }
                onBlur={handleSave}
                onKeyDown={handleSave}
              />
            ) : (
              <>
                {character.proficiencyTwo}
                <button
                  className="same-size-button"
                  onClick={() => handleEditClick("proficiencyTwo", character)}
                >
                  <FontAwesomeIcon icon={faPencilAlt} />
                </button>
              </>
            )}
            First Spell:
            {editingField === "spellOne" &&
            character.id === characterDetails.id ? (
              <input
                value={characterDetails.spellOne}
                onChange={(e) =>
                  setCharacterDetails({
                    ...characterDetails,
                    spellOne: e.target.value,
                  })
                }
                onBlur={handleSave}
                onKeyDown={handleSave}
              />
            ) : (
              <>
                {character.spellOne}
                <button
                  className="same-size-button"
                  onClick={() => handleEditClick("spellOne", character)}
                >
                  <FontAwesomeIcon icon={faPencilAlt} />
                </button>
              </>
            )}
            Second Spell:
            {editingField === "spellTwo" &&
            character.id === characterDetails.id ? (
              <input
                value={characterDetails.spellTwo}
                onChange={(e) =>
                  setCharacterDetails({
                    ...characterDetails,
                    spellTwo: e.target.value,
                  })
                }
                onBlur={handleSave}
                onKeyDown={handleSave}
              />
            ) : (
              <>
                {character.spellTwo}
                <button
                  className="same-size-button"
                  onClick={() => handleEditClick("spellTwo", character)}
                >
                  <FontAwesomeIcon icon={faPencilAlt} />
                </button>
              </>
            )}
          </div>
        ))}
      </div>
    </div>
  );
}
