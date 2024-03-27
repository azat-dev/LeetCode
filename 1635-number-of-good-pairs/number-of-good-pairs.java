class Solution {
    public int numIdenticalPairs(int[] nums) {
        
        final var countByNums = new HashMap<Integer, Integer>();
        var count = 0;

        for (int i = 0; i < nums.length; i++) {
            
            final var value = nums[i];
            final var currentCount = countByNums.getOrDefault(value, 0);

            count += currentCount;
            countByNums.put(value, currentCount + 1);
        }

        return count;
    }
}