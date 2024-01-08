package models;

import models.loadout_models.*;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import org.launchcode.fourohfourfound.finalproject.repositories.CharacterRepository;
import org.launchcode.fourohfourfound.finalproject.repositories.LoadoutRepository;
import models.loadout_models.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @OneToMany
    private final CharacterRepository characterRepository;

    @ManyToMany
    private final LoadoutRepository loadoutRepository;


    @Autowired
    public DatabaseLoader(CharacterRepository characterRepository,  LoadoutRepository loadoutRepository) {
        this.characterRepository = characterRepository;
        this.loadoutRepository = loadoutRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Character character1 = new Character();

        Weapon sword = new Weapon();
        MagicWeapon staff = new MagicWeapon();
        Armor armor = new Armor();
        MagicArmor mage = new MagicArmor();
        Equipment equip = new Equipment();
        Treasure gold = new Treasure();

        Loadout loadout1 = new Loadout();
        loadout1.setWeapon(sword);
        loadout1.setMagicWeapon(staff);
        loadout1.setArmor(armor);
        loadout1.setMagicArmor(mage);
        loadout1.setEquipment(equip);
        loadout1.setTreasure(gold);

        List<String> prof = new ArrayList<>();
        prof.add("proficiencies");
        prof.add("profic");

        List<String> spell = new ArrayList<>();
        spell.add("Abra");
        spell.add("Kadabra");

        character1.setId(1);
        character1.setName("name1");
        character1.setAlignment("alignment");
        character1.setBackground("background");
        character1.setClassInfo("classInfo1");
        character1.setLoadout(loadout1);
        character1.setProficiencies(prof);
        character1.setRace("Orc");
        character1.setSpells(spell);


        characterRepository.save(character1);
        loadoutRepository.save(loadout1);
    }
}
