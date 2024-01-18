package org.launchcode.fourohfourfound.finalproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.launchcode.fourohfourfound.finalproject.models.User;
import java.util.List;


@Entity
@Table(name = "characters")
public class Character extends AbstractIdentifiableModel{
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    private String characterName;
    private String alignment;
    private String characterClass;
    private String race;
    private String background;
    private String armorChoice;
    private String magicArmor;
    private String weapon;
    private String magicWeapon;
    private String equipment;
    private String treasure;
    private String proficiencyOne;
    private String proficiencyTwo;
    private String spellOne;
    private String spellTwo;

    public Character() {
    }

    public Character(User owner, String characterName,String alignment, String aBackground,String armorChoice,
                     String magicArmor, String weapon, String magicWeapon, String equipment, String treasure,
                     String aClass, String aRace, String proficiencyOne, String proficiencyTwo,
                     String spellOne, String spellTwo) {
        super();
        this.owner = owner;
        this.characterName = characterName;
        this.alignment = alignment;
        this.background = aBackground;
        this.armorChoice = armorChoice;
        this.magicArmor = magicArmor;
        this.weapon = weapon;
        this.magicWeapon = magicWeapon;
        this.equipment = equipment;
        this.treasure = treasure;
        this.characterClass = aClass;
        this.race = aRace;
        this.proficiencyOne = proficiencyOne;
        this.proficiencyTwo = proficiencyTwo;
        this.spellOne = spellOne;
        this.spellTwo = spellTwo;
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

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String classInfo) {
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

    public String getArmorChoice() {
        return armorChoice;
    }

    public void setArmorChoice(String armorChoice) {
        this.armorChoice = armorChoice;
    }

    public String getMagicArmor() {
        return magicArmor;
    }

    public void setMagicArmor(String magicArmor) {
        this.magicArmor = magicArmor;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getMagicWeapon() {
        return magicWeapon;
    }

    public void setMagicWeapon(String magicWeapon) {
        this.magicWeapon = magicWeapon;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getTreasure() {
        return treasure;
    }

    public void setTreasure(String treasure) {
        this.treasure = treasure;
    }

    public String getProficiencyOne() {
        return proficiencyOne;
    }

    public void setProficiencyOne(String proficiencyOne) {
        this.proficiencyOne = proficiencyOne;
    }

    public String getProficiencyTwo() {
        return proficiencyTwo;
    }

    public void setProficiencyTwo(String proficiencyTwo) {
        this.proficiencyTwo = proficiencyTwo;
    }

    public String getSpellOne() {
        return spellOne;
    }

    public void setSpellOne(String spellOne) {
        this.spellOne = spellOne;
    }

    public String getSpellTwo() {
        return spellTwo;
    }

    public void setSpellTwo(String spellTwo) {
        this.spellTwo = spellTwo;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
