package backend.config.service;

import backend.models.Character;

import java.util.List;


public interface ICharacterService {
    List<Character> findAll();
}
