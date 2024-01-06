package backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;


@Component
public class Character extends AbstractEntity{

    @ManyToMany(mappedBy = "characters")
    @Autowired
    private List<Character> characters = new ArrayList<>();

    @NotBlank
    @Autowired
    private String alignment;
    @NotBlank
    @Autowired
    private String classInfo;
    @NotBlank
    @Autowired
    private String race;

    @NotBlank(message = "Enter a custom background")
    @Size(max = 1000)
    @Autowired
    private String background;

    @ManyToOne
    @Autowired
    private Loadout loadout;

    @Size(max = 2, message = "Choose up to 2 proficiencies.")
    @Autowired
    private List<String> proficiencies;

    @Size(max = 2, message = "Choose up to 2 spells.")
    @Autowired
    private List<String> spells;

    public Character() {
    }

    public Character(String alignment, String aBackground, String aClass, String aRace, Loadout loadout, List<String> someProficiencies, List<String> someSpells) {
        super();
        this.alignment = alignment;
        this.background = aBackground;
        this.classInfo = aClass;
        this.race = aRace;
        this.loadout = loadout;
        this.proficiencies = someProficiencies;
        this.spells = someSpells;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Loadout getLoadout() {
        return loadout;
    }

    public void setLoadout(Loadout loadout) {
        this.loadout = loadout;
    }

    public List<String> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(List<String> proficiencies) {
        this.proficiencies = proficiencies;
    }

    public List<String> getSpells() {
        return spells;
    }

    public void setSpells(List<String> spells) {
        this.spells = spells;
    }
}
