package models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Loadout {

    @Id
    @GeneratedValue
    private int id;

    //functionality without some of the pieces??

    @NotBlank(message = "Select Equipment!")
    private String weapons;
    private String magicWeapons;
    private String armor;
    private String magicArmor;
    private String equipment;
    private String treasure;


    @ManyToMany(mappedBy = "equipment_id")
    @NotNull
    private List<Character> characters = new ArrayList<>();

    public Loadout(){}

    public Loadout(String weapons, String magicWeapons, String armor, String magicArmor, String equipment, String treasure) {
        this();
        this.weapons = weapons;
        this.magicWeapons = magicWeapons;
        this.armor = armor;
        this.magicArmor = magicArmor;
        this.equipment = equipment;
        this.treasure = treasure;
    }

    //toString(), equals, hashCode()
    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", weapons='" + weapons + '\'' +
                ", magicWeapons='" + magicWeapons + '\'' +
                ", armor='" + armor + '\'' +
                ", magicArmor='" + magicArmor + '\'' +
                ", equipment='" + equipment + '\'' +
                ", treasure='" + treasure + '\'' +
                ", characters=" + characters +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loadout loadout1)) return false;
        return id == loadout1.id && Objects.equals(weapons, loadout1.weapons) && Objects.equals(magicWeapons, loadout1.magicWeapons) && Objects.equals(armor, loadout1.armor) && Objects.equals(magicArmor, loadout1.magicArmor) && Objects.equals(equipment, loadout1.equipment) && Objects.equals(treasure, loadout1.treasure) && Objects.equals(characters, loadout1.characters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weapons, magicWeapons, armor, magicArmor, equipment, treasure, characters);
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeapons() {
        return weapons;
    }

    public void setWeapons(String weapons) {
        this.weapons = weapons;
    }

    public String getMagicWeapons() {
        return magicWeapons;
    }

    public void setMagicWeapons(String magicWeapons) {
        this.magicWeapons = magicWeapons;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getMagicArmor() {
        return magicArmor;
    }

    public void setMagicArmor(String magicArmor) {
        this.magicArmor = magicArmor;
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

    public List<Character> getCharacters() {
        return characters;
    }
    //End Getters and Setters
}
