class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        final var jewelsSet = new HashSet<Character>();
        
        for (int i = 0; i < jewels.length(); i++) {
            jewelsSet.add(jewels.charAt(i));
        }
        
        int count = 0;
        
        for (int i = 0; i < stones.length(); i++) {
            if (jewelsSet.contains(stones.charAt(i))) {
                count++;
            }
        }
        
        return count;
    }
}