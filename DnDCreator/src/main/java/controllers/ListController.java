package controllers;

import models.Character;
import models.*;
import models.Data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping (value = "list")
public class ListController {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private AlignmentRepository alignmentRepository;

    @Autowired
    private BackgroundRepository backgroundRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private LoadoutRepository loadoutRepository;

    @Autowired
    private ProficiencyRepository proficiencyRepository;

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private SpellRepository spellRepository;



    static HashMap<String, String> characteristicChoices = new HashMap<>();

    public ListController () {

        characteristicChoices.put("all", "All");
        characteristicChoices.put("alignment", "Alignment");
        characteristicChoices.put("background", "Background");
        characteristicChoices.put("class", "Class");
        characteristicChoices.put("loadout", "Loadout");
        characteristicChoices.put("proficiencies", "proficiencies");
        characteristicChoices.put("race", "Race");
        characteristicChoices.put("spells", "Spells");
    }

    @RequestMapping("")
    public String list(Model model) {
        List<Alignment> alignment = (List<Alignment>) alignmentRepository.findAll();
        model.addAttribute("alignment", alignment);

        List<Background> background = (List<Background>) backgroundRepository.findAll();
        model.addAttribute("background", background);

        List<ClassInfo> classInfo = (List<ClassInfo>) classRepository.findAll();
        model.addAttribute("class info", classInfo);

        List<Loadout> loadouts = (List<Loadout>) loadoutRepository.findAll();
        model.addAttribute("loadout", loadouts);

        List<Proficiencies> proficiencies = (List<Proficiencies>) proficiencyRepository.findAll();
        model.addAttribute("proficiencies", proficiencies);

        List<Race> race = (List<Race>) raceRepository.findAll();
        model.addAttribute("race", race);

        List<Spells> spells = (List<Spells>) spellRepository.findAll();
        model.addAttribute("spells", spells);

        return "list";
    }

    @RequestMapping(value = "characters")
    public String listCharactersByCharacteristicAndValue(Model model, @RequestParam String characteristic, @RequestParam String value) {
        List<Character> characters;
        if (characteristic.toLowerCase().equals("all")) {
            characters = (List<Character>) characterRepository.findAll();
            model.addAttribute("characters", characters);
            model.addAttribute("title", "All Characters");
        } else {
            characters = CharacterData.findByCharacteristicAndValue(characteristic, value, characterRepository.findAll());
            model.addAttribute("title", "Characters with " + characteristicChoices.get(characteristic) + ": " + value);
        }
        model.addAttribute("characters", characters);

        return "list-characters";
    }
}

