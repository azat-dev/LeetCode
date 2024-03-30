class Solution {
    public boolean isSubsequence(String s, String t) {
        
        var lastPosition = -1;
        var foundCount =0;

        for (int i = 0; i < s.length(); i++) {

            final var ch = s.charAt(i);
            var isCharFound = false;

            for (int j = lastPosition + 1; j < t.length(); j++) {
                
                if (t.charAt(j) == ch) {
                    lastPosition = j;
                    isCharFound = true;
                    break;
                }
            }

            if (!isCharFound) {
                return false;
            }

            foundCount++;
        }

        return foundCount == s.length();
    }
}