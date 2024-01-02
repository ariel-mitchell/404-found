import React from "react";

const LoadoutList = ({ loadouts, editLoadout, deleteLoadout}) => {
    return (
        <table align="center">
            <thead>
                <tr>
                    <th scope="col">Nº</th>
                    <th scope="col">Name</th>
                    <th scope="col">Armor</th>
                    <th scope="col">Equipment</th>
                    <th scope="col">Magic Armor</th>
                    <th scope="col">Magic Weapon</th>
                    <th scope="col">Treasure</th>
                    <th scope="col">Weapon</th>

                    <th scope="col">Option</th>
                </tr>
            </thead>
            {characters.map((loadout, index) => {
                return (
                    <tbody key={loadout.id}>
                        <tr>
                            <th scope="row">{index + 1} </th>
                            <td>{loadout.name}</td>
                            <td>{loadout.armor}</td>
                            <td>{loadout.magicArmor}</td>
                            <td>{loadout.weapon}</td>
                            <td>{loadout.magicWeapon}</td>
                            <td>{loadout.equipment}</td>
                            <td>{loadout.treasure}</td>
                            <td>
                                <button
                                    type="button"
                                    onClick={() => editLoadout(loadout)}
                                >
                                    Edit
                                </button>
                                <button
                                    type="button"
                                    onClick={() => deleteLoadout(loadout.id)}
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

export default LoadoutList;