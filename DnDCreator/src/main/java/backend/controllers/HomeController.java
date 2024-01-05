package backend.controllers;

import backend.models.Data.CharacterRepository;
import backend.models.Data.LoadoutRepository;
import backend.models.Loadout;
import jakarta.validation.Valid;
import backend.models.*;
import backend.models.Character;
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
    private LoadoutRepository loadoutRepository;

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

        List<Loadout> loadouts = (List<Loadout>) loadoutRepository.findAll();
        model.addAttribute("loadout", loadouts);

        return "add";
    }

    @PostMapping("add")
    public String processAddCharacterForm(@ModelAttribute @Valid Character newCharacter, Errors errors, Model model, @RequestParam int alignmentId, @RequestParam int backgroundId, @RequestParam int classId, @RequestParam List<Integer> loadout, @RequestParam List<Integer> proficiencies, @RequestParam int raceId, @RequestParam List<Integer> spells) {

        if(errors.hasErrors()) {
            return "add";
        }

        List<Loadout> loadoutObjs = (List<Loadout>) loadoutRepository.findAllById(loadout);
        newCharacter.setLoadout((Loadout) loadoutObjs);

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
