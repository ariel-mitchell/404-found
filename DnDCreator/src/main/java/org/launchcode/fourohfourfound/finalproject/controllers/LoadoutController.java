package controllers;

import jakarta.validation.Valid;
import org.launchcode.fourohfourfound.finalproject.repositories.LoadoutRepository;
import models.Loadout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Optional;

@Controller
@RequestMapping("loadout")
public class LoadoutController {

    @Autowired
    private LoadoutRepository loadoutRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("loadout", loadoutRepository.findAll());
        return "loadout/index";
    }

    @GetMapping("add")
    public String displayAddLoadoutForm(Model model) {
        model.addAttribute(new Loadout());
        return "loadout/add";
    }

    @PostMapping("add")
    public String processAddLoadoutForm(@ModelAttribute @Valid Loadout newLoadout, Errors errors, Model model) {
        if(errors.hasErrors()) {

            return "loadout/add";
        }
        loadoutRepository.save(newLoadout);
        return "redirect:./";
    }

    @GetMapping("view/{loadoutId}")
    public String displayViewLoadout(Model model, @PathVariable int loadoutId) {
        Optional<Loadout> optionalLoadout = loadoutRepository.findById(loadoutId);

        if (optionalLoadout.isPresent()) {
            Loadout loadout = (Loadout) optionalLoadout.get();
            model.addAttribute("loadout", loadout);
            return "equipment/view";
        } else {
            return "redirect:../";
        }
    }

}
