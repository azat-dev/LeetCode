class Solution {
    // Time Complexity: O(n) + O(x)
    // Space Complexity: O(26)
    public int firstUniqChar(String s) {
        
        final var map = new LinkedHashMap<Character, Integer>(26);
        
        for (int i = 0; i < s.length(); i++) {
            
            final var ch = s.charAt(i);
            final var existingIndex = map.get(ch);
            
            if (existingIndex == null) {
                map.put(ch, i);
                continue;
            }
            
            if (existingIndex == -1) {
                continue;
            }

            map.put(ch, -1);
        }
        
        for (var value: map.values()) {
            if (value == -1) {
                continue;
            }
            
            return value;
        }
        
        return -1;
    }
}