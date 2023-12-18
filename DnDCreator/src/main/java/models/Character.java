package models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;


@Entity
public class Character extends AbstractEntity {

    @ManyToOne
    private Alignment alignment;
    private Background background;
    private ClassInfo classInfo;
    private Race race;

    @ManyToMany
    @NotNull(message = "Select all equipment")
    private List<Loadout> loadouts;

    @ManyToMany
    @NotNull(message = "Select two proficiencies!")
    @Size(min = 2, max = 2)
    private List<Proficiencies> proficiencies;

    @ManyToMany
    @Size(max = 2)
    private List<Spells> spells;

    public Character() {
    }

    public Character(Alignment anAlignment, Background aBackground, ClassInfo aClass, Race aRace, List<Loadout> someLoadout, List<Proficiencies> someProficiencies, List<Spells> someSpells) {
        super();
        this.alignment = anAlignment;
        this.background = aBackground;
        this.classInfo = aClass;
        this.race = aRace;
        this.loadouts = someLoadout;
        this.proficiencies = someProficiencies;
        this.spells = someSpells;
    }

    // Getters and Setters


    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public List<Loadout> getEquipment() {
        return loadouts;
    }

    public void setEquipment(List<Loadout> loadouts) {
        this.loadouts = loadouts;
    }

    public List<Proficiencies> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(List<Proficiencies> proficiencies) {
        this.proficiencies = proficiencies;
    }

    public List<Spells> getSpells() {
        return spells;
    }

    public void setSpells(List<Spells> spells) {
        this.spells = spells;
    }
}
