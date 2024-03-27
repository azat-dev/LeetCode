class Solution {
    // Time Complexity: O(n) + O(x)
    // Space Complexity: O(26)
    public int firstUniqChar(String s) {
        
        var minIndex = -1;
        
        for (char ch = 'a'; ch <= 'z'; ch++) {
            
            final var firstIndex = s.indexOf(ch);
            if (firstIndex == -1) {
                continue;
            }

            final var lastIndex = s.lastIndexOf(ch);
            if (lastIndex != firstIndex ) {
                continue;
            }

            if (minIndex == -1 || firstIndex < minIndex) {
                minIndex = firstIndex;
            }

            if (minIndex == 0) {
                return 0;
            }
        }
        
        return minIndex;
    }
}