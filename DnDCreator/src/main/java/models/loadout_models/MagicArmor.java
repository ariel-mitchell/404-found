package models.loadout_models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import models.AbstractEntity;
import models.Loadout;

import java.util.ArrayList;
import java.util.List;

@Entity
public class MagicArmor extends AbstractEntity {

    public String magicArmor;

    @ManyToMany(mappedBy = "magicArmor_id")
    private List<Loadout> loadouts = new ArrayList<>();

    public MagicArmor() {}

    public MagicArmor (String magicArmor) {
        super();
        this.magicArmor = magicArmor;
    }

    public String getMagicArmor() {
        return magicArmor;
    }

    public void setMagicArmor(String magicArmor) {
        this.magicArmor = magicArmor;
    }
}
