class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        final var indexesByNums = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            
            final var currentValue = nums[i];
            final var additionalValue = target - currentValue;
            final var additionalValueIndex = indexesByNums.get(additionalValue);
            
            if (additionalValueIndex != null) {
                return new int[] { i, additionalValueIndex };
            }
            
            indexesByNums.put(currentValue, i);
        }
        
        return new int[0];
    }
}