package models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Proficiencies extends AbstractEntity{

    @NotBlank(message = "Select two proficiencies!")
    public String proficiency;

    @ManyToMany(mappedBy = "proficiency_id")
    @NotNull
    private List<Character> characters = new ArrayList<>();

    public Proficiencies(){}

    public Proficiencies(String proficiency) {
        super();
        this.proficiency = proficiency;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public List<Character> getCharacters() {
        return characters;
    }
}
