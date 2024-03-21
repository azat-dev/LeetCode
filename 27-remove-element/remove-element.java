class Solution {
    public int removeElement(int[] nums, int val) {
        
        var lastNotEqualValue = -1;
        var numberOfValues = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            final var currentValue = nums[i];
            
            if (currentValue == val) {
                continue;
            }
            
            // Move the value
            lastNotEqualValue++;
            nums[lastNotEqualValue] = nums[i];
            numberOfValues++;
        }
        
        return numberOfValues;
    }
}