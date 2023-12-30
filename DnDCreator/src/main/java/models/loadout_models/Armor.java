package models.loadout_models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import models.AbstractEntity;
import models.Loadout;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Armor extends AbstractEntity {

    public String armor;

    @ManyToMany(mappedBy = "armor_id")
    private List<Loadout> loadouts = new ArrayList<>();

    public Armor() {}

    public Armor (String armor) {
        super();
        this.armor = armor;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }
}
