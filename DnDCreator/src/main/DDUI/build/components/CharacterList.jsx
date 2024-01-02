import React from "react";

const CharacterList = ({ characters, editCharacter, deleteCharacter}) => {
    return (
        <table align="center">
            <thead>
                <tr>
                    <th scope="col">Nº</th>
                    <th scope="col">Name</th>
                    <th scope="col">Alignment</th>
                    <th scope="col">Background</th>
                    <th scope="col">Class</th>
                    <th scope="col">Race</th>
                    <th scope="col">Loadout</th>
                    <th scope="col">Proficiencies</th>
                    <th scope="col">Spells</th>

                    <th scope="col">Option</th>
                </tr>
            </thead>
            {characters.map((character, index) => {
                return (
                    <tbody>
                        <tr>
                            <th scope="row">{index + 1} </th>
                            <td>{character.name}</td>
                            <td>{character.alignment}</td>
                            <td>{character.background}</td>
                            <td>{character.classInfo}</td>
                            <td>{character.race}</td>
                            <td>{character.loadout}</td>
                            <td>{character.proficiencies}</td>
                            <td>{character.spells}</td>
                            <td>
                                <button
                                    type="button"
                                    onClick={() => editCharacter(character)}
                                >
                                    Edit
                                </button>
                                <button
                                    type="button"
                                    onClick={() => deleteCharacter(character.id)}
                                >
                                    Delete
                                </button>
                            </td>
                        </tr>
                    </tbody>
                );
            })}
        </table>
    );
};

export default CharacterList;