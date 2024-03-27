import java.util.Map;
import java.util.HashMap;

class Solution {

    private Map<Character, Integer> countCharacters(String text) {
        Map<Character, Integer> characterMap = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            final var ch = text.charAt(i);

            characterMap.put(ch, characterMap.getOrDefault(ch, 0) + 1);
        }

        return characterMap;
    }
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> magazineCharacters = countCharacters(magazine);
        Map<Character, Integer> ransomNoteCharacters = countCharacters(ransomNote);

        for (Character ch : ransomNoteCharacters.keySet()) {

            final var availableCharacters = magazineCharacters.getOrDefault(ch, 0);
            final var neededCharacters = ransomNoteCharacters.getOrDefault(ch, 0);

            if (availableCharacters < neededCharacters) {
                return false;
            }
        }

        return true;
    }
}