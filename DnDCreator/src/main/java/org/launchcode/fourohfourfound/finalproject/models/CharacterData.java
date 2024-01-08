package org.launchcode.fourohfourfound.finalproject.models;

import java.util.ArrayList;

public class CharacterData {

    /**
     * Allows Users to search through their Character data by field and search term
     *
     * @param characteristic Character field searched for.
     * @param value          value of the field to search for.
     * @param allCharacters  list of all User's characters.
     * @return List all Characters with matching criteria.
     */

    public static ArrayList<Character> findByCharacteristicAndValue(String characteristic, String value, Iterable<Character> allCharacters) {

        ArrayList<Character> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")) {
            return (ArrayList<Character>) allCharacters;
        }

        if (characteristic.equals("all")) {
            results = findByValue(value, allCharacters);
        }

        for (Character character : allCharacters) {

            String aValue = getFieldValue(character, characteristic);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(character);
            }
        }

        return results;

    }

    public static String getFieldValue(Character character, String fieldName) {

        String theValue = null;

        if (fieldName.equals("name")) {
            theValue = character.getName();
        } else if (fieldName.equals("alignment")) {
            theValue = character.getAlignment().toString();
        } else if (fieldName.equals("background")) {
            theValue = character.getBackground().toString();
        } else if (fieldName.equals("classInfo")) {
            theValue = character.getClassInfo().toString();
        } else if (fieldName.equals("equipment")) {
            theValue = character.getLoadout().toString();
        } else if (fieldName.equals("proficiencies")) {
            theValue = character.getProficiencies().toString();
        } else if (fieldName.equals("race")) {
            theValue = character.getRace().toString();
        } else if (fieldName.equals("spells")) {
            theValue = character.getSpells().toString();
        }
        return theValue;
    }

    /**
     * Search all Job fields for the given term.
     *
     * @param value The search term to look for.
     * @param allCharacters The list of characters to search.
     * @return      List of all characters with at least one field containing the value.
     */
    public static ArrayList<Character> findByValue(String value, Iterable<Character> allCharacters) {

        ArrayList<Character> results = new ArrayList<>();

        for (Character character : allCharacters) {

            if(character.getName().toLowerCase().contains(value.toLowerCase())) {
                results.add(character);
            } else if(character.getAlignment().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(character);
            } else if(character.getBackground().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(character);
            } else if(character.getClassInfo().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(character);
            } else if(character.getLoadout().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(character);
            } else if(character.getProficiencies().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(character);
            } else if(character.getRace().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(character);
            } else if(character.getSpells().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(character);
            }
        }

        return results;
    }
}