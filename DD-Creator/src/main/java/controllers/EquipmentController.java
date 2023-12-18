package controllers;

import jakarta.validation.Valid;
import models.Data.EquipmentRepository;
import models.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Optional;

@Controller
@RequestMapping("equipment")
public class EquipmentController {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("equipment", equipmentRepository.findAll());
        return "equipment/index";
    }

    @GetMapping("add")
    public String displayAddEquipmentForm(Model model) {
        model.addAttribute(new Equipment());
        return "equipment/add";
    }

    @PostMapping("add")
    public String processAddEquipmentForm(@ModelAttribute @Valid Equipment newEquipment, Errors errors, Model model) {
        if(errors.hasErrors()) {

            return "equipment/add";
        }
        equipmentRepository.save(newEquipment);
        return "redirect:./";
    }

    @GetMapping("view/{equipmentId}")
    public String displayViewEquipment(Model model, @PathVariable int equipmentId) {
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(equipmentId);

        if (optionalEquipment.isPresent()) {
            Equipment equipment = (Equipment) optionalEquipment.get();
            model.addAttribute("equipment", equipment);
            return "equipment/view";
        } else {
            return "redirect:../";
        }
    }

}
