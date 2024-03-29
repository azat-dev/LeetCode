class Solution {
    public int distributeCandies(int[] candyType) {
        
        final var n = candyType.length / 2;
        final var uniqueTypes = new HashSet<Integer>(n);

        for(int type : candyType) {
            
            if (!uniqueTypes.add(type)) {
                if (uniqueTypes.size() >= n) {
                    break;
                }
            }
        }

        return Math.min(uniqueTypes.size(), n);
    }
}