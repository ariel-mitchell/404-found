package models;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import models.Data.*;
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
    public DatabaseLoader(CharacterRepository characterRepository, BackgroundRepository backgroundRepository, AlignmentRepository alignmentRepository, ClassRepository classRepository, LoadoutRepository loadoutRepository, ProficiencyRepository proficiencyRepository, RaceRepository raceRepository, SpellRepository spellRepository) {
        this.characterRepository = characterRepository;
        this.loadoutRepository = loadoutRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Character character1 = new Character();
        Character character2 = new Character();
        List<Character> characters = new ArrayList<>();
        List<Loadout> loadouts = new ArrayList<>();

        Loadout loadout1 = new Loadout();
        loadout1.setWeapon("sword");
        loadout1.setMagicWeapon("staff");
        loadout1.setArmor("armor");
        loadout1.setMagicArmor("mage");
        loadout1.setEquipment("equip");
        loadout1.setTreasure("gold");

        Loadout loadout2 = new Loadout();
        loadout2.setWeapon("spear");
        loadout2.setMagicWeapon("wand");
        loadout2.setArmor("mail");
        loadout2.setMagicArmor("robe");
        loadout2.setEquipment("shovel");
        loadout2.setTreasure("silver");

        character1.setId(1);
        character1.setName("name1");
        character1.setAlignment("alignment");
        character1.setBackground("background");
        character1.setClassInfo("classInfo1");
        character1.setLoadout(loadout1);
        character1.setProficiencies("proficiencies1");
        character1.setProficiencies("proficiencies2");
        character1.setRace("Orc");
        character1.setSpells("Abra");
        character1.setSpells("Kadabra");

        character2.setId(2);
        character2.setName("name2");
        character2.setAlignment("alignment2");
        character2.setBackground("background2");
        character2.setClassInfo("classInfo2");
        character2.setLoadout(loadout2);
        character2.setProficiencies("five");
        character2.setProficiencies("six");
        character2.setRace("Human");
        character2.setSpells("Ala");
        character2.setSpells("Kazam");

        characterRepository.save(character1);
        characterRepository.save(character2);
        loadoutRepository.save(loadout1);
        loadoutRepository.save(loadout2);
    }
}
