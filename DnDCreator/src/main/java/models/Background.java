package models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Background extends AbstractEntity{

    @Size(min = 1, max = 500, message = "Enter a background of less than 500 characters.")
    public String background;

    @ManyToMany(mappedBy = "background_id")
    @NotNull
    private List<Character> characters = new ArrayList<>();

    public Background() {}

    @Size(min = 1, max = 500, message = "Enter a background of less than 500 characters.")
    public Background(String background) {
        super();
        this.background = background;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
