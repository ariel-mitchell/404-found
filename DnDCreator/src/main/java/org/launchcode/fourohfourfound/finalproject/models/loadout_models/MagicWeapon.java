package models.loadout_models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import models.AbstractEntity;
import models.Loadout;

import java.util.ArrayList;
import java.util.List;

@Entity
public class MagicWeapon extends AbstractEntity {

    @ManyToMany(mappedBy = "magicWeapon_id")
    private List<Loadout> loadouts = new ArrayList<>();

    public MagicWeapon () {
        super();
    }
}
