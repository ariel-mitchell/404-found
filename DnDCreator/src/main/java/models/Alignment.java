package models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Alignment extends AbstractEntity{

    @NotBlank(message = "Enter character alignment!")
    public String alignment;

    @ManyToMany(mappedBy = "alignment_id")
    @NotNull
    private List<Character> characters = new ArrayList<>();


    public Alignment() {}

    public Alignment (String alignment) {
        super();
        this.alignment = alignment;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public List<Character> getCharacters() {
        return characters;
    }
}
