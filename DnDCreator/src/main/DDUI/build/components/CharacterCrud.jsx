import { useState } from "react";
//import api from "../api.axios";
import CharacterList from "./CharacterList";

const CharacterCrud = ({load, characters }) => {
    const [id, setId] = useState("");
    const [name, setName] = useState("");
    const [alignment, setAlignment] = useState("");
    const [background, setBackground] = useState("");
    const [classInfo, setClassInfo] = useState("");
    const [race, setRace] = useState("");
    const [loadouts, setLoadout] = useState("");
    const [proficiencies, setProficiencies] = useState("");
    const [spells, setSpells] = useState("");

    async function save(event) {
        event.preventDefault();
        await api.post("/create", {
            name: name,
            alignment: alignment,
            background: background,
            classInfo: classInfo,
            race: race,
            loadouts: loadouts,
            proficiencies: proficiencies,
            spells: spells,
        });
        alert("Character Record Saved");
        // reset State
        setId("");
        setName("");
        setAlignment("");
        setBackground("");
        setClassInfo("");
        setRace("");
        setLoadout("");
        setProficiencies("");
        setSpells("");
        load();
    }

    async function editCharacter(characters) {
        setName(characters.name);
        setAlignment(characters.alignment);
        setBackground(characters.background);
        setClassInfo(characters.classInfo);
        setRace(characters.race);
        setLoadout(characters.loadouts);
        setProficiencies(characters.proficiencies);
        setSpells(characters.spells);
    }

    async function deleteCharacter(id) {
        await api.delete("/delete/" + id);
        alert("Character Deleted Successfully");
        load();
    }

    async function update(event) {
        event.preventDefault();
        if (!id) return alert("Character not found!");
        await api.put("/update", {
            name: name,
            alignment: alignment,
            background: background,
            classInfo: classInfo,
            race: race,
            loadouts: loadouts,
            proficiencies: proficiencies,
            spells: spells,
        });
        alert("Character updated!");
        // reset state
        setId("");
        setName("");
        setAlignment("");
        setBackground("");
        setClassInfo("");
        setRace("");
        setLoadout("");
        setProficiencies("");
        setSpells("");
        load();
    }

    return (
        <div>
            <form>
                <div>
                    <input
                        type="text"
                        hidden
                        value={id}
                        onChange={e => setName(e.target.value)}
                    />
                    <label>Name</label>
                    <input
                        type="text"
                        value={name}
                        onChange={e => setName(e.target.value)}
                    />
                </div>

                <div>
                    <label>Alignment</label>
                        <input
                            type="text"
                            value={alignment}
                            placeholder="Alignments"
                            onChange={e => setAlignment(e.target.value)}
                        />
                </div>

                <div>
                    <label>Background</label>
                        <input
                            type="text"
                            value={background}
                            placeholder="Background"
                            onChange={e => setBackground(e.target.value)}
                        />
                </div>

                <div>
                    <label>Class</label>
                        <input
                            type="text"
                            value={classInfo}
                            placeholder="Class"
                            onChange={e => setClassInfo(e.target.value)}
                        />
                </div>

                <div>
                    <label>Race</label>
                        <input
                            type="text"
                            value={race}
                            placeholder="Race"
                            onChange={e => setRace(e.target.value)}
                        />
                </div>

                <div>
                    <label>Loadout</label>
                        <input
                            type="text"
                            value={loadouts}
                            placeholder="Loadout"
                            onChange={e => setLoadout(e.target.value)}
                        />
                </div>

                <div>
                    <label>Proficiencies</label>
                        <input
                            type="text"
                            value={proficiencies}
                            placeholder="Proficiencies"
                            onChange={e => setProficiencies(e.target.value)}
                        />
                </div>

                <div>
                    <label>Spells</label>
                        <input
                            type="text"
                            value={spells}
                            placeholder="Spells"
                            onChange={e => setSpells(e.target.value)}
                        />
                </div>


                <div>
                    <button onClick={save}> Create </button>
                    <button onClick={update}> Update </button>
                </div>
            </form>
            <CharacterList
            characters={characters}
            editCharacter={editCharacter}
            deleteCharacter={deleteCharacter}
            />
        </div>
    );
};

export default CharacterCrud;