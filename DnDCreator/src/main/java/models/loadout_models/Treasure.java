package models.loadout_models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import models.AbstractEntity;
import models.Loadout;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Treasure extends AbstractEntity {

    public String treasure;

    @ManyToMany(mappedBy = "treasure_id")
    private List<Loadout> loadouts = new ArrayList<>();

    public Treasure() {}

    public Treasure(String treasure) {
        super();
        this.treasure = treasure;
    }

    public String getTreasure() {
        return treasure;
    }

    public void setTreasure(String treasure) {
        this.treasure = treasure;
    }
}
