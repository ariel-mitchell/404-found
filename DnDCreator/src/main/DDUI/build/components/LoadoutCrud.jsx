import { useState } from "react";
//import api from "../api";
import LoadoutList from "./LoadoutList";

const LoadoutCrud = {( load, loadouts )} => {
    const [id, setId] = useState("");
    const [name, setName] = useState("");
    const [armor, setArmor] = useState("");
    const [equipment, setEquipment] = useState("");
    const [magicArmor, setMagicArmor] = useState("");
    const [magicWeapon, setMagicWeapon] = useState("");
    const [treasure, setTreasure] = useState("");
    const [weapon, setWeapon] = useState("");

    async function save(event) {
        event.preventDefault();
        await api.post("/create", {
            name: name
            armor: armor
            equipment: equipment
            magicArmor: magicArmor
            magicWeapon: magicWeapon
            treasure: treasure
            weapon: weapon
        });
        alert("Loadout Saved");
        // reset state
        setId("");
        setName("");
        setArmor("");
        setEquipment("");
        setMagicArmor("");
        setMagicWeapon("");
        setTreasure("");
        setWeapon("");
        load();
    }

    async function editLoadout(loadouts) {
        setName(loadouts.name);
        setWeapon(loadouts.weapon);
        setTreasure(loadouts.treasure);
        setMagicWeapon(loadouts.magicWeapon);
        setMagicArmor(loadouts.magicArmor);
        setArmor(loadouts.armor);
        setEquipment(loadouts.equipment);
    }

    async fucntion deleteLoadout(id) {
        await api.delete("/delete/" + id);
        alert("Loadout successfully deleted!");
        load();
    }

    async function update(event) {
        event.preventDefault();
        if (!id) return alert("Loadout not found!");
        await api.put("/update", {
            name: name
            armor: armor
            equipment: equipment
            magicArmor: magicArmor
            magicWeapon: magicWeapon
            treasure: treasure
            weapon: weapon
        });
        alert("Loadout Updated!");
        // reset state
        setId("");
        setName("");
        setArmor("");
        setEquipment("");
        setMagicArmor("");
        setMagicWeapon("");
        setTreasure("");
        setWeapon("");
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
                            onChange={e => setId(e.target.value)}
                        />
                        <label>Name</label>
                        <input
                            type="text"
                            value={name}
                            onChange={e => setName(e.target.value)}
                        />
                    </div>

                    <div>
                        <label>Armor</label>
                            <input
                                type="text"
                                value={armor}
                                placeholder="Armor"
                                onChange={e => setArmor(e.target.value)}
                            />
                    </div>

                    <div>
                        <label>Equipment</label>
                            <input
                                type="text"
                                value={equipment}
                                placeholder="Equipment"
                                onChange={e => setEquipment(e.target.value)}
                            />
                    </div>

                    <div>
                        <label>Magic Armor</label>
                            <input
                                type="text"
                                value={magicArmor}
                                placeholder="Magic Armor"
                                onChange={e => setMagicArmor(e.target.value)}
                            />
                    </div>

                    <div>
                        <label>Magic Weapon</label>
                            <input
                                type="text"
                                value={magicWeapon}
                                placeholder="Magic Weapon"
                                onChange={e => setMagicWeapon(e.target.value)}
                            />
                    </div>

                    <div>
                        <label>Treasure</label>
                            <input
                                type="text"
                                value={treasure}
                                placeholder="treasure"
                                onChange={e => setTreasure(e.target.value)}
                            />
                    </div>

                    <div>
                        <label>Weapon</label>
                            <input
                                type="text"
                                value={weapon}
                                placeholder="Weapon"
                                onChange={e => setWeapon(e.target.value)}
                            />
                    </div>

                    <div>
                        <button onClick={save}> Create </button>
                        <button onClick={update}> Update </button>
                    </div>
                </form>
                <LoadoutListList
                loadouts={loadouts}
                editLoadout={editLoadout}
                deleteLoadout={deleteLoadout}
                />
            </div>
        );
}

export default LoadoutCrud;
