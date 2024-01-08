package models.loadout_models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import models.AbstractEntity;
import models.Loadout;

import java.util.ArrayList;
import java.util.List;

@Entity
public class MagicArmor extends AbstractEntity {

    @ManyToMany(mappedBy = "magicArmor_id")
    private List<Loadout> loadouts = new ArrayList<>();

    public MagicArmor () {
        super();
    }
}
