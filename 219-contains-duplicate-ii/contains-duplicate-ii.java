class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        for (int i = 0; i < nums.length; i++) {
            
            final var val1 = nums[i];
            
            for (int j = i + 1; j < nums.length && j - i <= k; j++) {
                
                final var val2 = nums[j];
                
                if (val1 == val2) {
                    return true;
                }
            }
        }
        
        return false;
    }
}