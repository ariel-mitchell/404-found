package org.launchcode.fourohfourfound.finalproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import org.launchcode.fourohfourfound.finalproject.models.loadout_models.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Loadout extends AbstractEntity{

    @ManyToOne
    private Weapon weapon;
    private MagicWeapon magicWeapon;
    private Armor armor;
    private MagicArmor magicArmor;
    private Equipment equipment;
    private Treasure treasure;


    @ManyToMany(mappedBy = "loadout_id")
    @NotNull
    private List<Character> characters = new ArrayList<>();

    public Loadout(){}

    public Loadout(Weapon weapon, MagicWeapon magicWeapon, Armor armor, MagicArmor magicArmor, Equipment equipment, Treasure treasure) {
        this();
        this.weapon = weapon;
        this.magicWeapon = magicWeapon;
        this.armor = armor;
        this.magicArmor = magicArmor;
        this.equipment = equipment;
        this.treasure = treasure;
    }

    //Getters and Setters


    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public MagicWeapon getMagicWeapon() {
        return magicWeapon;
    }

    public void setMagicWeapon(MagicWeapon magicWeapon) {
        this.magicWeapon = magicWeapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public MagicArmor getMagicArmor() {
        return magicArmor;
    }

    public void setMagicArmor(MagicArmor magicArmor) {
        this.magicArmor = magicArmor;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
