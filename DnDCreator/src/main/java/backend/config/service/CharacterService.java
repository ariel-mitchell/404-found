package backend.config.service;

import backend.models.*;
import backend.models.Character;
import backend.models.Data.CharacterRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableJpaRepositories(basePackages = {"backend.models.data"})
public class CharacterService implements ICharacterService {

    private final CharacterRepository characterRepository;


    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<Character> findAll() {

        return (List<Character>) characterRepository.findAll();
    }
}