package models;

import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import models.Character;
import models.*;
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

    @ManyToOne
    private final BackgroundRepository backgroundRepository;
    private final AlignmentRepository alignmentRepository;
    private final ClassRepository classRepository;
    private final RaceRepository raceRepository;

    @ManyToMany
    private final LoadoutRepository loadoutRepository;
    private final ProficiencyRepository proficiencyRepository;
    private final SpellRepository spellRepository;

    @Autowired
    public DatabaseLoader(CharacterRepository characterRepository, BackgroundRepository backgroundRepository, AlignmentRepository alignmentRepository, ClassRepository classRepository, LoadoutRepository loadoutRepository, ProficiencyRepository proficiencyRepository, RaceRepository raceRepository, SpellRepository spellRepository) {
        this.characterRepository = characterRepository;
        this.backgroundRepository = backgroundRepository;
        this.alignmentRepository = alignmentRepository;
        this.classRepository = classRepository;
        this.loadoutRepository = loadoutRepository;
        this.proficiencyRepository = proficiencyRepository;
        this.raceRepository = raceRepository;
        this.spellRepository = spellRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Character character1 = new Character();
        Character character2= new Character();
        List<Character> characters = new ArrayList<>();
        List<String> loadout1 = (List<String>) new Loadout();

        Loadout loadout1 = new Loadout();
        loadout1.setWeapons("sword");
        loadout1.setMagicWeapons("staff");
        loadout1.setArmor("armor");
        loadout1.setMagicArmor("mage");
        loadout1.setEquipment("equip");
        loadout1.setTreasure("gold");

        Loadout loadout2 = new Loadout();
        loadout2.setWeapons("spear");
        loadout2.setMagicWeapons("wand");
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


    }

    @Override
    public void run(String name, Alignment someAlignment, Background somebackground, ClassInfo someClass, List<Loadout> someLoadout, List<Proficiencies> someProficiencies, Race someRace, List<Spells> someSpells) throws Exception {
        this.characterRepository.save(new Character("name", someAlignment, somebackground, someClass, someRace, someLoadout, someProficiencies, someSpells));
    }

    @Override
    public void run(Object... args) throws Exception {
        this.characterRepository.save(new Character(Alignment, Background, ClassInfo, Race, Loadout, Proficiencies, Spells));
    }

    @Override
    public void run(String... args) throws Exception {
        this.backgroundRepository.save(new Background("someBackground"));
        this.alignmentRepository.save(new Alignment("someAlignment"));
        this.classRepository.save(new ClassInfo("someClassInfo"));
        this.raceRepository.save(new Race("someRace"));
    }

}
