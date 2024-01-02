package models.loadout_models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import models.AbstractEntity;
import models.Loadout;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Weapon extends AbstractEntity {

    @ManyToMany(mappedBy = "weapon_id")
    private List<Loadout> loadouts = new ArrayList<>();

    public Weapon() {
        super();
    }
}
