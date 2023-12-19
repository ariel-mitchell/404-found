package controllers;

import jakarta.validation.Valid;
import models.Background;
import models.Data.BackgroundRepository;
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
@RequestMapping("backgrounds")
public class BackgroundController {

    @Autowired
    private BackgroundRepository backgroundRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("backgrounds", backgroundRepository.findAll());
        return "backgrounds/index";
    }

    @GetMapping("add")
    public String displayAddBackgroundForm(Model model) {
        model.addAttribute(new Background());
        return "backgrounds/add";
    }

    @GetMapping("add")
    public String processAddBackgroundForm(@ModelAttribute @Valid Background newBackground, Errors errors, Model model) {
        if(errors.hasErrors()) {
            return "backgrounds/add";
        }
        backgroundRepository.save(newBackground);
        return "redirect:./";
    }

    @GetMapping("view/{backgroundId}")
    public String displayViewBackground(Model model, @PathVariable int backgroundId) {

        Optional <Background> optionalBackground = backgroundRepository.findById(backgroundId);
        if (optionalBackground.isPresent()) {
            Background background = optionalBackground.get();
            model.addAttribute("background", background);
            return "backgrounds/view";
        } else {
            return "redirect:../";
        }
    }
}
