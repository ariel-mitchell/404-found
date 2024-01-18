package org.launchcode.fourohfourfound.finalproject.dto;

import java.util.List;

public record CharacterDTO(int id, UserDTO owner, String characterName, String alignment,
                           String characterClass, String race, String background, List<String> loadout,
                           List<String> proficiencies, List<String> spells){}
