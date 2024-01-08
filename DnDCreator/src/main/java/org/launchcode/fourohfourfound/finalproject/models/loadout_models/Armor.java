package org.launchcode.fourohfourfound.finalproject.models.loadout_models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import org.launchcode.fourohfourfound.finalproject.models.AbstractEntity;
import org.launchcode.fourohfourfound.finalproject.models.Loadout;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Armor extends AbstractEntity {

    @ManyToMany(mappedBy = "armor_id")
    private List<Loadout> loadouts = new ArrayList<>();

    public Armor () {
        super();
    }
}
