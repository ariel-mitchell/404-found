package controllers;

import models.ClassInfo;
import models.Data.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("classes")
public class ClassController {

    @Autowired
    private ClassRepository classRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "All Classes");
        List<ClassInfo> classes = (List<ClassInfo>) classRepository.findAll();
        model.addAttribute("classes", classes);
        return "classes/index";
    }

    @GetMapping("view/{classId}")
    public String displayViewClassInfo(Model model, @PathVariable int classId) {

        Optional<ClassInfo> optionalClassInfo = classRepository.findById(classId);
        if (optionalClassInfo.isPresent()) {
            ClassInfo classInfo = (ClassInfo) optionalClassInfo.get();
            model.addAttribute("classInfo", classInfo);
            return "classes/view";
        } else {
            return "redirect:../";
        }
    }
}
