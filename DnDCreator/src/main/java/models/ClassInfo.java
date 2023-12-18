package models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ClassInfo extends AbstractEntity{

    @NotBlank(message = "Select a class!")
    public String classInfo;

    @ManyToMany(mappedBy = "class_id")
    @NotNull
    private List<Character> characters = new ArrayList<>();

    public ClassInfo(){}

    public ClassInfo(String classInfo) {
        super();
        this.classInfo = classInfo;
    }

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

    public List<Character> getCharacters() {
        return characters;
    }
}
