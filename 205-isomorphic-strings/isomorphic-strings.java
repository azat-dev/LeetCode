class Solution {
    
    // Time Complexity: O(n)
    // Space Complexity: O(26 * 2) * 2
    public boolean isIsomorphic(String a, String b) {
        
        final var numberOfCharactersWithCase = 26 * 2;
        
        final var aToB = new HashMap<Character, Character>(numberOfCharactersWithCase);
        final var bToA = new HashMap<Character, Character>(numberOfCharactersWithCase);
        
        // O(n)
        for(int i = 0; i < a.length(); i++) {
            
            final var charA = a.charAt(i);
            final var charB = b.charAt(i);
            
            // O(1)
            final var mappedBChar = aToB.get(charA);
            final var mappedAChar = bToA.get(charB);
            
            if (mappedBChar == null && mappedAChar == null) {
                aToB.put(charA, charB);
                bToA.put(charB, charA);
                continue;
            }
            
            final var isOnlyOneDirectionMapping = (mappedBChar == null || mappedAChar == null);
            
            if (isOnlyOneDirectionMapping) {
                return false;
            }
            

            if (mappedBChar == charB && mappedAChar == charA) {
                continue;
            }
            
            return false;
        }
        
        return true;
    }
}