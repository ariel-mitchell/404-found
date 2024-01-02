package models.loadout_models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import models.AbstractEntity;
import models.Loadout;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Treasure extends AbstractEntity {

    @ManyToMany(mappedBy = "treasure_id")
    private List<Loadout> loadouts = new ArrayList<>();

    public Treasure() {
        super();
    }
}
