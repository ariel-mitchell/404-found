package models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Race extends AbstractEntity{

    @NotBlank(message = "Enter character race!")
    public String race;

    @ManyToMany(mappedBy = "race_id")
    @NotNull
    private List<Character> characters = new ArrayList<>();

    public Race() {}

    public Race (String alignment) {
        super();
        this.race = race;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public List<Character> getCharacters() {
        return characters;
    }
}
