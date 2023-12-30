package models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;


@Entity
public class Character{

    private int id;
    private String name;

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

    public Character(String name, Alignment anAlignment, Background aBackground, ClassInfo aClass, Race aRace, List<Loadout> someLoadout, List<Proficiencies> someProficiencies, List<Spells> someSpells) {
        this.name = name;
        this.alignment = anAlignment;
        this.background = aBackground;
        this.classInfo = aClass;
        this.race = aRace;
        this.loadouts = someLoadout;
        this.proficiencies = someProficiencies;
        this.spells = someSpells;
    }


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public List<Loadout> getLoadout() {
        return loadouts;
    }

    public void setLoadout(List<Loadout> loadouts) {
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

    // to string and hashcode


    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alignment=" + alignment +
                ", background=" + background +
                ", classInfo=" + classInfo +
                ", race=" + race +
                ", loadouts=" + loadouts +
                ", proficiencies=" + proficiencies +
                ", spells=" + spells +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character character)) return false;
        return id == character.id && Objects.equals(name, character.name) && Objects.equals(alignment, character.alignment) && Objects.equals(background, character.background) && Objects.equals(classInfo, character.classInfo) && Objects.equals(race, character.race) && Objects.equals(loadouts, character.loadouts) && Objects.equals(proficiencies, character.proficiencies) && Objects.equals(spells, character.spells);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, alignment, background, classInfo, race, loadouts, proficiencies, spells);
    }
}
