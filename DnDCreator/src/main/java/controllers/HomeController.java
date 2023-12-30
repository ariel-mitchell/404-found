package controllers;

import jakarta.validation.Valid;
import models.*;
import models.Character;
import models.Data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/character")
public class HomeController {

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

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "All Characters");
        List<Character> characters = (List<Character>) characterRepository.findAll();
        model.addAttribute("characters", characters);
        return "index";
    }

    @GetMapping("add")
    public String displayAddCharacterForm(Model model) {
        model.addAttribute("title", "Add Character");
        model.addAttribute(new Character());

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

        return "add";
    }

    @PostMapping("add")
    public String processAddCharacterForm(@ModelAttribute @Valid Character newCharacter, Errors errors, Model model, @RequestParam int alignmentId, @RequestParam int backgroundId, @RequestParam int classId, @RequestParam List<Integer> equipment, @RequestParam List<Integer> proficiencies, @RequestParam int raceId, @RequestParam List<Integer> spells) {

        if(errors.hasErrors()) {
            return "add";
        }

        Optional<Alignment> optionalAlignment = alignmentRepository.findById(alignmentId);
        if (optionalAlignment.isPresent()) {
            Alignment alignment = optionalAlignment.get();
            newCharacter.setAlignment(alignment);
        }

        Optional<ClassInfo> optionalClassInfo = classRepository.findById(classId);
        if (optionalClassInfo.isPresent()) {
            ClassInfo classInfo = optionalClassInfo.get();
            newCharacter.setClassInfo(classInfo);
        }

        Optional<Race> optionalRace = raceRepository.findById(raceId);
        if (optionalRace.isPresent()) {
            Race race = optionalRace.get();
            newCharacter.setRace(race);
        }

        Optional<Background> optionalBackground = backgroundRepository.findById(backgroundId);
        if (optionalBackground.isPresent()) {
            Background background = optionalBackground.get();
            newCharacter.setBackground(background);
        }

        List<Loadout> loadoutObjs = (List<Loadout>) loadoutRepository.findAllById(equipment);
        newCharacter.setLoadout(loadoutObjs);

        List<Proficiencies> proficienciesObjs = (List<Proficiencies>) proficiencyRepository.findAllById(proficiencies);
        newCharacter.setProficiencies(proficienciesObjs);

        List<Spells> spellObjs = (List<Spells>) spellRepository.findAllById(spells);
        newCharacter.setSpells(spellObjs);

        characterRepository.save(newCharacter);
        return "redirect:";
    }

    @GetMapping("view/{characterId}")
    public String displayViewCharacter(Model model, @PathVariable int characterId) {
        Optional<Character> optionalCharacter = characterRepository.findById(characterId);
        if(optionalCharacter.isPresent()) {
            Character character = (Character) optionalCharacter.get();
            model.addAttribute("character", character);
            return "view";
        } else {
            return "redirect:./";
        }
    }
}
