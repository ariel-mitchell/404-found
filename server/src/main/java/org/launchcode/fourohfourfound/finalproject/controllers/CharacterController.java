package org.launchcode.fourohfourfound.finalproject.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.launchcode.fourohfourfound.finalproject.dtos.CharacterDTO;
import org.launchcode.fourohfourfound.finalproject.models.Character;
import org.launchcode.fourohfourfound.finalproject.models.User;
import org.launchcode.fourohfourfound.finalproject.repositories.CharacterRepository;
import org.launchcode.fourohfourfound.finalproject.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api/characters")
public class CharacterController {
    private static final String userSessionKey = "user";
    private final UserRepository userRepository;
    private final CharacterRepository characterRepository;

    public CharacterController(UserRepository userRepository, CharacterRepository characterRepository) {
        this.userRepository = userRepository;
        this.characterRepository = characterRepository;
    }
    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return null;
        }
        return user.get();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Character>> getCharactersByUserId(@PathVariable int userId, HttpSession session) {
        Optional<User> user = userRepository.findById(userId);
        User owner = getUserFromSession(session);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (owner == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        List<Character> characters = characterRepository.findByOwner(owner);
        if (characters.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(characters);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createCharacter(@Valid @RequestBody CharacterDTO characterDTO, Errors errors,
                                             HttpSession session) {
        if (errors.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        User owner = getUserFromSession(session);
        if (owner == null) {
            return new ResponseEntity<String>("You must be logged in to create a character", HttpStatus.UNAUTHORIZED);
        }
//        User owner, String characterName,String alignment, String aBackground,String armorChoice,
//                String magicArmor, String weapon, String magicWeapon, String equipment, String treasure,
//                String aClass, String aRace, String proficiencyOne, String proficiencyTwo,
//                String spellOne, String spellTwo

        Character character = new Character(owner, characterDTO.getCharacterName(), characterDTO.getAlignment(),
                characterDTO.getBackground(), characterDTO.getArmorChoice(), characterDTO.getMagicArmor(),
                characterDTO.getWeapon(), characterDTO.getMagicWeapon(), characterDTO.getEquipment(),
                characterDTO.getTreasure(), characterDTO.getCharacterClass(), characterDTO.getRace(),
                characterDTO.getProficiencyOne(), characterDTO.getProficiencyTwo(), characterDTO.getSpellOne(),
                characterDTO.getSpellTwo());
        try {
            characterRepository.save(character);
            return new ResponseEntity<>(character, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Integer id, @RequestBody Character updatedCharacter) {
        Optional<Character> optionalCharacter = characterRepository.findById(id);

        if (!optionalCharacter.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Character character = optionalCharacter.get();
        character.setCharacterName((updatedCharacter.getCharacterName()));
        character.setRace((updatedCharacter.getRace()));
        character.setAlignment((updatedCharacter.getAlignment()));
        character.setBackground((updatedCharacter.getBackground()));
        character.setArmorChoice(updatedCharacter.getArmorChoice());
        character.setMagicArmor(updatedCharacter.getMagicArmor());
        character.setWeapon(updatedCharacter.getWeapon());
        character.setMagicWeapon(updatedCharacter.getMagicWeapon());
        character.setProficiencyOne(updatedCharacter.getProficiencyOne());
        character.setProficiencyTwo(updatedCharacter.getProficiencyTwo());
        character.setSpellOne(updatedCharacter.getSpellOne());
        character.setSpellTwo(updatedCharacter.getSpellTwo());
        character.setEquipment(updatedCharacter.getEquipment());
        character.setTreasure(updatedCharacter.getTreasure());
        character.setCharacterClass(updatedCharacter.getCharacterClass());

        characterRepository.save(character);

        return new ResponseEntity<>(character, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCharacter(@PathVariable Integer id) {
        Optional<Character> optionalCharacter = characterRepository.findById(id);

        if (!optionalCharacter.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        characterRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}