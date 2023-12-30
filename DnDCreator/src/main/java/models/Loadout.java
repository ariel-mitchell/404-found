package models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Loadout {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToOne
    private String weapon;
    private String magicWeapon;
    private String armor;
    private String magicArmor;
    private String equipment;
    private String treasure;


    @ManyToMany(mappedBy = "loadout_id")
    @NotNull
    private List<Character> characters = new ArrayList<>();

    public Loadout(){}

    public Loadout(String weapon, String magicWeapon, String armor, String magicArmor, String equipment, String treasure) {
        this();
        this.weapon = weapon;
        this.magicWeapon = magicWeapon;
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
                ", weapons='" + weapon + '\'' +
                ", magicWeapons='" + magicWeapon + '\'' +
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
        return id == loadout1.id && Objects.equals(weapon, loadout1.weapon) && Objects.equals(magicWeapon, loadout1.magicWeapon) && Objects.equals(armor, loadout1.armor) && Objects.equals(magicArmor, loadout1.magicArmor) && Objects.equals(equipment, loadout1.equipment) && Objects.equals(treasure, loadout1.treasure) && Objects.equals(characters, loadout1.characters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weapon, magicWeapon, armor, magicArmor, equipment, treasure, characters);
    }

    //Getters and Setters

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

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
