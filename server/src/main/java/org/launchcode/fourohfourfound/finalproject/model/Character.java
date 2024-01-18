package org.launchcode.fourohfourfound.finalproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;


import java.util.List;


@Entity
@Table(name = "characters")
public class Character extends AbstractIdentifiableModel{
    @ManyToOne
    @NotNull(message = "You must be logged in to create a character")
    private User owner;
    @NotNull(message = "Choose a name for your character")
    @Size(min = 3, max = 50, message = "Character name must be between 3 and 50 characters")
    private String characterName;

    @NotNull(message = "Choose an alignment from the list")
    private String alignment;


    @NotNull(message = "Choose a class from the list")
    private String characterClass;


    @NotNull(message = "Choose a race")
    private String race;


    @NotBlank(message = "Enter a custom background")
    @Size(max = 1000)
    private String background;


    private List<String> loadout;


    @Size(max = 2, message = "Choose up to 2 proficiencies.")
    private List<String> proficiencies;


    @Size(max = 2, message = "Choose up to 2 spells.")
    private List<String> spells;

    public Character() {
    }

    public Character(String alignment, String aBackground, String aClass,
                     String aRace, List<String> someProficiencies,
                     List<String> someSpells, List<String> someLoadout) {
        super();
        this.alignment = alignment;
        this.background = aBackground;
        this.characterClass = aClass;
        this.race = aRace;
        this.proficiencies = someProficiencies;
        this.spells = someSpells;
        this.loadout = someLoadout;
    }

    public int getId() {
        return super.getId();
    }
    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getClassInfo() {
        return characterClass;
    }

    public void setClassInfo(String classInfo) {
        this.characterClass = classInfo;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<String> getLoadout() {
        return loadout;
    }

    public void setLoadout(List<String> loadout) {
        this.loadout = loadout;
    }
}
