class Solution {
    public int[] sortArrayByParity(int[] nums) {
     
        int lastEvenValueIndex = -1;
        
        for (int i = 0; i < nums.length; i++) {
            
            final var currentValue = nums[i];
            final var isEven = currentValue % 2 == 0;
            
            if (!isEven) {
                continue;
            }
            
            lastEvenValueIndex++;
            
            // Swapping values
            nums[i] = nums[lastEvenValueIndex];
            nums[lastEvenValueIndex] = currentValue;
        }
        
        return nums;
    }
}