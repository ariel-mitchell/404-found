package models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Spells extends AbstractEntity{

    @NotBlank
    public String spell;

    @ManyToMany(mappedBy = "spell_id")
    //???? functionality without an input?
    @NotNull
    private List<Character> characters = new ArrayList<>();

    public Spells(){}

    public Spells(String spell) {
        super();
        this.spell = spell;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell1) {
        this.spell = spell;
    }

    public List<Character> getCharacters() {
        return characters;
    }
}
