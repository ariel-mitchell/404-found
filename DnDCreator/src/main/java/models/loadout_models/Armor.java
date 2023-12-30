package models.loadout_models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import models.AbstractEntity;

@Entity
public class Armor extends AbstractEntity {

    public String armor;

    @ManyToOne(mappedBy = "weapon_id")
    private List<String>
}
