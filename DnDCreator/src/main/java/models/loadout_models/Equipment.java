package models.loadout_models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import models.AbstractEntity;
import models.Loadout;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipment extends AbstractEntity {

    public String equipment;

    @ManyToMany(mappedBy = "equipment_id")
    private List<Loadout> loadouts = new ArrayList<>();

    public Equipment() {}

    public Equipment (String equipment) {
        super();
        this.equipment = equipment;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}
