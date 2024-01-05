package backend.models.loadout_models;

import backend.models.AbstractEntity;
import backend.models.Loadout;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

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
