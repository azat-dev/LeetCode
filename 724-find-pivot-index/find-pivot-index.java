class Solution {
    public int pivotIndex(int[] nums) {
        
        var total = 0;
        
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        
        var leftSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            final var val = nums[i];
            final var rightSum = total - val - leftSum;
            
            if (leftSum == rightSum) {
                return i;
            }
            
            leftSum += val;
        }
        
        return -1;
    }
}