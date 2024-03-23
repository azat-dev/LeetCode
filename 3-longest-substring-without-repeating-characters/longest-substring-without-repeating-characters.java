class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        var maxSubstringStartIndex = -1;
        var maxSubstringLength = 0;
        var substringStartIndex = -1;
        var substringLength = 0;

        final var indexesByChars = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {

            final var ch = s.charAt(i);
            final var prevMetAt = indexesByChars.get(ch);

            if (prevMetAt != null) {

                if (prevMetAt < substringStartIndex) {
                    substringStartIndex = i;
                    substringLength = 1;
                    indexesByChars.clear();
                } else {
                    substringStartIndex = prevMetAt + 1;
                    substringLength = i - substringStartIndex + 1;

                    final var iterator = indexesByChars.entrySet().iterator();

                    while(iterator.hasNext()) {
                        
                        final var entry = iterator.next();
                        if (entry.getValue() < substringStartIndex) {
                            iterator.remove();
                        }
                    }
                }

            } else {

                if (substringStartIndex == -1) {
                    substringStartIndex = i;
                    substringLength = 0;
                }
                
                substringLength++;
            }

            // Update max substring if needed
            if (maxSubstringLength < substringLength) {
                maxSubstringStartIndex = substringStartIndex;
                maxSubstringLength = substringLength;
            }

            indexesByChars.put(ch, i);
        }

        return maxSubstringLength;
    }
}