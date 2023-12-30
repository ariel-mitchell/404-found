package models;

import models.Character;
import models.*;
import models.Data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final CharacterRepository characterRepository;
    private final BackgroundRepository backgroundRepository;
    private final AlignmentRepository alignmentRepository;
    private final ClassRepository classRepository;
    private final LoadoutRepository loadoutRepository;
    private final ProficiencyRepository proficiencyRepository;
    private final RaceRepository raceRepository;
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
    public void run(String name, Alignment someAlignment, Background somebackground, ClassInfo someClass, List<Loadout> someLoadout, List<Proficiencies> someProficiencies, Race someRace, List<Spells> someSpells) throws Exception {
        this.characterRepository.save(new Character("name", someAlignment, somebackground, someClass, someRace, someLoadout, someProficiencies, someSpells));
        this.backgroundRepository.save(new Background());
    }
}
