package org.launchcode.fourohfourfound.finalproject.controllers;

import org.launchcode.fourohfourfound.finalproject.models.Character;
import org.launchcode.fourohfourfound.finalproject.models.*;
import org.launchcode.fourohfourfound.finalproject.repositories.*;
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
    private LoadoutRepository loadoutRepository;

    static HashMap<String, String> characteristicChoices = new HashMap<>();

    public ListController () {

        characteristicChoices.put("all", "All");
        characteristicChoices.put("alignment", "Alignment");
        characteristicChoices.put("background", "Background");
        characteristicChoices.put("class", "Class");
        characteristicChoices.put("loadout", "Loadout");
        characteristicChoices.put("proficiencies", "Proficiencies");
        characteristicChoices.put("race", "Race");
        characteristicChoices.put("spells", "Spells");
    }

    @RequestMapping("")
    public String list(Model model) {
        List<Loadout> loadouts = (List<Loadout>) loadoutRepository.findAll();
        model.addAttribute("loadout", loadouts);

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

