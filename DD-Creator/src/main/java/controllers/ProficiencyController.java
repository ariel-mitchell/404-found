package controllers;

import jakarta.validation.Valid;
import models.Data.ProficiencyRepository;
import models.Proficiencies;
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
@RequestMapping("proficiencies")
public class ProficiencyController {

    @Autowired
    private ProficiencyRepository proficiencyRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("proficiencies", proficiencyRepository.findAll());
        return "proficiencies/index";
    }

    @GetMapping("add")
    public String displayAddProficiencyForm(Model model) {
        model.addAttribute(new Proficiencies());
        return "proficiencies/add";
    }

    @GetMapping("add")
    public String processAddProficiencyForm(@ModelAttribute @Valid Proficiencies newProficiency, Errors errors, Model model) {
        if(errors.hasErrors()) {
            return "proficiencies/add";
        }
        proficiencyRepository.save(newProficiency);
        return "redirect:./";
    }

    @GetMapping("view/{proficienciesId}")
    public String displayViewProficiencies(Model model, @PathVariable int proficienciesId) {

        Optional <Proficiencies> optionalProficiencies = proficiencyRepository.findById(proficienciesId);
        if (optionalProficiencies.isPresent()) {
            Proficiencies proficiency = optionalProficiencies.get();
            model.addAttribute("proficiency", proficiency);
            return "backgrounds/view";
        } else {
            return "redirect:../";
        }
    }
}