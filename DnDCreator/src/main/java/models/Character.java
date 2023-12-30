package models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Objects;


@Entity
public class Character{

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToOne
    private String alignment;
    private String background;
    private String classInfo;
    private String race;

    @ManyToMany
    @NotNull(message = "Select all equipment")
    private Loadout loadout;

    @ManyToMany
    private List<String> proficiencies;

    @ManyToMany
    private List<String> spells;

    public Character() {
    }

    public Character(String name, String anAlignment, String aBackground, String aClass, String aRace, Loadout loadout, List<String> someProficiencies, List<String> someSpells) {
        this.name = name;
        this.alignment = anAlignment;
        this.background = aBackground;
        this.classInfo = aClass;
        this.race = aRace;
        this.loadout = loadout;
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

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
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

    public Loadout getLoadout() {
        return loadout;
    }

    public void setLoadout(Loadout loadout) {
        this.loadout = loadout;
    }

    public List<String> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(String proficiencies) {
        this.proficiencies = Collections.singletonList(proficiencies);
    }

    public String getSpells() {
        return spells.toString();
    }

    public void setSpells(String spells) {
        this.spells = Collections.singletonList(spells);
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
                ", loadout=" + loadout +
                ", proficiencies=" + proficiencies +
                ", spells=" + spells +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character character)) return false;
        return id == character.id && Objects.equals(name, character.name) && Objects.equals(alignment, character.alignment) && Objects.equals(background, character.background) && Objects.equals(classInfo, character.classInfo) && Objects.equals(race, character.race) && Objects.equals(loadout, character.loadout) && Objects.equals(proficiencies, character.proficiencies) && Objects.equals(spells, character.spells);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, alignment, background, classInfo, race, loadout, proficiencies, spells);
    }
}
