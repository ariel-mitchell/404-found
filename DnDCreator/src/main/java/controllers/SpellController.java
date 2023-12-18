package controllers;

import jakarta.validation.Valid;
import models.Data.SpellRepository;
import models.Spells;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("spells")
public class SpellController {

    @Autowired
    private SpellRepository spellRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("spells", spellRepository.findAll());
        return "spells/index";
    }

    @GetMapping("add")
    public String displayAddSpellForm(Model model) {
        model.addAttribute(new Spells());
        return "spells/add";
    }

    @GetMapping("add")
    public String processAddSpellForm(@ModelAttribute @Valid Spells newSpell, Errors errors, Model model) {
        if(errors.hasErrors()) {
            return "spells/add";
        }
        spellRepository.save(newSpell);
        return "redirect:./";
    }

    @GetMapping("view/{spellId}")
    public String displayViewSpells(Model model, @PathVariable int spellId) {

        Optional<Spells> optionalSpell = spellRepository.findById(spellId);
        if (optionalSpell.isPresent()) {
            Spells spell = optionalSpell.get();
            model.addAttribute("spell", spell);
            return "spells/view";
        } else {
            return "redirect:../";
        }
    }
}
