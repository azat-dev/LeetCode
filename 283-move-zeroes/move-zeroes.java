class Solution {
    public void moveZeroes(int[] nums) {
        
        var lastNonZeroValueIndex = -1;
        
        for (int i = 0; i < nums.length; i++) {
            
            final var currentValue = nums[i];
            
            if (currentValue == 0) {
                continue;
            }

            lastNonZeroValueIndex++;
            
            if (lastNonZeroValueIndex == i) {
                continue;
            }
            
            nums[lastNonZeroValueIndex] = currentValue;
            nums[i] = 0;
        }
    }
}