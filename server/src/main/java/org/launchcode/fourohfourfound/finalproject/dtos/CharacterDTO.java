package org.launchcode.fourohfourfound.finalproject.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Valid
public class CharacterDTO {

    @NotNull(message = "Owner ID cannot be null")
    private int ownerId;

    @NotNull(message = "Choose a name for your character")
    @Size(min = 3, max = 50, message = "Character name must be between 3 and 50 characters")
    @NotBlank(message = "Choose a name for your character")
    private String characterName;

    @NotBlank(message = "Choose an alignment")
    @Size(min = 3, max = 50, message = "Alignment must be between 3 and 50 characters")
    @NotNull(message = "Choose an alignment")
    private String alignment;

    @NotNull(message = "Choose a class from the list")
    @NotBlank(message = "Choose a class from the list")
    private String characterClass;

    @NotNull(message = "Choose a race")
    @NotBlank
    private String race;

    @NotBlank(message = "Enter a custom background")
    @Size(max = 1000)
    private String background;
    private String proficiencyOne;
    private String proficiencyTwo;
    private String spellOne;
    private String spellTwo;
    private String armorChoice;
    private String magicArmor;
    private String weapon;
    private String magicWeapon;
    private String equipment;
    private String treasure;

    public CharacterDTO( int ownerId,
                        String characterName, String alignment,
                        String characterClass, String race,
                        String background, String proficiencyOne, String proficiencyTwo,
                         String spellOne,String spellTwo,String weapon,
                         String magicWeapon, String armorChoice, String magicArmor,
                         String equipment, String treasure) {

        this.ownerId = ownerId;
        this.characterName = characterName;
        this.alignment = alignment;
        this.characterClass = characterClass;
        this.race = race;
        this.background = background;
        this.proficiencyOne = proficiencyOne;
        this.proficiencyTwo = proficiencyTwo;
        this.spellOne = spellOne;
        this.spellTwo = spellTwo;
        this.weapon = weapon;
        this.magicWeapon = magicWeapon;
        this.armorChoice = armorChoice;
        this.magicArmor = magicArmor;
        this.equipment = equipment;
        this.treasure = treasure;

    }

    public CharacterDTO() {
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
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

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
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
}
