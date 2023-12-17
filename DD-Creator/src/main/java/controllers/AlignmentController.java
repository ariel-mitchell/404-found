package controllers;

import models.Alignment;
import models.Data.AlignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("alignments")
public class AlignmentController {

    @Autowired
    private AlignmentRepository alignmentRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "All Alignments");
        List<Alignment> alignments = (List<Alignment>) alignmentRepository.findAll();
        model.addAttribute("alignments", alignments);
        return "alignments/index";
    }

    @GetMapping("view/{alignmentId}")
    public String displayViewAlignment(Model model, @PathVariable int alignmentId) {
        Optional<Alignment> optionalAlignment = alignmentRepository.findById(alignmentId);

        if(optionalAlignment.isPresent()) {
            Alignment alignment = (Alignment) optionalAlignment.get();
            model.addAttribute("alignment", alignment);
            return "alignment/view";
        } else {
            return "redirect:../";
        }
    }
}
