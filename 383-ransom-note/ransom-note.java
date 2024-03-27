import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;

class Solution {

    private Map<Character, Long> countCharacters(String text) {
        return text.chars()
            .mapToObj(ch -> (char) ch)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Long> magazineCharacters = countCharacters(magazine);
        Map<Character, Long> ransomNoteCharacters = countCharacters(ransomNote);

        return ransomNoteCharacters.entrySet().stream()
            .allMatch(entry -> {
                final var availableCharacters = magazineCharacters.getOrDefault(entry.getKey(), 0L);
                return availableCharacters >= entry.getValue();
            });
    }
}