class Solution {
    public boolean wordPattern(String pattern, String s) {

        final var words = s.split("\\s+");
        if (words.length != pattern.length()) {
            return false;
        }

        final var patternToWord = new HashMap<Character, String>();
        final var seenWords = new HashSet<String>();

        for (int i = 0; i < words.length; i++) {

            final var currentWord = words[i];
            final var currentPattern = pattern.charAt(i);

            final var existingWordForPattern = patternToWord.get(currentPattern);

            if (existingWordForPattern != null) {
                if (existingWordForPattern.equals(currentWord)) {
                    continue;
                }
                
                return false;
            }

            final var wordWasSeen = !seenWords.add(currentWord);
            
            if (wordWasSeen) {
                return false;
            }

            patternToWord.put(currentPattern, currentWord);

        }

        return true;
    }
}