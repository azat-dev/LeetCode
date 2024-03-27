class Solution {
    public int numIdenticalPairs(int[] nums) {
        
        final var countByNums = new int[101];
        var count = 0;

        for (int value : nums) {
            
            final var currentCount = countByNums[value];
            count += currentCount;
            countByNums[value] = currentCount + 1;
        }

        return count;
    }
}