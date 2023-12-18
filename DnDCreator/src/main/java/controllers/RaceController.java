package controllers;

import models.Race;
import models.Data.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("races")
public class RaceController {

    @Autowired
    private RaceRepository raceRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "All Races");
        List<Race> races = (List<Race>) raceRepository.findAll();
        model.addAttribute("races", races);
        return "races/index";
    }

    @GetMapping("view/{raceId}")
    public String displayViewRace(Model model, @PathVariable int raceId) {
        Optional<Race> optionalRace = raceRepository.findById(raceId);

        if(optionalRace.isPresent()) {
            Race race = (Race) optionalRace.get();
            model.addAttribute("race", race);
            return "race/view";
        } else {
            return "redirect:../";
        }
    }
}

