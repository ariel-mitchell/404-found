package org.launchcode.fourohfourfound.finalproject.controllers;

import org.launchcode.fourohfourfound.finalproject.models.Character;
import org.launchcode.fourohfourfound.finalproject.models.CharacterData;
import org.launchcode.fourohfourfound.finalproject.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.launchcode.fourohfourfound.finalproject.controllers.ListController.characteristicChoices;


@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private CharacterRepository characterRepository;

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("characteristics", characteristicChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        Iterable<Character> characters;

        if (searchTerm.toLowerCase().equals("all") || searchTerm.isEmpty()) {
            characters = characterRepository.findAll();
        } else {
            characters = CharacterData.findByCharacteristicAndValue(searchType, searchTerm, characterRepository.findAll());
        }
        model.addAttribute("characteristic", characteristicChoices);
        model.addAttribute("title", "Characters with " + characteristicChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("characters", characters);

        return "search";
    }
}
